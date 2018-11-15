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
@Table(name = "EN_EXPERIENCIAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnExperiencias.findAll", query = "SELECT e FROM EnExperiencias e")
    , @NamedQuery(name = "EnExperiencias.findByCodExperiencia", query = "SELECT e FROM EnExperiencias e WHERE e.codExperiencia = :codExperiencia")
    , @NamedQuery(name = "EnExperiencias.findByDescripcion", query = "SELECT e FROM EnExperiencias e WHERE e.descripcion = :descripcion")
    , @NamedQuery(name = "EnExperiencias.findByUsuInsercion", query = "SELECT e FROM EnExperiencias e WHERE e.usuInsercion = :usuInsercion")
    , @NamedQuery(name = "EnExperiencias.findByFecInsercion", query = "SELECT e FROM EnExperiencias e WHERE e.fecInsercion = :fecInsercion")
    , @NamedQuery(name = "EnExperiencias.findByUsuModificacion", query = "SELECT e FROM EnExperiencias e WHERE e.usuModificacion = :usuModificacion")
    , @NamedQuery(name = "EnExperiencias.findByFecModificacion", query = "SELECT e FROM EnExperiencias e WHERE e.fecModificacion = :fecModificacion")
    , @NamedQuery(name = "EnExperiencias.findByEstado", query = "SELECT e FROM EnExperiencias e WHERE e.estado = :estado")})
public class EnExperiencias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_EXPERIENCIA")
    private Long codExperiencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
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
    @Size(max = 1)
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codExperiencia")
    private List<EnEncExperiencia> enEncExperienciaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codExperiencia")
    private List<EnExpPtoContacto> enExpPtoContactoList;

    public EnExperiencias() {
    }

    public EnExperiencias(Long codExperiencia) {
        this.codExperiencia = codExperiencia;
    }

    public EnExperiencias(Long codExperiencia, String descripcion, String usuInsercion, Date fecInsercion, String usuModificacion, Date fecModificacion) {
        this.codExperiencia = codExperiencia;
        this.descripcion = descripcion;
        this.usuInsercion = usuInsercion;
        this.fecInsercion = fecInsercion;
        this.usuModificacion = usuModificacion;
        this.fecModificacion = fecModificacion;
    }

    public Long getCodExperiencia() {
        return codExperiencia;
    }

    public void setCodExperiencia(Long codExperiencia) {
        this.codExperiencia = codExperiencia;
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
    public List<EnEncExperiencia> getEnEncExperienciaList() {
        return enEncExperienciaList;
    }

    public void setEnEncExperienciaList(List<EnEncExperiencia> enEncExperienciaList) {
        this.enEncExperienciaList = enEncExperienciaList;
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
        hash += (codExperiencia != null ? codExperiencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnExperiencias)) {
            return false;
        }
        EnExperiencias other = (EnExperiencias) object;
        if ((this.codExperiencia == null && other.codExperiencia != null) || (this.codExperiencia != null && !this.codExperiencia.equals(other.codExperiencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.facturacion.entity.EnExperiencias[ codExperiencia=" + codExperiencia + " ]";
    }
    
}
