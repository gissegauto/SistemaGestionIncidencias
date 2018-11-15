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
@Table(name = "EN_PREGUNTAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnPreguntas.findAll", query = "SELECT e FROM EnPreguntas e")
    , @NamedQuery(name = "EnPreguntas.findByCodPregunta", query = "SELECT e FROM EnPreguntas e WHERE e.codPregunta = :codPregunta")
    , @NamedQuery(name = "EnPreguntas.findByOrden", query = "SELECT e FROM EnPreguntas e WHERE e.orden = :orden")
    , @NamedQuery(name = "EnPreguntas.findByTitulo", query = "SELECT e FROM EnPreguntas e WHERE e.titulo = :titulo")
    , @NamedQuery(name = "EnPreguntas.findByObligatorio", query = "SELECT e FROM EnPreguntas e WHERE e.obligatorio = :obligatorio")
    , @NamedQuery(name = "EnPreguntas.findByUsuInsercion", query = "SELECT e FROM EnPreguntas e WHERE e.usuInsercion = :usuInsercion")
    , @NamedQuery(name = "EnPreguntas.findByFecInsercion", query = "SELECT e FROM EnPreguntas e WHERE e.fecInsercion = :fecInsercion")
    , @NamedQuery(name = "EnPreguntas.findByUsuModificacion", query = "SELECT e FROM EnPreguntas e WHERE e.usuModificacion = :usuModificacion")
    , @NamedQuery(name = "EnPreguntas.findByFecModificacion", query = "SELECT e FROM EnPreguntas e WHERE e.fecModificacion = :fecModificacion")
    , @NamedQuery(name = "EnPreguntas.findByTipPersona", query = "SELECT e FROM EnPreguntas e WHERE e.tipPersona = :tipPersona")
    , @NamedQuery(name = "EnPreguntas.findByCanal", query = "SELECT e FROM EnPreguntas e WHERE e.canal = :canal")
    , @NamedQuery(name = "EnPreguntas.findByEstado", query = "SELECT e FROM EnPreguntas e WHERE e.estado = :estado")
    , @NamedQuery(name = "EnPreguntas.findByAtributo", query = "SELECT e FROM EnPreguntas e WHERE e.atributo = :atributo")
    , @NamedQuery(name = "EnPreguntas.findByVerbatim", query = "SELECT e FROM EnPreguntas e WHERE e.verbatim = :verbatim")})
