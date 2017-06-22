package es.pablo.ritmic.service;

import java.util.List;

import es.pablo.ritmic.TO.PerfilUsuarioTO;
 
public interface PerfilUsuarioSrv {
 
    public PerfilUsuarioTO findById(int id);
 
    public PerfilUsuarioTO findByType(String type);
     
    public List<PerfilUsuarioTO> findAll();
     
}
