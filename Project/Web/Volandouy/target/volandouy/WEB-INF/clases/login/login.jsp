<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <jsp:include page="/WEB-INF/clases/template/head.jsp" />
    <link rel="stylesheet" href="media/styles/registrar.css">
	<style>
		.sin-after::after {
			content: none !important;
		}
	
	        
	</style>
</head>
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

<body>
      <jsp:include page="/WEB-INF/clases/template/header.jsp" />
 

      <div class="content-container"> 
        
        
      <div class="form-container"> 
        
        <form class="register-form" action="/volandouy/login" method="post" >
            
            <h2>Login</h2>

            <div class="from-section">
                
                <input type="hidden" name="mobile" value="<%= isMobile %>">
                
                
                <div class="input-container">
                    <label for="username">Nombre Usuario</label>
                    <input type="text" id="username" name="username" required>
                </div>
                <div class="input-container">
                    <label for="pasword">Contraseña</label>
                    <input type="password" id="password" name="password" required>
                </div>
				<input type="hidden" name="action" value="login">
            </div>
            <label class="sin-after" style="color:red;">${error}</label>
            <button class="login-btn" type="submit"> Iniciar Sesión </button>
			<% 
			if(!isMobile){
			%>
            <div class="sign-in-message" onclick="location.href ='/volandouy/login?action=register'">Crear cuenta</div>
			<% 
			}
			%>

        </form>

        </div>
      </div>


</body>