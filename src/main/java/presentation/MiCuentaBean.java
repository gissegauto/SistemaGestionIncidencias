/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.direccion.boundary.BarrioManager;
import business.direccion.boundary.CiudadManager;
import business.direccion.entity.Barrio;
import business.direccion.entity.Ciudad;
import business.funcionario.boundary.FuncionarioManager;
import business.funcionario.entity.Funcionario;
import business.usuario.controller.UsuarioController;
import business.usuario.entity.Usuario;
import business.utils.MD5Generator;
import business.utils.UtilLogger;
import java.io.Serializable;
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
public class MiCuentaBean implements Serializable {

    private Usuario usuario;
    private String password;
    private String nuevo;
    private String repetir;
    private Funcionario funcionario;
    private List<Ciudad> ciudadList;
    private Ciudad ciudad;
    private List<Barrio> barrioList;
    private Barrio barrio;

    @Inject
    BarrioManager barrioMgr;
    @Inject
    CiudadManager ciudadMgr;
    @Inject
    UsuarioController usuarioController;
    @Inject
    LoginBean session;

    @PostConstruct
    public void init() {
        usuario = session.getUsuario();
        funcionario = usuario.getIdFuncionario();
        ciudadList = ciudadMgr.getAll();
        ciudad = new Ciudad();
        barrio = new Barrio();
    }

    /**
     * Actualizar Password
     */
    public void actualizarPass() {
        if (usuario != null & password != null & nuevo != null & repetir != null) {
            if (nuevo.equals(repetir)) {
                if (usuario.getPassword().equals(MD5Generator.MD5(password))) {
                    usuario = usuarioController.actualizarPassword(usuario, nuevo);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizó la contraseña"));
                    RequestContext.getCurrentInstance().execute("PF('dlgActualizarPass').hide()");
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "Contraseña actual incorrecta"));
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error", "Vuelva a repetir la contraseña"));
            }
        }
    }

    /**
     * Actualizar Datos Funcionario
     */
    public void actualizarDatos() {
        if (funcionario != null && !funcionario.getNombreFuncionario().equals("")) {
            if (barrio != null && barrio.getIdBarrio() > 0) {
                funcionario.setIdBarrio(barrio);
            }
            usuarioController.actualizarDatosPersonales(funcionario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizaron los Datos Personales"));
            RequestContext.getCurrentInstance().execute("PF('dlgActualizarDatos').hide()");
            RequestContext.getCurrentInstance().update("miCuentaForm:miCuentaDatosDetail");
        }
    }

    public void buscarBarrios() {
        barrioList = barrioMgr.getBarriosByCiudad(ciudad);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNuevo() {
        return nuevo;
    }

    public void setNuevo(String nuevo) {
        this.nuevo = nuevo;
    }

    public String getRepetir() {
        return repetir;
    }

    public void setRepetir(String repetir) {
        this.repetir = repetir;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Ciudad> getCiudadList() {
        return ciudadList;
    }

    public void setCiudadList(List<Ciudad> ciudadList) {
        this.ciudadList = ciudadList;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public List<Barrio> getBarrioList() {
        return barrioList;
    }

    public void setBarrioList(List<Barrio> barrioList) {
        this.barrioList = barrioList;
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

}
