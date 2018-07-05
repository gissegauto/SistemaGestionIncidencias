/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.cliente.boundary.ClienteManager;
import business.solicitudes.boundary.SolicitudAmpliacionManager;
import business.cliente.entity.Cliente;
import business.solicitudes.controller.SolicitudAmpliacionController;
import business.solicitudes.entity.SolicitudAmpliacion;
import business.utils.UtilLogger;
import java.io.Serializable;
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
public class SolicitudAmpliacionBean implements Serializable {

    private SolicitudAmpliacion solicitudAmpliacion;
    private List<SolicitudAmpliacion> solicitudAmpliacionList;
    private List<Cliente> clienteList;
    private Cliente cliente;
    private boolean editar;

    @Inject
    SolicitudAmpliacionManager solicitudAmpliacionMgr;
    @Inject
    SolicitudAmpliacionController solicitudAmpliacionController;
    @Inject
    ClienteManager clienteMgr;

    @PostConstruct
    public void init() {
        limpiar();
    }

    public void limpiar() {
        solicitudAmpliacion = new SolicitudAmpliacion();
        solicitudAmpliacionList = solicitudAmpliacionMgr.getAll();
        cliente = new Cliente();
        clienteList = clienteMgr.getAll();
        editar = false;
    }

    public String add() {
        try {
            if (solicitudAmpliacion.getIdSolicitudAmpliacion() == null) {
                solicitudAmpliacion = solicitudAmpliacionController.agregarSolicitud(solicitudAmpliacion);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se agregó correctamente",
                        "Solicitud de Ampliación Nro: " + solicitudAmpliacion.getIdSolicitudAmpliacion()));
            } else if (solicitudAmpliacion.getIdSolicitudAmpliacion() > 0) {
                solicitudAmpliacion = solicitudAmpliacionController.actualizarSolicitud(solicitudAmpliacion);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizó correctamente",
                        "Solicitud de Ampliación nro: " + solicitudAmpliacion.getIdSolicitudAmpliacion()));
            }
            limpiar();
            RequestContext.getCurrentInstance().update("solicitudAmpliacionForm:dtSolicitudConexion");
            return "solicitudAmpliacion";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar la solicitud de Ampliación "));
            UtilLogger.error("Problemas al insertar la solicitud de Ampliación", e);
            return "";
        }
    }

    public void cambiarEstadoActivo(SolicitudAmpliacion solicitud) {
        if (solicitud != null) {
            solicitudAmpliacionController.activarSolicitud(solicitud);
            RequestContext.getCurrentInstance().update("solicitudAmpliacionForm:dtSolicitudConexion");
        }
    }

    public void cambiarEstadoAnulado(SolicitudAmpliacion solicitud) {
        if (solicitud != null) {
            solicitudAmpliacionController.actualizarSolicitudAnulado(solicitud);
            RequestContext.getCurrentInstance().update("solicitudAmpliacionForm:dtSolicitudConexion");
        }
    }

//    public String verHistorial(SolicitudAmpliacion solicitudA) {
//        if (solicitudA != null) {
////            solicitudConexionHistorialBean.cargarHistorial(solicitudC);
//            return "solicitudConexionHistorial";
//        } else {
//            return "";
//        }
//    }
    public void seleccionarCliente() {
        System.out.println("entro");
    }

    public void edicion() {
        editar = true;
    }

    public SolicitudAmpliacion getSolicitudAmpliacion() {
        return solicitudAmpliacion;
    }

    public void setSolicitudAmpliacion(SolicitudAmpliacion solicitudAmpliacion) {
        this.solicitudAmpliacion = solicitudAmpliacion;
    }

    public List<SolicitudAmpliacion> getSolicitudAmpliacionList() {
        return solicitudAmpliacionList;
    }

    public void setSolicitudAmpliacionList(List<SolicitudAmpliacion> solicitudAmpliacionList) {
        this.solicitudAmpliacionList = solicitudAmpliacionList;
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isEditar() {
        return editar;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
    }

}
