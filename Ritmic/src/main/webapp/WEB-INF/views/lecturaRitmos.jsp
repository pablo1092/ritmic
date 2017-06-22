<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lectura de Ritmos</title>

<%@include file="includes.jsp" %> 

<script type="text/javascript" src="resources/js/libs/hammer.min.js"></script>    
<script type="text/javascript" src="resources/js/libs/beep.js"></script>  
<script type="text/javascript" src="resources/js/libs/sound.js"></script>  

<script type="text/javascript">
	$(document).ready(function() {
		var tiemposClicksAlumno = [];
		var elementoPulsable = document.getElementById('tab1');

		// TO-DO Ahora hago sonar un metrónomo a 60 bps
		$('#grabar').click(function() {	
			
			$("#grabar").attr("disabled", true);
			
			//Iniciamos metrónomo
			iniciaMetronomo(60);
			
			//Iniciamos cuenta atrás
			var count = 5;
			var number = document.getElementById('numero');
			var intervalo = setInterval(function() {
				count--;
				number.innerHTML = count;
				if(count == 1) {
					number.innerHTML = "¿Preparado?"
				}
				if (count == 0) {
					number.innerHTML = "¡YA!"
					clearInterval(intervalo);
					
					//Empezamos a grabar
					tiemposClicksAlumno = [];
					startTime = new Date().getTime();					
					var mc = new Hammer(elementoPulsable);
					mc.on("tap", function(ev) {
						var t = new Date().getTime() - startTime;
			        	if (!isNaN(t)) {
			  		        	tiemposClicksAlumno.push(t);
			  		        	$("#parar").attr("disabled", false);
			      		    	console.log("Array: " + tiemposClicksAlumno.length);
			       		} else {
			  	        		console.log("t es nan: " + t);
			       		}
			  	    		return false;
					});
				}
			}, 1000);
		});
		
		$('#parar').click(function() {
			paraMetronomo();	
			var ejecucion = document.getElementById('ejecucion').value=tiemposClicksAlumno;
		});
	});
</script>

<script language="javascript" type="text/javascript">
	$(document).ready(function()
	{
	    $("#myModal").modal("show");
	});
</script>

</head>
<body>

<div class="container"> 

<%@include file="cabecera.jsp" %>

		<c:if test="${empty actividadadCargar}">
			<div class="col-md-7 col-md-offset-2">
				<div class="alert alert-danger alert-dismissable">
					<a class="panel-close close" data-dismiss="alert">×</a> <i
						class="fa fa-coffee"></i>
					<p>
						El curso:  <strong>${curso.descripcion}</strong> no tiene actividades vinculadas
					</p>
				</div>
			</div>
		</c:if>

		<c:if test="${not empty actividadadCargar}">
			<h1>${actividadadCargar.descripActividad}</h1>

			<c:if test="${not empty puntuacion}">
				<!-- Modal -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				  <div class="modal-dialog">
				    <div class="modal-content">
				      <div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				        <h4 class="modal-title" id="myModalLabel">Tu puntuación</h4>
				      </div>
				      <div class="modal-body">
					      <div class="alert alert-success alert-dismissable">
					        <i class="fa fa-coffee"></i>
					        	La puntuacion obtenida ha sido de: <strong>${puntuacion}</strong>
								punto/s
					       </div>
				      </div>
				      
				      <div class="modal-footer">
				        <button type="button" class="btn btn-default" id="cerrar" data-dismiss="modal">Cerrar</button>
				      </div>
				      
				    </div>
				  </div>
				</div>	
			</c:if>

			<!-- ${indiceMenor}  -->
			<!-- ${indiceMayor} -->
			<!-- ${totalActividades} -->
			
			<h1 align=center id="numero"></h1>
			
			<c:set var="musicXML" value="${contenidoActividadCargar}" scope="request"/>
			<c:set var="id" value="partitura" scope="request"/>
			<jsp:include page="partitura.jsp"/>
		
			<button  id="grabar" type="button" class="btn btn-primary btn-lg col-md-4 col-md-offset-1">Realizar actividad</button>
			
			<div class="form-group">
				<c:url var="corregirUrl" value="/corregir.do" /> 
			    <form id="form" method="get" class="form-horizontal" action="${corregirUrl}">
					<button  id="parar" type="submit" class="btn btn-primary btn-lg col-md-4 col-md-offset-1" disabled>Corregir actividad</button>
					
					<input type="hidden" id="ejecucion" name="ejecucion" value=""/>
				</form>
			</div>
			<br></br>	
			<br></br>
			
			<p align=center>Toque el ritmo pulsando sobre este recuadro	</p>
			
			<button  id="tab1" class="btn btn-default center-block" style="width: 420px; height: 150px;" type="button">
				<img src="resources/images/iconoPercu.png">
			</button>

			<ul class="pager">
				<c:if test="${indiceMenor>=0}">
					<li class="previous"><a href="actividadanterior">&larr; Anterior</a></li>
				</c:if>
				<c:if test="${indiceMenor<0}">
					<li class="previous disabled"><a>&larr; Anterior</a></li>
				</c:if>
				<c:if test="${indiceMayor>=totalActividades}">
					<li class="next disabled"><a>Siguiente &rarr;</a></li>
				</c:if>
				<c:if test="${indiceMayor<totalActividades}">
					<li class="next"><a href="actividadsiguiente">Siguiente &rarr;</a></li>
			    </c:if>
			</ul>
		</c:if>

	</div>
</body>
</html>