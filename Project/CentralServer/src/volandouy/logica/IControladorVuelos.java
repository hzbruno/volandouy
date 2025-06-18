package volandouy.logica;

import java.util.List;
import java.util.Map;
import volandouy.datatypes.DtFecha;
import volandouy.datatypes.DtHora;
import volandouy.datatypes.EnumAsiento;
import volandouy.datatypes.EnumEstado;
import volandouy.excepciones.SetException;

public interface IControladorVuelos {

    void altaCiudad(String ciudad,  String pais,  String aeropuerto,  String descripcion,  String sitioWeb,  DtFecha fechaAlta) throws SetException;

	void altaRutaDeVuelo(String aerolinea,  String nombre,  String descripcion,  DtHora hora, 
			String costoBaseTurista,  String costoBaseEjecutivo,  String costoEquipajeExtra,  String Origen, 
			String Destino,  DtFecha fechaAlta,  List<String> cats, String descripcionCorta) throws SetException;

    void altaVuelo(String RutaDeVuelo,  String nombre,  DtFecha fecha ,  DtHora Duracion ,  String CantMaxT,  String CantMaxE,  DtFecha fechaAlta) throws SetException;
    
    void altaPaquete(String nombre, String descripcion,  String validez ,  String descuento,  DtFecha fechaAlta) throws SetException;

    void altaCompraPaquete(String nombrePaquete,  String nicknameCliente , DtFecha fechaCompra) throws SetException;

    void agregarRutaVueloPaquete(String paquete, String ruta, int cant , EnumAsiento asiento) throws SetException;

    Map<String,  Map<String,  Ciudad>> getCiudadesPais();

    List<String> getCategorias();

    RutaDeVuelo getRutaDeVuelo(String nombre);
        
    Map<String, RutaDeVuelo> getRutasDeVuelo(String nombre);
    
    Vuelo getVuelo(String nombre);
    
    Paquete getPaquete(String nombre);

	Map<String,  Paquete> getPaquetes();

    void altaReserva(String cliente,  String vuelo,  EnumAsiento tipoAsiento,  int equipajeExtra,  int pasajes, DtFecha fechaActual, boolean paqueteUsado, Map<String, String> personas) throws SetException;

    void setEstadoRuta(String ruta, EnumEstado estado) throws SetException;
    
    Map<String, RutaDeVuelo> getRutasDeVueloIngresadas(String nickname);
    
    Map<String, RutaDeVuelo> getRutasDeVueloAceptadas(String nickname);
    
    Map<String, RutaDeVuelo> getAllRutasDeVuelo();
    
    Map<String, Vuelo> getVuelos();

    
    void finalizarRuta(String nombre);

    
    boolean estaRutaEnAlgunPaquete(String nombre);

    void realizarCheckIn(String nickname , String vuelo);
    
}
