package volandouy.dto;

import java.util.ArrayList;
import volandouy.logica.Paquete;

public class PaqueteArrayDto {
    private ArrayList<Paquete> paquetes;
    public PaqueteArrayDto() {
    }
    public PaqueteArrayDto(ArrayList<Paquete> p) {
        this.paquetes = p;
    }

    public ArrayList<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(ArrayList<Paquete> p) {
        this.paquetes = p;
    }
}