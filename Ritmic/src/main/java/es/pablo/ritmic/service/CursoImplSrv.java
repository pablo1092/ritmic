package es.pablo.ritmic.service;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.pablo.ritmic.TO.CursoTO;
import es.pablo.ritmic.dao.CursoDAO;

@Service("cursoService")
@Transactional
public class CursoImplSrv implements CursoSrv {
	
	    @Autowired
	    private CursoDAO dao;

	    public CursoTO findById(int id) {
	        return dao.findById(id);
	    }

	    public CursoTO findByDescrip(String descrip) {
	    	CursoTO curso = dao.findByDescrip(descrip);
	        return curso;
	    }
	    
	    public List<CursoTO> findByProfesor(int id) {
	    	List<CursoTO> cursos = dao.findByProfesor(id);
	    	return cursos;
	    }

	    public void saveCurso(CursoTO curso) {
	        dao.saveCurso(curso);
	    }
	     
	    public List<CursoTO> findAllCursos() {
	        return dao.findAllCursos();
	    }

		public void deleteCursoById(int id) {
			dao.deleteCursoById(id);
		}
	}