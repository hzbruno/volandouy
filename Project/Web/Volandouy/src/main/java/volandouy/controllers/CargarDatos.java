package volandouy.controllers;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import volandouy.servidor.*;

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

        String userAgent = req.getHeader("User-Agent");
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
        		System.out.println("Entro a la excepcion");
				e.printStackTrace();
		}

        HttpSession session = req.getSession();

        if (isMobile) {
            resp.sendRedirect("/volandouy/login?action=login");
        } else {
            resp.sendRedirect("/volandouy/home");
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
