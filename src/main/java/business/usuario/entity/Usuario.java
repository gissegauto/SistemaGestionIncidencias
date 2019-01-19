/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.usuario.entity;

import business.configuracion.entity.Articulo;
import business.configuracion.entity.Configuracion;
import business.funcionario.entity.Funcionario;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdusuario", query = "SELECT u FROM Usuario u WHERE u.idusuario = :idusuario")
    , @NamedQuery(name = "Usuario.findByUsername", query = "SELECT u FROM Usuario u WHERE u.username = :username")
    , @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password")})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuario")
    private Integer idusuario;
    @Size(max = 45)
    @NotNull
    @Column(name = "username")
    private String username;
    @Size(max = 45)
    @NotNull
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "id_rol", referencedColumnName = "idrol")
    @ManyToOne
    private Rol idrol;
    @JoinColumn(name = "id_funcionario", referencedColumnName = "idFuncionario")
    @ManyToOne
    private Funcionario idFuncionario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "estado")
    private String estado;

    @OneToMany(mappedBy = "usuInsercion")
    private List<Articulo> articuloList;
    @OneToMany(mappedBy = "usuModificacion")
    private List<Articulo> articuloList1;
    @OneToMany(mappedBy = "idUsuario")
    private List<Funcionario> funcionarioList;
    @OneToMany(mappedBy = "idUsuarioActualizacion")
    private List<Funcionario> funcionarioList1;
    @OneToMany(mappedBy = "idUsuarioRegistro")
    private List<Funcionario> funcionarioList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuInsercion")
    private List<Configuracion> configuracionList;
    @OneToMany(mappedBy = "usuModificacion")
    private List<Configuracion> configuracionList1;

}
