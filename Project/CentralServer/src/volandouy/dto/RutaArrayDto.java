package volandouy.dto;

import java.util.ArrayList;

import volandouy.logica.RutaDeVuelo;

public class RutaArrayDto {
    private ArrayList<RutaDeVuelo> rutas;
    public RutaArrayDto() {
    }
    public RutaArrayDto(ArrayList<RutaDeVuelo> r) {
        this.rutas = r;
    }

    public ArrayList<RutaDeVuelo> getRutas() {
        return rutas;
    }

    public void setRutas(ArrayList<RutaDeVuelo> r) {
        this.rutas = r;
    }
}