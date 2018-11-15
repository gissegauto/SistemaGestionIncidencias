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
@Table(name = "EN_PRE_DETALLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnPreDetalle.findAll", query = "SELECT e FROM EnPreDetalle e")
    , @NamedQuery(name = "EnPreDetalle.findByCodPreDetalle", query = "SELECT e FROM EnPreDetalle e WHERE e.codPreDetalle = :codPreDetalle")
    , @NamedQuery(name = "EnPreDetalle.findByOrden", query = "SELECT e FROM EnPreDetalle e WHERE e.orden = :orden")
    , @NamedQuery(name = "EnPreDetalle.findByValor", query = "SELECT e FROM EnPreDetalle e WHERE e.valor = :valor")
    , @NamedQuery(name = "EnPreDetalle.findByDescripcion", query = "SELECT e FROM EnPreDetalle e WHERE e.descripcion = :descripcion")
    , @NamedQuery(name = "EnPreDetalle.findByEstado", query = "SELECT e FROM EnPreDetalle e WHERE e.estado = :estado")
    , @NamedQuery(name = "EnPreDetalle.findByUsuInsercion", query = "SELECT e FROM EnPreDetalle e WHERE e.usuInsercion = :usuInsercion")
    , @NamedQuery(name = "EnPreDetalle.findByFecInsercion", query = "SELECT e FROM EnPreDetalle e WHERE e.fecInsercion = :fecInsercion")
    , @NamedQuery(name = "EnPreDetalle.findByUsuModificacion", query = "SELECT e FROM EnPreDetalle e WHERE e.usuModificacion = :usuModificacion")
    , @NamedQuery(name = "EnPreDetalle.findByFecModificacion", query = "SELECT e FROM EnPreDetalle e WHERE e.fecModificacion = :fecModificacion")})
public class EnPreDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_PRE_DETALLE")
    private Long codPreDetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDEN")
    private long orden;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "VALOR")
    private String valor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ESTADO")
    private String estado;
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
    @JoinColumn(name = "COD_PREGUNTA", referencedColumnName = "COD_PREGUNTA")
    @ManyToOne(optional = false)
    private EnPreguntas codPregunta;

    public EnPreDetalle() {
    }

    public EnPreDetalle(Long codPreDetalle) {
        this.codPreDetalle = codPreDetalle;
    }

    public EnPreDetalle(Long codPreDetalle, long orden, String valor, String descripcion, String estado, String usuInsercion, Date fecInsercion, String usuModificacion, Date fecModificacion) {
        this.codPreDetalle = codPreDetalle;
        this.orden = orden;
        this.valor = valor;
        this.descripcion = descripcion;
        this.estado = estado;
        this.usuInsercion = usuInsercion;
        this.fecInsercion = fecInsercion;
        this.usuModificacion = usuModificacion;
        this.fecModificacion = fecModificacion;
    }

    public Long getCodPreDetalle() {
        return codPreDetalle;
    }

    public void setCodPreDetalle(Long codPreDetalle) {
        this.codPreDetalle = codPreDetalle;
    }

    public long getOrden() {
        return orden;
    }

    public void setOrden(long orden) {
        this.orden = orden;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public EnPreguntas getCodPregunta() {
        return codPregunta;
    }

    public void setCodPregunta(EnPreguntas codPregunta) {
        this.codPregunta = codPregunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPreDetalle != null ? codPreDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnPreDetalle)) {
            return false;
        }
        EnPreDetalle other = (EnPreDetalle) object;
        if ((this.codPreDetalle == null && other.codPreDetalle != null) || (this.codPreDetalle != null && !this.codPreDetalle.equals(other.codPreDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.facturacion.entity.EnPreDetalle[ codPreDetalle=" + codPreDetalle + " ]";
    }
    
}
