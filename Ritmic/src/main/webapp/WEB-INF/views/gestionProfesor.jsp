<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Panel de gestión</title>

<%@include file="includes.jsp" %> 

<script  language="javascript" type="text/javascript" >

	function activaTab(tabId){
	    $('.nav-tabs a[href="#' + tabId + '"]').tab('show');
	};
	
</script>

</head>
<body>

<div class="container"> 
      
    <%@include file="cabecera.jsp" %>   
     
	<div class="page-header">
       <h1>Panel de gestión del profesor</h1>
    </div>

    <ul class="nav nav-tabs nav-justified">
  		<li><a href="#crearactividad" data-toggle="tab">Crear actividad</a></li>
  		<li><a href="#crearcurso" data-toggle="tab">Crear nuevo curso</a></li>
  		<li><a href="#misAlumnos" data-toggle="tab">Mis Alumnos</a></li>
	</ul>
	
	<div class="tab-content">
		<div class="tab-pane fade" id="crearactividad"><jsp:include page="crearActividad.jsp" /></div>
		<div class="tab-pane fade" id="crearcurso"><jsp:include page="crearCurso.jsp" /></div>
		<div class="tab-pane fade" id="misAlumnos"><jsp:include page="misCursos.jsp" /></div>
	</div>
	
	<c:if test="${param.crearcurso != null || param.errorcurso != null}">
		<script>activaTab('crearcurso');</script>
	</c:if>
	
	<c:if test="${param.crearactividad != null || param.erroractividad != null}">
		<script>activaTab('crearactividad');</script>
	</c:if>
	
	<c:if test="${param.misalumnos != null || param.misalumnos != null}">
		<script>activaTab('misAlumnos');</script>
	</c:if>
	
	
	
  </div>
</body>
</html>