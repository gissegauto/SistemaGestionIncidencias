package business.configuracion.entity;

import business.solicitudes.entity.HistorialSolicitudConexion;
import business.solicitudes.entity.SolicitudConexion;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-22T19:51:21")
@StaticMetamodel(Servicio.class)
public class Servicio_ { 

    public static volatile CollectionAttribute<Servicio, HistorialSolicitudConexion> historialSolicitudConexionCollection;
    public static volatile SingularAttribute<Servicio, Integer> estado;
    public static volatile SingularAttribute<Servicio, String> servicio;
    public static volatile CollectionAttribute<Servicio, SolicitudConexion> solicitudConexionCollection;
    public static volatile SingularAttribute<Servicio, Integer> idServicio;

}