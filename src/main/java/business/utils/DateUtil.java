package business.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class DateUtil {

    final long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día

    public static Date dateFormater(String fecha, String formato) {
        //SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        SimpleDateFormat formatter = new SimpleDateFormat(formato);
        String dateInString = fecha;

        try {

            Date date = formatter.parse(dateInString);
            //System.out.println(date);
            //System.out.println(formatter.format(date));
            return date;

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            return null;
        }

    }

    public static Date getDateFromHourWDate(String hora, String minuto, Date fecha) {
        return getDateFromHourWDate(hora, minuto, "00", fecha);
    }

    public static Date getDateFromHourWDate(String hora, String minuto, String segundo, Date fecha) {

        if (Integer.parseInt(hora) < 10) {
            hora = "0" + hora;
        }
        if (Integer.parseInt(minuto) < 10) {
            minuto = "0" + minuto;
        }

        String horaCompleta = hora + ":" + minuto + ":" + segundo;
        return dateFormater(getCurrentDateWDate(fecha) + " " + horaCompleta, "yyyy/MM/dd HH:mm:ss");
    }

    public static String getCurrentDateWDate(Date fechaW) {
        Calendar now = Calendar.getInstance();
        now.setTime(fechaW);
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1; // Note: zero based!
        int day = now.get(Calendar.DAY_OF_MONTH);
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);
        int millis = now.get(Calendar.MILLISECOND);
        String fecha = year + "/" + month + "/" + day;

        return fecha;

    }

    public static Date getDateFromHour(String hora, String minuto) {
        return getDateFromHour(hora, minuto, "00");
    }

    public static Date getDateFromHour(String hora, String minuto, String segundo) {

        if (Integer.parseInt(hora) < 10) {
            hora = "0" + hora;
        }
        if (Integer.parseInt(minuto) < 10) {
            minuto = "0" + minuto;
        }

        String horaCompleta = hora + ":" + minuto + ":" + segundo;
        return dateFormater(getCurrentDate() + " " + horaCompleta, "yyyy/MM/dd HH:mm:ss");
    }

    public static String getCurrentDate() {
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1; // Note: zero based!
        int day = now.get(Calendar.DAY_OF_MONTH);
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);
        int millis = now.get(Calendar.MILLISECOND);
        String fecha = year + "/" + month + "/" + day;

        return fecha;

    }

    public static Date getDateTime(Date fecha, Date hora) {
        Calendar calFecha = Calendar.getInstance();
        Calendar calHora = Calendar.getInstance();
        Calendar calResultado = Calendar.getInstance();

        calFecha.setTime(fecha);
        calHora.setTime(hora);
        calResultado.set(Calendar.YEAR, calFecha.get(Calendar.YEAR));
        calResultado.set(Calendar.MONTH, calFecha.get(Calendar.MONTH));
        calResultado.set(Calendar.DAY_OF_MONTH, calFecha.get(Calendar.DAY_OF_MONTH));
        calResultado.set(Calendar.HOUR_OF_DAY, calHora.get(Calendar.HOUR_OF_DAY));
        calResultado.set(Calendar.MINUTE, calFecha.get(Calendar.MINUTE));
        calResultado.set(Calendar.SECOND, calFecha.get(Calendar.SECOND));

        return calResultado.getTime();
    }

    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date1.getTime() - date2.getTime();
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    public static long getMillisecondInHour() {
        return 3600000L;
    }

    public static java.sql.Date getStartOfDate(Date date) {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(date);
        calendario.set(Calendar.HOUR_OF_DAY, 0);
        calendario.set(Calendar.MINUTE, 0);
        calendario.set(Calendar.SECOND, 0);
        return new java.sql.Date(Long.valueOf(calendario.getTime().getTime()));
    }

    public static java.sql.Date getEndOfDate(Date date) {
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(date);
        calendario.set(Calendar.HOUR_OF_DAY, 23);
        calendario.set(Calendar.MINUTE, 59);
        calendario.set(Calendar.SECOND, 59);
        return new java.sql.Date(Long.valueOf(calendario.getTime().getTime()));
    }

    public static Integer getDifferenceInWorksDays(Date date) {
        Integer result = 0;
        Calendar calendar = GregorianCalendar.getInstance();
        Calendar calendarToday = GregorianCalendar.getInstance();
        calendar.setTime(date);
        calendarToday.setTime(new Date());
        boolean sameDay = false;
        Integer[] daysAllowed = {2, 3, 4, 5,6};

        if (calendarToday.getTime().after(date)) {
            do {
                int dayOfTheWeek = calendar.get(Calendar.DAY_OF_WEEK);
                int dayOfTheYear = calendar.get(Calendar.DAY_OF_WEEK);
//                System.out.println("DO: " + calendar.getTime() + " / " + calendarToday.getTime());
                
                if (calendar.get(Calendar.MONTH) == calendarToday.get(Calendar.MONTH) && calendar.get(Calendar.YEAR) == calendarToday.get(Calendar.YEAR)) {
//                    System.out.println("In the same month and Year");
                    if (calendar.get(Calendar.DAY_OF_YEAR) == calendarToday.get(Calendar.DAY_OF_YEAR)) {
//                        System.out.println("In the same day");
                        sameDay=true;
                    }
                }
                //Checks if the day is work day
                if (Arrays.asList(daysAllowed).contains(dayOfTheWeek)) {
                    result++;
                }
                else
                {
//                    System.out.println("DATE OUT OF WORKS DATE:" + calendar.getTime());
                }
                calendar.add(Calendar.DATE, 1);

            } while (!sameDay );

        } else {
            result = -1;
        }

        return result;
    }
    public static Date getNextLaborDay(Date fecha)
    {
            Calendar calendario = GregorianCalendar.getInstance();
            
            calendario.setTime(fecha);
            calendario.set(Calendar.HOUR_OF_DAY, 8);
            calendario.set(Calendar.SECOND, 0);
            calendario.set(Calendar.MINUTE, 0);
            int diaSemana= calendario.get(Calendar.DAY_OF_WEEK);
            UtilLogger.info("DateUtil : Dia de la semana Actual:"  + diaSemana);
            calendario.add(Calendar.DATE, 1);//agrega un dia
            
            Integer[] daysAllowed = {2, 3, 4, 5,6};
            int dayOfTheWeek = calendario.get(Calendar.DAY_OF_WEEK);
            
            if (!Arrays.asList(daysAllowed).contains(dayOfTheWeek)) {
                
                UtilLogger.info("Dia fuera del rango : "+ dayOfTheWeek );
                if (dayOfTheWeek == 7) //Sabado
                {
                    UtilLogger.info("Se agregan 2 dias a la fecha actual:" + calendario.getTime());
                    calendario.add(Calendar.DATE, 2);//agrega 2 dias
                }
                else if (dayOfTheWeek == 1) //Sabado
                {
                    UtilLogger.info("Se agrega 1 dia a la fecha actual:" + calendario.getTime());
                    calendario.add(Calendar.DATE, 1);//agrega 1 dias
                }
            }
            
            fecha = calendario.getTime();
            return fecha;
    }
    
    public static void main(String[] args) {
            System.out.println("TEST DATE");
            Calendar calendar = GregorianCalendar.getInstance();
            calendar.setTime(new Date());
            calendar.add(Calendar.DATE, 10);
            System.out.println("Test tested: " + calendar.getTime() );
            Date fechaProxima =getNextLaborDay(calendar.getTime());
            System.out.println("Proximo dia laboral:" + fechaProxima);
            
                  
    }

}
