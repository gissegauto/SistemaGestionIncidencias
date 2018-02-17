/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.usuario.entity;

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
@Table(name = "rol_pantalla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolPantalla.findAll", query = "SELECT r FROM RolPantalla r")
    , @NamedQuery(name = "RolPantalla.findByIdrolPantalla", query = "SELECT r FROM RolPantalla r WHERE r.idrolPantalla = :idrolPantalla")
    , @NamedQuery(name = "RolPantalla.findByIdrol", query = "SELECT r FROM RolPantalla r WHERE r.idrol = :idrol")})
public class RolPantalla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrol_pantalla")
    private Integer idrolPantalla;
    @JoinColumn(name = "idrol", referencedColumnName = "idrol")
    @ManyToOne
    private Rol idrol;
    @JoinColumn(name = "idpantalla", referencedColumnName = "idpantalla")
    @ManyToOne
    private Pantalla idpantalla;

    public RolPantalla() {
    }

    public RolPantalla(Integer idrolPantalla) {
        this.idrolPantalla = idrolPantalla;
    }

    public Integer getIdrolPantalla() {
        return idrolPantalla;
    }

    public void setIdrolPantalla(Integer idrolPantalla) {
        this.idrolPantalla = idrolPantalla;
    }

    public Pantalla getIdpantalla() {
        return idpantalla;
    }

    public void setIdpantalla(Pantalla idpantalla) {
        this.idpantalla = idpantalla;
    }

    public Rol getIdRol() {
        return idrol;
    }

    public void setIdRol(Rol idrol) {
        this.idrol = idrol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrolPantalla != null ? idrolPantalla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolPantalla)) {
            return false;
        }
        RolPantalla other = (RolPantalla) object;
        if ((this.idrolPantalla == null && other.idrolPantalla != null) || (this.idrolPantalla != null && !this.idrolPantalla.equals(other.idrolPantalla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.usuarios.entity.RolPantalla[ idrolPantalla=" + idrolPantalla + " ]";
    }

}
