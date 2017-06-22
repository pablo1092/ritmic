package es.pablo.ritmic.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import es.pablo.ritmic.TO.ActividadTO;
import es.pablo.ritmic.TO.CursoTO;

@Repository("actividadDao")
public class ActividadDAOimpl extends AbstractDao<Integer, ActividadTO> implements ActividadDAO {
 
    public ActividadTO findById(int id) {
    	ActividadTO actividad = getByKey(id);
    	
    	if(actividad!=null){
            Hibernate.initialize(actividad.getIdCurso());
            Hibernate.initialize(actividad.getIdTipoActividad());
        }
        return actividad;
    }
    
    @SuppressWarnings("unchecked")
    public List<ActividadTO> findByCurso(CursoTO curso) {
    	Criteria criteria = createEntityCriteria().addOrder(Order.asc("dificultadActividad"));
    	criteria.add(Restrictions.eq("curso", curso));
    	
    	List<ActividadTO> actividades = (List<ActividadTO>) criteria.list();
        return actividades;
    }
    
    @SuppressWarnings("unchecked")
    public List<ActividadTO> findAllActividades() {
    	Criteria criteria = createEntityCriteria().addOrder(Order.asc("dificultadActividad"));
    	criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    	List<ActividadTO> actividades = (List<ActividadTO>) criteria.list();
    	
        return actividades;
    }
    
 
    public void saveActividad(ActividadTO actividad) {
    	System.out.println("Actividad" + actividad);
        persist(actividad);
    }
    
 
    public void deleteById(int id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("idActividad", id));
        ActividadTO actividad = (ActividadTO)crit.uniqueResult();
        delete(actividad);
    }
 

}
