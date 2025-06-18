package volandouy.logica;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import volandouy.datatypes.DtFecha;
import volandouy.datatypes.DtHora;
import volandouy.datatypes.EnumEstado;
import volandouy.datatypes.EnumAsiento;
import volandouy.datatypes.Par;
import volandouy.excepciones.SetException;


public class ControladorVuelos implements  IControladorVuelos{
    
    @Override
    public void altaCiudad(String ciudad,  String pais,  String aeropuerto,  String descripcion,  String sitioWeb,  DtFecha fechaAlta) throws SetException {
        Set<String> errores = new HashSet<>();

        Par parPais = new Par(pais,  ciudad);
        
        if (pais == null) {
            errores.add("Seleccione un pais");
        }

        if (ManCiudad.getInstancia().getCiudad(parPais)!=null){
            errores.add("Esta ciudad ya existe");
        }else  if (ciudad.length()==0){
            errores.add("La Ciudad no debe ser vacio");
        }
       
        if (aeropuerto.length()==0){
            errores.add("El aeropuerto no debe ser vacio");
        }
     
        if (descripcion.length()==0){
            errores.add("La descripcion no debe ser vacio");
        }
      
        if (!sitioWeb.matches("^https?://[^\\s/$.?#].[^\\s]*\\.[a-z]{2,}(/.*)?$")){
            errores.add("El sitioWeb no es valido");
        }

        if (errores.isEmpty()) {
            Ciudad newCiudad= new Ciudad(ciudad,  pais,  aeropuerto,  descripcion,  sitioWeb,  fechaAlta);
            ManCiudad.getInstancia().agregarCiudad(newCiudad);
        }else {
            throw new SetException(errores);
        }

    }

    @Override
    public void altaRutaDeVuelo(String aerolinea,  String nombre,  String descripcion,  DtHora hora,  
                                             String costoBaseTurista,  String costoBaseEjecutivo,  String costoEquipajeExtra,  
                                              String Origen,  String Destino,  DtFecha fechaAlta, List<String> cats, String descripcionCorta) throws SetException {
        Set<String> errores = new HashSet<>();
            
        if (Origen.equals(Destino)) {
            errores.add("Las ciudades no pueden ser iguales");
        }
        
        if (aerolinea == null) {
            errores.add("Selecciona una aerolinea");

        }
        
        if (Origen == null || Destino == null) {
            errores.add("Debe seleccionar un origen y un destino");
        }
        if (cats.size() == 0) {
        	errores.add("No hay categorias seleccionadas");
        }
        
        if (ManRutaYVuelo.getInstancia().getRutaDeVuelo(nombre) != null) {
            errores.add("Nombre ya en uso");
        } else  if (nombre.isEmpty()) {
            errores.add("El nombre no debe ser vacío");
        }

        if (descripcion.isEmpty()) {
            errores.add("La descripción no debe ser vacía");
        } 
        if (costoBaseTurista.isEmpty()) {
            errores.add("Campo costoBaseTurista vacío");
        } else  if (!costoBaseTurista.matches("^\\d+(\\.\\d+)?$")) {  
            errores.add("Valor inválido en costoBaseTurista");
        }

        if (costoBaseEjecutivo.isEmpty()) {
            errores.add("Campo costoBaseEjecutivo vacío");
        } else  if (!costoBaseEjecutivo.matches("^\\d+(\\.\\d+)?$")) {  
            errores.add("Valor inválido en costoBaseEjecutivo");
        }

        if (costoEquipajeExtra.isEmpty()) {
            errores.add("Campo costoEquipajeExtra vacío");
        } else  if (!costoEquipajeExtra.matches("^\\d+(\\.\\d+)?$")) {  
            errores.add("Valor inválido en costoEquipajeExtra");
        }
        if (errores.isEmpty()) {
        	
            String paisOrigen = Origen.split(", ")[0];
            String ciudadOrigen = Origen.split(", ")[1].trim();
            String paisDestino = Destino.split(", ")[0];
            String ciudadDestino = Destino.split(", ")[1].trim();

            Par pOrig = new Par(paisOrigen,  ciudadOrigen);
            Par pDest = new Par(paisDestino,  ciudadDestino);

            Ciudad orig = ManCiudad.getInstancia().getCiudad(pOrig);
            Ciudad dest = ManCiudad.getInstancia().getCiudad(pDest);
        	
            float costoBaseTuristaF = Float.parseFloat(costoBaseTurista);
            float costoBaseEjecutivoF = Float.parseFloat(costoBaseEjecutivo);
            float costoEquipajeExtraF = Float.parseFloat(costoEquipajeExtra);
            
                        
            RutaDeVuelo newRuta = new RutaDeVuelo(aerolinea,  nombre,  descripcion,  hora,  costoBaseTuristaF,  costoBaseEjecutivoF,  costoEquipajeExtraF,  orig,  dest,  fechaAlta, new ArrayList<>(cats), descripcionCorta);
            ManRutaYVuelo.getInstancia().agregarRutaDeVuelo(newRuta);
            ManUsuarios.getInstancia().getAerolinea(aerolinea).agregarRutaDeVuelo(newRuta);
            newRuta.setOrigen(ManCiudad.getInstancia().getCiudad(pOrig));
            newRuta.setDestino(ManCiudad.getInstancia().getCiudad(pDest));
            
        }else {
            throw new SetException(errores);
        }


    }


