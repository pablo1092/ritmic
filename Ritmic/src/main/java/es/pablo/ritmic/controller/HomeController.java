package es.pablo.ritmic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.pablo.ritmic.TO.UsuarioTO;
import es.pablo.ritmic.service.UsuarioSrv;


@Controller
public class HomeController {

	@Autowired
	UsuarioSrv usuarioService;
	
	
	@RequestMapping(value = {"/", "/home.do"}, method = RequestMethod.GET)
	public String home(Model model) {
		
		if(getPrincipal() != "anonymousUser")
		{
			UsuarioTO user = usuarioService.findBySSO(getPrincipal());

	        model.addAttribute("user", user);
	        model.addAttribute("loggedinuser", getPrincipal());
        
			//System.out.println("Usuario loggeado HOME: " + getPrincipal());
			//System.out.println("Nombre: " + user.getNombre());
			//System.out.println("Apellidos: " + user.getApellidos());
			//System.out.println("usuario: " + user.getssoId());
		}
		
		return "home";
	}
	
	/**
	 * Método para cargar la pestaña aprendizaje
	 */
	@RequestMapping(value = "/aprendizaje.do", method = RequestMethod.GET)
	public String getAprendizaje(Model model) {
		
		UsuarioTO user = usuarioService.findBySSO(getPrincipal());
        model.addAttribute("user", user);
		
		return "aprendizaje";
		
	}
	
    /**
     * El método devuelve el usuario principal logueado en el sistema
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
