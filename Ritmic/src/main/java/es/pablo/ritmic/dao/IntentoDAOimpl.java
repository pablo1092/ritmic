package es.pablo.ritmic.dao;

import java.util.List;
 
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import es.pablo.ritmic.TO.IntentoTO;
 
@Repository("IntentoDao")
public class IntentoDAOimpl extends AbstractDao<Integer, IntentoTO> implements IntentoDAO {
 
    public IntentoTO findById(int id) {
    	IntentoTO intento = getByKey(id);
  
        return intento;
    }
    
    @SuppressWarnings("unchecked")
    public List<IntentoTO> findAllByAlumnoCurso(int idAlumno, int idCurso) {
    	Criteria crit = createEntityCriteria();
    	crit.add(Restrictions.eq("idAlumno", idAlumno));
    	crit.add(Restrictions.eq("idCurso", idCurso));
    	List<IntentoTO> intentos = (List<IntentoTO>) crit.list();
    	
    	return intentos;
    }
    
    @SuppressWarnings("unchecked")
    public List<IntentoTO> findAllIntentos() {
    	Criteria criteria = createEntityCriteria().addOrder(Order.asc("idAlumno"));
    	criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    	List<IntentoTO> intentos = (List<IntentoTO>) criteria.list();
    
        return intentos;
    }
 
    public void saveIntento(IntentoTO intento) {
        persist(intento);
    }
}
