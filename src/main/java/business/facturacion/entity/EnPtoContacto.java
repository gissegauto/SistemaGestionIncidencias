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
@Table(name = "EN_PTO_CONTACTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnPtoContacto.findAll", query = "SELECT e FROM EnPtoContacto e")
    , @NamedQuery(name = "EnPtoContacto.findByCodSucursal", query = "SELECT e FROM EnPtoContacto e WHERE e.codSucursal = :codSucursal")
    , @NamedQuery(name = "EnPtoContacto.findByNombre", query = "SELECT e FROM EnPtoContacto e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "EnPtoContacto.findByUsuInsercion", query = "SELECT e FROM EnPtoContacto e WHERE e.usuInsercion = :usuInsercion")
    , @NamedQuery(name = "EnPtoContacto.findByFecInsercion", query = "SELECT e FROM EnPtoContacto e WHERE e.fecInsercion = :fecInsercion")
    , @NamedQuery(name = "EnPtoContacto.findByUsuModificacion", query = "SELECT e FROM EnPtoContacto e WHERE e.usuModificacion = :usuModificacion")
    , @NamedQuery(name = "EnPtoContacto.findByFecModificacion", query = "SELECT e FROM EnPtoContacto e WHERE e.fecModificacion = :fecModificacion")
    , @NamedQuery(name = "EnPtoContacto.findByEstado", query = "SELECT e FROM EnPtoContacto e WHERE e.estado = :estado")})
public class EnPtoContacto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_SUCURSAL")
    private Long codSucursal;
    @Size(max = 45)
    @Column(name = "NOMBRE")
    private String nombre;
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
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codSucursal")
    private List<EnEncDetalle> enEncDetalleList;
    @OneToMany(mappedBy = "codSucursal")
    private List<EnPerDetalle> enPerDetalleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPtoContacto")
    private List<EnExpPtoContacto> enExpPtoContactoList;

    public EnPtoContacto() {
    }

    public EnPtoContacto(Long codSucursal) {
        this.codSucursal = codSucursal;
    }

    public EnPtoContacto(Long codSucursal, String usuInsercion, Date fecInsercion, String usuModificacion, Date fecModificacion) {
        this.codSucursal = codSucursal;
        this.usuInsercion = usuInsercion;
        this.fecInsercion = fecInsercion;
        this.usuModificacion = usuModificacion;
        this.fecModificacion = fecModificacion;
    }

    public Long getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(Long codSucursal) {
        this.codSucursal = codSucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    public List<EnEncDetalle> getEnEncDetalleList() {
        return enEncDetalleList;
    }

    public void setEnEncDetalleList(List<EnEncDetalle> enEncDetalleList) {
        this.enEncDetalleList = enEncDetalleList;
    }

    @XmlTransient
    public List<EnPerDetalle> getEnPerDetalleList() {
        return enPerDetalleList;
    }

    public void setEnPerDetalleList(List<EnPerDetalle> enPerDetalleList) {
        this.enPerDetalleList = enPerDetalleList;
    }

    @XmlTransient
    public List<EnExpPtoContacto> getEnExpPtoContactoList() {
        return enExpPtoContactoList;
    }

    public void setEnExpPtoContactoList(List<EnExpPtoContacto> enExpPtoContactoList) {
        this.enExpPtoContactoList = enExpPtoContactoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSucursal != null ? codSucursal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnPtoContacto)) {
            return false;
        }
        EnPtoContacto other = (EnPtoContacto) object;
        if ((this.codSucursal == null && other.codSucursal != null) || (this.codSucursal != null && !this.codSucursal.equals(other.codSucursal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.facturacion.entity.EnPtoContacto[ codSucursal=" + codSucursal + " ]";
    }
    
}
