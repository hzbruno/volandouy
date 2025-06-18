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

<body>
      <jsp:include page="/WEB-INF/clases/template/header.jsp" />
 

      <div class="content-container"> 
        
        
      <div class="form-container"> 
        
        <form class="register-form" action="/volandouyMobile/login" method="post" >
            
            <h2>Login</h2>

            <div class="from-section">            
                
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

        </form>

        </div>
      </div>


</body>