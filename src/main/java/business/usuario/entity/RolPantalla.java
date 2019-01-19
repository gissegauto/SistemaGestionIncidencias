/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.usuario.entity;

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
@Table(name = "rol_pantalla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolPantalla.findAll", query = "SELECT r FROM RolPantalla r")
    , @NamedQuery(name = "RolPantalla.findByIdrolPantalla", query = "SELECT r FROM RolPantalla r WHERE r.idrolPantalla = :idrolPantalla")
    , @NamedQuery(name = "RolPantalla.findByIdrol", query = "SELECT r FROM RolPantalla r WHERE r.idrol = :idrol")})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j
public class RolPantalla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrol_pantalla")
    private Integer idrolPantalla;
    @JoinColumn(name = "idrol", referencedColumnName = "idrol")
    @ManyToOne
    private Rol idrol;
    @JoinColumn(name = "idpantalla", referencedColumnName = "idpantalla")
    @ManyToOne
    private Pantalla idpantalla;

}
