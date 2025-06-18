package volandouy.datatypes;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtHora {
    private int hora;
    private int minuto;

    // Constructor
    public DtHora() {

    }
    
    public DtHora(int hora, int minuto) {
        this.hora = hora;
        this.minuto = minuto;
    }

    // Getters
    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    // Setters
    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    // Método para mostrar la hora en formato hh:mm
    @Override
    public String toString() {
        return String.format("%02d:%02d", hora, minuto);
    }
}

