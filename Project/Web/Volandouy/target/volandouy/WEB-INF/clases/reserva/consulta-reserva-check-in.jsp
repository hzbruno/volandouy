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
Cliente c = (Cliente) request.getAttribute("Cliente");

ReservasArrayDto reservas = (ReservasArrayDto) request.getAttribute("Reservas");
if(c!= null){
        for(Reserva r : reservas.getReservas()){
            if(r.isCheck()){ 
        %>
            <div class="user-box" onclick="location.href='/volandouy/reservas?action=check&vuelo=<%= URLEncoder.encode(r.getVuelo().getNombre(), "UTF-8") %>'">
                <img src="media/images/datos/vuelos/<%= r.getVuelo().getNombre() %>.jpg" onerror="this.onerror=null; this.src='media/images/avion.png';" class="user-image-sm" alt="imagen usuario" />
                <h3 class="vuelo-nombre">Reserva al vuelo <%= r.getVuelo().getNombre() %></h3> 
            </div>
<%
			}
		}
	}
%>
        </div>
</div>

