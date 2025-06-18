 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="volandouy.controllers.*"%>
<%@ page import="volandouy.servidor.*"%>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/clases/template/head.jsp" />
	<link rel="stylesheet" href="media/styles/vuelo.css">
</head>
<body>
    
    <jsp:include page="/WEB-INF/clases/template/header.jsp" />


    <div class="content-container">

    <jsp:include page="/WEB-INF/clases/template/table-container.jsp" />



<%

String userAgent = request.getHeader("User-Agent");
boolean isMobile = false;

// Definimos algunos términos comunes en User-Agent de dispositivos móviles
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

Vuelo vuelo = (Vuelo) request.getAttribute("vuelo");
DtFecha fecha=vuelo.getFecha();
DtFecha fechaAlta = vuelo.getFechaAlta();
DtHora duracion = vuelo.getDuracion();
%>


        <div class="vuelos-container">

            <div class="vuelo-item">
                <img src="media/images/datos/vuelos/<%= vuelo.getNombre() %>.jpg" onerror="this.onerror=null; this.src='media/images/avion.png';" class="vuelo-img" alt="imagen vuelo" />
                <h2 class="vuelo-nombre"> <%= vuelo.getNombre() %> </h2>
                <p class="vuelo-nombre"><b>Nombre: </b><%= vuelo.getNombre() %></p>
                <p class="vuelo-fecha"><b>Fecha: </b><%=fecha.getDia() %>/<%=fecha.getMes() %>/<%=fecha.getAnio() %></p>
                <p class="vuelo-duracion"><b>Duracion: </b><%= String.format("%02d", duracion.getHora()) %>:<%= String.format("%02d", duracion.getMinuto()) %></p>
                <p class="vuelo-cantTurista"><b>Cantidad máxima asientos turistas: </b><%= vuelo.getCantMaxAsientoTurista() %></p>
                <p class="vuelo-cantTurista"><b>Cantidad máxima asientos ejecutivos: </b><%= vuelo.getCantMaxAsientoEjecutivo() %></p>
                <p class="vuelo-fechaAlta"><b>Fecha Alta: </b><%=fechaAlta.getDia() %>/<%=fechaAlta.getMes() %>/<%=fechaAlta.getAnio() %></p>
            </div>


<%
Integer estadoSesion =(Integer) session.getAttribute("estado_sesion");
if(estadoSesion!= null && estadoSesion == 1 && !isMobile){
	Usuario usuarioLogeado = (Usuario)session.getAttribute("usuario_logeado");
	if(usuarioLogeado instanceof Cliente && !(boolean) request.getAttribute("comprado")){

%>

          <div class="user-btn" onclick="location.href='/volandouy/reservas?action=reservar&nombre=<%= URLEncoder.encode(vuelo.getNombre(), "UTF-8") %>'">Reservar vuelo</div>

        
<%
	}
}
%>   
   
        
        </div>



        <div class="Aerolinea-Ruta">
        	<%
        	if(!isMobile){
        	%>
            <h1 for="aerolinea">Aerolinea</h1>                       
            <button class="aerolinea-btn" id="aerolinea-btn" onclick="location.href ='/volandouy/usuarios?action=perfil&nickname=<%= URLEncoder.encode(vuelo.getRutaDeVuelo().getAerolinea(), "UTF-8") %>'"><%= vuelo.getRutaDeVuelo().getAerolinea() %></button>           
            <%
				}
			%>  
            
            
            <h1 for="ruta">Ruta</h1>       
          <%
             String nombreVuelo = URLEncoder.encode(vuelo.getNombre(), "UTF-8");
          %>
        <button class="aerolinea-btn" onclick="location.href='/volandouy/Rutas?action=consultar&nombre=<%= URLEncoder.encode(vuelo.getRutaDeVuelo().getNombre(), "UTF-8") %>'"><%= vuelo.getRutaDeVuelo().getNombre() %></button>  

            
            
        </div>

    </div>





</body>
</html>