/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.funcionario.controller;

import business.funcionario.boundary.HistorialFuncionarioManager;
import business.funcionario.entity.Funcionario;
import business.funcionario.entity.HistorialFuncionario;
import business.utils.UtilLogger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ggauto
 */
@Stateless
public class HistorialFuncionarioController {

    @Inject
    HistorialFuncionarioManager historialFuncionarioManager;

    public void addHistory(Funcionario funcionario) {
        try {
            HistorialFuncionario history = new HistorialFuncionario();
            history.setNombreFuncionario(funcionario.getNombreFuncionario());
            history.setApellidoFuncionario(funcionario.getApellidoFuncionario());
            history.setNroDocumento((funcionario.getNroDocumento() != null) ? funcionario.getNroDocumento() : null);
            history.setTipoDocumento((funcionario.getTipoDocumento() != null) ? funcionario.getTipoDocumento() : null);
            history.setFechaRegistro((funcionario.getFechaRegistro() != null) ? funcionario.getFechaRegistro() : null);
            history.setFechaActualizacion((funcionario.getFechaActualizacion() != null) ? funcionario.getFechaActualizacion() : null);
            history.setEstado((funcionario.getEstado() != null) ? funcionario.getEstado() : null);
            if (funcionario.getIdBarrio() != null) {
                history.setIdBarrio(funcionario.getIdBarrio().getIdBarrio());
            }
//            if (funcionario.getIdUsuarioRegistro() != null) {
//                history.setIdUsuarioRegistro(funcionario.getIdUsuarioRegistro());
//            }
//            if (funcionario.getIdUsuarioActualizacion() != null) {
//                history.setIdUsuarioActualizacion(funcionario.getIdUsuarioActualizacion());
//            }
            historialFuncionarioManager.add(history);
            UtilLogger.info(HistorialFuncionarioController.class + ".addHistory : Insertado correctamente en histórico");
        } catch (Exception e) {
            UtilLogger.error(HistorialFuncionarioController.class + ".addHistory : Al intentar agregar historial ", e);
        }
    }

}
