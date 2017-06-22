package es.pablo.ritmic.service;

import java.util.Iterator;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.pablo.ritmic.TO.IntentoTO;
import es.pablo.ritmic.dao.IntentoDAO;

@Service("intentoService")
@Transactional
public class IntentoImplSrv implements IntentoSrv {
	
	    @Autowired
	    private IntentoDAO dao;

	    public IntentoTO findById(int id) {
	        return dao.findById(id);
	    }

	    public List<IntentoTO> findByAlumno(int idAlumno, int idCurso) {
	    	List<IntentoTO> intento = dao.findAllByAlumnoCurso(idAlumno, idCurso);
	        return intento;
	    }
	    
	   public List<IntentoTO> findAllIntentos() {
		   List<IntentoTO> intentos = dao.findAllIntentos();
		   return intentos;
	   }
	   		
	    public void saveIntento(IntentoTO intento) {
	        dao.saveIntento(intento);
	    }
	    
	    //Matodo para calcular la media de puntuaciones para un alumno de todas las actividades
	    //de un alumno - Curso
	    public float calcularMedia(int idAlumno, int idCurso) {
	    	
	    	float media = 0;
	    	
	    	List<IntentoTO> allIntentos = dao.findAllByAlumnoCurso(idAlumno, idCurso);
	    	
	    	Iterator<IntentoTO> it = allIntentos.iterator();
	    	
	    	while(it.hasNext()) {
	    		media = media + it.next().getPuntuacion();
	    	}
	    	
	    	media = media / allIntentos.size();
	    	
	    	return media;
	    }
	}