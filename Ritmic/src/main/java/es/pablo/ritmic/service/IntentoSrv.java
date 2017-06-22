package es.pablo.ritmic.service;

import java.util.List;

import es.pablo.ritmic.TO.IntentoTO;

public interface IntentoSrv {
	
	public IntentoTO findById(int id);
	
	public List<IntentoTO> findByAlumno(int idAlumno, int idCurso);
	
	public List<IntentoTO> findAllIntentos();
	
	public void saveIntento(IntentoTO intento);
	
	public float calcularMedia(int idAlumno, int idCurso);
}
