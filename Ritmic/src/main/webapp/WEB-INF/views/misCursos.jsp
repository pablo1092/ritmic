<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>

<link rel="stylesheet"
	href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css"></link>
<link rel="stylesheet"
	href="https://cdn.datatables.net/responsive/2.1.1/css/responsive.bootstrap.min.css"></link>
<script type="text/javascript"
	src="resources/js/libs/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.15/js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/responsive/2.1.1/js/dataTables.responsive.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/responsive/2.1.1/js/responsive.bootstrap.min.js"></script>
<script>
$(document).ready(function(){
    $('#myTable').dataTable({
    	info:     false,	
    	paging:   false, 
    	searching: false,
    	responsive: true});
});
</script>
</head>
<body>
	<div class="container">

		<br></br>

		<legend> Selecciona un curso: </legend>

		<c:if test="${empty cursos}">
			<div class="col-md-7 col-md-offset-2">
				<div class="alert alert-danger alert-dismissable">
					<a class="panel-close close" data-dismiss="alert">×</a> <i
						class="fa fa-coffee"></i>
					<p>
						<strong>Todavía no se ha creado ningún curso</strong>
					</p>
				</div>
			</div>
		</c:if>

		<div class="row">
			<div class="col-md-4">
				<div class="list-group">
					<c:forEach items="${cursos}" var="cursos" varStatus="loop">
						<a href="gestionprofesor/cargaralumnos.do-${cursos.idCurso}"
							class="list-group-item">${cursos.descripcion}</a>
					</c:forEach>
				</div>
			</div>

			<c:if test="${param.misalumnos != null}">
				<div class="col-md-8">
					<div class="panel panel-info">
						<div class="panel-heading">
							<h3 class="panel-title">Alumnos matriculados en curso:
								<strong>${cursoCargado}</strong></h3>
						</div>

						<table id="myTable" >
							<thead>
								<tr>
									<th>#</th>
									<th>Nombre</th>
									<th>Apellidos</th>
									<th>Usuario</th>
									<th>Email</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${alumnos}" var="alumnos" varStatus="loop">
									<tr>
										<th>${loop.index+1}</th>
										<th>${alumnos.nombre}</th>
										<td>${alumnos.apellidos}</td>
										<td>${alumnos.ssoId}</td>
										<td>${alumnos.email}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</c:if>
		</div>
	</div>
</body>
</html>
