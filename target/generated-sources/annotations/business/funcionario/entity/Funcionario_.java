package business.funcionario.entity;

import business.direccion.entity.Barrio;
import business.usuario.entity.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-14T00:26:29")
@StaticMetamodel(Funcionario.class)
public class Funcionario_ { 

    public static volatile SingularAttribute<Funcionario, String> estado;
    public static volatile SingularAttribute<Funcionario, Date> fechaRegistro;
    public static volatile SingularAttribute<Funcionario, Usuario> idUsuario;
    public static volatile SingularAttribute<Funcionario, String> direccion;
    public static volatile SingularAttribute<Funcionario, String> apellidoFuncionario;
    public static volatile SingularAttribute<Funcionario, Usuario> idUsuarioRegistro;
    public static volatile SingularAttribute<Funcionario, Integer> idFuncionario;
    public static volatile SingularAttribute<Funcionario, String> tipoDocumento;
    public static volatile SingularAttribute<Funcionario, Usuario> idUsuarioActualizacion;
    public static volatile SingularAttribute<Funcionario, Barrio> idBarrio;
    public static volatile SingularAttribute<Funcionario, Date> fechaActualizacion;
    public static volatile SingularAttribute<Funcionario, String> celular;
    public static volatile SingularAttribute<Funcionario, String> nombreFuncionario;
    public static volatile SingularAttribute<Funcionario, String> telefono;
    public static volatile SingularAttribute<Funcionario, String> nroDocumento;

}