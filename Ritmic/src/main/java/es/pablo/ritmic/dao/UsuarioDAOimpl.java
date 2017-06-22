package es.pablo.ritmic.dao;

import java.util.List;
 
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import es.pablo.ritmic.TO.UsuarioTO;

 
@Repository("UsuarioDao")
public class UsuarioDAOimpl extends AbstractDao<Integer, UsuarioTO> implements UsuarioDAO {
 
    public UsuarioTO findById(int id) {
    	UsuarioTO usuario = getByKey(id);
    	
    	if(usuario!=null){
            Hibernate.initialize(usuario.getUserProfiles());
            Hibernate.initialize(usuario.getCursos());
        }
        return usuario;
    }
    
    public UsuarioTO findBySSO(String sso) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        UsuarioTO usuario = (UsuarioTO)crit.uniqueResult();
        if(usuario!=null){
            Hibernate.initialize(usuario.getUserProfiles());
        }
        return usuario;
    }
    
    @SuppressWarnings("unchecked")
    public List<UsuarioTO> findByCurso(int id) {
    	Criteria crit = createEntityCriteria();
    	crit.createAlias("cursos", "cursosAlias");
    	crit.add(Restrictions.eq("cursosAlias.idCurso", id));
    	crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//Para evitar duplicados
    	List<UsuarioTO> usuarios = (List<UsuarioTO>) crit.list();
		return usuarios;
    }
    
    @SuppressWarnings("unchecked")
    public List<UsuarioTO> findAllUsuarios() {
    	Criteria criteria = createEntityCriteria().addOrder(Order.asc("nombre"));
    	criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//Para evitar duplicados
    	List<UsuarioTO> usuarios = (List<UsuarioTO>) criteria.list();
    
        return usuarios;
    }
 
    public void saveUsuario(UsuarioTO usuario) {
    	System.out.println("Save usuario" + usuario);
        persist(usuario);
    }
    
    public void deleteBySSO(String sso) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        UsuarioTO usuario = (UsuarioTO)crit.uniqueResult();
        delete(usuario);
    }
}
