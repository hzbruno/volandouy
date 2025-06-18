package volandouyMobile.controllers;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import volandouyMobile.servidor.*;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@WebServlet("/cargardatos")
public class CargarDatos extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CargarDatos() {
        super();
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	volandouyMobile.servidor.PublicadorService service = new volandouyMobile.servidor.PublicadorService();
    	volandouyMobile.servidor.Publicador port = service.getPublicadorPort();    
        try {
        	ImagenesDto imagen =port.getFiles();
        	for(ImagenDto imgDto :imagen.getImagenes()) {
	            String rutaCompleta = getServletContext().getRealPath("/media/images/datos/"+ imgDto.getTipo());
	            File archivoImagen = new File(rutaCompleta + File.separator + imgDto.getNombre() + ".jpg");
	    		try (FileOutputStream fos = new FileOutputStream(archivoImagen)) {
	                fos.write(imgDto.getImagen());
	            } catch (IOException e) {
	            }
        	}

        } catch (IOException_Exception e) {
				e.printStackTrace();
		}

        HttpSession session = req.getSession();
        resp.sendRedirect("/volandouyMobile/login?action=login");

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
