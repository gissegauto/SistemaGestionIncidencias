/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.usuario.controller.UsuarioController;
import business.usuario.entity.Pantalla;
import business.utils.UtilLogger;
import business.usuario.entity.Usuario;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author ggauto
 */
@Model
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private boolean loggedIn;
    private Usuario usuario;
    private String fechaAcceso;
    static Map<String, Pantalla> mapaPantalla;

    @Inject
    UsuarioController usuariosController;

    @PostConstruct
    public void init() {
        username = "";
        password = "";
        loggedIn = false;
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        fechaAcceso = f.format(new Date());
        usuario = new Usuario();
        mapaPantalla = new HashMap<>();
    }

    public String logout() throws IOException {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        session.invalidate();

        FacesContext.getCurrentInstance().getExternalContext().redirect("../login.jsf");
        UtilLogger.info("Cerró la sessión");
        loggedIn = false;
        return "login";
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String login() throws IOException {
        usuario = usuariosController.authenticate(username, password);
        if (usuario != null) {
            loggedIn = true;
        }

        if (loggedIn) {
            UtilLogger.info("Se inició sesión como " + username);
            redirect();
            return "usuario";
        } else {
            loggedIn = false;
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error de acceso", "El usuario y la contraseña no coinciden");
            FacesContext.getCurrentInstance().addMessage(null, message);
            UtilLogger.info("Se intentó ingresar como " + username);
            username = null;
            password = null;
            RequestContext.getCurrentInstance().update("loginPage");
            return "login";
        }
    }

    public void redirect() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().redirect("secure/usuario.jsf");
    }

    public boolean getPermisoPantalla(String roles) {

        return true;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public static Map<String, Pantalla> getMapaPantalla() {
        return mapaPantalla;
    }

    public static void setMapaPantalla(Map<String, Pantalla> mapaPantalla) {
        LoginBean.mapaPantalla = mapaPantalla;
    }

    public String getFechaAcceso() {
        return fechaAcceso;
    }

    public void setFechaAcceso(String fechaAcceso) {
        this.fechaAcceso = fechaAcceso;
    }

}
