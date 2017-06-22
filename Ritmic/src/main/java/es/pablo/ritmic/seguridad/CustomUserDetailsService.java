package es.pablo.ritmic.seguridad;

import java.util.ArrayList;
import java.util.List;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.pablo.ritmic.TO.PerfilUsuarioTO;
import es.pablo.ritmic.TO.UsuarioTO;
import es.pablo.ritmic.service.UsuarioSrv;
 
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
 
    static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
     
    @Autowired
    private UsuarioSrv usuarioService;
       
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String ssoId)
            throws UsernameNotFoundException {
    	
        UsuarioTO usuario = usuarioService.findBySSO(ssoId);
        
        if(usuario==null){
            throw new UsernameNotFoundException("Username not found");
        }
            return new org.springframework.security.core.userdetails.User(usuario.getssoId(), usuario.getPass(), 
                 true, true, true, true, getGrantedAuthorities(usuario));
    }
 
    private List<GrantedAuthority> getGrantedAuthorities(UsuarioTO usuario){
    	
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
         
        for(PerfilUsuarioTO userProfile : usuario.getUserProfiles()){
            authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getType()));
        }
        return authorities;
    }     
}