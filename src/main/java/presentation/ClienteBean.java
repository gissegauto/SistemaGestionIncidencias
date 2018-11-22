/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.cliente.boundary.ClienteManager;
import business.cliente.boundary.ClienteSolicitudManager;
import business.cliente.controller.ClienteController;
import business.cliente.controller.HistorialClienteController;
import business.cliente.entity.Cliente;
import business.direccion.boundary.BarrioManager;
import business.direccion.boundary.CiudadManager;
import business.direccion.entity.Barrio;
import business.direccion.entity.Ciudad;
import business.solicitudes.entity.SolicitudConexion;
import business.utils.UtilLogger;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FlowEvent;
import org.primefaces.model.UploadedFile;

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
    private String city;
    private List<Barrio> barrioList;
    private Barrio barrio;
    private boolean editar;
    private boolean skip;
    private UploadedFile file;
    private SolicitudConexion solicitudConexion;
    private Map<String, String> cities;
    @Inject
    ClienteManager clienteMgr;
    @Inject
    ClienteSolicitudManager clienteSolicitudMgr;
    @Inject
    HistorialClienteController historialClienteController;
    @Inject
    ClienteController clienteController;
    @Inject
    SolicitudConexionBean solicitudConexionBean;
    @Inject
    ClienteSolicitudBean clienteSolicitudBean;
    @Inject
    BarrioManager barrioMgr;
    @Inject
    CiudadManager ciudadMgr;
    @Inject
    LoginBean session;

    @PostConstruct
    public void init() {
        limpiar();
        cities = new HashMap<String, String>();
        ciudadList = ciudadMgr.getAll();
        for (Ciudad ciudad : ciudadList) {
            cities.put(ciudad.getCiudad(), ciudad.getCiudad());
        }

    }

    public void limpiar() {
        editar = false;
        cliente = new Cliente();
        clienteList = clienteMgr.getByNotBorrado();
        ciudadList = ciudadMgr.getAll();
        ciudad = new Ciudad();
        barrio = new Barrio();
    }

    public String add() {
        try {
            if (null != cliente) {
                for (Cliente clie : clienteList) {
                    if ((cliente.getIdCliente() == null || cliente.getIdCliente() == 0)
                            && cliente.getNroDocumento().trim().equalsIgnoreCase(clie.getNroDocumento().trim())) {
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Advertencia",
                                "El cliente " + cliente.getNombre() + " " + cliente.getApellido()
                                + " ya se encuentra registrado"));
                        RequestContext.getCurrentInstance().execute("PF('dlgClienteAdd').hide()");
                        return "cliente";
                    }
                }
                if (cliente.getIdCliente() == null) {
                    cliente.setFechaRegistro(new Date());
                    cliente.setIdUsuarioRegistro(session.getUsuario());
                    cliente.setEstado("Activo");
                    cliente = clienteMgr.add(cliente);
                    historialClienteController.addHistory(cliente);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Se agregó correctamente",
                            "Cliente: " + cliente.getNombre() + " " + cliente.getApellido()));
                } else if (cliente.getIdCliente() > 0) {
                    cliente.setFechaActualizacion(new Date());
                    cliente.setIdUsuarioActualizacion(session.getUsuario());
                    cliente = clienteMgr.update(cliente);
                    historialClienteController.addHistory(cliente);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Se actualizó correctamente",
                            "Cliente: " + cliente.getNombre() + " " + cliente.getApellido()));
                }
                limpiar();
                RequestContext.getCurrentInstance().execute("PF('dlgClienteAdd').hide()");
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar el cliente "));
            UtilLogger.error("Problemas al insertar el cliente", e);
        }
        return "cliente";
    }

    public void addCliente() {
        try {
            if (null != cliente) {
                if (cliente != null & cliente.getIdCliente() == null) {
                    cliente.setFechaRegistro(new Date());
                    cliente.setIdUsuarioRegistro(session.getUsuario());
                    cliente.setEstado("Activo");
                    cliente = clienteMgr.add(cliente);
                    historialClienteController.addHistory(cliente);

                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Se agregó correctamente",
                            "Cliente: " + cliente.getNombre() + " " + cliente.getApellido()));
                }
                limpiar();
                RequestContext.getCurrentInstance().execute("PF('dlgClienteAdd').hide()");
                solicitudConexionBean.changeStatusFinalizado(solicitudConexion);
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error",
                    "Ocurrió un error al intentar guardar el cliente "));
            UtilLogger.error("Problemas al insertar el cliente", e);
        }
    }

    public String solicitudes(Cliente cliente) {
        clienteSolicitudBean.setCliente(cliente);
        clienteSolicitudBean.setSolicitudes(clienteSolicitudMgr.getByCliente(cliente));
        return "solicitudes";
    }

    public void delete(Cliente cliente) {
        try {
            cliente.setEstado("Borrado");
            clienteMgr.update(cliente);
            limpiar();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se borró Cliente"));
            RequestContext.getCurrentInstance().update("clienteForm:dtCliente");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error",
                    "Ocurrió un error al intentar guardar el cliente "));
            UtilLogger.error("Problemas al insertar el cliente", e);
        }
    }

    public void handleFileUpload(FileUploadEvent event) throws Exception {
        event.getFile().write("/home/ggauto/Escritorio");
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void edicion() {
        editar = true;
    }

    public void actionClean(ActionEvent actionEvent) {
        cliente = new Cliente();
        RequestContext.getCurrentInstance().update("clienteForm:dtCliente");
    }

    public void desactivarCliente(Cliente cliente) {
        clienteController.cambiarEstado(cliente, session.getUsuario(), "Inactivo");
        limpiar();
        RequestContext.getCurrentInstance().update("clienteForm:dtCliente");
    }

    public void activarCliente(Cliente cliente) {
        clienteController.cambiarEstado(cliente, session.getUsuario(), "Activo");
        limpiar();
        RequestContext.getCurrentInstance().update("clienteForm:dtCliente");
    }

    public void editCliente(Cliente cli) {
        ciudad = new Ciudad();
        barrioList = new ArrayList<>();
        if (cli.getIdBarrio() != null) {
            ciudad = cli.getIdBarrio().getIdCiudad();
            buscarBarrios();
        }
        cliente = cli;
    }

    public void upload() {
        if (file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }

    public void buscarBarrios() {
        if (city != null) {
            ciudad = ciudadMgr.getByName(city);
            barrioList = barrioMgr.getBarriosByCiudad(ciudad);
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Al seleccionar ciudad. Intente de nuevo"));
        }
    }

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

    public boolean isEditar() {
        return editar;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public SolicitudConexion getSolicitudConexion() {
        return solicitudConexion;
    }

    public void setSolicitudConexion(SolicitudConexion solicitudConexion) {
        this.solicitudConexion = solicitudConexion;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Map<String, String> getCities() {
        return cities;
    }

    public void setCities(Map<String, String> cities) {
        this.cities = cities;
    }

}
