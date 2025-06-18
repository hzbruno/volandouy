package volandouy.controllers;

import java.io.IOException;
import java.io.InputStream;

import volandouy.servidor.*;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.ByteArrayOutputStream;
import java.io.File;
import jakarta.servlet.http.Part; 
import jakarta.servlet.annotation.MultipartConfig;


@WebServlet ("/login")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
                 maxFileSize = 1024 * 1024 * 10,      // 10 MB
                 maxRequestSize = 1024 * 1024 * 50)   // 50 MB
                 
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
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

        String userAgent = request.getHeader("User-Agent");
        boolean isMobile = false;

        String[] mobileDevices = {
            "Android", "iPhone", "iPad", "iPod", "BlackBerry", "Opera Mini", "IEMobile", 
            "Samsung", "Xiaomi", "Huawei", "OnePlus", "Nokia", "Sony", "HTC", "LG", "Motorola"
        };

        for (String device : mobileDevices) {
            if (userAgent != null && userAgent.contains(device)) {
                isMobile = true;
                break;
            }
        }
		
        volandouy.servidor.PublicadorService service = new volandouy.servidor.PublicadorService();
        volandouy.servidor.Publicador port = service.getPublicadorPort();        
        volandouy.servidor.CategoriasArrayDto cats = port.getCategorias();
        request.setAttribute("Categorias", cats);
        HttpSession session = request.getSession();
		
        Integer estadoSesion =(Integer) session.getAttribute("estado_sesion");
		if(act.equals("login") && (estadoSesion==null ||(estadoSesion!=null && estadoSesion !=1)) ) {
			request.getRequestDispatcher("/WEB-INF/clases/login/login.jsp").forward(request, response);

			
		}
		else if(act.equals("register")){
	        volandouy.servidor.PaisArrayDto paises = port.getPaises();

			request.setAttribute("paises", paises);
			
			
			request.getRequestDispatcher("/WEB-INF/clases/login/register.jsp").forward(request, response);
			
		}else if(act.equals("close")) {
            session.setAttribute("estado_sesion", 0);
            session.setAttribute("usuario_logeado", null);
            if(isMobile) {
    			response.sendRedirect("/volandouy/login?action=login");

            }else {
            	
            	response.sendRedirect("/volandouy/home");	
            }

        }else {
        	response.sendRedirect("/volandouy/home");	

        }
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("action");
		volandouy.servidor.PublicadorService service = new volandouy.servidor.PublicadorService();
        volandouy.servidor.Publicador port = service.getPublicadorPort();
		
		HttpSession session = request.getSession();
		if(act.equals("login")) {
			
			String username =request.getParameter("username");
			String password =request.getParameter("password");
			Usuario usr=port.getUsuario(username).getUsuario();
			if(usr!=null && !(usr instanceof Aerolinea && request.getParameter("mobile").equals("true")  )) {
				
				if(usr.getNickname().equals(username) && usr.getContrasenia().equals(password)) {
					
					session.setAttribute("usuario_logeado", usr);
					session.setAttribute("estado_sesion", 1);
					response.sendRedirect("/volandouy/home");	
				}
				else {

					request.setAttribute("error", "Usuario o contraseña incorrectos.");
					request.getRequestDispatcher("/WEB-INF/clases/login/login.jsp").forward(request, response);
				}
			}
			else {

				request.setAttribute("error", "Usuario o contraseña incorrectos.");
				request.getRequestDispatcher("/WEB-INF/clases/login/login.jsp").forward(request, response);
				
			}
			
		}
		else if(act.equals("register")){
			String tipoU = (String)request.getParameter("tipo-usuario");
			String nickname = (String)request.getParameter("username");
			String name = (String)request.getParameter("name");
			String email = (String)request.getParameter("email");
			String password = (String)request.getParameter("password");
	        
			if(tipoU.equals("Cliente")) {
				String apellido = (String)request.getParameter("apellido");
				String fechaNacimiento = (String)request.getParameter("fechaNacimiento");
				String pais = (String)request.getParameter("country");
				String tipoDoc = (String)request.getParameter("documentType");
				String numDoc = (String)request.getParameter("numeroDoc");
				
				EnumDocumento tipoDocumento = ("Pasaporte".equals(tipoDoc)) ? EnumDocumento.PASAPORTE : EnumDocumento.DNI;
		    	String[] partesFecha = fechaNacimiento.split("-");
		    	DtFecha fechaNac = port.getFecha(Integer.parseInt(partesFecha[2]),Integer.parseInt(partesFecha[1]),Integer.parseInt(partesFecha[0]));
		    	String exception = port.altaCliente(nickname, name, email, password, apellido, fechaNac, act, tipoDocumento, numDoc);
				if(exception.equals("")) {
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
					session.setAttribute("usuario_logeado", port.getUsuario(nickname).getUsuario());
					session.setAttribute("estado_sesion", 1);
					response.sendRedirect("/volandouy/home");

				}else{
                    System.out.println(exception);
					request.setAttribute("error", exception);    
			        volandouy.servidor.PaisArrayDto paises = port.getPaises();
					request.setAttribute("paises", paises);
					request.getRequestDispatcher("/WEB-INF/clases/login/register.jsp").forward(request, response);

				}
				
				
			}else if(tipoU.equals("Aerolinea")) {
				String desc = (String)request.getParameter("shortDescription");
				String paginaWeb = (String)request.getParameter("paginaWeb");

				String exception = port.altaAerolinea(nickname, name, email, password, desc, paginaWeb);
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
					session.setAttribute("usuario_logeado", port.getUsuario(nickname).getUsuario());
					session.setAttribute("estado_sesion", 1);
					response.sendRedirect("/volandouy/home");	
					
				}else {

                    System.out.println(exception);
					request.setAttribute("error", exception);       
			        volandouy.servidor.PaisArrayDto paises = port.getPaises();
					request.setAttribute("paises", paises);
					request.getRequestDispatcher("/WEB-INF/clases/login/register.jsp").forward(request, response);
					
				}
			}
			else {

				
				
				request.getRequestDispatcher("/WEB-INF/clases/login/register.jsp").forward(request, response);
			}

			
		}

		
	}

}