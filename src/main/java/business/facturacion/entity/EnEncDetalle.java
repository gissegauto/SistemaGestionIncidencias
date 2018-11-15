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
@Table(name = "EN_ENC_DETALLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnEncDetalle.findAll", query = "SELECT e FROM EnEncDetalle e")
    , @NamedQuery(name = "EnEncDetalle.findByCodEncDetalle", query = "SELECT e FROM EnEncDetalle e WHERE e.codEncDetalle = :codEncDetalle")
    , @NamedQuery(name = "EnEncDetalle.findByUsuInsercion", query = "SELECT e FROM EnEncDetalle e WHERE e.usuInsercion = :usuInsercion")
    , @NamedQuery(name = "EnEncDetalle.findByFecInsercion", query = "SELECT e FROM EnEncDetalle e WHERE e.fecInsercion = :fecInsercion")
    , @NamedQuery(name = "EnEncDetalle.findByUsuModificacion", query = "SELECT e FROM EnEncDetalle e WHERE e.usuModificacion = :usuModificacion")
    , @NamedQuery(name = "EnEncDetalle.findByFecModificacion", query = "SELECT e FROM EnEncDetalle e WHERE e.fecModificacion = :fecModificacion")})
public class EnEncDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_ENC_DETALLE")
    private Long codEncDetalle;
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
    @JoinColumn(name = "COD_ENCUESTA", referencedColumnName = "COD_ENCUESTA")
    @ManyToOne(optional = false)
    private EnEncuestas codEncuesta;
    @JoinColumn(name = "COD_SUCURSAL", referencedColumnName = "COD_SUCURSAL")
    @ManyToOne(optional = false)
    private EnPtoContacto codSucursal;

    public EnEncDetalle() {
    }

    public EnEncDetalle(Long codEncDetalle) {
        this.codEncDetalle = codEncDetalle;
    }

    public EnEncDetalle(Long codEncDetalle, String usuInsercion, Date fecInsercion, String usuModificacion, Date fecModificacion) {
        this.codEncDetalle = codEncDetalle;
        this.usuInsercion = usuInsercion;
        this.fecInsercion = fecInsercion;
        this.usuModificacion = usuModificacion;
        this.fecModificacion = fecModificacion;
    }

    public Long getCodEncDetalle() {
        return codEncDetalle;
    }

    public void setCodEncDetalle(Long codEncDetalle) {
        this.codEncDetalle = codEncDetalle;
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

    public EnEncuestas getCodEncuesta() {
        return codEncuesta;
    }

    public void setCodEncuesta(EnEncuestas codEncuesta) {
        this.codEncuesta = codEncuesta;
    }

    public EnPtoContacto getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(EnPtoContacto codSucursal) {
        this.codSucursal = codSucursal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEncDetalle != null ? codEncDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnEncDetalle)) {
            return false;
        }
        EnEncDetalle other = (EnEncDetalle) object;
        if ((this.codEncDetalle == null && other.codEncDetalle != null) || (this.codEncDetalle != null && !this.codEncDetalle.equals(other.codEncDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.facturacion.entity.EnEncDetalle[ codEncDetalle=" + codEncDetalle + " ]";
    }
    
}
