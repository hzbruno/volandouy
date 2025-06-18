package volandouy.datatypes;

public class DTCiudad {
    private String nombre;
    private String pais;
    private String descrip;
    private String pagWeb;
    private DtFecha fechaAlta;

    public DTCiudad(String nombre, String pais, String descrip, String pagWeb, DtFecha fechaAlta) {
        this.nombre = nombre;
        this.pais = pais;
        this.descrip = descrip;
        this.pagWeb = pagWeb;
        this.fechaAlta = fechaAlta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getPagWeb() {
        return pagWeb;
    }

    public void setPagWeb(String pagWeb) {
        this.pagWeb = pagWeb;
    }

    public DtFecha getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(DtFecha fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Override
    public String toString() {
        return "Ciudad: " + nombre +
               "\nFecha De Alta: " + fechaAlta.toString() +
               "\nDescripcion: " + descrip +
               "\nPagina Web: " + pagWeb +
               "\nPais: " + pais;
    }
}
