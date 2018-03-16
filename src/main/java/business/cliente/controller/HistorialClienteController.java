/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.cliente.controller;

import business.cliente.boundary.HistorialClienteManager;
import business.cliente.entity.Cliente;
import business.cliente.entity.HistorialCliente;
import business.utils.UtilLogger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ggauto
 */
@Stateless
public class HistorialClienteController {

    @Inject
    HistorialClienteManager historialClienteManager;

    public void addHistory(Cliente cliente) {
        try {
            HistorialCliente history = new HistorialCliente();
            history.setNombre(cliente.getNombre());
            history.setApellido(cliente.getApellido());
            history.setSexo((cliente.getSexo() != null) ? cliente.getSexo() : null);
            history.setNroDocumento((cliente.getNroDocumento() != null) ? cliente.getNroDocumento() : null);
            history.setTipoDocumento((cliente.getTipoDocumento() != null) ? cliente.getTipoDocumento() : null);
            history.setFechaRegistro((cliente.getFechaRegistro() != null) ? cliente.getFechaRegistro() : null);
            history.setFechaActualizacion((cliente.getFechaActualizacion() != null) ? cliente.getFechaActualizacion() : null);
            history.setEstado((cliente.getEstado() != null) ? cliente.getEstado() : null);
            if (cliente.getIdBarrio() != null) {
                history.setIdBarrio(cliente.getIdBarrio().getIdBarrio());
            }
            if (cliente.getIdUsuarioRegistro() != null) {
                history.setIdUsuarioRegistro(cliente.getIdUsuarioRegistro().getIdusuario());
            }
            if (cliente.getIdUsuarioActualizacion() != null) {
                history.setIdUsuarioActualizacion(cliente.getIdUsuarioActualizacion().getIdusuario());
            }
            historialClienteManager.add(history);
            UtilLogger.info(HistorialClienteController.class + ".addHistory : Insertado correcatemente en histórico");
        } catch (Exception e) {
            UtilLogger.error(HistorialClienteController.class + ".addHistory : Al intentar agregar historial ", e);
        }
    }
}
