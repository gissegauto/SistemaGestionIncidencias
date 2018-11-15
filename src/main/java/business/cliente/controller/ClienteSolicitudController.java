/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.cliente.controller;

import business.cliente.boundary.ClienteSolicitudManager;
import business.cliente.entity.Cliente;
import business.cliente.entity.ClienteSolicitud;
import business.solicitudes.entity.SolicitudConexion;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ggauto
 */
@Stateless
public class ClienteSolicitudController {

    @Inject
    ClienteSolicitudManager clienteSolicitudMgr;
    

    public void insertarClienteSolicitud(SolicitudConexion solicitudConexion, Cliente cliente) {
        ClienteSolicitud clienteSolicitud = new ClienteSolicitud();
        clienteSolicitud.setIdCliente(cliente);
        clienteSolicitud.setIdSolicitudConexion(solicitudConexion);
        clienteSolicitudMgr.add(clienteSolicitud);
    }

}
