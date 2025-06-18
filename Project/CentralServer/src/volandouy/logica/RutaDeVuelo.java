package volandouy.logica;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import volandouy.datatypes.DtFecha;
import volandouy.datatypes.DtHora;
import volandouy.datatypes.EnumEstado;


public class RutaDeVuelo {
    private String aerolinea;
    private String nombre;
    private String descripcion;
    private DtHora hora;
    private DtFecha fechaDeAlta;
    private double costoBaseTurista;
    private double costoBaseEjecutivo;
    private double costoEquipajeExtra;
    private ArrayList<String> categorias;
    private EnumEstado estado;
    private String descripcionCorta;
    private Ciudad origen;
    private Ciudad destino;
    private Map<String, Vuelo> vuelos;

    public RutaDeVuelo() {
    }
    
    public RutaDeVuelo(String aerolinea, String nombre,  String descripcion,  DtHora hora,  double costoBaseTurista,  double costoBaseEjecutivo,  double costoEquipajeExtra,  Ciudad origen,  Ciudad destino,  DtFecha fechaDeAlta,  ArrayList<String> cats, String descripcionCorta) {
        this.aerolinea = aerolinea;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.hora = hora;
        this.fechaDeAlta = fechaDeAlta;
        this.costoBaseTurista = costoBaseTurista;
        this.costoBaseEjecutivo = costoBaseEjecutivo;
        this.costoEquipajeExtra = costoEquipajeExtra;
        this.categorias = cats;
        this.origen = origen;
        this.destino = destino;
        this.descripcionCorta=descripcionCorta;
        vuelos = new HashMap<>();
        estado = EnumEstado.INGRESADA;

    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public DtHora getHora() {
        return hora;
    }

    public DtFecha getFechaDeAlta() {
        return fechaDeAlta;
    }

    public double getCostoBaseTurista() {
        return costoBaseTurista;
    }

    public double getCostoBaseEjecutivo() {
        return costoBaseEjecutivo;
    }

    public double getCostoEquipajeExtra() {
        return costoEquipajeExtra;
    }

    public String getAerolinea(){
        return aerolinea;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setHora(DtHora hora) {
        this.hora = hora;
    }

    public void setFechaDeAlta(DtFecha fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    public void setCostoBaseTurista(double costoBaseTurista) {
        this.costoBaseTurista = costoBaseTurista;
    }

    public void setCostoBaseEjecutivo(double costoBaseEjecutivo) {
        this.costoBaseEjecutivo = costoBaseEjecutivo;
    }

    public void setCostoEquipajeExtra(double costoEquipajeExtra) {
        this.costoEquipajeExtra = costoEquipajeExtra;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }
    
    public ArrayList<String> getCategorias() {
        return categorias;
    }
    public void setCategorias(ArrayList<String> cats) {
        this.categorias = cats;
    }
    public Ciudad getOrigen() {
        return origen;
    }

    public void setOrigen(Ciudad origen) {
        this.origen = origen;
    }

    public Ciudad getDestino() {
        return destino;
    }


    public void setDestino(Ciudad destino) {
        this.destino = destino;
    }

    public Map<String, Vuelo> getVuelos() {
        return vuelos;
    }


    public void agregarVuelo(Vuelo vuelo) {
        this.vuelos.put(vuelo.getNombre(), vuelo);
    }
    
    public EnumEstado getEstado() {
        return estado;
    }
    
    public void setEstado(EnumEstado est) {
        this.estado = est;
    }

    public String getDescripcionCorta(){
        return this.descripcionCorta;
    }
    
    public void setDescripcionCorta(String des){
        this.descripcionCorta=des;
    }

    public boolean existeCategoria(String categoriaObj){

        for (String categoria : categorias){
            if (categoriaObj.equals(categoria))return true;
        }    

        return false;
    }
    
    public boolean noTieneVuelosVigentes() {
    	boolean resultado = true;
    	DtFecha actual = new DtFecha();	
    	for(Vuelo vuelo : vuelos.values()) {
    		if(actual.compararFechas(vuelo.getFecha())!=1)return false;
    	}
    	
    	return resultado;
    }

}
