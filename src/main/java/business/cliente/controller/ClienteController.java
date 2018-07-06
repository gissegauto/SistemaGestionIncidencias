/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.cliente.controller;

import business.cliente.boundary.ClienteManager;
import business.cliente.entity.Cliente;
import business.usuario.entity.Usuario;
import java.util.Date;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ggauto
 */
@Stateless
public class ClienteController {

    @Inject
    ClienteManager clienteMgr;
    
    @Inject
    HistorialClienteController historialClienteController;

    public void cambiarEstado(Cliente cliente, Usuario usuario, String estado) {
        cliente.setEstado(estado);
        cliente.setFechaActualizacion(new Date());
        cliente.setIdUsuarioActualizacion(usuario);
        cliente = clienteMgr.update(cliente);
        historialClienteController.addHistory(cliente);
    }

}
