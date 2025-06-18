package volandouy.logica;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import volandouy.datatypes.DtFecha;
import volandouy.datatypes.EnumDocumento;
import volandouy.excepciones.SetException;

public class ControladorUsuarios implements IControladorUsuarios{

    @Override
    public void altaCliente(String nickname,  String nombre,  String correo, String contrasenia,  String apellido,  DtFecha fechaDeNacimiento,  String nacionalidad,  EnumDocumento tipoDocumento,  String numeroDocumento) throws SetException {
        Set<String> errores = new HashSet<>();

        if (ManUsuarios.getInstancia().getUsuario(nickname)!=null){
            errores.add("El nickname ya esta en uso");
        }else  if (nickname.length()<=2 || nickname.length()>=25){
            errores.add("El nickname debe tener entre 3 y 24 caracteres");
        }else  if (!nickname.matches("[a-zA-Z0-9]+")){
            errores.add("El nickname solo puede contener letras y numeros");
        }
        if (nombre.length()==0){
            errores.add("El nombre no debe ser vacio");
        }
        if (contrasenia.length()==0){
            errores.add("La contrasenia no debe ser vacia");
        }
        if (contrasenia.length()<8){
            errores.add("La contrasenia debe tener mas de 8 caracteres");
        }
        
        if (!correo.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")){
            errores.add("El correo no es valido");
        }else  if (ManUsuarios.getInstancia().getUsuarioPorCorreo(correo)!=null){
            errores.add("Correo en uso");
        }
  
        if (apellido.length()==0){
            errores.add("El apellido no debe ser vacio");
        }

        DtFecha fechaActual18 = new DtFecha();
        DtFecha fechaActual120 = new DtFecha();
        fechaActual18.setAnio(fechaActual18.getAnio()-18);
        fechaActual120.setAnio(fechaActual120.getAnio()-120);

        if (fechaDeNacimiento.compararFechas(fechaActual18)==1){
            errores.add("Debe ser mayor de 18");
        }else  if (fechaDeNacimiento.compararFechas(fechaActual120)==-1 ) {
            errores.add("Fecha de Nacimiento fuera de rango");
        }
        if (numeroDocumento.length()<6 || numeroDocumento.length()>11){
            errores.add("El documento debe tener entre 6 y 11 caracteres");
        }
        if (errores.isEmpty()) {
            Cliente newCliente= new Cliente(nickname,  nombre,  correo, contrasenia,  apellido,  fechaDeNacimiento,   nacionalidad,   tipoDocumento,  numeroDocumento);
            ManUsuarios.getInstancia().agregarUsuario(newCliente);
        }else {
            throw new SetException(errores);
        }
    }

    @Override
    public void altaAerolinea(String nickname,  String nombre,  String correo, String contrasenia,  String descripcionGeneral,  String paginaWeb) throws SetException {
        Set<String> errores = new HashSet<>();
        if (ManUsuarios.getInstancia().getUsuario(nickname)!=null){
            errores.add("El nickname ya esta en uso");
        }else  if (nickname.length()<=2 || nickname.length()>=25 ){
            errores.add("El nickname debe tener entre 3 y 24 caracteres");
        }else  if (!nickname.matches("[a-zA-Z0-9]+")){
            errores.add("El nickname solo puede contener letras y numeros");
        }

        if (nombre.length()==0){
            errores.add("El nombre no debe ser vacio");
        }
        if (contrasenia.length()==0){
            errores.add("La contrasenia no debe ser vacia");
        }
        if (contrasenia.length()<8){
            errores.add("La contrasenia debe tener mas de 8 caracteres");
        }
        if (!correo.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")){
            errores.add("El correo no es valido");
        }else  if (ManUsuarios.getInstancia().getUsuarioPorCorreo(correo)!=null){
            errores.add("Correo en uso");
        }
 
        if (descripcionGeneral.length()==0 || descripcionGeneral.length()>=201){
            errores.add("La descripcion debe tener entre 1 y 200 caracteres ");
        }

        if (!paginaWeb.matches("^https?://[^\\s/$.?#].[^\\s]*\\.[a-z]{2,}(/.*)?$")){
            errores.add("El sitio no es valido");
        }

        if (errores.isEmpty()) {
            Aerolinea newAerolinea = new Aerolinea(nickname,  nombre,  correo,  contrasenia,  descripcionGeneral,  paginaWeb);
            ManUsuarios.getInstancia().agregarUsuario(newAerolinea);
        }else {
            throw new SetException(errores);
        }

    }
    @Override
    public void modificarAerolinea(String nickname, String nombre, String contrasenia , String sitioWeb , String descripcion) throws SetException {
        Set<String> errores = new HashSet<>();

        if (nombre.length()==0){
            errores.add("El nombre no debe ser vacio");
        }
        if (descripcion.length()==0 || descripcion.length()>=201){
            errores.add("La descripcion debe tener entre 1 y 200 caracteres ");
        }
        if (!sitioWeb.matches("^https?://[^\\s/$.?#].[^\\s]*\\.[a-z]{2,}(/.*)?$")){
            errores.add("El sitio web no es valido");
        }
        if (contrasenia.length()==0){
            errores.add("La contrasenia no debe ser vacia");
        }
        if (contrasenia.length()<8){
            errores.add("La contrasenia debe tener mas de 8 caracteres");
        }
        if (errores.isEmpty()) {
            Aerolinea aerolinea = ManUsuarios.getInstancia().getAerolinea(nickname);
            aerolinea.setNombre(nombre);
            aerolinea.setDescripcionGeneral(descripcion);
            aerolinea.setSitioWeb(sitioWeb);
            aerolinea.setContrasenia(contrasenia); 

        }else {
            throw new SetException(errores);
        }
    }

