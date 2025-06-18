package volandouy.dto;

import java.util.ArrayList;

import volandouy.logica.Pasaje;


public class PersonasArrayDto {
    private ArrayList<Pasaje> personas;

    public PersonasArrayDto() {

    }
    
    public PersonasArrayDto(ArrayList<Pasaje> p ) {
        this.personas = p;

    }

    public ArrayList<Pasaje> getPasaje() {
        return personas;
    }

    public void setPasaje(ArrayList<Pasaje> p) {
        this.personas = p;
    }
    

}