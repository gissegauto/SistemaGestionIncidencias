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
import business.funcionario.controller.HistorialFuncionarioController;
import business.funcionario.entity.Funcionario;
import business.utils.UtilLogger;
import java.io.Serializable;
import java.util.Date;
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
public class FuncionarioBean implements Serializable {

    private Funcionario funcionario;
    private List<Funcionario> funcionarioList;
    private List<Ciudad> ciudadList;
    private Ciudad ciudad;
    private List<Barrio> barrioList;
    private Barrio barrio;

    @Inject
    FuncionarioManager funcionarioMgr;
    @Inject
    HistorialFuncionarioController historialFuncionarioController;
    @Inject
    BarrioManager barrioMgr;
    @Inject
    CiudadManager ciudadMgr;
    @Inject
    LoginBean session;

    @PostConstruct
    public void init() {
        limpiar();
    }

    public void limpiar() {
        funcionario = new Funcionario();
        funcionarioList = funcionarioMgr.getAll();
        ciudadList = ciudadMgr.getAll();
        ciudad = new Ciudad();
        barrio = new Barrio();
    }

    public String add() {
        try {
            if (null != funcionario) {
                for (Funcionario funcionario : funcionarioList) {
                    if (funcionario.getApellidoFuncionario().trim().equalsIgnoreCase(funcionario.getApellidoFuncionario().trim())
                            && (funcionario.getIdFuncionario() == null || funcionario.getIdFuncionario() == 0)) {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Advertencia",
                                "El funcionario " + funcionario.getNombreFuncionario() + funcionario.getApellidoFuncionario()
                                + " ya se encuentra registrado"));
                        return "funcionario";
                    }
                }
                if (funcionario != null & funcionario.getIdFuncionario() == null) {
                    funcionario.setEstado("Activo");
                    funcionario.setFechaRegistro(new Date());
                    funcionario.setIdUsuarioRegistro(session.getUsuario());
                    funcionario = funcionarioMgr.add(funcionario);
                    if(funcionario != null){
                        historialFuncionarioController.addHistory(funcionario);
                    }
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se agregó correctamente",
                            "Funcionario: " + funcionario.getNombreFuncionario() + funcionario.getApellidoFuncionario()));
                } else if (funcionario != null & funcionario.getIdFuncionario() > 0) {
                    funcionario.setIdUsuarioActualizacion(session.getUsuario());
                    funcionario.setFechaActualizacion(new Date());
                    funcionario = funcionarioMgr.update(funcionario);
                    
                    if(funcionario != null){
                        historialFuncionarioController.addHistory(funcionario);
                    }
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizó correctamente",
                            "Funcionario: " + funcionario.getNombreFuncionario() + funcionario.getApellidoFuncionario()));
                }
                limpiar();
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar el funcionario "));
            UtilLogger.error("Problemas al insertar el funcionario", e);
        }
        RequestContext.getCurrentInstance().update("funcionarioForm:dtFuncionario");
        return "funcionario";
    }

    public String delete() {
        try {
            funcionarioMgr.delete(funcionario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se borró Funcionario"));
            RequestContext.getCurrentInstance().update("funcionarioForm:dtFuncionario");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar el funcionario"));
            UtilLogger.error("Problemas al insertar el funcionario", e);
            return null;
        }
        return "funcionario";
    }

    public void buscarBarrios() {
        barrioList = barrioMgr.getBarriosByCiudad(ciudad);
    }

    public void actionClean(ActionEvent actionEvent) {
        this.funcionario = new Funcionario();
        RequestContext.getCurrentInstance().update("funcionarioForm:dtFuncionario");
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public List<Ciudad> getCiudadList() {
        return ciudadList;
    }

    public void setCiudadList(List<Ciudad> ciudadList) {
        this.ciudadList = ciudadList;
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
