/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.funcionario.entity;

import business.direccion.entity.Barrio;
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
@Table(name = "funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f")
    , @NamedQuery(name = "Funcionario.findByIdFuncionario", query = "SELECT f FROM Funcionario f WHERE f.idFuncionario = :idFuncionario")
    , @NamedQuery(name = "Funcionario.findByNombreFuncionario", query = "SELECT f FROM Funcionario f WHERE f.nombreFuncionario = :nombreFuncionario")
    , @NamedQuery(name = "Funcionario.findByApellidoFuncionario", query = "SELECT f FROM Funcionario f WHERE f.apellidoFuncionario = :apellidoFuncionario")
    , @NamedQuery(name = "Funcionario.findByTipoDocumento", query = "SELECT f FROM Funcionario f WHERE f.tipoDocumento = :tipoDocumento")
    , @NamedQuery(name = "Funcionario.findByNroDocumento", query = "SELECT f FROM Funcionario f WHERE f.nroDocumento = :nroDocumento")
    , @NamedQuery(name = "Funcionario.findByFechaRegistro", query = "SELECT f FROM Funcionario f WHERE f.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "Funcionario.findByFechaActualizacion", query = "SELECT f FROM Funcionario f WHERE f.fechaActualizacion = :fechaActualizacion")
    , @NamedQuery(name = "Funcionario.findByEstado", query = "SELECT f FROM Funcionario f WHERE f.estado = :estado")
    , @NamedQuery(name = "Funcionario.findByDireccion", query = "SELECT f FROM Funcionario f WHERE f.direccion = :direccion")
    , @NamedQuery(name = "Funcionario.findByTelefono", query = "SELECT f FROM Funcionario f WHERE f.telefono = :telefono")
    , @NamedQuery(name = "Funcionario.findByCelular", query = "SELECT f FROM Funcionario f WHERE f.celular = :celular")})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j
public class Funcionario implements Serializable {

    @OneToMany(mappedBy = "idFuncionario")
    private List<Usuario> usuarioList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFuncionario")
    private Integer idFuncionario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombreFuncionario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellido")
    private String apellidoFuncionario;
    @Size(max = 45)
    @Column(name = "tip_documento")
    private String tipoDocumento;
    @Size(max = 20)
    @Column(name = "nro_documento")
    private String nroDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fec_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Column(name = "fec_actualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "estado")
    private String estado;
    @Size(max = 255)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 30)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 15)
    @Column(name = "celular")
    private String celular;
    @JoinColumn(name = "id_barrio", referencedColumnName = "idBarrio")
    @ManyToOne
    private Barrio idBarrio;
    @JoinColumn(name = "id_usuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @JoinColumn(name = "id_usu_actualizacion", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario idUsuarioActualizacion;
    @JoinColumn(name = "id_usu_registro", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idUsuarioRegistro;

    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "tecnico")
    private String tecnico;

}
