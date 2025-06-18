package volandouy.logica;

import java.util.ArrayList;
import volandouy.datatypes.DtFecha;
import volandouy.datatypes.EnumAsiento;



public class Reserva{

    private int identificacion;
    private DtFecha fecha;
    private int unidadesEquipExtra;
    private int cantPasajes;
    private EnumAsiento tipoAsiento;
    private double costo;
    private Vuelo vuelo;
    private Cliente cliente;
    private CompraPaquete paquete;
    private ArrayList<Pasaje> pasajes;
    private boolean check;
    private DtFecha fechaCheck;
 
    public Reserva() {
    }

    public Reserva(DtFecha fecha,  EnumAsiento tipoAsiento,  int unidadesEquipExtra,  int cantPasajes,  double costo,  Vuelo vuelo,  Cliente cliente,  CompraPaquete paquete,  ArrayList<Pasaje> pasajes,  int identif) {
    	this.fecha = fecha;
        this.tipoAsiento = tipoAsiento;
        this.unidadesEquipExtra = unidadesEquipExtra;
        this.cantPasajes = cantPasajes;
        this.costo = costo;
        this.vuelo = vuelo;
        this.cliente = cliente;
        this.paquete = paquete;
        this.pasajes = pasajes;
        this.identificacion = identif;
        this.check = false;
        this.fechaCheck = null;

    }

    public void setFechaCheck(DtFecha fechaC){
        this.fechaCheck = fechaC;
    }

    public DtFecha getFechaCheck(){
        return this.fechaCheck;
    }
    
    public void setCheck(boolean checkin){
        this.check = checkin;
    }

    public boolean getCheck(){
        return this.check;
    }
    
    public ArrayList<Pasaje> getPasajes() {
        return pasajes;
    }
    public CompraPaquete getPaquete() {
        return paquete;
    }
    public DtFecha getFecha() {
        return fecha;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public int getId(){
        return identificacion;
    }

    public EnumAsiento getTipoAsiento() {
        return tipoAsiento;
    }

    public Vuelo getVuelo(){
        return vuelo;
    }

    public int getUnidadesEquipExtra() {
        return unidadesEquipExtra;
    }

    public int getCantPasajes() {
        return cantPasajes;
    }

    public double getCosto() {
        return costo;
    }

    public void setPaquete(CompraPaquete paquete) {
        this.paquete = paquete;
    }

    public void setFecha(DtFecha fecha) {
        this.fecha = fecha;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setId(int identificacion) {
        this.identificacion = identificacion;
    }

    public void setTipoAsiento(EnumAsiento tipoAsiento) {
        this.tipoAsiento = tipoAsiento;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public void setUnidadesEquipExtra(int unidadesEquipExtra) {
        this.unidadesEquipExtra = unidadesEquipExtra;
    }

    public void setCantPasajes(int cantPasajes) {
        this.cantPasajes = cantPasajes;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    public void setPasajes(ArrayList<Pasaje> p) {
        this.pasajes = p;
    }

}
