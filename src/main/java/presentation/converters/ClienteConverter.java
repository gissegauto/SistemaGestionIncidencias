/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.converters;

import business.cliente.boundary.ClienteManager;
import business.cliente.entity.Cliente;
import business.utils.UtilLogger;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author ggauto
 */
@FacesConverter(value = "clienteConverter")
public class ClienteConverter implements Converter {

    private ClienteManager clienteMgr;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.equals("")) {
            return null;
        }

        try {
            clienteMgr = CDI.current().select(ClienteManager.class).get();
            Cliente cliente = clienteMgr.getByName(value);
            return cliente;
        } catch (Exception e) {
            UtilLogger.error("CLASS " + this.getClass().getName() + " METHOD: getAsObject ", e);
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object o) {
        if (o == null || o.equals("")) {
            return null;
        }
        try {
            if (o instanceof Cliente) {
                Cliente cliente = (Cliente) o;
                return cliente.getNombre() + " " + cliente.getApellido();
            } else {
                return null;
            }

        } catch (Exception e) {
            UtilLogger.error("CLASS " + this.getClass().getName() + " METHOD: getAsString ", e);
            return null;
        }
    }

}
