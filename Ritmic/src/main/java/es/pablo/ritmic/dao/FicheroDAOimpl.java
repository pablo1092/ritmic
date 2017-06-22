package es.pablo.ritmic.dao;

import java.util.List;
 
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import es.pablo.ritmic.TO.FicheroTO;
import es.pablo.ritmic.TO.TipoFicheroTO;
 
@Repository("FicheroDao")
public class FicheroDAOimpl extends AbstractDao<Integer, FicheroTO> implements FicheroDAO {
 
    public FicheroTO findById(int id) {
    	FicheroTO fichero = getByKey(id);
  
        return fichero;
    }
    
    public FicheroTO findByTipo(TipoFicheroTO tipo) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("idTipoFichero", tipo));
        FicheroTO fichero = (FicheroTO)crit.uniqueResult();
        return fichero;
    }
    
    public FicheroTO findByIdActividad(int idActividad) {
    	Criteria crit = createEntityCriteria();
    	crit.add(Restrictions.eq("idActividad", idActividad));
    	FicheroTO fichero = (FicheroTO)crit.uniqueResult();
    	return fichero;
    }
    
    @SuppressWarnings("unchecked")
    public List<FicheroTO> findAllFicheros() {
    	Criteria criteria = createEntityCriteria().addOrder(Order.asc("idFichero"));
    	criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    	List<FicheroTO> ficheros = (List<FicheroTO>) criteria.list();
    
        return ficheros;
    }
 
    public void saveFichero(FicheroTO fichero) {
    	System.out.println("fichero" + fichero);
        persist(fichero);
    }
 
    public void deleteFicheroById(int id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("idFichero", id));
        FicheroTO fichero = (FicheroTO)crit.uniqueResult();
        delete(fichero);
    }
}
