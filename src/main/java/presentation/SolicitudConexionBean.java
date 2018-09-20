/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.cliente.boundary.ClienteManager;
import business.cliente.controller.HistorialClienteController;
import business.cliente.entity.Cliente;
import business.configuracion.boundary.ServicioManager;
import business.configuracion.entity.Servicio;
import business.direccion.boundary.BarrioManager;
import business.direccion.boundary.CiudadManager;
import business.direccion.entity.Barrio;
import business.direccion.entity.Ciudad;
import business.solicitudes.boundary.SolicitudConexionManager;
import business.solicitudes.entity.SolicitudConexion;
import business.utils.UtilLogger;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import java.util.List;
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
public class SolicitudConexionBean implements Serializable {
    
    private SolicitudConexion solicitudConexion;
    private List<SolicitudConexion> solicitudConexionList;
    private List<SolicitudConexion> solicitudConexionFilter;
    private List<Servicio> servicioList;
    private List<Servicio> servicioListSelected;
    private List<Ciudad> ciudadList;
    private Ciudad ciudad;
    private List<Barrio> barrioList;
    private boolean editar;
    private Cliente cliente;
    
    @Inject
    SolicitudConexionManager solicitudConexionMgr;
    @Inject
    ServicioManager servicioMgr;
    @Inject
    ClienteManager clienteMgr;
    @Inject
    HistorialClienteController historialClienteController;
    @Inject
    ClienteSolicitudBean clienteSolicitudBean;
    @Inject
    ClienteBean clienteBean;
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
        editar = false;
        solicitudConexion = new SolicitudConexion();
        servicioList = servicioMgr.getAll();
        ciudadList = ciudadMgr.getAll();
        solicitudConexionList = solicitudConexionMgr.getAll();
    }
    
    public void add() {
        try {
            if (null != solicitudConexion) {
                if (solicitudConexion.getIdSolicitudConexion() == null) {
                    if (!servicioListSelected.isEmpty()) {
                        for (Servicio servicio : servicioListSelected) {
                            solicitudConexion.setIdServicio(servicio);
                            solicitudConexion.setFechaRegistro(new Date());
                            solicitudConexion.setIdUsuarioRegistro(session.getUsuario());
                            solicitudConexion.setEstado("Pendiente");
                            solicitudConexion = solicitudConexionMgr.add(solicitudConexion);
                            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se agregó correctamente",
                                    "Solicitud de Conexión Nro: " + solicitudConexion.getIdSolicitudConexion()));
                        }
                        RequestContext.getCurrentInstance().update("solicitudConexionForm:dtSolicitudConexion");
                        limpiar();
                    }
                }

                // else if (solicitudConexion.getIdSolicitudConexion() > 0) {
//                    solicitudConexion.setFechaActualizacion(new Date());
//                    solicitudConexion.setIdUsuarioActualizacion(session.getUsuario());
//                    solicitudConexion = solicitudConexionMgr.update(solicitudConexion);
//                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizó correctamente",
//                            "Solicitud de Conexión nro: " + solicitudConexion.getIdSolicitudConexion()));
//                }
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar la solicitud de conexión "));
            UtilLogger.error("Problemas al insertar la solicitud de conexión", e);
        }
//        return "solicitudConexion";
    }
    
    public String desactivar() {
        try {
            solicitudConexion.setEstado("Desactivado");
            solicitudConexionMgr.update(solicitudConexion);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se desactivó la Solicitud de Conexion"));
            RequestContext.getCurrentInstance().update("solicitudConexionForm:dtSolicitudConexion");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar desactivar la solicitud de conexión"));
            UtilLogger.error("Problemas al desactivar la solicitud de conexión", e);
            return null;
        }
        return "solicitudConexion";
    }
    
    public String clienteSolicitud(SolicitudConexion solicitudC) {
        clienteSolicitudBean.setSolicitudConexion(solicitudC);
        return "clienteSolicitud";
    }
    
    public void addCliente(SolicitudConexion solicitudC) {
        Cliente cli = new Cliente();
        cli.setNombre(solicitudC.getNombre());
        cli.setApellido(solicitudC.getApellido());
        cli.setCelular(solicitudC.getCelular());
        cli.setDireccion(solicitudC.getDireccion());
        cli.setIdBarrio(solicitudC.getIdBarrio() != null ? solicitudC.getIdBarrio() : null);
        clienteBean.limpiar();
        clienteBean.setCliente(cli);
        clienteBean.setSolicitudConexion(solicitudC);
        RequestContext.getCurrentInstance().execute("PF('dlgClienteAdd').show()");
    }
    
    public void changeStatusFinalizado(SolicitudConexion solicitudConexion) {
        solicitudConexion.setIdUsuarioActualizacion(session.getUsuario());
        solicitudConexion.setFechaActualizacion(new Date());
        solicitudConexion.setEstado("Finalizado");
        solicitudConexionMgr.update(solicitudConexion);
        limpiar();
        RequestContext.getCurrentInstance().update("solicitudConexionForm:dtSolicitudConexion");
    }
    
    public void cargarClienteSolicitud() {
//        this.solicitudConexion = solicitudC;
        RequestContext.getCurrentInstance().update("form-add:solicitudConexionGr");
    }
    
    public void buscarBarrios() {
        barrioList = barrioMgr.getBarriosByCiudad(ciudad);
    }
    
    public void actionClean() {
        this.solicitudConexion = new SolicitudConexion();
        RequestContext.getCurrentInstance().update("solicitudConexionForm:dtSolicitudConexion");
    }
    
    public void edicion() {
        editar = true;
    }
    
    public void agregar() {
        limpiar();
    }
    
    public SolicitudConexion getSolicitudConexion() {
        return solicitudConexion;
    }
    
    public void setSolicitudConexion(SolicitudConexion solicitudConexion) {
        this.solicitudConexion = solicitudConexion;
    }
    
    public List<SolicitudConexion> getSolicitudConexionList() {
        return solicitudConexionList;
    }
    
    public void setSolicitudConexionList(List<SolicitudConexion> solicitudConexionList) {
        this.solicitudConexionList = solicitudConexionList;
    }
    
    public List<Servicio> getServicioList() {
        return servicioList;
    }
    
    public void setServicioList(List<Servicio> servicioList) {
        this.servicioList = servicioList;
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
    
    public List<Servicio> getServicioListSelected() {
        return servicioListSelected;
    }
    
    public void setServicioListSelected(List<Servicio> servicioListSelected) {
        this.servicioListSelected = servicioListSelected;
    }
    
    public List<SolicitudConexion> getSolicitudConexionFilter() {
        return solicitudConexionFilter;
    }
    
    public void setSolicitudConexionFilter(List<SolicitudConexion> solicitudConexionFilter) {
        this.solicitudConexionFilter = solicitudConexionFilter;
    }
    
    public boolean isEditar() {
        return editar;
    }
    
    public void setEditar(boolean editar) {
        this.editar = editar;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
