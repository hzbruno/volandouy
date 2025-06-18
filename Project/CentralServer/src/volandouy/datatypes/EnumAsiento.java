package volandouy.datatypes;

public enum EnumAsiento{
    turista, ejecutivo;
    
public static EnumAsiento fromString(String texto) {

        if (texto != null) {
            for (EnumAsiento asiento : EnumAsiento.values()) {
                if (asiento.name().equalsIgnoreCase(texto)) {
                    return asiento;
                }
            }
        }
        throw new IllegalArgumentException();
    }
}