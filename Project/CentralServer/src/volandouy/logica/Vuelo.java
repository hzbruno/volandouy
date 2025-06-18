package volandouy.logica;

import java.util.ArrayList;
import java.util.List;
import volandouy.datatypes.DtFecha;
import volandouy.datatypes.DtHora;
import volandouy.datatypes.DTVuelo;

public class Vuelo {
    private String nombre;
    private DtFecha fecha;
    private DtHora duracion; 
    private DtFecha fechaAlta;
    private int cantAsientoTurista;
    private int cantAsientoEjecutivo;
    private int cantMaxAsientoTurista;
    private int cantMaxAsientoEjecutivo;
    private int asientosEjecutivosChecked;
    private int asientosTuristaChecked;
    private RutaDeVuelo rutaDeVuelo;
    private ArrayList<Reserva> reservas;

    public Vuelo() {  
    }
    
    public Vuelo(String nombre,  DtFecha fecha,  DtHora duracion,  DtFecha fechaAlta,  int cantAsientoTurista,  int cantAsientoEjecutivo,  RutaDeVuelo rutaDeVuelo) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.duracion = duracion;
        this.fechaAlta = fechaAlta;
        this.cantAsientoTurista = cantAsientoTurista;
        this.cantAsientoEjecutivo = cantAsientoEjecutivo;
        this.rutaDeVuelo = rutaDeVuelo;
        this.cantMaxAsientoTurista = cantAsientoTurista;
        this.cantMaxAsientoEjecutivo = cantAsientoEjecutivo;
        reservas = new ArrayList<>();

        this.asientosEjecutivosChecked = 1;
        this.asientosTuristaChecked = cantAsientoEjecutivo + 1;
    }

    public int getCantAsientosEjecutivoChecked(){
        return this.asientosEjecutivosChecked;
    }

    public int getCantAsientosTuristaChecked(){
        return this.asientosTuristaChecked;
    }

    public void setCantAsientosEjecutivoChecked(int a){
        this.asientosEjecutivosChecked  = a;
    }

    public void setCantAsientosTuristaChecked(int a){
        this.asientosTuristaChecked  = a;
    }

    public RutaDeVuelo getRutaDeVuelo() {
        return rutaDeVuelo;
    }

    public String getNombre() {
        return nombre;
    }

    public DtFecha getFecha() {
        return fecha;
    }

    public DtHora getDuracion() {
        return duracion;
    }

    public DtFecha getFechaAlta() {
        return fechaAlta;
    }

    public int getCantMaxAsientoTurista() {
        return cantMaxAsientoTurista;
    }

    public int getCantMaxAsientoEjecutivo() {
        return cantMaxAsientoEjecutivo;
    }
    public List<Reserva> getReservas(){
    	return reservas;
    }
    
    public String getAerolinea() {
    	return rutaDeVuelo.getAerolinea();
    }


    public int getCantAsientoTurista() {
    	return cantAsientoTurista;
    }
    
    public int getCantAsientoEjecutivo() {
    	return cantAsientoEjecutivo;
    }
    public void setCantAsientoTurista(int cantAsientoTurista) {
        this.cantAsientoTurista = cantAsientoTurista;
    }

    public void setCantAsientoEjecutivo(int cantAsientoEjecutivo) {
        this.cantAsientoEjecutivo = cantAsientoEjecutivo;
    }
    public void setRutaDeVuelo(RutaDeVuelo rutaDeVuelo) {
        this.rutaDeVuelo = rutaDeVuelo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(DtFecha fecha) {
        this.fecha = fecha;
    }

    public void setDuracion(DtHora duracion) {
        this.duracion = duracion;
    }

    public void setFechaAlta(DtFecha fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public void setCantMaxAsientoTurista(int cantMaxAsientoTurista) {
        this.cantMaxAsientoTurista = cantMaxAsientoTurista;
    }

    public void setCantMaxAsientoEjecutivo(int cantMaxAsientoEjecutivo) {
        this.cantMaxAsientoEjecutivo = cantMaxAsientoEjecutivo;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void agregarReservaAVuelo(Reserva reservaObj){
        reservas.add(reservaObj);
    }

    
    public DTVuelo getDTVuelo() {
    	return new DTVuelo(nombre,  fecha,  duracion,  fechaAlta,  
    			cantAsientoTurista,  cantAsientoEjecutivo);
    }
}

