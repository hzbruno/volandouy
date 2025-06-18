package volandouy.dto;

import volandouy.logica.Usuario;

public class UsuarioDto {
	private Usuario usuario;
	public UsuarioDto() {
    }
    public UsuarioDto(Usuario usr) {
    	this.usuario = usr;
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usr) {
        this.usuario = usr;
    }
    


}