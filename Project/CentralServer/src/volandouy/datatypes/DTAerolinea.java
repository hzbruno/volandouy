package volandouy.datatypes;

public class DTAerolinea {

    private String nickname;
    private String nombre;
    private String correo;
    private String descripcionGeneral;
    private String paginaWeb;

    public DTAerolinea(String nickname, String nombre, String correo, 
                       String descripcionGeneral, String paginaWeb) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.correo = correo;
        this.descripcionGeneral = descripcionGeneral;
        this.paginaWeb = paginaWeb;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDescripcionGeneral() {
        return descripcionGeneral;
    }

    public void setDescripcionGeneral(String descripcionGeneral) {
        this.descripcionGeneral = descripcionGeneral;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }
}
