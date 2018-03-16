/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.cliente.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "historialCliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistorialCliente.findAll", query = "SELECT h FROM HistorialCliente h")
    , @NamedQuery(name = "HistorialCliente.findByIdHistorialCliente", query = "SELECT h FROM HistorialCliente h WHERE h.idHistorialCliente = :idHistorialCliente")
    , @NamedQuery(name = "HistorialCliente.findByNombre", query = "SELECT h FROM HistorialCliente h WHERE h.nombre = :nombre")
    , @NamedQuery(name = "HistorialCliente.findByApellido", query = "SELECT h FROM HistorialCliente h WHERE h.apellido = :apellido")
    , @NamedQuery(name = "HistorialCliente.findByTipoDocumento", query = "SELECT h FROM HistorialCliente h WHERE h.tipoDocumento = :tipoDocumento")
    , @NamedQuery(name = "HistorialCliente.findByNroDocumento", query = "SELECT h FROM HistorialCliente h WHERE h.nroDocumento = :nroDocumento")
    , @NamedQuery(name = "HistorialCliente.findBySexo", query = "SELECT h FROM HistorialCliente h WHERE h.sexo = :sexo")
    , @NamedQuery(name = "HistorialCliente.findByEstado", query = "SELECT h FROM HistorialCliente h WHERE h.estado = :estado")
    , @NamedQuery(name = "HistorialCliente.findByIdUsuarioRegistro", query = "SELECT h FROM HistorialCliente h WHERE h.idUsuarioRegistro = :idUsuarioRegistro")
    , @NamedQuery(name = "HistorialCliente.findByFechaRegistro", query = "SELECT h FROM HistorialCliente h WHERE h.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "HistorialCliente.findByIdUsuarioActualizacion", query = "SELECT h FROM HistorialCliente h WHERE h.idUsuarioActualizacion = :idUsuarioActualizacion")
    , @NamedQuery(name = "HistorialCliente.findByFechaActualizacion", query = "SELECT h FROM HistorialCliente h WHERE h.fechaActualizacion = :fechaActualizacion")
    , @NamedQuery(name = "HistorialCliente.findByIdBarrio", query = "SELECT h FROM HistorialCliente h WHERE h.idBarrio = :idBarrio")
    , @NamedQuery(name = "HistorialCliente.findByIdCliente", query = "SELECT h FROM HistorialCliente h WHERE h.idCliente = :idCliente")})
public class HistorialCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idHistorialCliente")
    private Integer idHistorialCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellido")
    private String apellido;
    @Size(max = 10)
    @Column(name = "tipoDocumento")
    private String tipoDocumento;
    @Size(max = 20)
    @Column(name = "nroDocumento")
    private String nroDocumento;
    @Size(max = 1)
    @Column(name = "sexo")
    private String sexo;
    @Size(max = 10)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuarioRegistro")
    private int idUsuarioRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaRegistro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuarioActualizacion")
    private int idUsuarioActualizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaActualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;
    @Column(name = "idBarrio")
    private Integer idBarrio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCliente")
    private int idCliente;

    public HistorialCliente() {
    }

    public HistorialCliente(Integer idHistorialCliente) {
        this.idHistorialCliente = idHistorialCliente;
    }

    public HistorialCliente(Integer idHistorialCliente, String nombre, String apellido, int idUsuarioRegistro, Date fechaRegistro, int idUsuarioActualizacion, Date fechaActualizacion, int idCliente) {
        this.idHistorialCliente = idHistorialCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idUsuarioRegistro = idUsuarioRegistro;
        this.fechaRegistro = fechaRegistro;
        this.idUsuarioActualizacion = idUsuarioActualizacion;
        this.fechaActualizacion = fechaActualizacion;
        this.idCliente = idCliente;
    }

    public Integer getIdHistorialCliente() {
        return idHistorialCliente;
    }

    public void setIdHistorialCliente(Integer idHistorialCliente) {
        this.idHistorialCliente = idHistorialCliente;
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

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdUsuarioRegistro() {
        return idUsuarioRegistro;
    }

    public void setIdUsuarioRegistro(int idUsuarioRegistro) {
        this.idUsuarioRegistro = idUsuarioRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getIdUsuarioActualizacion() {
        return idUsuarioActualizacion;
    }

    public void setIdUsuarioActualizacion(int idUsuarioActualizacion) {
        this.idUsuarioActualizacion = idUsuarioActualizacion;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Integer getIdBarrio() {
        return idBarrio;
    }

    public void setIdBarrio(Integer idBarrio) {
        this.idBarrio = idBarrio;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistorialCliente != null ? idHistorialCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistorialCliente)) {
            return false;
        }
        HistorialCliente other = (HistorialCliente) object;
        if ((this.idHistorialCliente == null && other.idHistorialCliente != null) || (this.idHistorialCliente != null && !this.idHistorialCliente.equals(other.idHistorialCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.cliente.entity.HistorialCliente[ idHistorialCliente=" + idHistorialCliente + " ]";
    }
    
}
