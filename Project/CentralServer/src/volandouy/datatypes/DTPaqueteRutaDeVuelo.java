package volandouy.datatypes;


public class DTPaqueteRutaDeVuelo {
    private int cantidad;
    private EnumAsiento tipoDeAsiento;
    private DTRutaDeVuelo rutaDeVuelo; // Lista de rutas de vuelo en formato DataType
    private DTPaquete paquete;

    public DTPaqueteRutaDeVuelo(int cantidad, EnumAsiento tipoDeAsiento, 
                                DTRutaDeVuelo rutaDeVuelo, DTPaquete paquete) {
        this.cantidad = cantidad;
        this.tipoDeAsiento = tipoDeAsiento;
        this.rutaDeVuelo = rutaDeVuelo;
        this.paquete = paquete;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public EnumAsiento getTipoDeAsiento() {
        return tipoDeAsiento;
    }

    public void setTipoDeAsiento(EnumAsiento tipoDeAsiento) {
        this.tipoDeAsiento = tipoDeAsiento;
    }

    public DTRutaDeVuelo getRutaDeVuelo() {
        return rutaDeVuelo;
    }

    public void setRutaDeVuelo(DTRutaDeVuelo rutaDeVuelo) {
        this.rutaDeVuelo = rutaDeVuelo;
    }

    public DTPaquete getPaquete() {
        return paquete;
    }

    public void setPaquete(DTPaquete paquete) {
        this.paquete = paquete;
    }

    @Override
    public String toString() {
        return "PaqueteRutaDeVuelo{" +
               "cantidad=" + cantidad +
               ", tipoDeAsiento=" + tipoDeAsiento +
               ", rutaDeVuelo=" + rutaDeVuelo +
               ", paquete=" + paquete +
               '}';
    }
}
