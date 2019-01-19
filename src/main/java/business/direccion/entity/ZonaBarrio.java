/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.direccion.entity;

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
@Table(name = "zona_barrio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZonaBarrio.findAll", query = "SELECT z FROM ZonaBarrio z")
    , @NamedQuery(name = "ZonaBarrio.findByIdZonabarrio", query = "SELECT z FROM ZonaBarrio z WHERE z.idZonabarrio = :idZonabarrio")})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j
public class ZonaBarrio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idZona_barrio")
    private Integer idZonabarrio;
    @JoinColumn(name = "idZona", referencedColumnName = "idZona")
    @ManyToOne(optional = false)
    private Zona idZona;
    @JoinColumn(name = "idBarrio", referencedColumnName = "idBarrio")
    @ManyToOne(optional = false)
    private Barrio idBarrio;

}
