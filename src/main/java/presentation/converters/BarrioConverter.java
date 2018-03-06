/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.converters;

import business.direccion.boundary.BarrioManager;
import business.direccion.entity.Barrio;
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
@FacesConverter(value = "barrioConverter")
public class BarrioConverter implements Converter {

    private BarrioManager barrioMgr;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.equals("")) {
            return null;
        }
        
        try {
            barrioMgr = CDI.current().select(BarrioManager.class).get();
            Barrio barrio = barrioMgr.getByName(value);
            return barrio;
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
            if (o instanceof Barrio) {
                Barrio barrio = (Barrio) o;
                return barrio.getBarrio();
            } else {
                return null;
            }

        } catch (Exception e) {
            UtilLogger.error("CLASS " + this.getClass().getName() + " METHOD: getAsString ", e);
            return null;
        }
    }

}