/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.solicitudes.entity;

import business.cliente.entity.Cliente;
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
@Table(name = "solicitud_ampliacion")
@NamedQueries({
    @NamedQuery(name = "SolicitudAmpliacion.findAll", query = "SELECT s FROM SolicitudAmpliacion s")
    , @NamedQuery(name = "SolicitudAmpliacion.findByIdSolicitudAmpliacion", query = "SELECT s FROM SolicitudAmpliacion s WHERE s.idSolicitudAmpliacion = :idSolicitudAmpliacion")
    , @NamedQuery(name = "SolicitudAmpliacion.findByObservaciones", query = "SELECT s FROM SolicitudAmpliacion s WHERE s.observaciones = :observaciones")
    , @NamedQuery(name = "SolicitudAmpliacion.findByEstado", query = "SELECT s FROM SolicitudAmpliacion s WHERE s.estado = :estado")
    , @NamedQuery(name = "SolicitudAmpliacion.findByCantidadTV", query = "SELECT s FROM SolicitudAmpliacion s WHERE s.cantidadTV = :cantidadTV")})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j
public class SolicitudAmpliacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSolicitudAmpliacion")
    private Integer idSolicitudAmpliacion;
    @Size(max = 255)
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "estado")
    private String estado;
    @Column(name = "cantidadTV")
    private Integer cantidadTV;
    @Basic(optional = false)
    @Column(name = "fechaRegistro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Column(name = "fechaActualizacion")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;

    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "idFuncionario", referencedColumnName = "idFuncionario")
    @ManyToOne(optional = false)
    private Funcionario idFuncionario;
    @JoinColumn(name = "idUsuarioActualizacion", referencedColumnName = "idusuario")
    @ManyToOne
    private Usuario idUsuarioActualizacion;
    @JoinColumn(name = "idUsuarioRegistro", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idUsuarioRegistro;

}
