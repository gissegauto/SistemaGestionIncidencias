/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.usuario.entity;

import business.funcionario.entity.Funcionario;
import business.cliente.entity.Cliente;
import business.configuracion.entity.Notificaciones;
import business.funcionario.entity.Funcionario;
import business.funcionario.entity.HistorialFuncionario;
import business.solicitudes.entity.HistorialSolicitudConexion;
import business.solicitudes.entity.SolicitudConexion;
import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
    private List<Cliente> clienteList;
    @OneToMany(mappedBy = "idUsuarioRegistro")
    private List<Cliente> clienteList1;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioRegistro")
    private List<Notificaciones> notificacionesList;

    @OneToMany(mappedBy = "idUsuarioActualizacion")
    private Collection<HistorialSolicitudConexion> historialSolicitudConexionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioRegistro")
    private Collection<HistorialSolicitudConexion> historialSolicitudConexionCollection1;
    @OneToMany(mappedBy = "idUsuarioActualizacion")
    private Collection<SolicitudConexion> solicitudConexionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioRegistro")
    private Collection<SolicitudConexion> solicitudConexionCollection1;
    @OneToMany(mappedBy = "idUsuarioActualizacion")
    private Collection<Funcionario> funcionarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioRegistro")
    private Collection<Funcionario> funcionarioCollection1;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuario")
    private Integer idusuario;
    @Size(max = 45)
    @Column(name = "username")
    private String username;
    @Size(max = 45)
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "idrol", referencedColumnName = "idrol")
    @ManyToOne
    private Rol idrol;
    @JoinColumn(name = "idFuncionario", referencedColumnName = "idFuncionario")
    @ManyToOne
    private Funcionario idFuncionario;

    public Usuario() {
    }

    public Usuario(Integer idusuario) {
        this.idusuario = idusuario;
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

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
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
        return "business.usuarios.entity.Usuario[ idusuario=" + idusuario + " ]";
    }

    public Collection<HistorialSolicitudConexion> getHistorialSolicitudConexionCollection() {
        return historialSolicitudConexionCollection;
    }

    public void setHistorialSolicitudConexionCollection(Collection<HistorialSolicitudConexion> historialSolicitudConexionCollection) {
        this.historialSolicitudConexionCollection = historialSolicitudConexionCollection;
    }

    public Collection<HistorialSolicitudConexion> getHistorialSolicitudConexionCollection1() {
        return historialSolicitudConexionCollection1;
    }

    public void setHistorialSolicitudConexionCollection1(Collection<HistorialSolicitudConexion> historialSolicitudConexionCollection1) {
        this.historialSolicitudConexionCollection1 = historialSolicitudConexionCollection1;
    }

    public Collection<SolicitudConexion> getSolicitudConexionCollection() {
        return solicitudConexionCollection;
    }

    public void setSolicitudConexionCollection(Collection<SolicitudConexion> solicitudConexionCollection) {
        this.solicitudConexionCollection = solicitudConexionCollection;
    }

    public Collection<SolicitudConexion> getSolicitudConexionCollection1() {
        return solicitudConexionCollection1;
    }

    public void setSolicitudConexionCollection1(Collection<SolicitudConexion> solicitudConexionCollection1) {
        this.solicitudConexionCollection1 = solicitudConexionCollection1;
    }

    public Collection<Funcionario> getFuncionarioCollection() {
        return funcionarioCollection;
    }

    public void setFuncionarioCollection(Collection<Funcionario> funcionarioCollection) {
        this.funcionarioCollection = funcionarioCollection;
    }

    public Collection<Funcionario> getFuncionarioCollection1() {
        return funcionarioCollection1;
    }

    public void setFuncionarioCollection1(Collection<Funcionario> funcionarioCollection1) {
        this.funcionarioCollection1 = funcionarioCollection1;
    }

    @XmlTransient
    public List<Notificaciones> getNotificacionesList() {
        return notificacionesList;
    }

    public void setNotificacionesList(List<Notificaciones> notificacionesList) {
        this.notificacionesList = notificacionesList;
    }

    @XmlTransient
    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @XmlTransient
    public List<Cliente> getClienteList1() {
        return clienteList1;
    }

    public void setClienteList1(List<Cliente> clienteList1) {
        this.clienteList1 = clienteList1;
    }

}
