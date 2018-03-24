/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.funcionario.entity;

import business.funcionario.entity.Funcionario;
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
@Table(name = "historial_funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistorialFuncionario.findAll", query = "SELECT h FROM HistorialFuncionario h")
    , @NamedQuery(name = "HistorialFuncionario.findByIdHistorialFuncionario", query = "SELECT h FROM HistorialFuncionario h WHERE h.idHistorialFuncionario = :idHistorialFuncionario")
    , @NamedQuery(name = "HistorialFuncionario.findByIdUsuario", query = "SELECT h FROM HistorialFuncionario h WHERE h.idUsuario = :idUsuario")
    , @NamedQuery(name = "HistorialFuncionario.findByNombreFuncionario", query = "SELECT h FROM HistorialFuncionario h WHERE h.nombreFuncionario = :nombreFuncionario")
    , @NamedQuery(name = "HistorialFuncionario.findByApellidoFuncionario", query = "SELECT h FROM HistorialFuncionario h WHERE h.apellidoFuncionario = :apellidoFuncionario")
    , @NamedQuery(name = "HistorialFuncionario.findByTipoDocumento", query = "SELECT h FROM HistorialFuncionario h WHERE h.tipoDocumento = :tipoDocumento")
    , @NamedQuery(name = "HistorialFuncionario.findByNroDocumento", query = "SELECT h FROM HistorialFuncionario h WHERE h.nroDocumento = :nroDocumento")
    , @NamedQuery(name = "HistorialFuncionario.findByIdUsuarioRegistro", query = "SELECT h FROM HistorialFuncionario h WHERE h.idUsuarioRegistro = :idUsuarioRegistro")
    , @NamedQuery(name = "HistorialFuncionario.findByFechaRegistro", query = "SELECT h FROM HistorialFuncionario h WHERE h.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "HistorialFuncionario.findByIdUsuarioActualizacion", query = "SELECT h FROM HistorialFuncionario h WHERE h.idUsuarioActualizacion = :idUsuarioActualizacion")
    , @NamedQuery(name = "HistorialFuncionario.findByFechaActualizacion", query = "SELECT h FROM HistorialFuncionario h WHERE h.fechaActualizacion = :fechaActualizacion")
    , @NamedQuery(name = "HistorialFuncionario.findByEstado", query = "SELECT h FROM HistorialFuncionario h WHERE h.estado = :estado")
    , @NamedQuery(name = "HistorialFuncionario.findByIdBarrio", query = "SELECT h FROM HistorialFuncionario h WHERE h.idBarrio = :idBarrio")
    , @NamedQuery(name = "HistorialFuncionario.findByDireccion", query = "SELECT h FROM HistorialFuncionario h WHERE h.direccion = :direccion")})
public class HistorialFuncionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idHistorialFuncionario")
    private Integer idHistorialFuncionario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuario")
    private int idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreFuncionario")
    private String nombreFuncionario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellidoFuncionario")
    private String apellidoFuncionario;
    @Size(max = 45)
    @Column(name = "tipoDocumento")
    private String tipoDocumento;
    @Size(max = 20)
    @Column(name = "nroDocumento")
    private String nroDocumento;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idBarrio")
    private int idBarrio;
    @Size(max = 255)
    @Column(name = "direccion")
    private String direccion;
    @JoinColumn(name = "idFuncionario", referencedColumnName = "idFuncionario")
    @ManyToOne(optional = false)
    private Funcionario idFuncionario;

    public HistorialFuncionario() {
    }

    public HistorialFuncionario(Integer idHistorialFuncionario) {
        this.idHistorialFuncionario = idHistorialFuncionario;
    }

    public HistorialFuncionario(Integer idHistorialFuncionario, int idUsuario, String nombreFuncionario, String apellidoFuncionario, int idUsuarioRegistro, Date fechaRegistro, int idUsuarioActualizacion, Date fechaActualizacion, String estado, int idBarrio) {
        this.idHistorialFuncionario = idHistorialFuncionario;
        this.idUsuario = idUsuario;
        this.nombreFuncionario = nombreFuncionario;
        this.apellidoFuncionario = apellidoFuncionario;
        this.idUsuarioRegistro = idUsuarioRegistro;
        this.fechaRegistro = fechaRegistro;
        this.idUsuarioActualizacion = idUsuarioActualizacion;
        this.fechaActualizacion = fechaActualizacion;
        this.estado = estado;
        this.idBarrio = idBarrio;
    }

    public Integer getIdHistorialFuncionario() {
        return idHistorialFuncionario;
    }

    public void setIdHistorialFuncionario(Integer idHistorialFuncionario) {
        this.idHistorialFuncionario = idHistorialFuncionario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreFuncionario() {
        return nombreFuncionario;
    }

    public void setNombreFuncionario(String nombreFuncionario) {
        this.nombreFuncionario = nombreFuncionario;
    }

    public String getApellidoFuncionario() {
        return apellidoFuncionario;
    }

    public void setApellidoFuncionario(String apellidoFuncionario) {
        this.apellidoFuncionario = apellidoFuncionario;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdBarrio() {
        return idBarrio;
    }

    public void setIdBarrio(int idBarrio) {
        this.idBarrio = idBarrio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHistorialFuncionario != null ? idHistorialFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistorialFuncionario)) {
            return false;
        }
        HistorialFuncionario other = (HistorialFuncionario) object;
        if ((this.idHistorialFuncionario == null && other.idHistorialFuncionario != null) || (this.idHistorialFuncionario != null && !this.idHistorialFuncionario.equals(other.idHistorialFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.direccion.entity.HistorialFuncionario[ idHistorialFuncionario=" + idHistorialFuncionario + " ]";
    }
    
}
