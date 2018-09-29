/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.configuracion.boundary.ArticuloManager;
import business.configuracion.entity.Articulo;
import business.configuracion.entity.Articulo;
import business.utils.UtilLogger;
import java.io.Serializable;
import java.util.ArrayList;
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

    public String add() {
        try {
            if (null != articulo) {
                if (articulo != null & articulo.getIdArticulo() == null) {
                    if (articulo.getCantidad() > 0) {
                        articulo.setEstado("En Stock");
                    } else {
                        articulo.setEstado("En Falta");
                    }
                    articulo.setUsuInsercion(session.getUsuario());
                    articulo.setFecInsercion(new Date());
                    articulo = articuloMgr.add(articulo);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se agregó correctamente",
                            "Articulo: " + articulo.getDescripcion()));
                } else if (articulo != null & articulo.getIdArticulo() > 0) {
                    articulo = articuloMgr.update(articulo);
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizó correctamente",
                            "Articulo: " + articulo.getDescripcion()));
                }
                limpiar();
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar el articulo "));
            UtilLogger.error("Problemas al insertar el articulo", e);
        }
        return "articulo";
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
