/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.usuario.entity;

import business.cliente.entity.Cliente;
import business.cliente.entity.HistorialCliente;
import business.solicitudes.entity.HistorialSolicitudConexion;
import business.solicitudes.entity.SolicitudConexion;
import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ggauto
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdusuario", query = "SELECT u FROM Usuario u WHERE u.idusuario = :idusuario")
    , @NamedQuery(name = "Usuario.findByUsername", query = "SELECT u FROM Usuario u WHERE u.username = :username")
    , @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password")})
public class Usuario implements Serializable {

    @OneToMany(mappedBy = "idUsuarioActualizacion")
    private Collection<Cliente> clienteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioRegistro")
    private Collection<Cliente> clienteCollection1;
    @OneToMany(mappedBy = "idUsuarioActualizacion")
    private Collection<HistorialCliente> historialClienteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioRegistro")
    private Collection<HistorialCliente> historialClienteCollection1;

    @OneToMany(mappedBy = "idUsuarioActualizacion")
    private Collection<HistorialSolicitudConexion> historialSolicitudConexionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioRegistro")
    private Collection<HistorialSolicitudConexion> historialSolicitudConexionCollection1;
    @OneToMany(mappedBy = "idUsuarioActualizacion")
    private Collection<SolicitudConexion> solicitudConexionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioRegistro")
    private Collection<SolicitudConexion> solicitudConexionCollection1;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuario")
    private Integer idusuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "idrol", referencedColumnName = "idrol")
    @ManyToOne(optional = false)
    private Rol idrol;

    public Usuario() {
    }

    public Usuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Usuario(Integer idusuario, String username, String password) {
        this.idusuario = idusuario;
        this.username = username;
        this.password = password;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getIdrol() {
        return idrol;
    }

    public void setIdrol(Rol idrol) {
        this.idrol = idrol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.usuario.entity.Usuario[ idusuario=" + idusuario + " ]";
    }

    @XmlTransient
    public Collection<HistorialSolicitudConexion> getHistorialSolicitudConexionCollection() {
        return historialSolicitudConexionCollection;
    }

    public void setHistorialSolicitudConexionCollection(Collection<HistorialSolicitudConexion> historialSolicitudConexionCollection) {
        this.historialSolicitudConexionCollection = historialSolicitudConexionCollection;
    }

    @XmlTransient
    public Collection<HistorialSolicitudConexion> getHistorialSolicitudConexionCollection1() {
        return historialSolicitudConexionCollection1;
    }

    public void setHistorialSolicitudConexionCollection1(Collection<HistorialSolicitudConexion> historialSolicitudConexionCollection1) {
        this.historialSolicitudConexionCollection1 = historialSolicitudConexionCollection1;
    }

    @XmlTransient
    public Collection<SolicitudConexion> getSolicitudConexionCollection() {
        return solicitudConexionCollection;
    }

    public void setSolicitudConexionCollection(Collection<SolicitudConexion> solicitudConexionCollection) {
        this.solicitudConexionCollection = solicitudConexionCollection;
    }

    @XmlTransient
    public Collection<SolicitudConexion> getSolicitudConexionCollection1() {
        return solicitudConexionCollection1;
    }

    public void setSolicitudConexionCollection1(Collection<SolicitudConexion> solicitudConexionCollection1) {
        this.solicitudConexionCollection1 = solicitudConexionCollection1;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection1() {
        return clienteCollection1;
    }

    public void setClienteCollection1(Collection<Cliente> clienteCollection1) {
        this.clienteCollection1 = clienteCollection1;
    }

    @XmlTransient
    public Collection<HistorialCliente> getHistorialClienteCollection() {
        return historialClienteCollection;
    }

    public void setHistorialClienteCollection(Collection<HistorialCliente> historialClienteCollection) {
        this.historialClienteCollection = historialClienteCollection;
    }

    @XmlTransient
    public Collection<HistorialCliente> getHistorialClienteCollection1() {
        return historialClienteCollection1;
    }

    public void setHistorialClienteCollection1(Collection<HistorialCliente> historialClienteCollection1) {
        this.historialClienteCollection1 = historialClienteCollection1;
    }
    
}
