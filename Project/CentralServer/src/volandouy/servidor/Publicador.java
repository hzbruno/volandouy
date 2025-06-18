/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package volandouy.servidor;
import volandouy.datatypes.DtFecha;
import volandouy.datatypes.DtHora;
import volandouy.datatypes.EnumAsiento;
import volandouy.datatypes.EnumDocumento;
import volandouy.datatypes.EnumEstado;
import volandouy.excepciones.SetException;
import volandouy.logica.*;
import volandouy.dto.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.HashMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.ParameterStyle;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.xml.ws.Endpoint;



@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class Publicador {
	IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();
    IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();
    
    private Endpoint endpoint = null;
    //Constructor
    public Publicador(){}
    

    @WebMethod(exclude = true)
    public void publicar(){
    	
    	Properties properties = new Properties();
    	
    	try (FileInputStream input = new FileInputStream(System.getProperty("user.home")+ File.separator + "volandouy" + File.separator +  "config.properties")) {
            properties.load(input);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
    	
    	
        endpoint = Endpoint.publish(properties.getProperty("url"), this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
    
    
    @WebMethod
    public String altaRutaDeVuelo(String aerolinea,  String nombre,  String descripcion,  DtHora hora,  
    String costoBaseTurista,  String costoBaseEjecutivo,  String costoEquipajeExtra,  
    String Origen,  String Destino,  DtFecha fechaAlta, CategoriasArrayDto categorias, String descripcionCorta){
    	IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();
    	List<String> categories = categorias.getCategorias();
    	try {
    		controladorVuelos.altaRutaDeVuelo(aerolinea, nombre, descripcion, hora,  
    				costoBaseTurista, costoBaseEjecutivo, costoEquipajeExtra,  
    				Origen, Destino, fechaAlta, categories, descripcionCorta);
            return "";

    	}
    	catch(SetException err){
    		 String mensajeError = "Se encontraron errores: \n";
             for (String mErr : err.getErrorSet()) {
                 mensajeError+=mErr +"\n";
             }
             return mensajeError;
    	}
    }
    
    @WebMethod
    public String altaVuelo(String RutaDeVuelo,  String nombre,  DtFecha fecha ,  DtHora duracion ,  String CantMaxT,  String CantMaxE,  DtFecha fechaAlta) {
    	IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();
    	try {
    		controladorVuelos.altaVuelo( RutaDeVuelo, nombre, fecha , duracion , CantMaxT, CantMaxE, fechaAlta);
            return "";
    		
    	}
    	catch(SetException err){
    		 String mensajeError = "Se encontraron errores: \n";
             for (String mErr : err.getErrorSet()) {
                 mensajeError+=mErr +"\n";
             }
             return mensajeError;
    	}
    }
    @WebMethod
    public String altaPaquete(String nombre, String descripcion,  String validez ,  String descuento,  DtFecha fechaActual) {
    	IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();
    	try {
    		controladorVuelos.altaPaquete( nombre,  descripcion,   validez ,   descuento,   fechaActual);
            return "";
    		
    	}
    	catch(SetException err){
    		 String mensajeError = "Se encontraron errores: \n";
             for (String mErr : err.getErrorSet()) {
                 mensajeError+=mErr +"\n";
             }
             return mensajeError;
    	}
    }
    @WebMethod
    public String altaCompraPaquete(String nombrePaquete,  String nicknameCliente , DtFecha fechaCompra) {
    	IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();
    	try {
    		controladorVuelos.altaCompraPaquete( nombrePaquete,   nicknameCliente ,  fechaCompra);
            return "";
    		
    	}
    	catch(SetException err){
    		 String mensajeError = "Se encontraron errores: \n";
             for (String mErr : err.getErrorSet()) {
                 mensajeError+=mErr +"\n";
             }
             return mensajeError;
    	}
    }
    
    @WebMethod
    public String altaReserva(String cliente,  String vuelo,  EnumAsiento tipoAsiento,  int equipajeExtra,  int pasajes, DtFecha fechaActual, String paqueteUsado ,PersonasArrayDto personas) {
    	
    	IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();
    	IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();
    	Cliente cli = controladorUsuarios.getCliente(cliente);
    	Map<String, String> mapPersonas = new HashMap<>();
    	
    	for(Pasaje p : personas.getPasaje()) {
    		mapPersonas.put(p.getNombre(), p.getApellido());
    	}
    	boolean paqComprado=false;
    	if(!paqueteUsado.equals("")) {
    		paqComprado=true;
    		
    	}

    	try {
    		controladorVuelos.altaReserva(cliente, vuelo, tipoAsiento, equipajeExtra, pasajes, fechaActual, paqComprado, mapPersonas);
            return "";

    	}
    	catch(SetException err){
    		 String mensajeError = "Se encontraron errores: \n";
             for (String mErr : err.getErrorSet()) {
                 mensajeError+=mErr +"\n";
             }
             return mensajeError;
    	}
    	
    }
     
    @WebMethod
    public PaisArrayDto getPaises(){
    	IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();
    	Map<String, Map <String,Ciudad>> ciudadPaisMap = controladorVuelos.getCiudadesPais();
    	ArrayList<String> paises = new ArrayList<>();
    	
    	for(Map.Entry<String, Map<String, Ciudad>> cp : ciudadPaisMap.entrySet()) {

	    	paises.add(cp.getKey());
    	}
    	PaisArrayDto paisesCiudad = new PaisArrayDto();
    	paisesCiudad.setPaises(paises);
        return paisesCiudad;
    }
    
    @WebMethod
    public PaisDto getCiudadesPais(String pais){
    	IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();
    	Map<String, Map <String,Ciudad>> ciudadPaisMap = controladorVuelos.getCiudadesPais();
    	ArrayList<Ciudad> ciudades = new ArrayList<>();    	
    	
		for(Map.Entry<String, Ciudad> c : ciudadPaisMap.get(pais).entrySet()) {
	    	ciudades.add(c.getValue());
		}
		PaisDto paisArr = new PaisDto(pais);
		paisArr.setCiudadesPais(ciudades);    	
        return paisArr;
    }
    
    
    
    @WebMethod
    public CategoriasArrayDto getCategorias(){
    	IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();
    	ArrayList<String> listCategorias = (ArrayList)controladorVuelos.getCategorias();
    	CategoriasArrayDto categorias = new CategoriasArrayDto(listCategorias);
    	return categorias;
    }
    
    @WebMethod
    public PaqueteDto getPaquete(String nombre){
    	IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();
    	PaqueteDto p =new PaqueteDto();
    	p.setPaquete(controladorVuelos.getPaquete(nombre));
    	return p;
    }
    
    @WebMethod
    public PaqueteArrayDto getPaquetes(){
    	IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();

    	ArrayList<Paquete> paquetes = new ArrayList<>();
    	
    	for(Map.Entry<String, Paquete> p : controladorVuelos.getPaquetes().entrySet()) {
    		paquetes.add(p.getValue());
    	}

    	PaqueteArrayDto paq = new PaqueteArrayDto();
    	paq.setPaquetes(paquetes);
    	return paq;
    }
    @WebMethod
    public RutaDeVueloDto getRutaDeVuelo(String nombre){
    	IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();
    	RutaDeVueloDto r = new RutaDeVueloDto();
    	r.setRutaDeVuelo(controladorVuelos.getRutaDeVuelo( nombre));
    	return r;
    }
    
    @WebMethod
    public VueloDto getVuelo(String nombre) {
    	IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();
    	VueloDto v = new VueloDto();
    	v.setVuelo(controladorVuelos.getVuelo( nombre));
    	return v;
    }
    
    
    @WebMethod
    public RutaArrayDto getRutasDeVuelo(String nickname) {
    	IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();
        //RutaArrayDto rutasArray = new RutaArrayDto(controladorVuelos.getRutasDeVuelo( nickname));
        ArrayList<RutaDeVuelo> rutas = new ArrayList<>();
    	
    	for(Entry r : controladorVuelos.getRutasDeVuelo( nickname).entrySet()) {

    		rutas.add((RutaDeVuelo)r.getValue());
    	}
    	
        RutaArrayDto rutasArray = new RutaArrayDto();
        rutasArray.setRutas(rutas);
      	return rutasArray;
    }
    
    @WebMethod
    public RutaArrayDto getAllRutasDeVuelo() {
    	IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();
    	ArrayList<RutaDeVuelo> rutas = new ArrayList<>();
    	
    	for(Entry r : controladorVuelos.getAllRutasDeVuelo().entrySet()) {

    		rutas.add((RutaDeVuelo)r.getValue());
    	}
    	
        RutaArrayDto rutasArray = new RutaArrayDto();
		rutasArray.setRutas(rutas);
      	return rutasArray;
    }
    

    @WebMethod
    public AerolineaDto getAerolinea(String nombre) {
    	IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();
    	AerolineaDto a = new AerolineaDto();
    	a.setAerolinea(controladorUsuarios.getAerolinea(nombre));
    	return a;
    } 
    
    @WebMethod
    public ClienteDto getCliente(String nombre) {
    	IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();
		ClienteDto c = new ClienteDto();
		c.setCliente(controladorUsuarios.getCliente(nombre));
    	return c;
    } 
    
    @WebMethod
    public UsuarioDto getUsuario(String nickname) {
    	IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();
    	UsuarioDto u = new UsuarioDto();
    	u.setUsuario(controladorUsuarios.getUsuario( nickname));
    	
    	return u;
    }
    
    @WebMethod
    public AerolineasArrayDto getAerolineas(){
    	IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();	
    	ArrayList<Aerolinea> aerolineas = new ArrayList<>();
    	
    	for(Map.Entry<String, Aerolinea> u : controladorUsuarios.getAerolineas().entrySet()) {
    		aerolineas.add(u.getValue());
    	}	
    	AerolineasArrayDto aer  = new AerolineasArrayDto();
    	aer.setAerolineas(aerolineas);
    	return aer;
    }
    
    @WebMethod
    public UsuarioArrayDto getUsuarios(){
    	IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();	
    	ArrayList<Usuario> usuarios = new ArrayList<>();
    	
    	for(Map.Entry<String, Usuario> u : controladorUsuarios.getUsuarios().entrySet()) {
    		usuarios.add(u.getValue());
    	}	
      	UsuarioArrayDto usr  = new UsuarioArrayDto();
      	usr.setUsuarios(usuarios);
    	return usr;
    }
    
    @WebMethod
    public String altaCliente(String nickname, String nombre, String correo, String apellido, String contrasenia, DtFecha fechaDeNacimiento, String nacionalidad, EnumDocumento tipoDocumento, String numeroDocumento) {
    	IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();
    	try {
    		controladorUsuarios.altaCliente(nickname, nombre, correo, apellido, contrasenia, fechaDeNacimiento, nacionalidad, tipoDocumento, numeroDocumento);
            return "";

    	}
    	catch(SetException err){
    		 String mensajeError = "Se encontraron errores: \n";
             for (String mErr : err.getErrorSet()) {
                 mensajeError+=mErr +"\n";
             }
             return mensajeError;
    	}
    }
    @WebMethod
    public String altaAerolinea(String nickname, String nombre, String correo, String contrasenia, String descripcionGeneral, String paginaWeb){
    	IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();
    	try {
    		controladorUsuarios.altaAerolinea(nickname, nombre, correo, contrasenia, descripcionGeneral, paginaWeb);
    		return "";
    	}
    	catch(SetException err){
    		 String mensajeError = "Se encontraron errores: \n";
             for (String mErr : err.getErrorSet()) {
                 mensajeError+=mErr +"\n";
             }
             return mensajeError;
    	}
    }
    @WebMethod
    public String modificarAerolinea(String nickname, String nombre, String contrasenia, String sitioWeb, String descripcion){
    	IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();
    	try {
    		controladorUsuarios.modificarAerolinea(nickname, nombre, contrasenia, sitioWeb, descripcion);
    		return "";
    	}
    	catch(SetException err){
    		 String mensajeError = "Se encontraron errores: \n";
             for (String mErr : err.getErrorSet()) {
                 mensajeError+=mErr +"\n";
             }
             return mensajeError;
    	}
    }
    @WebMethod
    public String modificarCliente(String nickname, String nombre, String contrasenia, String apellido, DtFecha fechaDeNacimiento, String nacionalidad, EnumDocumento tipoDocumento, String numeroDocumento){
    	IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();
    	try {
    		controladorUsuarios.modificarCliente(nickname, nombre, contrasenia, apellido, fechaDeNacimiento, nacionalidad, tipoDocumento, numeroDocumento);
    		return "";
    	}
    	catch(SetException err){
    		 String mensajeError = "Se encontraron errores: \n";
             for (String mErr : err.getErrorSet()) {
                 mensajeError+=mErr +"\n";
             }
             return mensajeError;
    	}
    }
    
    @WebMethod
    public DtFecha getFecha(int dia, int mes , int anio){
    	DtFecha f = new DtFecha();
    	f.setAnio(anio);
    	f.setMes(mes);
    	f.setDia(dia);
    	return f;
    }
    
    @WebMethod
    public DtHora getHora(int hora, int minuto){
    	DtHora h = new DtHora();
    	h.setHora(hora);
    	h.setMinuto(minuto);
    	return h;
    }
    
    @WebMethod
    public PaquetesRutaArrayDto getPaquetesRuta(String nombrePaquete){

    	IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();
    	Paquete paq = controladorVuelos.getPaquete(nombrePaquete);
    	ArrayList<PaqueteRuta> paqRut = new ArrayList<>();
    	for(PaqueteRuta p:paq.getPaquetesRuta()) {
    		paqRut.add(p);
    		
    	}
    	PaquetesRutaArrayDto p = new PaquetesRutaArrayDto(paqRut);
    	p.setPaquetesRuta(paqRut);
    	return p;
    }
    
    @WebMethod
    public RutaArrayDto getRutasDeVueloAceptadasAerolinea(String Aerolinea){
    	IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();
    	Aerolinea aer = controladorUsuarios.getAerolinea(Aerolinea);
    	ArrayList<RutaDeVuelo> rutas = new ArrayList<>();
    	for(Entry e:aer.getRutasDeVueloAceptadas().entrySet()) {
    		rutas.add((RutaDeVuelo)e.getValue());
    	}
    	RutaArrayDto r = new RutaArrayDto();
		r.setRutas(rutas);
    	return r;
    }
    @WebMethod
    public RutaArrayDto getRutasDeVueloIngresadasRechazadasAerolinea(String Aerolinea){
    	IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();
    	Aerolinea aer = controladorUsuarios.getAerolinea(Aerolinea);
    	ArrayList<RutaDeVuelo> rutas = new ArrayList<>();
    	for(Entry e:aer.getRutasDeVuelo().entrySet()) {
    		RutaDeVuelo r = (RutaDeVuelo)e.getValue();
    		if (r.getEstado() == EnumEstado.INGRESADA || r.getEstado() == EnumEstado.RECHAZADA ) {
    			rutas.add(r);
			 }
    	}
    	RutaArrayDto r =new RutaArrayDto(rutas);
    	return r;
    }
    @WebMethod
    public VueloArrayDto getVuelosRuta(String Ruta){
    	IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();
    	RutaDeVuelo ruta = controladorVuelos.getRutaDeVuelo(Ruta);
    	ArrayList<Vuelo> vuelos = new ArrayList<>();
    	for(Entry e:ruta.getVuelos().entrySet()) {
    		vuelos.add((Vuelo)e.getValue());
    	}
    	VueloArrayDto v =new VueloArrayDto();
    	v.setVuelo(vuelos);
    	return v;
    }
    
    @WebMethod
    public ReservasArrayDto getReservasVuelo(String Vuelo){
    	IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();
    	Vuelo vuelo = controladorVuelos.getVuelo(Vuelo);
    	ReservasArrayDto r = new ReservasArrayDto();
    	r.setReservas((ArrayList)vuelo.getReservas());
    	return r;
    }
    @WebMethod
    public ComprasPaqueteArrayDto getComprasDePaquetesCliente(String Cliente){
    	IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();
    	Cliente cliente = controladorUsuarios.getCliente(Cliente);
    	ComprasPaqueteArrayDto c = new ComprasPaqueteArrayDto();
    	c.setComprasPaquete((ArrayList)cliente.getComprasDePaquetes());
    	return c;
    }
    
    @WebMethod
    public int getCpRestantesRuta(String clienteLog,String paqueteComp,String ruta){
    	IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();
    	Cliente cliente = controladorUsuarios.getCliente(clienteLog);
    	for(CompraPaquete comP: cliente.getComprasDePaquetes()) {
    		if(comP.getPaquete().equals(paqueteComp) && comP.getRestantes().get(ruta)!= null) {
    			return comP.getRestantes().get(ruta);
    		}
    	}
    	return 0;
    }
    
    @WebMethod
    public int compararFechas(DtFecha f1 ,DtFecha f2){
    	return f1.compararFechas(f2);
    }
    
    @WebMethod
    public DtFecha getFechaActual(){
    	return new DtFecha();
    }
    
    @WebMethod
    public int rutaDeAerolinea(String aer, String ruta){
    	IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();
    	IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();
    	Aerolinea aerolinea = controladorUsuarios.getAerolinea(aer);
    	RutaDeVuelo rutaDeVuelo = controladorVuelos.getRutaDeVuelo(ruta);
        if(aerolinea.getRutaDeVuelo(ruta) != null && rutaDeVuelo.getEstado() == EnumEstado.CONFIRMADA) {
        	return 1;
        }

    	return 0;
    }
    
    @WebMethod
    public ReservasArrayDto getReservasCliente(String cli){
    	IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();
    	Cliente cliente = controladorUsuarios.getCliente(cli);
		ReservasArrayDto resv = new ReservasArrayDto();
		resv.setReservas((ArrayList) cliente.getReservas());
    	return resv;
    }
    @WebMethod
    public void finalizarRuta(String ruta){
    	IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();
		controladorVuelos.finalizarRuta(ruta);
    }

    @WebMethod
    public boolean noTieneVuelosVigentes(String ruta){
    	IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();
    	RutaDeVuelo r = controladorVuelos.getRutaDeVuelo(ruta);
    	return r.noTieneVuelosVigentes();
    }
    @WebMethod
    public boolean estaRutaEnAlgunPaquete(String ruta){
    	IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();
    	return controladorVuelos.estaRutaEnAlgunPaquete(ruta);
    }
    
    @WebMethod
    public void realizarCheckIn(String cliente,String vuelo){
		IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();
		controladorVuelos.realizarCheckIn(cliente, vuelo);
	}
    
    @WebMethod
    public boolean sigueAUsuario(String usr,String seg) {
    	IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();
    	return controladorUsuarios.sigueAUsuario(usr, seg);
    }
    
    @WebMethod
    public void seguirAUsuario(String usr,String seg) {
    	IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();
    	 controladorUsuarios.seguirAUsuario(usr, seg);
    }
    
    @WebMethod
    public void dejarDeSeguir(String usr,String seg) {
    	IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();
    	 controladorUsuarios.dejarDeSeguir(usr, seg);
    }

	@WebMethod
    public ImagenesDto getFiles() throws  IOException {
    	IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();
    	IControladorVuelos controladorVuelos = Fabrica.getControladorVuelos();

		ArrayList<ImagenDto> arrayImg = new ArrayList<>();
		
		for(String usuario :controladorUsuarios.getUsuarios().keySet()) {
	        byte[] byteArray = null;

			try {
	            File f = new File(System.getProperty("user.dir") + File.separator + "images"+ File.separator + "datos" + File.separator + "usuarios" + File.separator + usuario +".jpg");
	            if(f.exists()) {
	            	FileInputStream imagen = new FileInputStream(f);
	            	byteArray = new byte[imagen.available()];
	            	imagen.read(byteArray);
	            	arrayImg.add(new ImagenDto("usuarios",usuario,byteArray));
	            }else {
	            	System.out.println("No existe el archivo de "+usuario);
	            }
	        } catch (IOException e) {
	                throw e;
	        }
		}
		for(String ruta :controladorVuelos.getAllRutasDeVuelo().keySet()) {
	        byte[] byteArray = null;

			try {
	            File f = new File(System.getProperty("user.dir") + File.separator + "images"+ File.separator + "datos" + File.separator + "rutas" + File.separator + ruta+".jpg");
	            if(f.exists()) {
		            FileInputStream imagen = new FileInputStream(f);
		            byteArray = new byte[imagen.available()];
		            imagen.read(byteArray);
		            arrayImg.add(new ImagenDto("rutas",ruta,byteArray));
	            }else {
	            	System.out.println("No existe el archivo de "+ruta);
	            }
	        } catch (IOException e) {
	                throw e;
	        }
		}
		for(String vuelo :controladorVuelos.getVuelos().keySet()) {
	        byte[] byteArray = null;

			try {
	            File f = new File(System.getProperty("user.dir") + File.separator + "images"+ File.separator + "datos" + File.separator + "vuelos" + File.separator + vuelo+".jpg");
	            if(f.exists()) {
	            FileInputStream imagen = new FileInputStream(f);
	            byteArray = new byte[imagen.available()];
	            imagen.read(byteArray);
	            arrayImg.add(new ImagenDto("vuelos",vuelo,byteArray));
	            }else {
	            	System.out.println("No existe el archivo de "+vuelo);
	            }
	        } catch (IOException e) {
	                throw e;
	        }
		}
		for(String paquete :controladorVuelos.getPaquetes().keySet()) {
	        byte[] byteArray = null;

			try {
	            File f = new File(System.getProperty("user.dir") + File.separator + "images"+ File.separator + "datos" + File.separator + "paquetes" + File.separator + paquete+".jpg");
	            if(f.exists()) {

	            FileInputStream imagen = new FileInputStream(f);
	            byteArray = new byte[imagen.available()];
	            imagen.read(byteArray);
	            arrayImg.add(new ImagenDto("paquetes",paquete,byteArray));
	            }else {
	            	System.out.println("No existe el archivo de "+paquete);
	            }
			} catch (IOException e) {
	                throw e;
	        }
		}
		
		return new ImagenesDto(arrayImg);

    }
    
    
	
	@WebMethod
    public void setImagen(String tipo,String nombre, byte[] img) throws  IOException {
		String rutaImagenes = System.getProperty("user.dir") + File.separator + "images"+ File.separator + "datos" + File.separator + tipo;
		File archivoImagen = new File(rutaImagenes + File.separator + nombre + ".jpg");
		try (FileOutputStream fos = new FileOutputStream(archivoImagen)) {
            fos.write(img);
        } catch (IOException e) {
        }
		
    }
    
 
 
    
}
