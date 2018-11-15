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
@Table(name = "EN_ENC_EXPERIENCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnEncExperiencia.findAll", query = "SELECT e FROM EnEncExperiencia e")
    , @NamedQuery(name = "EnEncExperiencia.findByCodEncExperiencia", query = "SELECT e FROM EnEncExperiencia e WHERE e.codEncExperiencia = :codEncExperiencia")
    , @NamedQuery(name = "EnEncExperiencia.findByDiasValidez", query = "SELECT e FROM EnEncExperiencia e WHERE e.diasValidez = :diasValidez")
    , @NamedQuery(name = "EnEncExperiencia.findByCanVerbatin", query = "SELECT e FROM EnEncExperiencia e WHERE e.canVerbatin = :canVerbatin")
    , @NamedQuery(name = "EnEncExperiencia.findByAnonimo", query = "SELECT e FROM EnEncExperiencia e WHERE e.anonimo = :anonimo")
    , @NamedQuery(name = "EnEncExperiencia.findByUsuInsercion", query = "SELECT e FROM EnEncExperiencia e WHERE e.usuInsercion = :usuInsercion")
    , @NamedQuery(name = "EnEncExperiencia.findByFecInsercion", query = "SELECT e FROM EnEncExperiencia e WHERE e.fecInsercion = :fecInsercion")
    , @NamedQuery(name = "EnEncExperiencia.findByUsuModificacion", query = "SELECT e FROM EnEncExperiencia e WHERE e.usuModificacion = :usuModificacion")
    , @NamedQuery(name = "EnEncExperiencia.findByFecModificacion", query = "SELECT e FROM EnEncExperiencia e WHERE e.fecModificacion = :fecModificacion")
    , @NamedQuery(name = "EnEncExperiencia.findByEstado", query = "SELECT e FROM EnEncExperiencia e WHERE e.estado = :estado")
    , @NamedQuery(name = "EnEncExperiencia.findByRecurrencia", query = "SELECT e FROM EnEncExperiencia e WHERE e.recurrencia = :recurrencia")
    , @NamedQuery(name = "EnEncExperiencia.findByTieValInicio", query = "SELECT e FROM EnEncExperiencia e WHERE e.tieValInicio = :tieValInicio")
    , @NamedQuery(name = "EnEncExperiencia.findByTieValFin", query = "SELECT e FROM EnEncExperiencia e WHERE e.tieValFin = :tieValFin")
    , @NamedQuery(name = "EnEncExperiencia.findByPromotoras", query = "SELECT e FROM EnEncExperiencia e WHERE e.promotoras = :promotoras")
    , @NamedQuery(name = "EnEncExperiencia.findByNeutras", query = "SELECT e FROM EnEncExperiencia e WHERE e.neutras = :neutras")
    , @NamedQuery(name = "EnEncExperiencia.findByDetractoras", query = "SELECT e FROM EnEncExperiencia e WHERE e.detractoras = :detractoras")})
