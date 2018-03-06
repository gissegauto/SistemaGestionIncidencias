/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.direccion.boundary;

import business.dao.GenericImpl;
import business.direccion.entity.Barrio;
import business.direccion.entity.Ciudad;
import business.utils.UtilLogger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author ggauto
 */
@Stateless
public class BarrioManager extends GenericImpl<Barrio, Integer> {

     /**
     * Obtener Barrio segun nombre de barrio
     *
     * @param name
     * @return Barrio
     */
    public Barrio getByName(String name) {
        try {
            Query query = em.createNamedQuery("Barrio.findByBarrio").setParameter("barrio", name);
            return ((Barrio) query.getSingleResult());
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName() + ".getByName", e);
            return null;
        }
    }
    
    /**
     * Obtener Barrios segun nombre de ciudad
     *
     * @param ciudad
     * @return List<Barrio>
     */
    public List<Barrio> getBarriosByCiudad(Ciudad ciudad) {
        try {
            Query query = em.createNamedQuery("Barrio.findByCiudad").setParameter("idCiudad", ciudad);
            return (List<Barrio>) query.getResultList();
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName() + ".getBarriosByCiudad", e);
            return null;
        }
    }
}
