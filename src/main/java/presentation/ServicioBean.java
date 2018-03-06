/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.configuracion.boundary.ServicioManager;
import business.configuracion.entity.Servicio;
import business.utils.UtilLogger;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;

/**
 *
 * @author ggauto
 */
@Named
@SessionScoped
public class ServicioBean implements Serializable {

    private Servicio servicio;
    private List<Servicio> servicioList;
    FacesContext context = FacesContext.getCurrentInstance();

    @Inject
    ServicioManager servicioMgr;

    @PostConstruct
    public void init() {
        limpiar();
    }

    public void limpiar() {
        servicio = new Servicio();
        servicioList = servicioMgr.getAll();
    }

    public String add() {
        try {
            if (null != servicio) {
                for (Servicio service : servicioList) {
                    if (service.getServicio().trim().equalsIgnoreCase(servicio.getServicio().trim())
                            && (servicio.getIdServicio() == null || servicio.getIdServicio() == 0)) {
                        context.addMessage(null, new FacesMessage("Advertencia",
                                "El servicio " + servicio.getServicio()
                                + " ya se encuentra registrado"));
                        return "servicio";
                    }
                }
                if (servicio != null & servicio.getIdServicio()== null) {
                    servicio = servicioMgr.add(servicio);
                    context.addMessage(null, new FacesMessage("Se agregó correctamente",
                            "Servicio: " + servicio.getServicio()));
                } else if (servicio != null & servicio.getIdServicio()> 0) {
                    servicio = servicioMgr.update(servicio);
                       context.addMessage(null, new FacesMessage("Se actualizó correctamente",
                            "Servicio: " + servicio.getServicio()));
                }
            }
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar el servicio "));
            UtilLogger.error("Problemas al insertar el servicio", e);
        }
        return "servicio";
    }

    public String delete() {
        try {
            if (servicio.getIdServicio()> 0) {
                servicioMgr.delete(servicio);
                context.addMessage(null, new FacesMessage("Se borró Servicio"));
                RequestContext.getCurrentInstance().update("servicioForm:dtServicio");
            }
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar el servicio"));
            UtilLogger.error("Problemas al insertar el servicio", e);
        }
        return "servicio";
    }

    public void onCellEdit(CellEditEvent event) {
//        String oldValue = event.getOldValue().toString();
//        String newValue = event.getNewValue().toString();
//        Servicio newServicio = servicioMgr.getByName(oldValue);
//        newServicio.getServicio(newValue);
//        servicioMgr.update(newServicio);
//        RequestContext.getCurrentInstance().update("servicioForm:dtServicio");

    }

    public void actionClean(ActionEvent actionEvent) {
        this.servicio = new Servicio();
        RequestContext.getCurrentInstance().update("servicioForm:dtServicio");
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public List<Servicio> getServicioList() {
        return servicioList;
    }

    public void setServicioList(List<Servicio> servicioList) {
        this.servicioList = servicioList;
    }

}
