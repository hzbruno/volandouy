<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="volandouy.controllers.*"%>
<%@ page import="volandouy.servidor.*"%>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.io.File" %>

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


<!DOCTYPE html>
<html lang="es">
<head>
    <jsp:include page="/WEB-INF/clases/template/head.jsp" />
	<link rel="stylesheet" href="media/styles/consulta-usuario.css">
</head>


<body>
<%
Integer estadoSesion =(Integer) session.getAttribute("estado_sesion");
Usuario usuario = (Usuario) request.getAttribute("usr");
%>
      <jsp:include page="/WEB-INF/clases/template/header.jsp" />
      <div class="content-container"> 
        
            <%if (!isMobile) {%>
            <jsp:include page="/WEB-INF/clases/template/table-container.jsp" />
        	<%} %>
        
        
        	<div class="user-container">

            <div class="info-user">
                
         <img src="media/images/datos/usuarios/<%= usuario.getNickname() %>.jpg" onerror="this.onerror=null; this.src='media/images/avatar.png';" class="user-image" alt="imagen usuario" />
                <div class="user-info">
                    <h2 id="nombre"><%= usuario.getNombre()%></h2>
                    <h1 id="correo"><%= usuario.getCorreo()%></h1>
                    <%
                    if(estadoSesion!= null && estadoSesion == 1){
                    	boolean siguiendo = (boolean) request.getAttribute("siguiendo");
                    	Usuario usuarioLogeado = (Usuario)session.getAttribute("usuario_logeado");
	                    
                    	if(!usuarioLogeado.getNickname().equals(usuario.getNickname())){
                    		if(!siguiendo){              	
                            %>
                    			<button class="reservas-btn" id="seguir-btn" onclick="location.href ='/volandouy/usuarios?action=perfil&nickname=<%= URLEncoder.encode(usuario.getNickname(), "UTF-8") %>&follow=true'">Seguir</button>
                            <% 
                    		}else{
		             		%>
		             			<button class="reservas-btn" id="seguir-btn" onclick="location.href ='/volandouy/usuarios?action=perfil&nickname=<%= URLEncoder.encode(usuario.getNickname(), "UTF-8") %>&follow=false'">Dejar de Seguir</button>
		             		<% 
                    	
             				}
                    	}
                    }
                 %>
                </div>
            </div>

