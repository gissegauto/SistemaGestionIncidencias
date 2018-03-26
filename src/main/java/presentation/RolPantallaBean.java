/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.usuario.boundary.PantallaManager;
import business.usuario.boundary.RolManager;
import business.usuario.boundary.RolPantallaManager;
import business.usuario.entity.Pantalla;
import business.usuario.entity.Rol;
import business.usuario.entity.RolPantalla;
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
public class RolPantallaBean implements Serializable {

    private RolPantalla rolPantalla;
    private List<RolPantalla> rolPantallaList;
    private List<Rol> rolList;
    private List<Pantalla> pantallaList;
    FacesContext context = FacesContext.getCurrentInstance();
    @Inject
    RolPantallaManager rolPantallaMgr;
    @Inject
    PantallaManager pantallaMgr;
    @Inject
    RolManager rolMgr;

    @PostConstruct
    public void init() {
        limpiar();
    }

    public void limpiar() {
        rolPantalla = new RolPantalla();
        rolPantallaList = rolPantallaMgr.getAll();
        rolList = rolMgr.getAll();
        pantallaList = pantallaMgr.getAll();
    }

    public String agregarRolPantala() {

        try {
            if (null != rolPantalla) {
                if (rolPantalla.getIdrolPantalla()== null) {
                    rolPantalla = rolPantallaMgr.add(rolPantalla);
                } else if (rolPantalla.getIdrolPantalla()> 0) {
                    rolPantalla = rolPantallaMgr.update(rolPantalla);
                }
            }
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar el Rol Pantalla "));
            UtilLogger.error("Problemas al insertar el Rol Pantalla", e);
        }

        return "rolPantalla";
    }

    public String delete() {
        try {
            if (rolPantalla.getIdrolPantalla()> 0) {
                rolPantallaMgr.delete(rolPantalla);
                context.addMessage(null, new FacesMessage("Se borró Rol Pantalla"));
                RequestContext.getCurrentInstance().update("rolPantallaForm:dtRolPantalla");
            }
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar el rol pantalla"));
            UtilLogger.error("Problemas al insertar el rol pantalla", e);
        }
        return "rolPantalla";
    }

    public void onCellEdit(CellEditEvent event) {
        RolPantalla oldValue = (RolPantalla) event.getOldValue();
        RolPantalla newValue = (RolPantalla) event.getNewValue();
//        RolPantalla newRol = rolPantallaMgr.getByName(oldValue);
//        newRol.setDescripcion(newValue);
//        rolPantallaMgr.update(newRol);
        RequestContext.getCurrentInstance().update("rolPantallaForm:dtRolPantalla");

    }

    public void actionClean(ActionEvent actionEvent) {
        this.rolPantalla = new RolPantalla();
        RequestContext.getCurrentInstance().update("rolPantallaForm:dtRolPantalla");
    }

    public RolPantalla getRolPantalla() {
        return rolPantalla;
    }

    public void setRolPantalla(RolPantalla rolPantalla) {
        this.rolPantalla = rolPantalla;
    }

    public List<RolPantalla> getRolPantallaList() {
        return rolPantallaList;
    }

    public void setRolPantallaList(List<RolPantalla> rolPantallaList) {
        this.rolPantallaList = rolPantallaList;
    }

    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    public List<Pantalla> getPantallaList() {
        return pantallaList;
    }

    public void setPantallaList(List<Pantalla> pantallaList) {
        this.pantallaList = pantallaList;
    }

}
