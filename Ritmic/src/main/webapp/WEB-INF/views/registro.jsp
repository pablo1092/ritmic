<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Registro de Usuario</title>

<%@include file="includes.jsp" %> 

<script  language="javascript" type="text/javascript" >
$(document).ready(function() {
	
    // Initialize the date picker for the original due date field
    $('#dueDatePicker')
        .datepicker({
       		labelMonthNext: 'Go to the next month',
        	labelMonthPrev: 'Go to the previous month',
        	labelMonthSelect: 'Pick a month from the dropdown',
        	labelYearSelect: 'Pick a year from the dropdown',
        	selectMonths: true,
        	selectYears: true,
          	format: 'dd/mm/yyyy'
        })
        .on('changeDate', function(evt) {
            // Revalidate the date field
            $('#fechaNacimiento').bootstrapValidator('revalidateField', 'fechaNacimiento');
        });

    $('#usuario').bootstrapValidator({
        framework: 'bootstrap',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            nombre: {
                row: '.col-xs-4',
                validators: {
                    notEmpty: {
                        message: 'El nombre no puede estar en blanco'
                    }
                }
            },
            apellidos: {
                row: '.col-xs-4',
                validators: {
                    notEmpty: {
                        message: 'Los apellidos no pueden estar en blanco'
                    }
                }
            },
            direccion: {
                row: '.col-xs-4',
                validators: {
                    notEmpty: {
                        message: 'La dirección no puede estar en blanco'
                    }
                }
            },
            poblacion: {
                row: '.col-xs-4',
                validators: {
                    notEmpty: {
                        message: 'La población no puede estar en blanco'
                    }
                }
            },
            fechaNacimiento: {
                row: '.col-xs-4',
                validators: {
                    notEmpty: {
                        message: 'La fecha de nacimiento no puede estar en blanco'
                    },
                }
            },
            
            
            ssoId: {
                validators: {
                    notEmpty: {
                        message: 'El usuario no puede estar en blanco'
                    },
                    stringLength: {
                        min: 6,
                        max: 30,
                        message: 'Longitud incorrecta. Debe contener en 6 y 30 caracteres'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_\.]+$/,
                        message: 'El campo usuario contiene caracteres no permitidos'
                    }
                }
            },
            
	            email: {
	                validators: {
	                    notEmpty: {
	                        message: 'El correo electrónico es requerido'
	                    },
	                    emailAddress: {
	                        message: 'Correo electrónico introducido incorrecto'
	                    }
	                }
	            },
	            
	            pass: {
	                validators: {
	                    notEmpty: {
	                        message: 'El campo contraseña no puede estar en blanco'
	                    },
	                    different: {
	                        field: 'ssoId',
	                        message: 'La contraseña no puede ser igual al usuario'
	                    }
	                }
	            },
	            
	            confirmpassword: {
	                validators: {
	                    notEmpty: {
	                        message: 'Comfirmar contraseña'
	                    },
	                    identical: {
	                        field: 'pass',
	                        message: 'Las contraseñas deben ser idénticas'
	                    }
	                }
	            },
	            
	            userProfiles: {
	                validators: {
	                    notEmpty: {
	                        message: 'El tipo de usuario no puede estar vacio'
	                    }
	                }
	            },
	            
	            cursos: {
	                validators: {
	                    notEmpty: {
	                        message: 'El curso no puede estar vacio'
	                    }
	                }
	            },
	            
	            agree: {
	                validators: {
	                    notEmpty: {
	                        message: 'Acepto términos y condiciones de uso'
	                    }
	                }
	            }
	        }
	    });
	});

	$(document).ready(function()
	{
	     $("#mostrarmodal").modal("show");
	});

	//Mostramos u ocultamos la opción para elegir curso según tipo de usuario
	$(document).ready(function () {
		toggleFields();
	
	    $("#userProfiles").change(function () {
	        toggleFields();
	    });
	    
	function toggleFields() {
	    if ($("#userProfiles").val() == "1")
	        $("#matriculacurso").show();
	    else
	        $("#matriculacurso").hide();
	}

});

</script>
  
</head>
<body>
<div class="container"> 

<%@include file="cabecera.jsp" %> 
            
	<div class="page-header">
       <h1>Registrar nuevo usuario:</h1>
    </div>
 
    <c:if test="${param.error != null}">                            
	<div class="modal fade" id="mostrarmodal" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
	   <div class="modal-dialog">
	      <div class="modal-content">
	         <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	            <h3>El usuario elegido ya existe.</h3>
	     </div>
	         <div class="modal-body">
	            <h4>Por favor, introduce otro usuario para finalizar el registro</h4> 
	     </div>
	         <div class="modal-footer">
	        <a href="registro.do"  class="btn btn-danger">Cerrar</a>
	     </div>
	      </div>
	   </div>
		</div>
	</c:if>	 

