package volandouy.dto;

import java.util.ArrayList;

import volandouy.logica.Reserva;


public class ReservasArrayDto {
    private ArrayList<Reserva> reservas;
    public ReservasArrayDto() {
    }
    public ReservasArrayDto(ArrayList<Reserva> r) {
        this.reservas = r;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> r) {
        this.reservas = r;
    }
}