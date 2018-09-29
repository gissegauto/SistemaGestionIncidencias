/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.configuracion.boundary;

import business.cliente.entity.Cliente;
import business.configuracion.entity.Precio;
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
public class PrecioManager extends GenericImpl<Precio, Integer> {

     /**
     * Obtener Lista de Precio que no tengan estado borrado
     * @return 
     */
    public List<Precio> getByNotBorrado() {
        try {
            Query query = em.createQuery("SELECT c FROM Precio c where c.estado <> 'Borrado' ");

            return ((List<Precio>) query.getResultList());
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName() + ".getByNotBorrado", e);
            return null;
        }
    }
    
    
     /**
     * Obtener Precio segun descripcion
     *
     * @param descripcion
     * @return 
     */
    public Precio getByDescripcion(String descripcion) {
        try {
            Query query = em.createNamedQuery("Precio.findByDescripcion").setParameter("descripcion", descripcion);
            return ((Precio) query.getSingleResult());
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName() + ".getByDescripcion", e);
            return null;
        }
    }
}
