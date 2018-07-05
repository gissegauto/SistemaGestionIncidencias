/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.solicitudes.boundary;

import business.dao.GenericImpl;
import business.solicitudes.entity.HistorialSolicitudConexion;
import business.solicitudes.entity.SolicitudConexion;
import business.utils.UtilLogger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author ggauto
 */
@Stateless
public class HistorialSolicitudConexionManager extends GenericImpl<HistorialSolicitudConexion, Integer> {

    /**
     * Obtener Historial de Solicitud de Conexion mediante Id de Solicitud de Conexion
     *
     * @param solicitudConexion
     * @return 
     */
    public List<HistorialSolicitudConexion> getHistorialByIdSolicitud(SolicitudConexion solicitudConexion) {
        try {
            Query query = em.createNamedQuery("HistorialSolicitudConexion.findByIdSolicitudConexion").setParameter("idSolicitudConexion", solicitudConexion);
            return query.getResultList();
        } catch (Exception e) {
            UtilLogger.error(this.getClass().getName() + ".getHistorialByIdSolicitud", e);
            return null;
        }
    }

}