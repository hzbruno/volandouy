package volandouy.datatypes;

public class DTUsuario {
    private String nickname;
    private String nombre;
    private String correo;

    public DTUsuario(String nickname, String nombre, String correo) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.correo = correo;
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

    @Override
    public String toString() {
        return "Usuario: " + nickname +
               "\nNombre: " + nombre +
               "\nCorreo: " + correo;
    }
}
