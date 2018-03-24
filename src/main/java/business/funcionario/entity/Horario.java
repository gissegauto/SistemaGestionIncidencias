/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.funcionario.entity;

import business.funcionario.entity.FuncionarioHorario;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ggauto
 */
@Entity
@Table(name = "horario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horario.findAll", query = "SELECT h FROM Horario h")
    , @NamedQuery(name = "Horario.findByIdHorario", query = "SELECT h FROM Horario h WHERE h.idHorario = :idHorario")
    , @NamedQuery(name = "Horario.findByEntrada", query = "SELECT h FROM Horario h WHERE h.entrada = :entrada")
    , @NamedQuery(name = "Horario.findBySalida", query = "SELECT h FROM Horario h WHERE h.salida = :salida")
    , @NamedQuery(name = "Horario.findByEntradaAlmuerzo", query = "SELECT h FROM Horario h WHERE h.entradaAlmuerzo = :entradaAlmuerzo")
    , @NamedQuery(name = "Horario.findBySalidaAlmuerzo", query = "SELECT h FROM Horario h WHERE h.salidaAlmuerzo = :salidaAlmuerzo")})
public class Horario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idHorario")
    private Integer idHorario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "entrada")
    @Temporal(TemporalType.DATE)
    private Date entrada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salida")
    @Temporal(TemporalType.DATE)
    private Date salida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "entrada_almuerzo")
    @Temporal(TemporalType.DATE)
    private Date entradaAlmuerzo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salida_almuerzo")
    @Temporal(TemporalType.DATE)
    private Date salidaAlmuerzo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHorario")
    private Collection<FuncionarioHorario> funcionarioHorarioCollection;

    public Horario() {
    }

    public Horario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public Horario(Integer idHorario, Date entrada, Date salida, Date entradaAlmuerzo, Date salidaAlmuerzo) {
        this.idHorario = idHorario;
        this.entrada = entrada;
        this.salida = salida;
        this.entradaAlmuerzo = entradaAlmuerzo;
        this.salidaAlmuerzo = salidaAlmuerzo;
    }

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getSalida() {
        return salida;
    }

    public void setSalida(Date salida) {
        this.salida = salida;
    }

    public Date getEntradaAlmuerzo() {
        return entradaAlmuerzo;
    }

    public void setEntradaAlmuerzo(Date entradaAlmuerzo) {
        this.entradaAlmuerzo = entradaAlmuerzo;
    }

    public Date getSalidaAlmuerzo() {
        return salidaAlmuerzo;
    }

    public void setSalidaAlmuerzo(Date salidaAlmuerzo) {
        this.salidaAlmuerzo = salidaAlmuerzo;
    }

    @XmlTransient
    public Collection<FuncionarioHorario> getFuncionarioHorarioCollection() {
        return funcionarioHorarioCollection;
    }

    public void setFuncionarioHorarioCollection(Collection<FuncionarioHorario> funcionarioHorarioCollection) {
        this.funcionarioHorarioCollection = funcionarioHorarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHorario != null ? idHorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horario)) {
            return false;
        }
        Horario other = (Horario) object;
        if ((this.idHorario == null && other.idHorario != null) || (this.idHorario != null && !this.idHorario.equals(other.idHorario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "business.direccion.entity.Horario[ idHorario=" + idHorario + " ]";
    }
    
}
