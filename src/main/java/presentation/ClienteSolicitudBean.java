/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.cliente.boundary.ClienteSolicitudManager;
import business.cliente.entity.Cliente;
import business.cliente.entity.ClienteSolicitud;
import business.funcionario.boundary.FuncionarioManager;
import business.funcionario.entity.Funcionario;
import business.solicitudes.boundary.SolicitudConexionManager;
import business.solicitudes.entity.SolicitudConexion;
import business.utils.UtilLogger;
import java.io.Serializable;
import java.util.Date;
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
public class ClienteSolicitudBean implements Serializable {

    private SolicitudConexion solicitudConexion;
    private List<Funcionario> funcionarioList;
    private List<Funcionario> funcionarioSelected;

    @Inject
    FuncionarioManager funcionarioMgr;
    @Inject
    ClienteSolicitudManager clienteSolicitudMgr;
    @Inject
    SolicitudConexionManager solicitudConexionMgr;
    @Inject
    LoginBean session;

    @PostConstruct
    public void init() {
        limpiar();
    }

    public String asignarTecnicos() {
        try {
            boolean confirm = true;
            if (funcionarioSelected != null) {
                for (Funcionario funcionario : funcionarioSelected) {
                    ClienteSolicitud clienteSolicitud = new ClienteSolicitud();
                    clienteSolicitud.setIdFuncionario(funcionario);
                    clienteSolicitud.setIdSolicitudConexion(solicitudConexion);
                    clienteSolicitudMgr.add(clienteSolicitud);
                }
            }
            if (confirm) {
                changeStatusSolicitud();
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error",
                        "Ocurrió un error al intentar guardar"));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar"));
            UtilLogger.error("Problemas al asignar funcionario a la solicitud", e);
        }
        return "solicitudConexion";
    }

    private void changeStatusSolicitud() {
        solicitudConexion.setIdUsuarioActualizacion(session.getUsuario());
        solicitudConexion.setFechaActualizacion(new Date());
        solicitudConexion.setEstado("En Curso");
        solicitudConexionMgr.update(solicitudConexion);
    }

    public void limpiar() {
        funcionarioList = funcionarioMgr.getByTecnico();
        solicitudConexion = new SolicitudConexion();
    }

    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    public SolicitudConexion getSolicitudConexion() {
        return solicitudConexion;
    }

    public void setSolicitudConexion(SolicitudConexion solicitudConexion) {
        this.solicitudConexion = solicitudConexion;
    }

    public List<Funcionario> getFuncionarioSelected() {
        return funcionarioSelected;
    }

    public void setFuncionarioSelected(List<Funcionario> funcionarioSelected) {
        this.funcionarioSelected = funcionarioSelected;
    }

}
