package volandouy.dto;

import java.util.ArrayList;
import volandouy.logica.Vuelo;

public class VueloArrayDto {
    private ArrayList<Vuelo> vuelos;
    public VueloArrayDto() {
    }
    public VueloArrayDto(ArrayList<Vuelo> v) {
        this.vuelos = v;
    }

    public ArrayList<Vuelo> getVuelo() {
        return vuelos;
    }

    public void setVuelo(ArrayList<Vuelo> v) {
        this.vuelos = v;
    }
}