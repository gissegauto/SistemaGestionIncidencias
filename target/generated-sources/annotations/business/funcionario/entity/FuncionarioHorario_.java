package business.funcionario.entity;

import business.funcionario.entity.Funcionario;
import business.funcionario.entity.Horario;
import business.usuario.entity.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-22T19:51:21")
@StaticMetamodel(FuncionarioHorario.class)
public class FuncionarioHorario_ { 

    public static volatile SingularAttribute<FuncionarioHorario, Horario> idHorario;
    public static volatile SingularAttribute<FuncionarioHorario, Usuario> idUsuarioActualizacion;
    public static volatile SingularAttribute<FuncionarioHorario, Date> fechaRegistro;
    public static volatile SingularAttribute<FuncionarioHorario, Date> fechaActualizacion;
    public static volatile SingularAttribute<FuncionarioHorario, Integer> idFuncionarioHorario;
    public static volatile SingularAttribute<FuncionarioHorario, Usuario> idUsuarioRegistro;
    public static volatile SingularAttribute<FuncionarioHorario, Funcionario> idFuncionario;

}