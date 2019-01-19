/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.solicitudes.entity;

import business.configuracion.entity.Servicio;
import business.direccion.entity.Barrio;
import business.usuario.entity.Usuario;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
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
@Table(name = "historial_solicitud_conexion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistorialSolicitudConexion.findAll", query = "SELECT h FROM HistorialSolicitudConexion h")
    , @NamedQuery(name = "HistorialSolicitudConexion.findByIdHistorialSolicitudConexion", query = "SELECT h FROM HistorialSolicitudConexion h WHERE h.idHistorialSolicitudConexion = :idHistorialSolicitudConexion")
    , @NamedQuery(name = "HistorialSolicitudConexion.findByNombre", query = "SELECT h FROM HistorialSolicitudConexion h WHERE h.nombre = :nombre")
    , @NamedQuery(name = "HistorialSolicitudConexion.findByApellido", query = "SELECT h FROM HistorialSolicitudConexion h WHERE h.apellido = :apellido")
    , @NamedQuery(name = "HistorialSolicitudConexion.findByDireccion", query = "SELECT h FROM HistorialSolicitudConexion h WHERE h.direccion = :direccion")
    , @NamedQuery(name = "HistorialSolicitudConexion.findByReferencia", query = "SELECT h FROM HistorialSolicitudConexion h WHERE h.referencia = :referencia")
    , @NamedQuery(name = "HistorialSolicitudConexion.findByTelefono", query = "SELECT h FROM HistorialSolicitudConexion h WHERE h.telefono = :telefono")
    , @NamedQuery(name = "HistorialSolicitudConexion.findByCelular", query = "SELECT h FROM HistorialSolicitudConexion h WHERE h.celular = :celular")
    , @NamedQuery(name = "HistorialSolicitudConexion.findByObservacion", query = "SELECT h FROM HistorialSolicitudConexion h WHERE h.observacion = :observacion")
    , @NamedQuery(name = "HistorialSolicitudConexion.findByEstado", query = "SELECT h FROM HistorialSolicitudConexion h WHERE h.estado = :estado")
    , @NamedQuery(name = "HistorialSolicitudConexion.findByFechaRegistro", query = "SELECT h FROM HistorialSolicitudConexion h WHERE h.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "HistorialSolicitudConexion.findByFechaActualizacion", query = "SELECT h FROM HistorialSolicitudConexion h WHERE h.fechaActualizacion = :fechaActualizacion")})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j
public class HistorialSolicitudConexion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idHistorialSolicitudConexion")
    private Integer idHistorialSolicitudConexion;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "apellido")
    private String apellido;
    @Size(max = 100)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 100)
    @Column(name = "referencia")
    private String referencia;
    @Size(max = 10)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 10)
    @Column(name = "celular")
    private String celular;
    @Size(max = 100)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaRegistro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Column(name = "fechaActualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;
    @JoinColumn(name = "idBarrio", referencedColumnName = "idBarrio")
    @ManyToOne
    private Barrio idBarrio;
    @JoinColumn(name = "id_servicio", referencedColumnName = "id_servicio")
    @ManyToOne(optional = false)
    private Servicio idServicio;
    @JoinColumn(name = "idSolicitudConexion", referencedColumnName = "idSolicitudConexion")
    @ManyToOne(optional = false)
    private SolicitudConexion idSolicitudConexion;
    @JoinColumn(name = "idUsuarioActualizacion", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario idUsuarioActualizacion;
    @JoinColumn(name = "idUsuarioRegistro", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idUsuarioRegistro;

}
