<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="volandouy.controllers.*"%>
<%@page import="volandouy.servidor.*"%>
<%@ page import="java.net.URLEncoder" %>



<header id="main-header">

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
Integer estadoSesion =(Integer) session.getAttribute("estado_sesion");

	
    if(isMobile && (estadoSesion== null || estadoSesion != 1)){%>
		
        <div class="logo"><img class="volandouy" onclick="location.href ='/volandouy/login?action=login' " src="media/images/logo-uy-png.png"/>  </div>

    <%
        }else{
        %>
        <div class="logo"><img class="volandouy" onclick="location.href ='/volandouy/home' " src="media/images/logo-uy-png.png"/>  </div>
        
        <% 
    }
	
%>
        
        
        <div class="search-container">

            
        </div>
	
        

<%
if(estadoSesion== null || estadoSesion != 1){
%>
	<div class="dropdown">
            <div class="menu-icon">
                <div class="bar"></div>
                <div class="bar"></div>
                <div class="bar"></div>
            </div>

            <div class="dropdown-content">
                <div onclick="location.href ='/volandouy/login?action=login'">Login</div>
                <%
				if(!isMobile){
				%>
                <div onclick="location.href ='/volandouy/login?action=register'">Register</div>
                <%
				}
				%>
            </div>

        </div>

    <div class="ses-container">
        <button class="user-btn" id="btnLogin" onclick="location.href ='/volandouy/login?action=login'">Login</button> 
        <%
		if(!isMobile){
		%>
        <button class="user-btn" id="btnRegistrar" onclick="location.href ='/volandouy/login?action=register'">Register</button> 
        <%
		}
		%>
    </div>
    
   
<%
}else if(estadoSesion == 1){
	Usuario usuarioLogeado = (Usuario)session.getAttribute("usuario_logeado");
	%>
	

        <div class="ses-container-logged" id="isLogged">
            <button class="username-btn" id = "botonNickname"><%= usuarioLogeado.getNickname() %></button> 
                <div class="dropdown-menu-user">
                	<%
					if(!isMobile){
					%>
                    <div onclick="location.href ='/volandouy/usuarios?action=perfil&nickname=<%= URLEncoder.encode(usuarioLogeado.getNickname(), "UTF-8") %>'">Mi perfil</div>
                    <div onclick="location.href ='/volandouy/usuarios?action=modificar&nickname=<%= URLEncoder.encode(usuarioLogeado.getNickname(), "UTF-8") %>'">Modificar Perfil</div>
                    <div onclick="location.href ='/volandouy/login?action=close'">Cerrar sesion</div>
                    
                    <%
					}else if(isMobile){
					%>
					
					<div onclick="location.href ='/volandouy/reservas?action=1' ">Consulta Reserva</div>
					<div onclick="location.href ='/volandouy/reservas?action=Check-in' ">Check-in</div>
					<div onclick="location.href ='/volandouy/login?action=close'">Cerrar sesion</div>

                    <%
					}
					%>
                    
                </div>
        </div>

    
<%
}
%>
    </header>











