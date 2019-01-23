/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.cliente.entity;

import business.direccion.entity.Barrio;
import business.direccion.entity.Zona;
import business.usuario.entity.Usuario;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ggauto
 */
public class ClienteTest {
    
    public ClienteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getIdCliente method, of class Cliente.
     */
    @Test
    public void testGetIdCliente() {
        System.out.println("getIdCliente");
        Cliente instance = new Cliente();
        Integer expResult = null;
        Integer result = instance.getIdCliente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class Cliente.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getApellido method, of class Cliente.
     */
    @Test
    public void testGetApellido() {
        System.out.println("getApellido");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getApellido();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNroDocumento method, of class Cliente.
     */
    @Test
    public void testGetNroDocumento() {
        System.out.println("getNroDocumento");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getNroDocumento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getObservaciones method, of class Cliente.
     */
    @Test
    public void testGetObservaciones() {
        System.out.println("getObservaciones");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getObservaciones();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSexo method, of class Cliente.
     */
    @Test
    public void testGetSexo() {
        System.out.println("getSexo");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getSexo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTelefono method, of class Cliente.
     */
    @Test
    public void testGetTelefono() {
        System.out.println("getTelefono");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getTelefono();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipoDocumento method, of class Cliente.
     */
    @Test
    public void testGetTipoDocumento() {
        System.out.println("getTipoDocumento");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getTipoDocumento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCelular method, of class Cliente.
     */
    @Test
    public void testGetCelular() {
        System.out.println("getCelular");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getCelular();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContrato method, of class Cliente.
     */
    @Test
    public void testGetContrato() {
        System.out.println("getContrato");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getContrato();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDireccion method, of class Cliente.
     */
    @Test
    public void testGetDireccion() {
        System.out.println("getDireccion");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getDireccion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstado method, of class Cliente.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.getEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaActualizacion method, of class Cliente.
     */
    @Test
    public void testGetFechaActualizacion() {
        System.out.println("getFechaActualizacion");
        Cliente instance = new Cliente();
        Date expResult = null;
        Date result = instance.getFechaActualizacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaRegistro method, of class Cliente.
     */
    @Test
    public void testGetFechaRegistro() {
        System.out.println("getFechaRegistro");
        Cliente instance = new Cliente();
        Date expResult = null;
        Date result = instance.getFechaRegistro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdBarrio method, of class Cliente.
     */
    @Test
    public void testGetIdBarrio() {
        System.out.println("getIdBarrio");
        Cliente instance = new Cliente();
        Barrio expResult = null;
        Barrio result = instance.getIdBarrio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdUsuarioActualizacion method, of class Cliente.
     */
    @Test
    public void testGetIdUsuarioActualizacion() {
        System.out.println("getIdUsuarioActualizacion");
        Cliente instance = new Cliente();
        Usuario expResult = null;
        Usuario result = instance.getIdUsuarioActualizacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdUsuarioRegistro method, of class Cliente.
     */
    @Test
    public void testGetIdUsuarioRegistro() {
        System.out.println("getIdUsuarioRegistro");
        Cliente instance = new Cliente();
        Usuario expResult = null;
        Usuario result = instance.getIdUsuarioRegistro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdZona method, of class Cliente.
     */
    @Test
    public void testGetIdZona() {
        System.out.println("getIdZona");
        Cliente instance = new Cliente();
        Zona expResult = null;
        Zona result = instance.getIdZona();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdCliente method, of class Cliente.
     */
    @Test
    public void testSetIdCliente() {
        System.out.println("setIdCliente");
        Integer idCliente = null;
        Cliente instance = new Cliente();
        instance.setIdCliente(idCliente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class Cliente.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        Cliente instance = new Cliente();
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setApellido method, of class Cliente.
     */
    @Test
    public void testSetApellido() {
        System.out.println("setApellido");
        String apellido = "";
        Cliente instance = new Cliente();
        instance.setApellido(apellido);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNroDocumento method, of class Cliente.
     */
    @Test
    public void testSetNroDocumento() {
        System.out.println("setNroDocumento");
        String nroDocumento = "";
        Cliente instance = new Cliente();
        instance.setNroDocumento(nroDocumento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setObservaciones method, of class Cliente.
     */
    @Test
    public void testSetObservaciones() {
        System.out.println("setObservaciones");
        String observaciones = "";
        Cliente instance = new Cliente();
        instance.setObservaciones(observaciones);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSexo method, of class Cliente.
     */
    @Test
    public void testSetSexo() {
        System.out.println("setSexo");
        String sexo = "";
        Cliente instance = new Cliente();
        instance.setSexo(sexo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTelefono method, of class Cliente.
     */
    @Test
    public void testSetTelefono() {
        System.out.println("setTelefono");
        String telefono = "";
        Cliente instance = new Cliente();
        instance.setTelefono(telefono);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTipoDocumento method, of class Cliente.
     */
    @Test
    public void testSetTipoDocumento() {
        System.out.println("setTipoDocumento");
        String tipoDocumento = "";
        Cliente instance = new Cliente();
        instance.setTipoDocumento(tipoDocumento);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCelular method, of class Cliente.
     */
    @Test
    public void testSetCelular() {
        System.out.println("setCelular");
        String celular = "";
        Cliente instance = new Cliente();
        instance.setCelular(celular);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setContrato method, of class Cliente.
     */
    @Test
    public void testSetContrato() {
        System.out.println("setContrato");
        String contrato = "";
        Cliente instance = new Cliente();
        instance.setContrato(contrato);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDireccion method, of class Cliente.
     */
    @Test
    public void testSetDireccion() {
        System.out.println("setDireccion");
        String direccion = "";
        Cliente instance = new Cliente();
        instance.setDireccion(direccion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class Cliente.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        String estado = "";
        Cliente instance = new Cliente();
        instance.setEstado(estado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaActualizacion method, of class Cliente.
     */
    @Test
    public void testSetFechaActualizacion() {
        System.out.println("setFechaActualizacion");
        Date fechaActualizacion = null;
        Cliente instance = new Cliente();
        instance.setFechaActualizacion(fechaActualizacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaRegistro method, of class Cliente.
     */
    @Test
    public void testSetFechaRegistro() {
        System.out.println("setFechaRegistro");
        Date fechaRegistro = null;
        Cliente instance = new Cliente();
        instance.setFechaRegistro(fechaRegistro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdBarrio method, of class Cliente.
     */
    @Test
    public void testSetIdBarrio() {
        System.out.println("setIdBarrio");
        Barrio idBarrio = null;
        Cliente instance = new Cliente();
        instance.setIdBarrio(idBarrio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdUsuarioActualizacion method, of class Cliente.
     */
    @Test
    public void testSetIdUsuarioActualizacion() {
        System.out.println("setIdUsuarioActualizacion");
        Usuario idUsuarioActualizacion = null;
        Cliente instance = new Cliente();
        instance.setIdUsuarioActualizacion(idUsuarioActualizacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdUsuarioRegistro method, of class Cliente.
     */
    @Test
    public void testSetIdUsuarioRegistro() {
        System.out.println("setIdUsuarioRegistro");
        Usuario idUsuarioRegistro = null;
        Cliente instance = new Cliente();
        instance.setIdUsuarioRegistro(idUsuarioRegistro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdZona method, of class Cliente.
     */
    @Test
    public void testSetIdZona() {
        System.out.println("setIdZona");
        Zona idZona = null;
        Cliente instance = new Cliente();
        instance.setIdZona(idZona);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Cliente.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Cliente instance = new Cliente();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of canEqual method, of class Cliente.
     */
    @Test
    public void testCanEqual() {
        System.out.println("canEqual");
        Object other = null;
        Cliente instance = new Cliente();
        boolean expResult = false;
        boolean result = instance.canEqual(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Cliente.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Cliente instance = new Cliente();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Cliente.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Cliente instance = new Cliente();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
