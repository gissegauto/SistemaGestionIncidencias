/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.cliente.entity;

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
@Table(name = "historial_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistorialCliente.findAll", query = "SELECT h FROM HistorialCliente h")
    , @NamedQuery(name = "HistorialCliente.findByIdHistorialCliente", query = "SELECT h FROM HistorialCliente h WHERE h.idHistorialCliente = :idHistorialCliente")
    , @NamedQuery(name = "HistorialCliente.findByNombre", query = "SELECT h FROM HistorialCliente h WHERE h.nombre = :nombre")
    , @NamedQuery(name = "HistorialCliente.findByApellido", query = "SELECT h FROM HistorialCliente h WHERE h.apellido = :apellido")
    , @NamedQuery(name = "HistorialCliente.findByTipoDocumento", query = "SELECT h FROM HistorialCliente h WHERE h.tipoDocumento = :tipoDocumento")
    , @NamedQuery(name = "HistorialCliente.findByNroDocumento", query = "SELECT h FROM HistorialCliente h WHERE h.nroDocumento = :nroDocumento")
    , @NamedQuery(name = "HistorialCliente.findBySexo", query = "SELECT h FROM HistorialCliente h WHERE h.sexo = :sexo")
    , @NamedQuery(name = "HistorialCliente.findByEstado", query = "SELECT h FROM HistorialCliente h WHERE h.estado = :estado")
    , @NamedQuery(name = "HistorialCliente.findByFechaRegistro", query = "SELECT h FROM HistorialCliente h WHERE h.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "HistorialCliente.findByFechaActualizacion", query = "SELECT h FROM HistorialCliente h WHERE h.fechaActualizacion = :fechaActualizacion")
    , @NamedQuery(name = "HistorialCliente.findByIdBarrio", query = "SELECT h FROM HistorialCliente h WHERE h.idBarrio = :idBarrio")
    , @NamedQuery(name = "HistorialCliente.findByContrato", query = "SELECT h FROM HistorialCliente h WHERE h.contrato = :contrato")})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j
public class HistorialCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idHistorialCliente")
    private Integer idHistorialCliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellido")
    private String apellido;
    @Size(max = 10)
    @Column(name = "tipoDocumento")
    private String tipoDocumento;
    @Size(max = 20)
    @Column(name = "nroDocumento")
    private String nroDocumento;
    @Size(max = 1)
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaRegistro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Column(name = "fechaActualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;
    @Column(name = "idBarrio")
    private Integer idBarrio;
    @Size(max = 255)
    @Column(name = "contrato")
    private String contrato;
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "idUsuarioActualizacion", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario idUsuarioActualizacion;
    @JoinColumn(name = "idUsuarioRegistro", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idUsuarioRegistro;

}
