package es.pablo.ritmic.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import es.pablo.ritmic.TO.TipoFicheroTO;
 
@Repository("tipoFicheroDAO")
public class TipoFicheroDAOimpl extends AbstractDao<Integer, TipoFicheroTO>implements TipoFicheroDAO{
 
    public TipoFicheroTO findById(int id) {
        return getByKey(id);
    }
 
    public TipoFicheroTO findByTipo(String tipo) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("tipoFichero", tipo));
        return (TipoFicheroTO) crit.uniqueResult();
    }
     
    @SuppressWarnings("unchecked")
    public List<TipoFicheroTO> findAll(){
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("tipoFichero"));
        return (List<TipoFicheroTO>)crit.list();
    }
     
}
