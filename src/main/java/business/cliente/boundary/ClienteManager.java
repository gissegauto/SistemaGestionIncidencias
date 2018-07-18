/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.cliente.boundary;

import business.direccion.boundary.*;
import business.dao.GenericImpl;
import business.cliente.entity.Cliente;
import business.utils.UtilLogger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author ggauto
 */
@Stateless
public class ClienteManager extends GenericImpl<Cliente, Integer> {

    /**
     * Obtener Cliente segun nombre
     *
     * @param name
     * @return Barrio
     */
    public Cliente getByName(String name) {
        try {
            Query query = em.createNamedQuery("Cliente.findByNombre").setParameter("nombre", name);
            return ((Cliente) query.getSingleResult());
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName() + ".getByName", e);
            return null;
        }
    }

}
