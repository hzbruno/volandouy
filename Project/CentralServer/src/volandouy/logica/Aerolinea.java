package volandouy.logica;

import java.util.HashMap;
import java.util.Map;

import volandouy.datatypes.EnumEstado;


public class Aerolinea extends Usuario {
    
    private String descripcionGeneral;
    private String sitioWeb;
    private Map<String,  RutaDeVuelo> rutasDeVuelo;

    public Aerolinea() {
    	
    }
    public Aerolinea(String nickname,  String nombre,  String correo,  String contrasenia,  
                     String descripcionGeneral,  String sitioWeb) {
    	
        super(nickname,  nombre,  correo,  contrasenia);
        this.descripcionGeneral = descripcionGeneral;
        this.sitioWeb = sitioWeb;
        this.rutasDeVuelo = new HashMap<String,  RutaDeVuelo>();
    }
    public String getDescripcionGeneral() {
        return descripcionGeneral;
    }

    public void setDescripcionGeneral(String descripcionGeneral) {
        this.descripcionGeneral = descripcionGeneral;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }
    public RutaDeVuelo getRutaDeVuelo(String ruta){
        return this.rutasDeVuelo.get(ruta);
    }

    public Map<String,  RutaDeVuelo> getRutasDeVuelo(){
        return this.rutasDeVuelo;
    }
    

    public void agregarRutaDeVuelo(RutaDeVuelo rdv){
        this.rutasDeVuelo.put(rdv.getNombre(),  rdv);
    }
    
    
    public Map<String,  RutaDeVuelo> getRutasDeVueloIngresadas(){
    	Map<String,  RutaDeVuelo> rutas = this.getRutasDeVuelo();
    	
    	Map<String,  RutaDeVuelo> res = new HashMap<>();
    	
    	for (RutaDeVuelo r : rutas.values()) {
			 if (r.getEstado() == EnumEstado.INGRESADA) {
				 res.put(r.getNombre(),  r);
			 }
	      }
    	
    	return res;
    }
    
    public Map<String,  RutaDeVuelo> getRutasDeVueloAceptadas(){
    	Map<String,  RutaDeVuelo> rutas = this.getRutasDeVuelo();
    	
    	Map<String,  RutaDeVuelo> res = new HashMap<>();
    	
    	for (RutaDeVuelo r : rutas.values()) {
			 if (r.getEstado() == EnumEstado.CONFIRMADA) {
				 res.put(r.getNombre(),  r);
			 }
	      }
    	
    	return res;
    }

}
