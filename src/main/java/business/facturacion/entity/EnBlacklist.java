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
@Table(name = "EN_BLACKLIST")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnBlacklist.findAll", query = "SELECT e FROM EnBlacklist e")
    , @NamedQuery(name = "EnBlacklist.findByCodBlacklist", query = "SELECT e FROM EnBlacklist e WHERE e.codBlacklist = :codBlacklist")
    , @NamedQuery(name = "EnBlacklist.findByTipoBloqueo", query = "SELECT e FROM EnBlacklist e WHERE e.tipoBloqueo = :tipoBloqueo")
    , @NamedQuery(name = "EnBlacklist.findByUsuInsercion", query = "SELECT e FROM EnBlacklist e WHERE e.usuInsercion = :usuInsercion")
    , @NamedQuery(name = "EnBlacklist.findByFecInsercion", query = "SELECT e FROM EnBlacklist e WHERE e.fecInsercion = :fecInsercion")
    , @NamedQuery(name = "EnBlacklist.findByUsuModificacion", query = "SELECT e FROM EnBlacklist e WHERE e.usuModificacion = :usuModificacion")
    , @NamedQuery(name = "EnBlacklist.findByFecModificacion", query = "SELECT e FROM EnBlacklist e WHERE e.fecModificacion = :fecModificacion")
    , @NamedQuery(name = "EnBlacklist.findByEstado", query = "SELECT e FROM EnBlacklist e WHERE e.estado = :estado")})
public class EnBlacklist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_BLACKLIST")
    private Long codBlacklist;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_BLOQUEO")
    private short tipoBloqueo;
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
    @ManyToOne
    private EnEncExperiencia codEncExperiencia;
    @JoinColumn(name = "COD_PERSONA", referencedColumnName = "COD_PERSONA")
    @ManyToOne(optional = false)
    private EnPersonas codPersona;

    public EnBlacklist() {
    }

    public EnBlacklist(Long codBlacklist) {
        this.codBlacklist = codBlacklist;
    }

    public EnBlacklist(Long codBlacklist, short tipoBloqueo, String usuInsercion, Date fecInsercion, String usuModificacion, Date fecModificacion, String estado) {
        this.codBlacklist = codBlacklist;
        this.tipoBloqueo = tipoBloqueo;
        this.usuInsercion = usuInsercion;
        this.fecInsercion = fecInsercion;
        this.usuModificacion = usuModificacion;
        this.fecModificacion = fecModificacion;
        this.estado = estado;
    }

    public Long getCodBlacklist() {
        return codBlacklist;
    }

    public void setCodBlacklist(Long codBlacklist) {
        this.codBlacklist = codBlacklist;
    }

    public short getTipoBloqueo() {
        return tipoBloqueo;
    }

    public void setTipoBloqueo(short tipoBloqueo) {
        this.tipoBloqueo = tipoBloqueo;
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

    public EnPersonas getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(EnPersonas codPersona) {
        this.codPersona = codPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codBlacklist != null ? codBlacklist.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnBlacklist)) {
            return false;
        }
        EnBlacklist other = (EnBlacklist) object;
        if ((this.codBlacklist == null && other.codBlacklist != null) || (this.codBlacklist != null && !this.codBlacklist.equals(other.codBlacklist))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.facturacion.entity.EnBlacklist[ codBlacklist=" + codBlacklist + " ]";
    }
    
}
