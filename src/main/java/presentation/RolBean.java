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
import org.primefaces.event.SelectEvent;

/**
 *
 * @author ggauto
 */
@Named
@SessionScoped
public class RolBean implements Serializable {

    private Rol rol;
    private List<Rol> rolesList;
    FacesContext context = FacesContext.getCurrentInstance();

    @Inject
    RolManager rolMgr;

    @PostConstruct
    public void init() {
        limpiar();
    }

    public void limpiar() {
        rol = new Rol();
        rolesList = rolMgr.getAll();
    }

    public String addRol() {
        try {
            if (null != rol) {
                for (Rol roles : rolesList) {
                    if (roles.getDescripcion().trim().equalsIgnoreCase(rol.getDescripcion().trim())
                            && (rol.getIdrol() == null || rol.getIdrol() == 0)) {
                        context.addMessage(null, new FacesMessage("Advertencia",
                                "La rol " + rol.getDescripcion()
                                + " ya se encuentra registrado"));
//                        RequestContext.getCurrentInstance().execute("PF('dlgRolAdd').hide()");
                        return "rol";
                    }
                }
                if (rol != null & rol.getIdrol() == null) {
                    rol = rolMgr.add(rol);
                    context.addMessage(null, new FacesMessage("Se agregó correctamente",
                            "Rol: " + rol.getDescripcion()));
                } else if (rol != null & rol.getIdrol() > 0) {
                    rol = rolMgr.update(rol);
                    context.addMessage(null, new FacesMessage("Se actualizó correctamente",
                            "Rol: " + rol.getDescripcion()));
                }
            }
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar el rol "));
            UtilLogger.error("Problemas al insertar el rol", e);
        }
        RequestContext.getCurrentInstance().update("rolForm:dtRol");
        return "rol";
    }

    public String delete() {
        try {
            rolMgr.delete(rol);
            context.addMessage(null, new FacesMessage("Se borró Rol"));
            RequestContext.getCurrentInstance().update("rolForm:dtRol");
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar el rol"));
            UtilLogger.error("Problemas al insertar el rol", e);
            return null;
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
        return rolesList;
    }

    public void setRolList(List<Rol> rolesList) {
        this.rolesList = rolesList;
    }

}