    @Override
    public void modificarCliente(String nickname, String nombre, String contrasenia, String apellido, DtFecha fechaDeNacimiento, String nacionalidad, EnumDocumento tipoDocumento, String numeroDocumento) throws SetException {
        Set<String> errores = new HashSet<>();

        if (nombre.length()==0){
            errores.add("El nombre no debe ser vacio");
        }

        if (apellido.length()==0){
            errores.add("El apellido no debe ser vacio");
        }

        DtFecha fechaActual18 = new DtFecha();
        DtFecha fechaActual120 = new DtFecha();
        fechaActual18.setAnio(fechaActual18.getAnio()-18);
        fechaActual120.setAnio(fechaActual120.getAnio()-120);

        if (fechaDeNacimiento.compararFechas(fechaActual18)==1){
            errores.add("Debe ser mayor de 18");
        }else if (fechaDeNacimiento.compararFechas(fechaActual120)==-1 ) {
            errores.add("Fecha de nacimiento fuera de rango");
        }

        if (numeroDocumento.length()<6 || numeroDocumento.length()>11){
            errores.add("El documento debe tener entre 6 y 11 caracteres");
        }
        if (contrasenia.length()==0){
            errores.add("La contrasenia no debe ser vacia");
        }
        if (contrasenia.length()<8){
            errores.add("La contrasenia debe tener mas de 8 caracteres");
        }
        if (errores.isEmpty()) {
            Cliente cliente = ManUsuarios.getInstancia().getCliente(nickname);
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setFechaDeNacimiento(fechaDeNacimiento);
            cliente.setNacionalidad(nacionalidad);
            cliente.setTipoDocumento(tipoDocumento);
            cliente.setNumeroDocumento(numeroDocumento);
            cliente.setContrasenia(contrasenia); 

        } else {
            throw new SetException(errores);
        }
    }


    @Override
    public Usuario getUsuario(String nickname){
        return ManUsuarios.getInstancia().getUsuario(nickname);
    }

    @Override
    public Map<String,  Aerolinea> getAerolineas(){
        return ManUsuarios.getInstancia().getListAerolinea();
    }

    @Override
    public Map<String,  Usuario> getUsuarios(){
        return ManUsuarios.getInstancia().getListUsuario();
    }

    @Override
    public Map<String,  Cliente> getClientes(){
        return ManUsuarios.getInstancia().getListCliente();
    }
     @Override
    public Aerolinea getAerolinea(String nickname){
        return ManUsuarios.getInstancia().getAerolinea(nickname);
    }

    @Override
    public Cliente getCliente(String nickname){
        return ManUsuarios.getInstancia().getCliente(nickname);
    }
    
    @Override
    public boolean sigueAUsuario(String usr, String sig) {
    	Usuario u = getUsuario(usr);
    	return u.sigueAUsuario(sig);
    }
    
    @Override
    public void seguirAUsuario(String usr,String sig) {
    	Usuario u = getUsuario(usr);
    	Usuario s = getUsuario(sig);
    	if(u == null || s == null || u.sigueAUsuario(sig) || usr.equals(sig)){
            return;
        }
    	u.seguirAUsuario(sig);
    	s.agregarSeguidor(usr);
    }
    
    @Override
    public void dejarDeSeguir(String usr,String sig) {
    	Usuario u = getUsuario(usr);
    	Usuario s = getUsuario(sig);
    	if(u == null || s == null || !u.sigueAUsuario(sig)|| usr.equals(sig)){
            return;
        }
    	u.dejarDeSeguir(sig);
    	s.eliminarSeguidor(usr);
    }
    
    
    
    
}