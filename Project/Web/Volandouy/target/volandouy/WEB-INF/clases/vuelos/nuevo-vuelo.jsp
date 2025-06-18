<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="volandouy.controllers.*"%>
<%@ page import="volandouy.servidor.*"%>
<%@ page import="java.net.URLEncoder" %>
    
    
    
    
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/WEB-INF/clases/template/head.jsp" />
    <link rel="stylesheet" href="media/styles/altaVuelo.css">
</head>
<body>
     <jsp:include page="/WEB-INF/clases/template/header.jsp" />  
<%
  RutaDeVuelo ruta = (RutaDeVuelo) request.getAttribute("Ruta");
  Aerolinea aerolineaLogeada = (Aerolinea) request.getAttribute("aerolineaLogeada");
  DtFecha fechaActual = (DtFecha) request.getAttribute("fechaActual");
  String fechaActualS = fechaActual.getAnio()+"-"+fechaActual.getMes()+"-"+fechaActual.getDia();
  %>

      <div class="content-container"> 
        
        
      <div class="form-container">
        <form class="register-form" method = "POST" action = "" enctype="multipart/form-data">
            <h2>Crear Vuelo</h2>

            <div class="from-section"> 
            	<div class="input-container">
	                <label for="imagen">Subir imagen:</label>
	    			<input type="file" id="imagen" name="imagen" accept="image/*">
	    		</div>
                <div class="ruta-container-input">
                    <label for="rutaVuelo">Ruta de vuelo</label>
                    <input class="input-container-btn-p" type="text" name="rutaVuelo" value="<%=ruta.getNombre() %>" readonly>
                </div>
                <div class="input-container">
                    <label for="nombre">Nombre</label>
                    <input type="text" id="nombre" name="nombreVuelo" required>
                </div>
                <div class="input-container">
                    <label for="fecha">Fecha</label>
                    <input type="date" id="fecha" name="fecha" min="<%= fechaActualS %>"  required/>
                </div>
                <div class="input-container">
                    <label for="duration">Duracion</label>
                    <input type="time" id="duration" name="hora" required />
                </div>

                <div class="input-container">
                    <label for="asientosTurista">Cantidad Asientos Turista</label>
                    <input type="asientosTurista" id="asientosTurista" name="asientosTurista" required>
                </div>
                <div class="input-container">
                    <label for="asientosEjecutivos">Cantidad Asientos Ejecutivos</label>
                    <input type="asientosEjecutivos" id="asientosEjecutivos" name="asientosEjecutivos" required>
                </div>

                
            </div>
	        <button class="login-btn"  type = "submit"> Registrar Nuevo Vuelo </button>
            </form>


        
        </div>
      </div>

</body>
</html>