/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.usuario.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 *
 * @author ggauto
 */
@Entity
@Table(name = "pantalla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pantalla.findAll", query = "SELECT p FROM Pantalla p")
    , @NamedQuery(name = "Pantalla.findByIdpantalla", query = "SELECT p FROM Pantalla p WHERE p.idpantalla = :idpantalla")
    , @NamedQuery(name = "Pantalla.findByDescripcion", query = "SELECT p FROM Pantalla p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Pantalla.findByCodigoPantalla", query = "SELECT p FROM Pantalla p WHERE p.codigoPantalla = :codigoPantalla")})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j
public class Pantalla implements Serializable {

    @OneToMany(mappedBy = "idpantalla")
    private Collection<RolPantalla> rolPantallaCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpantalla")
    private Integer idpantalla;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 45)
    @Column(name = "codigo_pantalla")
    private String codigoPantalla;

}
