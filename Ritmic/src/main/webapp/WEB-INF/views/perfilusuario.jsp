<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Información Cuenta</title>

<%@include file="includes.jsp"%>

<script language="javascript" type="text/javascript">
$(document).ready(function() {
	
	$('#usuario').bootstrapValidator({
        framework: 'bootstrap',
        icon: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {       	 
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
                    }
                }
            },
            
            confirmpassword1: {
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
        }
    });
});

$(document).on("click", function(e){
    if($(e.target).is("#botonPass")){
      $("#actualizarPass").toggle();
    }
});
</script>

</head>
<body>
	<div class="container">

		<%@include file="cabecera.jsp"%>

		<div class="page-header">
			<h1>Datos del usuario:</h1>
		</div>

		<c:url var="saveUrl" value="/actualizarusuario.do" />
		<form id="usuario" class="form-horizontal" method="post"
			modelAttribute="user" action="${saveUrl}">

			<div class="alert alert-info alert-dismissable">
				<a class="panel-close close" data-dismiss="alert">×</a> <i
					class="fa fa-coffee"></i> <strong>Importante:</strong>. Sólo se
				podrá modificar la información permitida por el sistema.
			</div>

			<legend> Información Personal </legend>

			<div class="form-group">
				<label class="col-xs-3 control-label">Nombre</label>
				<div class="col-xs-4">
					<div class="input-group">
						<span class="input-group-addon"><span
							class="glyphicon glyphicon-user"></span></span> <input type="text"
							class="form-control" name="nombre" placeholder="Nombre"
							value="${user.nombre}" readonly>
					</div>
				</div>
			</div>

			<div class="form-group">
				<label class="col-xs-3 control-label">Apellidos</label>
				<div class="col-xs-6">
					<div class="input-group">
						<span class="input-group-addon"><span
							class="glyphicon glyphicon-user"></span></span> <input type="text"
							class="form-control" name="apellidos" placeholder="Apellidos"
							value="${user.apellidos}" readonly>
					</div>
				</div>
			</div>

			<div class="form-group">
				<label class="col-xs-3 control-label">Dirección </label>
				<div class="col-xs-6">
					<div class="input-group">
						<span class="input-group-addon"><span
							class="glyphicon glyphicon-home"></span></span> <input type="text"
							class="form-control" name="direccion" placeholder="Dirección"
							value="${user.direccion}" />
					</div>
				</div>
			</div>

			<div class="form-group">
				<label class="col-xs-3 control-label">Población</label>
				<div class="col-xs-4">
					<div class="input-group">
						<span class="input-group-addon"><span
							class="glyphicon glyphicon-road"></span></span> <input type="text"
							class="form-control" name="poblacion" placeholder="Población"
							value="${user.poblacion}" />
					</div>
				</div>
			</div>

			<div class="form-group">
				<fmt:formatDate pattern='dd-MM-yyyy' value="${user.fechaNacimiento}"
					type='date' var="formatedDate" />
				<label class="col-xs-3 control-label">F. Nacimiento:</label>
				<div class="col-xs-3 dateContainer">
					<div class="input-group input-append date" id="dueDatePicker">
						<span class="input-group-addon add-on"><span
							class="glyphicon glyphicon-calendar"></span></span> <input type="text"
							class="form-control" name="fechaNacimiento"
							value="${formatedDate}" readonly />
					</div>
				</div>
			</div>

			<legend> Información de la cuenta </legend>

			<div class="form-group">
				<label class="col-xs-3 control-label">Tipo de Usuario</label>
				<div class="col-xs-5">
					<div class="input-group">
						<span class="input-group-addon"><span
							class="glyphicon glyphicon-user"></span></span> <input type="text"
							class="form-control" name="ssoId" placeholder="Usuario"
							value="${user.ssoId}" readonly />
					</div>
				</div>
			</div>

			<div class="form-group">
				<label class="col-xs-3 control-label">Email</label>
				<div class="col-xs-5">
					<div class="input-group">
						<span class="input-group-addon"><span
							class="glyphicon glyphicon-envelope"></span></span> <input type="text"
							class="form-control" name="email" placeholder="Email"
							value="${user.email}">
					</div>
				</div>
			</div>

			<legend> Más opciones: </legend>

			<div class="form-group">
				<div class="col-xs-9 col-xs-offset-0">
					<button type="button" id="botonPass" class="btn btn-primary"
						name="pass" value="pass">Actualizar Contraseña</button>

					<!-- Button trigger modal -->
					<button type="button" class="btn btn-primary" data-toggle="modal"
						data-target="#myModal">Borrar Cuenta</button>

					<!-- Modal -->
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal">
										<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
									</button>
									<h4 class="modal-title" id="myModalLabel">Eliminar Cuenta</h4>
								</div>
								<div class="modal-body">Estás seguro de que deseas
									eliminar tu cuenta?</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">Cerrar</button>
									<button type="button"
										onclick="location.href = 'borrarusuario.do-${user.ssoId}';"
										class="btn btn-primary">Aceptar</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div id="actualizarPass" style="display: none;" class="form-group">
				<div class="form-group">
					<label class="col-xs-3 control-label">Contraseña</label>
					<div class="col-xs-5">
						<div class="input-group">
							<span class="input-group-addon"><span
								class="glyphicon glyphicon-lock"></span></span> <input type="password"
								class="form-control" name="pass" placeholder="Contraseña" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="col-xs-3 control-label">Confirmar Contraseña</label>
					<div class="col-xs-5">
						<div class="input-group">
							<span class="input-group-addon"><span
								class="glyphicon glyphicon-lock"></span></span> <input type="password"
								class="form-control" name="confirmpassword"
								placeholder="Confirmar Contraseña" />
						</div>
					</div>
				</div>
			</div>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />

			<legend> </legend>

			<div class="form-group">
				<div class="col-xs-9 col-xs-offset-5">
					<button type="submit" class="btn btn-primary" name="update"
						value="Sign up">Guardar cambios</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>