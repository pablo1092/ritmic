<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script  language="javascript" type="text/javascript" >
$(document).ready(function() {
    $('#actividad').bootstrapValidator({
        framework: 'bootstrap',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        
        fields: {       	 
        	idTipoActividad: {
                row: '.col-xs-4',
                validators: {
                    notEmpty: {
                        message: 'El tipo de actividad es obligatorio'
                    }
                }
            },
            
            file: {
                row: '.col-xs-4',
                validators: {
                    notEmpty: {
                        message: 'Por favor, selecciona un fichero'
                    },
	            file: {
	                extension: 'xml,musicxml',
	                type: 'text/xml,text/musicxml',
	                maxSize: 2097152,   // 2048 * 1024
	                message: 'El fichero seleccionado no es válido. Revise extensión y tamaño'
	               }
                }
            },
            
        	idCurso: {
                row: '.col-xs-4',
                validators: {
                    notEmpty: {
                        message: 'El curso es obligatorio'
                    }
                }
            },
            
            descripActividad: {
                row: '.col-xs-4',
                validators: {
                    notEmpty: {
                        message: 'La descripción es obligatoria'
                    }
                }
            },
            
            dificultadActividad: {
                row: '.col-xs-4',
                validators: {
                    notEmpty: {
                        message: 'La dificultad de la actividad es obligatoria'
                    }
                }
            },
        }
    });
});
</script>
</head>
<body>

<c:if test="${param.crearactividad != null}">
	<br></br>
	<div class="col-sm-8">
      <div class="alert alert-success alert-dismissable">
        <a class="panel-close close" data-dismiss="alert">×</a> 
        <i class="fa fa-coffee"></i>
        	<p> La actividad: <strong>${activCreada}</strong> se ha creado correctamente </p>
       </div>
     </div>
</c:if>

<c:if test="${param.erroractividad != null}">
	<br></br>
	<div class="col-sm-8">
      <div class="alert alert-danger alert-dismissable">
        <a class="panel-close close" data-dismiss="alert">×</a> 
        <i class="fa fa-coffee"></i>
        	<p> Error al crear la actividad: <strong>${activCreada}</strong>. Por favor, prueba de nuevo.</p>
       </div>
     </div>
</c:if>

<c:if test="${empty cursos}">
	<br></br>
	<div class="col-md-7 col-md-offset-2">
		<div class="alert alert-danger alert-dismissable">
			<a class="panel-close close" data-dismiss="alert">×</a> <i
				class="fa fa-coffee"></i>
			<p>
				<strong>Por favor, cree un curso previamente para crear
					una actividad</strong>
			</p>
		</div>
	</div>
</c:if>

<div class="form-container">
   <br></br>
   
	<legend> Crea una nueva actividad: </legend>



	<c:url var="saveUrl" value="/gestionprofesor/crearactividad.do" />    
	<form id="actividad" method="post" class="form-horizontal" action="${saveUrl}" enctype="multipart/form-data">
	 
	   <div class="form-group"> 
            <label class="col-xs-3 control-label">Tipo Actividad</label>
            <div class="col-xs-4">
   				<div class="input-group">
   					<span class="input-group-addon"><span class="glyphicon glyphicon-paperclip"></span></span>
           			<form:select path="idTipoActividad" name="idTipoActividad" multiple="false" class="form-control input-sm">
           				<form:option value="">-- Selecciona un tipo de Actividad --</form:option>
           				<form:options items="${tipoActividades}" itemValue="idtipoActividad" itemLabel="tipo"/>
               		</form:select>
           		</div>
    		</div>
        </div>
	   
	   <div class="form-group"> 
            <label class="col-xs-3 control-label">Seleccionar fichero</label>
            <div class="col-xs-6">
				<div class="input-group">
					<span class="input-group-addon"><span class="glyphicon glyphicon-file"></span></span>
	                
	                <form:input type="file" name="file" path="file" id="file" class="form-control input-sm"/>
	                <div class="has-error">
	                     <form:errors path="file" class="help-inline"/>
	                </div>
              </div>
            </div>
        </div>
   	 
        <div class="form-group"> 
           <label class="col-xs-3 control-label" for="cursos">Curso</label>
           <div class="col-xs-4">
  				<div class="input-group">
  					<span class="input-group-addon"><span class="glyphicon glyphicon-paperclip"></span></span>
          			<form:select path="idCurso" name="idCurso" multiple="false" class="form-control input-sm">
          				<form:option value="">-- Selecciona un curso --</form:option>
           				<form:options items="${cursos}" itemValue="idCurso" itemLabel="descripcion"/>
               		</form:select>
          		</div>
   		   </div>
         </div>
         
        <div class="form-group">
	        <label class="col-xs-3 control-label">Descripción</label>
	        <div class="col-xs-6">
	        	<div class="input-group">
	        		<span class="input-group-addon"><span class="glyphicon glyphicon-pencil"></span></span>
	            	<input type="text" class="form-control" name="descripActividad" placeholder="Descripcion" path="descripActividad"/>
	            </div>	
	        </div>
    	</div>
    	
    	<div class="form-group">
	        <label class="col-xs-3 control-label">Nivel de dificultad</label>
	        <div class="col-xs-4">
	        	<div class="input-group">
		        	<span class="input-group-addon"><span class="glyphicon glyphicon-signal"></span></span>
		            <select class="form-control" name="dificultadActividad">
		                <option value="">-- Elige la dificultad --</option>
		                <option value="1">Dificultad 1</option>
		                <option value="2">Dificultad 2</option>
		                <option value="3">Dificultad 3</option>
		                <option value="4">Dificultad 4</option>
		                <option value="5">Dificultad 5</option>
		            </select>
		        </div>
	        </div>
    	</div>
    	
    	<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
           
         <div class="form-group"> 
             <div class="form-actions floatRight col-xs-9 col-xs-offset-3">
                 <input type="submit" value="Crear Actividad" class="btn btn-primary btn-sm">
             </div>
         </div>
   </form>
</div>
</body>
</html>