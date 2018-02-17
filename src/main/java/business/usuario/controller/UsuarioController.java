/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.usuario.controller;

import business.usuario.boundary.UsuarioManager;
import business.usuario.entity.Usuario;
import business.utils.MD5Generator;
import business.utils.UtilLogger;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author cbustamante
 */
@Stateless
public class UsuarioController {

    @Inject
    UsuarioManager usuarioMgr;

    public Usuario authenticate(String username, String password) {
        try {
            @SuppressWarnings("unchecked")
            List<Usuario> listaUsuarios = usuarioMgr.getAll();
            @SuppressWarnings("rawtypes")

            String newPassword = MD5Generator.MD5(password);

            for (Usuario us : listaUsuarios) {
                if (us.getPassword().equals(newPassword) & us.getUsername().equals(username)) {
                    return us;
                }

            }
            return null;
        } catch (Exception ex) {
            UtilLogger.error("UsuarioController.authenticate", ex);
            return null;
        }
    }
}
