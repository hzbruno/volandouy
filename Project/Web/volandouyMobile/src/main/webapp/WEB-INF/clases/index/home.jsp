<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="volandouyMobile.controllers.*"%>

<%@ page import="java.util.Map" %>
<%@ page import="volandouyMobile.servidor.*" %>
<%@ page import="java.net.URLEncoder" %>
<%@page import="java.util.Map"%>
<%@page import="java.io.File"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <jsp:include page="/WEB-INF/clases/template/head.jsp" />
     
</head>
<body>

       


    <jsp:include page="/WEB-INF/clases/template/header.jsp" />


    <div class="content-container">

        <div class="Rv-container">
<%

    RutaArrayDto rutas = (RutaArrayDto) request.getAttribute("rutas");
	String categoriaSeleccionada = (String)request.getParameter("categoria");
	boolean existeCategoria;
    if (rutas != null) {
        for (RutaDeVuelo r : rutas.getRutas()) {
            existeCategoria=false;
            if(categoriaSeleccionada!=null){
	        	for (String categoria : r.getCategorias()){
	                if (categoriaSeleccionada.equals(categoria)){
	                existeCategoria=true;
	                }
	            }   
            	
            }


            if (r.getEstado()== EnumEstado.CONFIRMADA && categoriaSeleccionada == null) {
%>
                <div class="rv-item" onclick="location.href='/volandouyMobile/Rutas?action=consultar&nombre=<%= URLEncoder.encode(r.getNombre(), "UTF-8") %>'">
                    <img src="media/images/datos/rutas/<%= r.getNombre() %>.jpg" onerror="this.onerror=null; this.src='media/images/ruta.jpg';" class="rv-img" alt="imagen ruta" />
                    <h2 class="rv-title"><%= r.getOrigen().getNombre() %> - <%= r.getDestino().getNombre() %> por <%= r.getAerolinea() %>(<%= r.getNombre() %>)</h2>
                    <p class="rv-descripcion"><%= r.getDescripcion() %></p>
                </div>
<%
            } else if (r.getEstado()== EnumEstado.CONFIRMADA && existeCategoria) {
%>
                <div class="rv-item" onclick="location.href='/volandouyMobile/Rutas?action=consultar&nombre=<%= URLEncoder.encode(r.getNombre(), "UTF-8") %>'">
                    <img src="media/images/datos/rutas/<%= r.getNombre() %>.jpg" onerror="this.onerror=null; this.src='media/images/ruta.jpg';" class="rv-img" alt="imagen ruta" />
                    <h2 class="rv-title"><%= r.getOrigen().getNombre() %> - <%= r.getDestino().getNombre() %> por <%= r.getAerolinea() %>(<%= r.getNombre() %>)</h2>
                    <p class="rv-descripcion"><%= r.getDescripcion() %></p>
                </div>
<%
            }
        }
    } else {
%>
    <p>No hay rutas disponibles en este momento.</p>
<%
    }
    
   
%>
 </div>
    </div>
</body>
</html>


          
        
        </div>

    </div>





</body>
</html>

