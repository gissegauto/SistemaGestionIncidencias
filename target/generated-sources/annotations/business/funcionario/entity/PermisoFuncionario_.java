package business.funcionario.entity;

import business.funcionario.entity.Funcionario;
import business.usuario.entity.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-22T19:51:21")
@StaticMetamodel(PermisoFuncionario.class)
public class PermisoFuncionario_ { 

    public static volatile SingularAttribute<PermisoFuncionario, Usuario> idUsuarioActualizacion;
    public static volatile SingularAttribute<PermisoFuncionario, Date> fechaInicio;
    public static volatile SingularAttribute<PermisoFuncionario, Integer> idPermiso;
    public static volatile SingularAttribute<PermisoFuncionario, Date> fechaRegistro;
    public static volatile SingularAttribute<PermisoFuncionario, String> tipoPermiso;
    public static volatile SingularAttribute<PermisoFuncionario, Date> fechaActualizacion;
    public static volatile SingularAttribute<PermisoFuncionario, Usuario> idUsuarioRegistro;
    public static volatile SingularAttribute<PermisoFuncionario, Funcionario> idFuncionario;
    public static volatile SingularAttribute<PermisoFuncionario, Date> fechaFin;

}