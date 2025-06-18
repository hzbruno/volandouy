package volandouy.logica;

public class Pasaje {
    private String nombre;
    private String apellido;
    private int numeroAsiento;

    public Pasaje() {

    }
    
    public Pasaje(String nombre,  String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroAsiento = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
    
    public int getNumeroAsiento(){
    	return numeroAsiento;    
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public void setNumeroAsiento(int asiento){
        this.numeroAsiento = asiento;
    }
}

