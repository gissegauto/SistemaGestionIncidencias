package business.usuario.entity;

import business.cliente.entity.Cliente;
import business.funcionario.entity.Funcionario;
import business.solicitudes.entity.SolicitudConexion;
import business.usuario.entity.Rol;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-26T09:29:49")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> password;
    public static volatile SingularAttribute<Usuario, Rol> idrol;
    public static volatile CollectionAttribute<Usuario, SolicitudConexion> solicitudConexionCollection1;
    public static volatile CollectionAttribute<Usuario, SolicitudConexion> solicitudConexionCollection;
    public static volatile CollectionAttribute<Usuario, Funcionario> funcionarioCollection;
    public static volatile CollectionAttribute<Usuario, Funcionario> funcionarioCollection1;
    public static volatile CollectionAttribute<Usuario, Funcionario> funcionarioCollection2;
    public static volatile CollectionAttribute<Usuario, Cliente> clienteCollection1;
    public static volatile CollectionAttribute<Usuario, Cliente> clienteCollection;
    public static volatile SingularAttribute<Usuario, Integer> idusuario;
    public static volatile SingularAttribute<Usuario, String> username;

}