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
AerolineasArrayDto aerolineasMap = (AerolineasArrayDto) request.getAttribute("aerolineasMap");

for (Aerolinea aero : aerolineasMap.getAerolineas()) {
%>

            <div class="user-box" onclick="location.href='/volandouy/reservas?action=2&aerolinea=<%= URLEncoder.encode(aero.getNickname(), "UTF-8") %>'">
                <img src="media/images/datos/usuarios/<%= aero.getNickname() %>.jpg" onerror="this.onerror=null; this.src='media/images/avatar.png';" class="user-image-sm" alt="imagen usuario" />
                <h3><%= aero.getNickname() %></h3>
            </div>

<%
}
%>
        </div>