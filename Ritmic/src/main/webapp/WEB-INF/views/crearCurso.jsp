<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    
<script>
$(document).ready(function() {
    $('#curso').bootstrapValidator({
        framework: 'bootstrap',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        
        fields: {       	 
        	descripcion: {
                row: '.col-xs-4',
                validators: {
                    notEmpty: {
                        message: 'La descripción de la actividad no puede estar en blanco'
                    }
                }
            },   
        }

    });
});
</script>
</head>
<body> 

<br></br>
  
<c:if test="${param.crearcurso != null}">
	<div class="col-sm-8">
      <div class="alert alert-success alert-dismissable">
        <a class="panel-close close" data-dismiss="alert">×</a> 
        <i class="fa fa-coffee"></i>
        	<p> El curso: <strong>${cursoCreado}</strong> se ha creado correctamente </p>
       </div>
     </div>
</c:if>

<c:if test="${param.errorcurso != null}">
	<div class="col-sm-8">
      <div class="alert alert-danger alert-dismissable">
        <a class="panel-close close" data-dismiss="alert">×</a> 
        <i class="fa fa-coffee"></i>
        	<p> Error al crear el curso: <strong>${cursoCreado}</strong>. Por favor, prueba de nuevo. </p>
       </div>
     </div>
</c:if>
 
<div class="container"> 

    <c:url var="cursoUrl" value="/gestionprofesor/crearcurso.do" /> 
    <form id="curso" method="post" class="form-horizontal" action="${cursoUrl}">
	    
	    <legend> Crea un nuevo curso: </legend>
	    
	    <br></br>
	
	    <div class="form-group">
	        <label class="col-xs-3 control-label">Descripción del curso</label>
	        <div class="col-xs-5">
	        	<div class="input-group">
	        		<span class="input-group-addon"><span class="glyphicon glyphicon-pencil"></span></span>
	            	<input type="text" class="form-control" name="descripcion" placeholder="Descripción" path="descripcion"/>
	            </div>	
	        </div>
	    </div> 
	  	
	  	<br></br>
	  	
	  	 <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
	    	    
	    <div class="form-group">
	        <div class="col-xs-9 col-xs-offset-3" > 
	            <button type="submit" class="btn btn-primary" name="signup" value="Sign up">Guardar curso</button>
		    </div>
	    </div>
	    
    </form>
</div>
</body>
</html>
