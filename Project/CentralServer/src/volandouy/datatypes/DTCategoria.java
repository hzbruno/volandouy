package volandouy.datatypes;

public class DTCategoria {
    private String nombre;

    public DTCategoria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "DTCategoria{" +
               "nombre='" + nombre + '\'' +
               '}';
    }
}
