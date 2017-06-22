package es.pablo.ritmic.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import es.pablo.ritmic.TO.TipoActividadTO;
import es.pablo.ritmic.service.TipoActividadSrv;
 
@Component
public class TipoActividadToTipoActividadTOConverter implements Converter<Object, TipoActividadTO>{
 
    static final Logger logger = LoggerFactory.getLogger(TipoActividadToTipoActividadTOConverter.class);
     
    @Autowired
    TipoActividadSrv tipoActividadService;
 
    /**
     * Conversor actividad
     */
    public TipoActividadTO convert(Object element) {
        Integer id = Integer.parseInt((String)element);
        TipoActividadTO actividad= tipoActividadService.findById(id);
        logger.info("Actividad : {}",actividad);
        
        return actividad;
    } 
}
