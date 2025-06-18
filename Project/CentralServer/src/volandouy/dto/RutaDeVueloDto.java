package volandouy.dto;

import volandouy.logica.RutaDeVuelo;

public class RutaDeVueloDto {
	private RutaDeVuelo ruta;
	public RutaDeVueloDto() {
    }
    public RutaDeVueloDto(RutaDeVuelo ruta) {
    	this.ruta = ruta;
    }
    public RutaDeVuelo getRutaDeVuelo() {
        return ruta;
    }

    public void setRutaDeVuelo(RutaDeVuelo ruta) {
        this.ruta = ruta;
    }
    


}