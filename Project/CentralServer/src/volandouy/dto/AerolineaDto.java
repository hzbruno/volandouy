package volandouy.dto;

import volandouy.logica.Aerolinea;

public class AerolineaDto {
	private Aerolinea aerolinea;

	public AerolineaDto() {
    }
	
    public AerolineaDto(Aerolinea aer) {
    	this.aerolinea = aer;
    }
    public Aerolinea getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(Aerolinea aer) {
        this.aerolinea = aer;
    }
    


}