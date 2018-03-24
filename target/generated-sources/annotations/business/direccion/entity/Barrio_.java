package business.direccion.entity;

import business.cliente.entity.Cliente;
import business.direccion.entity.Ciudad;
import business.direccion.entity.ZonaBarrio;
import business.funcionario.entity.Funcionario;
import business.solicitudes.entity.HistorialSolicitudConexion;
import business.solicitudes.entity.SolicitudConexion;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-22T19:51:21")
@StaticMetamodel(Barrio.class)
public class Barrio_ { 

    public static volatile CollectionAttribute<Barrio, HistorialSolicitudConexion> historialSolicitudConexionCollection;
    public static volatile SingularAttribute<Barrio, String> barrio;
    public static volatile CollectionAttribute<Barrio, SolicitudConexion> solicitudConexionCollection;
    public static volatile CollectionAttribute<Barrio, Funcionario> funcionarioCollection;
    public static volatile SingularAttribute<Barrio, Integer> idBarrio;
    public static volatile SingularAttribute<Barrio, Ciudad> idCiudad;
    public static volatile CollectionAttribute<Barrio, ZonaBarrio> zonaBarrioCollection;
    public static volatile CollectionAttribute<Barrio, Cliente> clienteCollection;

}