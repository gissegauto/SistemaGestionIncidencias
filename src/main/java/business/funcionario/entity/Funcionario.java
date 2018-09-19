/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.funcionario.entity;

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
@Table(name = "funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f")
    , @NamedQuery(name = "Funcionario.findByIdFuncionario", query = "SELECT f FROM Funcionario f WHERE f.idFuncionario = :idFuncionario")
    , @NamedQuery(name = "Funcionario.findByNombreFuncionario", query = "SELECT f FROM Funcionario f WHERE f.nombreFuncionario = :nombreFuncionario")
    , @NamedQuery(name = "Funcionario.findByApellidoFuncionario", query = "SELECT f FROM Funcionario f WHERE f.apellidoFuncionario = :apellidoFuncionario")
    , @NamedQuery(name = "Funcionario.findByTipoDocumento", query = "SELECT f FROM Funcionario f WHERE f.tipoDocumento = :tipoDocumento")
    , @NamedQuery(name = "Funcionario.findByNroDocumento", query = "SELECT f FROM Funcionario f WHERE f.nroDocumento = :nroDocumento")
    , @NamedQuery(name = "Funcionario.findByFechaRegistro", query = "SELECT f FROM Funcionario f WHERE f.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "Funcionario.findByFechaActualizacion", query = "SELECT f FROM Funcionario f WHERE f.fechaActualizacion = :fechaActualizacion")
    , @NamedQuery(name = "Funcionario.findByEstado", query = "SELECT f FROM Funcionario f WHERE f.estado = :estado")
    , @NamedQuery(name = "Funcionario.findByDireccion", query = "SELECT f FROM Funcionario f WHERE f.direccion = :direccion")
    , @NamedQuery(name = "Funcionario.findByTelefono", query = "SELECT f FROM Funcionario f WHERE f.telefono = :telefono")
    , @NamedQuery(name = "Funcionario.findByCelular", query = "SELECT f FROM Funcionario f WHERE f.celular = :celular")})
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFuncionario")
    private Integer idFuncionario;
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
    @Column(name = "fechaRegistro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Column(name = "fechaActualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado")
    private String estado;
    @Size(max = 255)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 30)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 15)
    @Column(name = "celular")
    private String celular;
    @JoinColumn(name = "idBarrio", referencedColumnName = "idBarrio")
    @ManyToOne
    private Barrio idBarrio;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @JoinColumn(name = "idUsuarioActualizacion", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario idUsuarioActualizacion;
    @JoinColumn(name = "idUsuarioRegistro", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idUsuarioRegistro;

    public Funcionario() {
    }

    public Funcionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Funcionario(Integer idFuncionario, String nombreFuncionario, String apellidoFuncionario, Date fechaRegistro, String estado) {
        this.idFuncionario = idFuncionario;
        this.nombreFuncionario = nombreFuncionario;
        this.apellidoFuncionario = apellidoFuncionario;
        this.fechaRegistro = fechaRegistro;
        this.estado = estado;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public Barrio getIdBarrio() {
        return idBarrio;
    }

    public void setIdBarrio(Barrio idBarrio) {
        this.idBarrio = idBarrio;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
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
        hash += (idFuncionario != null ? idFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.idFuncionario == null && other.idFuncionario != null) || (this.idFuncionario != null && !this.idFuncionario.equals(other.idFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.cliente.entity.Funcionario[ idFuncionario=" + idFuncionario + " ]";
    }
    
}
