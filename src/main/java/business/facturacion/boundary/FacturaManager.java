/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.facturacion.boundary;

import business.dao.GenericImpl;
import business.facturacion.entity.Factura;
import javax.ejb.Stateless;

/**
 *
 * @author ggauto
 */
@Stateless
public class FacturaManager extends GenericImpl<Factura, Integer> {

}
