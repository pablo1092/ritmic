<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="includes.jsp" %> 
</head>
<body>
    <div class="container">
	  <%@include file="cabecera.jsp" %> 

    	 <div class="col-md-8">
        	<div class="alert alert-success lead">
            	${success}
        	</div>
         
        	<span class="well floatRight">
            	Ir a <a href="registro.do">Página principal</a>
        	</span>
     	</div>   
    </div>
</body>
</html>