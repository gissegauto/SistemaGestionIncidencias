/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.direccion.boundary;

import business.dao.GenericImpl;
import business.direccion.entity.Pais;
import business.utils.UtilLogger;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author ggauto
 */
@Stateless
public class PaisManager extends GenericImpl<Pais, Integer> {

    /**
     * Obtener Pais segun nombre de pais
     *
     * @param name
     * @return Pais
     */
    public Pais getByName(String name) {
        try {
            Query query = em.createNamedQuery("Pais.findByNombre").setParameter("nombre", name);
            return ((Pais) query.getSingleResult());
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName() + ".getByName", e);
            return null;
        }
    }
}
