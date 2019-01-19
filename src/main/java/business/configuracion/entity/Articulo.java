/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.configuracion.entity;

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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 *
 * @author ggauto
 */
@Entity
@Table(name = "articulo")
@NamedQueries({
    @NamedQuery(name = "Articulo.findAll", query = "SELECT a FROM Articulo a")
    , @NamedQuery(name = "Articulo.findByIdArticulo", query = "SELECT a FROM Articulo a WHERE a.idArticulo = :idArticulo")
    , @NamedQuery(name = "Articulo.findByPrecio", query = "SELECT a FROM Articulo a WHERE a.precio = :precio")
    , @NamedQuery(name = "Articulo.findByDescripcion", query = "SELECT a FROM Articulo a WHERE a.descripcion = :descripcion")
    , @NamedQuery(name = "Articulo.findByEstado", query = "SELECT a FROM Articulo a WHERE a.estado = :estado")
    , @NamedQuery(name = "Articulo.findByFecInsercion", query = "SELECT a FROM Articulo a WHERE a.fecInsercion = :fecInsercion")
    , @NamedQuery(name = "Articulo.findByFecModificacion", query = "SELECT a FROM Articulo a WHERE a.fecModificacion = :fecModificacion")
    , @NamedQuery(name = "Articulo.findByCantidad", query = "SELECT a FROM Articulo a WHERE a.cantidad = :cantidad")})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idArticulo")
    private Integer idArticulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "estado")
    private String estado;
    @Column(name = "fec_insercion")
    @Temporal(TemporalType.DATE)
    private Date fecInsercion;
    @Column(name = "fec_modificacion")
    @Temporal(TemporalType.DATE)
    private Date fecModificacion;
    @Column(name = "cantidad")
    private Integer cantidad;
    @JoinColumn(name = "usu_insercion", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario usuInsercion;
    @JoinColumn(name = "usu_modificacion", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario usuModificacion;

}
