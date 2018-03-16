/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.cliente.boundary.ClienteManager;
import business.cliente.controller.ClienteController;
import business.cliente.controller.HistorialClienteController;
import business.cliente.entity.Cliente;
import business.direccion.boundary.BarrioManager;
import business.direccion.boundary.CiudadManager;
import business.direccion.entity.Barrio;
import business.direccion.entity.Ciudad;
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
public class ClienteBean implements Serializable {

    private Cliente cliente;
    private List<Cliente> clienteList;
    private List<Ciudad> ciudadList;
    private Ciudad ciudad;
    private List<Barrio> barrioList;
    Barrio barrio;
    @Inject
    ClienteManager clienteMgr;
    @Inject
    HistorialClienteController historialClienteController;
    @Inject
    ClienteController clienteController;
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
        cliente = new Cliente();
        clienteList = clienteMgr.getAll();
        ciudadList = ciudadMgr.getAll();
        ciudad = new Ciudad();
        barrio = new Barrio();
    }

    public String add() {
        try {
            if (null != cliente) {
                for (Cliente clie : clienteList) {
                    if ((cliente.getIdCliente() == null || cliente.getIdCliente() == 0)
                            && cliente.getNombre().trim().equalsIgnoreCase(clie.getNombre().trim())
                            && cliente.getApellido().trim().equalsIgnoreCase(clie.getApellido().trim())) {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Advertencia",
                                "El cliente " + cliente.getNombre() + " " + cliente.getApellido()
                                + " ya se encuentra registrado"));
                        RequestContext.getCurrentInstance().execute("PF('dlgClienteAdd').hide()");
                        return "cliente";
                    }
                }
                if (cliente != null & cliente.getIdCliente() == null) {
                    cliente.setFechaRegistro(new Date());
                    cliente.setIdUsuarioRegistro(session.getUsuario());
                    clienteMgr.add(cliente);
                    historialClienteController.addHistory(cliente);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se agregó correctamente",
                            "Cliente: " + cliente.getNombre() + " " + cliente.getApellido()));
                } else if (cliente != null & cliente.getIdCliente() > 0) {
                    cliente.setFechaActualizacion(new Date());
                    cliente.setIdUsuarioActualizacion(session.getUsuario());
                    cliente = clienteMgr.update(cliente);
                    historialClienteController.addHistory(cliente);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizó correctamente",
                            "Cliente: " + cliente.getNombre() + " " + cliente.getApellido()));
                }

                RequestContext.getCurrentInstance().execute("PF('dlgClienteAdd').hide()");
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar el cliente "));
            UtilLogger.error("Problemas al insertar el cliente", e);
        }
        return "cliente";
    }

    public String delete() {
        try {
            if (cliente.getIdCliente() > 0) {
                clienteMgr.delete(cliente);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se borró Cliente"));
                RequestContext.getCurrentInstance().update("clientecForm:dtCliente");
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar el cliente "));
            UtilLogger.error("Problemas al insertar el cliente", e);
        }
        return "cliente";
    }

    public void actionClean(ActionEvent actionEvent) {
        cliente = new Cliente();
        RequestContext.getCurrentInstance().update("clienteForm:dtCliente");
    }

    public void buscarBarrios() {
        barrioList = barrioMgr.getBarriosByCiudad(ciudad);
        RequestContext.getCurrentInstance().update("form-add:ClienteGr:barrio");
    }

//    public void onCellEdit(CellEditEvent event) {
//        Object oldValue = event.getOldValue();
//        Object newValue = event.getNewValue();
//        for (Cliente clien : clienteList) {
//            if (clien.getNombre().equals(oldValue.toString())) {
//                clien.setNombre(newValue.toString());
//                clienteMgr.update(clien);
//            }
//            if (clien.getApellido().equals(oldValue.toString())) {
//                clien.setApellido(newValue.toString());
//                clienteMgr.update(clien);
//            }
//            if (clien.getApellido().equals(oldValue.toString())) {
//                clien.setApellido(newValue.toString());
//                clienteMgr.update(clien);
//            }
//        }
//        RequestContext.getCurrentInstance().update("clienteForm:dtCliente");
//
//    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
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
