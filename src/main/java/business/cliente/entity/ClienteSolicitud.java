/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.cliente.entity;

import business.funcionario.entity.Funcionario;
import business.solicitudes.entity.SolicitudConexion;
import java.io.Serializable;
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
@Table(name = "cliente_solicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClienteSolicitud.findAll", query = "SELECT c FROM ClienteSolicitud c")
    , @NamedQuery(name = "ClienteSolicitud.findByIdSolicitudConexion", query = "SELECT c FROM ClienteSolicitud c WHERE c.idSolicitudConexion = :idSolicitudConexion")
    , @NamedQuery(name = "ClienteSolicitud.findByIdClienteSolicitud", query = "SELECT c FROM ClienteSolicitud c WHERE c.idClienteSolicitud = :idClienteSolicitud")})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j
public class ClienteSolicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idClienteSolicitud")
    private Integer idClienteSolicitud;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "estado")
    private String estado;

    @JoinColumn(name = "idSolicitudConexion", referencedColumnName = "idSolicitudConexion")
    @ManyToOne(optional = false)
    private SolicitudConexion idSolicitudConexion;

    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    @ManyToOne
    private Cliente idCliente;

    @JoinColumn(name = "idFuncionario", referencedColumnName = "idFuncionario")
    @ManyToOne(optional = false)
    private Funcionario idFuncionario;

}
