/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.facturacion.entity;

import business.configuracion.entity.Servicio;
import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ggauto
 */
@Entity
@Table(name = "fac_detalle")
@NamedQueries({
    @NamedQuery(name = "FacturaDetalle.findAll", query = "SELECT f FROM FacturaDetalle f")
    , @NamedQuery(name = "FacturaDetalle.findByIdFacturaDetalle", query = "SELECT f FROM FacturaDetalle f WHERE f.idFacturaDetalle = :idFacturaDetalle")
    , @NamedQuery(name = "FacturaDetalle.findByPreUnitario", query = "SELECT f FROM FacturaDetalle f WHERE f.preUnitario = :preUnitario")
    , @NamedQuery(name = "FacturaDetalle.findByCantidad", query = "SELECT f FROM FacturaDetalle f WHERE f.cantidad = :cantidad")
    , @NamedQuery(name = "FacturaDetalle.findByTotal", query = "SELECT f FROM FacturaDetalle f WHERE f.total = :total")
    , @NamedQuery(name = "FacturaDetalle.findByTotMulta", query = "SELECT f FROM FacturaDetalle f WHERE f.totMulta = :totMulta")
    , @NamedQuery(name = "FacturaDetalle.findByMulta", query = "SELECT f FROM FacturaDetalle f WHERE f.multa = :multa")
    , @NamedQuery(name = "FacturaDetalle.findByEstado", query = "SELECT f FROM FacturaDetalle f WHERE f.estado = :estado")
    , @NamedQuery(name = "FacturaDetalle.findByDescripcion", query = "SELECT f FROM FacturaDetalle f WHERE f.descripcion = :descripcion")})
public class FacturaDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fac_detalle")
    private Integer idFacturaDetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pre_unitario")
    private double preUnitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private double total;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "tot_multa")
    private Double totMulta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "multa")
    private String multa;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @Size(max = 255)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "id_servicio", referencedColumnName = "idServicio")
    @ManyToOne(optional = false)
    private Servicio idServicio;
    @JoinColumn(name = "id_factura", referencedColumnName = "id_factura")
    @ManyToOne
    private Factura idFactura;

    public FacturaDetalle() {
    }

    public Integer getIdFacturaDetalle() {
        return idFacturaDetalle;
    }

    public void setIdFacturaDetalle(Integer idFacturaDetalle) {
        this.idFacturaDetalle = idFacturaDetalle;
    }

    public FacturaDetalle(Integer idFacturaDetalle, double preUnitario, int cantidad, double total, Double totMulta, String multa, String estado, String descripcion, Servicio idServicio, Factura idFactura) {
        this.idFacturaDetalle = idFacturaDetalle;
        this.preUnitario = preUnitario;
        this.cantidad = cantidad;
        this.total = total;
        this.totMulta = totMulta;
        this.multa = multa;
        this.estado = estado;
        this.descripcion = descripcion;
        this.idServicio = idServicio;
        this.idFactura = idFactura;
    }

    public double getPreUnitario() {
        return preUnitario;
    }

    public void setPreUnitario(double preUnitario) {
        this.preUnitario = preUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Double getTotMulta() {
        return totMulta;
    }

    public void setTotMulta(Double totMulta) {
        this.totMulta = totMulta;
    }

    public String getMulta() {
        return multa;
    }

    public void setMulta(String multa) {
        this.multa = multa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    public Factura getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Factura idFactura) {
        this.idFactura = idFactura;
    }

    @Override
    public String toString() {
        return "business.facturacion.entity.FacDetalle[ idFacDetalle=" + idFacturaDetalle + " ]";
    }

}