public class EnPreguntas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_PREGUNTA")
    private Long codPregunta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDEN")
    private long orden;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "TITULO")
    private String titulo;
    @Size(max = 1)
    @Column(name = "OBLIGATORIO")
    private String obligatorio;
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
    @Size(max = 1)
    @Column(name = "TIP_PERSONA")
    private String tipPersona;
    @Size(max = 25)
    @Column(name = "CANAL")
    private String canal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @Size(max = 45)
    @Column(name = "ATRIBUTO")
    private String atributo;
    @Column(name = "VERBATIM")
    private Short verbatim;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPregunta")
    private List<EnPreDetalle> enPreDetalleList;
   
    @JoinColumn(name = "COD_CAM_OTROS", referencedColumnName = "COD_CAM_OTROS")
    @ManyToOne
    private EnCamOtros codCamOtros;
   
    
    @JoinColumn(name = "COD_ENCUESTA", referencedColumnName = "COD_ENCUESTA")
    @ManyToOne(optional = false)
    private EnEncuestas codEncuesta;
   
    
    
    @OneToMany(mappedBy = "codPreAsociada")
    private List<EnPreguntas> enPreguntasList;
    
    @JoinColumn(name = "COD_PRE_ASOCIADA", referencedColumnName = "COD_PREGUNTA")
    @ManyToOne
    private EnPreguntas codPreAsociada;
    
    
    
    
    @JoinColumn(name = "COD_TIP_RESPUESTA", referencedColumnName = "COD_TIP_RESPUESTA")
    @ManyToOne(optional = false)
    private EnTipRespuesta codTipRespuesta;
    @OneToMany(mappedBy = "codPregunta")
    private List<EnResDetalle> enResDetalleList;
    @OneToMany(mappedBy = "codPregunta")
    private List<EnRespuestas> enRespuestasList;

    public EnPreguntas() {
    }

    public EnPreguntas(Long codPregunta) {
        this.codPregunta = codPregunta;
    }

    public EnPreguntas(Long codPregunta, long orden, String titulo, String usuInsercion, Date fecInsercion, String usuModificacion, Date fecModificacion, String estado) {
        this.codPregunta = codPregunta;
        this.orden = orden;
        this.titulo = titulo;
        this.usuInsercion = usuInsercion;
        this.fecInsercion = fecInsercion;
        this.usuModificacion = usuModificacion;
        this.fecModificacion = fecModificacion;
        this.estado = estado;
    }

    public Long getCodPregunta() {
        return codPregunta;
    }

    public void setCodPregunta(Long codPregunta) {
        this.codPregunta = codPregunta;
    }

    public long getOrden() {
        return orden;
    }

    public void setOrden(long orden) {
        this.orden = orden;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getObligatorio() {
        return obligatorio;
    }

    public void setObligatorio(String obligatorio) {
        this.obligatorio = obligatorio;
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

    public String getTipPersona() {
        return tipPersona;
    }

    public void setTipPersona(String tipPersona) {
        this.tipPersona = tipPersona;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAtributo() {
        return atributo;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    public Short getVerbatim() {
        return verbatim;
    }

    public void setVerbatim(Short verbatim) {
        this.verbatim = verbatim;
    }

    @XmlTransient
    public List<EnPreDetalle> getEnPreDetalleList() {
        return enPreDetalleList;
    }

    public void setEnPreDetalleList(List<EnPreDetalle> enPreDetalleList) {
        this.enPreDetalleList = enPreDetalleList;
    }

    public EnCamOtros getCodCamOtros() {
        return codCamOtros;
    }

    public void setCodCamOtros(EnCamOtros codCamOtros) {
        this.codCamOtros = codCamOtros;
    }

    public EnEncuestas getCodEncuesta() {
        return codEncuesta;
    }

    public void setCodEncuesta(EnEncuestas codEncuesta) {
        this.codEncuesta = codEncuesta;
    }

    @XmlTransient
    public List<EnPreguntas> getEnPreguntasList() {
        return enPreguntasList;
    }

    public void setEnPreguntasList(List<EnPreguntas> enPreguntasList) {
        this.enPreguntasList = enPreguntasList;
    }

    public EnPreguntas getCodPreAsociada() {
        return codPreAsociada;
    }

    public void setCodPreAsociada(EnPreguntas codPreAsociada) {
        this.codPreAsociada = codPreAsociada;
    }

    public EnTipRespuesta getCodTipRespuesta() {
        return codTipRespuesta;
    }

    public void setCodTipRespuesta(EnTipRespuesta codTipRespuesta) {
        this.codTipRespuesta = codTipRespuesta;
    }

    @XmlTransient
    public List<EnResDetalle> getEnResDetalleList() {
        return enResDetalleList;
    }

    public void setEnResDetalleList(List<EnResDetalle> enResDetalleList) {
        this.enResDetalleList = enResDetalleList;
    }

    @XmlTransient
    public List<EnRespuestas> getEnRespuestasList() {
        return enRespuestasList;
    }

    public void setEnRespuestasList(List<EnRespuestas> enRespuestasList) {
        this.enRespuestasList = enRespuestasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPregunta != null ? codPregunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnPreguntas)) {
            return false;
        }
        EnPreguntas other = (EnPreguntas) object;
        if ((this.codPregunta == null && other.codPregunta != null) || (this.codPregunta != null && !this.codPregunta.equals(other.codPregunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.facturacion.entity.EnPreguntas[ codPregunta=" + codPregunta + " ]";
    }
    
}
