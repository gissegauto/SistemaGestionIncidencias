package business.solicitudes.entity;

import business.configuracion.entity.Servicio;
import business.direccion.entity.Barrio;
import business.solicitudes.entity.SolicitudConexion;
import business.usuario.entity.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-26T09:29:49")
@StaticMetamodel(HistorialSolicitudConexion.class)
public class HistorialSolicitudConexion_ { 

    public static volatile SingularAttribute<HistorialSolicitudConexion, String> estado;
    public static volatile SingularAttribute<HistorialSolicitudConexion, Integer> idHistorialSolicitudConexion;
    public static volatile SingularAttribute<HistorialSolicitudConexion, Date> fechaRegistro;
    public static volatile SingularAttribute<HistorialSolicitudConexion, String> direccion;
    public static volatile SingularAttribute<HistorialSolicitudConexion, Usuario> idUsuarioRegistro;
    public static volatile SingularAttribute<HistorialSolicitudConexion, String> nombre;
    public static volatile SingularAttribute<HistorialSolicitudConexion, SolicitudConexion> idSolicitudConexion;
    public static volatile SingularAttribute<HistorialSolicitudConexion, Usuario> idUsuarioActualizacion;
    public static volatile SingularAttribute<HistorialSolicitudConexion, Barrio> idBarrio;
    public static volatile SingularAttribute<HistorialSolicitudConexion, String> apellido;
    public static volatile SingularAttribute<HistorialSolicitudConexion, String> celular;
    public static volatile SingularAttribute<HistorialSolicitudConexion, Date> fechaActualizacion;
    public static volatile SingularAttribute<HistorialSolicitudConexion, Servicio> idServicio;
    public static volatile SingularAttribute<HistorialSolicitudConexion, String> telefono;
    public static volatile SingularAttribute<HistorialSolicitudConexion, String> referencia;
    public static volatile SingularAttribute<HistorialSolicitudConexion, String> observacion;

}