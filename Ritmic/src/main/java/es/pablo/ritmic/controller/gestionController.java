package es.pablo.ritmic.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.pablo.ritmic.TO.ActividadTO;
import es.pablo.ritmic.TO.CursoTO;
import es.pablo.ritmic.TO.FicheroTO;
import es.pablo.ritmic.TO.FileBucket;
import es.pablo.ritmic.TO.TipoActividadTO;
import es.pablo.ritmic.TO.TipoFicheroTO;
import es.pablo.ritmic.TO.UsuarioTO;
import es.pablo.ritmic.service.ActividadSrv;
import es.pablo.ritmic.service.CursoSrv;
import es.pablo.ritmic.service.FicheroSrv;
import es.pablo.ritmic.service.TipoActividadSrv;
import es.pablo.ritmic.service.TipoFicheroSrv;
import es.pablo.ritmic.service.UsuarioSrv;
import es.pablo.ritmic.util.FileValidator;

@Controller
@PropertySource(value = {"classpath:application.properties"}) 
public class gestionController {

    @Autowired
    Environment environment;
	     
	@Autowired
	FileValidator fileValidator;
	
	@Autowired
	CursoSrv cursoService;
	
	@Autowired
	FicheroSrv ficheroSrv;
	
	@Autowired
	TipoFicheroSrv tipoFicheroService;
	
	@Autowired
	ActividadSrv actividadService;
	
	@Autowired
	TipoActividadSrv tipoActividadService;
	
	@Autowired	
	UsuarioSrv usuarioService;
	
	UsuarioTO user;
	
	List <UsuarioTO> alumnos;
	
	/**
	 * Validamos el fichero cargado en el sistema
	 */
    @InitBinder("fileBucket")
    public void initBinderFileBucket(WebDataBinder binder) {
       binder.setValidator(fileValidator);
    }
    
    @RequestMapping(value = {"/gestionprofesor.do"}, method = RequestMethod.GET)
    public String gestionProfesor(ModelMap model) {
    	
    	   //Cargamos el usuario logueado. 
	       user = usuarioService.findBySSO(getPrincipal());
	       model.addAttribute("user", user);
	       
	       //Cargamos los combos
	       model.addAttribute("cursos", cursoService.findAllCursos());
	       model.addAttribute("tipoActividades", tipoActividadService.findAll());
    	
	       //Para la subida del fichero
    	   FileBucket file = new FileBucket();
    	   model.addAttribute("file", file);
    	   
    	   //Para la creacian de un nuevo curso
    	   CursoTO nuevoCurso = new CursoTO();
           model.addAttribute("nuevoCurso", nuevoCurso);
           
           //Para la creacian de la actividad
           ActividadTO actividad = new ActividadTO();
           TipoActividadTO idTipoActividad = new TipoActividadTO();
           CursoTO idCurso = new CursoTO();
           
           model.addAttribute("actividad", actividad);
           model.addAttribute("idTipoActividad", idTipoActividad);
           model.addAttribute("idCurso", idCurso);
           
           //Para cargar los cursos del profesor
           List<CursoTO> cursos = cursoService.findByProfesor(user.getIdUsuario());
           model.addAttribute("cursos", cursos);
           model.addAttribute("alumnos", alumnos);
           
           return "gestionProfesor";
    }
    
    /**
     * Metodo para crear un curso
     */
    @RequestMapping(value = {"/gestionprofesor/crearcurso.do"}, method = RequestMethod.POST)
    public String crearCurso(@ModelAttribute("descripcion") String descripcion, BindingResult result, ModelMap model, 
    			final RedirectAttributes redirectAttributes){
    	
    	if (result.hasErrors()) {
    		redirectAttributes.addFlashAttribute("cursoCreado", descripcion);
            return "redirect:/gestionprofesor.do?errorcurso";
        } else {  
        	CursoTO curso = new CursoTO();
        	
        	curso.setDescripcion(descripcion);
        	curso.setIdProfesor(user.getIdUsuario());
        	cursoService.saveCurso(curso);
        	
        	redirectAttributes.addFlashAttribute("cursoCreado", descripcion);
        	
        	return"redirect:/gestionprofesor.do?crearcurso";
        }
    }
    
    /**
     * Método para crear un nueva actividad. Además carga el fichero. 
     */
    @RequestMapping(value = {"/gestionprofesor/crearactividad.do"}, method = RequestMethod.POST)
    public String crearActividad(@Valid @ModelAttribute("actividad") ActividadTO actividad,
    		@ModelAttribute("file") FileBucket file, BindingResult result, ModelMap model, final RedirectAttributes redirectAttributes, HttpServletRequest request) throws IOException{
    	
    	if (result.hasErrors()) {
    		redirectAttributes.addFlashAttribute("activCreada", actividad.getDescripActividad());
            return "redirect:/gestionprofesor.do?erroractividad";
        } else {  
    	
    		//GUARDAMOS LA ACTIVIDAD
    		actividadService.saveActividad(actividad);
        	
        	//CREAMOS Y GUARDAMOS EL FICHERO
        	System.out.println("Get file: " + file.getFile());
        	System.out.println("Nombre original:" + file.getFile().getOriginalFilename());

            MultipartFile multipartFile = file.getFile();       
           
            //Obtenemos la ruta del proyecto para guardar el fichero de la actividad
            String ruta = System.getProperty("user.home");
            FileCopyUtils.copy(file.getFile().getBytes(), new File(ruta + File.separator + file.getFile().getOriginalFilename()));
            
            List<String> fileNames = new ArrayList<String>();
            fileNames.add(multipartFile.getOriginalFilename());
        	
        	FicheroTO fichero = new FicheroTO();
       
        	fichero.setIdActividad(actividad.getIdActividad());
        	
        	//Obtenemos el tipo de fichero a partir de la extensian del archivo. 
        	String extension = file.getFile().getOriginalFilename().split("\\.")[1];
        	TipoFicheroTO tipoFichero = tipoFicheroService.findByTipo(extension);
        	
        	fichero.setIdTipoFichero(tipoFichero);
        	fichero.setXpath(ruta + File.separator + file.getFile().getOriginalFilename());
        	
        	ficheroSrv.saveFichero(fichero);
        	
        	redirectAttributes.addFlashAttribute("activCreada", actividad.getDescripActividad());
     
        	return"redirect:/gestionprofesor.do?crearactividad";
        }
    }
    
    /**
     * Método para cargar los alumnos matriculados en un curso
     */
    @RequestMapping(value = {"/gestionprofesor/cargaralumnos.do-{idCurso}"}, method = RequestMethod.GET)
    public String cargarAlumnos(@PathVariable int idCurso, ModelMap model, final RedirectAttributes redirectAttributes) {
    	
    		CursoTO curso = cursoService.findById(idCurso);
    		
        	alumnos = usuarioService.findByCurso(idCurso);
        	model.addAttribute("alumnos", alumnos);
        	
        	redirectAttributes.addFlashAttribute("cursoCargado", curso.getDescripcion());
        	
        	return"redirect:/gestionprofesor.do?misalumnos";
    }
    
    /**
     * Método que devuelve el usuario principal logueado en el sistema
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
