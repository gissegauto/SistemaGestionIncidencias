/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.usuario.boundary;

import business.dao.GenericImpl;
import business.usuario.entity.Rol;
import business.usuario.entity.RolPantalla;
import business.utils.UtilLogger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author ggauto
 */
@Stateless
public class RolPantallaManager extends GenericImpl<RolPantalla, Integer>{
    
     public List<RolPantalla> getRolesByRolesPantallas(Rol rol)
   {
        try {            
            Query query = em.createQuery("SELECT r FROM RolPantalla r WHERE r.idrol.idrol =:idrol")
                    .setParameter("idrol", rol.getIdrol());
            
            return ((List<RolPantalla>) query.getResultList());
            
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName()+ ".getByNombre", e);
            return null;
        }   
   }
}
