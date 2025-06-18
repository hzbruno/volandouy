package volandouy.datatypes;

public class DTCliente {
    private String nickname;
    private String nombre;
    private String correo;
    private String apellido;
    private DtFecha fechaDeNacimiento;
    private String nacionalidad;
    private EnumDocumento tipoDocumento;
    private String numeroDocumento;

    public DTCliente(String nickname, String nombre, String correo, String apellido, 
                     DtFecha fechaDeNacimiento, String nacionalidad, EnumDocumento tipoDocumento, 
                     String numeroDocumento) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.correo = correo;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.nacionalidad = nacionalidad;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
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
}
