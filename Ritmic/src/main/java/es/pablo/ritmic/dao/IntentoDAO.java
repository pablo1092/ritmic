package es.pablo.ritmic.dao;

import java.util.List;

import es.pablo.ritmic.TO.IntentoTO;

public interface IntentoDAO {
	
	public IntentoTO findById(int id);
	
	public List<IntentoTO> findAllByAlumnoCurso(int idAlumno, int idCurso);
	
	public List<IntentoTO> findAllIntentos();
	
	public void saveIntento(IntentoTO intento);
}
