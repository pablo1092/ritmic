package es.pablo.ritmic.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import es.pablo.ritmic.TO.CursoTO;
import es.pablo.ritmic.service.CursoSrv;
 
@Component
public class CursoToUserTOConverter implements Converter<Object, CursoTO>{
 
    static final Logger logger = LoggerFactory.getLogger(CursoToUserTOConverter.class);
     
    @Autowired
    CursoSrv cursoService;
 
    /**
     * Conversor curso
     */
    public CursoTO convert(Object element) {
    	
    	if(element.getClass()!= CursoTO.class) {
    		
    		System.out.println("Vamos a convertir el curso");
        	
            Integer id = Integer.parseInt((String)element);
            CursoTO curso= cursoService.findById(id);
            logger.info("Curso : {}",curso);
            
            return curso;
    	}
    	
    	return (CursoTO)element;
    } 
}
