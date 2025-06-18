package volandouy.dto;

import volandouy.logica.Cliente;

public class ClienteDto {
	private Cliente cliente;
	public ClienteDto() {
    }
    public ClienteDto(Cliente cli) {
    	this.cliente = cli;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cli) {
        this.cliente = cli;
    }
    


}