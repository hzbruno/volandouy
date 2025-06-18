<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="volandouy.controllers.*"%>
<%@ page import="volandouy.servidor.*"%>
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

    <jsp:include page="/WEB-INF/clases/template/table-container.jsp" />



     <div class="vuelos-container" id="reserva-container">
<%
VueloArrayDto vuelos = (VueloArrayDto) request.getAttribute("mapVuelos");

for (Vuelo v : vuelos.getVuelo()) {
%>

            <div class="user-box" onclick="location.href='/volandouy/reservas?action=0&vuelo=<%= URLEncoder.encode(v.getNombre() , "UTF-8") %>'">
                <img src="media/images/datos/vuelos/<%= v.getNombre() %>.jpg" onerror="this.onerror=null; this.src='media/images/avion.png';" class="user-image-sm" alt="imagen usuario" />
                <h3><%= v.getNombre() %></h3>
            </div>

<%
}
%>
        </div>