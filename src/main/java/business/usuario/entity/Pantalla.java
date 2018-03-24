/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.usuario.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "pantalla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pantalla.findAll", query = "SELECT p FROM Pantalla p")
    , @NamedQuery(name = "Pantalla.findByIdpantalla", query = "SELECT p FROM Pantalla p WHERE p.idpantalla = :idpantalla")
    , @NamedQuery(name = "Pantalla.findByDescripcion", query = "SELECT p FROM Pantalla p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Pantalla.findByCodigoPantalla", query = "SELECT p FROM Pantalla p WHERE p.codigoPantalla = :codigoPantalla")})
public class Pantalla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpantalla")
    private Integer idpantalla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "codigo_pantalla")
    private String codigoPantalla;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpantalla")
    private Collection<RolPantalla> rolPantallaCollection;

    public Pantalla() {
    }

    public Pantalla(Integer idpantalla) {
        this.idpantalla = idpantalla;
    }

    public Pantalla(Integer idpantalla, String descripcion, String codigoPantalla) {
        this.idpantalla = idpantalla;
        this.descripcion = descripcion;
        this.codigoPantalla = codigoPantalla;
    }

    public Integer getIdpantalla() {
        return idpantalla;
    }

    public void setIdpantalla(Integer idpantalla) {
        this.idpantalla = idpantalla;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigoPantalla() {
        return codigoPantalla;
    }

    public void setCodigoPantalla(String codigoPantalla) {
        this.codigoPantalla = codigoPantalla;
    }

    @XmlTransient
    public Collection<RolPantalla> getRolPantallaCollection() {
        return rolPantallaCollection;
    }

    public void setRolPantallaCollection(Collection<RolPantalla> rolPantallaCollection) {
        this.rolPantallaCollection = rolPantallaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpantalla != null ? idpantalla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pantalla)) {
            return false;
        }
        Pantalla other = (Pantalla) object;
        if ((this.idpantalla == null && other.idpantalla != null) || (this.idpantalla != null && !this.idpantalla.equals(other.idpantalla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.usuario.entity.Pantalla[ idpantalla=" + idpantalla + " ]";
    }
    
}
