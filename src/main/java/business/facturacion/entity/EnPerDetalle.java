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
@Table(name = "EN_PER_DETALLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnPerDetalle.findAll", query = "SELECT e FROM EnPerDetalle e")
    , @NamedQuery(name = "EnPerDetalle.findByCodPerDetalle", query = "SELECT e FROM EnPerDetalle e WHERE e.codPerDetalle = :codPerDetalle")
    , @NamedQuery(name = "EnPerDetalle.findByCodExperiencia", query = "SELECT e FROM EnPerDetalle e WHERE e.codExperiencia = :codExperiencia")
    , @NamedQuery(name = "EnPerDetalle.findByFecExperiencia", query = "SELECT e FROM EnPerDetalle e WHERE e.fecExperiencia = :fecExperiencia")
    , @NamedQuery(name = "EnPerDetalle.findBySegCanVenta", query = "SELECT e FROM EnPerDetalle e WHERE e.segCanVenta = :segCanVenta")
    , @NamedQuery(name = "EnPerDetalle.findBySegAntiguedad", query = "SELECT e FROM EnPerDetalle e WHERE e.segAntiguedad = :segAntiguedad")
    , @NamedQuery(name = "EnPerDetalle.findBySegCueNomina", query = "SELECT e FROM EnPerDetalle e WHERE e.segCueNomina = :segCueNomina")
    , @NamedQuery(name = "EnPerDetalle.findBySegEdad", query = "SELECT e FROM EnPerDetalle e WHERE e.segEdad = :segEdad")
    , @NamedQuery(name = "EnPerDetalle.findBySegProducto", query = "SELECT e FROM EnPerDetalle e WHERE e.segProducto = :segProducto")
    , @NamedQuery(name = "EnPerDetalle.findBySegResReclamo", query = "SELECT e FROM EnPerDetalle e WHERE e.segResReclamo = :segResReclamo")
    , @NamedQuery(name = "EnPerDetalle.findBySegSegCliente", query = "SELECT e FROM EnPerDetalle e WHERE e.segSegCliente = :segSegCliente")
    , @NamedQuery(name = "EnPerDetalle.findBySegTipEjeOfi", query = "SELECT e FROM EnPerDetalle e WHERE e.segTipEjeOfi = :segTipEjeOfi")
    , @NamedQuery(name = "EnPerDetalle.findBySegTipTarjeta", query = "SELECT e FROM EnPerDetalle e WHERE e.segTipTarjeta = :segTipTarjeta")
    , @NamedQuery(name = "EnPerDetalle.findBySegTrabajo", query = "SELECT e FROM EnPerDetalle e WHERE e.segTrabajo = :segTrabajo")
    , @NamedQuery(name = "EnPerDetalle.findBySegNivSocEconomico", query = "SELECT e FROM EnPerDetalle e WHERE e.segNivSocEconomico = :segNivSocEconomico")
    , @NamedQuery(name = "EnPerDetalle.findBySegSubSegCliente", query = "SELECT e FROM EnPerDetalle e WHERE e.segSubSegCliente = :segSubSegCliente")
    , @NamedQuery(name = "EnPerDetalle.findBySegAreNegocio", query = "SELECT e FROM EnPerDetalle e WHERE e.segAreNegocio = :segAreNegocio")
    , @NamedQuery(name = "EnPerDetalle.findBySegExt02", query = "SELECT e FROM EnPerDetalle e WHERE e.segExt02 = :segExt02")
    , @NamedQuery(name = "EnPerDetalle.findBySegExt03", query = "SELECT e FROM EnPerDetalle e WHERE e.segExt03 = :segExt03")
    , @NamedQuery(name = "EnPerDetalle.findBySegExt04", query = "SELECT e FROM EnPerDetalle e WHERE e.segExt04 = :segExt04")
    , @NamedQuery(name = "EnPerDetalle.findBySegExt05", query = "SELECT e FROM EnPerDetalle e WHERE e.segExt05 = :segExt05")
    , @NamedQuery(name = "EnPerDetalle.findByOtrCodIrene", query = "SELECT e FROM EnPerDetalle e WHERE e.otrCodIrene = :otrCodIrene")
    , @NamedQuery(name = "EnPerDetalle.findBySegTipOficina", query = "SELECT e FROM EnPerDetalle e WHERE e.segTipOficina = :segTipOficina")
    , @NamedQuery(name = "EnPerDetalle.findByUsuInsercion", query = "SELECT e FROM EnPerDetalle e WHERE e.usuInsercion = :usuInsercion")
    , @NamedQuery(name = "EnPerDetalle.findByFecInsercion", query = "SELECT e FROM EnPerDetalle e WHERE e.fecInsercion = :fecInsercion")
    , @NamedQuery(name = "EnPerDetalle.findByUsuModificacion", query = "SELECT e FROM EnPerDetalle e WHERE e.usuModificacion = :usuModificacion")
    , @NamedQuery(name = "EnPerDetalle.findByFecModificacion", query = "SELECT e FROM EnPerDetalle e WHERE e.fecModificacion = :fecModificacion")})
