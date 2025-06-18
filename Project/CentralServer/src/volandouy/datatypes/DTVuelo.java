package volandouy.datatypes;

public class DTVuelo {
    private String nombre;
    private DtFecha fecha;
    private DtHora duracion;
    private DtFecha fechaAlta;
    private int cantAsientoTurista;
    private int cantAsientoEjecutivo;

    public DTVuelo(String nombre, DtFecha fecha, DtHora duracion, DtFecha fechaAlta, 
                   int cantAsientoTurista, int cantAsientoEjecutivo) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.duracion = duracion;
        this.fechaAlta = fechaAlta;
        this.cantAsientoTurista = cantAsientoTurista;
        this.cantAsientoEjecutivo = cantAsientoEjecutivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DtFecha getFecha() {
        return fecha;
    }

    public void setFecha(DtFecha fecha) {
        this.fecha = fecha;
    }

    public DtHora getDuracion() {
        return duracion;
    }

    public void setDuracion(DtHora duracion) {
        this.duracion = duracion;
    }

    public DtFecha getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(DtFecha fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public int getCantAsientoTurista() {
        return cantAsientoTurista;
    }

    public void setCantAsientoTurista(int cantAsientoTurista) {
        this.cantAsientoTurista = cantAsientoTurista;
    }

    public int getCantAsientoEjecutivo() {
        return cantAsientoEjecutivo;
    }

    public void setCantAsientoEjecutivo(int cantAsientoEjecutivo) {
        this.cantAsientoEjecutivo = cantAsientoEjecutivo;
    }

    @Override
    public String toString() {
        return "Vuelo: " + nombre +
               "\nFecha: " + fecha.toString() +
               "\nDuración: " + duracion + " horas" +
               "\nFecha de Alta: " + fechaAlta.toString() +
               "\nAsientos en Turista: " + cantAsientoTurista +
               "\nAsientos en Ejecutivo: " + cantAsientoEjecutivo;
    }
}
