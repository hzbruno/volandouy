 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="volandouy.servidor.*"%>
<%@ page import="java.util.TreeSet" %>
<%@ page import="java.util.Set" %>


<!DOCTYPE html>
<html lang="es">
<head>
    <jsp:include page="/WEB-INF/clases/template/head.jsp" />
    <link rel="stylesheet" href="media/styles/registrar.css">

</head>
<body>
     <jsp:include page="/WEB-INF/clases/template/header.jsp" />  

      <div class="content-container"> 
        
        
      <div class="form-container">
        <form class="register-form" method = "POST" action = "" enctype="multipart/form-data">
            <h2>Registrar</h2>
            
            
            <div class="from-section"> 
                <div class="input-container">
                    <label for="username">Nombre Usuario</label>
                    <input type="text" id="username" name="username" required>
                </div>
                <div class="input-container">
                    <label for="name">Nombre</label>
                    <input type="text" id="name" name="name" required>
                </div>
                <div class="input-container">
                <label for="pasword">Contraseña</label>
                <input type="password" id="password" name="password" required>
                </div>
                <div class="input-container">
                <label for="pasword">Confirmar Contraseña</label>
                <input type="password" name="confirm_password" id="confirm_password"  required>
                </div>
                 
                <div class="input-container">
                    <label for="email">Correo</label>
                    <input type="email" id="email" name="email" required>
                </div>
                <div class="input-container">
	                <label for="imagen">Subir imagen:</label>
	    			<input type="file" id="imagen" name="imagen" accept="image/*">
	    		</div>

            </div>
                    <select class="select-user" name="tipo-usuario" id="register-option" onchange="showSelectionType()">
                        <option disabled selected value> -- selecciona una opción -- </option>
                        <option value="Cliente">Cliente</option>
                        <option value="Aerolinea">Aerolinea</option>
        
                    </select>

            <div class="from-section cliente-container" style="display: none;">
                <div class="input-container">
                    <label for="apellido">Apellido</label>
                    <input type="text" id="apellido" name="apellido" required>
                </div> 
                <div class="input-container">
                    <label for="nacimiento">Fecha de Nacimiento</label>
                    <input type="date" id="fechaNacimiento" name="fechaNacimiento" value="2024-09-25" />
                </div>
                <div class="input-container">
                    <label for="country">Nacionalidad</label>    
                    <select id="country" name="country" class="form-control">
                    
                    <%
                    		
                    Set<String> setOrdenado = new TreeSet<>();
                    PaisArrayDto paises = (PaisArrayDto) request.getAttribute("paises");
                  	for(String p : paises.getPaises()){
                  		setOrdenado.add(p);
                  	}

                    for(String pais : setOrdenado){
                    %>
                    	
                        <option value="<%= pais %>"><%= pais%></option>

                    <% 	
                    }
                    %>

                    </select>
                </div>

                <div class="input-container ">
                <label for="documentType">Tipo Documento</label>    
                    <select id="documentType" name="documentType" class="form-control">
                        <option value="Pasaporte">Pasaporte</option>
                        <option value="DNI">DNI</option> 
                    </select>
                </div>
                <div class="input-container">
                    <label for="numeroDoc">Numero Documento</label>
                    <input type="text" id="numeroDoc" name="numeroDoc" required>
                </div>

            </div>

            <div class="from-section aerolinea-container" style="display: none;">
                <div class="input-container">
                    <label for="shortDescription">Descripcion General</label>
                    <input type="text" id="shortDescription" name="shortDescription" required>
                </div>
                <div class="input-container">
                    <label for="paginaWeb">Pagina Web</label>
                    <input type="url" id="paginaWeb" name="paginaWeb" required>
                </div>
            </div>

        <button class="login-btn" type="submit"> Registrarse </button>
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


          
      function showSelectionType() {  
    	   let select = document.getElementById("register-option");
    	   let selectedValue = select.value; 

    	   let divCliente = document.querySelector(".cliente-container");
    	   let divAerolinea = document.querySelector(".aerolinea-container");

    	   if (!divCliente || !divAerolinea) {
    	       return; 
    	   }

    	   if (selectedValue === "Cliente") {
    	       divAerolinea.style.display = "none";
    	       divCliente.style.display = "block"; 
    	       
    	       document.getElementById("apellido").setAttribute("required", "")
    	       document.getElementById("fechaNacimiento").setAttribute("required", "")
    	       document.getElementById("numeroDoc").setAttribute("required", "")
    	       
    	       document.getElementById("shortDescription").removeAttribute("required");
    	       document.getElementById("paginaWeb").removeAttribute("required");
   
    	   } else if (selectedValue === "Aerolinea") {
    	       divCliente.style.display = "none"; 
    	       divAerolinea.style.display = "block";
    	       
    	       document.getElementById("shortDescription").setAttribute("required", "")
    	       document.getElementById("paginaWeb").setAttribute("required", "")
    	       
    	       document.getElementById("apellido").removeAttribute("required");
    	       document.getElementById("fechaNacimiento").removeAttribute("required");
    	       document.getElementById("numeroDoc").removeAttribute("required");
    	       
    	   }
    	}
      
      </script> 
     

</body>

