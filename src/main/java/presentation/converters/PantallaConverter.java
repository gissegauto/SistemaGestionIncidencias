/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.converters;

import business.usuario.boundary.PantallaManager;
import business.usuario.entity.Pantalla;
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
@FacesConverter(value = "pantallaConverter")
public class PantallaConverter implements Converter {

    private PantallaManager pantallaMgr;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.equals("")) {
            return null;
        }
        
        try {
            pantallaMgr = CDI.current().select(PantallaManager.class).get();
            Pantalla pantalla = pantallaMgr.getByName(value);
            return pantalla;
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
            if (o instanceof Pantalla) {
                Pantalla pantalla = (Pantalla) o;
                return pantalla.getDescripcion();
            } else {
                return null;
            }

        } catch (Exception e) {
            UtilLogger.error("CLASS " + this.getClass().getName() + " METHOD: getAsString ", e);
            return null;
        }
    }

}
