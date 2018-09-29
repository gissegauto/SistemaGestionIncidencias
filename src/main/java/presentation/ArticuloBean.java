/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.configuracion.boundary.ArticuloManager;
import business.configuracion.entity.Articulo;
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
public class ArticuloBean implements Serializable {

    private Articulo articulo;
    private List<Articulo> articuloList;

    @Inject
    ArticuloManager articuloMgr;
    @Inject
    LoginBean session;

    @PostConstruct
    public void init() {
        limpiar();
    }

    public void limpiar() {
        articulo = new Articulo();
        articuloList = articuloMgr.getByNotDelete();
    }

    
    public void add() {
    }
    
    
    public void delete(Articulo articulo) {
        articulo.setEstado("Borrado");
        articuloMgr.update(articulo);
        limpiar();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se borró el registro"));
        RequestContext.getCurrentInstance().update("articuloForm:dtArticulo");
    }

    public void actionClean(ActionEvent actionEvent) {
        this.articulo = new Articulo();
        RequestContext.getCurrentInstance().update("articuloForm:dtArticulo");
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public List<Articulo> getArticuloList() {
        return articuloList;
    }

    public void setArticuloList(List<Articulo> articuloList) {
        this.articuloList = articuloList;
    }

}
