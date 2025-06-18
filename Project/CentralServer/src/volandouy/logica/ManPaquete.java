package volandouy.logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManPaquete {
    private static ManPaquete instancia;

    private final Map<String, Paquete> paquetes;
    private final List<CompraPaquete> comprasPaquetes;

    private ManPaquete() {
        paquetes = new HashMap<>();
		this.comprasPaquetes = new ArrayList<>();
    }

    public static synchronized ManPaquete getInstancia() { 
        if (instancia == null) {
            instancia = new ManPaquete();
        }
        return instancia;
    }
    
    public void agregarCompraPaquete(CompraPaquete compraPaquete) {
    	this.comprasPaquetes.add(compraPaquete);
    }

    public Map<String, Paquete> getListPaquete() {
        return paquetes;
    }

    public Paquete getPaquete(String nombre) {
        return paquetes.get(nombre); 
    }

    public void agregarPaquete(Paquete paquete) {
        paquetes.put(paquete.getNombre(), paquete);
    }
}
