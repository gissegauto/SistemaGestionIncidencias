/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.funcionario.entity;

import business.funcionario.entity.Funcionario;
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
@Table(name = "permiso_funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PermisoFuncionario.findAll", query = "SELECT p FROM PermisoFuncionario p")
    , @NamedQuery(name = "PermisoFuncionario.findByIdPermiso", query = "SELECT p FROM PermisoFuncionario p WHERE p.idPermiso = :idPermiso")
    , @NamedQuery(name = "PermisoFuncionario.findByTipoPermiso", query = "SELECT p FROM PermisoFuncionario p WHERE p.tipoPermiso = :tipoPermiso")
    , @NamedQuery(name = "PermisoFuncionario.findByFechaInicio", query = "SELECT p FROM PermisoFuncionario p WHERE p.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "PermisoFuncionario.findByFechaFin", query = "SELECT p FROM PermisoFuncionario p WHERE p.fechaFin = :fechaFin")
    , @NamedQuery(name = "PermisoFuncionario.findByFechaRegistro", query = "SELECT p FROM PermisoFuncionario p WHERE p.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "PermisoFuncionario.findByFechaActualizacion", query = "SELECT p FROM PermisoFuncionario p WHERE p.fechaActualizacion = :fechaActualizacion")})
public class PermisoFuncionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPermiso")
    private Integer idPermiso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "tipoPermiso")
    private String tipoPermiso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaRegistro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Column(name = "fechaActualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;
    @JoinColumn(name = "idFuncionario", referencedColumnName = "idFuncionario")
    @ManyToOne(optional = false)
    private Funcionario idFuncionario;
    @JoinColumn(name = "idUsuarioActualizacion", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario idUsuarioActualizacion;
    @JoinColumn(name = "idUsuarioRegistro", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idUsuarioRegistro;

    public PermisoFuncionario() {
    }

    public PermisoFuncionario(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public PermisoFuncionario(Integer idPermiso, String tipoPermiso, Date fechaInicio, Date fechaFin, Date fechaRegistro) {
        this.idPermiso = idPermiso;
        this.tipoPermiso = tipoPermiso;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public String getTipoPermiso() {
        return tipoPermiso;
    }

    public void setTipoPermiso(String tipoPermiso) {
        this.tipoPermiso = tipoPermiso;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
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

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
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
        hash += (idPermiso != null ? idPermiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermisoFuncionario)) {
            return false;
        }
        PermisoFuncionario other = (PermisoFuncionario) object;
        if ((this.idPermiso == null && other.idPermiso != null) || (this.idPermiso != null && !this.idPermiso.equals(other.idPermiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.direccion.entity.PermisoFuncionario[ idPermiso=" + idPermiso + " ]";
    }
    
}
