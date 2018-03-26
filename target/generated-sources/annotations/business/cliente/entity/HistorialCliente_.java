package business.cliente.entity;

import business.cliente.entity.Cliente;
import business.usuario.entity.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-26T09:29:49")
@StaticMetamodel(HistorialCliente.class)
public class HistorialCliente_ { 

    public static volatile SingularAttribute<HistorialCliente, Integer> idHistorialCliente;
    public static volatile SingularAttribute<HistorialCliente, String> estado;
    public static volatile SingularAttribute<HistorialCliente, Date> fechaRegistro;
    public static volatile SingularAttribute<HistorialCliente, String> contrato;
    public static volatile SingularAttribute<HistorialCliente, Usuario> idUsuarioRegistro;
    public static volatile SingularAttribute<HistorialCliente, String> nombre;
    public static volatile SingularAttribute<HistorialCliente, String> tipoDocumento;
    public static volatile SingularAttribute<HistorialCliente, Cliente> idCliente;
    public static volatile SingularAttribute<HistorialCliente, Usuario> idUsuarioActualizacion;
    public static volatile SingularAttribute<HistorialCliente, Integer> idBarrio;
    public static volatile SingularAttribute<HistorialCliente, String> apellido;
    public static volatile SingularAttribute<HistorialCliente, Date> fechaActualizacion;
    public static volatile SingularAttribute<HistorialCliente, String> sexo;
    public static volatile SingularAttribute<HistorialCliente, String> nroDocumento;

}