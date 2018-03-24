/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.cliente.entity;

import business.funcionario.entity.Funcionario;
import business.solicitudes.entity.SolicitudConexion;
import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ggauto
 */
@Entity
@Table(name = "cliente_solicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClienteSolicitud.findAll", query = "SELECT c FROM ClienteSolicitud c")
    , @NamedQuery(name = "ClienteSolicitud.findByIdClienteSolicitud", query = "SELECT c FROM ClienteSolicitud c WHERE c.idClienteSolicitud = :idClienteSolicitud")})
public class ClienteSolicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idClienteSolicitud")
    private Integer idClienteSolicitud;
    @JoinColumn(name = "idSolicitudConexion", referencedColumnName = "idSolicitudConexion")
    @ManyToOne(optional = false)
    private SolicitudConexion idSolicitudConexion;
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "idFuncionario", referencedColumnName = "idFuncionario")
    @ManyToOne(optional = false)
    private Funcionario idFuncionario;

    public ClienteSolicitud() {
    }

    public ClienteSolicitud(Integer idClienteSolicitud) {
        this.idClienteSolicitud = idClienteSolicitud;
    }

    public Integer getIdClienteSolicitud() {
        return idClienteSolicitud;
    }

    public void setIdClienteSolicitud(Integer idClienteSolicitud) {
        this.idClienteSolicitud = idClienteSolicitud;
    }

    public SolicitudConexion getIdSolicitudConexion() {
        return idSolicitudConexion;
    }

    public void setIdSolicitudConexion(SolicitudConexion idSolicitudConexion) {
        this.idSolicitudConexion = idSolicitudConexion;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClienteSolicitud != null ? idClienteSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteSolicitud)) {
            return false;
        }
        ClienteSolicitud other = (ClienteSolicitud) object;
        if ((this.idClienteSolicitud == null && other.idClienteSolicitud != null) || (this.idClienteSolicitud != null && !this.idClienteSolicitud.equals(other.idClienteSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.cliente.entity.ClienteSolicitud[ idClienteSolicitud=" + idClienteSolicitud + " ]";
    }
    
}
