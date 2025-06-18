<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="volandouy.controllers.*"%>
<%@ page import="volandouy.servidor.*"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.TreeMap" %>
<%@ page import="java.util.HashMap" %>

<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/WEB-INF/clases/template/head.jsp" />
	<link rel="stylesheet" href="media/styles/altaRutaVuelo.css">
</head>
<body>
<jsp:include page="/WEB-INF/clases/template/header.jsp" />

	<div class="content-container"> 

<%


Usuario usuarioLogeado = (Usuario)session.getAttribute("usuario_logeado");
Map<String, Map<String, Ciudad>> ciudades =(Map<String, Map<String, Ciudad>>) request.getAttribute("Ciudades");
CategoriasArrayDto categorias = (CategoriasArrayDto) request.getAttribute("Categorias");


%>   
        
      <div class="form-container">
        <form class="register-form" method = "POST" action = "" enctype="multipart/form-data">
            <h2>Crear Ruta de Vuelo</h2>
            
            
            <div class="from-section"> 
             	<input type="hidden" id="datosObjeto" name="aerolinea" value="<%= usuarioLogeado.getNickname() %>">
            	<div class="input-container">
	                <label for="imagen">Subir imagen:</label>
	    			<input type="file" id="imagen" name="imagen" accept="image/*">
	    		</div>
                <div class="input-container">
                    <label for="nombre">Nombre</label>
                    <input type="text" id="nombre" name="nombre" required>
                </div>
                <div class="input-container">
                    <label for="descripcion">Descripcion Corta</label>
                    <input type="text" id="descripcionC" name="descripcionC" required>
                </div>
                <div class="input-container">
                    <label for="descripcion">Descripcion</label>
                    <input type="text" id="descripcion" name="descripcion" required>
                </div>
                <div class="input-container">
                    <label for="costoT">Costo base turista</label>
                    <input type="costoT" id="costoT" name="costoT" required>
                </div>
                <div class="input-container">
                    <label for="costoE">Costo base ejecutivo</label>
                    <input type="costoE" id="costoE" name="costoE" required>
                </div>
                <div class="input-container">
                    <label for="costoExtra">Costo equipaje extra</label>
                    <input type="costoExtra" id="costoExtra" name="costoExtra" required>
                </div>
                <div class="input-container">
                    <label for="hora">Hora</label>
                    <input type="time" id="hora" name="hora" required />
                </div>
                <div class="input-container">
                    <label for="country">Ciudad de Origen</label>    
                    <select id="country" name="countryO" class="form-control">                 
                        <%

                        Map<String, Map<String, Ciudad>> mapaOrdenado = new TreeMap<>(ciudades);
                        for (String pais : mapaOrdenado.keySet()) {
                            for (String ciudad : mapaOrdenado.get(pais).keySet()) {
                            	System.out.println(pais + ", " + ciudad);
                                %>
                                <option value="<%=pais + ", " + ciudad%>"><%=pais + ", " + ciudad%></option>
                                <%
                            }
                        }
                        %>

                    </select>
                </div>
                    <div class="input-container">
                        <label for="country">Ciudad de Destino</label>    
                        <select id="country" name="countryD" class="form-control">
                        <%
                        for (String pais : mapaOrdenado.keySet()) {
                            for (String ciudad : mapaOrdenado.get(pais).keySet()) {
                                %>
                                <option value="<%=pais + ", " + ciudad%>"><%=pais + ", " + ciudad%></option>
                                <%
                            }
                        }
                        %>
                        </select>
                    </div>
                    <div class="input-container">
                        <label for="country">Categorías</label>    
                        <select id="categorias" name="categorias" class="form-control" multiple>
                        <%
                            for(String i : categorias.getCategorias()){
                                %>
                                    <option value="<%=i%>"><%=i%></option>
                                <%
                            }
                        %>
                        </select>
                    </div>
                    
                    </div>
            
        		<button class="login-btn" type = "submit"> Registrar Nueva Ruta </button>
            </form>
       


         </div>
        </div>
      </div>
      
      
</body>
</html>