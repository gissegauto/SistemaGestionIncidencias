/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.solicitudes.entity;

import business.cliente.entity.ClienteSolicitud;
import business.configuracion.entity.Servicio;
import business.direccion.entity.Barrio;
import business.usuario.entity.Usuario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 *
 * @author ggauto
 */
@Entity
@Table(name = "solicitud_conexion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SolicitudConexion.findAll", query = "SELECT s FROM SolicitudConexion s")
    , @NamedQuery(name = "SolicitudConexion.findByIdSolicitudConexion", query = "SELECT s FROM SolicitudConexion s WHERE s.idSolicitudConexion = :idSolicitudConexion")
    , @NamedQuery(name = "SolicitudConexion.findByNombre", query = "SELECT s FROM SolicitudConexion s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "SolicitudConexion.findByApellido", query = "SELECT s FROM SolicitudConexion s WHERE s.apellido = :apellido")
    , @NamedQuery(name = "SolicitudConexion.findByDireccion", query = "SELECT s FROM SolicitudConexion s WHERE s.direccion = :direccion")
    , @NamedQuery(name = "SolicitudConexion.findByReferencia", query = "SELECT s FROM SolicitudConexion s WHERE s.referencia = :referencia")
    , @NamedQuery(name = "SolicitudConexion.findByFechaRegistro", query = "SELECT s FROM SolicitudConexion s WHERE s.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "SolicitudConexion.findByFechaActualizacion", query = "SELECT s FROM SolicitudConexion s WHERE s.fechaActualizacion = :fechaActualizacion")
    , @NamedQuery(name = "SolicitudConexion.findByTelefono", query = "SELECT s FROM SolicitudConexion s WHERE s.telefono = :telefono")
    , @NamedQuery(name = "SolicitudConexion.findByCelular", query = "SELECT s FROM SolicitudConexion s WHERE s.celular = :celular")
    , @NamedQuery(name = "SolicitudConexion.findByObservacion", query = "SELECT s FROM SolicitudConexion s WHERE s.observacion = :observacion")
    , @NamedQuery(name = "SolicitudConexion.findByEstado", query = "SELECT s FROM SolicitudConexion s WHERE s.estado = :estado")})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j
public class SolicitudConexion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSolicitudConexion")
    private Integer idSolicitudConexion;
    @Basic(optional = false)
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Size(min = 1, max = 45)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @Size(max = 100)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 100)
    @Column(name = "referencia")
    private String referencia;
    @Basic(optional = false)
    @Column(name = "fechaRegistro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Column(name = "fechaActualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;
    @Size(max = 15)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 15)
    @Column(name = "celular")
    private String celular;
    @Column(name = "tv_cantidad")
    private Integer cantidadTv;
    @Size(max = 100)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @Size(min = 1, max = 10)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "idBarrio", referencedColumnName = "idBarrio")
    @ManyToOne(optional = false)
    private Barrio idBarrio;
    @JoinColumn(name = "idUsuarioActualizacion", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario idUsuarioActualizacion;
    @JoinColumn(name = "idUsuarioRegistro", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idUsuarioRegistro;
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
    @ManyToOne(optional = false)
    private Servicio idServicio;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSolicitudConexion")
    private List<HistorialSolicitudConexion> historialSolicitudConexionList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSolicitudConexion")
    private List<ClienteSolicitud> clienteSolicitudList;

}
