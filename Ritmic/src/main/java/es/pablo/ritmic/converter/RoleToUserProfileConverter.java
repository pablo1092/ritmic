package es.pablo.ritmic.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import es.pablo.ritmic.TO.PerfilUsuarioTO;
import es.pablo.ritmic.service.PerfilUsuarioSrv;
 
@Component
public class RoleToUserProfileConverter implements Converter<Object, PerfilUsuarioTO>{
 
    static final Logger logger = LoggerFactory.getLogger(RoleToUserProfileConverter.class);
     
    @Autowired
    PerfilUsuarioSrv userProfileService;
 
    /**
     * Conversor perfilUsuario
     */
    public PerfilUsuarioTO convert(Object element) {
        Integer id = Integer.parseInt((String)element);
        PerfilUsuarioTO profile= userProfileService.findById(id);
        logger.info("PerfilUsuario : {}",profile);
       
        return profile;
    } 
}
