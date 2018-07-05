/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.configuracion.boundary.NotificacionesManager;
import business.configuracion.entity.Notificaciones;
import business.utils.UtilLogger;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;

/**
 *
 * @author ggauto
 */
@Named
@SessionScoped
public class NotificacionesBean implements Serializable {

    private Notificaciones notificaciones;
    private Date hora;
    private List<Notificaciones> notificacionesList;

    @Inject
    NotificacionesManager notificacionesMgr;

    @Inject
    LoginBean session;

    @PostConstruct
    public void init() {
        limpiar();
    }

    public void limpiar() {
        notificaciones = new Notificaciones();
        notificacionesList = notificacionesMgr.getAll();
    }

    public String addNotificacion() {
        try {
            if (null != notificaciones) {
                if (notificaciones.getIdNotificaciones() == null) {
                    notificacionesMgr.add(notificaciones);
                    notificaciones.setFechaRegistro(new Date());
                    notificaciones.setIdUsuarioRegistro(session.getUsuario());
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se agregó correctamente"));
                } else {
                    notificacionesMgr.update(notificaciones);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
                }
            }
            RequestContext.getCurrentInstance().update("notificacionesForm:dtNotificaciones");
            RequestContext.getCurrentInstance().execute("PF('dlgNotificaciones').hide()");
            limpiar();
            return "notificaciones";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar notificacion "));
            UtilLogger.error("Problemas al insertar notificacion", e);
            return "";
        }
    }

    public String delete(Notificaciones not) {
        try {
            notificacionesMgr.delete(not);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se borró el Notificaciones"));
            limpiar();
            RequestContext.getCurrentInstance().update("notificacionesForm:dtNotificaciones");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar el cliente "));
            UtilLogger.error("Problemas al insertar el cliente", e);
        }
        return "notificaciones";
    }

    public Notificaciones getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(Notificaciones notificaciones) {
        this.notificaciones = notificaciones;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public List<Notificaciones> getNotificacionesList() {
        return notificacionesList;
    }

    public void setNotificacionesList(List<Notificaciones> notificacionesList) {
        this.notificacionesList = notificacionesList;
    }

    public NotificacionesManager getNotificacionesMgr() {
        return notificacionesMgr;
    }

    public void setNotificacionesMgr(NotificacionesManager notificacionesMgr) {
        this.notificacionesMgr = notificacionesMgr;
    }

}
