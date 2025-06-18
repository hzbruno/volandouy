package volandouy.logica;

import java.util.ArrayList;

public class Usuario {
    
    private String nickname;
    private String nombre;
    private String correo;
    private String contrasenia;
    private ArrayList<String> siguiendo;
    private ArrayList<String> seguidoresList;
    private int seguidores;
    private int seguidos;
    
    public Usuario() {
    }
    
    public Usuario(String nickname,  String nombre,  String correo,  String contrasenia) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenia = contrasenia;

        this.siguiendo = new ArrayList<>();
        this.seguidoresList = new ArrayList<>();

        this.seguidores = 0;
        this.seguidos = 0;
    }

    public ArrayList<String> getSeguidoresList(){
        return this.seguidoresList;
    }

    public void setSeguidoresList(ArrayList<String> s){
        this.seguidoresList = s;
    }

    public void agregarSeguidor(String u){
        this.seguidoresList.add(u);
        this.seguidores++;
    }

    public void eliminarSeguidor(String u){
        this.seguidoresList.remove(u);
        this.seguidores--;
    }
    
    public int getSeguidores(){
        return seguidores;
    }
    
    public void setSeguidores(int i){
        seguidores = i;
    }
    
    public int getSeguidos(){
        return seguidos;
    }
    
    public void setSeguidos(int i){
        seguidos = i;
    }
    
    
    public ArrayList<String> getSiguiendo(){
    	return siguiendo;
    }
    
    public void setSiguiendo(ArrayList<String> s) {
    	siguiendo = s;
    }
    
    public void seguirAUsuario(String u) {
    	siguiendo.add(u);
    	seguidos++;
    }
    
    public void dejarDeSeguir(String u) {
    	siguiendo.remove(u);
    	seguidos--;

    	
    }
    
    public boolean sigueAUsuario(String nick) {
    	
    	for(String iterador : siguiendo) {
    		if(iterador.equals(nick))return true;
    	}
    	return false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNickname() {
    	return nickname;
    }
    public void setNickname(String nickname) {
    	this.nickname = nickname;
    }
    
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
    	this.correo = correo;
    }
    
    public String getContrasenia() {
        return contrasenia;
    }
    
    public void setContrasenia(String contrasenia) {
    	this.contrasenia = contrasenia;
    }


}
