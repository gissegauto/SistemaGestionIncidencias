/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.facturacion.entity;

import business.cliente.entity.Cliente;
import business.usuario.entity.Usuario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 *
 * @author ggauto
 */
@Entity
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
    , @NamedQuery(name = "Factura.findByIdFactura", query = "SELECT f FROM Factura f WHERE f.idFactura = :idFactura")
    , @NamedQuery(name = "Factura.findByFecInsercion", query = "SELECT f FROM Factura f WHERE f.fecInsercion = :fecInsercion")
    , @NamedQuery(name = "Factura.findByFecModificacion", query = "SELECT f FROM Factura f WHERE f.fecModificacion = :fecModificacion")
    , @NamedQuery(name = "Factura.findByNroFactura", query = "SELECT f FROM Factura f WHERE f.nroFactura = :nroFactura")
    , @NamedQuery(name = "Factura.findByTimbrado", query = "SELECT f FROM Factura f WHERE f.timbrado = :timbrado")
    , @NamedQuery(name = "Factura.findByBoleta", query = "SELECT f FROM Factura f WHERE f.boleta = :boleta")
    , @NamedQuery(name = "Factura.findByNroBoleta", query = "SELECT f FROM Factura f WHERE f.nroBoleta = :nroBoleta")
    , @NamedQuery(name = "Factura.findByTotal", query = "SELECT f FROM Factura f WHERE f.total = :total")
    , @NamedQuery(name = "Factura.findByEstado", query = "SELECT f FROM Factura f WHERE f.estado = :estado")})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_factura")
    private Integer idFactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_insercion")
    @Temporal(TemporalType.DATE)
    private Date fecInsercion;
    @Column(name = "fec_modificacion")
    @Temporal(TemporalType.DATE)
    private Date fecModificacion;
    @Size(max = 45)
    @Column(name = "nro_factura")
    private String nroFactura;
    @Size(max = 45)
    @Column(name = "timbrado")
    private String timbrado;
    @Size(max = 2)
    @Column(name = "boleta")
    private String boleta;
    @Size(max = 45)
    @Column(name = "nro_boleta")
    private String nroBoleta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private double total;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "estado")
    private String estado;
    @Column(name = "fec_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;

    @JoinColumn(name = "id_cliente", referencedColumnName = "idCliente")
    @ManyToOne
    private Cliente cliente;

    @JoinColumn(name = "usu_insercion", referencedColumnName = "idUsuario")
    @ManyToOne
    private Usuario idUsuarioActualizacion;
    @JoinColumn(name = "usu_modificacion", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario idUsuarioRegistro;

    @OneToMany(mappedBy = "idFactura")
    private List<FacturaDetalle> facturaDetalleList;

}
