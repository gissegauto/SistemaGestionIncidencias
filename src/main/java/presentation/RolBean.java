/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.usuario.boundary.RolManager;
import business.usuario.entity.Rol;
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
public class RolBean implements Serializable {

    private Rol rol;
    private List<Rol> rolList;

    @Inject
    RolManager rolMgr;

    @PostConstruct
    public void init() {
        limpiar();
    }

    public void limpiar() {
        rol = new Rol();
        rolList = rolMgr.getByNotBorrado();
    }

    public void addRol() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            if (null != rol && rol.getIdrol() == null) {
                boolean flag = false;
                for (Rol roles : rolList) {
                    if (roles.getDescripcion().trim().equalsIgnoreCase(rol.getDescripcion().trim())
                            && (rol.getIdrol() == null || rol.getIdrol() == 0)) {
                        context.addMessage(null, new FacesMessage("Advertencia",
                                "La rol " + rol.getDescripcion()
                                + " ya se encuentra registrado"));
                        flag = true;
                    }
                }
                if (!flag) {
                    rol.setEstado("Activo");
                    rol = rolMgr.add(rol);
                    context.addMessage(null, new FacesMessage("Se agregó correctamente",
                            "Rol: " + rol.getDescripcion()));
                    limpiar();
                    RequestContext.getCurrentInstance().update("rolForm:dtRol");
                }
            }
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar el rol "));
            UtilLogger.error("Problemas al insertar el rol", e);
        }
    }

    public String delete() {
        try {
            if (rol.getIdrol() > 0) {
                rol.setEstado("Borrado");
                rolMgr.update(rol);
                limpiar();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se borró el Rol"));
                RequestContext.getCurrentInstance().update("rolForm:dtRol");
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar el rol"));
            UtilLogger.error("Problemas al insertar el rol", e);
        }
        return "rol";
    }

    public void onCellEdit(CellEditEvent event) {
        String oldValue = event.getOldValue().toString();
        String newValue = event.getNewValue().toString();
        Rol newRol = rolMgr.getByName(oldValue);
        newRol.setDescripcion(newValue);
        rolMgr.update(newRol);
        RequestContext.getCurrentInstance().update("rolForm:dtRol");

    }

    public void actionClean(ActionEvent actionEvent) {
        this.rol = new Rol();
        RequestContext.getCurrentInstance().update("rolForm:dtRol");
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

}
