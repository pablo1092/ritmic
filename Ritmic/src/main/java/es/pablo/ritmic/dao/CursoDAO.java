package es.pablo.ritmic.dao;

import java.util.List;

import es.pablo.ritmic.TO.CursoTO;

public interface CursoDAO {
	
	public CursoTO findById(int id);
	
	public CursoTO findByDescrip(String descrip);
	
	public List<CursoTO> findByProfesor(int id);
	
	public List<CursoTO> findAllCursos();
	
	public void saveCurso(CursoTO curso);
	
	public void deleteCursoById(int id);
}
