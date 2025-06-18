<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="volandouyMobile.controllers.*"%>
<%@ page import="volandouyMobile.servidor.*"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/clases/template/head.jsp" />
    <link rel="stylesheet" href="media/styles/consultaReservaCliente.css">
    <link rel="stylesheet" href="media/styles/consultar-usuarios.css">
</head>
<body>
    
    <jsp:include page="/WEB-INF/clases/template/header.jsp" />


    <div class="content-container">

     <div class="vuelos-container" id="reserva-container">
<%
RutaArrayDto mapaRutas = (RutaArrayDto) request.getAttribute("mapaRutas");

for (RutaDeVuelo ruta : mapaRutas.getRutas()) {
%>

            <div class="user-box" onclick="location.href='/volandouyMobile/reservas?action=3&ruta=<%= URLEncoder.encode(ruta.getNombre() , "UTF-8") %>'">
                <img src="media/images/datos/rutas/<%= ruta.getNombre() %>.jpg" onerror="this.onerror=null; this.src='media/images/ruta.jpg';" class="user-image-sm" alt="imagen usuario" />
                <h3><%= ruta.getNombre() %></h3>
            </div>

<%
}
%>
        </div>