package es.pablo.ritmic.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import es.pablo.ritmic.TO.TipoActividadTO;
 
@Repository("tipoActividadDAO")
public class TipoActividadDAOimpl extends AbstractDao<Integer, TipoActividadTO>implements TipoActividadDAO{
 
    public TipoActividadTO findById(int id) {
        return getByKey(id);
    }
 
    public TipoActividadTO findByTipo(String tipo) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("tipo", tipo));
        return (TipoActividadTO) crit.uniqueResult();
    }
     
    @SuppressWarnings("unchecked")
    public List<TipoActividadTO> findAll(){
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("tipo"));
        return (List<TipoActividadTO>)crit.list();
    }
     
}
