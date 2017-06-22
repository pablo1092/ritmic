<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
$(document).ready(function() {	
	$('#myModal').modal('show');
});

$(document).on("click", function(e){
    if($(e.target).is("#botonactividad")){
      $("#formactividad").show();
    }
});
</script>
</head>
<body> 

	<c:if test="${param.cargarfichero != null}">		
		<!-- Modal -->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
		        <h4 class="modal-title" id="myModalLabel">Fichero cargado</h4>
		      </div>
		      <div class="modal-body">
			      <div class="alert alert-success alert-dismissable">
			        <i class="fa fa-coffee"></i>
			        	El fichero se ha cargado correctamente
			       </div>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" id="botonactividad" data-dismiss="modal">Continuar con la creación</button>
		        <button type="button" class="btn btn-primary" data-dismiss="modal" data-dismiss="modal">Cargar otro fichero</button>
		      </div>
		    </div>
		  </div>
		</div>	
	</c:if>
 
    <div class="form-container">
       	<br></br>
	    
	    <legend> Nuevo Fichero: </legend>
        
        <c:url var="saveUrl" value="/gestionprofesor/crearfichero.do"/>
        <form id="fileForm" method="POST" modelAttribute="file" action="${saveUrl}" enctype="multipart/form-data" class="form-horizontal" >
                
	        <div class="form-group"> 
                <div class="form-group col-md-12">
                    <label class="col-xs-3 control-label" for="tipoActividad">Seleccionar fichero</label>
                    <div class="col-xs-7">
	   					<div class="input-group">
		   					<span class="input-group-addon"><span class="glyphicon glyphicon-paperclip"></span></span>
	                        <form:input type="file" name="file" path="file" id="file" class="form-control input-sm"/>
	                        <div class="has-error">
	                            <form:errors path="file" class="help-inline"/>
	                        </div>
	                     </div>
                    </div>
                </div>
            </div>
	        
	        <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
	        
	        <div class="form-group">
                <div class="form-actions floatRight col-xs-9 col-xs-offset-3">
                    <input type="submit" value="Cargar Fichero" class="btn btn-primary btn-sm">
                </div>
            </div>     
       </form>
       
       <c:url var="saveUrl" value="/gestionprofesor/crearactividad.do" />    
		<form id="formactividad" method="post" modelAttribute="actividad" style="display:none;" class="form-horizontal" action="${saveUrl}">
		 
	   		<div class="form-group"> 
	            <label class="col-xs-3 control-label" for="tipoActividad">Tipo Actividad</label>
	            <div class="col-xs-4">
	   				<div class="input-group">
	   					<span class="input-group-addon"><span class="glyphicon glyphicon-paperclip"></span></span>
	           			<form:select path="idTipoActividad" name="idTipoActividad" items="${tipoActividades}" multiple="false" itemValue="idtipoActividad" itemLabel="tipo" class="form-control input-sm" />
	           		</div>
	    		</div>
	        </div>
		        
	        <div class="form-group"> 
	           <label class="col-xs-3 control-label" for="cursos">Curso</label>
	           <div class="col-xs-4">
	  				<div class="input-group">
	  					<span class="input-group-addon"><span class="glyphicon glyphicon-paperclip"></span></span>
	          			<form:select path="idCurso" name="idCurso" items="${cursos}" multiple="false" itemValue="idCurso" itemLabel="descripcion" class="form-control input-sm" />
	          		</div>
	   		   </div>
	         </div>
	         
	        <div class="form-group">
		        <label class="col-xs-3 control-label">Descripción</label>
		        <div class="col-xs-6">
		        	<div class="input-group">
		        		<span class="input-group-addon"><span class="glyphicon glyphicon-paperclip"></span></span>
		            	<input type="text" class="form-control" name="descripActividad" placeholder="Descripcion" path="descripActividad"/>
		            </div>	
		        </div>
	    	</div>
	    	
	    	<div class="form-group">
		        <label class="col-xs-3 control-label">Nivel de dificultad</label>
		        <div class="col-xs-4">
		        	<div class="input-group">
			        	<span class="input-group-addon"><span class="glyphicon glyphicon-paperclip"></span></span>
			            <select class="form-control" name="dificultadActividad">
			                <option value="">Elige la dificultad</option>
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
