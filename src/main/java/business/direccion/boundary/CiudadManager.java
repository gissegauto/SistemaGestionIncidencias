/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.direccion.boundary;

import business.dao.GenericImpl;
import business.direccion.entity.Ciudad;
import business.utils.UtilLogger;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author ggauto
 */
@Stateless
public class CiudadManager extends GenericImpl<Ciudad, Integer> {

    /**
     * Obtener Ciudad segun nombre de ciudad
     *
     * @param name
     * @return Ciudad
     */
    public Ciudad getByName(String name) {
        try {
            Query query = em.createNamedQuery("Ciudad.findByCiudad").setParameter("ciudad", name);
            return ((Ciudad) query.getSingleResult());
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName() + ".getByName", e);
            return null;
        }
    }
    
}
