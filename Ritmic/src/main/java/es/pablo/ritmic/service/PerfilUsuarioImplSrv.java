package es.pablo.ritmic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import es.pablo.ritmic.TO.PerfilUsuarioTO;
import es.pablo.ritmic.dao.PerfilUsuarioDAO;

@Service("perfilUsuarioServ")
@Transactional
public class PerfilUsuarioImplSrv implements PerfilUsuarioSrv{
     
    @Autowired
    PerfilUsuarioDAO dao;
     
    public PerfilUsuarioTO findById(int id) {
        return dao.findById(id);
    }
 
    public PerfilUsuarioTO findByType(String type){
        return dao.findByType(type);
    }
 
    public List<PerfilUsuarioTO> findAll() {
        return dao.findAll();
    }
}
