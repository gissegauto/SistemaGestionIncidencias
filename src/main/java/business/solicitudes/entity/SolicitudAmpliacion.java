/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.solicitudes.entity;

import business.cliente.entity.Cliente;
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

/**
 *
 * @author ggauto
 */
@Entity
@Table(name = "solicitud_ampliacion")
@NamedQueries({
    @NamedQuery(name = "SolicitudAmpliacion.findAll", query = "SELECT s FROM SolicitudAmpliacion s")
    , @NamedQuery(name = "SolicitudAmpliacion.findByIdSolicitudAmpliacion", query = "SELECT s FROM SolicitudAmpliacion s WHERE s.idSolicitudAmpliacion = :idSolicitudAmpliacion")
    , @NamedQuery(name = "SolicitudAmpliacion.findByObservaciones", query = "SELECT s FROM SolicitudAmpliacion s WHERE s.observaciones = :observaciones")
    , @NamedQuery(name = "SolicitudAmpliacion.findByEstado", query = "SELECT s FROM SolicitudAmpliacion s WHERE s.estado = :estado")
    , @NamedQuery(name = "SolicitudAmpliacion.findByCantidadTV", query = "SELECT s FROM SolicitudAmpliacion s WHERE s.cantidadTV = :cantidadTV")})
public class SolicitudAmpliacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSolicitudAmpliacion")
    private Integer idSolicitudAmpliacion;
    @Size(max = 255)
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "estado")
    private String estado;
    @Column(name = "cantidadTV")
    private Integer cantidadTV;
    @Basic(optional = false)
    @Column(name = "fechaRegistro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Column(name = "fechaActualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;

    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "idFuncionario", referencedColumnName = "idFuncionario")
    @ManyToOne(optional = false)
    private Funcionario idFuncionario;
    @JoinColumn(name = "idUsuarioActualizacion", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario idUsuarioActualizacion;
    @JoinColumn(name = "idUsuarioRegistro", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idUsuarioRegistro;

    public SolicitudAmpliacion() {
    }

    public SolicitudAmpliacion(Integer idSolicitudAmpliacion) {
        this.idSolicitudAmpliacion = idSolicitudAmpliacion;
    }

    public SolicitudAmpliacion(Integer idSolicitudAmpliacion, String estado) {
        this.idSolicitudAmpliacion = idSolicitudAmpliacion;
        this.estado = estado;
    }

    public Integer getIdSolicitudAmpliacion() {
        return idSolicitudAmpliacion;
    }

    public void setIdSolicitudAmpliacion(Integer idSolicitudAmpliacion) {
        this.idSolicitudAmpliacion = idSolicitudAmpliacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getCantidadTV() {
        return cantidadTV;
    }

    public void setCantidadTV(Integer cantidadTV) {
        this.cantidadTV = cantidadTV;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitudAmpliacion != null ? idSolicitudAmpliacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudAmpliacion)) {
            return false;
        }
        SolicitudAmpliacion other = (SolicitudAmpliacion) object;
        if ((this.idSolicitudAmpliacion == null && other.idSolicitudAmpliacion != null) || (this.idSolicitudAmpliacion != null && !this.idSolicitudAmpliacion.equals(other.idSolicitudAmpliacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.solicitudes.entity.SolicitudAmpliacion[ idSolicitudAmpliacion=" + idSolicitudAmpliacion + " ]";
    }

}
