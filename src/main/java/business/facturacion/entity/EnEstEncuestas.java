/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.facturacion.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ggauto
 */
@Entity
@Table(name = "EN_EST_ENCUESTAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnEstEncuestas.findAll", query = "SELECT e FROM EnEstEncuestas e")
    , @NamedQuery(name = "EnEstEncuestas.findByCodEstado", query = "SELECT e FROM EnEstEncuestas e WHERE e.codEstado = :codEstado")
    , @NamedQuery(name = "EnEstEncuestas.findByDescripcion", query = "SELECT e FROM EnEstEncuestas e WHERE e.descripcion = :descripcion")
    , @NamedQuery(name = "EnEstEncuestas.findByUsuInsercion", query = "SELECT e FROM EnEstEncuestas e WHERE e.usuInsercion = :usuInsercion")
    , @NamedQuery(name = "EnEstEncuestas.findByFecInsercion", query = "SELECT e FROM EnEstEncuestas e WHERE e.fecInsercion = :fecInsercion")
    , @NamedQuery(name = "EnEstEncuestas.findByUsuModificacion", query = "SELECT e FROM EnEstEncuestas e WHERE e.usuModificacion = :usuModificacion")
    , @NamedQuery(name = "EnEstEncuestas.findByFecModificacion", query = "SELECT e FROM EnEstEncuestas e WHERE e.fecModificacion = :fecModificacion")})
public class EnEstEncuestas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_ESTADO")
    private Long codEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "USU_INSERCION")
    private String usuInsercion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_INSERCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecInsercion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "USU_MODIFICACION")
    private String usuModificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecModificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEstado")
    private List<EnEncAsignadas> enEncAsignadasList;

    public EnEstEncuestas() {
    }

    public EnEstEncuestas(Long codEstado) {
        this.codEstado = codEstado;
    }

    public EnEstEncuestas(Long codEstado, String descripcion, String usuInsercion, Date fecInsercion, String usuModificacion, Date fecModificacion) {
        this.codEstado = codEstado;
        this.descripcion = descripcion;
        this.usuInsercion = usuInsercion;
        this.fecInsercion = fecInsercion;
        this.usuModificacion = usuModificacion;
        this.fecModificacion = fecModificacion;
    }

    public Long getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(Long codEstado) {
        this.codEstado = codEstado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUsuInsercion() {
        return usuInsercion;
    }

    public void setUsuInsercion(String usuInsercion) {
        this.usuInsercion = usuInsercion;
    }

    public Date getFecInsercion() {
        return fecInsercion;
    }

    public void setFecInsercion(Date fecInsercion) {
        this.fecInsercion = fecInsercion;
    }

    public String getUsuModificacion() {
        return usuModificacion;
    }

    public void setUsuModificacion(String usuModificacion) {
        this.usuModificacion = usuModificacion;
    }

    public Date getFecModificacion() {
        return fecModificacion;
    }

    public void setFecModificacion(Date fecModificacion) {
        this.fecModificacion = fecModificacion;
    }

    @XmlTransient
    public List<EnEncAsignadas> getEnEncAsignadasList() {
        return enEncAsignadasList;
    }

    public void setEnEncAsignadasList(List<EnEncAsignadas> enEncAsignadasList) {
        this.enEncAsignadasList = enEncAsignadasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEstado != null ? codEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnEstEncuestas)) {
            return false;
        }
        EnEstEncuestas other = (EnEstEncuestas) object;
        if ((this.codEstado == null && other.codEstado != null) || (this.codEstado != null && !this.codEstado.equals(other.codEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.facturacion.entity.EnEstEncuestas[ codEstado=" + codEstado + " ]";
    }
    
}
