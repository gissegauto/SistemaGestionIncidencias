/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.direccion.boundary;

import business.dao.GenericImpl;
import business.direccion.entity.Departamento;
import business.utils.UtilLogger;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author ggauto
 */
@Stateless
public class DepartamentoManager extends GenericImpl<Departamento, Integer> {

    public Departamento getByName(String name) {
        try {
            Query query = em.createNamedQuery("Departamento.findByDepartamento")
                    .setParameter("departamento", name);
            return ((Departamento) query.getSingleResult());
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName() + ".getByName", e);
            return null;
        }
    }
}
