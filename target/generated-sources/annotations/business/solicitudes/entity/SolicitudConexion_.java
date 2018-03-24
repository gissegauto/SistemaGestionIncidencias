package business.solicitudes.entity;

import business.cliente.entity.ClienteSolicitud;
import business.configuracion.entity.Servicio;
import business.direccion.entity.Barrio;
import business.solicitudes.entity.HistorialSolicitudConexion;
import business.usuario.entity.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-22T19:51:21")
@StaticMetamodel(SolicitudConexion.class)
public class SolicitudConexion_ { 

    public static volatile SingularAttribute<SolicitudConexion, String> estado;
    public static volatile SingularAttribute<SolicitudConexion, Date> fechaRegistro;
    public static volatile SingularAttribute<SolicitudConexion, String> direccion;
    public static volatile SingularAttribute<SolicitudConexion, Usuario> idUsuarioRegistro;
    public static volatile SingularAttribute<SolicitudConexion, String> nombre;
    public static volatile CollectionAttribute<SolicitudConexion, HistorialSolicitudConexion> historialSolicitudConexionCollection;
    public static volatile SingularAttribute<SolicitudConexion, Integer> idSolicitudConexion;
    public static volatile CollectionAttribute<SolicitudConexion, ClienteSolicitud> clienteSolicitudCollection;
    public static volatile SingularAttribute<SolicitudConexion, Usuario> idUsuarioActualizacion;
    public static volatile SingularAttribute<SolicitudConexion, Barrio> idBarrio;
    public static volatile SingularAttribute<SolicitudConexion, String> apellido;
    public static volatile SingularAttribute<SolicitudConexion, Date> fechaActualizacion;
    public static volatile SingularAttribute<SolicitudConexion, String> celular;
    public static volatile SingularAttribute<SolicitudConexion, Servicio> idServicio;
    public static volatile SingularAttribute<SolicitudConexion, String> telefono;
    public static volatile SingularAttribute<SolicitudConexion, String> referencia;
    public static volatile SingularAttribute<SolicitudConexion, String> observacion;

}