<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ranking</title>

<%@include file="includes.jsp" %> 
 
<link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css"></link>
<script type="text/javascript" src="resources/js/libs/jquery.dataTables.min.js"></script>


<script>
$(document).ready(function() {

    $('#cursoRanking').bootstrapValidator({
        framework: 'bootstrap',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        
        fields: {       	 
        	cursosProfesor: {
                row: '.col-xs-4',
                validators: {
                    notEmpty: {
                        message: 'Se debe seleccionar un curso'
                    }
                }
            }   
        }

    });
});

$(document).ready(function(){
    $('#myTable').dataTable();
});
</script>
</head>
<body>

<div class="container"> 

<%@include file="cabecera.jsp" %> 
 
<div class="widget stacked widget-table action-table">
    					
		<div class="page-header">
		 	 <h1>Ranking de puntuaciones</h1>
		</div>
			
		<sec:authorize access="hasRole('Profesor')">
			<br></br>
			<c:url var="cursoUrl" value="/cargarranking.do" /> 
	 		 <form id="cursoRanking" method="post" modelAttribute="cursoMatricula" class="form-horizontal" action="${cursoUrl}">
	
				<div class="form-group">
		          <label class="col-xs-3 control-label" for="cursos">Cargar ranking para</label>
		           	<div class="col-xs-5">
	            		<div class="input-group"> 
		            		<span class="input-group-addon"><span class="glyphicon glyphicon-paperclip"></span></span>
		              		<form:select id="cursos" name="cursosProfesor" path="cursosProfesor"  multiple="false"  class="form-control input-sm">
		              			<form:option value="">-- Selecciona un curso para cargar el ranking --</form:option>
		              			<form:options items="${cursosProfesor}" itemValue="idCurso" itemLabel="descripcion"/>
		              		</form:select>
	              		</div>
	              	</div>
	              	
	              	<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
	             </div>
	              	
	             <div class="form-group">
			        <div class="col-xs-9 col-xs-offset-3" > 
			            <button type="submit" class="btn btn-primary">Seleccionar</button>
				    </div>
			    </div>
		    </form>

			<hr></hr>
		</sec:authorize>	
			
		<c:choose>
			<c:when test="${cursoActual.descripcion == null}">
				<div class="alert alert-danger col-md-7 col-md-offset-2" role="alert"><Strong>No ha cargado ningún curso.</Strong> Por favor, selecciona uno de ellos para visualizar el Ranking</div>
			</c:when>
			<c:otherwise>
				<div class="alert alert-success col-md-7 col-md-offset-2" role="alert">Ranking de puntuaciones obtenidas en curso: <strong> ${cursoActual.descripcion}</strong></div>
			</c:otherwise>
		</c:choose>
		
		</div> 
			<br></br>
			<br></br>
			<br></br>

			<table id="myTable"> 
				<thead>
					<tr>
						<th>Usuario</th>
						<th>Nombre</th>
						<th>Apellidos</th>
						<th>Puntuación media</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listaAlumnos}" var="Alumno" varStatus="loop">
						<tr>
							<td>${Alumno.ssoId}</td>
							<td>${Alumno.nombre}</td>
							<td>${Alumno.apellidos}</td>
							
							<c:choose>
								<c:when test="${Alumno.puntuacionMedia == 'NaN'}">
								    <td>No ha realizado ninguna actividad</td>
								</c:when>
								<c:otherwise>
									<td>${Alumno.puntuacionMedia}</td>
								</c:otherwise>
							</c:choose>
						</tr>
			    	</c:forEach>
			    </tbody>
			</table>
		</div> 	
</body>
</html>