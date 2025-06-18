package volandouyMobile.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import volandouyMobile.servidor.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;



@WebServlet ("/rutas")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
maxFileSize = 1024 * 1024 * 10,      // 10 MB
maxRequestSize = 1024 * 1024 * 50)   // 50 MB
public class Rutas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Rutas() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		volandouyMobile.servidor.PublicadorService service = new volandouyMobile.servidor.PublicadorService();
		volandouyMobile.servidor.Publicador port = service.getPublicadorPort();        
		String act = request.getParameter("action");

		HttpSession session = request.getSession();
		Integer estadoSesion =(Integer) session.getAttribute("estado_sesion");
    	if(estadoSesion== null || estadoSesion != 1){
    		response.sendRedirect("/volandouyMobile/login?action=login");
		}

		if(act.equals("consultar")) {
			RutaDeVuelo ruta = port.getRutaDeVuelo(request.getParameter("nombre")).getRutaDeVuelo();
			request.setAttribute("Ruta", ruta);
			Usuario usuarioLogeado = (Usuario)session.getAttribute("usuario_logeado");

			ArrayList<Vuelo> vuelosValidos = new ArrayList<>();
			VueloArrayDto vuelosR = port.getVuelosRuta(ruta.getNombre());
			DtFecha fechaActual = port.getFechaActual();
            for(Vuelo v : vuelosR.getVuelo()){
                if(port.compararFechas(v.getFecha(),fechaActual) == 1 ){
                	vuelosValidos.add(v);
                }
            }
			request.setAttribute("VuelosValidos", vuelosValidos);
			request.getRequestDispatcher("/WEB-INF/clases/rutas/consulta-ruta.jsp").forward(request, response);
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
