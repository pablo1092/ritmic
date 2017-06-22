package es.pablo.ritmic.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.pablo.ritmic.TO.CursoTO;
import es.pablo.ritmic.TO.UsuarioTO;
import es.pablo.ritmic.service.CursoSrv;
import es.pablo.ritmic.service.UsuarioSrv;

@Controller
public class alumnoCursosController {
	
	@Autowired
	UsuarioSrv usuarioService;
	
	@Autowired
	CursoSrv cursoService;
	
	UsuarioTO user;
	
	@RequestMapping(value = { "/miscursos.do" }, method = RequestMethod.GET)
	public String cursosAlumno(ModelMap model) {
		
		   //Cargamos el usuario logueado. 
	       user = usuarioService.findBySSO(getPrincipal());
	       model.addAttribute("user", user);
	       
	       //Cargamos el curso actual
	       CursoTO cursoActual = cursoService.findById(user.getCursoActual());
	       System.out.println("Curso actual: " + cursoActual);
	       model.addAttribute("cursoActual", cursoActual.getDescripcion());
	       
	       //Cargamos un nuevo curso para seleccionar
	       CursoTO cursoMatricula = new CursoTO();
	       model.addAttribute("cursoMatricula", cursoMatricula);
	       
	       CursoTO cursoCargar = new CursoTO();
	       model.addAttribute("cursoCargar", cursoCargar);
				
	       //Recuperamos los cursos del alumno
	       Set<CursoTO> cursosAlumno = user.getCursos();
	       
	       //Convertimos SET para los cursos del alumno en una lista para tratamiento
	       List<CursoTO> cursosAlumnoLista = new ArrayList<CursoTO>(cursosAlumno);
	       
	       //Cargamos los cursos de los que se podra matricular
	       List<CursoTO> allCursos = cursoService.findAllCursos();
	       
	       //COMBO matricular. Eliminamos de la seleccian los cursos para los que ya se ha matriculado
	       allCursos.removeAll(cursosAlumno);
	       
	       //COMBO Para cargar otro curso
	       cursosAlumnoLista.remove(cursoActual);	       
	       
	       model.addAttribute("matricularCurso", allCursos);
	       model.addAttribute("cargarCursos", cursosAlumnoLista);
	       
		return "cursosAlumno";
	}
	
	/**
	 * Metodo para matricular un alumno en un currso
	 */
	@RequestMapping(value = { "/matriculacion.do"}, method = RequestMethod.POST)
    public String matricularCurso(@Valid @ModelAttribute("cursoMatricula") CursoTO cursoMatricula, BindingResult result,
    		ModelMap model, final RedirectAttributes redirectAttributes) {
    	
		redirectAttributes.addFlashAttribute("matriculaCurso", cursoMatricula.getDescripcion());
		
		if (result.hasErrors()) {
            return "redirect:miscursos.do?errormatricular";
        } else {  
	    	System.out.println("Vamos a matricular de otro curso");
	    	
	    	usuarioService.matricular(user, cursoMatricula);
	        
	        return "redirect:miscursos.do?matriculado";
        }
    }
	
	/**
	 * Metodo para cargar un curso en el sistema
	 */
	@RequestMapping(value = { "/cargarcurso.do"}, method = RequestMethod.POST)
    public String cargarCurso(@Valid @ModelAttribute("cursoCargar") CursoTO cursoCargar, ModelMap model, 
    		 final RedirectAttributes redirectAttributes, BindingResult result) {
    	
		redirectAttributes.addFlashAttribute("cursoCargado", cursoCargar.getDescripcion());
		
    	if (result.hasErrors()) {
            return "redirect:miscursos.do?errorcargar";
        } else {  
        	usuarioService.cargarCurso(user, cursoCargar);
        }
        
        return "redirect:miscursos.do?cargado";
    }
	
    /**
     * Obtener el usuario principal logueado en el sistema
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
