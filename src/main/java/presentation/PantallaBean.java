/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.usuario.boundary.PantallaManager;
import business.usuario.entity.Pantalla;
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

/**
 *
 * @author ggauto
 */
@Named
@SessionScoped
public class PantallaBean implements Serializable {

    private Pantalla pantallaSelected;
    private List<Pantalla> pantallaList;
    FacesContext context = FacesContext.getCurrentInstance();

    @Inject
    PantallaManager pantallaManager;

    @PostConstruct
    public void init() {
        UtilLogger.info("Rol init: obteniendo lista de los roles");
        limpiar();
        UtilLogger.info("Rol init: se encontraron " + pantallaList.size());
    }

    public void limpiar() {
        pantallaSelected = new Pantalla();
        pantallaList = pantallaManager.getAll();
    }

    public String agregarPantalla() {
        try {
            if (null != pantallaSelected) {
                for (Pantalla pantalla : pantallaList) {
                    if (pantalla.getDescripcion().trim().equalsIgnoreCase(pantallaSelected.getDescripcion().trim())
                            && (pantallaSelected.getIdpantalla() == null || pantallaSelected.getIdpantalla() == 0)) {
                        context.addMessage(null, new FacesMessage("Advertencia",
                                "La pantalla " + pantallaSelected.getDescripcion()
                                + " ya se encuentra registrado"));
                        RequestContext.getCurrentInstance().execute("PF('dlgPantallaAdd').hide()");
                        return "pantalla";
                    }
                }
                if (pantallaSelected != null & pantallaSelected.getIdpantalla() == null) {
                    pantallaSelected = pantallaManager.add(pantallaSelected);
                } else if (pantallaSelected != null & pantallaSelected.getIdpantalla() > 0) {
                    pantallaSelected = pantallaManager.update(pantallaSelected);
                }
            }
            RequestContext.getCurrentInstance().execute("PF('dlgPantallaAdd').hide()");            
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar la pantalla "));
            UtilLogger.error("Problemas al insertar la pantalla", e);
        }
        return "pantalla";
    }

    public void actionClean(ActionEvent actionEvent) {
        this.pantallaSelected = new Pantalla();
        RequestContext.getCurrentInstance().update("pantalla-form:dtPantalla");
    }

    public Pantalla getPantallaSelected() {
        return pantallaSelected;
    }

    public void setPantallaSelected(Pantalla pantallaSelected) {
        this.pantallaSelected = pantallaSelected;
    }

    public List<Pantalla> getPantallaList() {
        return pantallaList;
    }

    public void setPantallaList(List<Pantalla> pantallaList) {
        this.pantallaList = pantallaList;
    }

}
