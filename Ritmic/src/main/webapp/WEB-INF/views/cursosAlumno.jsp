<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mis cursos</title>

<%@include file="includes.jsp" %>

<script>
$(document).ready(function() {

    $('#cursoCargar').bootstrapValidator({
        framework: 'bootstrap',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        
        fields: {       	 
        	cursoCargar: {
                row: '.col-xs-4',
                validators: {
                    notEmpty: {
                        message: 'Se debe seleccionar un curso'
                    }
                }
            }   
        }

    });
	
    $('#cursoMatricula').bootstrapValidator({
        framework: 'bootstrap',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        
        fields: {       	 
        	cursoMatricula: {
                row: '.col-xs-4',
                validators: {
                    notEmpty: {
                        message: 'Se debes seleccionar un curso'
                    }
                }
            }   
        }

    });

    $(document).ready(function() {	
    	$('#myModal').modal('show');
    });
        
});
</script>
</head>
<body>

	<div class="container">
		<%@include file="cabecera.jsp" %>
		            
		<div class="page-header">
		 	 <h1>Mis cursos:</h1>
		</div>
		
		<p class="bg-info"></p>
		<div class="alert alert-info col-md-7 col-md-offset-2" role="alert">Su curso actual es: <strong>${cursoActual}</strong></div>
		
		<legend> Cargar otro curso: </legend>
		
		<c:if test="${param.cargado != null || param.matriculado != null}">  
			<!-- Modal -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
			        <h4 class="modal-title" id="myModalLabel">¡Enhorabuena!</h4>
			      </div>
			      <div class="modal-body">
				      <div class="alert alert-success alert-dismissable">
				        <i class="fa fa-coffee"></i>
				        	<c:if test="${param.cargado != null}">
				        		<p> Has cargado el curso <strong>${cursoCargado}</strong> correctamente </p>
				        	</c:if>
				        	
				        	<c:if test="${param.matriculado != null}">
				        		<p> Te has matriculado en el curso <strong>${matriculaCurso}</strong> correctamente </p>
				        	</c:if>
				       </div>
			      </div>
			      
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" id="cerrar" data-dismiss="modal">Cerrar</button>
			      </div>
			      
			    </div>
			  </div>
			</div>	
		</c:if>
		
		<c:if test="${param.errormatricular != null || param.errorcargar != null}">  
			<!-- Modal -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
			        <h4 class="modal-title" id="myModalLabel">¡Lo sentimos!</h4>
			      </div>
			      <div class="modal-body">
				      <div class="alert alert-danger alert-dismissable">
				        <i class="fa fa-coffee"></i>
				        	<c:if test="${param.errormatricular != null}">
				        		<p> Error al realizar la matrícula en el curso: <strong>${matriculaCurso}</strong>. Por favor, inténtalo de nuevo. </p>
				      		</c:if>
				      		
				      		<c:if test="${param.errorcargar != null}">
				        		<p> Error al cargar el curso <strong>${cursoCargado}</strong>. Por favor, inténtalo de nuevo. </p>
				      		</c:if>
				       </div>
			      </div>
			      
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" id="cerrar" data-dismiss="modal">Cerrar</button>
			      </div>
			      
			    </div>
			  </div>
			</div>	
		</c:if>
		
		<c:url var="cursoUrl" value="cargarcurso.do" /> 
    	<form id="cursoCargar" method="post" modelAttribute="cursoCargar" class="form-horizontal" action="${cursoUrl}">
			 <div class="form-group">
		        <label class="col-xs-3 control-label" for="cursos">Seleccionar curso</label>
		        <div class="col-xs-5">
	        		<div class="input-group"> 
	             		<span class="input-group-addon"><span class="glyphicon glyphicon-paperclip"></span></span>
	               		<form:select id="cursos" name="cursoCargar" path="cursoCargar" multiple="false" class="form-control input-sm">
		               		<form:option value="">-- Selecciona un curso para cargar --</form:option>
		               		<form:options items="${cargarCursos}" itemValue="idCurso" itemLabel="descripcion"/>
	               		</form:select>
	               	</div>
		        </div>
		    </div>
		    
	    	<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />    
	    	    
		    <div class="form-group">
		        <div class="col-xs-9 col-xs-offset-3" > 
		            <button type="submit" class="btn btn-primary">Cargar curso</button>
			    </div>
		    </div>
	    </form> 
		
		<legend> Matricularse en otro curso: </legend>
		
		 <c:url var="cursoUrl" value="/matriculacion.do" /> 
 		 <form id="cursoMatricula" method="post" modelAttribute="cursoMatricula" class="form-horizontal" action="${cursoUrl}">

			<div class="form-group">
	          <label class="col-xs-3 control-label" for="cursos">Seleccionar Curso</label>
	           	<div class="col-xs-5">
            		<div class="input-group"> 
	            		<span class="input-group-addon"><span class="glyphicon glyphicon-paperclip"></span></span>
	              		<form:select id="cursos" name="cursoMatricula" path="cursoMatricula"  multiple="false"  class="form-control input-sm">
	              			<form:option value="">-- Selecciona un curso para matricularte --</form:option>
	              			<form:options items="${matricularCurso}" itemValue="idCurso" itemLabel="descripcion"/>
	              		</form:select>
              		</div>
              	</div>
              	
              	<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
             </div>
              	
             <div class="form-group">
		        <div class="col-xs-9 col-xs-offset-3" > 
		            <button type="submit" class="btn btn-primary">Matricularse</button>
			    </div>
		    </div>
	    </form> 
	    
	</div>
</body>
</html>