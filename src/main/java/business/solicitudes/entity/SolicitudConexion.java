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

    public SolicitudConexion() {
    }

    public SolicitudConexion(Integer idSolicitudConexion) {
        this.idSolicitudConexion = idSolicitudConexion;
    }

    public Integer getCantidadTv() {
        return cantidadTv;
    }

    public void setCantidadTv(Integer cantidadTv) {
        this.cantidadTv = cantidadTv;
    }

    public Integer getIdSolicitudConexion() {
        return idSolicitudConexion;
    }

    public void setIdSolicitudConexion(Integer idSolicitudConexion) {
        this.idSolicitudConexion = idSolicitudConexion;
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

    public Barrio getIdBarrio() {
        return idBarrio;
    }

    public void setIdBarrio(Barrio idBarrio) {
        this.idBarrio = idBarrio;
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

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    public List<HistorialSolicitudConexion> getHistorialSolicitudConexionList() {
        return historialSolicitudConexionList;
    }

    public void setHistorialSolicitudConexionList(List<HistorialSolicitudConexion> historialSolicitudConexionList) {
        this.historialSolicitudConexionList = historialSolicitudConexionList;
    }

    public List<ClienteSolicitud> getClienteSolicitudList() {
        return clienteSolicitudList;
    }

    public void setClienteSolicitudList(List<ClienteSolicitud> clienteSolicitudList) {
        this.clienteSolicitudList = clienteSolicitudList;
    }

    @Override
    public String toString() {
        return "business.solicitudes.entity.SolicitudConexion[ idSolicitudConexion=" + idSolicitudConexion + " ]";
    }

}
