/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.cliente.entity;

import business.direccion.entity.Barrio;
import business.direccion.entity.Zona;
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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente")
    , @NamedQuery(name = "Cliente.findByApellido", query = "SELECT c FROM Cliente c WHERE c.apellido = :apellido")
    , @NamedQuery(name = "Cliente.findByCelular", query = "SELECT c FROM Cliente c WHERE c.celular = :celular")
    , @NamedQuery(name = "Cliente.findByContrato", query = "SELECT c FROM Cliente c WHERE c.contrato = :contrato")
    , @NamedQuery(name = "Cliente.findByDireccion", query = "SELECT c FROM Cliente c WHERE c.direccion = :direccion")
    , @NamedQuery(name = "Cliente.findByEstado", query = "SELECT c FROM Cliente c WHERE c.estado = :estado")
    , @NamedQuery(name = "Cliente.findByFechaActualizacion", query = "SELECT c FROM Cliente c WHERE c.fechaActualizacion = :fechaActualizacion")
    , @NamedQuery(name = "Cliente.findByFechaRegistro", query = "SELECT c FROM Cliente c WHERE c.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "Cliente.findByNombre", query = "SELECT c FROM Cliente c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Cliente.findByNroDocumento", query = "SELECT c FROM Cliente c WHERE c.nroDocumento = :nroDocumento")
    , @NamedQuery(name = "Cliente.findByObservaciones", query = "SELECT c FROM Cliente c WHERE c.observaciones = :observaciones")
    , @NamedQuery(name = "Cliente.findBySexo", query = "SELECT c FROM Cliente c WHERE c.sexo = :sexo")
    , @NamedQuery(name = "Cliente.findByTelefono", query = "SELECT c FROM Cliente c WHERE c.telefono = :telefono")
    , @NamedQuery(name = "Cliente.findByTipoDocumento", query = "SELECT c FROM Cliente c WHERE c.tipoDocumento = :tipoDocumento")})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCliente")
    private Integer idCliente;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "apellido")
    private String apellido;
    @Size(max = 15)
    @Column(name = "nro_documento")
    private String nroDocumento;
    @Size(max = 255)
    @Column(name = "observaciones")
    private String observaciones;
    @Size(max = 10)
    @Column(name = "sexo")
    private String sexo;
    @Size(max = 25)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 25)
    @Column(name = "tip_documento")
    private String tipoDocumento;
    @Size(max = 25)
    @Column(name = "celular")
    private String celular;
    @Size(max = 255)
    @Column(name = "contrato")
    private String contrato;
    @Size(max = 255)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 10)
    @Column(name = "estado")
    private String estado;
    @Column(name = "fec_actualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;
    @Column(name = "fec_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @JoinColumn(name = "id_barrio", referencedColumnName = "idBarrio")
    @ManyToOne
    private Barrio idBarrio;
    @JoinColumn(name = "id_usu_actualizacion", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario idUsuarioActualizacion;
    @JoinColumn(name = "id_usu_registro", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario idUsuarioRegistro;
    @JoinColumn(name = "id_zona", referencedColumnName = "idZona")
    @ManyToOne
    private Zona idZona;

}
