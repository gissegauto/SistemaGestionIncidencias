/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.facturacion.entity;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "EN_ENCUESTAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnEncuestas.findAll", query = "SELECT e FROM EnEncuestas e")
    , @NamedQuery(name = "EnEncuestas.findByCodEncuesta", query = "SELECT e FROM EnEncuestas e WHERE e.codEncuesta = :codEncuesta")
    , @NamedQuery(name = "EnEncuestas.findByDesPerFisica", query = "SELECT e FROM EnEncuestas e WHERE e.desPerFisica = :desPerFisica")
    , @NamedQuery(name = "EnEncuestas.findByPrioridad", query = "SELECT e FROM EnEncuestas e WHERE e.prioridad = :prioridad")
    , @NamedQuery(name = "EnEncuestas.findByUsuInsercion", query = "SELECT e FROM EnEncuestas e WHERE e.usuInsercion = :usuInsercion")
    , @NamedQuery(name = "EnEncuestas.findByFecInsercion", query = "SELECT e FROM EnEncuestas e WHERE e.fecInsercion = :fecInsercion")
    , @NamedQuery(name = "EnEncuestas.findByUsuModificacion", query = "SELECT e FROM EnEncuestas e WHERE e.usuModificacion = :usuModificacion")
    , @NamedQuery(name = "EnEncuestas.findByFecModificacion", query = "SELECT e FROM EnEncuestas e WHERE e.fecModificacion = :fecModificacion")
    , @NamedQuery(name = "EnEncuestas.findByTitulo", query = "SELECT e FROM EnEncuestas e WHERE e.titulo = :titulo")
    , @NamedQuery(name = "EnEncuestas.findByDesPerJuridica", query = "SELECT e FROM EnEncuestas e WHERE e.desPerJuridica = :desPerJuridica")})
public class EnEncuestas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_ENCUESTA")
    private Long codEncuesta;
    @Size(max = 500)
    @Column(name = "DES_PER_FISICA")
    private String desPerFisica;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRIORIDAD")
    private BigInteger prioridad;
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
    @Size(min = 1, max = 255)
    @Column(name = "TITULO")
    private String titulo;
    @Size(max = 500)
    @Column(name = "DES_PER_JURIDICA")
    private String desPerJuridica;
    @OneToMany(mappedBy = "codEncuesta")
    private List<EnEncExperiencia> enEncExperienciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEncuesta")
    private List<EnPreguntas> enPreguntasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEncuesta")
    private List<EnEncDetalle> enEncDetalleList;

    public EnEncuestas() {
    }

    public EnEncuestas(Long codEncuesta) {
        this.codEncuesta = codEncuesta;
    }

    public EnEncuestas(Long codEncuesta, BigInteger prioridad, String usuInsercion, Date fecInsercion, String usuModificacion, Date fecModificacion, String titulo) {
        this.codEncuesta = codEncuesta;
        this.prioridad = prioridad;
        this.usuInsercion = usuInsercion;
        this.fecInsercion = fecInsercion;
        this.usuModificacion = usuModificacion;
        this.fecModificacion = fecModificacion;
        this.titulo = titulo;
    }

    public Long getCodEncuesta() {
        return codEncuesta;
    }

    public void setCodEncuesta(Long codEncuesta) {
        this.codEncuesta = codEncuesta;
    }

    public String getDesPerFisica() {
        return desPerFisica;
    }

    public void setDesPerFisica(String desPerFisica) {
        this.desPerFisica = desPerFisica;
    }

    public BigInteger getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(BigInteger prioridad) {
        this.prioridad = prioridad;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDesPerJuridica() {
        return desPerJuridica;
    }

    public void setDesPerJuridica(String desPerJuridica) {
        this.desPerJuridica = desPerJuridica;
    }

    @XmlTransient
    public List<EnEncExperiencia> getEnEncExperienciaList() {
        return enEncExperienciaList;
    }

    public void setEnEncExperienciaList(List<EnEncExperiencia> enEncExperienciaList) {
        this.enEncExperienciaList = enEncExperienciaList;
    }

    @XmlTransient
    public List<EnPreguntas> getEnPreguntasList() {
        return enPreguntasList;
    }

    public void setEnPreguntasList(List<EnPreguntas> enPreguntasList) {
        this.enPreguntasList = enPreguntasList;
    }

    @XmlTransient
    public List<EnEncDetalle> getEnEncDetalleList() {
        return enEncDetalleList;
    }

    public void setEnEncDetalleList(List<EnEncDetalle> enEncDetalleList) {
        this.enEncDetalleList = enEncDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEncuesta != null ? codEncuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnEncuestas)) {
            return false;
        }
        EnEncuestas other = (EnEncuestas) object;
        if ((this.codEncuesta == null && other.codEncuesta != null) || (this.codEncuesta != null && !this.codEncuesta.equals(other.codEncuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.facturacion.entity.EnEncuestas[ codEncuesta=" + codEncuesta + " ]";
    }
    
}
