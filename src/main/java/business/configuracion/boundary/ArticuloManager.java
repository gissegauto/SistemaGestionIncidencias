/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.configuracion.boundary;

import business.configuracion.entity.Articulo;
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
public class ArticuloManager extends GenericImpl<Articulo, Integer> {

     /**
     * Obtener Lista de Articulo que no tengan estado borrado
     * @return 
     */
    public List<Articulo> getByNotDelete() {
        try {
            Query query = em.createQuery("SELECT c FROM Articulo c where c.estado <> 'Borrado' ");

            return ((List<Articulo>) query.getResultList());
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName() + ".getByNotDelete", e);
            return null;
        }
    }
    
    
     /**
     * Obtener Articulo segun descripcion
     *
     * @param descripcion
     * @return 
     */
    public Articulo getByDescripcion(String descripcion) {
        try {
            Query query = em.createNamedQuery("Articulo.findByDescripcion").setParameter("descripcion", descripcion);
            return ((Articulo) query.getSingleResult());
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName() + ".getByDescripcion", e);
            return null;
        }
    }
}
