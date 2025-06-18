package volandouy.logica;

import java.util.Map;
import volandouy.datatypes.DtFecha;
import volandouy.datatypes.EnumDocumento;
import volandouy.excepciones.SetException;


public interface IControladorUsuarios {
    void altaCliente(String nickname, String nombre, String correo, String apellido, String contrasenia, DtFecha fechaDeNacimiento, String nacionalidad, EnumDocumento tipoDocumento, String numeroDocumento) throws SetException;

    void altaAerolinea(String nickname, String nombre, String correo, String contrasenia, String descripcionGeneral, String paginaWeb) throws SetException;
        
    void modificarAerolinea(String nickname, String nombre, String contrasenia, String sitioWeb, String descripcion) throws SetException;

    void modificarCliente(String nickname, String nombre, String contrasenia, String apellido, DtFecha fechaDeNacimiento, String nacionalidad, EnumDocumento tipoDocumento, String numeroDocumento) throws SetException;
            
    Usuario getUsuario(String nickname);
    
    Map<String, Aerolinea> getAerolineas();
    
    Map<String, Usuario> getUsuarios();
    
    Map<String, Cliente> getClientes();

    Aerolinea getAerolinea(String nombre);
       
    Cliente getCliente(String nombre);
    
    boolean sigueAUsuario(String nicknameUsuario, String seguir);
    
    void seguirAUsuario(String usr,String sig);
    
    void dejarDeSeguir(String usr,String sig);
}
