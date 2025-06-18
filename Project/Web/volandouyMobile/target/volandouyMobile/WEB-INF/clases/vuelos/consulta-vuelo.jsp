 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="volandouyMobile.controllers.*"%>
<%@ page import="volandouyMobile.servidor.*"%>
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




<%

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

        </div>



        <div class="Aerolinea-Ruta">
     
            <h1 for="ruta">Ruta</h1>       
          <%
             String nombreVuelo = URLEncoder.encode(vuelo.getNombre(), "UTF-8");
          %>
        <button class="aerolinea-btn" onclick="location.href='/volandouyMobile/Rutas?action=consultar&nombre=<%= URLEncoder.encode(vuelo.getRutaDeVuelo().getNombre(), "UTF-8") %>'"><%= vuelo.getRutaDeVuelo().getNombre() %></button>  

            
            
        </div>

    </div>





</body>
</html>