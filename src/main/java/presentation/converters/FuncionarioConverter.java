/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.converters;

import business.funcionario.boundary.FuncionarioManager;
import business.funcionario.entity.Funcionario;
import business.utils.UtilLogger;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author ggauto
 */
@FacesConverter(value = "funcionarioConverter")
public class FuncionarioConverter implements Converter {

    private FuncionarioManager funcionarioMgr;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.equals("")) {
            return null;
        }
        
        try {
            funcionarioMgr = CDI.current().select(FuncionarioManager.class).get();
            Funcionario funcionario = funcionarioMgr.getByName(value);
            return funcionario;
        } catch (Exception e) {
            UtilLogger.error("CLASS " + this.getClass().getName() + " METHOD: getAsObject ", e);
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object o) {
        if (o == null || o.equals("")) {
            return null;
        }
        try {
            if (o instanceof Funcionario) {
                Funcionario funcionario = (Funcionario) o;
                return funcionario.getNombreFuncionario() + "" + funcionario.getApellidoFuncionario();
            } else {
                return null;
            }

        } catch (Exception e) {
            UtilLogger.error("CLASS " + this.getClass().getName() + " METHOD: getAsString ", e);
            return null;
        }
    }

}