package volandouy.dto;

import volandouy.logica.Vuelo;

public class VueloDto {
	private Vuelo vuelo;
	public VueloDto() {
    }
    public VueloDto(Vuelo vuelo) {
    	this.vuelo = vuelo;
    }
    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }
    


}