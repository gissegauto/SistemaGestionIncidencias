/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.solicitudes.controller;

import business.funcionario.entity.Funcionario;
import business.solicitudes.boundary.SolicitudAmpliacionManager;
import business.solicitudes.entity.SolicitudAmpliacion;
import business.usuario.entity.Usuario;
import business.utils.UtilLogger;
import java.util.Date;
import javax.ejb.Stateless;
import javax.inject.Inject;
import presentation.LoginBean;

/**
 *
 * @author ggauto
 */
@Stateless
public class SolicitudAmpliacionController {

    @Inject
    SolicitudAmpliacionManager solicitudAmpliacionMgr;
    @Inject
    LoginBean session;

    /**
     * Agregar una Solicitud Ampiación
     *
     * @param solicitudAmpliacion
     * @return
     */
    public SolicitudAmpliacion agregarSolicitud(SolicitudAmpliacion solicitudAmpliacion) {
        try {
            solicitudAmpliacion.setFechaRegistro(new Date());
            solicitudAmpliacion.setIdUsuarioRegistro(session.getUsuario());
            solicitudAmpliacion.setEstado("Pendiente");
            solicitudAmpliacion = solicitudAmpliacionMgr.add(solicitudAmpliacion);
//            histSolicitudAmpliacionController.addHistory(solicitudAmpliacion);
            return solicitudAmpliacion;
        } catch (Exception e) {
            UtilLogger.error("Error : agregarSolicitud ", e);
            return null;
        }
    }

    /**
     * Agregar una Solicitud Ampiación
     *
     * @param solicitudAmpliacion
     * @param usuario
     * @return
     */
    public SolicitudAmpliacion actualizarSolicitud(SolicitudAmpliacion solicitudAmpliacion) {
        try {
            solicitudAmpliacion.setFechaActualizacion(new Date());
            solicitudAmpliacion.setIdUsuarioActualizacion(session.getUsuario());
            solicitudAmpliacion = solicitudAmpliacionMgr.update(solicitudAmpliacion);
//            histSolicitudAmpliacionController.addHistory(solicitudAmpliacion);
            return solicitudAmpliacion;
        } catch (Exception e) {
            UtilLogger.error("Error : actualizarSolicitud ", e);
            return null;
        }
    }

    /**
     * Actualizar Solicitud de Ampliacion Estado = En Curso al asignarle un
     * funcionario
     *
     * @param solicitudAmpliacion
     * @param funcionario
     */
    public void actualizarSolicitudEnCurso(SolicitudAmpliacion solicitudAmpliacion,
            Funcionario funcionario) {
//        histSolicitudAmpliacionController.addHistory(solicitudAmpliacion);
        solicitudAmpliacion.setIdFuncionario(funcionario);
        solicitudAmpliacion.setFechaActualizacion(new Date());
        solicitudAmpliacion.setIdUsuarioActualizacion(session.getUsuario());
        solicitudAmpliacion.setEstado("En Curso");
        solicitudAmpliacionMgr.update(solicitudAmpliacion);
    }

    /**
     * Actualizar estado de Solicitud Ampiación a Finalizado
     *
     * @param solicitudAmpliacion
     */
    public void actualizarSolicitudFinalizado(SolicitudAmpliacion solicitudAmpliacion) {
        try {
//            histSolicitudAmpliacionController.addHistory(solicitudAmpliacion);
            solicitudAmpliacion.setFechaActualizacion(new Date());
            solicitudAmpliacion.setIdUsuarioActualizacion(session.getUsuario());
            solicitudAmpliacion.setEstado("Finalizado");
            solicitudAmpliacionMgr.update(solicitudAmpliacion);
        } catch (Exception e) {
            UtilLogger.error("Error : actualizarSolicitudFinalizado ", e);
        }
    }

    /**
     * Actualizar estado de Solicitud Ampiación a Anulado
     *
     * @param solicitudAmpliacion
     */
    public void actualizarSolicitudAnulado(SolicitudAmpliacion solicitudAmpliacion) {
        try {
//            histSolicitudAmpliacionController.addHistory(solicitudAmpliacion);
            solicitudAmpliacion.setFechaActualizacion(new Date());
            solicitudAmpliacion.setIdUsuarioActualizacion(session.getUsuario());
            solicitudAmpliacion.setEstado("Anulado");
            solicitudAmpliacionMgr.update(solicitudAmpliacion);
        } catch (Exception e) {
            UtilLogger.error("Error : actualizarSolicitudAnulado ", e);
        }
    }

    /**
     * Activar una Solicitud Ampiación (Estado Pendiente)
     *
     * @param solicitudAmpliacion
     */
    public void activarSolicitud(SolicitudAmpliacion solicitudAmpliacion) {
        try {
//            histSolicitudAmpliacionController.addHistory(solicitudAmpliacion);
            solicitudAmpliacion.setFechaActualizacion(new Date());
            solicitudAmpliacion.setIdUsuarioActualizacion(session.getUsuario());
            solicitudAmpliacion.setEstado("Pendiente");
            solicitudAmpliacionMgr.update(solicitudAmpliacion);
        } catch (Exception e) {
            UtilLogger.error("Error : activarSolicitud ", e);
        }
    }

}
