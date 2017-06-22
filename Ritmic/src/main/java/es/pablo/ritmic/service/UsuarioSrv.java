package es.pablo.ritmic.service;

import java.util.List;

import es.pablo.ritmic.TO.CursoTO;
import es.pablo.ritmic.TO.UsuarioTO;

public interface UsuarioSrv {
	
	public UsuarioTO findById(int id);
	
	public UsuarioTO findBySSO(String sso);
	
	public List<UsuarioTO> findByCurso (int curso);
	
	public void saveUsuario(UsuarioTO usuario);
	
	public void updateUsuario(UsuarioTO usuario);
	
	public void matricular(UsuarioTO usuario, CursoTO curso);
	
	public void cargarCurso(UsuarioTO usuario, CursoTO curso);
	
	public void deleteUserBySSO(String sso);
	
	public List<UsuarioTO> findAllUsuarios();
	
	public boolean isUsuarioUnique(Integer id, String sso);
}
