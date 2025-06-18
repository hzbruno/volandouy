package volandouy.datatypes;

public enum EnumDocumento {
    PASAPORTE("PASAPORTE"),
    DNI("DNI");

    private final String descripcion;

    // Constructor
    EnumDocumento(String descripcion) {
        this.descripcion = descripcion;
    }

    // Método para obtener la descripción del documento
    public String getDescripcion() {
        return descripcion;
    }

    // Métoedo para obtener el EnumDocumento a partir d una cadena
    public static EnumDocumento fromString(String texto) {
        for (EnumDocumento doc : EnumDocumento.values()) {
            if (doc.descripcion.equalsIgnoreCase(texto)) {
                return doc;
            }
        }
        throw new IllegalArgumentException("Tipo de documento no válido: " + texto);
    }

    // Sobrescribiendo el método toString para retornar la descripción
    @Override
    public String toString() {
        return this.descripcion;
    }
}
