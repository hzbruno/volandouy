<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="volandouyMobile.controllers.*"%>
<%@page import="volandouyMobile.servidor.*"%>
<%@ page import="java.net.URLEncoder" %>



<header id="main-header">

<%
Integer estadoSesion =(Integer) session.getAttribute("estado_sesion");

	
    if(estadoSesion== null || estadoSesion != 1){
        %>
		
        <div class="logo"><img class="volandouy" onclick="location.href ='/volandouyMobile/login?action=login' " src="media/images/logo-uy-png.png"/>  </div>

    <%
        }else{
        %>
        <div class="logo"><img class="volandouy" onclick="location.href ='/volandouyMobile/home' " src="media/images/logo-uy-png.png"/>  </div>
        
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
                <div onclick="location.href ='/volandouyMobile/login?action=login'">Login</div>
            </div>

        </div>

    <div class="ses-container">
        <button class="user-btn" id="btnLogin" onclick="location.href ='/volandouyMobile/login?action=login'">Login</button> 

    </div>
    
   
<%
}else if(estadoSesion == 1){
	Usuario usuarioLogeado = (Usuario)session.getAttribute("usuario_logeado");
	%>
	

        <div class="ses-container-logged" id="isLogged">
            <button class="username-btn" id = "botonNickname"><%= usuarioLogeado.getNickname() %></button> 
                <div class="dropdown-menu-user">
				
					<div onclick="location.href ='/volandouyMobile/reservas?action=1' ">Consulta Reserva</div>
					<div onclick="location.href ='/volandouyMobile/reservas?action=Check-in' ">Check-in</div>
					<div onclick="location.href ='/volandouyMobile/login?action=close'">Cerrar sesion</div>            
                </div>
        </div>

    
<%
}
%>
    </header>











