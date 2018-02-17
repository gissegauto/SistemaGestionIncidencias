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
    private boolean bloquearBotones = true;

    @Inject
    RolManager rolesMgr;

    public RolBean() {
    }

    @PostConstruct
    public void init() {
        UtilLogger.info("Rol init: obteniendo lista de los roles ");
        limpiar();
        UtilLogger.info("Rol init: se encontraron " + rolesList.size());
    }

    public void limpiar() {
        rol = new Rol();
        rolesList = rolesMgr.getAll();
    }

    public String agregarRol() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {

            if (null != rol) {
                for (Rol roles : rolesList) {
                    if (roles.getDescripcion().trim().equalsIgnoreCase(rol.getDescripcion().trim())
                            && (rol.getIdrol() == null || rol.getIdrol() == 0)) {
                        context.addMessage(null, new FacesMessage("Advertencia",
                                "La rol " + rol.getDescripcion()
                                + " ya se encuentra registrado"));
                        RequestContext.getCurrentInstance().execute("PF('dlgRolAdd').hide()");
                        return "rol";
                    }
                }
                if (rol != null & rol.getIdrol() == null) {
                    rol = rolesMgr.add(rol);
                } else if (rol != null & rol.getIdrol() > 0) {
                    rol = rolesMgr.update(rol);
                }
            }
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar el rol "));
            UtilLogger.error("Problemas al insertar el rol", e);
        }
        return "rol";
    }

    public void actionClean(ActionEvent actionEvent) {
        this.rol = new Rol();
        RequestContext.getCurrentInstance().update("rol-form:dtRol");
    }

    public void alSeleccionarRol(SelectEvent event) {
        this.rol = (Rol) event.getObject();

        this.bloquearBotones = false;
        RequestContext.getCurrentInstance().update("rol-form:dtRol");
        RequestContext.getCurrentInstance().update("rol-form:dtRol:botonEditar");
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

    public boolean isBloquearBotones() {
        return bloquearBotones;
    }

    public void setBloquearBotones(boolean bloquearBotones) {
        this.bloquearBotones = bloquearBotones;
    }
}
