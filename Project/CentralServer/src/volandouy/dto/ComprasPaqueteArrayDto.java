package volandouy.dto;

import java.util.ArrayList;

import volandouy.logica.CompraPaquete;


public class ComprasPaqueteArrayDto {
    private ArrayList<CompraPaquete> comprasPaquete;
    public ComprasPaqueteArrayDto() {
    }
    public ComprasPaqueteArrayDto(ArrayList<CompraPaquete> cp) {
        this.comprasPaquete = cp;
    }

    public ArrayList<CompraPaquete> getComprasPaquete() {
        return comprasPaquete;
    }

    public void setComprasPaquete(ArrayList<CompraPaquete> cp) {
        this.comprasPaquete = cp;
    }
}