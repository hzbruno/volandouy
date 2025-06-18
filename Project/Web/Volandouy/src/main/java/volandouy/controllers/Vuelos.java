package volandouy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import volandouy.servidor.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("action");
        volandouy.servidor.PublicadorService service = new volandouy.servidor.PublicadorService();
        volandouy.servidor.Publicador port = service.getPublicadorPort();       
        volandouy.servidor.CategoriasArrayDto cats = port.getCategorias();
        request.setAttribute("Categorias", cats);
		
		
		HttpSession session = request.getSession();
		if(act.equals("consultar")) {
			
			Vuelo vuelo = port.getVuelo(request.getParameter("nombre")).getVuelo();
			boolean comprado = false;
			Integer estadoSesion =(Integer) session.getAttribute("estado_sesion");
			if(estadoSesion!= null && estadoSesion == 1){
				Usuario usuarioLogeado = (Usuario)session.getAttribute("usuario_logeado");
				if (usuarioLogeado instanceof Cliente) {
					Cliente cli =port.getCliente(usuarioLogeado.getNickname()).getCliente();
					ReservasArrayDto reservas = port.getReservasCliente(cli.getNickname());
					for(Reserva r : reservas.getReservas()) {
						if(r.getVuelo().getNombre().equals(vuelo.getNombre())) {
							comprado = true;
						}
					}
		
				}
			}
			request.setAttribute("comprado", comprado);
			request.setAttribute("vuelo", vuelo);
			request.getRequestDispatcher("/WEB-INF/clases/vuelos/consulta-vuelo.jsp").forward(request, response);
			
		}else if(act.equals("crear")){
			RutaDeVuelo ruta = port.getRutaDeVuelo(request.getParameter("nombre")).getRutaDeVuelo();
			Usuario usuarioLogeado =(Usuario)session.getAttribute("usuario_logeado");
			Aerolinea aerolineaLogeada = port.getAerolinea(usuarioLogeado.getNickname()).getAerolinea();
			request.setAttribute("Ruta", ruta);
			request.setAttribute("aerolineaLogeada",aerolineaLogeada);
			request.setAttribute("fechaActual",port.getFechaActual());

			request.getRequestDispatcher("/WEB-INF/clases/vuelos/nuevo-vuelo.jsp").forward(request, response);
			
		}
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String rutaVuelo = request.getParameter("rutaVuelo");
	    String nombre = request.getParameter("nombreVuelo");
	    String fecha = request.getParameter("fecha");
	    String duracion = request.getParameter("hora");
	    String asientosTurista = request.getParameter("asientosTurista");
	    String asientosEjecutivos = request.getParameter("asientosEjecutivos");

        volandouy.servidor.PublicadorService service = new volandouy.servidor.PublicadorService();
        volandouy.servidor.Publicador port = service.getPublicadorPort();   
        String[] partesFecha = fecha.split("-");
        String[] partes = duracion.split(":");
		DtHora horaDt = new DtHora();
        horaDt.setHora(Integer.parseInt(partes[0]));
        horaDt.setMinuto(Integer.parseInt(partes[1]));
        DtFecha fechaDt = new DtFecha();
        fechaDt.setDia(Integer.parseInt(partesFecha[2]));
        fechaDt.setMes(Integer.parseInt(partesFecha[1]));
        fechaDt.setAnio(Integer.parseInt(partesFecha[0]));

        String exception = port.altaVuelo(rutaVuelo, nombre,fechaDt ,horaDt , asientosTurista, asientosEjecutivos, port.getFechaActual());
	    if(exception.equals("")){

            String rutaRelativa = "/media/images/datos/vuelos";
            String rutaCompleta = getServletContext().getRealPath(rutaRelativa);
            Part filePart = request.getPart("imagen");
            String fileName = nombre + ".jpg";
            String filePath = rutaCompleta + File.separator + fileName;
            filePart.write(filePath);

            byte[] imagenBytes = convertirPartABytes(filePart);
	        try {
            	
		        port.setImagen("vuelos", nombre, imagenBytes);
            } catch (IOException_Exception e) {
				e.printStackTrace();
			}
	        
			response.sendRedirect("/volandouy/home");


		}else{
	        System.out.println(exception);
	        request.setAttribute("error", exception);
	        request.getRequestDispatcher("index.jsp").forward(request, response);

		}
	     
		
	}

}
