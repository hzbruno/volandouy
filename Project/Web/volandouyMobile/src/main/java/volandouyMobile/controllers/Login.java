package volandouyMobile.controllers;

import java.io.IOException;

import volandouyMobile.servidor.*;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("action");

		volandouyMobile.servidor.PublicadorService service = new volandouyMobile.servidor.PublicadorService();
		volandouyMobile.servidor.Publicador port = service.getPublicadorPort();        
		volandouyMobile.servidor.CategoriasArrayDto cats = port.getCategorias();
        request.setAttribute("Categorias", cats);
        HttpSession session = request.getSession();
		
        Integer estadoSesion =(Integer) session.getAttribute("estado_sesion");
		if(act.equals("login") && (estadoSesion==null ||(estadoSesion!=null && estadoSesion !=1)) ) {
			request.getRequestDispatcher("/WEB-INF/clases/login/login.jsp").forward(request, response);

		}else if(act.equals("close")) {
            session.setAttribute("estado_sesion", 0);
            session.setAttribute("usuario_logeado", null);
    		response.sendRedirect("/volandouyMobile/login?action=login");

        }else {
        	response.sendRedirect("/volandouyMobile/home");	

        }
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("action");
		volandouyMobile.servidor.PublicadorService service = new volandouyMobile.servidor.PublicadorService();
		volandouyMobile.servidor.Publicador port = service.getPublicadorPort();
		
		HttpSession session = request.getSession();			
		String username =request.getParameter("username");
		String password =request.getParameter("password");
		Usuario usr=port.getUsuario(username).getUsuario();
		
		if(usr!=null && !(usr instanceof Aerolinea )) {
			
			if(usr.getNickname().equals(username) && usr.getContrasenia().equals(password)) {
				
				session.setAttribute("usuario_logeado", usr);
				session.setAttribute("estado_sesion", 1);
				response.sendRedirect("/volandouyMobile/home");	
			}
			else {

				request.setAttribute("error", "Usuario o contraseña incorrectos.");
				request.getRequestDispatcher("/WEB-INF/clases/login/login.jsp").forward(request, response);
			}
		}else {
	
				request.setAttribute("error", "Usuario o contraseña incorrectos.");
				request.getRequestDispatcher("/WEB-INF/clases/login/login.jsp").forward(request, response);
				
			}
			
		}
		
			
	}

