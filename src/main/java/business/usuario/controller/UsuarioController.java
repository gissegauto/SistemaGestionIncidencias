/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.usuario.controller;

import business.funcionario.boundary.FuncionarioManager;
import business.funcionario.entity.Funcionario;
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
    @Inject
    FuncionarioManager funcionarioMgr;

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

    /**
     * Actualizar Password de MI CUENTA
     *
     * @param usuario
     * @param newPass
     * @return
     */
    public Usuario actualizarPassword(Usuario usuario, String newPass) {
        try {
            usuario.setPassword(MD5Generator.MD5(newPass));
            return usuarioMgr.update(usuario);
        } catch (Exception ex) {
            UtilLogger.error("UsuarioController.actualizarPassword", ex);
            return usuario;
        }
    }

    /**
     * Resetear Password de un Usuario
     *
     * @param usuario
     * @return
     */
    public Usuario resetearPassword(Usuario usuario) {
        try {
            String newPassword = MD5Generator.MD5("12345");
            usuario.setPassword(newPassword);
            return usuarioMgr.update(usuario);
        } catch (Exception ex) {
            UtilLogger.error("UsuarioController.resetearPassword", ex);
            return usuario;
        }
    }

    public boolean actualizarDatosPersonales(Funcionario funcionario) {
        try {
            funcionario = funcionarioMgr.update(funcionario);
            return true;
        } catch (Exception ex) {
            UtilLogger.error("UsuarioController.actualizarDatosPersonales", ex);
            return false;
        }
    }
}
