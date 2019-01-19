/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.funcionario.entity;

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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 *
 * @author ggauto
 */
@Entity
@Table(name = "historial_Funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistorialFuncionario.findAll", query = "SELECT h FROM HistorialFuncionario h")
    , @NamedQuery(name = "HistorialFuncionario.findByIdHistorialFuncionario", query = "SELECT h FROM HistorialFuncionario h WHERE h.idHistorialFuncionario = :idHistorialFuncionario")
    , @NamedQuery(name = "HistorialFuncionario.findByIdFuncionario", query = "SELECT h FROM HistorialFuncionario h WHERE h.idFuncionario = :idFuncionario")
    , @NamedQuery(name = "HistorialFuncionario.findByIdUsuario", query = "SELECT h FROM HistorialFuncionario h WHERE h.idUsuario = :idUsuario")
    , @NamedQuery(name = "HistorialFuncionario.findByNombreFuncionario", query = "SELECT h FROM HistorialFuncionario h WHERE h.nombreFuncionario = :nombreFuncionario")
    , @NamedQuery(name = "HistorialFuncionario.findByApellidoFuncionario", query = "SELECT h FROM HistorialFuncionario h WHERE h.apellidoFuncionario = :apellidoFuncionario")
    , @NamedQuery(name = "HistorialFuncionario.findByTipoDocumento", query = "SELECT h FROM HistorialFuncionario h WHERE h.tipoDocumento = :tipoDocumento")
    , @NamedQuery(name = "HistorialFuncionario.findByNroDocumento", query = "SELECT h FROM HistorialFuncionario h WHERE h.nroDocumento = :nroDocumento")
    , @NamedQuery(name = "HistorialFuncionario.findByIdUsuarioRegistro", query = "SELECT h FROM HistorialFuncionario h WHERE h.idUsuarioRegistro = :idUsuarioRegistro")
    , @NamedQuery(name = "HistorialFuncionario.findByFechaRegistro", query = "SELECT h FROM HistorialFuncionario h WHERE h.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "HistorialFuncionario.findByIdUsuarioActualizacion", query = "SELECT h FROM HistorialFuncionario h WHERE h.idUsuarioActualizacion = :idUsuarioActualizacion")
    , @NamedQuery(name = "HistorialFuncionario.findByFechaActualizacion", query = "SELECT h FROM HistorialFuncionario h WHERE h.fechaActualizacion = :fechaActualizacion")
    , @NamedQuery(name = "HistorialFuncionario.findByEstado", query = "SELECT h FROM HistorialFuncionario h WHERE h.estado = :estado")
    , @NamedQuery(name = "HistorialFuncionario.findByIdBarrio", query = "SELECT h FROM HistorialFuncionario h WHERE h.idBarrio = :idBarrio")
    , @NamedQuery(name = "HistorialFuncionario.findByDireccion", query = "SELECT h FROM HistorialFuncionario h WHERE h.direccion = :direccion")})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j
public class HistorialFuncionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idHistorialFuncionario")
    private Integer idHistorialFuncionario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idFuncionario")
    private int idFuncionario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuario")
    private int idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreFuncionario")
    private String nombreFuncionario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellidoFuncionario")
    private String apellidoFuncionario;
    @Size(max = 45)
    @Column(name = "tipoDocumento")
    private String tipoDocumento;
    @Size(max = 20)
    @Column(name = "nroDocumento")
    private String nroDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuarioRegistro")
    private int idUsuarioRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaRegistro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsuarioActualizacion")
    private int idUsuarioActualizacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaActualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estado")
    private String estado;
    @Column(name = "idBarrio")
    private Integer idBarrio;
    @Size(max = 255)
    @Column(name = "direccion")
    private String direccion;

}
