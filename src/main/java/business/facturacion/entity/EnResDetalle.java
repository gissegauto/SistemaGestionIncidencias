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
@Table(name = "EN_RES_DETALLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnResDetalle.findAll", query = "SELECT e FROM EnResDetalle e")
    , @NamedQuery(name = "EnResDetalle.findByCodResDetalle", query = "SELECT e FROM EnResDetalle e WHERE e.codResDetalle = :codResDetalle")
    , @NamedQuery(name = "EnResDetalle.findByValor1", query = "SELECT e FROM EnResDetalle e WHERE e.valor1 = :valor1")
    , @NamedQuery(name = "EnResDetalle.findByValor2", query = "SELECT e FROM EnResDetalle e WHERE e.valor2 = :valor2")
    , @NamedQuery(name = "EnResDetalle.findByUsuInsercion", query = "SELECT e FROM EnResDetalle e WHERE e.usuInsercion = :usuInsercion")
    , @NamedQuery(name = "EnResDetalle.findByFecInsercion", query = "SELECT e FROM EnResDetalle e WHERE e.fecInsercion = :fecInsercion")
    , @NamedQuery(name = "EnResDetalle.findByUsuModificacion", query = "SELECT e FROM EnResDetalle e WHERE e.usuModificacion = :usuModificacion")
    , @NamedQuery(name = "EnResDetalle.findByFecModificacion", query = "SELECT e FROM EnResDetalle e WHERE e.fecModificacion = :fecModificacion")})
public class EnResDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_RES_DETALLE")
    private Long codResDetalle;
    @Size(max = 255)
    @Column(name = "VALOR1")
    private String valor1;
    @Size(max = 255)
    @Column(name = "VALOR2")
    private String valor2;
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
    @ManyToOne
    private EnPreguntas codPregunta;
    @JoinColumn(name = "COD_RESPUESTA", referencedColumnName = "COD_RESPUESTA")
    @ManyToOne(optional = false)
    private EnRespuestas codRespuesta;
    @JoinColumn(name = "COD_TIP_RESPUESTA", referencedColumnName = "COD_TIP_RESPUESTA")
    @ManyToOne(optional = false)
    private EnTipRespuesta codTipRespuesta;

    public EnResDetalle() {
    }

    public EnResDetalle(Long codResDetalle) {
        this.codResDetalle = codResDetalle;
    }

    public EnResDetalle(Long codResDetalle, String usuInsercion, Date fecInsercion, String usuModificacion, Date fecModificacion) {
        this.codResDetalle = codResDetalle;
        this.usuInsercion = usuInsercion;
        this.fecInsercion = fecInsercion;
        this.usuModificacion = usuModificacion;
        this.fecModificacion = fecModificacion;
    }

    public Long getCodResDetalle() {
        return codResDetalle;
    }

    public void setCodResDetalle(Long codResDetalle) {
        this.codResDetalle = codResDetalle;
    }

    public String getValor1() {
        return valor1;
    }

    public void setValor1(String valor1) {
        this.valor1 = valor1;
    }

    public String getValor2() {
        return valor2;
    }

    public void setValor2(String valor2) {
        this.valor2 = valor2;
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

    public EnRespuestas getCodRespuesta() {
        return codRespuesta;
    }

    public void setCodRespuesta(EnRespuestas codRespuesta) {
        this.codRespuesta = codRespuesta;
    }

    public EnTipRespuesta getCodTipRespuesta() {
        return codTipRespuesta;
    }

    public void setCodTipRespuesta(EnTipRespuesta codTipRespuesta) {
        this.codTipRespuesta = codTipRespuesta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codResDetalle != null ? codResDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnResDetalle)) {
            return false;
        }
        EnResDetalle other = (EnResDetalle) object;
        if ((this.codResDetalle == null && other.codResDetalle != null) || (this.codResDetalle != null && !this.codResDetalle.equals(other.codResDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.facturacion.entity.EnResDetalle[ codResDetalle=" + codResDetalle + " ]";
    }
    
}
