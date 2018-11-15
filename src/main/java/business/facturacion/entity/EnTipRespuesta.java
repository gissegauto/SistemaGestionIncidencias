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
@Table(name = "EN_TIP_RESPUESTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnTipRespuesta.findAll", query = "SELECT e FROM EnTipRespuesta e")
    , @NamedQuery(name = "EnTipRespuesta.findByCodTipRespuesta", query = "SELECT e FROM EnTipRespuesta e WHERE e.codTipRespuesta = :codTipRespuesta")
    , @NamedQuery(name = "EnTipRespuesta.findByDescripcion", query = "SELECT e FROM EnTipRespuesta e WHERE e.descripcion = :descripcion")
    , @NamedQuery(name = "EnTipRespuesta.findByUsuInsercion", query = "SELECT e FROM EnTipRespuesta e WHERE e.usuInsercion = :usuInsercion")
    , @NamedQuery(name = "EnTipRespuesta.findByFecInsercion", query = "SELECT e FROM EnTipRespuesta e WHERE e.fecInsercion = :fecInsercion")
    , @NamedQuery(name = "EnTipRespuesta.findByUsuModificacion", query = "SELECT e FROM EnTipRespuesta e WHERE e.usuModificacion = :usuModificacion")
    , @NamedQuery(name = "EnTipRespuesta.findByFecModificacion", query = "SELECT e FROM EnTipRespuesta e WHERE e.fecModificacion = :fecModificacion")
    , @NamedQuery(name = "EnTipRespuesta.findByEstado", query = "SELECT e FROM EnTipRespuesta e WHERE e.estado = :estado")})
public class EnTipRespuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_TIP_RESPUESTA")
    private Long codTipRespuesta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTipRespuesta")
    private List<EnPreguntas> enPreguntasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTipRespuesta")
    private List<EnResDetalle> enResDetalleList;

    public EnTipRespuesta() {
    }

    public EnTipRespuesta(Long codTipRespuesta) {
        this.codTipRespuesta = codTipRespuesta;
    }

    public EnTipRespuesta(Long codTipRespuesta, String descripcion, String usuInsercion, Date fecInsercion, String usuModificacion, Date fecModificacion, String estado) {
        this.codTipRespuesta = codTipRespuesta;
        this.descripcion = descripcion;
        this.usuInsercion = usuInsercion;
        this.fecInsercion = fecInsercion;
        this.usuModificacion = usuModificacion;
        this.fecModificacion = fecModificacion;
        this.estado = estado;
    }

    public Long getCodTipRespuesta() {
        return codTipRespuesta;
    }

    public void setCodTipRespuesta(Long codTipRespuesta) {
        this.codTipRespuesta = codTipRespuesta;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<EnPreguntas> getEnPreguntasList() {
        return enPreguntasList;
    }

    public void setEnPreguntasList(List<EnPreguntas> enPreguntasList) {
        this.enPreguntasList = enPreguntasList;
    }

    @XmlTransient
    public List<EnResDetalle> getEnResDetalleList() {
        return enResDetalleList;
    }

    public void setEnResDetalleList(List<EnResDetalle> enResDetalleList) {
        this.enResDetalleList = enResDetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipRespuesta != null ? codTipRespuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnTipRespuesta)) {
            return false;
        }
        EnTipRespuesta other = (EnTipRespuesta) object;
        if ((this.codTipRespuesta == null && other.codTipRespuesta != null) || (this.codTipRespuesta != null && !this.codTipRespuesta.equals(other.codTipRespuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.facturacion.entity.EnTipRespuesta[ codTipRespuesta=" + codTipRespuesta + " ]";
    }
    
}
