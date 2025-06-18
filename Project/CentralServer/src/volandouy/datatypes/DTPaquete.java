package volandouy.datatypes;

public class DTPaquete {
    private String nombre;
    private String descripcion;
    private int duracionDias;
    private int descuento;
    private double costo;
    private DtFecha fechaDeAlta;

    public DTPaquete(String nombre, String descripcion, int duracionDias, int descuento, 
                     double costo, DtFecha fechaDeAlta) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracionDias = duracionDias;
        this.descuento = descuento;
        this.costo = costo;
        this.fechaDeAlta = fechaDeAlta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracionDias() {
        return duracionDias;
    }

    public void setDuracionDias(int duracionDias) {
        this.duracionDias = duracionDias;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public DtFecha getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setFechaDeAlta(DtFecha fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }

    @Override
    public String toString() {
        return "Paquete{" +
               "nombre='" + nombre + '\'' +
               ", descripcion='" + descripcion + '\'' +
               ", duracionDias=" + duracionDias +
               ", descuento=" + descuento + "%" +
               ", costo=" + costo +
               ", fechaDeAlta=" + fechaDeAlta +
               '}';
    }
}
