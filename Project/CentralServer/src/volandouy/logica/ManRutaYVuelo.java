package volandouy.logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManRutaYVuelo {
    private static ManRutaYVuelo instancia;

    private final Map<String, RutaDeVuelo> rutasDeVuelo;
    private final Map<String, Vuelo> vuelos;
    private final List<String> categorias;
    private final Map<Integer,  Reserva> reservas;
    private int idActual;
    private ManRutaYVuelo() {
        rutasDeVuelo = new HashMap<>();
        vuelos = new HashMap<>();
        categorias = new ArrayList<>();
        reservas = new HashMap<>();
        idActual = 0;
    }

    public static synchronized ManRutaYVuelo getInstancia() { 
        if (instancia == null) {                               
            instancia = new ManRutaYVuelo();                   
        }
        return instancia;
    }

    public Map<String, RutaDeVuelo> getListRutaDeVuelo() {
        return rutasDeVuelo;
    }

    public RutaDeVuelo getRutaDeVuelo(String nombre) {
        return rutasDeVuelo.get(nombre); 
    }

    public void agregarRutaDeVuelo(RutaDeVuelo rutaDeVuelo) {
        rutasDeVuelo.put(rutaDeVuelo.getNombre(), rutaDeVuelo);
    }

    public Reserva getReserva(int identificacion){
        return reservas.get(identificacion);
    }

    public void agregarReserva(Reserva reserva){
        reservas.put(idActual, reserva);
        idActual++;
    }

    public int getIdActual(){
        return idActual;
    }

    public Map<String, Vuelo> getListVuelo() {
        return vuelos;
    }

    public Vuelo getVuelo(String nombre) {
        return vuelos.get(nombre); 
    }
    
    

    public void agregarVuelo(Vuelo vuelo) {
        vuelos.put(vuelo.getNombre(), vuelo);
    }

    public void agregarCategoria(String cat){
        categorias.add(cat);
    }

    public List<String> getListCategoria(){
        return categorias;
    }



}