public class EnPerDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_PER_DETALLE")
    private Long codPerDetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_EXPERIENCIA")
    private long codExperiencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_EXPERIENCIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecExperiencia;
    @Size(max = 45)
    @Column(name = "SEG_CAN_VENTA")
    private String segCanVenta;
    @Size(max = 45)
    @Column(name = "SEG_ANTIGUEDAD")
    private String segAntiguedad;
    @Size(max = 45)
    @Column(name = "SEG_CUE_NOMINA")
    private String segCueNomina;
    @Size(max = 45)
    @Column(name = "SEG_EDAD")
    private String segEdad;
    @Size(max = 45)
    @Column(name = "SEG_PRODUCTO")
    private String segProducto;
    @Size(max = 45)
    @Column(name = "SEG_RES_RECLAMO")
    private String segResReclamo;
    @Size(max = 45)
    @Column(name = "SEG_SEG_CLIENTE")
    private String segSegCliente;
    @Size(max = 45)
    @Column(name = "SEG_TIP_EJE_OFI")
    private String segTipEjeOfi;
    @Size(max = 45)
    @Column(name = "SEG_TIP_TARJETA")
    private String segTipTarjeta;
    @Size(max = 45)
    @Column(name = "SEG_TRABAJO")
    private String segTrabajo;
    @Size(max = 45)
    @Column(name = "SEG_NIV_SOC_ECONOMICO")
    private String segNivSocEconomico;
    @Size(max = 45)
    @Column(name = "SEG_SUB_SEG_CLIENTE")
    private String segSubSegCliente;
    @Size(max = 45)
    @Column(name = "SEG_ARE_NEGOCIO")
    private String segAreNegocio;
    @Size(max = 45)
    @Column(name = "SEG_EXT_02")
    private String segExt02;
    @Size(max = 45)
    @Column(name = "SEG_EXT_03")
    private String segExt03;
    @Size(max = 45)
    @Column(name = "SEG_EXT_04")
    private String segExt04;
    @Size(max = 45)
    @Column(name = "SEG_EXT_05")
    private String segExt05;
    @Size(max = 45)
    @Column(name = "OTR_COD_IRENE")
    private String otrCodIrene;
    @Size(max = 45)
    @Column(name = "SEG_TIP_OFICINA")
    private String segTipOficina;
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
    @JoinColumn(name = "COD_PERSONA", referencedColumnName = "COD_PERSONA")
    @ManyToOne
    private EnPersonas codPersona;
    @JoinColumn(name = "COD_SUCURSAL", referencedColumnName = "COD_SUCURSAL")
    @ManyToOne
    private EnPtoContacto codSucursal;

    public EnPerDetalle() {
    }

    public EnPerDetalle(Long codPerDetalle) {
        this.codPerDetalle = codPerDetalle;
    }

    public EnPerDetalle(Long codPerDetalle, long codExperiencia, Date fecExperiencia, String usuInsercion, Date fecInsercion, String usuModificacion, Date fecModificacion) {
        this.codPerDetalle = codPerDetalle;
        this.codExperiencia = codExperiencia;
        this.fecExperiencia = fecExperiencia;
        this.usuInsercion = usuInsercion;
        this.fecInsercion = fecInsercion;
        this.usuModificacion = usuModificacion;
        this.fecModificacion = fecModificacion;
    }

    public Long getCodPerDetalle() {
        return codPerDetalle;
    }

    public void setCodPerDetalle(Long codPerDetalle) {
        this.codPerDetalle = codPerDetalle;
    }

    public long getCodExperiencia() {
        return codExperiencia;
    }

    public void setCodExperiencia(long codExperiencia) {
        this.codExperiencia = codExperiencia;
    }

    public Date getFecExperiencia() {
        return fecExperiencia;
    }

    public void setFecExperiencia(Date fecExperiencia) {
        this.fecExperiencia = fecExperiencia;
    }

    public String getSegCanVenta() {
        return segCanVenta;
    }

    public void setSegCanVenta(String segCanVenta) {
        this.segCanVenta = segCanVenta;
    }

    public String getSegAntiguedad() {
        return segAntiguedad;
    }

    public void setSegAntiguedad(String segAntiguedad) {
        this.segAntiguedad = segAntiguedad;
    }

    public String getSegCueNomina() {
        return segCueNomina;
    }

    public void setSegCueNomina(String segCueNomina) {
        this.segCueNomina = segCueNomina;
    }

    public String getSegEdad() {
        return segEdad;
    }

    public void setSegEdad(String segEdad) {
        this.segEdad = segEdad;
    }

    public String getSegProducto() {
        return segProducto;
    }

    public void setSegProducto(String segProducto) {
        this.segProducto = segProducto;
    }

    public String getSegResReclamo() {
        return segResReclamo;
    }

    public void setSegResReclamo(String segResReclamo) {
        this.segResReclamo = segResReclamo;
    }

    public String getSegSegCliente() {
        return segSegCliente;
    }

    public void setSegSegCliente(String segSegCliente) {
        this.segSegCliente = segSegCliente;
    }

    public String getSegTipEjeOfi() {
        return segTipEjeOfi;
    }

    public void setSegTipEjeOfi(String segTipEjeOfi) {
        this.segTipEjeOfi = segTipEjeOfi;
    }

    public String getSegTipTarjeta() {
        return segTipTarjeta;
    }

    public void setSegTipTarjeta(String segTipTarjeta) {
        this.segTipTarjeta = segTipTarjeta;
    }

    public String getSegTrabajo() {
        return segTrabajo;
    }

    public void setSegTrabajo(String segTrabajo) {
        this.segTrabajo = segTrabajo;
    }

    public String getSegNivSocEconomico() {
        return segNivSocEconomico;
    }

    public void setSegNivSocEconomico(String segNivSocEconomico) {
        this.segNivSocEconomico = segNivSocEconomico;
    }

    public String getSegSubSegCliente() {
        return segSubSegCliente;
    }

    public void setSegSubSegCliente(String segSubSegCliente) {
        this.segSubSegCliente = segSubSegCliente;
    }

    public String getSegAreNegocio() {
        return segAreNegocio;
    }

    public void setSegAreNegocio(String segAreNegocio) {
        this.segAreNegocio = segAreNegocio;
    }

    public String getSegExt02() {
        return segExt02;
    }

    public void setSegExt02(String segExt02) {
        this.segExt02 = segExt02;
    }

    public String getSegExt03() {
        return segExt03;
    }

    public void setSegExt03(String segExt03) {
        this.segExt03 = segExt03;
    }

    public String getSegExt04() {
        return segExt04;
    }

    public void setSegExt04(String segExt04) {
        this.segExt04 = segExt04;
    }

    public String getSegExt05() {
        return segExt05;
    }

    public void setSegExt05(String segExt05) {
        this.segExt05 = segExt05;
    }

    public String getOtrCodIrene() {
        return otrCodIrene;
    }

    public void setOtrCodIrene(String otrCodIrene) {
        this.otrCodIrene = otrCodIrene;
    }

    public String getSegTipOficina() {
        return segTipOficina;
    }

    public void setSegTipOficina(String segTipOficina) {
        this.segTipOficina = segTipOficina;
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

    public EnPersonas getCodPersona() {
        return codPersona;
    }

    public void setCodPersona(EnPersonas codPersona) {
        this.codPersona = codPersona;
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
        hash += (codPerDetalle != null ? codPerDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnPerDetalle)) {
            return false;
        }
        EnPerDetalle other = (EnPerDetalle) object;
        if ((this.codPerDetalle == null && other.codPerDetalle != null) || (this.codPerDetalle != null && !this.codPerDetalle.equals(other.codPerDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.facturacion.entity.EnPerDetalle[ codPerDetalle=" + codPerDetalle + " ]";
    }
    
}
