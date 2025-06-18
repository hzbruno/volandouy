package volandouy.dto;


public class ImagenDto {
	private String tipo;
	private String nombre;
	private byte[] imagen;

	public ImagenDto() {
    }
	
    public ImagenDto(String tipo, String nombre, byte[] imagen) {
    	this.tipo = tipo;
    	this.nombre = nombre;
    	this.imagen = imagen;

    }
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] img) {
        this.imagen = img;
    }


}