    @Override
    public void altaVuelo(String RutaDeVuelo,  String nombre,  DtFecha fecha ,  DtHora duracion ,  String CantMaxT,  String CantMaxE,  DtFecha fechaAlta) throws SetException {
        Set<String> errores = new HashSet<>();
    
        if (RutaDeVuelo == null) {
            errores.add("Selecciona una ruta de vuelo");
        }
        
        if ( ManRutaYVuelo.getInstancia().getVuelo(nombre) != null) {
            errores.add("Nombre ya en uso");
        }else  if (nombre.isEmpty()) {
            errores.add("El nombre no debe ser vacío");
        }
        if (!CantMaxT.matches("^[0-9]\\d*$")) {
            errores.add("Cantidad de asientos trista invalida");
        }

        if (!CantMaxE.matches("^[0-9]\\d*$")) {
            errores.add("Cantidad de asientos ejecutivo invalida");

        }
        if (fecha.compararFechas(fechaAlta)==-1){
            errores.add("Fecha invalida");
        }
        
        if (errores.isEmpty()) {
            int Turista = Integer.parseInt(CantMaxT);
            int Ejecutivo = Integer.parseInt(CantMaxE);
            Vuelo nuevoVuelo = new Vuelo(nombre,  fecha,  duracion,  fechaAlta,  Turista,  Ejecutivo,  ManRutaYVuelo.getInstancia().getRutaDeVuelo(RutaDeVuelo));
            RutaDeVuelo ruta = ManRutaYVuelo.getInstancia().getRutaDeVuelo(RutaDeVuelo);
            ruta.agregarVuelo(nuevoVuelo);
    
            ManRutaYVuelo.getInstancia().agregarVuelo(nuevoVuelo);
        }else {

            
            throw new SetException(errores);
        }

        
    }


    @Override
    public void altaPaquete(String nombre, String descripcion,  String validez ,  String descuento,  DtFecha fechaActual) throws SetException{
        Set<String> errores = new HashSet<>();
        
        if ( ManPaquete.getInstancia().getPaquete(nombre) != null) {
            errores.add("Nombre ya en uso");
            
        } else  if (nombre.isEmpty()) {
            errores.add("El nombre no debe ser vacío");
        }
        if (descripcion.isEmpty()) {
            errores.add("La descripcion no debe ser vacia");
        }
    
        if (!validez.matches("^[1-9]\\d*$")) {
            errores.add("Campo validez invalido");
        }

        if (!descuento.matches("^[1-9]\\d*$")) {
            errores.add("Campo descuento invalido");
        }else  if (Integer.parseInt(descuento) > 100) {
            errores.add("El descuento no debe ser mayor a 100%");
        }


        if (errores.isEmpty()) {
            int des = Integer.parseInt(descuento);
            int per = Integer.parseInt(validez);
            Paquete newPaqueteRutaDeVuelo = new Paquete(nombre, descripcion, des, per, fechaActual);
            ManPaquete.getInstancia().agregarPaquete(newPaqueteRutaDeVuelo);
        }else {
            throw new SetException(errores);
        }


    }

