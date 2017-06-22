package es.pablo.ritmic.dao;

import java.util.List;
 
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import es.pablo.ritmic.TO.CursoTO;
 
@Repository("cursoDao")
public class CursoDAOimpl extends AbstractDao<Integer, CursoTO> implements CursoDAO {
 
    public CursoTO findById(int id) {
    	CursoTO curso = getByKey(id);
  
        return curso;
    }
    
    public CursoTO findByDescrip(String descrip) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("descripcion", descrip));
        CursoTO curso = (CursoTO)crit.uniqueResult();
        return curso;
    }
    
    @SuppressWarnings("unchecked")
    public List<CursoTO> findByProfesor(int id) {
    	Criteria crit = createEntityCriteria().addOrder(Order.asc("idCurso"));
    	crit.add(Restrictions.eq("idProfesor", id));
    	List<CursoTO> cursos = (List<CursoTO>) crit.list();
    	
    	return cursos;
    }
    
    @SuppressWarnings("unchecked")
    public List<CursoTO> findAllCursos() {
    	Criteria criteria = createEntityCriteria().addOrder(Order.asc("descripcion"));
    	criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    	List<CursoTO> cursos = (List<CursoTO>) criteria.list();
    
        return cursos;
    }
 
    public void saveCurso(CursoTO curso) {
        persist(curso);
    }
 
    public void deleteCursoById(int id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("idCurso", id));
        CursoTO curso = (CursoTO)crit.uniqueResult();
        delete(curso);
    }
}
