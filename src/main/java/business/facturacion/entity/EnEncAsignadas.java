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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "EN_ENC_ASIGNADAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnEncAsignadas.findAll", query = "SELECT e FROM EnEncAsignadas e")
    , @NamedQuery(name = "EnEncAsignadas.findByCodEncAsignada", query = "SELECT e FROM EnEncAsignadas e WHERE e.codEncAsignada = :codEncAsignada")
    , @NamedQuery(name = "EnEncAsignadas.findByFecAsignacion", query = "SELECT e FROM EnEncAsignadas e WHERE e.fecAsignacion = :fecAsignacion")
    , @NamedQuery(name = "EnEncAsignadas.findByBasEstado", query = "SELECT e FROM EnEncAsignadas e WHERE e.basEstado = :basEstado")
    , @NamedQuery(name = "EnEncAsignadas.findByBasAlerta", query = "SELECT e FROM EnEncAsignadas e WHERE e.basAlerta = :basAlerta")
    , @NamedQuery(name = "EnEncAsignadas.findByFecEnvAlco", query = "SELECT e FROM EnEncAsignadas e WHERE e.fecEnvAlco = :fecEnvAlco")
    , @NamedQuery(name = "EnEncAsignadas.findByUsuInsercion", query = "SELECT e FROM EnEncAsignadas e WHERE e.usuInsercion = :usuInsercion")
    , @NamedQuery(name = "EnEncAsignadas.findByFecInsercion", query = "SELECT e FROM EnEncAsignadas e WHERE e.fecInsercion = :fecInsercion")
    , @NamedQuery(name = "EnEncAsignadas.findByUsuModificacion", query = "SELECT e FROM EnEncAsignadas e WHERE e.usuModificacion = :usuModificacion")
    , @NamedQuery(name = "EnEncAsignadas.findByFecModificacion", query = "SELECT e FROM EnEncAsignadas e WHERE e.fecModificacion = :fecModificacion")})
public class EnEncAsignadas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_ENC_ASIGNADA")
    private Long codEncAsignada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_ASIGNACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecAsignacion;
    @Column(name = "BAS_ESTADO")
    private Short basEstado;
    @Column(name = "BAS_ALERTA")
    private Short basAlerta;
    @Column(name = "FEC_ENV_ALCO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecEnvAlco;
    @Size(max = 10)
    @Column(name = "USU_INSERCION")
    private String usuInsercion;
    @Column(name = "FEC_INSERCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecInsercion;
    @Size(max = 10)
    @Column(name = "USU_MODIFICACION")
    private String usuModificacion;
    @Column(name = "FEC_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecModificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEncAsignada")
    private List<EnRespuestas> enRespuestasList;
    @JoinColumn(name = "COD_ENC_EXPERIENCIA", referencedColumnName = "COD_ENC_EXPERIENCIA")
    @ManyToOne(optional = false)
    private EnEncExperiencia codEncExperiencia;
    @JoinColumn(name = "COD_ESTADO", referencedColumnName = "COD_ESTADO")
    @ManyToOne(optional = false)
    private EnEstEncuestas codEstado;
    @JoinColumn(name = "COD_PERSONA", referencedColumnName = "COD_PERSONA")
    @ManyToOne
    private EnPersonas codPersona;

    public EnEncAsignadas() {
    }

    public EnEncAsignadas(Long codEncAsignada) {
        this.codEncAsignada = codEncAsignada;
    }

    public EnEncAsignadas(Long codEncAsignada, Date fecAsignacion) {
        this.codEncAsignada = codEncAsignada;
        this.fecAsignacion = fecAsignacion;
    }

    public Long getCodEncAsignada() {
        return codEncAsignada;
    }

    public void setCodEncAsignada(Long codEncAsignada) {
        this.codEncAsignada = codEncAsignada;
    }

    public Date getFecAsignacion() {
        return fecAsignacion;
    }

    public void setFecAsignacion(Date fecAsignacion) {
        this.fecAsignacion = fecAsignacion;
    }

    public Short getBasEstado() {
        return basEstado;
    }

    public void setBasEstado(Short basEstado) {
        this.basEstado = basEstado;
    }

    public Short getBasAlerta() {
        return basAlerta;
    }

    public void setBasAlerta(Short basAlerta) {
        this.basAlerta = basAlerta;
    }

    public Date getFecEnvAlco() {
        return fecEnvAlco;
    }

    public void setFecEnvAlco(Date fecEnvAlco) {
        this.fecEnvAlco = fecEnvAlco;
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
    public List<EnRespuestas> getEnRespuestasList() {
        return enRespuestasList;
    }

    public void setEnRespuestasList(List<EnRespuestas> enRespuestasList) {
        this.enRespuestasList = enRespuestasList;
    }

    public EnEncExperiencia getCodEncExperiencia() {
        return codEncExperiencia;
    }

    public void setCodEncExperiencia(EnEncExperiencia codEncExperiencia) {
        this.codEncExperiencia = codEncExperiencia;
    }

    public EnEstEncuestas getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(EnEstEncuestas codEstado) {
        this.codEstado = codEstado;
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
        hash += (codEncAsignada != null ? codEncAsignada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnEncAsignadas)) {
            return false;
        }
        EnEncAsignadas other = (EnEncAsignadas) object;
        if ((this.codEncAsignada == null && other.codEncAsignada != null) || (this.codEncAsignada != null && !this.codEncAsignada.equals(other.codEncAsignada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.facturacion.entity.EnEncAsignadas[ codEncAsignada=" + codEncAsignada + " ]";
    }
    
}
