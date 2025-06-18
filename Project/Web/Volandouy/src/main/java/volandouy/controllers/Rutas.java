package volandouy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import volandouy.servidor.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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

        volandouy.servidor.PublicadorService service = new volandouy.servidor.PublicadorService();
        volandouy.servidor.Publicador port = service.getPublicadorPort();        
        volandouy.servidor.CategoriasArrayDto cats = port.getCategorias();
        request.setAttribute("Categorias", cats);
		String act = request.getParameter("action");

		if(act.equals("consultar")) {
	        HttpSession session = request.getSession();
			RutaDeVuelo ruta = port.getRutaDeVuelo(request.getParameter("nombre")).getRutaDeVuelo();
			request.setAttribute("Ruta", ruta);
			Usuario usuarioLogeado = (Usuario)session.getAttribute("usuario_logeado");

			if(usuarioLogeado instanceof Aerolinea) {
				Aerolinea aerolineaLogeada = port.getAerolinea(usuarioLogeado.getNickname()).getAerolinea();

				request.setAttribute("aer", aerolineaLogeada);
				int rutDeAero = port.rutaDeAerolinea(aerolineaLogeada.getNickname(),ruta.getNombre());
				request.setAttribute("rutaDeAerolinea",rutDeAero);
				boolean finalizable = !port.estaRutaEnAlgunPaquete(ruta.getNombre()) && port.noTieneVuelosVigentes(ruta.getNombre());
				request.setAttribute("finalizable",finalizable);
				
			}
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
			
		}else if(act.equals("crear")){
			PaisArrayDto paisArr = port.getPaises();
			
			Map<String, Map<String, Ciudad>> ciudadesMap =  new HashMap<>();
			for (String pais : paisArr.getPaises()) {
				Map<String, Ciudad> cMap =  new HashMap<>();

			    for (Ciudad ciudad :port.getCiudadesPais(pais).getCiudades()) {

			        cMap.put(ciudad.getNombre(),ciudad);
			        for (Map.Entry<String, Ciudad> c2 :cMap.entrySet()) {
				    }

			    }
			    ciudadesMap.put(pais, cMap);
			}
			
			request.setAttribute("Ciudades", ciudadesMap);
			request.getRequestDispatcher("/WEB-INF/clases/rutas/nueva-ruta.jsp").forward(request, response);
			
		}else if(act.equals("finalizar")){
			port.finalizarRuta(request.getParameter("nombre"));
			response.sendRedirect("/volandouy/home");

			
			
		}
		
		
		


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        volandouy.servidor.PublicadorService service = new volandouy.servidor.PublicadorService();
        volandouy.servidor.Publicador port = service.getPublicadorPort();       
		
        String nombre = request.getParameter("nombre");
        String costoT = request.getParameter("costoT");
        String descripcionC = request.getParameter("descripcionC");
        String descripcion = request.getParameter("descripcion");
        String costoE = request.getParameter("costoE");
        String costoExtra = request.getParameter("costoExtra");
        String hora = request.getParameter("hora");
        String ciudadOrigen = request.getParameter("countryO"); 
        String ciudadDestino = request.getParameter("countryD"); 
        String aerolinea = request.getParameter("aerolinea");
        String[] categorias = request.getParameterValues("categorias");
        CategoriasArrayDto categoriasArray = new CategoriasArrayDto();
        List<String> cats = categoriasArray.getCategorias();
        
        if (categorias != null) { 
            for (String categoria : categorias) {
                cats.add(categoria);
            }
        }
        String[] partes = hora.split(":"); 
        DtHora horaDt = new DtHora();
        horaDt.setHora(Integer.parseInt(partes[0]));
        horaDt.setMinuto(Integer.parseInt(partes[1]));
        String exception =port.altaRutaDeVuelo(aerolinea, nombre, descripcion, horaDt, costoT, costoE, costoExtra, ciudadOrigen, ciudadDestino, port.getFechaActual(), categoriasArray,descripcionC);
		if(exception.equals("")) {
			
			
			String rutaRelativa = "/media/images/datos/rutas";
            String rutaCompleta = getServletContext().getRealPath(rutaRelativa);
            Part filePart = request.getPart("imagen");
            String fileName = nombre + ".jpg";
            String filePath = rutaCompleta + File.separator + fileName;
            filePart.write(filePath);
            byte[] imagenBytes = convertirPartABytes(filePart);
	        
	        try {
            	port.setImagen("rutas", nombre, imagenBytes);
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
