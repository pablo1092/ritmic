<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Acceso Denegado</title>

<%@include file="includes.jsp" %> 

</head>
<body>
	<div class="container">
	
	<%@include file="cabecera.jsp" %>
	
        <div class="authbar">
       			<div class="alert alert-danger col-md-7 col-md-offset-2" role="alert">Usuario <strong>${user.ssoId}</strong>, no está autorizado para acceder a esta url.</div>
        </div>
    </div>
</body>
</html>