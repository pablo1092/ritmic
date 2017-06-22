package es.pablo.ritmic.dao;

import java.util.List;

import es.pablo.ritmic.TO.ActividadTO;
import es.pablo.ritmic.TO.CursoTO;

public interface ActividadDAO {
	
	public ActividadTO findById(int id);
	
	public List<ActividadTO> findByCurso(CursoTO curso);
	
	public List<ActividadTO> findAllActividades();
	
	public void saveActividad(ActividadTO actividad);
	
	public void deleteById(int id);
}
