/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.funcionario.boundary;

import business.dao.GenericImpl;
import business.funcionario.entity.Funcionario;
import business.utils.UtilLogger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author ggauto
 */
@Stateless
public class FuncionarioManager extends GenericImpl<Funcionario, Integer> {

    /**
     * Obtener Funcionario segun nombre
     *
     * @param name
     * @return Funcionario
     */
    public Funcionario getByName(String name) {
        try {
            Query query = em.createNamedQuery("Funcionario.findByNombreFuncionario").setParameter("nombreFuncionario", name);
            return ((Funcionario) query.getSingleResult());
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName() + ".getByName", e);
            return null;
        }
    }

    /**
     * Obtener Lista de Funcionarios que sean Tecnicos
     * @return 
     */
    public List<Funcionario> getByTecnico() {
        try {
            Query query = em.createQuery("SELECT f FROM Funcionario f where f.tecnico = 'SI' and f.estado = 'Activo' ");

            return ((List<Funcionario>) query.getResultList());
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName() + ".getByTecnico", e);
            return null;
        }
    }
    
    
    /**
     * Obtener Lista de Funcionarios que no estén borrados
     * @return 
     */
    public List<Funcionario> getByNotBorrado() {
        try {
            Query query = em.createQuery("SELECT c FROM Funcionario c where c.estado <> 'Borrado' ");

            return ((List<Funcionario>) query.getResultList());
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName() + ".getByNotBorrado", e);
            return null;
        }
    }

}
