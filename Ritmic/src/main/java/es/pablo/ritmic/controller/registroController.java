package es.pablo.ritmic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.pablo.ritmic.TO.CursoTO;
import es.pablo.ritmic.TO.PerfilUsuarioTO;
import es.pablo.ritmic.TO.UsuarioTO;
import es.pablo.ritmic.service.CursoSrv;
import es.pablo.ritmic.service.PerfilUsuarioSrv;
import es.pablo.ritmic.service.UsuarioSrv;

@Controller
public class registroController {
	
	@Autowired
	UsuarioSrv usuarioService;
	
	@Autowired
	PerfilUsuarioSrv perfilUsuarioServ; 
	
	@Autowired
	CursoSrv cursoService;
	
	@Autowired
    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;
	
	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;
	
	
    @RequestMapping(value = { "/registro.do" }, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
    	
        UsuarioTO user = new UsuarioTO();  
        PerfilUsuarioTO perfilUsuario = new PerfilUsuarioTO();
        CursoTO curso = new CursoTO();
        
        model.addAttribute("user", user);
        model.addAttribute("loggedinuser", getPrincipal());        
        model.addAttribute("userProfiles", perfilUsuarioServ.findAll());
        model.addAttribute("getcursos", cursoService.findAllCursos());
        
        model.addAttribute("perfilUsuario", perfilUsuario);
        model.addAttribute("cursos", curso);
        
        return "registro";
    }
	
	/**
     * Método para guardo un nuevo usuario en la BD
     */
	@RequestMapping(value = { "/registro.do" }, method = RequestMethod.POST)
    public String saveUser(@Valid @ModelAttribute("user") UsuarioTO user, BindingResult result,
            ModelMap model)  {
    	
    	//En el caso que guardemos un profesor, INICIALIZAMOS el curso.
    	PerfilUsuarioTO perfilSeleccionado = new PerfilUsuarioTO();
    	perfilSeleccionado = user.getUserProfiles().iterator().next();

    	if(perfilSeleccionado.getId() == 2) {
    		//Por si llegara basura, para que no falle la aplicacian 
    		user.setCursos(null);
    	}
    	else {
    		//Grabamos el cursoActual. En este caso es el que se ha matriculado el alumno
        	user.setCursoActual(user.getCursos().iterator().next().getIdCurso());
    	}

        if(!usuarioService.isUsuarioUnique(user.getIdUsuario(), user.getssoId())){
            //FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getssoId()}, Locale.getDefault()));
            //result.addError(ssoError);
        	System.out.println("Usuario duplicado");
        	
        	return "redirect:/registro.do?error";
        }
         
        usuarioService.saveUsuario(user);
 
        model.addAttribute("success", "Usuario " + user.getNombre() + " "+ user.getApellidos() + " registrado correctamente");
        model.addAttribute("loggedinuser", getPrincipal());

        return "registroCorrecto";
    }

    /**
     * Método para mapear un acceso denegado
     */
    @RequestMapping(value = "/accesoDenegado", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
    	
	    UsuarioTO user = usuarioService.findBySSO(getPrincipal());
	    model.addAttribute("user", user);
	    
        return "accesoDenegado";
    }
    
    
    /**
     * Autenticación en el sistema
     */
    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public String loginPage(ModelMap model) {
        if (isCurrentAuthenticationAnonymous()) {
            return "login";
        } else {
            return "redirect:home.do";  
        }
    }
    
    /**
     * Método para cerrar sesión en el sistema
     */
    @RequestMapping(value="/logout-{accion}", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response, @PathVariable String accion,
    		final RedirectAttributes redirectAttributes){
        
    	String cadena = "";
    	String usuario = getPrincipal();
    	
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            persistentTokenBasedRememberMeServices.logout(request, response, auth);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        
        if(accion.equals("eliminar")){
        	redirectAttributes.addFlashAttribute("usuario", usuario);
        	cadena = "redirect:/login.do?eliminado";
        }
        else{
        	cadena = "redirect:/login.do?logout";
        }
        return cadena;
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
    
    /**
    * Método que devuelve si un usuario esta logueado en el sistema.
    */
   private boolean isCurrentAuthenticationAnonymous() {
       final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       return authenticationTrustResolver.isAnonymous(authentication);
   }
}

