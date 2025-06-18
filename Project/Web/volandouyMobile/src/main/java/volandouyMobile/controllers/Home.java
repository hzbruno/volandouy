package volandouyMobile.controllers;

import java.io.IOException;
import java.util.Map;

import volandouyMobile.servidor.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/home")
public class Home extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Home() {
        super();
    }
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    	volandouyMobile.servidor.PublicadorService service = new volandouyMobile.servidor.PublicadorService();
    	volandouyMobile.servidor.Publicador port = service.getPublicadorPort();        
    	volandouyMobile.servidor.RutaArrayDto rutas = port.getAllRutasDeVuelo();
        request.setAttribute("rutas", rutas);
     	HttpSession session = request.getSession();
		Integer estadoSesion =(Integer) session.getAttribute("estado_sesion");
    	if(estadoSesion== null || estadoSesion != 1){
    		response.sendRedirect("/volandouyMobile/login?action=login");
			
		}else{
            
	        request.getRequestDispatcher("/WEB-INF/clases/index/home.jsp").forward(request, response);
        }
     
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
