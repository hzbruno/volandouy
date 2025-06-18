<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="volandouy.controllers.*"%>
<%@page import="volandouy.servidor.*"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.net.URLEncoder" %>

<div class="table-container">
	
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

    if (!isMobile) {
%>
     




            <table>
            
<%
Integer estadoSesion =(Integer) session.getAttribute("estado_sesion");
if(estadoSesion== null || estadoSesion != 1){
	%>
                <thead>
                    <tr>
                        <th>Visitante</th>
                    </tr>
                </thead>
                <tbody>
                <tr>
                    <td style="cursor: pointer;" onclick="location.href ='/volandouy/usuarios?action=list'">Consultar Usuarios</td>
                </tr>
                <tr>
                    <td style="cursor: pointer;" onclick="location.href ='/volandouy/Paquetes?action=list'">Consultar Paquetes</td>
                </tr>
                </tbody>
<%	
}else if(estadoSesion == 1){
Usuario usuarioLogeado = (Usuario) session.getAttribute("usuario_logeado");

	%>
				<thead>
                    <tr>
                        <th style="cursor: pointer;" onclick="location.href ='/volandouy/usuarios?action=perfil&nickname=<%= URLEncoder.encode(usuarioLogeado.getNickname(), "UTF-8") %>'">Mi Perfil</th>
                    </tr>
                </thead>
   
	<%

	if(usuarioLogeado instanceof Cliente){
		//cliente
	%>
                <tbody>
                    <tr>
                        <td style="cursor: pointer;" onclick="location.href ='/volandouy/usuarios?action=list'">Consultar Usuarios</td>
                    </tr>
                    <tr>
                        <td style="cursor: pointer;" onclick="location.href ='/volandouy/reservas?action=1' ">Consulta Reserva</td>
                    </tr>
                    <tr>
                    	<td style="cursor: pointer;" onclick="location.href ='/volandouy/Paquetes?action=list'">Consultar Paquetes</td>
                    </tr>
                    <tr>
                    	<td style="cursor: pointer;" onclick="location.href ='/volandouy/reservas?action=list'">Consultar Check-In</td>
                   </tr>
                </tbody>
	
	<%	
	}else if(usuarioLogeado instanceof Aerolinea){
		//aerolinea
	%>	
                <tbody>
                    <tr>
                        <td style="cursor: pointer;" onclick="location.href ='/volandouy/usuarios?action=list'">Consultar Usuarios</td>
                    </tr>
                    <tr>
                        <td style="cursor: pointer;" onclick="location.href ='/volandouy/Rutas?action=crear' ">Nueva Ruta</td>
                    </tr>
                    <tr>
                        <td style="cursor: pointer;" onclick="location.href ='/volandouy/reservas?action=2&aerolinea=<%=usuarioLogeado.getNickname()%>' ">Consulta Reserva</td>
                    </tr> 
                    <tr>
                    <td style="cursor: pointer;" onclick="location.href ='/volandouy/Paquetes?action=list'">Consultar Paquetes</td>
                </tr>
                </tbody>
<%
	}	
}
%> 

                <thead>
                    <tr>
                        <th>Categorías</th>
                    </tr>
                </thead>
                <tbody>

    <%
			CategoriasArrayDto cats = (CategoriasArrayDto) request.getAttribute("Categorias");
			for(String cat:cats.getCategorias()){
    %>
                    <tr>
                        <td style="cursor: pointer;" onclick="location.href ='/volandouy/home?categoria=<%= cat %>'"><%= cat  %></td>
                    </tr>
    <%
}
    %>
                </tbody>
                
                
            </table>
            
            <%
    } else {
%>
        
<%
    }
%>
            

            
        </div>