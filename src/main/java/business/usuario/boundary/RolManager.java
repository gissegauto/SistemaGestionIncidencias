/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.usuario.boundary;

import business.dao.GenericImpl;
import business.usuario.entity.Rol;
import business.utils.UtilLogger;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author ggauto
 */
@Stateless
public class RolManager extends GenericImpl<Rol, Integer> {

    public Rol getByName(String name) {
        try {
            Query query = em.createNamedQuery("Rol.findByDescripcion").setParameter("descripcion", name);
            return ((Rol) query.getSingleResult());
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName() + ".getByName", e);
            return null;
        }
    }

}
