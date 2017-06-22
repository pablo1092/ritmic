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
			<h1>Conceptos teóricos</h1>
		</div>

		<h3>Introducción a la lectura musical</h3>


		<p>Un sistema de notación musical nos permite especificar dos de
			las características principales de la música: la nota que debemos
			tocar y su duración. En los siguientes puntos, se explican los
			aspectos básicos de la lectura musical. Comenzaremos por aprender
			como especificamos la duración de los sonidos. Para eso, veamos
			primeramente dos conceptos importantes: la pulsación y el compás.</p>

		<div class="panel-group" id="accordion" role="tablist"
			aria-multiselectable="true">

			<div class="panel panel-default">
				<div class="panel-heading" role="tab" id="heading1">
					<h4 class="panel-title">
						<a role="button" data-toggle="collapse" data-parent="#accordion"
							href="#collapse1" aria-expanded="true" aria-controls="collapse1">
							1. Pulsación y Compás</a>
					</h4>
				</div>
				<div id="collapse1" class="panel-collapse collapse in"
					role="tabpanel" aria-labelledby="heading1">
					<div class="panel-body">
						Se define <strong>la pulsación</strong> como la unidad que nos
						permite medir el tiempo en fragmentos iguales. Lo normal es que la
						pulsación sea constante aunque a veces se puede acelerar o
						atrasar. Más comunmente, es conocida como el <strong>tiempo</strong>.
						<br></br> <strong>El compás</strong> no es más que un conjunto de
						tiempos delimitados por una linea transversal que indica el inicio
						y fin de cada uno de ellos. En los niveles de enseñanza menos
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
						notas junto con todos los demás signos musicales. Un pentagrama,
						como su propio nombre indica, se compone por cinco lineas
						horizontales y paralelas, las cuales forman cuatro espacios entre
						ellas. Tanto encima de las lineas como en los espacios se pueden
						ubicar notas musicales. <br></br> Una <strong>partirura</strong>
						es un conjunto de pentagramas. Para representar partituras
						rítmicas, propias de instrumentos de percusión, se suelen utilizar
						pentagramas de una única línea, puesto que sólo vamos a
						representar en él la duración de las notas musicales y no su
						altura.<br></br> En la siguiente imagen se puede observar un
						ejemplo de una partitura rítmica: <br></br> <img
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
							aria-controls="collapse2"> 3. Indicación de compás </a>
					</h4>
				</div>
				<div id="collapse2" class="panel-collapse collapse" role="tabpanel"
					aria-labelledby="heading2">
					<div class="panel-body">
						Al leer música, uno de los primeros símbolos que encontraremos
						será la indicación de compás. Los compases se componen de dos
						valores numéricos; el número superior nos indica la cantidad de
						tiempos o pulsaciones. <br></br> Los compases se subdividen a su
						vez en <strong>simples</strong> y <strong>compuestos</strong>. La
						diferencia se basa en que en los compases simples, la pulsación o
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
						Una vez hemos aprendido el concepto de compás y tiempo, podemos
						comenzar a leer. <br> <br> Indicamos la <strong>duración</strong>
						de un sonido por medio de figuras musicales. Comenzaremos por
						conocer algunas <strong>figuras musicales</strong> y su duración
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
						En música, otro elemento de gran importancia es <strong>el
							silencio</strong>. Para cada una de las figuras muscales, existe un signo
						de silencio que la representa, el cual posee la misma duración que
						la figura en sí. En la siguiente tabla se puede ver una relación de las
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
						En puntos anteriores, hemos visto figuras con la duración de
						1,2,4... tiempos. ¿Qué figura podemos usar para indicar un sonido
						con tres tiempos? <br>Realmente, no existe una figura de esta
						duración, pero podemos crearla usando: <strong>el
							puntillo</strong> o <strong>la ligadura.</strong></br> <br> El <strong>
							puntillo</strong> añade a una figura la mitad de su valor. Por ejemplo, si
						le añadimos a la blanca que tiene 2 tiempos un puntillo,
						obtendremos un sonido con la duración de 3 tiempos (la mitad de 2
						es 1, por tanto, 1 + 2 = 3). </br>
						
						<br> La <strong>ligadura</strong> nos
						permite lograr el mismo efecto que un puntillo. Una ligadura añade
						a la primera nota el valor de la segunda. Por ejemplo, si ligamos
						una negra a un blanca, obtenemos un sonido de 3 tiempo de duración
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