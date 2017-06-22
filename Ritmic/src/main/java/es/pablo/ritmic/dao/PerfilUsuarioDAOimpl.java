package es.pablo.ritmic.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import es.pablo.ritmic.TO.PerfilUsuarioTO;
 
@Repository("perfilUsuarioDAO")
public class PerfilUsuarioDAOimpl extends AbstractDao<Integer, PerfilUsuarioTO>implements PerfilUsuarioDAO{
 
    public PerfilUsuarioTO findById(int id) {
        return getByKey(id);
    }
 
    public PerfilUsuarioTO findByType(String type) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("type", type));
        return (PerfilUsuarioTO) crit.uniqueResult();
    }
     
    @SuppressWarnings("unchecked")
    public List<PerfilUsuarioTO> findAll(){
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("type"));
        return (List<PerfilUsuarioTO>)crit.list();
    }
     
}
