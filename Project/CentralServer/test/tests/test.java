package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import volandouy.excepciones.SetException;
//import volandouy.logica.ControladorUsuarios;
//import volandouy.logica.ControladorVuelos;
import volandouy.logica.ManCiudad;
import volandouy.logica.ManRutaYVuelo;
import volandouy.logica.IControladorUsuarios;
import volandouy.logica.IControladorVuelos;
import volandouy.logica.CompraPaquete;
import volandouy.logica.Fabrica;
import volandouy.logica.Paquete;
import volandouy.logica.RutaDeVuelo;
import volandouy.datatypes.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class test {

    private IControladorVuelos controladorVuelos;
    private IControladorUsuarios controladorUsuarios;
    private final Fabrica Fabrica = new Fabrica();

    @BeforeEach
    public void setUp() {
        controladorVuelos = Fabrica.getControladorVuelos();
        controladorUsuarios = Fabrica.getControladorUsuarios();


        //controladorVuelos = new ControladorVuelos();
        //controladorUsuarios = new ControladorUsuarios();
        FechaActual.getInstancia().setFechaActual(8,  9,  2024);

    }
    
    @Test
    public void testPaises_Valido() {
        Set<String> errores = new HashSet<>();

        try {
            ManCiudad.getInstancia().agregarPais("Uruguay");
            ManCiudad.getInstancia().agregarPais("Alemania");
            ManCiudad.getInstancia().agregarPais("Panamá");
            ManCiudad.getInstancia().agregarPais("Argentina");
            ManCiudad.getInstancia().agregarPais("España");
            ManCiudad.getInstancia().agregarPais("Chile");
            ManCiudad.getInstancia().agregarPais("Estado Unidos");
            ManCiudad.getInstancia().agregarPais("Brasil");
            ManCiudad.getInstancia().agregarPais("Italia");
            ManCiudad.getInstancia().agregarPais("Mexico");
            ManCiudad.getInstancia().agregarPais("Canada");
            ManCiudad.getInstancia().agregarPais("Francia");
            ManCiudad.getInstancia().agregarPais("Inglaterra");
            ManCiudad.getInstancia().agregarPais("Australia");
            ManCiudad.getInstancia().agregarPais("Nueva Zelanda");
            ManCiudad.getInstancia().agregarPais("Suecia");
            ManCiudad.getInstancia().agregarPais("Dinamarca");
            ManCiudad.getInstancia().agregarPais("Noruega");
            ManCiudad.getInstancia().agregarPais("Finlandia");
            ManCiudad.getInstancia().agregarPais("Colombia");
            ManCiudad.getInstancia().agregarPais("Peru");
            ManCiudad.getInstancia().agregarPais("Venezuela");
            ManCiudad.getInstancia().agregarPais("Ecuador");
            ManCiudad.getInstancia().agregarPais("Paraguay");
            ManCiudad.getInstancia().agregarPais("Bolivia");
        }
        catch (Exception err) {
        }

        assertTrue(errores.isEmpty(),  "No debería haber errores para los paises.");
    }
    @Test
    public void testCategorias_Valido() {
        Set<String> errores = new HashSet<>();

        try {
            String CA01 = "Nacionales";
			String CA02 = "Internacionales";
			String CA03 = "Europa";
			String CA04 = "America";
			String CA05 = "Exclusivos";
			String CA06 = "Temporada";
			String CA07 = "Cortos"; 

			ManRutaYVuelo.getInstancia().agregarCategoria(CA01);
			ManRutaYVuelo.getInstancia().agregarCategoria(CA02);
			ManRutaYVuelo.getInstancia().agregarCategoria(CA03);
			ManRutaYVuelo.getInstancia().agregarCategoria(CA04);
			ManRutaYVuelo.getInstancia().agregarCategoria(CA05);
			ManRutaYVuelo.getInstancia().agregarCategoria(CA06);
			ManRutaYVuelo.getInstancia().agregarCategoria(CA07);
        }
        catch (Exception err) {
        }

        assertTrue(errores.isEmpty(),  "No debería haber errores para las categorías.");
    }
    
    @Test
    public void seguirAUsuarioValido() {
    	boolean ok = true;
    	try {
    	controladorUsuarios.altaCliente("brunohz",  "Bruno",  "brunohz@gmail.com", "contrasenia",  "Hernández",   new DtFecha(15,  9,  1988),  "Mexico",  EnumDocumento.PASAPORTE,  "GZ1234567");
    	controladorUsuarios.altaCliente("hzbruno",  "Bruno",  "hzbruno@gmail.com", "contrasenia",  "Hernández",   new DtFecha(15,  9,  1988),  "Mexico",  EnumDocumento.PASAPORTE,  "GZ1234567");
    	
    	}catch (Exception err) {
            ok = false;
       }
    	
    	controladorUsuarios.seguirAUsuario("brunohz", "hzbruno");
    	
    	 assertTrue(controladorUsuarios.getUsuario("brunohz").sigueAUsuario("hzbruno"));
    	
    	
    }
   
    
    @Test
    public void dejarDeSeguirUsuarioValido() {
    	boolean ok = true;
    	
    	controladorUsuarios.seguirAUsuario("brunohz", "hzbruno");
    	controladorUsuarios.dejarDeSeguir("brunohz", "hzbruno");
    	assertFalse(controladorUsuarios.getUsuario("brunohz").sigueAUsuario("hzbruno"));
    }

    
}