    @Override
    public void altaCompraPaquete(String nombrePaquete,  String nicknameCliente , DtFecha fechaCompra) throws SetException{
    	
    	Set<String> errores = new HashSet<>();
    	
        if (nombrePaquete == null) {
            errores.add("Selecciona un paquete");

        }
        
        if (nicknameCliente == null) {
            errores.add("Selecciona un Cliente");

        }
        
        if (nombrePaquete != null && nicknameCliente != null) {
    		Cliente cliente = ManUsuarios.getInstancia().getCliente(nicknameCliente);
    		for (CompraPaquete compraPaquete : cliente.getComprasDePaquetes()) {
    			if (compraPaquete.getPaqueteAsociado().getNombre().equals(nombrePaquete)) {
    	            errores.add("El cliente ya compro ese paquete");
    	            break;
    			}
    		}

        }
        
    	
    	if (errores.isEmpty()) {
    		Cliente cliente = ManUsuarios.getInstancia().getCliente(nicknameCliente);
    		/*for (CompraPaquete cp : cliente.getComprasDePaquetes()) {
    			
    			if (cp.getPaqueteAsociado().getNombre().equals(nombrePaquete) ) {
    				errores.add("El cliente ya compro ese paquete");
    				break;
    			}
    		}*/
            float costo = 0;
            Paquete paquete = ManPaquete.getInstancia().getPaquete(nombrePaquete);
            for (PaqueteRuta pr : paquete.getPaquetesRuta()) {
                
                pr.getTipoAsiento();
                if (pr.getTipoAsiento().equals(EnumAsiento.turista)){
                    costo += pr.getCantidad()*pr.getRutaAsociada().getCostoBaseTurista()*(paquete.getDescuento()/100);
                }else {
                    costo += pr.getCantidad()*pr.getRutaAsociada().getCostoBaseEjecutivo()*(paquete.getDescuento()/100);
                }
            }
            DtFecha fechaVencimiento = fechaCompra;
            fechaVencimiento.sumarDias(paquete.getDuracionDias());
            paquete.setComprado();
            CompraPaquete compraPaquete = new CompraPaquete(nombrePaquete,  nicknameCliente,  fechaCompra,  fechaVencimiento,  costo,  paquete);
            cliente.addCompraDePaquetes(compraPaquete);
            ManPaquete.getInstancia().agregarCompraPaquete(compraPaquete);
            
        }else {
            throw new SetException(errores);
        }
    }

    @Override
    public Map<String,  Map<String,  Ciudad>> getCiudadesPais(){
        return ManCiudad.getInstancia().getCiudadesPais();

    }

    @Override
    public List<String> getCategorias(){
        return ManRutaYVuelo.getInstancia().getListCategoria();
    }

    @Override
    public Paquete getPaquete(String nombre){
        return ManPaquete.getInstancia().getPaquete(nombre);
    }

    @Override
    public Map<String, Paquete> getPaquetes(){
        return ManPaquete.getInstancia().getListPaquete();
    }

    @Override
    public RutaDeVuelo getRutaDeVuelo(String nombre){
        return ManRutaYVuelo.getInstancia().getRutaDeVuelo(nombre);
    }
   
    @Override
    public Map<String, RutaDeVuelo> getRutasDeVuelo(String nickname){
        return ManUsuarios.getInstancia().getAerolinea(nickname).getRutasDeVuelo();
    }
    
    @Override
    public Map<String, RutaDeVuelo> getRutasDeVueloIngresadas(String nickname){
    	return ManUsuarios.getInstancia().getAerolinea(nickname).getRutasDeVueloIngresadas();
    }
    
    @Override
    public Map<String, RutaDeVuelo> getRutasDeVueloAceptadas(String nickname){
    	return ManUsuarios.getInstancia().getAerolinea(nickname).getRutasDeVueloAceptadas();
    }
    public Map<String, RutaDeVuelo> getAllRutasDeVuelo(){
    	return ManRutaYVuelo.getInstancia().getListRutaDeVuelo();
    }

    
    @Override
    public Vuelo getVuelo(String nombre) {
    	return ManRutaYVuelo.getInstancia().getVuelo(nombre);
    }
   

