<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Matricúlate en otro curso</title>

<%@include file="includes.jsp"%>

<script language="javascript" type="text/javascript">

$(document).ready(function()
{
     $("#myModal").modal("show");
});
</script>
</head>
<body>
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Matricúlate en otro
						curso</h4>
				</div>
				<div class="modal-body">

					<div class="form-group">
						<label class="col-xs-3 control-label" for="cursos">Curso</label>
						<div class="col-xs-5">
							<div class="input-group">
								<span class="input-group-addon"><span
									class="glyphicon glyphicon-envelope"></span></span> <span
									class="input-group-addon"><span
									class="glyphicon glyphicon-paperclip"></span></span>
								<form:select id="cursos" name="curso" path="cursos"
									items="${getcursos}" multiple="false" itemValue="idCurso"
									itemLabel="descripcion" class="form-control input-sm" />
							</div>
						</div>
					</div>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
					<button type="button"
						onclick="location.href = 'borrarusuario.do-${user.ssoId}';"
						class="btn btn-primary">Aceptar</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>