/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.funcionario.boundary.FuncionarioManager;
import business.funcionario.entity.Funcionario;
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
public class FuncionarioBean implements Serializable {

    private Funcionario funcionario;
    private List<Funcionario> funcionarioList;
    FacesContext context = FacesContext.getCurrentInstance();

    @Inject
    FuncionarioManager funcionarioMgr;

    @PostConstruct
    public void init() {
        limpiar();
    }

    public void limpiar() {
        funcionario = new Funcionario();
        funcionarioList = funcionarioMgr.getAll();
    }

    public String add() {
        try {
            if (null != funcionario) {
                for (Funcionario funcionario : funcionarioList) {
                    if (funcionario.getApellidoFuncionario().trim().equalsIgnoreCase(funcionario.getApellidoFuncionario().trim())
                            && (funcionario.getIdFuncionario()== null || funcionario.getIdFuncionario() == 0)) {
                        context.addMessage(null, new FacesMessage("Advertencia",
                                "El funcionario " + funcionario.getNombreFuncionario() + funcionario.getApellidoFuncionario()
                                + " ya se encuentra registrado"));
                        return "funcionario";
                    }
                }
                if (funcionario != null & funcionario.getIdFuncionario()== null) {
                    funcionario = funcionarioMgr.add(funcionario);
                    context.addMessage(null, new FacesMessage("Se agregó correctamente",
                            "Funcionario: " + funcionario.getNombreFuncionario() + funcionario.getApellidoFuncionario()));
                } else if (funcionario != null & funcionario.getIdFuncionario() > 0) {
                    funcionario = funcionarioMgr.update(funcionario);
                    context.addMessage(null, new FacesMessage("Se actualizó correctamente",
                            "Funcionario: " + funcionario.getNombreFuncionario() + funcionario.getApellidoFuncionario()));
                }
            }
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar el funcionario "));
            UtilLogger.error("Problemas al insertar el funcionario", e);
        }
        RequestContext.getCurrentInstance().update("funcionarioForm:dtFuncionario");
        return "funcionario";
    }

    public String delete() {
        try {
            funcionarioMgr.delete(funcionario);
            context.addMessage(null, new FacesMessage("Se borró Funcionario"));
            RequestContext.getCurrentInstance().update("funcionarioForm:dtFuncionario");
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar el funcionario"));
            UtilLogger.error("Problemas al insertar el funcionario", e);
            return null;
        }
        return "funcionario";
    }

    public void onCellEdit(CellEditEvent event) {
//        String oldValue = event.getOldValue().toString();
//        String newValue = event.getNewValue().toString();
//        Funcionario newFuncionario = funcionarioMgr.getByName(oldValue);
//        newFuncionario.setDescripcion(newValue);
//        funcionarioMgr.update(newFuncionario);
        RequestContext.getCurrentInstance().update("funcionarioForm:dtFuncionario");

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

}
