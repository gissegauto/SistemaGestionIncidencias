/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.configuracion.boundary;

import business.configuracion.entity.Servicio;
import business.dao.GenericImpl;
import business.utils.UtilLogger;
import java.util.List;
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

    /**
     * Obtener Lista de Servicio que no tengan estado borrado
     *
     * @return
     */
    public List<Servicio> getByNotDelete() {
        try {
            Query query = em.createQuery("SELECT c FROM Servicio c where c.estado <> 'Borrado' ");

            return ((List<Servicio>) query.getResultList());
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName() + ".getByNotDelete", e);
            return null;
        }
    }
    
    
    
    /**
     * Obtener Lista de Servicio que tengan estado activo
     *
     * @return
     */
    public List<Servicio> getByEstadoActivo() {
        try {
            Query query = em.createQuery("SELECT c FROM Servicio c where c.estado = 'Activo' ");

            return ((List<Servicio>) query.getResultList());
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName() + ".getByEstadoActivo", e);
            return null;
        }
    }

}
