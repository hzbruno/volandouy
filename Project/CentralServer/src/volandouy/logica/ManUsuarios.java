package volandouy.logica;
import  java.util.HashMap;
import java.util.Map; 

public class ManUsuarios {
    private static ManUsuarios instancia;

    private final Map<String,  Usuario> usuarios;
    private final Map<String,  Cliente> clientes;
    private final Map<String,  Aerolinea> aerolineas;

    private ManUsuarios() {
        usuarios = new HashMap<>();
        clientes = new HashMap<>();
        aerolineas = new HashMap<>();
    }

    public static synchronized ManUsuarios getInstancia() { //explicacion en ManRutaYVuelo
        if (instancia == null) {
            instancia = new ManUsuarios();
        }
        return instancia;
    }

    public Map<String,  Usuario> getListUsuario() {
        return usuarios;
    }

    public Map<String,  Cliente> getListCliente() {
        return clientes;
    }

    public Map<String,  Aerolinea> getListAerolinea() {
        return aerolineas;
    }
    public Usuario getUsuarioPorCorreo(String correo) {
        for (Usuario usr : usuarios.values()) {
            if (usr.getCorreo().equals(correo)){
                return usr;
            }
        }
        return null;
    }
    public Usuario getUsuario(String nickname) {
        return usuarios.get(nickname); 
    }
    public Cliente getCliente(String nickname) {
        return clientes.get(nickname);
    }
    public Aerolinea getAerolinea(String nickname) {

        return aerolineas.get(nickname);

    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.put(usuario.getNickname(),  usuario);
        if (usuario instanceof Cliente) {
            clientes.put(usuario.getNickname(),  (Cliente) usuario);
        } else  if (usuario instanceof Aerolinea) {
        
            aerolineas.put(usuario.getNickname(),  (Aerolinea) usuario);
        }
    }

}
