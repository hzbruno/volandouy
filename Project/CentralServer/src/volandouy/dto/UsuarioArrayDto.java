package volandouy.dto;

import java.util.ArrayList;
import volandouy.logica.Usuario;

public class UsuarioArrayDto {
    private ArrayList<Usuario> usuarios;
    
    public UsuarioArrayDto() {
    } 

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> u) {
        this.usuarios = u;
    }
}