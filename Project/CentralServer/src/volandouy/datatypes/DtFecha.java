package volandouy.datatypes;

import java.time.LocalDate;

public class DtFecha {

    private int dia;
    private int mes;
    private int año;

    // Constructor vacío que usa la fecha actual
    public DtFecha() {
        //LocalDate today = LocalDate.now();
        this.dia = FechaActual.getInstancia().getDia();
        this.mes = FechaActual.getInstancia().getMes();
        this.año = FechaActual.getInstancia().getAnio();
    }

    //Constructor con día, mes y año
    public DtFecha(int dia, int mes, int año) {
        if (isFechaValida(dia, mes, año)) {
            this.dia = dia;
            this.mes = mes;
            this.año = año;
        } else {
            throw new IllegalArgumentException("Fecha no válida.");
        }
    }

    // Constructor a partir de una cadena de texto (formato: dd/MM/yyyy)
    // public DTFecha(String fecha) {
    //     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    //     try {
    //         LocalDate parsedDate = LocalDate.parse(fecha, formatter);
    //         this.dia = parsedDate.getDayOfMonth();
    //         this.mes = parsedDate.getMonthValue();
    //         this.año = parsedDate.getYear();
    //     } catch (DateTimeParseException e) {
    //         throw new IllegalArgumentException("Fecha no válida.");
    //     }
    // }

    // Getters y Setters
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        if (isFechaValida(dia, this.mes, this.año)) {
            this.dia = dia;
        } else {
            throw new IllegalArgumentException("Día no válido.");
        }
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        if (isFechaValida(this.dia, mes, this.año)) {
            this.mes = mes;
        } else {
            throw new IllegalArgumentException("Mes no válido.");
        }
    }

    public int getAnio() {
        return año;
    }

    public void setAnio(int año) {
        if (isFechaValida(this.dia, this.mes, año)) {
            this.año = año;
        } else {
            throw new IllegalArgumentException("Año no válido.");
        }
    }

    //Método para validar la fecha
    public boolean isFechaValida(int dia, int mes, int año) {
        try {
            LocalDate.of(año, mes, dia);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Método para retornar la fecha en formato dd/MM/yyyy
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, año);
    }

    public int compararFechas(DtFecha fecha2) {
        if (this.año < fecha2.getAnio()) {
            return -1;
        } else if (this.año > fecha2.getAnio()) {
            return 1;
        }
        if (this.mes < fecha2.getMes()) {
            return -1;
        } else if (this.mes > fecha2.getMes()) {
            return 1;
        }
        if (this.dia < fecha2.getDia()) {
            return -1;
        } else if (this.dia > fecha2.getDia()) {
            return 1;
        }
        return 0;
    }

    public void sumarDias(int cantidadDias) {
        LocalDate fechaActual = LocalDate.of(año, mes, dia);
        
        LocalDate nuevaFecha = fechaActual.plusDays(cantidadDias);
        
        this.dia = nuevaFecha.getDayOfMonth();
        this.mes = nuevaFecha.getMonthValue();
        this.año = nuevaFecha.getYear();
    }



    
}