    @Override 
    public void agregarRutaVueloPaquete(String paquete, String ruta, int cant , EnumAsiento asiento) throws SetException{
    	
    	Set<String> errores = new HashSet<>();
    	
    	if (ruta == null) {
    		errores.add("Debe seleccionar una ruta");
    	}
    	
    	if (cant == 0) {
    		errores.add("Cantidad debe ser mayor a 0");
    	}

    	if (asiento == null) {
    		errores.add("Selecciona un asiento");
    	}

    	if (paquete == null) {
    		errores.add("Selecciona un paquete");
    	}

    	
        if (errores.isEmpty()) {
        	
        	boolean repetido=false;
        	Paquete paqueteObj = ManPaquete.getInstancia().getPaquete(paquete);
        	for (PaqueteRuta pr : paqueteObj.getPaquetesRuta()){
        		if (pr.getRutaAsociada().getNombre().equals(ruta) && pr.getTipoAsiento().equals(asiento)) {
        			pr.setCantidad(pr.getCantidad()+cant);
        			repetido=true;
        			break;
        		}
        	}
        	
        	if (!repetido){
        		PaqueteRuta paqueteRuta = new PaqueteRuta(cant, asiento, ManRutaYVuelo.getInstancia().getRutaDeVuelo(ruta));
        		paqueteObj.agregarRutaAPaquete(paqueteRuta);
        	}
        }else  {
            throw new SetException(errores);
        }

     }

    @Override
    public void altaReserva(String cliente,  String vuelo,  EnumAsiento tipoAsiento,  int equipajeExtra,  int pasajes, DtFecha fechaActual, boolean paqueteUsado, Map<String, String> personas) throws SetException{
        Set<String> errores = new HashSet<>();
        for (Map.Entry<String,  String> entry : personas.entrySet()) {
            if (entry.getKey().isEmpty() || entry.getValue().isEmpty()){
                errores.add("Algun nombre o apellido invalido");
                break;
            }
        }
        if (vuelo==null) {
            errores.add("No hay vuelo seleccionado");
        }else {
        	Vuelo vueloObj = ManRutaYVuelo.getInstancia().getVuelo(vuelo);
            if (pasajes==0){
                errores.add("No hay pasajes seleccionados");
            }else  if (tipoAsiento == EnumAsiento.ejecutivo && pasajes>vueloObj.getCantAsientoEjecutivo()) {
            	errores.add("Cantidad de asientos ejecutivo insuficiente");
            }else  if (tipoAsiento == EnumAsiento.turista && pasajes>vueloObj.getCantAsientoTurista()) {
            	errores.add("cantidad de asientos turista insuficiente");
            }
        }
        
        
        if (cliente==null) {
            errores.add("No hay cliente seleccionado");
        }



    	
        if (errores.isEmpty()) {
        	Vuelo vueloObj = ManRutaYVuelo.getInstancia().getVuelo(vuelo);

        	Cliente clienteObj = ManUsuarios.getInstancia().getCliente(cliente);
        	
        	long costoTotal= 0;
        	double descuento=1.0;
        	CompraPaquete cPaquete = null;
        	String nombreRuta =vueloObj.getRutaDeVuelo().getNombre();
        	if (paqueteUsado) {
        		for (CompraPaquete cp : clienteObj.getComprasDePaquetes()){
        			
        			for (PaqueteRuta pr :cp.getPaqueteAsociado().getPaquetesRuta()){
        				
        				if ( pr.getRutaAsociada().getNombre().equals(nombreRuta) && cp.getRestantes().get(vueloObj.getRutaDeVuelo().getNombre())>= pasajes && pr.getTipoAsiento()==tipoAsiento && cp.getFechaVencimiento().compararFechas(fechaActual) != -1){
        					double d=1.0-((double)(cp.getPaqueteAsociado().getDescuento())/100.0);
        					if(d<=descuento) {
        						descuento=d;
        						cPaquete = cp;
        					}
        					break;
        				}  
        			}
        			
        		}
        	}
        	if (tipoAsiento == EnumAsiento.turista) {
        		costoTotal=Math.round( vueloObj.getRutaDeVuelo().getCostoBaseTurista() * pasajes * descuento + equipajeExtra * vueloObj.getRutaDeVuelo().getCostoEquipajeExtra());
        	}else  { 
        		costoTotal=Math.round( vueloObj.getRutaDeVuelo().getCostoBaseEjecutivo() * pasajes * descuento + equipajeExtra * vueloObj.getRutaDeVuelo().getCostoEquipajeExtra());
        	}
            
            ArrayList<Pasaje> arrayPasajes=new ArrayList<>(); 
			
            for (Map.Entry<String,  String> entry : personas.entrySet()) {
                Pasaje pasajeA = new Pasaje( entry.getKey(), entry.getValue());
                arrayPasajes.add(pasajeA);
               
            }
            
            Reserva nuevaReserva = new Reserva(fechaActual, tipoAsiento, equipajeExtra, pasajes, costoTotal, vueloObj, clienteObj, cPaquete, arrayPasajes, ManRutaYVuelo.getInstancia().getIdActual());
            ManRutaYVuelo.getInstancia().agregarReserva(nuevaReserva);
            vueloObj.agregarReservaAVuelo(nuevaReserva);
            clienteObj.addReserva(nuevaReserva);

            if (cPaquete!=null){
                cPaquete.sustraerPasajes(vueloObj.getRutaDeVuelo().getNombre(), pasajes);
            }
            
            if (tipoAsiento.equals(EnumAsiento.fromString("turista"))){
            	vueloObj.setCantAsientoTurista(vueloObj.getCantAsientoTurista()-pasajes);
            }else {
            	vueloObj.setCantAsientoEjecutivo(vueloObj.getCantAsientoEjecutivo()-pasajes);
            }

        }else {
            throw new SetException(errores);
        }


    }
    
