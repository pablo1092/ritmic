package es.pablo.ritmic.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import es.pablo.ritmic.TO.TipoFicheroTO;
import es.pablo.ritmic.service.TipoFicheroSrv;
 
@Component
public class TipoFicheroToTipoFicheroTOConverter implements Converter<Object, TipoFicheroTO>{
 
    static final Logger logger = LoggerFactory.getLogger(TipoFicheroToTipoFicheroTOConverter.class);
     
    @Autowired
    TipoFicheroSrv tipoFicheroService;
 
    /**
     * Conversor TipoFichero
     */
    public TipoFicheroTO convert(Object element) {
        Integer id = Integer.parseInt((String)element);
        TipoFicheroTO tipoFichero= tipoFicheroService.findById(id);
        logger.info("Fichero : {}",tipoFichero);
        
        return tipoFichero;
    } 
}