<c:url var="saveUrl" value="/registro.do" />    
<form id="usuario" method="post" modelAttribute="user" class="form-horizontal" action="${saveUrl}">

	<legend> Información Personal </legend>

    <div class="form-group">
        <label class="col-xs-3 control-label">Nombre</label>
        <div class="col-xs-4">
        	<div class="input-group">
        		<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
            	<input type="text" class="form-control" name="nombre" placeholder="Nombre" path="nombre"/>
            </div>	
        </div>
    </div>
    
    <div class="form-group">
     <label class="col-xs-3 control-label">Apellidos</label>
        <div class="col-xs-6">
        	<div class="input-group">
        		<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
            	<input type="text" class="form-control" name="apellidos" placeholder="Apellidos" path="apellidos" />
          	</div>  	
        </div>
    </div>   
    
   <div class="form-group"> 
     <label class="col-xs-3 control-label">Dirección </label>
        <div class="col-xs-6"> 
        	<div class="input-group"> 
        		<span class="input-group-addon"><span class="glyphicon glyphicon-home"></span></span>
            	<input type="text" class="form-control" name="direccion" placeholder="Dirección" path="direccion"  />
            </div>
        </div>
    </div>   
    
    <div class="form-group">
        <label class="col-xs-3 control-label">Población</label>
        <div class="col-xs-4">
        	<div class="input-group"> 
        	    <span class="input-group-addon"><span class="glyphicon glyphicon-road"></span></span>
            	<input type="text" class="form-control" name="poblacion" placeholder="Población" path="poblacion" />
            </div>
        </div>
    </div>
     	
	<div class="form-group">
			<label class="col-xs-3 control-label">F. Nacimiento:</label>
		    <div class="col-xs-3 dateContainer">
            	<div class="input-group input-append date" id="dueDatePicker">
                	<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
                	<input type="text" class="form-control" name="fechaNacimiento" placeholder="F. Nacimiento" path="fechaNacimiento" />
            	</div>
        	</div>
	</div>
    
    <legend> Información de la cuenta </legend>
    
    <div class="form-group">
        <label class="col-xs-3 control-label">Usuario</label>
        <div class="col-xs-5">
        	<div class="input-group"> 
        		<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
            	<input type="text" class="form-control" name="ssoId" placeholder="Usuario" path="ssoId" />
           </div>
        </div>
    </div>

    <div class="form-group">
        <label class="col-xs-3 control-label">Email</label>
        <div class="col-xs-5">
        	<div class="input-group"> 
        		<span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></span>
            	<input type="text" class="form-control" name="email" placeholder="Email" path="email"  />
          	</div>
        </div>
    </div>

    <div class="form-group">
        <label class="col-xs-3 control-label">Contraseña</label>
        <div class="col-xs-5">
        	<div class="input-group"> 
        		<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
            	<input type="password" class="form-control" name="pass" placeholder="Contraseña" path="pass"  />
            </div>
        </div>
    </div>
    
    <div class="form-group">
        <label class="col-xs-3 control-label">Confirmar Contraseña</label>
        <div class="col-xs-5">
        	<div class="input-group"> 
        		<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
            	<input type="password" class="form-control" name="confirmpassword" placeholder="Confirmar Contraseña"  />
            </div>
        </div>
    </div>
    
	 <div class="form-group">
          <label class="col-xs-3 control-label" for="userProfiles">Tipo de usuario</label>
            <div class="col-xs-5">
           		<div class="input-group"> 
           		<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
               		<form:select id="userProfiles" name="userProfiles" path="perfilUsuario" multiple="false" class="form-control input-sm">
               			<form:option value="">-- Selecciona un perfil --</form:option>
       			        <form:options items="${userProfiles}" itemValue="id" itemLabel="type"/>
               		</form:select>
               	</div>
           </div>
    </div>
    
      
    <div id="matriculacurso" class="form-group">   
    	 <legend> Matricúlate en un curso </legend>
    	 
         <label class="col-xs-3 control-label" for="cursos">Curso</label>
            <div class="col-xs-5">
             	<div class="input-group"> 
             		<span class="input-group-addon"><span class="glyphicon glyphicon-paperclip"></span></span>
               		<form:select id="cursos" name="cursos" path="cursos" multiple="false" class="form-control input-sm">
               			 <form:option value="">-- Selecciona un curso --</form:option>
               			 <form:options items="${getcursos}" itemValue="idCurso" itemLabel="descripcion"/>
               		</form:select>
               	</div>
           </div>
    </div>

    <div class="form-group">
        <div class="col-xs-6 col-xs-offset-3">
            <div class="checkbox">
                <label>
                    <input type="checkbox" name="agree" value="agree" /> Acepto los términos y condiciones
                </label>
            </div>
        </div>
    </div>
    
    <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />

    <div class="form-group">
        <div class="col-xs-9 col-xs-offset-3" > 
            <button type="submit" class="btn btn-primary" name="signup" value="Sign up">Registrarse</button>
        </div>
    </div>
  </form>  
  </div>
  </body>
</html>