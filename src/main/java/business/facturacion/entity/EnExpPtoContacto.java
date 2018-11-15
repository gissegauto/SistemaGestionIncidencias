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
@Table(name = "EN_EXP_PTO_CONTACTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnExpPtoContacto.findAll", query = "SELECT e FROM EnExpPtoContacto e")
    , @NamedQuery(name = "EnExpPtoContacto.findByCodExpPtoContacto", query = "SELECT e FROM EnExpPtoContacto e WHERE e.codExpPtoContacto = :codExpPtoContacto")
    , @NamedQuery(name = "EnExpPtoContacto.findByCantidad", query = "SELECT e FROM EnExpPtoContacto e WHERE e.cantidad = :cantidad")
    , @NamedQuery(name = "EnExpPtoContacto.findByUsuInsercion", query = "SELECT e FROM EnExpPtoContacto e WHERE e.usuInsercion = :usuInsercion")
    , @NamedQuery(name = "EnExpPtoContacto.findByFecInsercion", query = "SELECT e FROM EnExpPtoContacto e WHERE e.fecInsercion = :fecInsercion")
    , @NamedQuery(name = "EnExpPtoContacto.findByUsuModificacion", query = "SELECT e FROM EnExpPtoContacto e WHERE e.usuModificacion = :usuModificacion")
    , @NamedQuery(name = "EnExpPtoContacto.findByFecModificacion", query = "SELECT e FROM EnExpPtoContacto e WHERE e.fecModificacion = :fecModificacion")})
public class EnExpPtoContacto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_EXP_PTO_CONTACTO")
    private Long codExpPtoContacto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CANTIDAD")
    private int cantidad;
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
    @JoinColumn(name = "COD_EXPERIENCIA", referencedColumnName = "COD_EXPERIENCIA")
    @ManyToOne(optional = false)
    private EnExperiencias codExperiencia;
    @JoinColumn(name = "COD_PTO_CONTACTO", referencedColumnName = "COD_SUCURSAL")
    @ManyToOne(optional = false)
    private EnPtoContacto codPtoContacto;

    public EnExpPtoContacto() {
    }

    public EnExpPtoContacto(Long codExpPtoContacto) {
        this.codExpPtoContacto = codExpPtoContacto;
    }

    public EnExpPtoContacto(Long codExpPtoContacto, int cantidad, String usuInsercion, Date fecInsercion, String usuModificacion, Date fecModificacion) {
        this.codExpPtoContacto = codExpPtoContacto;
        this.cantidad = cantidad;
        this.usuInsercion = usuInsercion;
        this.fecInsercion = fecInsercion;
        this.usuModificacion = usuModificacion;
        this.fecModificacion = fecModificacion;
    }

    public Long getCodExpPtoContacto() {
        return codExpPtoContacto;
    }

    public void setCodExpPtoContacto(Long codExpPtoContacto) {
        this.codExpPtoContacto = codExpPtoContacto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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

    public EnExperiencias getCodExperiencia() {
        return codExperiencia;
    }

    public void setCodExperiencia(EnExperiencias codExperiencia) {
        this.codExperiencia = codExperiencia;
    }

    public EnPtoContacto getCodPtoContacto() {
        return codPtoContacto;
    }

    public void setCodPtoContacto(EnPtoContacto codPtoContacto) {
        this.codPtoContacto = codPtoContacto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codExpPtoContacto != null ? codExpPtoContacto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnExpPtoContacto)) {
            return false;
        }
        EnExpPtoContacto other = (EnExpPtoContacto) object;
        if ((this.codExpPtoContacto == null && other.codExpPtoContacto != null) || (this.codExpPtoContacto != null && !this.codExpPtoContacto.equals(other.codExpPtoContacto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.facturacion.entity.EnExpPtoContacto[ codExpPtoContacto=" + codExpPtoContacto + " ]";
    }
    
}
