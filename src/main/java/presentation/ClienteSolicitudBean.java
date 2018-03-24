/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.cliente.boundary.ClienteSolicitudManager;
import business.cliente.entity.Cliente;
import business.direccion.entity.Barrio;
import business.direccion.entity.Ciudad;
import business.funcionario.boundary.FuncionarioManager;
import business.funcionario.entity.Funcionario;
import business.solicitudes.entity.SolicitudConexion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ggauto
 */
@Named
@SessionScoped
public class ClienteSolicitudBean implements Serializable {

    private SolicitudConexion solicitudConexion;
    private List<Funcionario> funcionarioList;
    private Funcionario funcionarioSelected;
    @Inject
    FuncionarioManager funcionarioMgr;
    @Inject
    ClienteSolicitudManager clienteSolicitudMgr;
    @Inject
    LoginBean session;

    @PostConstruct
    public void init() {
        limpiar();
    }

    public void limpiar() {
        funcionarioList = new ArrayList<>();
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

    public Funcionario getFuncionarioSelected() {
        return funcionarioSelected;
    }

    public void setFuncionarioSelected(Funcionario funcionarioSelected) {
        this.funcionarioSelected = funcionarioSelected;
    }

}