<%
if(usuario instanceof Cliente){
	Cliente cli = (Cliente) request.getAttribute("cli");
	DtFecha fechaNac=cli.getFechaDeNacimiento();
%>
            <div class="caja-usr">
                <div class="aero-perfil-container">
                <button class="user-btn">Perfil</button>
                </div>
                <div class="info-user-container" >
                   
                    <div class="infoAerolina">
                        <p><b>Nickname: </b><%= usuario.getNickname()%></p>
                        <p><b>Nombre: </b><%= usuario.getNombre()%></p>
                        <p><b>Apellido: </b><%= cli.getApellido() %></p>
                        <p><b>Email: </b><%= usuario.getCorreo()%></p>
                        <p><b>Fecha de Nacimiento: </b><%=fechaNac.getDia() %>/<%=fechaNac.getMes() %>/<%=fechaNac.getAnio() %><p>
                        <p><b>Tipo de Documento: </b><%= cli.getTipoDocumento() %></p>
                        <p><b>Número de Documento: </b><%= cli.getNumeroDocumento()%></p>
                         </div>
                    </div>

                    <div class="social">
					    <div class="seguidores">
					        
					        <p onclick="togglePopup('popupSeguidores')"><b >Seguidores:</b> <%=usuario.getSeguidores()%></p>
					        <div id="popupSeguidores" class="popup">
					            <span class="close-btn" onclick="togglePopup('popupSeguidores')">&times;</span>
					            <div class="popup-content">
					                <% for (String ss: usuario.getSeguidoresList()) { %>
					                    <div onclick="location.href ='/volandouy/usuarios?action=perfil&nickname=<%= URLEncoder.encode(ss, "UTF-8") %>'">
					                        <p><%= ss %></p>
					                    </div>
					                <% } %>
					            </div>
					        </div>
					    </div>
					
					    <div class="seguidos">
					        <!-- Botón para abrir el popup de seguidos -->
					        <p onclick="togglePopup('popupSeguidos')"><b>Seguidos:</b> <%=usuario.getSeguidos()%></p>
					        <!-- Popup de seguidos -->
					        <div id="popupSeguidos" class="popup">
					            <span class="close-btn" onclick="togglePopup('popupSeguidos')">&times;</span>
					            <div class="popup-content">
					                <% for (String ss: usuario.getSiguiendo()) { %>
					                    <div onclick="location.href ='/volandouy/usuarios?action=perfil&nickname=<%= URLEncoder.encode(ss, "UTF-8") %>'">
					                        <p><%= ss %></p>
					                    </div>
					                <% } %>
					            </div>
					        </div>
					    </div>
					</div>
    
            </div>
<%

//Integer estadoSesion =(Integer) session.getAttribute("estado_sesion");
if(estadoSesion!= null && estadoSesion == 1){
	Usuario usuarioLogeado = (Usuario)session.getAttribute("usuario_logeado");
	if(usuarioLogeado.getNickname().equals(usuario.getNickname())){
		ReservasArrayDto reservas =(ReservasArrayDto) request.getAttribute("reservasCliente" );
		ComprasPaqueteArrayDto comprasP = (ComprasPaqueteArrayDto)request.getAttribute("cpCliente" );
%>     
	</div>
            <div class="reservas">
                <div class="confirmadas">
                <h1 for="reservas">RESERVAS</h1>
                <%
                for(Reserva r :reservas.getReservas()){
                %>
                	<button  class="reservas-btn" , id="reservas-btn" onclick="location.href='/volandouy/Reservas?action=0&vuelo=<%= URLEncoder.encode(r.getVuelo().getNombre(), "UTF-8") %>'"><%= r.getVuelo().getNombre() %></button>
                <% 																							     
                }
                %>
            	</div>
                 <div class="confirmadas">
                <h1 for="reservas">PAQUETES</h1>
                <%
                for(CompraPaquete cp : comprasP.getComprasPaquete()){
                %>
                	<button  class="reservas-btn" , id="reservas-btn" onclick="location.href='/volandouy/Paquetes?action=consultar&nombre=<%= URLEncoder.encode(cp.getPaqueteAsociado().getNombre(), "UTF-8") %>'"><%= cp.getPaqueteAsociado().getNombre() %></button>
                <% 																							     
                }
                %>
                </div>
            </div>
<%
	}else{
        
    }
	
}
%>          
            
          
<%	
}else if(usuario instanceof Aerolinea){
	Aerolinea aer = (Aerolinea) request.getAttribute("aer");
	//Integer estadoSesion =(Integer) session.getAttribute("estado_sesion");
	Usuario usuarioLogeado=null;
	if(estadoSesion!= null && estadoSesion == 1){
		usuarioLogeado = (Usuario)session.getAttribute("usuario_logeado");
	}
	RutaArrayDto rutasAceptadas =(RutaArrayDto) request.getAttribute("rutasAceptadas" );
	
%>	
           
           <div class="caja-usr">
                <div class="aero-perfil-container">
                <button class="user-btn">Perfil</button>
                </div>
                <div class="info-user-container" >
                   
                    <div class="infoAerolina">
                        <p><b>Nombre: </b><%=aer.getNombre() %></p>
                        <p><b>Email: </b><%=aer.getCorreo() %> </p>
                        <p><b>Sitio Web: </b><%=aer.getSitioWeb() %><p>
                        <p><b>Descripcion: </b><%=aer.getDescripcionGeneral() %></p>
                    </div>
                   </div>
                    
                    <div class="social">
					    <div class="seguidores">
					        
					        <p onclick="togglePopup('popupSeguidores')"><b >Seguidores:</b> <%=usuario.getSeguidores()%></p>
					        <div id="popupSeguidores" class="popup">
					            <span class="close-btn" onclick="togglePopup('popupSeguidores')">&times;</span>
					            <div class="popup-content">
					                <% for (String ss: usuario.getSeguidoresList()) { %>
					                    <div onclick="location.href ='/volandouy/usuarios?action=perfil&nickname=<%= URLEncoder.encode(ss, "UTF-8") %>'">
					                        <p><%= ss %></p>
					                    </div>
					                <% } %>
					            </div>
					        </div>
					    </div>
					
					    <div class="seguidos">
					        <!-- Botón para abrir el popup de seguidos -->
					        <p onclick="togglePopup('popupSeguidos')"><b>Seguidos:</b> <%=usuario.getSeguidos()%></p>
					        <!-- Popup de seguidos -->
					        <div id="popupSeguidos" class="popup">
					            <span class="close-btn" onclick="togglePopup('popupSeguidos')">&times;</span>
					            <div class="popup-content">
					                <% for (String ss: usuario.getSiguiendo()) { %>
					                    <div onclick="location.href ='/volandouy/usuarios?action=perfil&nickname=<%= URLEncoder.encode(ss, "UTF-8") %>'">
					                        <p><%= ss %></p>
					                    </div>
					                <% } %>
					            </div>
					        </div>
					    </div>
					</div>
					
					    
                
    
            </div>


                </div>

           <div class="reservas">
               <div class="confirmadas">
                <h1 for="reservas">RUTAS DE VUELO</h1>
                	<div class="otras">
               <%
               for(RutaDeVuelo r :rutasAceptadas.getRutas()){
            	   
                    	
               %>
                	<button  class="reservas-btn" , id="reservas-btn" onclick="location.href='/volandouy/Rutas?action=consultar&nombre=<%=URLEncoder.encode(r.getNombre(), "UTF-8")%>'"><%=r.getNombre()%></button>
                <%
                }
               		
                if(estadoSesion!= null && estadoSesion == 1 && usuarioLogeado.getNickname().equals(aer.getNickname())){
                	RutaArrayDto rutasNoAceptadas = (RutaArrayDto)request.getAttribute("rutasNoAceptadas" );
                %>  
                		</div>
                    </div>
                    <h1 for="reservas">INGRESADAS</h1>
                    <div class="otras">
	                <%
	                for(RutaDeVuelo r :rutasNoAceptadas.getRutas()){
                        if(r.getEstado() == EnumEstado.INGRESADA){
	                %>
                	<button  class="reservas-btn" , id="reservas-btn" onclick="location.href='/volandouy/Rutas?action=consultar&nombre=<%= URLEncoder.encode(r.getNombre(), "UTF-8") %>'"><%= r.getNombre() %></button>
                <% 
                        }
                    }

                    %>
                    </div>
                    <h1 for="reservas">RECHAZADAS</h1>
                    <div class="otras">
	                <%
	                for(RutaDeVuelo r :rutasNoAceptadas.getRutas()){
                        if(r.getEstado() == EnumEstado.RECHAZADA){
	                %>
                	<button  class="reservas-btn" , id="reservas-btn" onclick="location.href='/volandouy/Rutas?action=consultar&nombre=<%= URLEncoder.encode(r.getNombre(), "UTF-8") %>'"><%= r.getNombre() %></button>
                <% 
                        }
                    }

                    %>

                    </div>
                    <h1 for="reservas">FINALIZADAS</h1>
                    <div class="otras">
	                <%
	                for(RutaDeVuelo r :rutasNoAceptadas.getRutas()){
                        if(r.getEstado() == EnumEstado.FINALIZADA){
	                %>
                	<button  class="reservas-btn" , id="reservas-btn" onclick="location.href='/volandouy/Rutas?action=consultar&nombre=<%= URLEncoder.encode(r.getNombre(), "UTF-8") %>'"><%= r.getNombre() %></button>
                <% 
                        }
                    }

                    %>
                    <%

                }           
                %>
                    </div>


                
           </div>
     
           
<%            
}	
%>	     
        

        
        
      </div>

<script>
function togglePopup(id) {
    var popup = document.getElementById(id);
    if (popup.style.display === "block") {
        popup.style.display = "none";
    } else {
        popup.style.display = "block";
    }
}

// Cerrar el popup cuando se hace clic fuera de él
window.onclick = function(event) {
    var popups = document.getElementsByClassName('popup');
    for (var i = 0; i < popups.length; i++) {
        if (event.target === popups[i]) {
            popups[i].style.display = "none";
        }
    }
}
</script>

</body>