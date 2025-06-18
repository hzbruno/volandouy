package volandouy.logica;

import java.util.HashMap;
import java.util.Map;
import volandouy.datatypes.DtFecha;

public class CompraPaquete {
	private String clienteNickname;
	private String nombrePaquete;
    private DtFecha fechaDeCompra;
    private DtFecha fechaVencimiento;
    private float costo;
    private Paquete paqueteAsociado;
    private Map<String,  Integer> restantes;

    public CompraPaquete() {
       
    }
    
    public CompraPaquete(String nombrePaquete,  String clienteNickname, DtFecha fechaDeCompra,  DtFecha fechaVencimiento,  float costo,  Paquete paquete) {
        this.clienteNickname = clienteNickname;
    	this.nombrePaquete = nombrePaquete;
    	this.fechaDeCompra = fechaDeCompra;
        this.fechaVencimiento = fechaVencimiento;
        this.costo = costo;

        this.paqueteAsociado = paquete;
        
        this.restantes = new HashMap<>();

        for (PaqueteRuta pr : paqueteAsociado.getPaquetesRuta()){
            this.restantes.put(pr.getRutaAsociada().getNombre(),  pr.getCantidad());
        }
    }

    public void sustraerPasajes(String rdv,  int cantidad){
    	restantes.put(rdv,  restantes.get(rdv)-cantidad);
    }

    public Map<String,  Integer> getRestantes() {
    	return this.restantes;
    }
    public Paquete getPaqueteAsociado() {
        return paqueteAsociado;
    }

    public DtFecha getFechaDeCompra() {
        return fechaDeCompra;
    }


    public DtFecha getFechaVencimiento() {
        return fechaVencimiento;
    }
    
    public String getCliente() {
    	return clienteNickname;
    }
    public String getPaquete() {
    	return nombrePaquete;
    }
    public float getCosto() {
    	return costo;
    }
	
	
	public void setRestantes(Map<String,  Integer> rest){
		this.restantes = rest;
	}
	
    public void setPaqueteAsociado(Paquete paqueteAsociado) {
        this.paqueteAsociado = paqueteAsociado;
    }

    public void setFechaDeCompra(DtFecha fechaDeCompra) {
        this.fechaDeCompra = fechaDeCompra;
    }

    public void setFechaVencimiento(DtFecha fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setCliente(String clienteNickname) {
        this.clienteNickname = clienteNickname;
    }

    public void setPaquete(String nombrePaquete) {
        this.nombrePaquete = nombrePaquete;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

}
