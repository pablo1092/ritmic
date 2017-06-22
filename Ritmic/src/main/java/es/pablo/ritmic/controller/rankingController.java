package es.pablo.ritmic.controller;

import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.pablo.ritmic.TO.CursoTO;
import es.pablo.ritmic.TO.UsuarioTO;
import es.pablo.ritmic.service.CursoSrv;
import es.pablo.ritmic.service.IntentoSrv;
import es.pablo.ritmic.service.UsuarioSrv;

@Controller
public class rankingController {
	
	@Autowired
	UsuarioSrv usuarioService;
	
	@Autowired
	CursoSrv cursoService;
	
	@Autowired
	IntentoSrv intentoService;
	
	UsuarioTO user;
	
	CursoTO cursoActual;
	
	CursoTO cursoCargado;
	
	@RequestMapping(value = {"/ranking.do"}, method = RequestMethod.GET)
    public String rankingAlumno(ModelMap model) {
		
		//Cargamos el usuario logueado. 
	    user = usuarioService.findBySSO(getPrincipal());
	    model.addAttribute("user", user);
	    
	    //Cargamos el curso actual
	    cursoActual = cursoService.findById(user.getCursoActual());
	    model.addAttribute("cursoActual", cursoActual);

	    if(user.getUserProfiles().iterator().next().getType().equals("Alumno")){
	    	
	    	//Cargamos los alumnos del curso actual del alumno.
		    List<UsuarioTO> listaAlumnos = usuarioService.findByCurso(user.getCursoActual());
		    
		    System.out.println("Curso Actual: " + user.getCursoActual());
		    System.out.println("Lista de alumno para el curso: " + listaAlumnos);
	    	
		    Iterator<UsuarioTO> it = listaAlumnos.iterator();
	    	while(it.hasNext()) {
	    		UsuarioTO actual = it.next();
	    		float media = intentoService.calcularMedia(actual.getIdUsuario(), user.getCursoActual());
	    		System.out.println("Media: " + media);
	    		actual.setPuntuacionMedia(media);
	    	}
	    	
	    	model.addAttribute("listaAlumnos", listaAlumnos);
	    }
	    else { //Si el usuario es un profesor
	    	
	    	//Para cargar en combo los cursos del profesor 
	        List<CursoTO> cursos = cursoService.findByProfesor(user.getIdUsuario());
	        
	        if (cursoCargado != null) {
	
	        	cursos.remove(cursoCargado);
	        	
	        	//Cargamos los alumnos del curso actual del alumno.
			    List<UsuarioTO> listaAlumnos = usuarioService.findByCurso(cursoCargado.getIdCurso());
	        	
			    model.addAttribute("cursoActual", cursoCargado);
	        
			    Iterator<UsuarioTO> it = listaAlumnos.iterator();
		    	while(it.hasNext()) {
		    		UsuarioTO actual = it.next();
		    		float media = intentoService.calcularMedia(actual.getIdUsuario(), cursoCargado.getIdCurso());
		    		System.out.println("Media: " + media);
		    		actual.setPuntuacionMedia(media);
		    	}
		    	
		    	model.addAttribute("listaAlumnos", listaAlumnos);
	        }
	        
	        model.addAttribute("cursosProfesor", cursos);
	    }
	   
		return "ranking";
	}
	
	/**
	 * Método para cargar el ranking de un curso
	 */
	@RequestMapping(value = { "/cargarranking.do"}, method = RequestMethod.POST)
    public String cargarRanking(@Valid @ModelAttribute("cursosProfesor") CursoTO cursosProfesor, BindingResult result,
    		ModelMap model) {

		cursoCargado = cursosProfesor;
		
        return "redirect:ranking.do";
    }
	
    /**
     * Método que devuelve el usuario principal logueado en el sistema.
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
