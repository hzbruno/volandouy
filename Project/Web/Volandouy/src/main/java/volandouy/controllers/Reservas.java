package volandouy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import volandouy.servidor.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import java.io.File;
import java.io.IOException;


@WebServlet ("/reservas")
public class Reservas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Reservas() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String act = request.getParameter("action");
        volandouy.servidor.PublicadorService service = new volandouy.servidor.PublicadorService();
        volandouy.servidor.Publicador port = service.getPublicadorPort();        
        volandouy.servidor.CategoriasArrayDto cats = port.getCategorias();
        request.setAttribute("Categorias", cats);
        HttpSession session = request.getSession();

        if (act != null) {
            switch (act) {
                case "1": 
                	volandouy.servidor.AerolineasArrayDto aerolineas = port.getAerolineas();
                    request.setAttribute("aerolineasMap", aerolineas);
                    request.getRequestDispatcher("/WEB-INF/clases/reserva/consulta-reserva1.jsp").forward(request, response);
                    break;
                case "2":
                	volandouy.servidor.RutaArrayDto rutasAceptadas = port.getRutasDeVueloAceptadasAerolinea(request.getParameter("aerolinea"));
                	request.setAttribute("mapaRutas", rutasAceptadas);
                    request.getRequestDispatcher("/WEB-INF/clases/reserva/consulta-reserva2.jsp").forward(request, response);
                    break;
                case "3":
                	volandouy.servidor.VueloArrayDto vuelos = port.getVuelosRuta(request.getParameter("ruta"));
                	request.setAttribute("mapVuelos", vuelos);
                    request.getRequestDispatcher("/WEB-INF/clases/reserva/consulta-reserva3.jsp").forward(request, response);
                    break;
                case "0":
                	Usuario usuarioLogeado =(Usuario)session.getAttribute("usuario_logeado");
                	Cliente c = port.getCliente(usuarioLogeado.getNickname()).getCliente(); 
                	Vuelo v  = port.getVuelo(request.getParameter("vuelo")).getVuelo();
                	ReservasArrayDto r  = port.getReservasVuelo(request.getParameter("vuelo"));
                	request.setAttribute("Cliente", c);
                	request.setAttribute("Vuelo", v);
                	request.setAttribute("Reservas", r);
                    request.getRequestDispatcher("/WEB-INF/clases/reserva/consulta-reserva.jsp").forward(request, response);
                    break;
                case "Check-in":
                	Usuario clienteLogeado2 =(Usuario)session.getAttribute("usuario_logeado");
                	Cliente cli = port.getCliente(clienteLogeado2.getNickname()).getCliente(); 
                	ReservasArrayDto reservas = (ReservasArrayDto)port.getReservasCliente(cli.getNickname());
                	request.setAttribute("Cliente", cli);
                	request.setAttribute("Reservas", reservas);
                    request.getRequestDispatcher("/WEB-INF/clases/reserva/check-in.jsp").forward(request, response);
                    
                    break;
				case "list":
				    Usuario usuarioLogeado3 =(Usuario)session.getAttribute("usuario_logeado");
                	Cliente clien = port.getCliente(usuarioLogeado3.getNickname()).getCliente(); 
                	ReservasArrayDto res = (ReservasArrayDto)port.getReservasCliente(clien.getNickname());

                	request.setAttribute("Cliente", clien);
                	request.setAttribute("Reservas", res);
                    request.getRequestDispatcher("/WEB-INF/clases/reserva/consulta-reserva-check-in.jsp").forward(request, response);

					break;
				case "check":
					
					Usuario usr =(Usuario)session.getAttribute("usuario_logeado");
                	Cliente clt = port.getCliente(usr.getNickname()).getCliente(); 
                	Vuelo vu  = port.getVuelo(request.getParameter("vuelo")).getVuelo();
					ReservasArrayDto reses = (ReservasArrayDto)port.getReservasCliente(clt.getNickname());
                	request.setAttribute("Cliente", clt);
                	request.setAttribute("Vuelo", vu);
					request.setAttribute("Reservas", reses);
					request.getRequestDispatcher("/WEB-INF/clases/reserva/consulta-check-in.jsp").forward(request, response);
					break;
				case "makeCheck":
					
					String cliente = request.getParameter("cliente");
                	String vuelo = request.getParameter("vuelo");
					port.realizarCheckIn(cliente,vuelo);
		        	response.sendRedirect("/volandouy/home");	

					break;
		
                case "reservar":
                	Vuelo v1 = port.getVuelo(request.getParameter("nombre")).getVuelo();
                	Usuario usuarioLogeado1 =(Usuario)session.getAttribute("usuario_logeado");
                	Cliente clienteLogeado = port.getCliente(usuarioLogeado1.getNickname()).getCliente();
                	request.setAttribute("vuelo", v1);
                	request.setAttribute("clienteLogeado", clienteLogeado);
                	
                	String nombreRuta =v1.getRutaDeVuelo().getNombre();
                    Integer cantidadRestanteTurista = 0;
                    Integer cantidadRestanteEjecutivo = 0;
                    CompraPaquete paqueteCompradoTurista = null;
                    CompraPaquete paqueteCompradoEjecutivo = null;
                    double descuentoT=1;
                    double descuentoE=1;
                    for(CompraPaquete cp : port.getComprasDePaquetesCliente(clienteLogeado.getNickname()).getComprasPaquete()){
                    	
        				for(PaqueteRuta pr :port.getPaquetesRuta(cp.getPaquete()).getPaquetesRuta()){
        					int restantesRuta = port.getCpRestantesRuta(clienteLogeado.getNickname(),cp.getPaquete(),nombreRuta);
        					if( pr.getRutaAsociada().getNombre().equals(nombreRuta) && restantesRuta>0 && port.compararFechas(cp.getFechaVencimiento(),port.getFechaActual()) != -1){
        						double d=1.0-((double)(cp.getPaqueteAsociado().getDescuento())/100.0);
        						if(pr.getTipoAsiento()==EnumAsiento.TURISTA && restantesRuta>cantidadRestanteTurista && d<=descuentoT){
        							descuentoT=d;
        							paqueteCompradoTurista = cp;
        							cantidadRestanteTurista =restantesRuta;
        							
        						}
        						if(pr.getTipoAsiento()==EnumAsiento.EJECUTIVO && restantesRuta>cantidadRestanteEjecutivo && d<=descuentoE){
        							descuentoE=d;
        							cantidadRestanteEjecutivo =restantesRuta;
        							paqueteCompradoEjecutivo = cp;
        						}

        					}  
        				}
        			}
                    request.setAttribute("descuentoE", descuentoE);
            		request.setAttribute("descuentoT", descuentoT);
                	request.setAttribute("paqueteCompradoEjecutivo", paqueteCompradoEjecutivo);
                	request.setAttribute("paqueteCompradoTurista", paqueteCompradoTurista);
                	request.setAttribute("cantidadRestanteEjecutivo", cantidadRestanteEjecutivo);
                	request.setAttribute("cantidadRestanteTurista", cantidadRestanteTurista);
                	
                    request.getRequestDispatcher("/WEB-INF/clases/reserva/reservar-vuelo.jsp").forward(request, response);
                    break;
                default:
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Acción no válida");
                    break;
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Se requiere una acción");
        }
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String aerolinea = request.getParameter("aerolinea");
        String ruta = request.getParameter("ruta");
        String vuelo = request.getParameter("vuelo");
        String tipoAsiento = request.getParameter("tipo-asiento");
        String paqueteUsado = request.getParameter("paquete-usado");
        String paqueteComprado = request.getParameter("compra-paquete");
        EnumAsiento tipoAsientoE = tipoAsiento.equals("Turista")? EnumAsiento.TURISTA:EnumAsiento.EJECUTIVO ;
        CompraPaquete comP=null;
        int cantidadPasajes = Integer.parseInt(request.getParameter("pasajes"));
        int equipajeExtra = Integer.parseInt(request.getParameter("equipaje-extra"));
        double costoFinal = Integer.parseInt(request.getParameter("precio-total"));
        String[] nombres = request.getParameterValues("nombre[]");
        String[] apellidos = request.getParameterValues("apellido[]");
        
        volandouy.servidor.PublicadorService service = new volandouy.servidor.PublicadorService();
        volandouy.servidor.Publicador port = service.getPublicadorPort(); 
        
    	PersonasArrayDto pasajesArray= new PersonasArrayDto();

		
        for (int i = 0; i < cantidadPasajes; i++) {
        	Pasaje p = new Pasaje();
        	p.setNombre(nombres[i]);
        	p.setApellido(apellidos[i]);
        	pasajesArray.getPasaje().add(p);

        }
        
    	HttpSession session = request.getSession();
    	Usuario usuarioLogeado = (Usuario)session.getAttribute("usuario_logeado");	
    	Cliente clienteLogeado = port.getCliente(usuarioLogeado.getNickname()).getCliente();

    	if(paqueteUsado==null) {
    		paqueteComprado="";
    	}

    	DtFecha fechaA = port.getFechaActual();
    	String exception = port.altaReserva(usuarioLogeado.getNickname(),vuelo,tipoAsientoE,equipajeExtra,cantidadPasajes,fechaA,paqueteComprado,pasajesArray);    		
    	 
    	
    	if(exception.equals("")) {
    		
    		response.sendRedirect("/volandouy/home");
    	}else {
    		Vuelo v1 = port.getVuelo(request.getParameter("vuelo")).getVuelo();

        	request.setAttribute("vuelo", v1);
        	request.setAttribute("clienteLogeado", clienteLogeado);
        	
        	String nombreRuta =v1.getRutaDeVuelo().getNombre();
            Integer cantidadRestanteTurista = 0;
            Integer cantidadRestanteEjecutivo = 0;
            CompraPaquete paqueteCompradoTurista = null;
            CompraPaquete paqueteCompradoEjecutivo = null;
            double descuentoT=1;
            double descuentoE=1;

            for(CompraPaquete cp : port.getComprasDePaquetesCliente(clienteLogeado.getNickname()).getComprasPaquete()){
            	
				for(PaqueteRuta pr :port.getPaquetesRuta(cp.getPaquete()).getPaquetesRuta()){
					int restantesRuta = port.getCpRestantesRuta(clienteLogeado.getNickname(),cp.getPaquete(),nombreRuta);
					if( pr.getRutaAsociada().getNombre().equals(nombreRuta) && restantesRuta>0 && port.compararFechas(cp.getFechaVencimiento(),port.getFechaActual()) != -1){
						double d=1.0-((double)(cp.getPaqueteAsociado().getDescuento())/100.0);
						if(pr.getTipoAsiento()==EnumAsiento.TURISTA && restantesRuta>cantidadRestanteTurista && d<=descuentoT){
							descuentoT=d;
							paqueteCompradoTurista = cp;
							cantidadRestanteTurista =restantesRuta;
							
						}
						if(pr.getTipoAsiento()==EnumAsiento.EJECUTIVO && restantesRuta>cantidadRestanteEjecutivo && d<=descuentoE){
							descuentoE=d;
							cantidadRestanteEjecutivo =restantesRuta;
							paqueteCompradoEjecutivo = cp;
						}

					}  
				}
			}

            
    		request.setAttribute("descuentoE", descuentoE);
    		request.setAttribute("descuentoT", descuentoT);
        	request.setAttribute("paqueteCompradoEjecutivo", paqueteCompradoEjecutivo);
        	request.setAttribute("paqueteCompradoTurista", paqueteCompradoTurista);
        	request.setAttribute("cantidadRestanteEjecutivo", cantidadRestanteEjecutivo);
        	request.setAttribute("cantidadRestanteTurista", cantidadRestanteTurista);
    		
    		System.out.println(exception);
    		request.setAttribute("error", exception);
    		request.getRequestDispatcher("/WEB-INF/clases/reserva/reservar-vuelo.jsp").forward(request, response);
    		
    	}



		
		
	}

}
