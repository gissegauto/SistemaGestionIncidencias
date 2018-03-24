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
    , @NamedQuery(name = "RolPantalla.findByIdRolPantalla", query = "SELECT r FROM RolPantalla r WHERE r.idRolPantalla = :idRolPantalla")})
public class RolPantalla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRolPantalla")
    private Integer idRolPantalla;
    @JoinColumn(name = "idpantalla", referencedColumnName = "idpantalla")
    @ManyToOne(optional = false)
    private Pantalla idpantalla;
    @JoinColumn(name = "idrol", referencedColumnName = "idrol")
    @ManyToOne(optional = false)
    private Rol idrol;

    public RolPantalla() {
    }

    public RolPantalla(Integer idRolPantalla) {
        this.idRolPantalla = idRolPantalla;
    }

    public Integer getIdRolPantalla() {
        return idRolPantalla;
    }

    public void setIdRolPantalla(Integer idRolPantalla) {
        this.idRolPantalla = idRolPantalla;
    }

    public Pantalla getIdpantalla() {
        return idpantalla;
    }

    public void setIdpantalla(Pantalla idpantalla) {
        this.idpantalla = idpantalla;
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
        hash += (idRolPantalla != null ? idRolPantalla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolPantalla)) {
            return false;
        }
        RolPantalla other = (RolPantalla) object;
        if ((this.idRolPantalla == null && other.idRolPantalla != null) || (this.idRolPantalla != null && !this.idRolPantalla.equals(other.idRolPantalla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.usuario.entity.RolPantalla[ idRolPantalla=" + idRolPantalla + " ]";
    }
    
}
