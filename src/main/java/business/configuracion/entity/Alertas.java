/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.configuracion.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "alertas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alertas.findAll", query = "SELECT a FROM Alertas a")
    , @NamedQuery(name = "Alertas.findByIdAlertas", query = "SELECT a FROM Alertas a WHERE a.idAlertas = :idAlertas")
    , @NamedQuery(name = "Alertas.findByAlertaFechaHora", query = "SELECT a FROM Alertas a WHERE a.alertaFechaHora = :alertaFechaHora")
    , @NamedQuery(name = "Alertas.findByAlertaDescripcion", query = "SELECT a FROM Alertas a WHERE a.alertaDescripcion = :alertaDescripcion")})
public class Alertas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAlerta")
    private Integer idAlertas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaHora")
    @Temporal(TemporalType.DATE)
    private Date alertaFechaHora;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "descripcion")
    private String alertaDescripcion;

    public Alertas() {
    }

    public Alertas(Integer idAlertas) {
        this.idAlertas = idAlertas;
    }

    public Alertas(Integer idAlertas, Date alertaFechaHora, String alertaDescripcion) {
        this.idAlertas = idAlertas;
        this.alertaFechaHora = alertaFechaHora;
        this.alertaDescripcion = alertaDescripcion;
    }

    public Integer getIdAlertas() {
        return idAlertas;
    }

    public void setIdAlertas(Integer idAlertas) {
        this.idAlertas = idAlertas;
    }

    public Date getAlertaFechaHora() {
        return alertaFechaHora;
    }

    public void setAlertaFechaHora(Date alertaFechaHora) {
        this.alertaFechaHora = alertaFechaHora;
    }

    public String getAlertaDescripcion() {
        return alertaDescripcion;
    }

    public void setAlertaDescripcion(String alertaDescripcion) {
        this.alertaDescripcion = alertaDescripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlertas != null ? idAlertas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alertas)) {
            return false;
        }
        Alertas other = (Alertas) object;
        if ((this.idAlertas == null && other.idAlertas != null) || (this.idAlertas != null && !this.idAlertas.equals(other.idAlertas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.configuracion.entity.Alertas[ idAlertas=" + idAlertas + " ]";
    }
    
}
