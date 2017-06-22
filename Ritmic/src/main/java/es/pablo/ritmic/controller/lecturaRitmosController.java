package es.pablo.ritmic.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.pablo.ritmic.TO.ActividadTO;
import es.pablo.ritmic.TO.CursoTO;
import es.pablo.ritmic.TO.FicheroTO;
import es.pablo.ritmic.TO.IntentoTO;
import es.pablo.ritmic.TO.UsuarioTO;
import es.pablo.ritmic.actividades.CorreccionActivdadLectura;
import es.pablo.ritmic.service.ActividadSrv;
import es.pablo.ritmic.service.CursoSrv;
import es.pablo.ritmic.service.FicheroSrv;
import es.pablo.ritmic.service.IntentoSrv;
import es.pablo.ritmic.service.UsuarioSrv;
import es.pablo.ritmic.vistas.VerovioMEI;
import es.ua.dlsi.im3.IM3Exception;
import es.ua.dlsi.im3.core.score.NoMeterException;
import es.ua.dlsi.im3.io.FileType;
import es.ua.dlsi.im3.io.ImportException;

@Controller
public class lecturaRitmosController {
	
	@Autowired
	UsuarioSrv usuarioService;
	
	@Autowired
	CursoSrv cursoService;
	
	@Autowired
	ActividadSrv actividadService;
	
	@Autowired
	FicheroSrv ficheroService;
	
	@Autowired
	IntentoSrv intentoService;
	
	ActividadTO actividadEjemplo;
	
	List<ActividadTO > actividades;
	
	UsuarioTO user;
	
	FicheroTO ficheroActividadEjemplo;
	
	CursoTO curso;
	
	int indice=0;
	
	int indiceMenor = 0, indiceMayor=0, totalActividades=0;
	
	String contenidoActividadCargar = "", contenidoCod = "";
	
	public lecturaRitmosController() {
		for (Handler handler: Logger.getGlobal().getHandlers()) {
			handler.setLevel(Level.INFO);
		}
	}
	
	@RequestMapping(value = {"/lecturaritmos.do"}, method = RequestMethod.GET)
    public String lecturaRitmos(ModelMap model) throws IOException {
		
		//Cargamos el usuario logueado. 
	    user = usuarioService.findBySSO(getPrincipal());
	    model.addAttribute("user", user);
	    
	    //Si no hay usuario logueado, cargamos actividad ejemplo
	    if (user == null) {
	    	actividadEjemplo = actividadService.findById(1);
	    	
	     	if (actividadEjemplo == null) {
	    		throw new IOException("No hay ninguna actividad de ejemplo creada con id=1");
	    	}
	     	
	    	model.addAttribute("actividadEjemplo", actividadEjemplo);
	    	
	    	ficheroActividadEjemplo = ficheroService.finByIdActividad(actividadEjemplo.getIdActividad());
	    	
	    	String contenidoActividadEjemplo = getFileData(ficheroActividadEjemplo.getXpath());
	    	
	    	//Cargamos el fichero Xml
	    	try {
	    		VerovioMEI meiEncoder = new VerovioMEI(FileType.musicxml, contenidoActividadEjemplo);
	    		contenidoCod = meiEncoder.getEscapedMusicXMLContent();
	    		model.addAttribute("contenidoActividadEjemplo", contenidoCod);
	    		
	    	} catch (Exception e) {
	    		Logger.getLogger(lecturaRitmosController.class.getName()).log(Level.WARNING, "No se ha podido cargar el MusicXML y exportarlo a MEI: " + e.getMessage(), e);
	    		throw new IOException(e);
	    	}
	    	 
	        return "actividadPrueba";
	    }
	    else {
	    	
		    //Cargamos curso del alumno
		    int idCursoActual = user.getCursoActual();

		    curso = cursoService.findById(idCursoActual);
	    	actividades = actividadService.findByCurso(curso);
	    	
	    	if(!actividades.isEmpty()) {
	    		
	    		if (indice > actividades.size()){
	    			indice=0;
	    		}
	    		
	    		model.addAttribute("actividadadCargar", actividades.get(indice));
		    	
	    		ficheroActividadEjemplo = ficheroService.finByIdActividad(actividades.get(indice).getIdActividad());
		    	
		    	contenidoActividadCargar = getFileData(ficheroActividadEjemplo.getXpath());
		    	
		    	try {
		    		VerovioMEI meiEncoder = new VerovioMEI(FileType.musicxml, contenidoActividadCargar);
		    		contenidoCod = meiEncoder.getEscapedMusicXMLContent();
		    		model.addAttribute("contenidoActividadCargar", contenidoCod);
		    	} catch (Exception e) {
		    		Logger.getLogger(lecturaRitmosController.class.getName()).log(Level.WARNING, "No se ha podido cargar el MusicXML y exportarlo a MEI: " + e.getMessage(), e);
		    		throw new IOException(e);
		    	}
	    	}
	    	
	    	model.addAttribute("curso", curso);
	    	
	    	//Calculo de indices para paginar
	    	if(indice==0) {
		    	indiceMenor = indice - 1;
		    	indiceMayor = indice + 1;
	    	} 
	    	
	    	model.addAttribute("indiceMenor", indiceMenor);
	    	model.addAttribute("indiceMayor", indiceMayor);
	    	
	    	totalActividades = actividades.size();
	    	model.addAttribute("totalActividades", totalActividades);
	    	
	    	return  "lecturaRitmos";
	    }
	}
	