public class EnEncExperiencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_ENC_EXPERIENCIA")
    private Long codEncExperiencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DIAS_VALIDEZ")
    private short diasValidez;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAN_VERBATIN")
    private int canVerbatin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ANONIMO")
    private String anonimo;
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
    @Column(name = "RECURRENCIA")
    private Short recurrencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIE_VAL_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tieValInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIE_VAL_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tieValFin;
    @Column(name = "PROMOTORAS")
    private Short promotoras;
    @Column(name = "NEUTRAS")
    private Short neutras;
    @Column(name = "DETRACTORAS")
    private Short detractoras;
    @JoinColumn(name = "COD_ENCUESTA", referencedColumnName = "COD_ENCUESTA")
    @ManyToOne
    private EnEncuestas codEncuesta;
    @JoinColumn(name = "COD_EXPERIENCIA", referencedColumnName = "COD_EXPERIENCIA")
    @ManyToOne(optional = false)
    private EnExperiencias codExperiencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEncExperiencia")
    private List<EnWhitelist> enWhitelistList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEncExperiencia")
    private List<EnEncAsignadas> enEncAsignadasList;
    @OneToMany(mappedBy = "codEncExperiencia")
    private List<EnBlacklist> enBlacklistList;

    public EnEncExperiencia() {
    }

    public EnEncExperiencia(Long codEncExperiencia) {
        this.codEncExperiencia = codEncExperiencia;
    }

    public EnEncExperiencia(Long codEncExperiencia, short diasValidez, int canVerbatin, String anonimo, String usuInsercion, Date fecInsercion, String usuModificacion, Date fecModificacion, String estado, Date tieValInicio, Date tieValFin) {
        this.codEncExperiencia = codEncExperiencia;
        this.diasValidez = diasValidez;
        this.canVerbatin = canVerbatin;
        this.anonimo = anonimo;
        this.usuInsercion = usuInsercion;
        this.fecInsercion = fecInsercion;
        this.usuModificacion = usuModificacion;
        this.fecModificacion = fecModificacion;
        this.estado = estado;
        this.tieValInicio = tieValInicio;
        this.tieValFin = tieValFin;
    }

    public Long getCodEncExperiencia() {
        return codEncExperiencia;
    }

    public void setCodEncExperiencia(Long codEncExperiencia) {
        this.codEncExperiencia = codEncExperiencia;
    }

    public short getDiasValidez() {
        return diasValidez;
    }

    public void setDiasValidez(short diasValidez) {
        this.diasValidez = diasValidez;
    }

    public int getCanVerbatin() {
        return canVerbatin;
    }

    public void setCanVerbatin(int canVerbatin) {
        this.canVerbatin = canVerbatin;
    }

    public String getAnonimo() {
        return anonimo;
    }

    public void setAnonimo(String anonimo) {
        this.anonimo = anonimo;
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

    public Short getRecurrencia() {
        return recurrencia;
    }

    public void setRecurrencia(Short recurrencia) {
        this.recurrencia = recurrencia;
    }

    public Date getTieValInicio() {
        return tieValInicio;
    }

    public void setTieValInicio(Date tieValInicio) {
        this.tieValInicio = tieValInicio;
    }

    public Date getTieValFin() {
        return tieValFin;
    }

    public void setTieValFin(Date tieValFin) {
        this.tieValFin = tieValFin;
    }

    public Short getPromotoras() {
        return promotoras;
    }

    public void setPromotoras(Short promotoras) {
        this.promotoras = promotoras;
    }

    public Short getNeutras() {
        return neutras;
    }

    public void setNeutras(Short neutras) {
        this.neutras = neutras;
    }

    public Short getDetractoras() {
        return detractoras;
    }

    public void setDetractoras(Short detractoras) {
        this.detractoras = detractoras;
    }

    public EnEncuestas getCodEncuesta() {
        return codEncuesta;
    }

    public void setCodEncuesta(EnEncuestas codEncuesta) {
        this.codEncuesta = codEncuesta;
    }

    public EnExperiencias getCodExperiencia() {
        return codExperiencia;
    }

    public void setCodExperiencia(EnExperiencias codExperiencia) {
        this.codExperiencia = codExperiencia;
    }

    @XmlTransient
    public List<EnWhitelist> getEnWhitelistList() {
        return enWhitelistList;
    }

    public void setEnWhitelistList(List<EnWhitelist> enWhitelistList) {
        this.enWhitelistList = enWhitelistList;
    }

    @XmlTransient
    public List<EnEncAsignadas> getEnEncAsignadasList() {
        return enEncAsignadasList;
    }

    public void setEnEncAsignadasList(List<EnEncAsignadas> enEncAsignadasList) {
        this.enEncAsignadasList = enEncAsignadasList;
    }

    @XmlTransient
    public List<EnBlacklist> getEnBlacklistList() {
        return enBlacklistList;
    }

    public void setEnBlacklistList(List<EnBlacklist> enBlacklistList) {
        this.enBlacklistList = enBlacklistList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEncExperiencia != null ? codEncExperiencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnEncExperiencia)) {
            return false;
        }
        EnEncExperiencia other = (EnEncExperiencia) object;
        if ((this.codEncExperiencia == null && other.codEncExperiencia != null) || (this.codEncExperiencia != null && !this.codEncExperiencia.equals(other.codEncExperiencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.facturacion.entity.EnEncExperiencia[ codEncExperiencia=" + codEncExperiencia + " ]";
    }
    
}
