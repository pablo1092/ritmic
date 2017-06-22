package es.pablo.ritmic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import es.pablo.ritmic.TO.TipoActividadTO;
import es.pablo.ritmic.dao.TipoActividadDAO;


@Service("tipoActividadServ")
@Transactional
public class TipoActividadImplSrv implements TipoActividadSrv{
     
    @Autowired
    TipoActividadDAO dao;
     
    public TipoActividadTO findById(int id) {
        return dao.findById(id);
    }
 
    public TipoActividadTO findByTipo(String tipo){
        return dao.findByTipo(tipo);
    }
 
    public List<TipoActividadTO> findAll() {
        return dao.findAll();
    }
}
