package volandouy.controllers;

import java.io.IOException;
import java.util.Map;

import volandouy.servidor.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/home")
public class Home extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Home() {
        super();
    }
    
    private void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
    	
    	
        volandouy.servidor.PublicadorService service = new volandouy.servidor.PublicadorService();
        volandouy.servidor.Publicador port = service.getPublicadorPort();        
        volandouy.servidor.CategoriasArrayDto cats = port.getCategorias();
        volandouy.servidor.RutaArrayDto rutas = port.getAllRutasDeVuelo();
        req.setAttribute("Categorias", cats);
        req.setAttribute("rutas", rutas);
        
        
        
        
        req.getRequestDispatcher("/WEB-INF/clases/index/home.jsp").forward(req, resp);
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
