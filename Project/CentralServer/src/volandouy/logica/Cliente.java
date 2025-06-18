package volandouy.logica;

import java.util.ArrayList;
import java.util.List;
import volandouy.datatypes.DtFecha;
import volandouy.datatypes.EnumDocumento;

public class Cliente extends Usuario {
    


    private String apellido;
    private DtFecha fechaDeNacimiento;
    private String nacionalidad;
    private EnumDocumento tipoDocumento;
    private String numeroDocumento;
    private ArrayList<Reserva> reservas;
    private ArrayList<CompraPaquete> comprasDePaquetes;

    public Cliente() {
    }
    
    public Cliente(String nickname,  String nombre,  String correo,  String contrasenia,  String apellido,  
                   DtFecha fechaDeNacimiento,  String nacionalidad,  EnumDocumento tipoDocumento,  
                   String numeroDocumento) {
    	
        super(nickname,  nombre,  correo,  contrasenia);
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.nacionalidad = nacionalidad;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.reservas = new ArrayList<>();
		this.comprasDePaquetes = new ArrayList<>();

    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public DtFecha getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(DtFecha fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public EnumDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(EnumDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
    public List<Reserva> getReservas() {
        return reservas;
    }

    public List<CompraPaquete> getComprasDePaquetes() {
        return comprasDePaquetes;
    }

    public CompraPaquete getCompraPaquete(String input){
        for (CompraPaquete paquete : comprasDePaquetes){
            if (paquete.getPaqueteAsociado().getNombre() == input){
                return paquete;
            }
        }
        return null;
    }

    public void addCompraDePaquetes(CompraPaquete compraP) {
        this.comprasDePaquetes.add(compraP);
    }

    public void addReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }

    public Reserva getReserva(String vuelo){
        for(Reserva reserva : reservas){
            if(reserva.getVuelo().getNombre().equals(vuelo)){
                return reserva;
                }
        }
        return null;
    }

}
