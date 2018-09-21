/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.cliente.entity.Cliente;
import business.direccion.boundary.CiudadManager;
import business.direccion.entity.Barrio;
import business.direccion.entity.Ciudad;
import business.facturacion.boundary.FacturaDetalleManager;
import business.facturacion.boundary.FacturaManager;
import business.facturacion.entity.Factura;
import java.io.Serializable;
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
public class FacturacionBean implements Serializable {

    private List<Factura> facturaList;

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
