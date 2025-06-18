package volandouy.controllers;

import jakarta.mail.Session;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import volandouy.servidor.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Set;



@WebServlet ("/usuarios")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
maxFileSize = 1024 * 1024 * 10,      // 10 MB
maxRequestSize = 1024 * 1024 * 50)   // 50 MB
public class Usuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Usuarios() {
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
		String act = request.getParameter("action");
		volandouy.servidor.PublicadorService service = new volandouy.servidor.PublicadorService();
        volandouy.servidor.Publicador port = service.getPublicadorPort();       
        volandouy.servidor.CategoriasArrayDto cats = port.getCategorias();
        HttpSession session = request.getSession();
        Integer estadoSesion =(Integer) session.getAttribute("estado_sesion");
        
        
        request.setAttribute("Categorias", cats);
		
		
		if(act.equals("perfil")) {
			Usuario usuario = port.getUsuario(request.getParameter("nickname")).getUsuario();
			if(estadoSesion!=null && estadoSesion==1){
				Usuario usr = (Usuario)session.getAttribute("usuario_logeado");
				
				
				
				
				if(request.getParameter("follow") != null && request.getParameter("follow").equals("true")){// usuarioActual, usuarioASeguir
					port.seguirAUsuario(usr.getNickname(),request.getParameter("nickname"));
					
				} else if (request.getParameter("follow") != null && request.getParameter("follow").equals("false")){
					port.dejarDeSeguir(usr.getNickname(),request.getParameter("nickname"));
				}
				
				boolean siguiendo = port.sigueAUsuario(usr.getNickname(),request.getParameter("nickname"));
				request.setAttribute("siguiendo", siguiendo);	
						
			}
			
			usuario = port.getUsuario(request.getParameter("nickname")).getUsuario();
			request.setAttribute("usr", usuario);

			
			if (usuario instanceof Cliente) {
				
				Cliente cli =port.getCliente(usuario.getNickname()).getCliente();
				ReservasArrayDto reservas = port.getReservasCliente(cli.getNickname());
				ComprasPaqueteArrayDto cpCliente =port.getComprasDePaquetesCliente(cli.getNickname());
				request.setAttribute("reservasCliente", reservas);
				request.setAttribute("cpCliente", cpCliente);
				request.setAttribute("cli", cli);
				
			}
			else if(usuario instanceof Aerolinea){
				Aerolinea aer =port.getAerolinea(usuario.getNickname()).getAerolinea();
				RutaArrayDto rutasAceptadas = port.getRutasDeVueloAceptadasAerolinea(aer.getNickname());
				RutaArrayDto rutasNoAceptadas = port.getRutasDeVuelo((aer.getNickname()));
				request.setAttribute("rutasAceptadas", rutasAceptadas);
				request.setAttribute("rutasNoAceptadas", rutasNoAceptadas);
				request.setAttribute("aer", aer);
				
			}
			
			
			request.getRequestDispatcher("/WEB-INF/clases/usuarios/consulta-usuario.jsp").forward(request, response);

		}
		else if(act.equals("list")){
			List<Usuario> usrs = port.getUsuarios().getUsuarios();
			request.setAttribute("usrs", usrs);
			request.getRequestDispatcher("/WEB-INF/clases/usuarios/consulta-usuarios.jsp").forward(request, response);
			
		}else if(act.equals("modificar")) {
			Usuario usuario = port.getUsuario(request.getParameter("nickname")).getUsuario();
			request.setAttribute("usr", usuario);
			
			if (usuario instanceof Cliente) {
		        volandouy.servidor.PaisArrayDto paises = port.getPaises();
				request.setAttribute("paises", paises);
				Cliente cli =port.getCliente(usuario.getNickname()).getCliente();
				request.setAttribute("cli", cli);
			}
			else if(usuario instanceof Aerolinea){
				Aerolinea aer =port.getAerolinea(usuario.getNickname()).getAerolinea();
				request.setAttribute("aer", aer);
			}
			request.getRequestDispatcher("/WEB-INF/clases/usuarios/modificar-usuario.jsp").forward(request, response);
			
			
		}

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		volandouy.servidor.PublicadorService service = new volandouy.servidor.PublicadorService();
        volandouy.servidor.Publicador port = service.getPublicadorPort();     

		String nickname = request.getParameter("nickname");
	    String nombre = request.getParameter("nombre");
        String password = request.getParameter("password");
        
        String apellido = request.getParameter("apellido");
        String fechaNac = request.getParameter("fechaNacimiento");
        String country = request.getParameter("country");
        String documentType = request.getParameter("documentType");
        String numeroDocumento = request.getParameter("numeroDoc");
        
        String descripcionGeneral = request.getParameter("descripcionGeneral");
        String paginaWeb = request.getParameter("paginaWeb");
        
        
        HttpSession session = request.getSession();
        Usuario usuarioLogeado =  (Usuario) session.getAttribute("usuario_logeado");
        
		if(usuarioLogeado instanceof Cliente){
			EnumDocumento tipoDocumento = ("Pasaporte".equals(documentType)) ? EnumDocumento.PASAPORTE : EnumDocumento.DNI;
			String[] partesFecha = fechaNac.split("-");
			DtFecha fechaNacDt = port.getFecha(Integer.parseInt(partesFecha[2]),Integer.parseInt(partesFecha[1]),Integer.parseInt(partesFecha[0]));
			String exception =port.modificarCliente( nickname,nombre,password,apellido, fechaNacDt, country, tipoDocumento, numeroDocumento);
			if(exception.equals("")){


				String rutaRelativa = "/media/images/datos/usuarios";
	            String rutaCompleta = getServletContext().getRealPath(rutaRelativa);
	            Part filePart = request.getPart("imagen");
	            String fileName = nickname + ".jpg";
	            String filePath = rutaCompleta + File.separator + fileName;
	            filePart.write(filePath);
	            byte[] imagenBytes = convertirPartABytes(filePart);
		        try {
	            	
			        port.setImagen("usuarios", nickname, imagenBytes);
	            } catch (IOException_Exception e) {
					e.printStackTrace();
				}
				//////////////////////////////////////////////////////////////////////////////////////

				response.sendRedirect("/volandouy/home");

			}else{

                System.out.println(exception);
				request.setAttribute("error", exception);
				request.getRequestDispatcher("index.jsp").forward(request, response);

			}
		}else if(usuarioLogeado instanceof Aerolinea){
			
			String exception =port.modificarAerolinea(nickname,nombre, password , paginaWeb, descripcionGeneral);
			
			if(exception.equals("")){


				// IMAGEN
				String rutaRelativa = "/media/images/datos/usuarios";
	            String rutaCompleta = getServletContext().getRealPath(rutaRelativa);
	            Part filePart = request.getPart("imagen");
	            String fileName = nickname + ".jpg";
	            String filePath = rutaCompleta + File.separator + fileName;
	            filePart.write(filePath);
	            byte[] imagenBytes = convertirPartABytes(filePart);
		        try {
	            	
			        port.setImagen("usuarios", nickname, imagenBytes);
	            } catch (IOException_Exception e) {
					e.printStackTrace();
				}
				//////////////////////////////////////////////////////////////////////////////////////

				response.sendRedirect("/volandouy/home");

			}else{

                System.out.println(exception);
				request.setAttribute("error", exception);
				request.getRequestDispatcher("index.jsp").forward(request, response);

			}  
		     
		}

	}

}
