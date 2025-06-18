package volandouy.dto;

import volandouy.logica.Paquete;

public class PaqueteDto {
	private Paquete paquete;
	public PaqueteDto() {
    }
    public PaqueteDto(Paquete paq) {
    	this.paquete = paq;
    }
    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paq) {
        this.paquete = paq;
    }
    


}