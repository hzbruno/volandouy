<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="volandouy.controllers.*"%>
<%@ page import="volandouy.servidor.*"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
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
%>
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
            if(r.getCliente().getNickname().equals(c.getNickname()) && r.isCheck() && r.getVuelo().getNombre().equals(request.getParameter("vuelo"))){ 
            	DtFecha fecha=r.getVuelo().getFecha();
        %>

            <div class="vuelo-item">
                <!--agregar el nombre del vuelo -->
                <img src="media/images/datos/vuelos/<%= request.getParameter("vuelo") %>.jpg" onerror="this.onerror=null; this.src='media/images/avion.png';" class="user-image-sm" alt="imagen usuario" />
                <h1 class="vuelo-nombre">Reserva al vuelo <%= request.getParameter("vuelo") %></h1>         
                <h1 class="vuelo-nombre">Pasajeros :</h1>

                <% 
                    List<Pasaje> pasajes = r.getPasajes();
                    for(Pasaje p : pasajes){
                %>
                <div class="datos-container">
                    <h3 class="vuelo-fechaAlta"><%= p.getNombre()%> <%= p.getApellido()%> - Asiento : <%= p.getNumeroAsiento()%></h3>
                </div>

                <%
                }
                %>

                <div class="datos-container">
                    <h2 class="vuelo-duracion"><b>Duración del Vuelo:</b> <%=r.getVuelo().getDuracion().getHora() %>:<%=r.getVuelo().getDuracion().getMinuto() %></h2>
                    <h2 class="vuelo-fechaAlta"><b>Fecha del Vuelo:</b> <%=fecha.getDia() %>/<%=fecha.getMes() %>/<%=fecha.getAnio() %></h2>
                </div>

               


            </div>

        <%
        }   
    }
}else{
        for(Reserva r : reservas.getReservas()){
%>

            <div class="vuelo-item">
                <!--agregar el nombre del vuelo -->
                <img src="media/images/datos/vuelos/<%= request.getParameter("vuelo") %>.jpg" onerror="this.onerror=null; this.src='media/images/avion.png';" class="user-image-sm" alt="imagen usuario" />
                <h1 class="vuelo-nombre">Reserva al vuelo <%= request.getParameter("vuelo") %></h1>         
                <h1 class="vuelo-nombre">Pasajeros :</h1>

                <% 
                    List<Pasaje> pasajes = r.getPasajes();
                    for(Pasaje p : pasajes){
                %>
                <div class="datos-container">
                    <h3 class="vuelo-fechaAlta"><%= p.getNombre()%> <%= p.getApellido()%> - Asiento : <%= p.getNumeroAsiento() %> </h3>
                </div>

                <%
                }
                %>

                <div class="datos-container">
                    <h2 class="vuelo-duracion"><b>Duración del Vuelo:</b> <%=r.getVuelo().getDuracion().toString() %></h2>
                    <h2 class="vuelo-fechaAlta"><b>Fecha del Vuelo:</b> <%= r.getVuelo().getFecha()%></h2>
                </div>
               
            </div>
   
    <%
            }
        }  
%>

        	
</div>