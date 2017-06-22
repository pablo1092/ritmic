package es.pablo.ritmic.dao;

import java.util.List;

import es.pablo.ritmic.TO.UsuarioTO;

public interface UsuarioDAO {
	
	public UsuarioTO findById(int id);
	
	public UsuarioTO findBySSO(String sso);
	
	public List<UsuarioTO> findByCurso(int id);
	
	public List<UsuarioTO> findAllUsuarios();
	
	public void saveUsuario(UsuarioTO usuario);
	
	public void deleteBySSO(String sso);
}
