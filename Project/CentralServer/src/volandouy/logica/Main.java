package volandouy.logica;
import volandouy.servidor.Publicador;
import volandouy.presentacion.MainInternal;


public class Main {
    public static void main(String[] args) {
    Publicador p = new Publicador();
    p.publicar();
    MainInternal mainFrame = new MainInternal();
    mainFrame.setVisible(true);


    }
}













  

