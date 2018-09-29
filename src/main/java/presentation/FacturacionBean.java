/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.cliente.entity.Cliente;
import business.configuracion.boundary.ArticuloManager;
import business.configuracion.entity.Articulo;
import business.facturacion.boundary.FacturaDetalleManager;
import business.facturacion.boundary.FacturaManager;
import business.facturacion.entity.Factura;
import business.facturacion.entity.FacturaDetalle;
import business.solicitudes.entity.SolicitudConexion;
import business.utils.UtilLogger;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ggauto
 */
@Named
@SessionScoped
public class FacturacionBean implements Serializable {

    private List<Factura> facturaList;

    @Inject
    ArticuloManager precioMgr;
    @Inject
    FacturaManager facturaMgr;
    @Inject
    FacturaDetalleManager facturaDetalleMgr;
    @Inject
    LoginBean session;

    @PostConstruct
    public void init() {
        limpiar();
    }

    public void generarFacturaCliente(Cliente cliente, SolicitudConexion solicitudConexion) {
        try {
            Factura factura = new Factura();
            FacturaDetalle facturaDetalle = new FacturaDetalle();

            List<FacturaDetalle> facturaDetalleList = new ArrayList<>();
            facturaDetalle.setCantidad(1);
            facturaDetalle.setEstado("Activo");
            facturaDetalle.setIdServicio(solicitudConexion.getIdServicio());
            facturaDetalle.setPreUnitario(solicitudConexion.getIdServicio().getPrecio());
            facturaDetalleList.add(facturaDetalle);

            factura.setFacturaDetalleList(facturaDetalleList);
            factura.setCliente(cliente);
            factura.setTotal(solicitudConexion.getIdServicio().getPrecio());
            factura.setEstado("Pendiente");

            factura.setIdUsuarioRegistro(session.getUsuario());
            factura.setFecInsercion(new Date());
            facturaMgr.add(factura);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar generar la factura del cliente "));
            UtilLogger.error("Problemas al generar factura del cliente", e);
        }
    }

    public void limpiar() {
        facturaList = facturaMgr.getAll();
    }

    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

}
