/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.usuario.controller.UsuarioController;
import business.usuario.boundary.RolManager;
import business.utils.MD5Generator;
import business.utils.UtilLogger;
import business.usuario.boundary.UsuarioManager;
import business.usuario.entity.Rol;
import business.usuario.entity.Usuario;
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
public class UsuarioBean implements Serializable {

    private Usuario usuario;
    private Usuario usuarioSelected;
    private List<Usuario> usuarioList;
    private String password;
    private String repeadPassword;
    private List<Rol> rolesList;

    @Inject
    UsuarioManager usuariosMgr;

    @Inject
    RolManager rolesMgr;

    @Inject
    UsuarioController usuariosController;

    public UsuarioBean() {

    }

    @PostConstruct
    public void init() {
        limpiar();
    }

    public void limpiar() {
        usuario = new Usuario();
        usuarioSelected = new Usuario();
        usuarioList = usuariosMgr.getAll();
        rolesList = rolesMgr.getAll();
    }

    public String addUsuario() {
        try {
            if (null != usuario) {
                for (Usuario user : usuarioList) {
                    if ((usuario.getIdusuario() == null || usuario.getIdusuario() == 0)
                            && usuario.getUsername().trim().equalsIgnoreCase(user.getUsername().trim())) {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Advertencia",
                                "El usuario " + usuario.getUsername()
                                + " ya se encuentra registrado"));
                        RequestContext.getCurrentInstance().execute("PF('dlgUsuAdd').hide()");
                        return "usuario";
                    }
                }
                if (usuario != null & usuario.getIdusuario() == null) {
                    usuario = usuariosMgr.add(usuario);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se agregó correctamente",
                            "Usuario: " + usuario.getUsername()));
                } else if (usuario != null & usuario.getIdusuario() > 0) {
                    usuario = usuariosMgr.update(usuario);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizó correctamente",
                            "Usuario: " + usuario.getUsername()));
                }

                if (usuario != null) {
                    if (null == usuario.getIdusuario()) {
                        //cifrar password
                        usuario.setPassword(MD5Generator.MD5(usuario.getPassword()));
                        usuario = usuariosMgr.add(usuario);
                        usuarioList.add(usuario);
                    } else {
                        usuario.setPassword(MD5Generator.MD5(usuario.getPassword()));
                        usuario = usuariosMgr.update(usuario);
                        usuarioList = usuariosMgr.getAll();
                    }
                }
                RequestContext.getCurrentInstance().execute("PF('dlgUsuAdd').hide()");
                limpiar();
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar el usuario "));
            UtilLogger.error("Problemas al insertar el usuario", e);
        }
        return "usuario";
    }

    public String delete() {
        try {
            if (usuario.getIdusuario() > 0) {
                usuariosMgr.delete(usuario);
                limpiar();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se borró Usuario"));
                RequestContext.getCurrentInstance().update("usuarioForm:dtUsuario");
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar el usuario "));
            UtilLogger.error("Problemas al insertar el usuario", e);
        }
        return "usuario";
    }

    public void resetearPass() {
        if (!usuarioSelected.getPassword().equals("")) {
            usuariosController.resetearPassword(usuarioSelected);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se reseteó el  password", "Usuario : " + usuarioSelected.getUsername()));
        }
    }

    public void actionClean(ActionEvent actionEvent) {
        usuario = new Usuario();
        RequestContext.getCurrentInstance().update("usuarioForm:dtUsuario");
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
//        Usuario newRolName = usuariosMgr.getByName(oldValue.toString());
        for (Usuario user : usuarioList) {
            if (user.getUsername().equals(oldValue.toString())) {
                user.setUsername(newValue.toString());
                usuariosMgr.update(user);
            }

            if (user.getIdrol().equals(oldValue)) {
                Rol newUserRol = user.getIdrol();
                newUserRol.setIdrol(((Rol) newValue).getIdrol());
                user.setIdrol(newUserRol);
                usuariosMgr.update(user);
            }
        }
        RequestContext.getCurrentInstance().update("usuarioForm:dtUsuario");

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioSelected() {
        return usuarioSelected;
    }

    public void setUsuarioSelected(Usuario usuarioSelected) {
        this.usuarioSelected = usuarioSelected;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeadPassword() {
        return repeadPassword;
    }

    public void setRepeadPassword(String repeadPassword) {
        this.repeadPassword = repeadPassword;
    }

    public UsuarioManager getUsuarioMgr() {
        return usuariosMgr;
    }

    public void setUsuarioMgr(UsuarioManager usuariosMgr) {
        this.usuariosMgr = usuariosMgr;
    }

    public List<Rol> getRolList() {
        return rolesList;
    }

    public void setRolList(List<Rol> rolesList) {
        this.rolesList = rolesList;
    }

}
