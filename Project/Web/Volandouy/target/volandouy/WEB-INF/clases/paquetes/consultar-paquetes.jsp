<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="volandouy.controllers.*"%>
<%@ page import="volandouy.servidor.*"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Set" %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/clases/template/head.jsp" />
    <link rel="stylesheet" href="media/styles/consultar-paquetes.css">
</head>
<body>
    
    <jsp:include page="/WEB-INF/clases/template/header.jsp" />


    <div class="content-container">

    <jsp:include page="/WEB-INF/clases/template/table-container.jsp" />
     <div class="vuelos-container" id="reserva-container">


<%

        String error = (String) request.getAttribute("error");
		if(error!=null){
			
			%>
			<script> 
			alert("<%=error %>");
			</script>
			
			<% 
		}
		PaqueteArrayDto paquetes = (PaqueteArrayDto) request.getAttribute("paquetes");

        for(Paquete p : paquetes.getPaquetes()){
        %>

            <div class="vuelo-item"  onclick="location.href='/volandouy/Paquetes?action=consultar&nombre=<%= URLEncoder.encode(p.getNombre(), "UTF-8") %>'">
                <!--agregar el nombre del vuelo -->
                <img src="media/images/datos/paquetes/<%= p.getNombre() %>.jpg" onerror="this.onerror=null; this.src='media/images/paquete.png';" class="user-image-sm" alt="imagen usuario" />
                <h1 class="vuelo-nombre"><%= p.getNombre() %></h1>         
                <h3 class="vuelo-nombre"><%= p.getDescripcion() %></h3>    
				<h2 class="vuelo-nombre">Descuento: <%= p.getDescuento() %></h2>
				<h2 class="vuelo-nombre">Costo: <%= (int)p.getCosto() %></h2>

			</div>
	<% 
	}
%>
</div>



