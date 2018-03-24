package business.cliente.entity;

import business.cliente.entity.Cliente;
import business.funcionario.entity.Funcionario;
import business.solicitudes.entity.SolicitudConexion;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-22T19:51:21")
@StaticMetamodel(ClienteSolicitud.class)
public class ClienteSolicitud_ { 

    public static volatile SingularAttribute<ClienteSolicitud, SolicitudConexion> idSolicitudConexion;
    public static volatile SingularAttribute<ClienteSolicitud, Cliente> idCliente;
    public static volatile SingularAttribute<ClienteSolicitud, Integer> idClienteSolicitud;
    public static volatile SingularAttribute<ClienteSolicitud, Funcionario> idFuncionario;

}