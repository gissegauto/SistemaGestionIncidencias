package business.cliente.entity;

import business.direccion.entity.Barrio;
import business.usuario.entity.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-14T00:26:29")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> estado;
    public static volatile SingularAttribute<Cliente, Date> fechaRegistro;
    public static volatile SingularAttribute<Cliente, String> direccion;
    public static volatile SingularAttribute<Cliente, Usuario> idUsuarioRegistro;
    public static volatile SingularAttribute<Cliente, String> nombre;
    public static volatile SingularAttribute<Cliente, String> tipoDocumento;
    public static volatile SingularAttribute<Cliente, Integer> idCliente;
    public static volatile SingularAttribute<Cliente, Usuario> idUsuarioActualizacion;
    public static volatile SingularAttribute<Cliente, Barrio> idBarrio;
    public static volatile SingularAttribute<Cliente, String> apellido;
    public static volatile SingularAttribute<Cliente, String> observaciones;
    public static volatile SingularAttribute<Cliente, Date> fechaActualizacion;
    public static volatile SingularAttribute<Cliente, String> celular;
    public static volatile SingularAttribute<Cliente, String> sexo;
    public static volatile SingularAttribute<Cliente, String> telefono;
    public static volatile SingularAttribute<Cliente, String> nroDocumento;

}