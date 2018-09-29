/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.usuario.entity;

import business.cliente.entity.Cliente;
import business.configuracion.entity.Articulo;
import business.facturacion.entity.Factura;
import business.funcionario.entity.Funcionario;
import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

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
public class Usuario implements Serializable {

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

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuario")
    private Integer idusuario;
    @Size(max = 45)
    @Column(name = "username")
    private String username;
    @Size(max = 45)
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "idrol", referencedColumnName = "idrol")
    @ManyToOne
    private Rol idrol;
    @JoinColumn(name = "idFuncionario", referencedColumnName = "idFuncionario")
    @ManyToOne
    private Funcionario idFuncionario;
    
    public Usuario() {
    }

    public Usuario(Integer idusuario, String username, String password) {
        this.idusuario = idusuario;
        this.username = username;
        this.password = password;
    }
    

    public Usuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getIdrol() {
        return idrol;
    }

    public void setIdrol(Rol idrol) {
        this.idrol = idrol;
    }

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }


    @Override
    public String toString() {
        return "Usuario{" + "idusuario=" + idusuario + ", username=" + username + ", password=" + password + ", idrol=" + idrol + ", idFuncionario=" + idFuncionario + '}';
    }

    public List<Articulo> getArticuloList() {
        return articuloList;
    }

    public void setArticuloList(List<Articulo> articuloList) {
        this.articuloList = articuloList;
    }

    public List<Articulo> getArticuloList1() {
        return articuloList1;
    }

    public void setArticuloList1(List<Articulo> articuloList1) {
        this.articuloList1 = articuloList1;
    }

    public List<Funcionario> getFuncionarioList() {
        return funcionarioList;
    }

    public void setFuncionarioList(List<Funcionario> funcionarioList) {
        this.funcionarioList = funcionarioList;
    }

    public List<Funcionario> getFuncionarioList1() {
        return funcionarioList1;
    }

    public void setFuncionarioList1(List<Funcionario> funcionarioList1) {
        this.funcionarioList1 = funcionarioList1;
    }

    public List<Funcionario> getFuncionarioList2() {
        return funcionarioList2;
    }

    public void setFuncionarioList2(List<Funcionario> funcionarioList2) {
        this.funcionarioList2 = funcionarioList2;
    }
    
}
