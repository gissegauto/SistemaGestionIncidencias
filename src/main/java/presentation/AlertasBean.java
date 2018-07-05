/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.configuracion.boundary.AlertasManager;
import business.configuracion.entity.Alertas;
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
public class AlertasBean implements Serializable {

    private Alertas alertas;
    private Date hora;
    private List<Alertas> alertasList;

    @Inject
    AlertasManager alertasMgr;

    @PostConstruct
    public void init() {
        limpiar();
    }

    public void limpiar() {
        alertas = new Alertas();
        alertasList = alertasMgr.getAll();
    }

    public String addAlerta() {
        try {
            if (null != alertas) {
                if (alertas.getIdAlertas() == null) {
                    alertasMgr.add(alertas);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se agregó correctamente"));
                } else {
                    alertasMgr.update(alertas);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo correctamente"));
                }
            }
            RequestContext.getCurrentInstance().update("alertasForm:dtAlertas");
            RequestContext.getCurrentInstance().execute("PF('dlgAlertas').hide()");
            limpiar();
            return "alertas";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar alerta "));
            UtilLogger.error("Problemas al insertar alerta", e);
            return "";
        }
    }

    public String delete(Alertas aler) {
        try {
            alertasMgr.delete(aler);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se borró el Alertas"));
            limpiar();
            RequestContext.getCurrentInstance().update("alertasForm:dtAlertas");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar el cliente "));
            UtilLogger.error("Problemas al insertar el cliente", e);
        }
        return "alertas";
    }

    public Alertas getAlertas() {
        return alertas;
    }

    public void setAlertas(Alertas alertas) {
        this.alertas = alertas;
    }

    public List<Alertas> getAlertasList() {
        return alertasList;
    }

    public void setAlertasList(List<Alertas> alertasList) {
        this.alertasList = alertasList;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

}
