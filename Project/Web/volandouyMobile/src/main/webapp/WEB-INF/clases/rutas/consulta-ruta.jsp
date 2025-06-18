 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="volandouyMobile.controllers.*"%>
<%@ page import="volandouyMobile.servidor.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.net.URLEncoder" %>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/WEB-INF/clases/template/head.jsp" />
	<link rel="stylesheet" href="media/styles/consulta-ruta.css">
	<link rel="stylesheet" href="media/styles/vuelo.css">


</head>
<body>
	<jsp:include page="/WEB-INF/clases/template/header.jsp" />


    <div class="content-container">




<%


	RutaDeVuelo ruta = (RutaDeVuelo) request.getAttribute("Ruta");
	DtFecha fechaAlta = ruta.getFechaDeAlta();
	DtHora hora = ruta.getHora();


%>

        <div class="rutas-container">

            <div class="vuelo-item">
                <img src="media/images/datos/rutas/<%= ruta.getNombre() %>.jpg" onerror="this.onerror=null; this.src='media/images/ruta.jpg';" class="ruta-img" alt="imagen ruta" />
                <h2 class="ruta-nombre"><%=ruta.getDescripcionCorta() %></h2>  
                <p class="ruta-descripcion"><b>Descripción: </b><%= ruta.getDescripcion() %></p>
                <p class="ruta-origen"><b>Ciudad Origen: </b><%= ruta.getOrigen().getNombre() %>, <%= ruta.getOrigen().getPais() %></p>
                <p class="ruta-destino"><b>Ciudad Destino: </b><%= ruta.getDestino().getNombre() %>, <%= ruta.getDestino().getPais() %></p>
                <p class="ruta-hora"><b>Hora: </b><%= String.format("%02d", hora.getHora()) %>:<%= String.format("%02d", hora.getMinuto()) %></p>
                <p class="ruta-turista"><b>Costo Turista (USD): </b><%= ruta.getCostoBaseTurista()%></p>
                <p class="ruta-ejecutivo"><b>Costo Ejecutivo (USD): </b><%=ruta.getCostoBaseEjecutivo() %></p>
                <p class="ruta-extra"><b>Costo Equipaje Extra (USD): </b><%=ruta.getCostoEquipajeExtra() %></p>
                <p class="ruta-alta"><b>Fecha de Alta: </b><%=fechaAlta.getDia() %>/<%=fechaAlta.getMes() %>/<%=fechaAlta.getAnio() %></p>
                <p class="ruta-estado"><b>Estado: </b><%= ruta.getEstado() %></p>
                <p class="ruta-categorias"><b>Categorias: </b> <%=String.join(", ", ruta.getCategorias()) %></p>
            </div>
    	
        </div>



        <div class="vuelos">

            <h1 for="vuelos">VUELOS</h1>
            <%

            ArrayList<Vuelo> vuelos =(ArrayList<Vuelo>) request.getAttribute("VuelosValidos");
            for(Vuelo v : vuelos){

            %>
        		<button  class="vuelo-btn" id="vuelo-btn" onclick="location.href='/volandouyMobile/vuelos?action=consultar&nombre=<%= URLEncoder.encode(v.getNombre(), "UTF-8") %>'"><%= v.getNombre() %></button>
            <% 
            }
            %>
    
		</div>



    </div>
</body>
</html>