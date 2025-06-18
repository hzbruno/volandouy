package volandouyMobile.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import volandouyMobile.servidor.*;

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
        volandouyMobile.servidor.PublicadorService service = new volandouyMobile.servidor.PublicadorService();
        volandouyMobile.servidor.Publicador port = service.getPublicadorPort();        

        HttpSession session = request.getSession();
		Integer estadoSesion =(Integer) session.getAttribute("estado_sesion");
    	if(estadoSesion== null || estadoSesion != 1){
    		response.sendRedirect("/volandouyMobile/login?action=login");
			
		}

        if (act != null) {
            switch (act) {
                case "1": 
                	volandouyMobile.servidor.AerolineasArrayDto aerolineas = port.getAerolineas();
                    request.setAttribute("aerolineasMap", aerolineas);
                    request.getRequestDispatcher("/WEB-INF/clases/reserva/consulta-reserva1.jsp").forward(request, response);
                    break;
                case "2":
                	volandouyMobile.servidor.RutaArrayDto rutasAceptadas = port.getRutasDeVueloAceptadasAerolinea(request.getParameter("aerolinea"));
                	request.setAttribute("mapaRutas", rutasAceptadas);
                    request.getRequestDispatcher("/WEB-INF/clases/reserva/consulta-reserva2.jsp").forward(request, response);
                    break;
                case "3":
                	volandouyMobile.servidor.VueloArrayDto vuelos = port.getVuelosRuta(request.getParameter("ruta"));
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
		        	response.sendRedirect("/volandouyMobile/home");	

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
		doGet(request, response);	
	}

}
