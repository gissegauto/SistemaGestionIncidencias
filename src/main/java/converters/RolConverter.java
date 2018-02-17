/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;


import business.usuario.entity.Rol;
import business.utils.UtilLogger;
import java.util.List;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import presentation.RolBean;

/**
 *
 * @author cbustamante
 */
@FacesConverter(value = "rolConverter")
public class RolConverter implements Converter {
     private RolBean rolesBean;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.equals("")) {

            return null;
        }
        try {

            rolesBean = CDI.current().select(RolBean.class).get();

            List<Rol> listaRol  = rolesBean.getRolList();
            for (Rol rol : listaRol)
            {
                if (rol.getDescripcion().equals(value))
                {
                    return rol;
                }
            }
            Rol rol = new Rol();
            rol.setDescripcion("NN");
            rol.setIdrol(null);
            
            return rol;
        } catch (Exception e) {
            UtilLogger.error("CLASS " + this.getClass().getName() + " METHOD: getAsObject ", e);
           Rol rol = new Rol();
            rol.setDescripcion("NN");
            rol.setIdrol(null);
            return rol;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object o) {

        if (o == null || o.equals("")) {
            return null;
        }
        try {
            if (o instanceof Rol) {
                Rol rol = (Rol) o;
                return rol.getDescripcion();
            } else {
                return null;
            }

        } catch (Exception e) {

            UtilLogger.error("CLASS " + this.getClass().getName() + " METHOD: getAsString ", e);
            return null;
        }

    }
    
}
