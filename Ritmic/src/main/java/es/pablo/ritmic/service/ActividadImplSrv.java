package es.pablo.ritmic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.pablo.ritmic.TO.ActividadTO;
import es.pablo.ritmic.TO.CursoTO;
import es.pablo.ritmic.dao.ActividadDAO;

@Service("actividadService")
@Transactional
public class ActividadImplSrv implements ActividadSrv {
	
	    @Autowired
	    private ActividadDAO dao;
	     
	    public ActividadTO findById(int id) {
	        return dao.findById(id);
	    }
	    
	    public List<ActividadTO> findByCurso(CursoTO curso) {
	    	List<ActividadTO> actividades = dao.findByCurso(curso);
	        return actividades;
	    }
	    
	    public List<ActividadTO> findAllActividades() {
	    	List<ActividadTO> actividades = dao.findAllActividades();
	    	return actividades;
	    }
	 
	    public void saveActividad(ActividadTO actividad) {
	        dao.saveActividad(actividad);
	    }
	 
	    public void deleteById(int id) {
	        dao.deleteById(id);
	    }
	}