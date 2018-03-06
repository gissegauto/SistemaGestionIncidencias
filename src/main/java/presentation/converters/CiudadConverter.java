/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.converters;

import business.direccion.boundary.CiudadManager;
import business.direccion.entity.Ciudad;
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
@FacesConverter(value = "ciudadConverter")
public class CiudadConverter implements Converter {

    private CiudadManager ciudadMgr;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.equals("")) {
            return null;
        }

        try {
            ciudadMgr = CDI.current().select(CiudadManager.class).get();
            Ciudad ciudad = ciudadMgr.getByName(value);
            return ciudad;
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
            if (o instanceof Ciudad) {
                Ciudad ciudad = (Ciudad) o;
                return ciudad.getCiudad();
            } else {
                return null;
            }

        } catch (Exception e) {
            UtilLogger.error("CLASS " + this.getClass().getName() + " METHOD: getAsString ", e);
            return null;
        }
    }

}
