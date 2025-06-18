package volandouy.logica;
import volandouy.datatypes.DtFecha;

public class Ciudad {
    private String nombre;
    private String pais;
    private String aeropuerto;
    private String descripcion;
    private String pagWeb;
    private DtFecha fechaAlta;

    public Ciudad() {
    } 
    
    public Ciudad(String nombre,  String pais,  String aeropuerto,  String descripcion,  String pagWeb,  DtFecha fechaAlta) {
        this.nombre = nombre;
        this.pais = pais;
        this.aeropuerto = aeropuerto;
        this.descripcion = descripcion;
        this.pagWeb = pagWeb;    
        this.fechaAlta = fechaAlta;
    }   
    public String getNombre() {
        return nombre;
    }
    
    public String getPais() {
        return pais;
     }
    

    public String getDescripcion() {
          return descripcion;
    }
    
    public String getAeropuerto() {
        return aeropuerto;
  }


    public String getPagWeb() {
         return pagWeb;
    }


    public DtFecha getFechaAlta() {
         return fechaAlta;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setAeropuerto(String aeropuerto) {
        this.aeropuerto = aeropuerto;
    }

    public void setPagWeb(String pagWeb) {
        this.pagWeb = pagWeb;
    }

    public void setFechaAlta(DtFecha fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    }