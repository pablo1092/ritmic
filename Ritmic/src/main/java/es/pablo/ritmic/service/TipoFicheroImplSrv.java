package es.pablo.ritmic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import es.pablo.ritmic.TO.TipoFicheroTO;
import es.pablo.ritmic.dao.TipoFicheroDAO;


@Service("tipoFicheroServ")
@Transactional
public class TipoFicheroImplSrv implements TipoFicheroSrv{
     
    @Autowired
    TipoFicheroDAO dao;
     
    public TipoFicheroTO findById(int id) {
        return dao.findById(id);
    }
 
    public TipoFicheroTO findByTipo(String tipo){
        return dao.findByTipo(tipo);
    }
 
    public List<TipoFicheroTO> findAll() {
        return dao.findAll();
    }
}
