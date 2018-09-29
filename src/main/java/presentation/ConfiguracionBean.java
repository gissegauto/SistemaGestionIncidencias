/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.cliente.entity.Cliente;
import business.configuracion.boundary.ConfiguracionManager;
import business.configuracion.entity.Configuracion;
import business.direccion.entity.Barrio;
import business.direccion.entity.Ciudad;
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
public class ConfiguracionBean implements Serializable {
    
    private Configuracion configuracion;
    @Inject
    ConfiguracionManager configuracionMgr;
    @Inject
    LoginBean session;
    
    @PostConstruct
    public void init() {
        limpiar();
    }
    
    public void limpiar() {
        List<Configuracion> configuracionList = configuracionMgr.getAll();
        configuracion = configuracionList.get(configuracionList.size() - 1);
    }
    
    public Configuracion getConfiguracion() {
        return configuracion;
    }
    
    public void setConfiguracion(Configuracion configuracion) {
        this.configuracion = configuracion;
    }
    
}
