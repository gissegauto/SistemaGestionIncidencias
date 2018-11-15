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
@Table(name = "EN_CAM_OTROS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnCamOtros.findAll", query = "SELECT e FROM EnCamOtros e")
    , @NamedQuery(name = "EnCamOtros.findByCodCamOtros", query = "SELECT e FROM EnCamOtros e WHERE e.codCamOtros = :codCamOtros")
    , @NamedQuery(name = "EnCamOtros.findByNombre", query = "SELECT e FROM EnCamOtros e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "EnCamOtros.findByUsuInsercion", query = "SELECT e FROM EnCamOtros e WHERE e.usuInsercion = :usuInsercion")
    , @NamedQuery(name = "EnCamOtros.findByFecInsercion", query = "SELECT e FROM EnCamOtros e WHERE e.fecInsercion = :fecInsercion")
    , @NamedQuery(name = "EnCamOtros.findByUsuModificacion", query = "SELECT e FROM EnCamOtros e WHERE e.usuModificacion = :usuModificacion")
    , @NamedQuery(name = "EnCamOtros.findByFecModificacion", query = "SELECT e FROM EnCamOtros e WHERE e.fecModificacion = :fecModificacion")})
public class EnCamOtros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_CAM_OTROS")
    private Long codCamOtros;
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
    @OneToMany(mappedBy = "codCamOtros")
    private List<EnPreguntas> enPreguntasList;

    public EnCamOtros() {
    }

    public EnCamOtros(Long codCamOtros) {
        this.codCamOtros = codCamOtros;
    }

    public EnCamOtros(Long codCamOtros, String usuInsercion, Date fecInsercion, String usuModificacion, Date fecModificacion) {
        this.codCamOtros = codCamOtros;
        this.usuInsercion = usuInsercion;
        this.fecInsercion = fecInsercion;
        this.usuModificacion = usuModificacion;
        this.fecModificacion = fecModificacion;
    }

    public Long getCodCamOtros() {
        return codCamOtros;
    }

    public void setCodCamOtros(Long codCamOtros) {
        this.codCamOtros = codCamOtros;
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

    @XmlTransient
    public List<EnPreguntas> getEnPreguntasList() {
        return enPreguntasList;
    }

    public void setEnPreguntasList(List<EnPreguntas> enPreguntasList) {
        this.enPreguntasList = enPreguntasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCamOtros != null ? codCamOtros.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnCamOtros)) {
            return false;
        }
        EnCamOtros other = (EnCamOtros) object;
        if ((this.codCamOtros == null && other.codCamOtros != null) || (this.codCamOtros != null && !this.codCamOtros.equals(other.codCamOtros))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.facturacion.entity.EnCamOtros[ codCamOtros=" + codCamOtros + " ]";
    }
    
}
