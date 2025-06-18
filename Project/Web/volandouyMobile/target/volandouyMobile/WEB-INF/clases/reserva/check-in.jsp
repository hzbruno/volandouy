<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="volandouyMobile.controllers.*"%>
<%@ page import="volandouyMobile.servidor.*"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/clases/template/head.jsp" />
    <link rel="stylesheet" href="media/styles/checkIn.css">
    <link rel="stylesheet" href="media/styles/consultar-usuarios.css">
</head>
<body>
    
    <jsp:include page="/WEB-INF/clases/template/header.jsp" />


    <div class="content-container">

     <div class="vuelos-container" id="reserva-container">


<%
Cliente c = (Cliente) request.getAttribute("Cliente");
ReservasArrayDto reservas = (ReservasArrayDto) request.getAttribute("Reservas");
        for(Reserva r: reservas.getReservas()){
            
            if(!r.isCheck()){ 
            	DtFecha fecha=r.getVuelo().getFecha();
            	
        %>

            <div class="vuelo-item">
                
                <img src="media/images/datos/vuelos/<%= r.getVuelo().getNombre() %>.jpg" onerror="this.onerror=null; this.src='media/images/avion.png';" class="user-image-sm" alt="imagen usuario" />
                <h1 class="vuelo-nombre">Reserva al vuelo <%= r.getVuelo().getNombre() %></h1>         
                <h1 class="vuelo-nombre">Pasajeros :</h1>

                <% 
                    List<Pasaje> pasajes = r.getPasajes();
                    for(Pasaje p : pasajes){
                %>
                <div class="datos-container">
                    <h3 class="vuelo-fechaAlta"><%= p.getNombre()%> <%= p.getApellido()%></h3>
                </div>

                <%
                }
                %>

                <div class="datos-container">
                    <p class="vuelo-fechaAlta"><b>Costo: </b> <%= (int)(r.getCosto())%></p>
                    <h2 class="vuelo-fechaAlta"><b>Fecha del Vuelo:</b> <%=fecha.getDia() %>/<%=fecha.getMes() %>/<%=fecha.getAnio() %></h2>
                </div>
                
				<div class="datos-container">
                    <button class="aerolinea-btn" onclick="location.href='/volandouyMobile/reservas?action=makeCheck&vuelo=<%= URLEncoder.encode(r.getVuelo().getNombre(), "UTF-8") %>&cliente=<%=c.getNickname()%>'" id="aerolinea-btn" > Check-In </button> 
				</div>
				

            </div>

        <%
        }   
    }
%>


</div>
