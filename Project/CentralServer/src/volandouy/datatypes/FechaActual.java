package volandouy.datatypes;


public class FechaActual {

    // Instancia única del singleton
    private static FechaActual instancia;

    // Atributos para mes, día y año
    private int mes;
    private int dia;
    private int anio;

    // Constructor privado para evitar la instanciación directa
    private FechaActual() {
        this.mes = 1;
        this.dia = 1;
        this.anio = 1;
    }

    private FechaActual(int dia, int mes, int anio) {
        this.mes = mes;
        this.dia = dia;
        this.anio = anio;
    }

    // Método estático para obtener la instancia única
    public static FechaActual getInstancia() {
        if (instancia == null) {
            synchronized (FechaActual.class) {
                if (instancia == null) {
                    instancia = new FechaActual();
                }
            }
        }
        return instancia;
    }

    // Método para actualizar la fecha
    public void setFechaActual(int dia, int mes, int anio) {
        this.mes = mes;
        this.dia = dia;
        this.anio = anio;
    }

    // Métodos para obtener los atributos de la fecha
    public int getMes() {
        return mes;
    }

    public int getDia() {
        return dia;
    }

    public int getAnio() {
        return anio;
    }
}