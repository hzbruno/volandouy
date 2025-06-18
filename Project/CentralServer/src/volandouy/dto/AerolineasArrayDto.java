package volandouy.dto;

import java.util.ArrayList;
import volandouy.logica.Aerolinea;

public class AerolineasArrayDto {
    private ArrayList<Aerolinea> aerolineas;
    public AerolineasArrayDto() {
    }
    public AerolineasArrayDto(ArrayList<Aerolinea> a) {
        this.aerolineas = a;
    }

    public ArrayList<Aerolinea> getAerolineas() {
        return aerolineas;
    }

    public void setAerolineas(ArrayList<Aerolinea> a) {
        this.aerolineas = a;
    }
}