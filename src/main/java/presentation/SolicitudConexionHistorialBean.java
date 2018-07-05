/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.solicitudes.boundary.HistorialSolicitudConexionManager;
import business.solicitudes.entity.HistorialSolicitudConexion;
import business.solicitudes.entity.SolicitudConexion;
import business.utils.UtilLogger;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import static javax.faces.context.FacesContext.getCurrentInstance;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

/**
 *
 * @author ggauto
 */
@Named
@SessionScoped
public class SolicitudConexionHistorialBean implements Serializable {

    private List<HistorialSolicitudConexion> solicitudConexionHistorialList;
    private SolicitudConexion solicitudConexion;
    @Inject
    HistorialSolicitudConexionManager solicitudConexionHistorialMgr;

    @PostConstruct
    public void init() {
        limpiar();
    }

    public void limpiar() {
        solicitudConexionHistorialList = new ArrayList<>();
    }

    public void cargarHistorial(SolicitudConexion solicitud) {
        try {
            solicitudConexion = solicitud;
            solicitudConexionHistorialList = solicitudConexionHistorialMgr.getHistorialByIdSolicitud(solicitud);
            RequestContext.getCurrentInstance().update("historialSolicitudConexionForm:dtHistorialSolicitudConexion");
            
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName() + ".cargarHistorial", e);
        }
    }

    public List<HistorialSolicitudConexion> getSolicitudConexionHistorialList() {
        return solicitudConexionHistorialList;
    }

    public void setSolicitudConexionHistorialList(List<HistorialSolicitudConexion> solicitudConexionHistorialList) {
        this.solicitudConexionHistorialList = solicitudConexionHistorialList;
    }

    public SolicitudConexion getSolicitudConexion() {
        return solicitudConexion;
    }

    public void setSolicitudConexion(SolicitudConexion solicitudConexion) {
        this.solicitudConexion = solicitudConexion;
    }

}
