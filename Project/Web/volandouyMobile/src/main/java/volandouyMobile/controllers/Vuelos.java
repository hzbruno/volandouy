package volandouyMobile.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import volandouyMobile.servidor.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

import jakarta.servlet.http.Part;




@WebServlet ("/vuelos")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
maxFileSize = 1024 * 1024 * 10,      // 10 MB
maxRequestSize = 1024 * 1024 * 50)   // 50 MB
public class Vuelos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Vuelos() {
        super();
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
		
		if(act.equals("consultar")) {
			Vuelo vuelo = port.getVuelo(request.getParameter("nombre")).getVuelo();
			request.setAttribute("vuelo", vuelo);
			request.getRequestDispatcher("/WEB-INF/clases/vuelos/consulta-vuelo.jsp").forward(request, response);
			
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);	

	}

}
