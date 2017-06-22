package es.pablo.ritmic.service;

import java.util.List;

import es.pablo.ritmic.TO.CursoTO;

public interface CursoSrv {
	
	public CursoTO findById(int id);
	
	public CursoTO findByDescrip(String descrip);
	
	public List<CursoTO> findByProfesor(int id);
	
	public void saveCurso(CursoTO curso);
	
	public void deleteCursoById(int id);
	
	public List<CursoTO> findAllCursos();
}
