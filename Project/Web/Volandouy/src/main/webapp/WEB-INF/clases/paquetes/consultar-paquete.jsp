 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="volandouy.controllers.*"%>
<%@ page import="volandouy.servidor.*"%>
<%@ page import="java.net.URLEncoder" %>
    
    
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/WEB-INF/clases/template/head.jsp" />
	<link rel="stylesheet" href="media/styles/consultar-paquete.css">


</head>
<body>
	<jsp:include page="/WEB-INF/clases/template/header.jsp" />


    <div class="content-container">

    <jsp:include page="/WEB-INF/clases/template/table-container.jsp" />



<%


	Paquete paquete = (Paquete) request.getAttribute("paquete");


%>

        <div class="paquete-container">

            <div class="paquete-item">
            
                <img src="media/images/datos/paquetes/<%= paquete.getNombre() %>.jpg" onerror="this.onerror=null; this.src='media/images/paquete.png';" class="paquete-image" alt="imagen usuario" />
                <h2 class="paquete-nombre"><%=paquete.getNombre() %></h2>  
                <p class="paquete-descripcion"><b>Descripción: </b><%= paquete.getDescripcion() %></p>
                <p class="paquete-descuento"><b>Descuento: </b><%= paquete.getDescuento() %></p>
                <p class="paquete-duracion"><b>Duracion (dias): </b><%= paquete.getDuracionDias() %></p>
                <p class="paquete-costo"><b>Costo (USD): </b><%= (int)paquete.getCosto() %></p>
            </div>
<%          
Integer estadoSesion =(Integer) session.getAttribute("estado_sesion");
if(estadoSesion!= null && estadoSesion == 1){
	Usuario usuarioLogeado = (Usuario)session.getAttribute("usuario_logeado");
		if(usuarioLogeado instanceof Cliente){		

				%>
				<form method = "POST" action = "">
				
					<input type="hidden" name="usuario" value="<%= usuarioLogeado.getNickname() %>">
					<input type="hidden" name="paquete" value="<%= paquete.getNombre() %>">
				
					<button type=submit class="user-btn" id=comprar-btn  > Comprar Paquete </button>
				
				</form>
				
				
				<%	
			
		}
	}
		
%>     

        </div>

        <div class="rutas">
            
            <h1 for="rutas">RUTAS</h1>
            
            <%
            PaquetesRutaArrayDto paqRutas = (PaquetesRutaArrayDto) request.getAttribute("paqueteRutas");

            for(PaqueteRuta pr : paqRutas.getPaquetesRuta()){
                	
            %>
            	<div class="ruta-item">
            		<label >cantidad: <%= pr.getCantidad() %></label>
            		<label ><%= pr.getTipoAsiento() %></label>
	        		<button class="ruta-btn"  id="ruta-btn" onclick="location.href='/volandouy/Rutas?action=consultar&nombre=<%= URLEncoder.encode(pr.getRutaAsociada().getNombre(), "UTF-8") %>'" > <%= pr.getRutaAsociada().getNombre() %> </button>
            	</div>
            <% 
               
            }
            %>
    
		</div>



    </div>
</body>
</html>