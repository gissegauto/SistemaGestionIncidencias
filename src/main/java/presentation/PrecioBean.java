/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.configuracion.boundary.PrecioManager;
import business.configuracion.entity.Precio;
import java.io.Serializable;
import java.util.ArrayList;
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
public class PrecioBean implements Serializable {

    private Precio precio;
    private List<Precio> precioList;

    @Inject
    PrecioManager precioMgr;
    @Inject
    LoginBean session;

    @PostConstruct
    public void init() {
        limpiar();
    }

    public void limpiar() {
        precio = new Precio();
        precioList = precioMgr.getByNotBorrado();
    }

    public void delete(Precio precio) {
        precio.setEstado("Borrado");
        precioMgr.update(precio);
        limpiar();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se borró el registro"));
        RequestContext.getCurrentInstance().update("precioForm:dtPrecio");
    }

    public void actionClean(ActionEvent actionEvent) {
        this.precio = new Precio();
        RequestContext.getCurrentInstance().update("precioForm:dtPrecio");
    }

    public Precio getPrecio() {
        return precio;
    }

    public void setPrecio(Precio precio) {
        this.precio = precio;
    }

    public List<Precio> getPrecioList() {
        return precioList;
    }

    public void setPrecioList(List<Precio> precioList) {
        this.precioList = precioList;
    }

}
