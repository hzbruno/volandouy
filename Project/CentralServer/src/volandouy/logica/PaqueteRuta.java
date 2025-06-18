package volandouy.logica;

import volandouy.datatypes.EnumAsiento;


public class PaqueteRuta {

    private int cantidad;
    private EnumAsiento tipoAsiento;
    private RutaDeVuelo rutaAsociada;

    public PaqueteRuta() {
    }
    
    public PaqueteRuta(int cantidad,  EnumAsiento tipoAsiento,  RutaDeVuelo rutaAsociada) {
        this.cantidad= cantidad;
        this.tipoAsiento=tipoAsiento;
        this.rutaAsociada=rutaAsociada;

        
    }
    public int getCantidad() {
        return cantidad;
    }

    public EnumAsiento getTipoAsiento() {
        return tipoAsiento;
    }

    public RutaDeVuelo getRutaAsociada() {
        return rutaAsociada;
    }
    public void setTipoAsiento(EnumAsiento tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }

    public void setRutaAsociada(RutaDeVuelo rutaAsociada) {
        this.rutaAsociada = rutaAsociada;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}