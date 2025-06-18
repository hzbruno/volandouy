package volandouy.datatypes;

import java.util.List;
import java.util.Map;

public class DTRutaDeVuelo {
    private String nombre;
    private String descripcion;
    private DtHora hora;
    private DtFecha fechaDeAlta;
    private double costoBaseTurista;
    private double costoBaseEjecutivo;
    private double costoEquipajeExtra;
    private List<String> categorias;
    private String origen;
    private String destino;
    private Map<String, DTVuelo> vuelos;

    // Constructor
    public DTRutaDeVuelo(String nombre, String descripcion, DtHora hora, DtFecha fechaDeAlta, 
                         double costoBaseTurista, double costoBaseEjecutivo, double costoEquipajeExtra,
                         List<String> categorias, Map<String, DTVuelo> vuelos,String origen, String destino) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.hora = hora;
        this.fechaDeAlta = fechaDeAlta;
        this.costoBaseTurista = costoBaseTurista;
        this.costoBaseEjecutivo = costoBaseEjecutivo;
        this.costoEquipajeExtra = costoEquipajeExtra;
        this.categorias = categorias;
        this.vuelos = vuelos;
        this.origen = origen;
        this.destino = destino;
    }

    // Getters
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

    public List<String> getCategorias() {
        return categorias;
    }

    public Map<String, DTVuelo> getVuelos() {
        return vuelos;
    }

    public String getOrigen(){
        return origen;
    }

    public String getDestino(){
        return destino;
    }

    // toString para mostrar los datos
    @Override
    public String toString() {
        return "DTRutaDeVuelo{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", hora=" + hora +
                ", fechaDeAlta=" + fechaDeAlta +
                ", costoBaseTurista=" + costoBaseTurista +
                ", costoBaseEjecutivo=" + costoBaseEjecutivo +
                ", costoEquipajeExtra=" + costoEquipajeExtra +
                ", categorias=" + categorias +
                ", vuelos=" + vuelos +
                '}';
    }
}
