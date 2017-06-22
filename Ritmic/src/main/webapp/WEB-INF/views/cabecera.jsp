<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
     
      <!-- Static navbar -->
      <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="home.do">Ritmic</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
            	<li><a href="aprendizaje.do">Aprendizaje</a></li>
            	<sec:authorize access="isAnonymous() or hasRole('Alumno')">	
              		<li><a href="lecturaritmos.do">Lectura de Ritmos</a></li>
              	</sec:authorize>
            </ul>
            
            <ul class="nav navbar-nav navbar-right">
 
 				<sec:authorize access="hasRole('Profesor')">
 					<li><a href="gestionprofesor.do">Panel de Gestión</a></li>
           		 </sec:authorize>	
           		 
           		 <sec:authorize access="hasRole('Alumno')">
 					<li><a href="miscursos.do">Mis Cursos</a></li>
           		 </sec:authorize>
 
           		 <sec:authorize access="hasRole('Alumno') or hasRole('Profesor')">
           		 	<li><a href="ranking.do">Ranking</a></li>
           		 	<li class="dropdown">
	              		<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${user.ssoId} <span class="caret"></span></a>
	           		 	<ul class="dropdown-menu">
	                		<li><a href="perfilusuario.do-${user.ssoId}">Editar Usuario</a></li>
	                	</ul>
                	</li>
           		 </sec:authorize>
           		 
           		 <sec:authorize access="hasRole('Alumno') or hasRole('Profesor')">
           		 	<li><a href="<c:url value="/logout-cerrar" />">Cerrar sesión</a></li>
           		 </sec:authorize>	
           		  
           		 <sec:authorize access="isAnonymous()">
            			<li><a href="registro.do">Registrarse</a></li>
            			<li><a href="login.do">Iniciar Sesion</a></li>
            	</sec:authorize>
            </ul>  	
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>