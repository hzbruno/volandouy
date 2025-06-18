package volandouy.logica;
import java.util.HashMap;
import java.util.Map;
import volandouy.datatypes.Par;

public class ManCiudad {
    private static ManCiudad instancia;

    private final Map<Par,  Ciudad> ciudades;
    private final Map<String,  Map<String, Ciudad>> ciudadesPais;

    private ManCiudad() {
        ciudades = new HashMap<>();
        ciudadesPais = new HashMap<>();
    }

    public static synchronized ManCiudad getInstancia() {//explicacion en ManRutaYVuelo
        if (instancia == null) {
            instancia = new ManCiudad();
        }
        return instancia;
    }

    public Map<String,  Map<String, Ciudad>> getListCiudad() {
        return ciudadesPais;
    }

    public Ciudad getCiudad(Par parObj) {
        return ciudades.get(parObj);
        
    }

    public void agregarCiudad(Ciudad ciudad) {
        Par parObj = new Par(ciudad.getPais(),  ciudad.getNombre());
        ciudades.put(parObj,  ciudad);

        if (ciudadesPais.get(ciudad.getPais()) == null){
            Map<String, Ciudad> ciudadMapa = new HashMap<>();
            ciudadMapa.put(ciudad.getNombre(), ciudad);
            ciudadesPais.put(ciudad.getPais(), ciudadMapa);
        }else {
            Map<String, Ciudad> ciudadObj = ciudadesPais.get(ciudad.getPais());
            ciudadObj.put(ciudad.getNombre(), ciudad);
            ciudadesPais.put(ciudad.getPais(), ciudadObj);
        }

    }

    public void agregarPais(String pais){
        Map<String, Ciudad> Objeto = new HashMap<>();
        ciudadesPais.put(pais,  Objeto);
    }

    public Map<String,  Map<String, Ciudad>> getCiudadesPais(){
        return ciudadesPais;
    }

    public Map<Par, Ciudad> getCiudades(){
        return ciudades;
    }

}
