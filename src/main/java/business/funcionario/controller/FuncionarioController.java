/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.funcionario.controller;

import business.funcionario.boundary.FuncionarioManager;
import business.funcionario.entity.Funcionario;
import business.usuario.entity.Usuario;
import java.util.Date;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ggauto
 */
@Stateless
public class FuncionarioController {

    @Inject
    FuncionarioManager funcionarioMgr;

    public void cambiarEstado(Funcionario funcionario, Usuario usuario, String estado) {
        funcionario.setEstado(estado);
        funcionario.setFechaActualizacion(new Date());
        funcionario.setIdUsuarioActualizacion(usuario);
        funcionario = funcionarioMgr.update(funcionario);
    }
}
