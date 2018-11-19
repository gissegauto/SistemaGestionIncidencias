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

    public HistorialSolicitudConexion() {
    }

    public HistorialSolicitudConexion(Integer idHistorialSolicitudConexion) {
        this.idHistorialSolicitudConexion = idHistorialSolicitudConexion;
    }

    public HistorialSolicitudConexion(Integer idHistorialSolicitudConexion, String estado, Date fechaRegistro) {
        this.idHistorialSolicitudConexion = idHistorialSolicitudConexion;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdHistorialSolicitudConexion() {
        return idHistorialSolicitudConexion;
    }

    public void setIdHistorialSolicitudConexion(Integer idHistorialSolicitudConexion) {
        this.idHistorialSolicitudConexion = idHistorialSolicitudConexion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Barrio getIdBarrio() {
        return idBarrio;
    }

    public void setIdBarrio(Barrio idBarrio) {
        this.idBarrio = idBarrio;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    public SolicitudConexion getIdSolicitudConexion() {
        return idSolicitudConexion;
    }

    public void setIdSolicitudConexion(SolicitudConexion idSolicitudConexion) {
        this.idSolicitudConexion = idSolicitudConexion;
    }

    public Usuario getIdUsuarioActualizacion() {
        return idUsuarioActualizacion;
    }

    public void setIdUsuarioActualizacion(Usuario idUsuarioActualizacion) {
        this.idUsuarioActualizacion = idUsuarioActualizacion;
    }

    public Usuario getIdUsuarioRegistro() {
        return idUsuarioRegistro;
    }

    public void setIdUsuarioRegistro(Usuario idUsuarioRegistro) {
        this.idUsuarioRegistro = idUsuarioRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistorialSolicitudConexion != null ? idHistorialSolicitudConexion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistorialSolicitudConexion)) {
            return false;
        }
        HistorialSolicitudConexion other = (HistorialSolicitudConexion) object;
        if ((this.idHistorialSolicitudConexion == null && other.idHistorialSolicitudConexion != null) || (this.idHistorialSolicitudConexion != null && !this.idHistorialSolicitudConexion.equals(other.idHistorialSolicitudConexion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.solicitudes.entity.HistorialSolicitudConexion[ idHistorialSolicitudConexion=" + idHistorialSolicitudConexion + " ]";
    }
    
}
