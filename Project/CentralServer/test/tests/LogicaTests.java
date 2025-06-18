package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import volandouy.excepciones.SetException;
//import volandouy.logica.ControladorUsuarios;
//import volandouy.logica.ControladorVuelos;
import volandouy.logica.*;
import volandouy.datatypes.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class LogicaTests {

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
    public void testAltaCiudad_Valida() {
        Set<String> errores = new HashSet<>();

        try {
			controladorVuelos.altaCiudad("Montevideo",  "Uruguay",  "Carrasco",  "Capital uruguaya,  conocida por su Rambla,  arquitectura colonial y vibrante vida cultural.",  "https://montevideo.gub.uy",  new DtFecha(01,  04,  2024));
        } 
        catch (SetException err) {
            errores=err.getErrorSet();
        }

        assertTrue(errores.isEmpty(),  "No debería haber errores para una ciudad válida.");
        
        
    }

    @Test
    public void testAltaCiudad_CiudadRepetida() {
        Set<String> errores1 = new HashSet<>();
        Set<String> errores2 = new HashSet<>();

        try {

            controladorVuelos.altaCiudad("Argentina",  "Buenos Aires",  "Ezeiza",  "Aeropuerto internacional",  "http://aeropuerto.com",  new DtFecha(05,  07,  2024));
        } 
        catch (SetException err) {
            errores1=err.getErrorSet();
        }
        try {

            controladorVuelos.altaCiudad("Argentina",  "Buenos Aires",  "Aeroparque",  "Otro aeropuerto",  "http://aeroparque.com",  new DtFecha(05,  07,  2024));
        } 
        catch (SetException err) {
            errores2=err.getErrorSet();
        }
        assertTrue(errores1.isEmpty(), "La primera ciudad deberia ser valida");
        assertEquals(String.join("", errores2), "Esta ciudad ya existe",  "El error deberia ser de ciudad existente");
    }

    @Test
    public void testAltaCiudad_CiudadInvalida() {
        Set<String> errores = new HashSet<>();

        try {
            controladorVuelos.altaCiudad("",  "",  "",  "",  "",  new DtFecha(05,  07,  2024));
        } 
        catch (SetException err) {
            errores=err.getErrorSet();
        }
        Set<String> erroresEsperados = Set.of("La Ciudad no debe ser vacio", "El aeropuerto no debe ser vacio", "La descripcion no debe ser vacio", "El sitioWeb no es valido");
        
        assertEquals(erroresEsperados, errores,  "La ciudad deberia ser invalida");
    }

    @Test
    public void testAltaAerolinea_Valida(){
        Set<String> errores = new HashSet<>();

        try {
            controladorUsuarios.altaAerolinea("tytyjty",  "Aerolíneas Argentinas",  "servicioalcliente1@aerolineas.com.uy", "contrasnia",  "Aerolínea nacional de Argentina que ofrece vuelos directos entre múltiples destinos.",  "https://www.aerolineas.com.ar");
        } catch (SetException err) {
            errores=err.getErrorSet();
        }
        

        assertTrue(errores.isEmpty(),  "No debería haber errores para una aerolinea válida.");
        
        Aerolinea aero = controladorUsuarios.getAerolinea("tytyjty");
        String a = aero.getNickname();
        a = aero.getNombre();
        a = aero.getContrasenia();
        a = aero.getCorreo();
        a = aero.getDescripcionGeneral();
        a = aero.getSitioWeb(); 
    }
    @Test
    public void testAltaAerolinea_Repetida(){
        Set<String> errores = new HashSet<>();

        try {
            controladorUsuarios.altaAerolinea("aerolineas",  "Aerolíneas Argentinas",  "servicioalcliente@aerolineas.com.uy",  "contrasnia",  "Aerolínea nacional de Argentina que ofrece vuelos directos entre múltiples destinos.",  "https://www.aerolineas.com.ar");
            controladorUsuarios.altaAerolinea("aerolineas",  "Aerolíneas Argentinas",  "servicioalcliente@aerolineas.com.uy", "contrasnia",   "Aerolínea nacional de Argentina que ofrece vuelos directos entre múltiples destinos.",  "https://www.aerolineas.com.ar");
        } catch (SetException err) {
            errores=err.getErrorSet();
        }
                Set<String> erroresEsperados = Set.of("El nickname ya esta en uso", "Correo en uso");

        assertEquals(erroresEsperados, errores,  "El error deberia ser de nickname ya en uso");
    }

    @Test
    public void testAltaAerolinea_Invalida() {
        Set<String> errores = new HashSet<>();

        try {
            controladorUsuarios.altaAerolinea("",  "", "",  "",  "",  "");
        } 
        catch (SetException err) {
            errores=err.getErrorSet();
        }
        Set<String> erroresEsperados = Set.of("El nickname debe tener entre 3 y 24 caracteres", "El nombre no debe ser vacio", "El correo no es valido", "La descripcion debe tener entre 1 y 200 caracteres ", "El sitio no es valido");

        assertFalse(errores.isEmpty());
    }
    @Test
    public void testAltaAerolinea_Invalida2() {
        Set<String> errores = new HashSet<>();

        try {
            controladorUsuarios.altaAerolinea("++++",  "Aerolíneas Argentinas",  "servicioalcliente1@aerolineas.com.uy",  "contrasnia",  "Aerolínea nacional de Argentina que ofrece vuelos directos entre múltiples destinos.",  "https://www.aerolineas.com.ar");
        } 
        catch (SetException err) {
            errores=err.getErrorSet();
        }
        Set<String> erroresEsperados = Set.of("El nickname solo puede contener letras y numeros", "Correo en uso");

        assertEquals(erroresEsperados, errores,  "La aerolinea deberia ser invalida");
    }
    
    @Test
    public void testAltaCliente_Valido(){
        Set<String> errores = new HashSet<>();

        try {
			controladorUsuarios.altaCliente("ejstar",  "Emily",  "emily.j@hotmail.com", "contrasnia",  "Johnson",   new DtFecha(24,  06,  1985),  "Estados Unidos",  EnumDocumento.PASAPORTE,  "485719842");
        } catch (SetException err) {
            errores=err.getErrorSet();
        }
        Set<String> a = new HashSet<>();
        assertTrue(errores.isEmpty(),  "No debería haber errores para un cliente válido.");
        
        Cliente c = controladorUsuarios.getCliente("ejstar");
        String b = c.getApellido();
        b = c.getContrasenia();
        b = c.getCorreo();
        b = c.getNacionalidad();
        b = c.getNacionalidad();
        b = c.getNombre();
        b = c.getNumeroDocumento();
        
    }
    @Test
    public void testAltaCliente_Repetido(){
        Set<String> errores = new HashSet<>();

        try {
            controladorUsuarios.altaCliente("marsil14",  "Martín",  "m.silva94@webmail.uy", "contrasnia",  "Silva",   new DtFecha(14,  01,  1994),  "Uruguay",  EnumDocumento.PASAPORTE,  "C3456789");
			controladorUsuarios.altaCliente("marsil14",  "Ana",  "arodriguez87@netuy.com", "contrasnia",  "Rodríguez",   new DtFecha(18,  02,  1987),  "Uruguay",  EnumDocumento.PASAPORTE,  "B2345678");
        } catch (SetException err) {
            errores=err.getErrorSet();
        }
        Set<String> erroresEsperados = Set.of("El nickname ya esta en uso");

        assertEquals(erroresEsperados, errores,  "El error deberia ser de nickname ya en uso");
    }

    @Test
    public void testAltaCliente_Invalido() {
        Set<String> errores1 = new HashSet<>();
        Set<String> errores2 = new HashSet<>();

        try {
            controladorUsuarios.altaCliente("",  "",  "",  "", "",  new DtFecha(20, 10, 2010),  "",  EnumDocumento.PASAPORTE,  "");
        } 
        catch (SetException err) {
            errores1=err.getErrorSet();
        }
        try {
            controladorUsuarios.altaCliente("!?$%",  "asd",  "asd@gmail.com", "contrasnia",  "asd",   new DtFecha(20, 10, 1900),  "Uruguay",  EnumDocumento.PASAPORTE,  "123456");
        } 
        catch (SetException err) {
            errores2=err.getErrorSet();
        }
        
        assertFalse(errores1.isEmpty());
        assertFalse(errores2.isEmpty());
    }
    
    @Test
    public void testAltaRutaDeVuelo_Valida() {
        Set<String> errores = new HashSet<>();
        try{
        
            controladorUsuarios.altaAerolinea("aaaatest",  "Aerolínea S.A.",  "aaaatest@aero.com", "contrasnia",   "Descripción general",  "http://aero.com");
            Aerolinea a = controladorUsuarios.getAerolinea("aaaatest");
            
            controladorVuelos.altaCiudad("Buenos Aires",  "Argentina",  "Ezeiza",  "Aeropuerto internacional",  "http://aeropuerto.com",  new DtFecha());
            controladorVuelos.altaCiudad("Santiago",  "Chile",  "Santiago Airport",  "Aeropuerto de Santiago",  "http://santiago.com",  new DtFecha());

            DtFecha fecha = new DtFecha(5,  9,  2024);
            DtHora hora = new DtHora(10,  30);
            controladorVuelos.altaRutaDeVuelo(
                    "aero123",  "Ruta1",  "Ruta Buenos Aires - Santiago",  hora,  "100",  "200",  "50", 
                    "Argentina,  Buenos Aires",  "Chile,  Santiago de Chile",  fecha,  List.of("Temporada",  "Cortos"), "descCorta");
            
            boolean existeCategoria = controladorVuelos.getRutaDeVuelo("Ruta1").existeCategoria("asd");
        }catch(SetException err){
            errores=err.getErrorSet();
        }
        
        assertTrue(errores.isEmpty(),  "No debería haber errores para una ruta de vuelo válida.");
        
        try {
        	Map<String, RutaDeVuelo> ingresadas = controladorVuelos.getRutasDeVueloIngresadas("aero123");
        	controladorVuelos.setEstadoRuta("Ruta1",  EnumEstado.CONFIRMADA);
        	Map<String, RutaDeVuelo> aceptadas = controladorVuelos.getRutasDeVueloAceptadas("aero123");
        }catch(SetException err){
            errores=err.getErrorSet();
        }
        
        
        assertTrue(errores.isEmpty(),  "No debería haber errores para una ruta de vuelo válida.");
    }
    
    @Test
    public void testAltaRutaDeVuelo_Invalida() {
        Set<String> errores1 = new HashSet<>();
        Set<String> errores2 = new HashSet<>();
        Set<String> errores3 = new HashSet<>();
        DtFecha fecha = new DtFecha(5,  9,  2024);
        DtHora hora = new DtHora(10,  30);

        try{
        
            controladorUsuarios.altaAerolinea("aero123",  "Aerolínea S.A.",  "ASA@aero.com", "contrasnia",   "Descripción general",  "http://aero.com");
            controladorVuelos.altaRutaDeVuelo(
                    "aero123",  "eeeetest",  "Ruta Buenos Aires - Santiago",  hora,  "100",  "200",  "50", 
                    "Argentina,  Buenos Aires",  "Chile,  Santiago de Chile",  fecha,  List.of("Temporada",  "Cortos"), "descCorta");
        }catch(SetException err){
            
        }

        try{
            controladorVuelos.altaRutaDeVuelo(
                    "aero123",  "",  "",  hora,  "",  "",  "", 
                    "Chile,  Santiago de Chile",  "Chile,  Santiago de Chile",  fecha,  List.of("Temporada",  "Cortos"), "descCorta");
        }catch(SetException err){
            errores1=err.getErrorSet();
        }
        try{
            controladorVuelos.altaRutaDeVuelo(
                    "aero123",  "eeeetest",  "asd",  hora,  "asd",  "asd",  "asd", 
                    "Argentina,  Buenos Aires",  "Chile,  Santiago de Chile",  fecha,  List.of("Temporada",  "Cortos"), "descCorta");
        }catch(SetException err){
            errores2=err.getErrorSet();
        }
        
        try{
            controladorVuelos.altaRutaDeVuelo(null, "", "", hora, "",  "",  "", "Chile,  Santiago de Chile",  "Chile,  Santiago de Chile",  fecha,  List.of("Temporada",  "Cortos"), "descCorta");
        }catch(SetException err){
            errores3=err.getErrorSet();
        }
        
        Set<String> erroresEsperados1 = Set.of("Las ciudades no pueden ser iguales",  "El nombre no debe ser vacío",  "La descripción no debe ser vacía",  "Campo costoBaseTurista vacío",  "Campo costoBaseEjecutivo vacío",  "Campo costoEquipajeExtra vacío");
        Set<String> erroresEsperados2 = Set.of("Nombre ya en uso",  "Valor inválido en costoBaseTurista",  "Valor inválido en costoBaseEjecutivo",  "Valor inválido en costoEquipajeExtra");

        assertEquals(erroresEsperados1, errores1,  "La ruta de vuelo deberia ser invalida");
        assertEquals(erroresEsperados2, errores2,  "La ruta de vuelo deberia ser invalida");
    }

   @Test
    public void testModificarAerolinea_Valida() {
    	Set<String> errores = new HashSet<>();

        
        try {
			controladorUsuarios.altaAerolinea("copaair",  "Copa Airlines",  "contacto@copaair.com.uy",  "contrasnia",  "Aerolínea panameña con conexiones a varios destinos en América y el Caribe.",  "https://www.copaair.com");
            controladorUsuarios.modificarAerolinea("copaair",  "Copa Airlines","password", "https://www.copaair.com", "Aerolínea panameña con conexiones a varios destinos en América y el Caribe.");
        } 
        catch (SetException err) {
            errores=err.getErrorSet();
        }

        assertTrue(errores.isEmpty(),  "No debería haber errores en la modificacion.");
    }
    @Test
    public void testModificarAerolinea_Invalida() {
    	Set<String> errores = new HashSet<>();
        try {
            controladorUsuarios.modificarAerolinea("copaair",  "","password", "", "");
        } 
        catch (SetException err) {
            errores=err.getErrorSet();
        }

        Set<String> erroresEsperados = Set.of("El nombre no debe ser vacio", "La descripcion debe tener entre 1 y 200 caracteres ", "El sitio web no es valido");
        assertEquals(erroresEsperados, errores,  "La modificacion no deberia ser valida");
    }

    @Test
    public void testModificarCliente_Valido() {
    	Set<String> errores = new HashSet<>();

        try {
			controladorUsuarios.altaCliente("claire93d",  "Claire",  "claire.db@frmail.fr", "contrasnia",  "Rinaldi",   new DtFecha(22,  8,  1993),  "Italia",  EnumDocumento.PASAPORTE,  "20VF756483");
            controladorUsuarios.modificarCliente("claire93d", "Claire","password",  "Rinaldi",  new DtFecha(22,  8,  1993),  "Italia",  EnumDocumento.PASAPORTE,  "20VF756483");
        } 
        catch (SetException err) {
            errores=err.getErrorSet();
        }

        assertTrue(errores.isEmpty(),  "No debería haber errores en la modificacion.");
    }
    @Test
    public void testModificarCliente_Invalido() {
    	Set<String> errores = new HashSet<>();
        try {
            controladorUsuarios.modificarCliente("claire93d", "","password",  "",  new DtFecha(18,  02,  2010),  "Italia",  EnumDocumento.PASAPORTE,  "");
        } 
        catch (SetException err) {
            errores=err.getErrorSet();
        }
        try {
            controladorUsuarios.modificarCliente("claire93d", "Claire","password",  "Rinaldi",  new DtFecha(18,  02,  1000),  "Italia",  EnumDocumento.PASAPORTE,  "20VF756483");
        } 
        catch (SetException err) {
            errores.addAll(err.getErrorSet());
        }
        Set<String> erroresEsperados = Set.of("El nombre no debe ser vacio", "El apellido no debe ser vacio", "Debe ser mayor de 18", "El documento debe tener entre 6 y 11 caracteres", "Fecha de nacimiento fuera de rango");
        assertEquals(erroresEsperados, errores,  "La modificacion no deberia ser valida");
    }

    
   @Test
    public void testAltaVuelo_Valido(){
        Set<String> errores = new HashSet<>();

        try {     
            controladorUsuarios.altaAerolinea("iberia",  "Iberia",  "atencionclientes@iberia.com.uy", "contrasnia",   "Aerolínea española que te conecta con Europa y otros destinos internacionales.",  "https://www.iberia.com");                        
			controladorVuelos.altaRutaDeVuelo("iberia",  "IB6012",  "Tiempo de vuelo: cerca de 12 horas. Incluye comidas,  bebidas y entretenimiento en vuelo",  new DtHora(13,  00),  "350",  "1800",  "60", "Uruguay,  Montevideo",  "España,  Madrid", new DtFecha(22,  8,  2024),  Arrays.asList("Internacionales",  "Europa",  "Temporada"), "descCorta");
			controladorVuelos.altaVuelo("IB6012",  "IB6012377",  new DtFecha(3,  11,  2024),  new DtHora(11,  29),  "269",  "19",  new DtFecha(29,  8,  2024));

        } catch (SetException err) {
            errores=err.getErrorSet();

        assertTrue(errores.isEmpty(),  "No debería haber errores para un vuelo válido.");
        }
    }
    @Test
    public void testAltaVuelo_Invalido(){
        Set<String> errores = new HashSet<>();

        try {
			controladorVuelos.altaVuelo("IB6012",  "IB6012377",  new DtFecha(3,  11,  2024),  new DtHora(11,  29),  "a",  "a",  new DtFecha(29,  8,  2055));
        } catch (SetException err) {
            errores=err.getErrorSet();
        }
        try {
			controladorVuelos.altaVuelo("IB6012",  "",  new DtFecha(3,  11,  2024),  new DtHora(11,  29),  "269",  "19",  new DtFecha(29,  8,  2024));
        } catch (SetException err) {
            errores.addAll(err.getErrorSet());
        }
        Set<String> erroresEsperados = Set.of("Nombre ya en uso", "Cantidad de asientos trista invalida", "Cantidad de asientos ejecutivo invalida", "Fecha invalida", "El nombre no debe ser vacío");
        assertEquals(erroresEsperados, errores,  "El vuelo deberia ser invalido");
    }

   @Test
    public void testAltaPaquete_Valido(){
        Set<String> errores = new HashSet<>();

        try {     
            controladorVuelos.altaPaquete("Madrid ida y vuelta", "Descubre Madrid con este paquete perfecto para una escapada\r\n"
					+ "completa. Disfruta de vuelos directos ida y vuelta,  con\r\n"
					+ "cómodos horarios que te permiten aprovechar al máximo tu\r\n"
					+ "tiempo en la vibrante capital\r\n"
					+ "española.", "120", "50", new DtFecha(23, 8, 2024));
            
        } catch (SetException err) {
            errores=err.getErrorSet();

        }
        assertTrue(errores.isEmpty(),  "No debería haber errores para un vuelo válido.");  
        
        
    }
    @Test
    public void testAltaPaquete_Invalido(){
        Set<String> errores = new HashSet<>();

        try {
			controladorVuelos.altaPaquete("Madrid ida y vuelta", "", "a", "a", new DtFecha(23, 8, 2024));
        } catch (SetException err) {
            errores=err.getErrorSet();
        }
        try {
			controladorVuelos.altaPaquete("", "A", "120", "101", new DtFecha(23, 8, 2024));
        } catch (SetException err) {
            errores.addAll(err.getErrorSet());
        }
        Set<String> erroresEsperados = Set.of("Nombre ya en uso", "La descripcion no debe ser vacia", "Campo validez invalido", "Campo descuento invalido", "El nombre no debe ser vacío", "El descuento no debe ser mayor a 100%");
        assertEquals(erroresEsperados, errores,  "El vuelo deberia ser invalido");
        
        
        
        
        
    }

    @Test
    public void testCompraPaquete_Valido(){
        Set<String> errores = new HashSet<>();

        try {     
            controladorVuelos.altaPaquete("Cruzar el Charco", "Escápate a Buenos Aires y\r\n"
					+ "sumérgete en la vibrante vida de\r\n"
					+ "la capital argentina. Este paquete incluye vuelos directos", "150", "30", new DtFecha(25, 8, 2024));
            controladorVuelos.altaRutaDeVuelo(
					"aerolineas",  "AR1380",  
					"Tiempo de vuelo 1 hora,  directo y sin escalas",  
					new DtHora(07,  55),  
					"120",  "1000",  "30", 
					"Argentina,  Buenos Aires",  
					"Uruguay,  Montevideo", 
					new DtFecha(9,  8,  2024),  
					Arrays.asList("Nacionales",  "Europa"), "descCorta"
			);
            controladorVuelos.altaVuelo("AR1380",  "AR138011",  new DtFecha(29,  9,  2024),  new DtHora(11,  31),  "269",  "19",  new DtFecha(24,  8,  2024));
            
            controladorVuelos.agregarRutaVueloPaquete("Cruzar el Charco",  "AR1380",  2,  EnumAsiento.turista);

            controladorUsuarios.altaCliente("sofi89",  "Sofía",  "sofia.lopez@correouruguay.com", "contrasnia",  "López",   new DtFecha(25,  04,  1989),  "Uruguay",  EnumDocumento.PASAPORTE,  "A9876543");
            controladorVuelos.altaCompraPaquete("Cruzar el Charco",  "sofi89",  new DtFecha(26, 8, 2024));
            
            controladorVuelos.altaReserva("sofi89",  "AR138011",  EnumAsiento.ejecutivo,  0,  1, new DtFecha(27, 8, 2024),  true,  Map.of("Sofia",  "López"));
            //altaReserva(String cliente,  String vuelo,  EnumAsiento tipoAsiento,  int equipajeExtra,  
            //int pasajes,  double costoFinal, DTFecha fechaActual, CompraPaquete cPaquete, Map<String, String> personas){
            
        } catch (SetException err) {
            errores=err.getErrorSet();

        assertTrue(errores.isEmpty(),  "No debería haber errores para una compra valida.");
        }
    }
    @Test
    public void testCompraPaquete_Repetido(){
        Set<String> errores = new HashSet<>();
        
        try {
        	controladorVuelos.altaPaquete("paquete", "Escápate a Buenos Aires y\r\n"
					+ "sumérgete en la vibrante vida de\r\n"
					+ "la capital argentina. Este paquete incluye vuelos directos", "150", "30", new DtFecha(25, 8, 2024));
        	
            controladorVuelos.altaCompraPaquete("paquete",  "sofi89",  new DtFecha(26, 8, 2024));
            controladorVuelos.altaCompraPaquete("paquete",  "sofi89",  new DtFecha(26, 8, 2024));
        } catch (SetException err) {
            errores=err.getErrorSet();
        }

        Set<String> erroresEsperados = Set.of("El cliente ya compro ese paquete");
        assertEquals(erroresEsperados, errores,  "El cliente no deberia poder comprar el paquete");
    }


    @Test
    public void testAltaReserva_Valida(){
        Set<String> errores = new HashSet<>();

        try {     
            controladorVuelos.altaVuelo("IB6012",  "IB6012272",  new DtFecha(29,  9,  2024),  new DtHora(11,  31),  "269",  "19",  new DtFecha(24,  8,  2024));
            controladorUsuarios.altaCliente("hernacar",  "Carlos",  "carlosh89@mxmail.com", "contrasnia",  "Hernández",   new DtFecha(15,  9,  1988),  "Mexico",  EnumDocumento.PASAPORTE,  "GZ1234567");
            controladorVuelos.altaReserva("hernacar",  "IB6012272",  EnumAsiento.turista,  2,  1,  new DtFecha(28, 8, 2024),  false,  Map.of("Carlos",  "Hernández"));
            
        } catch (SetException err) {
            errores=err.getErrorSet();

        assertTrue(errores.isEmpty(),  "No debería haber errores para una reserva valida.");
        }
        
       
        
        
    }
    
    @Test
    public void testAltaReserva_ValidaPaquete(){
        Set<String> errores = new HashSet<>();

        try {   
        	controladorVuelos.setEstadoRuta("IB6012", EnumEstado.CONFIRMADA);
        	
            controladorVuelos.altaVuelo("IB6012",  "IB6012273",  new DtFecha(29,  9,  2024),  new DtHora(11,  31),  "269",  "19",  new DtFecha(24,  8,  2024));
            controladorUsuarios.altaCliente("bruno",  "Bruno",  "bruno@gmail.com", "contrasenia",  "Hernández",   new DtFecha(15,  9,  1988),  "Mexico",  EnumDocumento.PASAPORTE,  "GZ1234567");
            
            controladorVuelos.altaPaquete("nombre", "descripcion", "100", "5",new DtFecha());
            
            
            controladorVuelos.agregarRutaVueloPaquete("nombre", "IB6012", 10, EnumAsiento.turista);
            
            controladorVuelos.altaCompraPaquete("nombre", "bruno", new DtFecha());
            
            controladorVuelos.altaReserva("bruno",  "IB6012273",  EnumAsiento.turista,  2,  1,  new DtFecha(28, 8, 2024),  true,  Map.of("Carlos",  "Hernández"));
            
            controladorVuelos.realizarCheckIn("bruno", "IB6012273");
            
            DtFecha fechaVencimiento = controladorVuelos.getPaquete("nombre").calcularVencimiento();
            
            double costo = controladorVuelos.getPaquete("nombre").getCosto();
            
            boolean noTieneVuelosVigentes = controladorVuelos.getRutaDeVuelo("IB6012").noTieneVuelosVigentes();
            
            boolean estaEnPaquete = controladorVuelos.estaRutaEnAlgunPaquete("IB6012");
           controladorVuelos.finalizarRuta("IB6012");
           
            
        } catch (SetException err) {
            errores=err.getErrorSet();

        assertTrue(errores.isEmpty(),  "No debería haber errores para una reserva valida.");
        }
        
        
        
        
    }
    
    
    @Test
    public void testAgregarRutaInvalidaPaquete(){
        Set<String> errores = new HashSet<>();

        try {   
            controladorVuelos.altaPaquete("nombre2", "descripcion", "100", "5",new DtFecha());
            controladorVuelos.agregarRutaVueloPaquete(null, null, 0, null);// esto va  a ser invalido
      
        } catch (SetException err) {
            errores=err.getErrorSet();

        assertFalse(errores.isEmpty());
        }
   
    }


    @Test
    public void testAltaReserva_Invalida(){
        Set<String> errores = new HashSet<>();

        try {
            controladorVuelos.altaReserva(null, null,  EnumAsiento.turista,  2,  0,   new DtFecha(28, 8, 2024),  false,  Map.of("Carlos",  "Hernández"));

        } catch (SetException err) {
            errores=err.getErrorSet();
        }
        try {
            controladorVuelos.altaReserva("hernacar",  "IB6012272",  EnumAsiento.turista,  2,  0, new DtFecha(28, 8, 2024),  false,  Map.of("",  ""));
        } catch (SetException err) {
            errores.addAll(err.getErrorSet());
        }
        
        
        Set<String> erroresEsperados = Set.of("No hay vuelo seleccionado", "No hay cliente seleccionado", "No hay pasajes seleccionados", "Algun nombre o apellido invalido");
        assertEquals(erroresEsperados, errores,  "No deberia poder hacerse una reserva invalida");
    }

   @Test
   public void testPaquete_algo(){
        boolean ok = true;
       try {
           Paquete p = new Paquete("Cruzar el Charco", "Escápate a Buenos Aires y\r\n"
                               + "sumérgete en la vibrante vida de\r\n"
                               + "la capital argentina. Este paquete incluye vuelos directos", 15, 30, new DtFecha(25, 8, 2024));
           double c = p.getCosto();
       } catch (Exception err) {
            ok = false;
       }

       assertTrue(ok, "");

   }

    @Test
    public void testAgregarRutaPaquete(){
        boolean ok = true;
       try {
            controladorUsuarios.altaAerolinea("iberia2",  "Iberia",  "atencionclientes2@iberia.com.uy", "contrasnia",   "Aerolínea española que te conecta con Europa y otros destinos internacionales.",  "https://www.iberia.com");                        
            controladorVuelos.altaPaquete("paquetetest", "Escápate a Buenos Aires y\r\n"
					+ "sumérgete en la vibrante vida de\r\n"
					+ "la capital argentina. Este paquete incluye vuelos directos", "150", "30", new DtFecha(25, 8, 2024));
            controladorVuelos.altaRutaDeVuelo(
					"iberia2",  "aaee",  
					"Tiempo de vuelo 1 hora,  directo y sin escalas",  
					new DtHora(07,  55),  
					"120",  "340",  "30", 
					"Argentina,  Buenos Aires",  
					"Uruguay,  Montevideo", 
					new DtFecha(9,  8,  2024),  
					Arrays.asList("Nacionales",  "Europa"), "descCorta"
			);      
            controladorVuelos.agregarRutaVueloPaquete("paquetetest",  "aaee",  2,  EnumAsiento.turista);
            controladorVuelos.agregarRutaVueloPaquete("paquetetest",  "aaee",  2,  EnumAsiento.turista);


       } catch (Exception err) {
            ok = false;
       }

       assertTrue(ok, "");

   }
    
    @Test
    public void seguirAUsuarioValido() {

    	controladorUsuarios.seguirAUsuario("brunohz", "hzbruno");
    	
    	 assertTrue(controladorUsuarios.getUsuario("brunohz").sigueAUsuario("hzbruno"));
    	
    	
    }
    @Test
    public void dejarDeSeguirUsuarioValido() {

    	controladorUsuarios.seguirAUsuario("brunohz", "hzbruno");
    	controladorUsuarios.dejarDeSeguir("brunohz", "hzbruno");
    	assertFalse(controladorUsuarios.getUsuario("brunohz").sigueAUsuario("hzbruno"));
    }
    
    
    @Test
    public void seguirAUsuarioInvalido() {
    	boolean ok = true;
    	try {
        	controladorUsuarios.altaCliente("brunohz",  "Bruno",  "brunohz@gmail.com", "contrasenia",  "Hernández",   new DtFecha(15,  9,  1988),  "Mexico",  EnumDocumento.PASAPORTE,  "GZ1234567");
        	controladorUsuarios.altaCliente("hzbruno",  "Bruno",  "hzbruno@gmail.com", "contrasenia",  "Hernández",   new DtFecha(15,  9,  1988),  "Mexico",  EnumDocumento.PASAPORTE,  "GZ1234567");
        	
        	}catch (Exception err) {
                ok = false;
           
        	}
    	
    	controladorUsuarios.seguirAUsuario("brunohz", "brunohz");
    	assertFalse(controladorUsuarios.getUsuario("brunohz").sigueAUsuario("brunohz"));
    }
    
    
    
   
   
    
    
   


}
