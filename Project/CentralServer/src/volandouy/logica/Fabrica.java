package volandouy.logica;


public class Fabrica {

    public static IControladorUsuarios getControladorUsuarios() {
        return new ControladorUsuarios();  
    }

    public static IControladorVuelos getControladorVuelos() {
        return new ControladorVuelos(); 
    }


}