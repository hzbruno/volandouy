package volandouy.logica;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import volandouy.datatypes.DtFecha;
import volandouy.datatypes.EnumAsiento;

public class Paquete {
    private String nombre;
    private String descripcion;
    private int duracionDias;
    private int descuento; 
    private double costo;
    private DtFecha fechaDeAlta;
    private Set<PaqueteRuta> paquetesRuta;
    private boolean comprado;

    public Paquete() {

    }
    
    public Paquete(String nombre,  String descripcion,  int descuento,  int duracion,  DtFecha fechaAlta) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.descuento = descuento;
        this.duracionDias = duracion;
        this.fechaDeAlta = fechaAlta;
        this.paquetesRuta = new HashSet<>();
        this.comprado = false;
    }

    public boolean getComprado() {
        return comprado;
    }
    
    public void setComprado() {
        this.comprado=true;
    }

    public DtFecha calcularVencimiento() {
        LocalDate fechaAlta = LocalDate.of(fechaDeAlta.getAnio(),  fechaDeAlta.getMes(),  fechaDeAlta.getDia());
        LocalDate fechaVencimiento = fechaAlta.plusDays(duracionDias);

        return new DtFecha(fechaVencimiento.getDayOfMonth(),  fechaVencimiento.getMonthValue(),  fechaVencimiento.getYear());
    }


    public void agregarRutaAPaquete(PaqueteRuta paqRuta){
        paquetesRuta.add(paqRuta);
    }
  
    public Set<PaqueteRuta> getPaquetesRuta(){
    	return paquetesRuta;
    }
    public String getNombre() {
        return nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public int getDuracionDias() {
        return duracionDias;
    }

    public int getDescuento() {
        return descuento;
    }

    public double getCosto() {
        double costoBase = 0;
        for (PaqueteRuta paqRuta : paquetesRuta){
            if (paqRuta.getTipoAsiento().equals(EnumAsiento.fromString("turista"))){
            	costoBase += paqRuta.getCantidad()*paqRuta.getRutaAsociada().getCostoBaseTurista() * (1-(descuento/100));
            }else {
            	costoBase += paqRuta.getCantidad()*paqRuta.getRutaAsociada().getCostoBaseEjecutivo() * (1-(descuento/100));
            }
        }
        costoBase *= 1-  ((double)descuento/100);
        this.costo = Math.round(costoBase);
        return costo;
    }
    public DtFecha getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setCosto(double costo) {
    	this.costo = costo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDuracionDias(int duracionDias) {
        this.duracionDias = duracionDias;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public void setFechaDeAlta(DtFecha fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }
    
    public boolean estaRutaEnPaquete(String ruta) {
    	for(PaqueteRuta paqueteRuta : paquetesRuta) {
    		if(paqueteRuta.getRutaAsociada().getNombre()==ruta) {
    			return true;
    			}
    	}
    	return false;
    }
    
}
