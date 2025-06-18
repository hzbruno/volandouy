package volandouy.dto;
import java.util.ArrayList;

import volandouy.logica.PaqueteRuta;

public class PaquetesRutaArrayDto {
	private ArrayList<PaqueteRuta> paquetesRuta;
	public PaquetesRutaArrayDto() {
    }
    public PaquetesRutaArrayDto(ArrayList<PaqueteRuta> p) {
        this.paquetesRuta = p;
    }

    public ArrayList<PaqueteRuta> getPaquetesRuta() {
        return paquetesRuta;
    }

    public void setPaquetesRuta(ArrayList<PaqueteRuta> p) {
        this.paquetesRuta = p;
    }
}

