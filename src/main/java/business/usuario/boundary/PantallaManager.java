/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.usuario.boundary;

import business.usuario.entity.Pantalla;
import business.dao.GenericImpl;
import business.utils.UtilLogger;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author ggauto
 */
@Stateless
public class PantallaManager extends GenericImpl<Pantalla, Integer> {

    public Pantalla getByName(String name) {
        try {
            Query query = em.createNamedQuery("Pantalla.findByDescripcion").setParameter("descripcion", name);
            return ((Pantalla) query.getSingleResult());
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName() + ".getByName", e);
            return null;
        }
    }
}
