/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.utils;

/**
 *
 * @author ggauto
 */
import java.text.SimpleDateFormat;
import java.util.Properties;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;

public class UtilLogger {

    public static Logger logger = Logger.getLogger("log");
    public static boolean configured = false;

    public static void configurar() {

        Properties log4jProperties = new Properties();
        log4jProperties.setProperty("log4j.rootLogger", "ERROR, mitvlogs");
        log4jProperties.setProperty("log4j.rootLogger", "INFO, mitvlogs");
        log4jProperties.setProperty("log4j.rootLogger", "DEBUG, mitvlogs");
        log4jProperties.setProperty("log4j.rootLogger", "WARNING, mitvlogs");
        log4jProperties.setProperty("log4j.appender.mitvlogs", "org.apache.log4j.DailyRollingFileAppender");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        log4jProperties.setProperty("log4j.appender.mitvlogs.File", System.getProperty("user.home") + "/logs/sgotfs.log");
        log4jProperties.setProperty("log4j.appender.mitvlogs.DatePattern", ".yyyy-MM-dd");
        log4jProperties.setProperty("log4j.appender.mitvlogs.layout", "org.apache.log4j.PatternLayout");
        log4jProperties.setProperty("log4j.appender.mitvlogs.layout.ConversionPattern", "%d|%-5p|%m%n");
        log4jProperties.setProperty("log4j.appender.mitvlogs.rollingFile.File", "%d{yyyy-MM-dd}_logs.log.gz");
        log4jProperties.setProperty("log4j.appender.mitvlogs.rollingFile.MaxFileSize", "2MB");

        PropertyConfigurator.configure(log4jProperties);

        logger.debug("debug message");
        logger.info(" Inicio de actividades en log");
        configured = true;

    }

    public static void info(String log) {
        log(log);
    }

    public static void log(String log) {
        if (!configured) {
            configurar();
        }
        logger.info("INF |" + log);
        System.out.println("INF |" + log);

    }

    public static void error(String log) {
        if (!configured) {
            configurar();
        }
        logger.error("ERROR |" + log);
        System.out.println("ERROR |" + log);

    }

    public static void error(String log, Exception ex) {
        if (!configured) {
            configurar();
        }
        String errorMsg = "";
        if (ex instanceof NullPointerException) {
            NullPointerException n = (NullPointerException) ex;
            StackTraceElement stackTrace = n.getStackTrace()[0];
            errorMsg = ex.getMessage() + "Exception at Class:" + stackTrace.getClassName() + " method:" + stackTrace.getMethodName() + " line:" + stackTrace.getLineNumber();
        } else {
            errorMsg = ex.toString();
        }
        logger.error("ERROR |" + log + " " + errorMsg);
        System.out.println("ERROR |" + log + " " + ex.getMessage() + " causa:" + ex.getCause() + errorMsg);

    }
}
