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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

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
@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j
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

}
