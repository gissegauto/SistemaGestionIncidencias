/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.configuracion.entity;

import business.direccion.entity.Ciudad;
import business.usuario.entity.Usuario;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

/**
 *
 * @author ggauto
 */
@Entity
@Table(name = "configuracion")
@NamedQueries({
    @NamedQuery(name = "Configuracion.findAll", query = "SELECT c FROM Configuracion c")
    , @NamedQuery(name = "Configuracion.findByIdConfiguracion", query = "SELECT c FROM Configuracion c WHERE c.idConfiguracion = :idConfiguracion")
    , @NamedQuery(name = "Configuracion.findByMulta", query = "SELECT c FROM Configuracion c WHERE c.multa = :multa")
    , @NamedQuery(name = "Configuracion.findByNroFactura", query = "SELECT c FROM Configuracion c WHERE c.nroFactura = :nroFactura")
    , @NamedQuery(name = "Configuracion.findByNroBoleta", query = "SELECT c FROM Configuracion c WHERE c.nroBoleta = :nroBoleta")
    , @NamedQuery(name = "Configuracion.findByNomEmpresa", query = "SELECT c FROM Configuracion c WHERE c.nomEmpresa = :nomEmpresa")
    , @NamedQuery(name = "Configuracion.findByRucEmpresa", query = "SELECT c FROM Configuracion c WHERE c.rucEmpresa = :rucEmpresa")
    , @NamedQuery(name = "Configuracion.findByPropietario", query = "SELECT c FROM Configuracion c WHERE c.propietario = :propietario")
    , @NamedQuery(name = "Configuracion.findByNomFicticio", query = "SELECT c FROM Configuracion c WHERE c.nomFicticio = :nomFicticio")
    , @NamedQuery(name = "Configuracion.findByFecInsercion", query = "SELECT c FROM Configuracion c WHERE c.fecInsercion = :fecInsercion")
    , @NamedQuery(name = "Configuracion.findByDirEmpresa", query = "SELECT c FROM Configuracion c WHERE c.dirEmpresa = :dirEmpresa")
    , @NamedQuery(name = "Configuracion.findByFecModificacion", query = "SELECT c FROM Configuracion c WHERE c.fecModificacion = :fecModificacion")
    , @NamedQuery(name = "Configuracion.findByTimbrado", query = "SELECT c FROM Configuracion c WHERE c.timbrado = :timbrado")})
public class Configuracion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idConfiguracion")
    private Integer idConfiguracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "multa")
    private double multa;
    @Size(max = 25)
    @Column(name = "nro_factura")
    private String nroFactura;
    @Size(max = 25)
    @Column(name = "nro_boleta")
    private String nroBoleta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nom_empresa")
    private String nomEmpresa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ruc_empresa")
    private String rucEmpresa;
    @Size(max = 45)
    @Column(name = "propietario")
    private String propietario;
    @Size(max = 45)
    @Column(name = "nom_ficticio")
    private String nomFicticio;
    @Column(name = "fec_insercion")
    @Temporal(TemporalType.DATE)
    private Date fecInsercion;
    @Size(max = 255)
    @Column(name = "dir_empresa")
    private String dirEmpresa;
    @Column(name = "fec_modificacion")
    @Temporal(TemporalType.DATE)
    private Date fecModificacion;
    @Size(max = 45)
    @Column(name = "timbrado")
    private String timbrado;
    @JoinColumn(name = "idCiudad", referencedColumnName = "idCiudad")
    @ManyToOne
    private Ciudad idCiudad;
    @JoinColumn(name = "usu_insercion", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario usuInsercion;
    @JoinColumn(name = "usu_modificacion", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario usuModificacion;

    public Configuracion() {
    }

    public Configuracion(Integer idConfiguracion) {
        this.idConfiguracion = idConfiguracion;
    }

    public Configuracion(Integer idConfiguracion, double multa, String nomEmpresa, String rucEmpresa) {
        this.idConfiguracion = idConfiguracion;
        this.multa = multa;
        this.nomEmpresa = nomEmpresa;
        this.rucEmpresa = rucEmpresa;
    }

    public Integer getIdConfiguracion() {
        return idConfiguracion;
    }

    public void setIdConfiguracion(Integer idConfiguracion) {
        this.idConfiguracion = idConfiguracion;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public String getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(String nroFactura) {
        this.nroFactura = nroFactura;
    }

    public String getNroBoleta() {
        return nroBoleta;
    }

    public void setNroBoleta(String nroBoleta) {
        this.nroBoleta = nroBoleta;
    }

    public String getNomEmpresa() {
        return nomEmpresa;
    }

    public void setNomEmpresa(String nomEmpresa) {
        this.nomEmpresa = nomEmpresa;
    }

    public String getRucEmpresa() {
        return rucEmpresa;
    }

    public void setRucEmpresa(String rucEmpresa) {
        this.rucEmpresa = rucEmpresa;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getNomFicticio() {
        return nomFicticio;
    }

    public void setNomFicticio(String nomFicticio) {
        this.nomFicticio = nomFicticio;
    }

    public Date getFecInsercion() {
        return fecInsercion;
    }

    public void setFecInsercion(Date fecInsercion) {
        this.fecInsercion = fecInsercion;
    }

    public String getDirEmpresa() {
        return dirEmpresa;
    }

    public void setDirEmpresa(String dirEmpresa) {
        this.dirEmpresa = dirEmpresa;
    }

    public Date getFecModificacion() {
        return fecModificacion;
    }

    public void setFecModificacion(Date fecModificacion) {
        this.fecModificacion = fecModificacion;
    }

    public String getTimbrado() {
        return timbrado;
    }

    public void setTimbrado(String timbrado) {
        this.timbrado = timbrado;
    }

    public Ciudad getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Ciudad idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Usuario getUsuInsercion() {
        return usuInsercion;
    }

    public void setUsuInsercion(Usuario usuInsercion) {
        this.usuInsercion = usuInsercion;
    }

    public Usuario getUsuModificacion() {
        return usuModificacion;
    }

    public void setUsuModificacion(Usuario usuModificacion) {
        this.usuModificacion = usuModificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConfiguracion != null ? idConfiguracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Configuracion)) {
            return false;
        }
        Configuracion other = (Configuracion) object;
        if ((this.idConfiguracion == null && other.idConfiguracion != null) || (this.idConfiguracion != null && !this.idConfiguracion.equals(other.idConfiguracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.configuracion.entity.Configuracion[ idConfiguracion=" + idConfiguracion + " ]";
    }
    
}
