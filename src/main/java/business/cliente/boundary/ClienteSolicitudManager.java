/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.cliente.boundary;

import business.cliente.entity.Cliente;
import business.dao.GenericImpl;
import business.cliente.entity.ClienteSolicitud;
import business.utils.UtilLogger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author ggauto
 */
@Stateless
public class ClienteSolicitudManager extends GenericImpl<ClienteSolicitud, Integer> {

    
    
    /**
     * Obtener Solicitudes de un cliente
     *
     * @param cliente
     * @return List<>
     */
    public List<ClienteSolicitud> getByCliente(Cliente cliente) {
        try {
            Query query = em.createQuery("SELECT s FROM ClienteSolicitud s where s.idCliente = :c ").setParameter("c", cliente);
            return ((List<ClienteSolicitud>) query.getResultList());
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName() + ".getByCliente", e);
            return null;
        }
    }
    
    
    
}
