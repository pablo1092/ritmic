<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Aprendizaje</title>

<%@include file="includes.jsp"%>
</head>
<body>
	<div class="container">

		<%@include file="cabecera.jsp"%>

		<div class="page-header">
			<h1>Conceptos te�ricos</h1>
		</div>

		<h3>Introducci�n a la lectura musical</h3>


		<p>Un sistema de notaci�n musical nos permite especificar dos de
			las caracter�sticas principales de la m�sica: la nota que debemos
			tocar y su duraci�n. En los siguientes puntos, se explican los
			aspectos b�sicos de la lectura musical. Comenzaremos por aprender
			como especificamos la duraci�n de los sonidos. Para eso, veamos
			primeramente dos conceptos importantes: la pulsaci�n y el comp�s.</p>

		<div class="panel-group" id="accordion" role="tablist"
			aria-multiselectable="true">

			<div class="panel panel-default">
				<div class="panel-heading" role="tab" id="heading1">
					<h4 class="panel-title">
						<a role="button" data-toggle="collapse" data-parent="#accordion"
							href="#collapse1" aria-expanded="true" aria-controls="collapse1">
							1. Pulsaci�n y Comp�s</a>
					</h4>
				</div>
				<div id="collapse1" class="panel-collapse collapse in"
					role="tabpanel" aria-labelledby="heading1">
					<div class="panel-body">
						Se define <strong>la pulsaci�n</strong> como la unidad que nos
						permite medir el tiempo en fragmentos iguales. Lo normal es que la
						pulsaci�n sea constante aunque a veces se puede acelerar o
						atrasar. M�s comunmente, es conocida como el <strong>tiempo</strong>.
						<br></br> <strong>El comp�s</strong> no es m�s que un conjunto de
						tiempos delimitados por una linea transversal que indica el inicio
						y fin de cada uno de ellos. En los niveles de ense�anza menos
						avanzados, nos solemos encontraremos compases de 2, 3 o 4 tiempos<br></br>
						<img src="resources/images/compasDivisorias.png"
							class="col-md-6 col-md-offset-3 img-responsive" />
					</div>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading" role="tab" id="heading6">
					<h4 class="panel-title">
						<a class="collapsed" role="button" data-toggle="collapse"
							data-parent="#accordion" href="#collapse6" aria-expanded="false"
							aria-controls="collapse6"> 2. El pentagrama </a>
					</h4>
				</div>
				<div id="collapse6" class="panel-collapse collapse" role="tabpanel"
					aria-labelledby="heading6">
					<div class="panel-body">
						El <strong>pentagrama</strong> es el lugar donde se escriben las
						notas junto con todos los dem�s signos musicales. Un pentagrama,
						como su propio nombre indica, se compone por cinco lineas
						horizontales y paralelas, las cuales forman cuatro espacios entre
						ellas. Tanto encima de las lineas como en los espacios se pueden
						ubicar notas musicales. <br></br> Una <strong>partirura</strong>
						es un conjunto de pentagramas. Para representar partituras
						r�tmicas, propias de instrumentos de percusi�n, se suelen utilizar
						pentagramas de una �nica l�nea, puesto que s�lo vamos a
						representar en �l la duraci�n de las notas musicales y no su
						altura.<br></br> En la siguiente imagen se puede observar un
						ejemplo de una partitura r�tmica: <br></br> <img
							src="resources/images/ejemploPercusion.png"
							class="col-md-6 col-md-offset-3 img-responsive" />
					</div>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading" role="tab" id="heading2">
					<h4 class="panel-title">
						<a class="collapsed" role="button" data-toggle="collapse"
							data-parent="#accordion" href="#collapse2" aria-expanded="false"
							aria-controls="collapse2"> 3. Indicaci�n de comp�s </a>
					</h4>
				</div>
				<div id="collapse2" class="panel-collapse collapse" role="tabpanel"
					aria-labelledby="heading2">
					<div class="panel-body">
						Al leer m�sica, uno de los primeros s�mbolos que encontraremos
						ser� la indicaci�n de comp�s. Los compases se componen de dos
						valores num�ricos; el n�mero superior nos indica la cantidad de
						tiempos o pulsaciones. <br></br> Los compases se subdividen a su
						vez en <strong>simples</strong> y <strong>compuestos</strong>. La
						diferencia se basa en que en los compases simples, la pulsaci�n o
						unidad de tiempo se subdivide en mitades y en los compases
						compuestos, la unidad de tiempo se subdivide en tres partes. <br></br>
						<img src="resources/images/Tipos-de-compas.jpg"
							class="col-md-6 col-md-offset-3 img-responsive" />
					</div>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading" role="tab" id="heading3">
					<h4 class="panel-title">
						<a class="collapsed" role="button" data-toggle="collapse"
							data-parent="#accordion" href="#collapse3" aria-expanded="false"
							aria-controls="collapse3"> 4. Las figuras musicales </a>
					</h4>
				</div>
				<div id="collapse3" class="panel-collapse collapse" role="tabpanel"
					aria-labelledby="heading3">
					<div class="panel-body">
						Una vez hemos aprendido el concepto de comp�s y tiempo, podemos
						comenzar a leer. <br> <br> Indicamos la <strong>duraci�n</strong>
						de un sonido por medio de figuras musicales. Comenzaremos por
						conocer algunas <strong>figuras musicales</strong> y su duraci�n
						medida en pulsos o tiempos. <br></br> <img
							src="resources/images/figuras.jpg"
							class="col-md-6 col-md-offset-3 img-responsive" /> <br>
					</div>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading" role="tab" id="heading5">
					<h4 class="panel-title">
						<a class="collapsed" role="button" data-toggle="collapse"
							data-parent="#accordion" href="#collapse5" aria-expanded="false"
							aria-controls="collapse5"> 5. Los silencios </a>
					</h4>
				</div>
				<div id="collapse5" class="panel-collapse collapse" role="tabpanel"
					aria-labelledby="heading5">
					<div class="panel-body">
						En m�sica, otro elemento de gran importancia es <strong>el
							silencio</strong>. Para cada una de las figuras muscales, existe un signo
						de silencio que la representa, el cual posee la misma duraci�n que
						la figura en s�. En la siguiente tabla se puede ver una relaci�n de las
						distintas figuras musicales con sus respectivos silencios: <br></br>
						<img src="resources/images/figuras-silencios.jpg"
							class="col-md-6 col-md-offset-3 img-responsive" />
					</div>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading" role="tab" id="heading4">
					<h4 class="panel-title">
						<a class="collapsed" role="button" data-toggle="collapse"
							data-parent="#accordion" href="#collapse4" aria-expanded="false"
							aria-controls="collapse4"> 6. El puntillo y la ligadura </a>
					</h4>
				</div>
				<div id="collapse4" class="panel-collapse collapse" role="tabpanel"
					aria-labelledby="heading4">
					<div class="panel-body">
						En puntos anteriores, hemos visto figuras con la duraci�n de
						1,2,4... tiempos. �Qu� figura podemos usar para indicar un sonido
						con tres tiempos? <br>Realmente, no existe una figura de esta
						duraci�n, pero podemos crearla usando: <strong>el
							puntillo</strong> o <strong>la ligadura.</strong></br> <br> El <strong>
							puntillo</strong> a�ade a una figura la mitad de su valor. Por ejemplo, si
						le a�adimos a la blanca que tiene 2 tiempos un puntillo,
						obtendremos un sonido con la duraci�n de 3 tiempos (la mitad de 2
						es 1, por tanto, 1 + 2 = 3). </br>
						
						<br> La <strong>ligadura</strong> nos
						permite lograr el mismo efecto que un puntillo. Una ligadura a�ade
						a la primera nota el valor de la segunda. Por ejemplo, si ligamos
						una negra a un blanca, obtenemos un sonido de 3 tiempo de duraci�n
						(igual que una blanca con puntillo)</br> <br> Vemos un ejemplo
						musical usando la blanca con puntillo y la blanca ligada a un
						negra, el efecto es el mismo en ambos compases: </br>
						
						<img src="resources/images/ligadura.png"
							class="col-md-6 col-md-offset-3 img-responsive" /> <br>


					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>