<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="volandouy.controllers.*"%>
<%@ page import="volandouy.servidor.*"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.TreeSet" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/WEB-INF/clases/template/head.jsp" />
    <link rel="stylesheet" href="media/styles/modificar-usuario.css">
</head>
<body>
     <jsp:include page="/WEB-INF/clases/template/header.jsp" />  

<%
Usuario usuarioLogeado =  (Usuario) request.getAttribute("usr");

%>
	<div class="content-container">
        <div class="form-container">
            <form class="register-form" method = "POST" action = "Usuarios" enctype="multipart/form-data">
                <h2>Modificar Datos de Usuario</h2>
    
                <div class="form-section">
                        <input type="hidden" name="nickname" value="<%=usuarioLogeado.getNickname()%>" readonly>

                    <div class="input-container">
                        <label for="vuelo">Nombre</label>
                        <input class="input-container-btn" type="text" name="nombre" value="<%=usuarioLogeado.getNombre()%>" required>
                    </div>
    
	    			<div class="input-container">
		                <label for="pasword">Contraseña</label>
		                <input class="input-container-btn" type="password" id="password" name="password" required>
	                </div>
	                <div class="input-container">
		                <label for="pasword">Confirmar Contraseña</label>
		                <input class="input-container-btn"  type="password" name="confirm_password" id="confirm_password"  required>
	                </div>
    				<div class="input-container">
		                <label for="imagen">Subir imagen:</label>
		    			<input class="input-container-btn" type="file" id="imagen" name="imagen" accept="image/*">
	    			</div>
    			<% 
    			if(usuarioLogeado instanceof Cliente){
    				Cliente clienteLogeado =  (Cliente) request.getAttribute("cli");
    				%>
                <div class="input-container">
                    <label for="apellido">Apellido</label>
                    <input class="input-container-btn" type="text" id="apellido" name="apellido" value="<%=clienteLogeado.getApellido() %>" required>
                </div> 
                <div class="input-container">
                    <label for="nacimiento">Fecha de Nacimiento</label>
                    <%
                    DtFecha fechaNacimiento =clienteLogeado.getFechaDeNacimiento();
                    %>
                    <input class="input-container-btn" type="date" id="fechaNacimiento" name="fechaNacimiento" value="<%=fechaNacimiento.getAnio()%>-<%= (fechaNacimiento.getMes() < 10 ? "0" : "") + fechaNacimiento.getMes() %>-<%= (fechaNacimiento.getDia() < 10 ? "0" : "") + fechaNacimiento.getDia() %>" required> 
                </div>
                <div class="input-container">
                    <label for="country">Nacionalidad</label>    
                    <select class="select-ruta" id="country" name="country" class="form-control" required>
                    <%
                    Set<String> setOrdenado = new TreeSet<>();
                    PaisArrayDto paises = (PaisArrayDto) request.getAttribute("paises");
                   	for(String p : paises.getPaises()){
                   		setOrdenado.add(p);
                   	}

                    for(String pais : setOrdenado){


                    %>
                        <option value="<%= pais %>" <%if(clienteLogeado.getNacionalidad().equals(pais)){%>selected<%}%>><%= pais %></option>

                    <% 
 
                    }
                    %>
                    </select>
				</div>
				<div class="input-container ">
                <label for="documentType">Tipo Documento</label>    
                    <select class="select-ruta" id="documentType" name="documentType" class="form-control" required>
                        <option value="Pasaporte" <%if(clienteLogeado.getTipoDocumento()==EnumDocumento.PASAPORTE){%>selected<%}%>>Pasaporte</option>
                        <option value="DNI" <%if(clienteLogeado.getTipoDocumento()==EnumDocumento.DNI){%>selected<%}%>>DNI</option> 
                    </select>
                </div>
                
                <div class="input-container">
                    <label for="numeroDoc">Numero Documento</label>
                    <input class="input-container-btn" type="text" id="numeroDoc" name="numeroDoc" value="<%=clienteLogeado.getNumeroDocumento() %>" required>
                </div>

    				<%
    			}

    			else if(usuarioLogeado instanceof Aerolinea){
    				Aerolinea aerolineaLogeado =  (Aerolinea) request.getAttribute("aer");

    				%>
    				
				<div class="input-container">
                    <label for="shortDescription">Descripcion General</label>
                    <input type="text" id="shortDescription" name="descripcionGeneral" value="<%=aerolineaLogeado.getDescripcionGeneral() %>" required>
                </div>
                <div class="input-container">
                    <label for="paginaWeb">Pagina Web</label>
                    <input type="url" id="paginaWeb" name="paginaWeb" value="<%=aerolineaLogeado.getSitioWeb() %>" required>
                </div>


    			<%
    			}
    			%>

                    <div class="reservar-container">
                        <button class="reservar-btn" type="submit">Aplicar cambios</button>
                        
                    </div>
                </div>
            </form>
            
            
            
        </div>
    </div>
    
<script>
	var password = document.getElementById("password")
	var confirm_password = document.getElementById("confirm_password");
	function validatePassword(){
	    if(password.value != confirm_password.value) {
	        confirm_password.setCustomValidity("Las contraseñas no son iguales");
	    } else {
	        confirm_password.setCustomValidity('');
	     }
	    }
	
	password.onchange = validatePassword;
	confirm_password.onkeyup = validatePassword;


</script>
 


</body>
</html>