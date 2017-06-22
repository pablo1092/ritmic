package es.pablo.ritmic.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.pablo.ritmic.TO.UsuarioTO;
import es.pablo.ritmic.service.CursoSrv;
import es.pablo.ritmic.service.UsuarioSrv;

@Controller
public class perfilUsuarioController {
	
	@Autowired
	UsuarioSrv usuarioService;
	
	@Autowired
	CursoSrv cursoService;
	
	/**
	 * Método para cargar la edición de los datos de un usuario
	 */
    @RequestMapping(value = { "/perfilusuario.do-{ssoId}"}, method = RequestMethod.GET)
    public String editUser(@PathVariable String ssoId, ModelMap model) {
    	
        UsuarioTO user = usuarioService.findBySSO(ssoId);
        
        model.addAttribute("user", user);
        model.addAttribute("loggedinuser", getPrincipal());

        return "perfilusuario";
    }
    
    /**
     * Método para eliminar un usuario del sistema
     */
    @RequestMapping(value = { "/borrarusuario.do-{ssoId}"}, method = RequestMethod.GET)
    public String deleteUser(@PathVariable String ssoId, ModelMap model) {
    	
    	System.out.println("Vamos a eliminar el usuario");
    	
    	usuarioService.deleteUserBySSO(ssoId);
        
        return "redirect:/logout-eliminar";
    }
    
    /**
     * Método parra actualizar los datos de un usuario en la BD.
     */
    @RequestMapping(value = { "/actualizarusuario.do" }, method = RequestMethod.POST)
    public String updateUser(@Valid @ModelAttribute("user") UsuarioTO user, BindingResult result, 
    		ModelMap model){
 
        usuarioService.updateUsuario(user);
 
        model.addAttribute("success", "Usuario " + user.getNombre() + " "+ user.getApellidos() + " actualizado correctamente");
        model.addAttribute("loggedinuser", getPrincipal());
        
        return "registroCorrecto";
    }
    
    /**
     * Método que devuelve el usuario principal cargado en el sistema. 
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