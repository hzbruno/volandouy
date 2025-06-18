package volandouy.dto;

import java.util.ArrayList;

public class ImagenesDto {

	private ArrayList<ImagenDto> imagenes;

	public ImagenesDto() {
    }
	
    public ImagenesDto(ArrayList<ImagenDto> imagenes) {
    	this.imagenes = imagenes;


    }
    public ArrayList<ImagenDto> getImagenes() {
        return imagenes;
    }

    public void setImagenes(ArrayList<ImagenDto> imagenes) {
        this.imagenes = imagenes;
    }

}