	@RequestMapping(value = {"/corregir.do"}, method = RequestMethod.GET)
    public String corregir(@RequestParam(value="ejecucion") String ejecucion, ModelMap model) throws IOException, IM3Exception, ImportException, NoMeterException {
		
		//ejecucion = "0 1500 2000 4000";
		File fichero = new File(ficheroActividadEjemplo.getXpath());
		
		//Reemplazamos comas por espacios
		String ejecucionFinal = ejecucion.replace(',', ' ');
		
		//Correccion de la actividad
		CorreccionActivdadLectura cal = new CorreccionActivdadLectura(fichero, FileType.musicxml, 60, ejecucionFinal);
		double correcion = cal.corrige();
		
		if (correcion < 0) {
			correcion = 0;
		}
		else if (correcion >= 9.6) {
			correcion = 10;
		}
		else {
			correcion = Math.round(correcion*10)/10;
		}
		
		model.addAttribute("puntuacion", correcion);
		
		if (user == null) {
			actividadEjemplo = actividadService.findById(1);
			model.addAttribute("actividadEjemplo", actividadEjemplo);
			model.addAttribute("contenidoActividadEjemplo", contenidoCod);
			return "actividadPrueba";
		}else {
			
			//Guardamos el intento
			IntentoTO intento = new IntentoTO();
			
			intento.setEjecucionAlumno(ejecucion);
			intento.setIdActividad(actividades.get(indice).getIdActividad());
			intento.setIdAlumno(user.getIdUsuario());
			intento.setIdCurso(actividades.get(indice).getIdCurso().getIdCurso());
			intento.setPuntuacion((float) correcion);
			
			intentoService.saveIntento(intento);
			
			//Cargamos en el contexto la actividad
			model.addAttribute("user", user);
			model.addAttribute("actividadadCargar", actividades.get(indice));
			
			ficheroActividadEjemplo = ficheroService.finByIdActividad(actividades.get(indice).getIdActividad());
	    	contenidoActividadCargar = getFileData(ficheroActividadEjemplo.getXpath());
			model.addAttribute("contenidoActividadCargar", contenidoCod);
			
			model.addAttribute("indiceMenor", indiceMenor);
	    	model.addAttribute("indiceMayor", indiceMayor);
	    	
	    	totalActividades = actividades.size();
	    	model.addAttribute("totalActividades", totalActividades);
						
			return "lecturaRitmos";
		}
	}
	
