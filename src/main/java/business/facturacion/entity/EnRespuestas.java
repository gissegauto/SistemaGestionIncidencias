/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.facturacion.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "EN_RESPUESTAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnRespuestas.findAll", query = "SELECT e FROM EnRespuestas e")
    , @NamedQuery(name = "EnRespuestas.findByCodRespuesta", query = "SELECT e FROM EnRespuestas e WHERE e.codRespuesta = :codRespuesta")
    , @NamedQuery(name = "EnRespuestas.findByCanal", query = "SELECT e FROM EnRespuestas e WHERE e.canal = :canal")
    , @NamedQuery(name = "EnRespuestas.findByFecCompleto", query = "SELECT e FROM EnRespuestas e WHERE e.fecCompleto = :fecCompleto")
    , @NamedQuery(name = "EnRespuestas.findByComentarios", query = "SELECT e FROM EnRespuestas e WHERE e.comentarios = :comentarios")
    , @NamedQuery(name = "EnRespuestas.findByUsuInsercion", query = "SELECT e FROM EnRespuestas e WHERE e.usuInsercion = :usuInsercion")
    , @NamedQuery(name = "EnRespuestas.findByFecInsercion", query = "SELECT e FROM EnRespuestas e WHERE e.fecInsercion = :fecInsercion")
    , @NamedQuery(name = "EnRespuestas.findByUsuModificacion", query = "SELECT e FROM EnRespuestas e WHERE e.usuModificacion = :usuModificacion")
    , @NamedQuery(name = "EnRespuestas.findByFecModificacion", query = "SELECT e FROM EnRespuestas e WHERE e.fecModificacion = :fecModificacion")})
public class EnRespuestas implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_RESPUESTA")
    private BigDecimal codRespuesta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "CANAL")
    private String canal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_COMPLETO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecCompleto;
    @Size(max = 255)
    @Column(name = "COMENTARIOS")
    private String comentarios;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codRespuesta")
    private List<EnResDetalle> enResDetalleList;
    @JoinColumn(name = "COD_ENC_ASIGNADA", referencedColumnName = "COD_ENC_ASIGNADA")
    @ManyToOne(optional = false)
    private EnEncAsignadas codEncAsignada;
    @JoinColumn(name = "COD_PREGUNTA", referencedColumnName = "COD_PREGUNTA")
    @ManyToOne
    private EnPreguntas codPregunta;

    public EnRespuestas() {
    }

    public EnRespuestas(BigDecimal codRespuesta) {
        this.codRespuesta = codRespuesta;
    }

    public EnRespuestas(BigDecimal codRespuesta, String canal, Date fecCompleto, String usuInsercion, Date fecInsercion, String usuModificacion, Date fecModificacion) {
        this.codRespuesta = codRespuesta;
        this.canal = canal;
        this.fecCompleto = fecCompleto;
        this.usuInsercion = usuInsercion;
        this.fecInsercion = fecInsercion;
        this.usuModificacion = usuModificacion;
        this.fecModificacion = fecModificacion;
    }

    public BigDecimal getCodRespuesta() {
        return codRespuesta;
    }

    public void setCodRespuesta(BigDecimal codRespuesta) {
        this.codRespuesta = codRespuesta;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public Date getFecCompleto() {
        return fecCompleto;
    }

    public void setFecCompleto(Date fecCompleto) {
        this.fecCompleto = fecCompleto;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
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
    public List<EnResDetalle> getEnResDetalleList() {
        return enResDetalleList;
    }

    public void setEnResDetalleList(List<EnResDetalle> enResDetalleList) {
        this.enResDetalleList = enResDetalleList;
    }

    public EnEncAsignadas getCodEncAsignada() {
        return codEncAsignada;
    }

    public void setCodEncAsignada(EnEncAsignadas codEncAsignada) {
        this.codEncAsignada = codEncAsignada;
    }

    public EnPreguntas getCodPregunta() {
        return codPregunta;
    }

    public void setCodPregunta(EnPreguntas codPregunta) {
        this.codPregunta = codPregunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codRespuesta != null ? codRespuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnRespuestas)) {
            return false;
        }
        EnRespuestas other = (EnRespuestas) object;
        if ((this.codRespuesta == null && other.codRespuesta != null) || (this.codRespuesta != null && !this.codRespuesta.equals(other.codRespuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.facturacion.entity.EnRespuestas[ codRespuesta=" + codRespuesta + " ]";
    }
    
}
