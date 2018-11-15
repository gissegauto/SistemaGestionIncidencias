/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.facturacion.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "EN_WHITELIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnWhitelist.findAll", query = "SELECT e FROM EnWhitelist e")
    , @NamedQuery(name = "EnWhitelist.findByCodWhitelist", query = "SELECT e FROM EnWhitelist e WHERE e.codWhitelist = :codWhitelist")
    , @NamedQuery(name = "EnWhitelist.findByCodPersona", query = "SELECT e FROM EnWhitelist e WHERE e.codPersona = :codPersona")
    , @NamedQuery(name = "EnWhitelist.findByObservacion", query = "SELECT e FROM EnWhitelist e WHERE e.observacion = :observacion")
    , @NamedQuery(name = "EnWhitelist.findByUsuInsercion", query = "SELECT e FROM EnWhitelist e WHERE e.usuInsercion = :usuInsercion")
    , @NamedQuery(name = "EnWhitelist.findByFecInsercion", query = "SELECT e FROM EnWhitelist e WHERE e.fecInsercion = :fecInsercion")
    , @NamedQuery(name = "EnWhitelist.findByUsuModificacion", query = "SELECT e FROM EnWhitelist e WHERE e.usuModificacion = :usuModificacion")
    , @NamedQuery(name = "EnWhitelist.findByFecModificacion", query = "SELECT e FROM EnWhitelist e WHERE e.fecModificacion = :fecModificacion")
    , @NamedQuery(name = "EnWhitelist.findByEstado", query = "SELECT e FROM EnWhitelist e WHERE e.estado = :estado")})
public class EnWhitelist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_WHITELIST")
    private Long codWhitelist;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "COD_PERSONA")
    private String codPersona;
    @Size(max = 255)
    @Column(name = "OBSERVACION")
    private String observacion;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "COD_ENC_EXPERIENCIA", referencedColumnName = "COD_ENC_EXPERIENCIA")
    @ManyToOne(optional = false)
    private EnEncExperiencia codEncExperiencia;

    public EnWhitelist() {
    }

    public EnWhitelist(Long codWhitelist) {
        this.codWhitelist = codWhitelist;
    }

    public EnWhitelist(Long codWhitelist, String codPersona, String usuInsercion, Date fecInsercion, String usuModificacion, Date fecModificacion, String estado) {
        this.codWhitelist = codWhitelist;
        this.codPersona = codPersona;
        this.usuInsercion = usuInsercion;
        this.fecInsercion = fecInsercion;
        this.usuModificacion = usuModificacion;
        this.fecModificacion = fecModificacion;
        this.estado = estado;
    }

    public Long getCodWhitelist() {
        return codWhitelist;
    }

    public void setCodWhitelist(Long codWhitelist) {
        this.codWhitelist = codWhitelist;
    }

    public String getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(String codPersona) {
        this.codPersona = codPersona;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public EnEncExperiencia getCodEncExperiencia() {
        return codEncExperiencia;
    }

    public void setCodEncExperiencia(EnEncExperiencia codEncExperiencia) {
        this.codEncExperiencia = codEncExperiencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codWhitelist != null ? codWhitelist.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnWhitelist)) {
            return false;
        }
        EnWhitelist other = (EnWhitelist) object;
        if ((this.codWhitelist == null && other.codWhitelist != null) || (this.codWhitelist != null && !this.codWhitelist.equals(other.codWhitelist))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.facturacion.entity.EnWhitelist[ codWhitelist=" + codWhitelist + " ]";
    }
    
}
