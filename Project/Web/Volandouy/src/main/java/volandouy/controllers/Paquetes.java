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
import java.util.List;
import java.util.Map;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Servlet implementation class Paquetes
 */
@WebServlet("/Paquetes")
public class Paquetes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Paquetes() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private byte[] convertirPartABytes(Part filePart) throws IOException {
        try (InputStream inputStream = filePart.getInputStream();
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[8192];  
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }

            return byteArrayOutputStream.toByteArray();
        }
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        
		String act =request.getParameter("action");
		
        volandouy.servidor.PublicadorService service = new volandouy.servidor.PublicadorService();
        volandouy.servidor.Publicador port = service.getPublicadorPort();        
        volandouy.servidor.CategoriasArrayDto cats = port.getCategorias();
        request.setAttribute("Categorias", cats);

        if(act.equals("list")) {
        	PaqueteArrayDto paquetes = port.getPaquetes();
        	request.setAttribute("paquetes", paquetes);
        	request.getRequestDispatcher("/WEB-INF/clases/paquetes/consultar-paquetes.jsp").forward(request, response);
        	
        }else if (act.equals("consultar")) {

        	Paquete paquete = port.getPaquete(request.getParameter("nombre")).getPaquete();
        	request.setAttribute("paquete", paquete);
        	PaquetesRutaArrayDto paqRutas = port.getPaquetesRuta(request.getParameter("nombre"));
        	request.setAttribute("paqueteRutas", paqRutas);

        	
        	
        	request.getRequestDispatcher("/WEB-INF/clases/paquetes/consultar-paquete.jsp").forward(request, response);
        }

	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cliente = request.getParameter("usuario");
        String paquete = request.getParameter("paquete");
        
        volandouy.servidor.PublicadorService service = new volandouy.servidor.PublicadorService();
        volandouy.servidor.Publicador port = service.getPublicadorPort();        

	    String exception = port.altaCompraPaquete(paquete, cliente, port.getFechaActual());
			if(exception.equals("")){
				response.sendRedirect("/volandouy/home");
			
			}else{

	            System.out.println(exception);
				request.setAttribute("error", exception);
				PaqueteArrayDto paquetes = port.getPaquetes();
	        	request.setAttribute("paquetes", paquetes);
	        	volandouy.servidor.CategoriasArrayDto cats = port.getCategorias();
	            request.setAttribute("Categorias", cats);
				request.getRequestDispatcher("/WEB-INF/clases/paquetes/consultar-paquetes.jsp").forward(request, response);
			}
		
	}

}
