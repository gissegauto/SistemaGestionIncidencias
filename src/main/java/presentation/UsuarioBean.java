/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.usuario.boundary.RolManager;
import business.utils.MD5Generator;
import business.utils.UtilLogger;
import business.usuario.boundary.UsuarioManager;
import business.usuario.entity.Rol;
import business.usuario.entity.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author pinchi
 */
@Model
public class UsuarioBean implements Serializable {

    private Usuario usuario;
    private List<Usuario> usuarioList;
    private boolean bloquearBotones = true;
    private String password;
    private String repeadPassword;
    private List<Rol> rolesList;
    FacesContext context = FacesContext.getCurrentInstance();
    @Inject
    UsuarioManager usuariosMgr;
    @Inject
    RolManager rolesMgr;

    public UsuarioBean() {

    }

    @PostConstruct
    public void init() {
        UtilLogger.info("Usuario init: obteniendo lista de usuarios ");
        usuario = new Usuario();
        usuarioList = new ArrayList<>();
        usuarioList = usuariosMgr.getAll();
        rolesList = new ArrayList<>();
        rolesList = rolesMgr.getAll();
        UtilLogger.info("Usuario init: se encontraron " + usuarioList.size());
    }

    public String addUsuario() {
        try {
            context = FacesContext.getCurrentInstance();
            if (null != usuario) {
                /*for (Usuario usr : usuarioList) {
                    if ((usuario.getIdusuario() == null || usuario.getIdusuario() == 0
                            && usuario.getUsername() ==  usr.getUsername())) {
                        context.addMessage(null, new FacesMessage("Advertencia",
                                "El usuario " + usuario.getUsername()
                                + " ya se encuentra registrado"));
                        RequestContext.getCurrentInstance().execute("PF('dlgUsuAdd').hide()");
                        return "usuario";
                    }
                }*/
                if (usuario != null & usuario.getIdusuario() == null) {
                    usuario = usuariosMgr.add(usuario);
                } else if (usuario != null & usuario.getIdusuario() > 0) {
                    usuario = usuariosMgr.update(usuario);
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

                    return "usuario";
                }
                RequestContext.getCurrentInstance().execute("PF('dlgUsuAdd').hide()");
            }

        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar el usuario "));
            UtilLogger.error("Problemas al insertar el usuario", e);
        }
        return "usuario";
    }

    public void borrar() {
        try {
            context = FacesContext.getCurrentInstance();
            usuariosMgr.delete(usuario);
            usuarioList = usuariosMgr.getAll();
            context.addMessage(null, new FacesMessage("Se borró Usuario"));
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar el usuario "));
            UtilLogger.error("Problemas al insertar la ciudad", e);
        }
    }

    public String delete() {
        try {
            context = FacesContext.getCurrentInstance();
            usuariosMgr.delete(usuario);
            
            FacesContext.getCurrentInstance().getExternalContext().redirect("usuario.jsf");
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar el usuario "));
            UtilLogger.error("Problemas al insertar la ciudad", e);
        }
        return "usuario";
    }

    public void actionClean(ActionEvent actionEvent) {
        usuario = new Usuario();
        RequestContext.getCurrentInstance().update("usuario-form:dtUsuario");
    }

    public void onRowSelect(SelectEvent event) {
        this.usuario = (Usuario) event.getObject();

        this.bloquearBotones = false;
        RequestContext.getCurrentInstance().update("usuario-form:dtUsuario");
        RequestContext.getCurrentInstance().update("usuario-form:dtUsuario:botonEditar");
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public boolean isBloquearBotones() {
        return bloquearBotones;
    }

    public void setBloquearBotones(boolean bloquearBotones) {
        this.bloquearBotones = bloquearBotones;
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
