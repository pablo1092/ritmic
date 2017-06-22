<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<%@include file="includes.jsp" %> 
    
    <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
 </head>
 <body>
   <div class="container">
        <%@include file="cabecera.jsp" %> 
            <div class="col-md-5 col-md-offset-3">
                <div class="login-card">
                    <div class="login-form">
                        <c:url var="loginUrl" value="/login" />
                        <form action="${loginUrl}" method="post" class="form-horizontal">
                        	
                        	<h3 class="form-signin-heading">Iniciar Sesión:</h3>
                            <c:if test="${param.error != null}">
                                <div class="alert alert-danger">
                                    <p>Usuario o contraseña incorrectos.</p>
                                </div>
                            </c:if>
                            <c:if test="${param.logout != null}">
                                <div class="alert alert-success">
                                    <p>Sesión cerrada correctamente.</p>
                                </div>
                            </c:if>
                             <c:if test="${param.eliminado != null}">
                                <div class="alert alert-success">
                                    <p>Usuario <strong>${usuario}</strong> eliminado correctamente.</p>
                                </div>
                            </c:if>
                            
                            <div class="input-group input-sm">
                                <label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
                                <input type="text" class="form-control" id="username" name="ssoId" placeholder="Usuario" required>
                            </div>
                            <div class="input-group input-sm">
                                <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label> 
                                <input type="password" class="form-control" id="password" name="pass" placeholder="Contraseña" required>
                            </div>
                            <div class="input-group input-sm">
                              <div class="checkbox">
                                <label><input type="checkbox" id="rememberme" name="remember-me"> Recordame</label>  
                              </div>
                            </div>
                            <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
                                 
                            <div class="form-actions">
                                <input type="submit"
                                    class="btn btn-block btn-primary btn-default" value="Iniciar Sesión">
                            </div>
                        </form>
                    </div>
                </div>
               </div> 
            </div>
    </body>
</html>