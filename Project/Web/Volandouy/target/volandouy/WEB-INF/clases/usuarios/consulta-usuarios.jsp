<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="volandouy.controllers.*"%>
<%@page import="volandouy.servidor.*"%>
<%@page import="java.util.List"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.io.File" %>


<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/WEB-INF/clases/template/head.jsp" />
    
	<link rel="stylesheet" href="media/styles/consultar-usuarios.css">
    <link rel="stylesheet" href="media/styles/consulta-usuario.css">
</head>
<body>
	<jsp:include page="/WEB-INF/clases/template/header.jsp" />
	<div class="content-container">
	
	    <jsp:include page="/WEB-INF/clases/template/table-container.jsp" />
		
        <div class="users-container">
<%
List<Usuario> usrs = (List<Usuario>) request.getAttribute("usrs");

for(Usuario usr:usrs){
	%>
	
			<div class="user-box" onclick="location.href ='/volandouy/usuarios?action=perfil&nickname=<%= URLEncoder.encode(usr.getNickname(), "UTF-8") %>'">
			
		    <img src="media/images/datos/usuarios/<%= usr.getNickname() %>.jpg" onerror="this.onerror=null; this.src='media/images/avatar.png';" class="user-image-sm" alt="imagen usuario" />
        
                <h3><%= usr.getNombre() %></h3>
            </div>


<%
}
%>

    	</div>

    </div>


</body>
</html>