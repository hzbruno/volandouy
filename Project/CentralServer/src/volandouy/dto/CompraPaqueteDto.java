package volandouy.dto;

import volandouy.logica.CompraPaquete;

public class CompraPaqueteDto {
	private CompraPaquete compraPaquete;
	public CompraPaqueteDto() {
    }
    public CompraPaqueteDto(CompraPaquete cp) {
    	this.compraPaquete = cp;
    }
    public CompraPaquete getCompraPaquete() {
        return compraPaquete;
    }

    public void setCompraPaquete(CompraPaquete cp) {
        this.compraPaquete = cp;
    }
    


}