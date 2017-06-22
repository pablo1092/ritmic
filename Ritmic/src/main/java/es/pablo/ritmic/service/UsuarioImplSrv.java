package es.pablo.ritmic.service;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.pablo.ritmic.TO.CursoTO;
import es.pablo.ritmic.TO.UsuarioTO;
import es.pablo.ritmic.dao.UsuarioDAO;

@Service("usuarioService")
@Transactional
public class UsuarioImplSrv implements UsuarioSrv {
	
	    @Autowired
	    private UsuarioDAO dao;
	    
	    @Autowired
	    private PasswordEncoder passwordEncoder;
	     
	    public UsuarioTO findById(int id) {
	        return dao.findById(id);
	    }
	    
	    public UsuarioTO findBySSO(String sso) {
	    	UsuarioTO usuario = dao.findBySSO(sso);
	        return usuario;
	    }
	    
	    public List<UsuarioTO> findByCurso (int curso) {
	    	List<UsuarioTO> usuarios = dao.findByCurso(curso);
	    	return usuarios;
	    }
	 
	    public void saveUsuario(UsuarioTO usuario) {
	    	usuario.setPass(passwordEncoder.encode(usuario.getPass()));
	        dao.saveUsuario(usuario);
	    }
	 
	    public void updateUsuario(UsuarioTO usuario) {
	    	System.out.println("Entramos a update usuario");
	    	
	    	UsuarioTO entity = dao.findBySSO(usuario.getssoId());
	    	
	        if (entity!=null){	        		
	    		entity.setDireccion(usuario.getDireccion());
	    		entity.setPoblacion(usuario.getPoblacion());
	    		entity.setEmail(usuario.getEmail());
	    		
	    		//Si se ha actualizado la contraseaa
	    		if(!usuario.getPass().isEmpty()) {
	    			if(!usuario.getPass().equals(entity.getPass())){
		                entity.setPass(passwordEncoder.encode(usuario.getPass()));
		            }
	    		}
	        }
	    }
	    
	    public void cargarCurso(UsuarioTO usuario, CursoTO curso) {
	    	
	    	UsuarioTO entity = dao.findBySSO(usuario.getssoId());
	    	
	    	entity.setCursoActual(curso.getIdCurso());
	    }
	    
	    public void matricular(UsuarioTO usuario, CursoTO curso) {
	    	
	    	UsuarioTO entity = dao.findBySSO(usuario.getssoId());
	    	
	    	entity.getCursos().add(curso);
	    	entity.setCursoActual(curso.getIdCurso());
	    }
	    
	    public void deleteUserBySSO(String sso) {
	        dao.deleteBySSO(sso);
	    }
	     
	    public List<UsuarioTO> findAllUsuarios() {
	        return dao.findAllUsuarios();
	    }
	 
	    public boolean isUsuarioUnique(Integer id, String sso) {
	        UsuarioTO usuario = findBySSO(sso);
	        return (usuario == null || ((id != null) && (usuario.getIdUsuario() == id)));
	    }
	}