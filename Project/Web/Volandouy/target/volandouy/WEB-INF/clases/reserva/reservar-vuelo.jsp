<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="volandouy.controllers.*"%>
<%@ page import="volandouy.servidor.*"%>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/WEB-INF/clases/template/head.jsp" />
    <link rel="stylesheet" href="media/styles/reservarVuelo.css">
</head>
<body>
     <jsp:include page="/WEB-INF/clases/template/header.jsp" />  

<%
Vuelo v =  (Vuelo) request.getAttribute("vuelo");
Cliente clienteLogeado =  (Cliente) request.getAttribute("clienteLogeado");

%>
	<div class="content-container">
        <div class="form-container">
            <form class="register-form" method="POST" action="">
                <h2>Reservar Vuelo</h2>
    
                <div class="form-section">
                    <div class="ruta-container">
                        <label for="aerolinea">Aerolinea</label>
                        <input class="input-container-btn-p" type="text" name="aerolinea" value="<%= v.getRutaDeVuelo().getAerolinea()  %>" readonly>
                    </div>
    
                    <div class="ruta-container">
                        <label for="ruta">Ruta</label>
                        <input class="input-container-btn-p" type="text" name="ruta" value="<%=v.getRutaDeVuelo().getNombre()%>" readonly>
                    </div>
    
                    <div class="ruta-container">
                        <label for="vuelo">Vuelo</label>
                        <input class="input-container-btn-p" type="text" name="vuelo" value="<%=v.getNombre()%>" readonly>
                    </div>
    
                    <div class="ruta-container">
                        <label for="asientos">Clase de Asiento</label>
                        <select class="select-ruta" name="tipo-asiento" id="selectAsientos" onchange="selectChange()">
                            <option value="Turista" selected>Turista</option>
                            <option value="Ejecutivo">Ejecutivo</option>
                        </select>
                    </div>
                    
                    <%
                   Integer cantidadRestanteTurista = (Integer) request.getAttribute("cantidadRestanteTurista");
                   Integer cantidadRestanteEjecutivo =(Integer) request.getAttribute("cantidadRestanteEjecutivo");
                   CompraPaquete paqueteCompradoTurista = (CompraPaquete) request.getAttribute("paqueteCompradoTurista");
                   CompraPaquete paqueteCompradoEjecutivo = (CompraPaquete) request.getAttribute("paqueteCompradoEjecutivo");
                   double descuentoT=(double) request.getAttribute("descuentoT");
                   double descuentoE=(double) request.getAttribute("descuentoE");

                    if(cantidadRestanteTurista>0){
                    %>
                    <div class="activar-container" id="activar-container">
            			<label for="paquete-usado">Usar paquete</label>
            			<input type="checkbox" id="paquete-usado" name="paquete-usado" onchange="pasajesInput.dispatchEvent(new Event('input'))">
        			</div>
        			
                        <input type="hidden" name="compra-paquete" value="<%= paqueteCompradoTurista.getPaqueteAsociado().getNombre() %>">
                    
                    <% 
                    }else if(cantidadRestanteEjecutivo>0){
                    	%>
                    <div class="activar-container" id="activar-container" style="display: none;">
            			<label for="paquete-usado">Usar paquete</label>
            			<input type="checkbox" id="paquete-usado" name="paquete-usado" onchange="pasajesInput.dispatchEvent(new Event('input'))">
        			</div>	
        			
                    	<input type="hidden" name="compra-paquete" value="<%= paqueteCompradoEjecutivo.getPaqueteAsociado().getNombre() %>">

                    	<% 
                    }else{
                    %>	
                    <div class="activar-container" id="activar-container" style="display: none;">
            			<label for="paquete-usado">Usar paquete</label>
            			<input type="checkbox" id="paquete-usado" name="paquete-usado" onchange="pasajesInput.dispatchEvent(new Event('input'))">
        			</div>	

                    	<input type="hidden" name="compra-paquete" value=null>
                    	
                    	<% 
                    }
                    %>                    
                    
    				<div class="input-container">
                        <label for="equipaje-extra">Equipaje Extra</label>
                        <input class="input-container-btn" type="number" id="equipaje-extra" value="0" name="equipaje-extra" min="0" onchange="selectChange()" required/>
                    </div>
                    

                    
                    <div class="input-container">
                        <label for="pasajes">Cantidad de Pasajes</label>
                        <input class="input-container-btn" type="number" id="pasajes" name="pasajes" value="0" min="0" required/>
                    </div>
                    
                    <div class="pasajeros-container">
                        <label for="pasajeros">Pasajeros</label>
                    </div>
    
                    <div class="tabla-pasajeros-container">
                        <table class="tabla-pasajeros" id="tabla-pasajeros">
                            <tr>
                                <th class="tabla-pasajeros-td">Nombre</th>
                                <th class="tabla-pasajeros-td">Apellido</th>
                            </tr>
                            <tr>
                                <td class="tabla-pasajeros-row">
                                    <input class="tabla-pasajeros-input" type="text" id="nombre" name="nombre[]"value="<%=clienteLogeado.getNombre()%>" readonly>
                                </td>
                                <td class="tabla-pasajeros-row">
                                    <input class="tabla-pasajeros-input"  type="text" id="apellido" name="apellido[]" value="<%=clienteLogeado.getApellido()%>" readonly>
                                </td>
                            </tr>
                            
                        </table>
                    </div>

					<div class="pasajeros-container">
						<label class="label-precio" for="precio-total">Costo </label>
                        <input id="precio-total"  name="precio-total" value="0" readonly>
                        
                        
                    </div>


                    <div class="reservar-container">
                        <button class="reservar-btn" type="submit">Reservar</button>
                        
                    </div>
                </div>
            </form>
            
            
            
        </div>
    </div>
    
    <script>
    function selectChange() {
    	const div =  document.getElementById('activar-container');
    	if(document.getElementById('selectAsientos').value=="Turista"){
    		if(<%=cantidadRestanteTurista%>>0){
    			
    			div.style.display = 'flex';
    			document.getElementById('paquete-usado').checked = false;
    			
    		}else{
    			div.style.display = 'none';
    			document.getElementById('paquete-usado').checked = false;
    		}
    		precioAsiento=<%=v.getRutaDeVuelo().getCostoBaseTurista()%>;
    		
    	}else{
			if(<%=cantidadRestanteEjecutivo%>>0){
    			div.style.display = 'flex';
    			document.getElementById('paquete-usado').checked = false;

    		}else{
    			div.style.display = 'none';
    			document.getElementById('paquete-usado').checked = false;

    		}
        	precioAsiento=<%=v.getRutaDeVuelo().getCostoBaseEjecutivo()%>;
    		
    	}
    	pasajesInput.dispatchEvent(new Event('input'));

    }
    </script>
    
    
    
    
    <script>
    var precioAsiento;
    var cantidadPasajes=0;
    const pasajesInput = document.getElementById('pasajes');
    const tablaPasajeros = document.getElementById('tabla-pasajeros');
    pasajesInput.addEventListener('input', function() {
		var maxPasajes;

        while (tablaPasajeros.rows.length > 2) {
            tablaPasajeros.deleteRow(tablaPasajeros.rows.length-1);
        }
        var cantAsientosVuelo;
        var cantAsientosPaquete;
		if(document.getElementById('selectAsientos').value=="Turista"){
			cantAsientosVuelo=<%=v.getCantAsientoTurista()%>;
			if(document.getElementById('paquete-usado').checked){
				cantAsientosPaquete=<%=cantidadRestanteTurista%>;
				maxPasajes=Math.min(cantAsientosVuelo,cantAsientosPaquete);
			}
			
			else{
	    		maxPasajes = cantAsientosVuelo;
        		
        	}
        }else{
        	cantAsientosVuelo=<%=v.getCantAsientoEjecutivo()%>;
        	if(document.getElementById('paquete-usado').checked){

				cantAsientosPaquete=<%=cantidadRestanteEjecutivo%>;
				maxPasajes=Math.min(cantAsientosVuelo,cantAsientosPaquete);

				
			}
        	else{
	    		maxPasajes = cantAsientosVuelo;
        		
        	}

        }

        cantidadPasajes = Math.min(parseInt(pasajesInput.value) || 1, maxPasajes);
        document.getElementById('pasajes').value =cantidadPasajes;
        for (let i = 0; i < cantidadPasajes-1; i++) {
            const fila = tablaPasajeros.insertRow();
            const celdaNombre = fila.insertCell();
            celdaNombre.className = 'tabla-pasajeros-row';
            const celdaApellido = fila.insertCell();
            celdaApellido.className = 'tabla-pasajeros-row'

            const inputNombre = document.createElement('input');
            inputNombre.type = 'text';
            inputNombre.name = 'nombre[]';
            inputNombre.className = 'tabla-pasajeros-input';
            inputNombre.required = true;

            const inputApellido = document.createElement('input');
            inputApellido.type = 'text';
            inputApellido.name = 'apellido[]'; 
            inputApellido.className = 'tabla-pasajeros-input';
            inputApellido.required = true;

            celdaNombre.appendChild(inputNombre);
            celdaApellido.appendChild(inputApellido);
        }
        calcularPrecio()
    });
</script>


<script>
	selectChange();
	var costoTotal;
	var equipajeExtra
	var cantidadPasajes=1;
	function calcularPrecio() {
	    equipajeExtra = document.getElementById('equipaje-extra').value*<%=v.getRutaDeVuelo().getCostoEquipajeExtra()%>;
		if(document.getElementById('selectAsientos').value=="Turista"){
			if(document.getElementById('paquete-usado').checked){
				costoTotal = cantidadPasajes*precioAsiento*<%=descuentoT%>+equipajeExtra;
                //costoTotal =  0;
			}
			else{
				costoTotal = cantidadPasajes*precioAsiento+equipajeExtra;
                
			}
		}
		else{
			if(document.getElementById('paquete-usado').checked){
				costoTotal = cantidadPasajes*precioAsiento*<%=descuentoE%>+equipajeExtra;
                //costoTotal =  0;
			}
			else{
				costoTotal = cantidadPasajes*precioAsiento+equipajeExtra;
                
			}
		}
        
        
		document.getElementById('precio-total').value = costoTotal;
		
		
		
	}
	

</script>
    
    
    
    
    
    
</body>
</html>