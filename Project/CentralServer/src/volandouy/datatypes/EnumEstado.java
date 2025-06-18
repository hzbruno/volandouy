package volandouy.datatypes;

public enum EnumEstado {
    INGRESADA("Ingresada"),
    CONFIRMADA("Confirmada"),
    RECHAZADA("Rechazada"),
	FINALIZADA("Finalizada");

    private final String descripcion;

    // Constructor
    private EnumEstado(String descripcion) {
        this.descripcion = descripcion;
    }

    // Método para obtener la descripción
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
