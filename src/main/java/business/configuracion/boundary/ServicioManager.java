/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.configuracion.boundary;

import business.configuracion.entity.Servicio;
import business.dao.GenericImpl;
import business.utils.UtilLogger;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author ggauto
 */
@Stateless
public class ServicioManager extends GenericImpl<Servicio, Integer> {

     /**
     * Obtener Servicio segun nombre
     *
     * @param name
     * @return Servicio
     */
    public Servicio getByName(String name) {
        try {
            Query query = em.createNamedQuery("Servicio.findByServicio").setParameter("servicio", name);
            return ((Servicio) query.getSingleResult());
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName() + ".getByName", e);
            return null;
        }
    }
    
}
