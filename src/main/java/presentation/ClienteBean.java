/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.cliente.boundary.ClienteManager;
import business.cliente.controller.ClienteController;
import business.cliente.entity.Cliente;
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
public class ClienteBean implements Serializable {

    private Cliente cliente;
    private List<Cliente> clienteList;
    FacesContext context = FacesContext.getCurrentInstance();
    @Inject
    ClienteManager clienteMgr;
    @Inject
    ClienteController clienteController;

    @PostConstruct
    public void init() {
        limpiar();
    }

    public void limpiar() {
        cliente = new Cliente();
        clienteList = clienteMgr.getAll();
    }

    public String add() {
        try {
            context = FacesContext.getCurrentInstance();
            if (null != cliente) {
                for (Cliente clie : clienteList) {
                    if ((cliente.getIdCliente() == null || cliente.getIdCliente() == 0)
                            && cliente.getNombre().trim().equalsIgnoreCase(clie.getNombre().trim())
                            && cliente.getApellido().trim().equalsIgnoreCase(clie.getApellido().trim())) {
                        context.addMessage(null, new FacesMessage("Advertencia",
                                "El cliente " + cliente.getNombre() + " " + cliente.getApellido()
                                + " ya se encuentra registrado"));
                        RequestContext.getCurrentInstance().execute("PF('dlgUsuAdd').hide()");
                        return "cliente";
                    }
                }
                if (cliente != null & cliente.getIdCliente() == null) {
                    cliente = clienteMgr.add(cliente);
                    context.addMessage(null, new FacesMessage("Se agregó correctamente",
                            "Cliente: " + cliente.getNombre() + " " + cliente.getApellido()));
                } else if (cliente != null & cliente.getIdCliente() > 0) {
                    cliente = clienteMgr.update(cliente);
                    context.addMessage(null, new FacesMessage("Se actualizó correctamente",
                            "Cliente: " + cliente.getNombre() + " " + cliente.getApellido()));
                }

                RequestContext.getCurrentInstance().execute("PF('dlgClienteAdd').hide()");
            }

        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar el cliente "));
            UtilLogger.error("Problemas al insertar el cliente", e);
        }
        return "cliente";
    }

    public String delete() {
        try {
            if (cliente.getIdCliente() > 0) {
                clienteMgr.delete(cliente);
                context.addMessage(null, new FacesMessage("Se borró Cliente"));
//                RequestContext.getCurrentInstance().update("clientecForm:dtCliente");
            }
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar el cliente "));
            UtilLogger.error("Problemas al insertar el cliente", e);
        }
        return "cliente";
    }

    public void actionClean(ActionEvent actionEvent) {
        cliente = new Cliente();
        RequestContext.getCurrentInstance().update("clienteForm:dtCliente");
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
        for (Cliente clien : clienteList) {
            if (clien.getNombre().equals(oldValue.toString())) {
                clien.setNombre(newValue.toString());
                clienteMgr.update(clien);
            }
            if (clien.getApellido().equals(oldValue.toString())) {
                clien.setApellido(newValue.toString());
                clienteMgr.update(clien);
            }
            if (clien.getApellido().equals(oldValue.toString())) {
                clien.setApellido(newValue.toString());
                clienteMgr.update(clien);
            }
        }
        RequestContext.getCurrentInstance().update("clienteForm:dtCliente");

    }

}
