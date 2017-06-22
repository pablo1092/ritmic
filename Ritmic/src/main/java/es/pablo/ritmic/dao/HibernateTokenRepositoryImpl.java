package es.pablo.ritmic.dao;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
import es.pablo.ritmic.TO.PersistentLoginTO;
 
@Repository("tokenRepositoryDao")
@Transactional
public class HibernateTokenRepositoryImpl extends AbstractDao<String, PersistentLoginTO>
        implements PersistentTokenRepository {
 
    static final Logger logger = LoggerFactory.getLogger(HibernateTokenRepositoryImpl.class);
 
    public void createNewToken(PersistentRememberMeToken token) {
        logger.info("Crear Token para usuario : {}", token.getUsername());
        PersistentLoginTO persistentLogin = new PersistentLoginTO();
        persistentLogin.setUsername(token.getUsername());
        persistentLogin.setSeries(token.getSeries());
        persistentLogin.setToken(token.getTokenValue());
        persistentLogin.setLast_used(token.getDate());
        persist(persistentLogin);
    }
 
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        try {
            Criteria crit = createEntityCriteria();
            crit.add(Restrictions.eq("series", seriesId));
            PersistentLoginTO persistentLogin = (PersistentLoginTO) crit.uniqueResult();
 
            return new PersistentRememberMeToken(persistentLogin.getUsername(), persistentLogin.getSeries(),
                    persistentLogin.getToken(), persistentLogin.getLast_used());
        } catch (Exception e) {
            logger.info("Token no valido...");
            return null;
        }
    }
 
    public void removeUserTokens(String username) {
        logger.info("Eliminar token: {}", username);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("username", username));
        PersistentLoginTO persistentLogin = (PersistentLoginTO) crit.uniqueResult();
        if (persistentLogin != null) {
            logger.info("rememberMe ha sido seleccionado");
            delete(persistentLogin);
        }
    }
 
    public void updateToken(String seriesId, String tokenValue, Date lastUsed) {
        logger.info("Actualización Token for seriesId : {}", seriesId);
        PersistentLoginTO persistentLogin = getByKey(seriesId);
        persistentLogin.setToken(tokenValue);
        persistentLogin.setLast_used(lastUsed);
        update(persistentLogin);
    }
 
}
