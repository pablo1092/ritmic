<%@ page language="java" contentType="text/html; charsetUTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--  TO-DO Ver http://www.verovio.org/tutorial.xhtml?id=topic01 para más opciones - escalado... -->
<div class="miniscore" id="output_${id}"></div> 

<script type="text/javascript">
    //var zoom = 65;
	//pageHeight = $(document).height() * 100 / zoom;
	//pageWidth = $(window).width() * 100 / zoom;
	
	options = {
	    pageHeight: 350,
	    pageWidth: 1000,
	    //pageHeight: pageHeight,
	    //pageWidth: pageWidth,
	    adjustPageHeight: 1,
	    ignoreLayout: 1,
	    border: 0,
	    scale: 70,
	    //scale: zoom
	    inputFormat: "auto" 
	};
	
	var data = "${musicXML}";
    var vrvToolkit = new verovio.toolkit();
	var svg = vrvToolkit.renderData(data, options);
	$("#output_${id}").html(svg);    
</script>  





