package volandouy.dto;

import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class PaisArrayDto {
	
	@XmlElement(name = "Paises")
    private ArrayList<String> Paises = new ArrayList<String>();

    public PaisArrayDto() {
    }

    public ArrayList<String> getPaises() {
        return Paises;
    }

    public void setPaises(ArrayList<String> cp) {
        this.Paises = cp;
    }
}