	@RequestMapping(value = {"/actividadsiguiente"}, method = RequestMethod.GET)
    public String lecturaRitmosSiguiente(ModelMap model) throws IOException {
		
	    model.addAttribute("user", user);
	    
	    totalActividades = actividades.size();
		
		indice++;
		
		if(indice < totalActividades) {
			model.addAttribute("actividadadCargar", actividades.get(indice));
			
			ficheroActividadEjemplo = ficheroService.finByIdActividad(actividades.get(indice).getIdActividad());
	    	
	    	contenidoActividadCargar = getFileData(ficheroActividadEjemplo.getXpath());
	    	
	    	try {
	    		VerovioMEI meiEncoder = new VerovioMEI(FileType.musicxml, contenidoActividadCargar);
	    		contenidoCod = meiEncoder.getEscapedMusicXMLContent();
	    		model.addAttribute("contenidoActividadCargar", contenidoCod);
	    	} catch (Exception e) {
	    		Logger.getLogger(lecturaRitmosController.class.getName()).log(Level.WARNING, "No se ha podido cargar el MusicXML y exportarlo a MEI: " + e.getMessage(), e);
	    		throw new IOException(e);
	    	}
	    	
	    	//Calculo de indices para paginar
	    	indiceMenor = indice - 1;
	    	indiceMayor = indice + 1;   	
		} else {
			indice--;
			model.addAttribute("contenidoActividadCargar", contenidoCod);
			model.addAttribute("actividadadCargar", actividades.get(indice));
		}
    	
		model.addAttribute("indiceMenor", indiceMenor);
		model.addAttribute("indiceMayor", indiceMayor);
		model.addAttribute("totalActividades", totalActividades);
		
    	return  "lecturaRitmos";
	}
	
	@RequestMapping(value = {"/actividadanterior"}, method = RequestMethod.GET)
    public String lecturaRitmosAnterior(ModelMap model) throws IOException {
		
	    model.addAttribute("user", user);
		
		indice--;
		
		System.out.println("INDICEEE ANTERIOR: " + indice);
		
		if (indice >= 0) {
			model.addAttribute("actividadadCargar", actividades.get(indice));
			ficheroActividadEjemplo = ficheroService.finByIdActividad(actividades.get(indice).getIdActividad());
	    	contenidoActividadCargar = getFileData(ficheroActividadEjemplo.getXpath());
	    	
	    	try {
	    		VerovioMEI meiEncoder = new VerovioMEI(FileType.musicxml, contenidoActividadCargar);
	    		contenidoCod = meiEncoder.getEscapedMusicXMLContent();
	    		model.addAttribute("contenidoActividadCargar", contenidoCod);
	    	} catch (Exception e) {
	    		Logger.getLogger(lecturaRitmosController.class.getName()).log(Level.WARNING, "No se ha podido cargar el MusicXML y exportarlo a MEI: " + e.getMessage(), e);
	    		throw new IOException(e);
	    	}
	    	
	    	//Calculo de indices para paginar
	    	indiceMenor = indice - 1;
	    	indiceMayor = indice + 1;
	    	totalActividades = actividades.size();
	    	
		} else {
			indice++;
			model.addAttribute("contenidoActividadCargar", contenidoCod);
			model.addAttribute("actividadadCargar", actividades.get(indice));
		}
		
	    model.addAttribute("indiceMenor", indiceMenor);
	    model.addAttribute("indiceMayor", indiceMayor);
	    model.addAttribute("totalActividades", totalActividades);
    	
		return  "lecturaRitmos";
	}
	
	/**
	 * Método para cargar el contenido de un fichero
	 */
	private String getFileData(String ruta) throws IOException {
		
    	String cadena = "", resultado = "";
    	
    	FileReader fichero = new FileReader(ruta);
    	BufferedReader b = new BufferedReader(fichero);
    	
    	while((cadena = b.readLine())!=null) {
    		resultado = resultado + cadena;
        }
        b.close();
        
        return resultado;
	}
	
    /**
     * Método que devuelve el usuario principal cargado en el sistema
     */
    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
