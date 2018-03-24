/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.funcionario.entity;

import business.funcionario.entity.Funcionario;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ggauto
 */
@Entity
@Table(name = "funcionario_horario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FuncionarioHorario.findAll", query = "SELECT f FROM FuncionarioHorario f")
    , @NamedQuery(name = "FuncionarioHorario.findByIdFuncionarioHorario", query = "SELECT f FROM FuncionarioHorario f WHERE f.idFuncionarioHorario = :idFuncionarioHorario")
    , @NamedQuery(name = "FuncionarioHorario.findByFechaRegistro", query = "SELECT f FROM FuncionarioHorario f WHERE f.fechaRegistro = :fechaRegistro")
    , @NamedQuery(name = "FuncionarioHorario.findByFechaActualizacion", query = "SELECT f FROM FuncionarioHorario f WHERE f.fechaActualizacion = :fechaActualizacion")})
public class FuncionarioHorario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFuncionarioHorario")
    private Integer idFuncionarioHorario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaRegistro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Column(name = "fechaActualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;
    @JoinColumn(name = "idUsuarioActualizacion", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario idUsuarioActualizacion;
    @JoinColumn(name = "idUsuarioRegistro", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idUsuarioRegistro;
    @JoinColumn(name = "idFuncionario", referencedColumnName = "idFuncionario")
    @ManyToOne(optional = false)
    private Funcionario idFuncionario;
    @JoinColumn(name = "idHorario", referencedColumnName = "idHorario")
    @ManyToOne(optional = false)
    private Horario idHorario;

    public FuncionarioHorario() {
    }

    public FuncionarioHorario(Integer idFuncionarioHorario) {
        this.idFuncionarioHorario = idFuncionarioHorario;
    }

    public FuncionarioHorario(Integer idFuncionarioHorario, Date fechaRegistro) {
        this.idFuncionarioHorario = idFuncionarioHorario;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdFuncionarioHorario() {
        return idFuncionarioHorario;
    }

    public void setIdFuncionarioHorario(Integer idFuncionarioHorario) {
        this.idFuncionarioHorario = idFuncionarioHorario;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Usuario getIdUsuarioActualizacion() {
        return idUsuarioActualizacion;
    }

    public void setIdUsuarioActualizacion(Usuario idUsuarioActualizacion) {
        this.idUsuarioActualizacion = idUsuarioActualizacion;
    }

    public Usuario getIdUsuarioRegistro() {
        return idUsuarioRegistro;
    }

    public void setIdUsuarioRegistro(Usuario idUsuarioRegistro) {
        this.idUsuarioRegistro = idUsuarioRegistro;
    }

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Horario getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Horario idHorario) {
        this.idHorario = idHorario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFuncionarioHorario != null ? idFuncionarioHorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FuncionarioHorario)) {
            return false;
        }
        FuncionarioHorario other = (FuncionarioHorario) object;
        if ((this.idFuncionarioHorario == null && other.idFuncionarioHorario != null) || (this.idFuncionarioHorario != null && !this.idFuncionarioHorario.equals(other.idFuncionarioHorario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.direccion.entity.FuncionarioHorario[ idFuncionarioHorario=" + idFuncionarioHorario + " ]";
    }
    
}
