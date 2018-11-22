/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.usuario.boundary;

import business.dao.GenericImpl;
import business.usuario.entity.Usuario;
import business.utils.UtilLogger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author ggauto
 */
@Stateless
public class UsuarioManager extends GenericImpl<Usuario, Integer> {

    public Usuario getByName(String name) {
        try {
            Query query = em.createNamedQuery("Usuario.findByUsername").setParameter("username", name);
            Usuario usuario = (Usuario) query.getSingleResult();
            if (usuario != null) {
                return usuario;
            } else {
                return null;
            }
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName() + ".getByName", e);
            return null;
        }
    }
    
    
     /**
     * Obtener Lista de Usuario que no estén borrados
     * @return 
     */
    public List<Usuario> getByNotBorrado() {
        try {
            Query query = em.createQuery("SELECT c FROM Usuario c where c.estado <> 'Borrado' ");

            return ((List<Usuario>) query.getResultList());
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName() + ".getByNotBorrado", e);
            return null;
        }
    }

}
