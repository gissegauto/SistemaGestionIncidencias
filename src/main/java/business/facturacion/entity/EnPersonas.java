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
@Table(name = "EN_PERSONAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnPersonas.findAll", query = "SELECT e FROM EnPersonas e")
    , @NamedQuery(name = "EnPersonas.findByCodPersona", query = "SELECT e FROM EnPersonas e WHERE e.codPersona = :codPersona")
    , @NamedQuery(name = "EnPersonas.findBySegEstCivil", query = "SELECT e FROM EnPersonas e WHERE e.segEstCivil = :segEstCivil")
    , @NamedQuery(name = "EnPersonas.findBySegGenCliente", query = "SELECT e FROM EnPersonas e WHERE e.segGenCliente = :segGenCliente")
    , @NamedQuery(name = "EnPersonas.findByFrecuencia", query = "SELECT e FROM EnPersonas e WHERE e.frecuencia = :frecuencia")
    , @NamedQuery(name = "EnPersonas.findByOtrTipCliente", query = "SELECT e FROM EnPersonas e WHERE e.otrTipCliente = :otrTipCliente")
    , @NamedQuery(name = "EnPersonas.findByUsuInsercion", query = "SELECT e FROM EnPersonas e WHERE e.usuInsercion = :usuInsercion")
    , @NamedQuery(name = "EnPersonas.findByFecInsercion", query = "SELECT e FROM EnPersonas e WHERE e.fecInsercion = :fecInsercion")
    , @NamedQuery(name = "EnPersonas.findByUsuModificacion", query = "SELECT e FROM EnPersonas e WHERE e.usuModificacion = :usuModificacion")
    , @NamedQuery(name = "EnPersonas.findByFecModificacion", query = "SELECT e FROM EnPersonas e WHERE e.fecModificacion = :fecModificacion")})
public class EnPersonas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "COD_PERSONA")
    private String codPersona;
    @Size(max = 15)
    @Column(name = "SEG_EST_CIVIL")
    private String segEstCivil;
    @Size(max = 20)
    @Column(name = "SEG_GEN_CLIENTE")
    private String segGenCliente;
    @Column(name = "FRECUENCIA")
    private Short frecuencia;
    @Size(max = 1)
    @Column(name = "OTR_TIP_CLIENTE")
    private String otrTipCliente;
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
    @OneToMany(mappedBy = "codPersona")
    private List<EnEncAsignadas> enEncAsignadasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPersona")
    private List<EnBlacklist> enBlacklistList;
    @OneToMany(mappedBy = "codPersona")
    private List<EnPerDetalle> enPerDetalleList;

    public EnPersonas() {
    }

    public EnPersonas(String codPersona) {
        this.codPersona = codPersona;
    }

    public EnPersonas(String codPersona, String usuInsercion, Date fecInsercion, String usuModificacion, Date fecModificacion) {
        this.codPersona = codPersona;
        this.usuInsercion = usuInsercion;
        this.fecInsercion = fecInsercion;
        this.usuModificacion = usuModificacion;
        this.fecModificacion = fecModificacion;
    }

    public String getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(String codPersona) {
        this.codPersona = codPersona;
    }

    public String getSegEstCivil() {
        return segEstCivil;
    }

    public void setSegEstCivil(String segEstCivil) {
        this.segEstCivil = segEstCivil;
    }

    public String getSegGenCliente() {
        return segGenCliente;
    }

    public void setSegGenCliente(String segGenCliente) {
        this.segGenCliente = segGenCliente;
    }

    public Short getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(Short frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getOtrTipCliente() {
        return otrTipCliente;
    }

    public void setOtrTipCliente(String otrTipCliente) {
        this.otrTipCliente = otrTipCliente;
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

    @XmlTransient
    public List<EnBlacklist> getEnBlacklistList() {
        return enBlacklistList;
    }

    public void setEnBlacklistList(List<EnBlacklist> enBlacklistList) {
        this.enBlacklistList = enBlacklistList;
    }

    @XmlTransient
    public List<EnPerDetalle> getEnPerDetalleList() {
        return enPerDetalleList;
    }

    public void setEnPerDetalleList(List<EnPerDetalle> enPerDetalleList) {
        this.enPerDetalleList = enPerDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPersona != null ? codPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnPersonas)) {
            return false;
        }
        EnPersonas other = (EnPersonas) object;
        if ((this.codPersona == null && other.codPersona != null) || (this.codPersona != null && !this.codPersona.equals(other.codPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.facturacion.entity.EnPersonas[ codPersona=" + codPersona + " ]";
    }
    
}
