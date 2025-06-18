package volandouy.dto;

import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class CategoriasArrayDto {
	
	@XmlElement(name = "categorias")
    private ArrayList<String> categorias;

    public CategoriasArrayDto() {
    }
    
    public CategoriasArrayDto(ArrayList<String> c) {
        this.categorias = c;
    }

    public ArrayList<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<String> c) {
        this.categorias = c;
    }
}