/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.configuracion.entity;

import business.usuario.entity.Usuario;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
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

/**
 *
 * @author ggauto
 */
@Entity
@Table(name = "notificaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notificaciones.findAll", query = "SELECT n FROM Notificaciones n")
    , @NamedQuery(name = "Notificaciones.findByIdNotificaciones", query = "SELECT n FROM Notificaciones n WHERE n.idNotificaciones = :idNotificaciones")
    , @NamedQuery(name = "Notificaciones.findByAsunto", query = "SELECT n FROM Notificaciones n WHERE n.asunto = :asunto")
    , @NamedQuery(name = "Notificaciones.findByDescripcion", query = "SELECT n FROM Notificaciones n WHERE n.descripcion = :descripcion")
    , @NamedQuery(name = "Notificaciones.findByFechaHora", query = "SELECT n FROM Notificaciones n WHERE n.fechaHora = :fechaHora")
    , @NamedQuery(name = "Notificaciones.findByFechaRegistro", query = "SELECT n FROM Notificaciones n WHERE n.fechaRegistro = :fechaRegistro")})
public class Notificaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idNotificaciones")
    private Integer idNotificaciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "asunto")
    private String asunto;
    @Size(max = 500)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaHora")
    @Temporal(TemporalType.DATE)
    private Date fechaHora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaRegistro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Column(name = "todos")
    private String todos;
    @JoinColumn(name = "idUsuarioRegistro", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idUsuarioRegistro;

    public Notificaciones() {
    }

    public Notificaciones(Integer idNotificaciones) {
        this.idNotificaciones = idNotificaciones;
    }

    public Notificaciones(Integer idNotificaciones, String asunto, String descripcion, Date fechaHora, Date fechaRegistro, String todos, Usuario idUsuarioRegistro) {
        this.idNotificaciones = idNotificaciones;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.fechaHora = fechaHora;
        this.fechaRegistro = fechaRegistro;
        this.todos = todos;
        this.idUsuarioRegistro = idUsuarioRegistro;
    }

    public String getTodos() {
        return todos;
    }

    public void setTodos(String todos) {
        this.todos = todos;
    }

    public Integer getIdNotificaciones() {
        return idNotificaciones;
    }

    public void setIdNotificaciones(Integer idNotificaciones) {
        this.idNotificaciones = idNotificaciones;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Usuario getIdUsuarioRegistro() {
        return idUsuarioRegistro;
    }

    public void setIdUsuarioRegistro(Usuario idUsuarioRegistro) {
        this.idUsuarioRegistro = idUsuarioRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.idNotificaciones);
        hash = 59 * hash + Objects.hashCode(this.asunto);
        hash = 59 * hash + Objects.hashCode(this.descripcion);
        hash = 59 * hash + Objects.hashCode(this.fechaHora);
        hash = 59 * hash + Objects.hashCode(this.fechaRegistro);
        hash = 59 * hash + Objects.hashCode(this.todos);
        hash = 59 * hash + Objects.hashCode(this.idUsuarioRegistro);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Notificaciones other = (Notificaciones) obj;
        if (!Objects.equals(this.asunto, other.asunto)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.todos, other.todos)) {
            return false;
        }
        if (!Objects.equals(this.idNotificaciones, other.idNotificaciones)) {
            return false;
        }
        if (!Objects.equals(this.fechaHora, other.fechaHora)) {
            return false;
        }
        if (!Objects.equals(this.fechaRegistro, other.fechaRegistro)) {
            return false;
        }
        if (!Objects.equals(this.idUsuarioRegistro, other.idUsuarioRegistro)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.configuracion.entity.Notificaciones[ idNotificaciones=" + idNotificaciones + " ]";
    }

}