    @Override
    public void setEstadoRuta(String ruta, EnumEstado estado) throws SetException{
    	
    	Set<String> errores = new HashSet<>();
    	if (estado==null) {
            errores.add("No hay estado seleccionado");
        }else  if (ruta == null) {
        	errores.add("No hay ruta seleccionada");
        }
    	
    	
    	if (errores.isEmpty()) {
    	RutaDeVuelo rutaDeV = getRutaDeVuelo(ruta);
    	rutaDeV.setEstado(estado);
    	}else  {
    		throw new SetException(errores);
    	}
    }
    
    @Override
    public void finalizarRuta(String nombre) {
    	RutaDeVuelo ruta = getRutaDeVuelo(nombre);
    	ruta.setEstado(EnumEstado.FINALIZADA);
    }
    
    
    @Override
    public boolean estaRutaEnAlgunPaquete(String nombre){
    	Map<String, Paquete> paquetes = getPaquetes();
    	for(Paquete paquete : paquetes.values()) {
    		if(paquete.estaRutaEnPaquete(nombre))return true;
    	}
    	return false;
    }

    @Override
    public void realizarCheckIn(String nickname, String vuelo){
        IControladorUsuarios controladorUsuarios = Fabrica.getControladorUsuarios();
        Cliente cliente = controladorUsuarios.getCliente(nickname);

        Reserva reserva = cliente.getReserva(vuelo);
        reserva.setCheck(true);
        reserva.setFechaCheck(new DtFecha());

        EnumAsiento tipoAsiento = reserva.getTipoAsiento();
        int asientos = 0;

        
        if(tipoAsiento == EnumAsiento.turista){
            asientos = reserva.getVuelo().getCantAsientosTuristaChecked();
        }else{
            asientos = reserva.getVuelo().getCantAsientosEjecutivoChecked();
        }

        ArrayList<Pasaje> pasajes = reserva.getPasajes();
        for(Pasaje p : pasajes){
            p.setNumeroAsiento(asientos);
            asientos++;
        }

        if(tipoAsiento == EnumAsiento.turista){
             reserva.getVuelo().setCantAsientosTuristaChecked(asientos);
        }else{
            reserva.getVuelo().setCantAsientosEjecutivoChecked(asientos);
        }

    }
    
    @Override
    public Map<String, Vuelo> getVuelos(){
        return ManRutaYVuelo.getInstancia().getListVuelo();
    }
    
   
}