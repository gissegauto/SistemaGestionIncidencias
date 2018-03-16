/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.direccion.entity;

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
@Table(name = "zona_barrio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZonaBarrio.findAll", query = "SELECT z FROM ZonaBarrio z")
    , @NamedQuery(name = "ZonaBarrio.findByIdZonabarrio", query = "SELECT z FROM ZonaBarrio z WHERE z.idZonabarrio = :idZonabarrio")})
public class ZonaBarrio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idZona_barrio")
    private Integer idZonabarrio;
    @JoinColumn(name = "idZona", referencedColumnName = "idZona")
    @ManyToOne(optional = false)
    private Zona idZona;
    @JoinColumn(name = "idBarrio", referencedColumnName = "idBarrio")
    @ManyToOne(optional = false)
    private Barrio idBarrio;

    public ZonaBarrio() {
    }

    public ZonaBarrio(Integer idZonabarrio) {
        this.idZonabarrio = idZonabarrio;
    }

    public Integer getIdZonabarrio() {
        return idZonabarrio;
    }

    public void setIdZonabarrio(Integer idZonabarrio) {
        this.idZonabarrio = idZonabarrio;
    }

    public Zona getIdZona() {
        return idZona;
    }

    public void setIdZona(Zona idZona) {
        this.idZona = idZona;
    }

    public Barrio getIdBarrio() {
        return idBarrio;
    }

    public void setIdBarrio(Barrio idBarrio) {
        this.idBarrio = idBarrio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idZonabarrio != null ? idZonabarrio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZonaBarrio)) {
            return false;
        }
        ZonaBarrio other = (ZonaBarrio) object;
        if ((this.idZonabarrio == null && other.idZonabarrio != null) || (this.idZonabarrio != null && !this.idZonabarrio.equals(other.idZonabarrio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.direccion.entity.ZonaBarrio[ idZonabarrio=" + idZonabarrio + " ]";
    }
    
}
