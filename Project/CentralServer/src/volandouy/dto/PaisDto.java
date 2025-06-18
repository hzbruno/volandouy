package volandouy.dto;

import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import volandouy.logica.Ciudad;


@XmlAccessorType(XmlAccessType.FIELD)
public class PaisDto {
	private String nombrePais;
	
	@XmlElement(name = "ciudades")
    private ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();

    public PaisDto() {
    }
    
    public PaisDto(String nombrePais) {
    	this.nombrePais = nombrePais;
    }
    
    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String np) {
        this.nombrePais = np;
    }
    
    public ArrayList<Ciudad> getCiudadesPais() {
        return ciudades;
    }

    public void setCiudadesPais(ArrayList<Ciudad> c) {
        this.ciudades = c;
    }

}