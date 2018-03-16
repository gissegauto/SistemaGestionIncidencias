/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.direccion.entity;

import business.cliente.entity.Cliente;
import business.funcionario.entity.Funcionario;
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
@Table(name = "barrio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Barrio.findAll", query = "SELECT b FROM Barrio b")
    , @NamedQuery(name = "Barrio.findByIdBarrio", query = "SELECT b FROM Barrio b WHERE b.idBarrio = :idBarrio")
    , @NamedQuery(name = "Barrio.findByCiudad", query = "SELECT b FROM Barrio b WHERE b.idCiudad = :idCiudad")
    , @NamedQuery(name = "Barrio.findByBarrio", query = "SELECT b FROM Barrio b WHERE b.barrio = :barrio")})
public class Barrio implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBarrio")
    private Collection<ZonaBarrio> zonaBarrioCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBarrio")
    private Collection<SolicitudConexion> solicitudConexionCollection;

    @OneToMany(mappedBy = "idBarrio")
    private Collection<Funcionario> funcionarioCollection;

    @OneToMany(mappedBy = "idBarrio")
    private Collection<Cliente> clienteCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBarrio")
    private Integer idBarrio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "barrio")
    private String barrio;
    @JoinColumn(name = "idCiudad", referencedColumnName = "idCiudad")
    @ManyToOne(optional = false)
    private Ciudad idCiudad;

    public Barrio() {
    }

    public Barrio(Integer idBarrio) {
        this.idBarrio = idBarrio;
    }

    public Barrio(Integer idBarrio, String barrio) {
        this.idBarrio = idBarrio;
        this.barrio = barrio;
    }

    public Integer getIdBarrio() {
        return idBarrio;
    }

    public void setIdBarrio(Integer idBarrio) {
        this.idBarrio = idBarrio;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public Ciudad getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Ciudad idCiudad) {
        this.idCiudad = idCiudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBarrio != null ? idBarrio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Barrio)) {
            return false;
        }
        Barrio other = (Barrio) object;
        if ((this.idBarrio == null && other.idBarrio != null) || (this.idBarrio != null && !this.idBarrio.equals(other.idBarrio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.direccion.entity.Barrio[ idBarrio=" + idBarrio + " ]";
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @XmlTransient
    public Collection<Funcionario> getFuncionarioCollection() {
        return funcionarioCollection;
    }

    public void setFuncionarioCollection(Collection<Funcionario> funcionarioCollection) {
        this.funcionarioCollection = funcionarioCollection;
    }

    @XmlTransient
    public Collection<SolicitudConexion> getSolicitudConexionCollection() {
        return solicitudConexionCollection;
    }

    public void setSolicitudConexionCollection(Collection<SolicitudConexion> solicitudConexionCollection) {
        this.solicitudConexionCollection = solicitudConexionCollection;
    }

    @XmlTransient
    public Collection<ZonaBarrio> getZonaBarrioCollection() {
        return zonaBarrioCollection;
    }

    public void setZonaBarrioCollection(Collection<ZonaBarrio> zonaBarrioCollection) {
        this.zonaBarrioCollection = zonaBarrioCollection;
    }
    
}
