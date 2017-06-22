package es.pablo.ritmic.dao;

import java.util.List;

import es.pablo.ritmic.TO.PerfilUsuarioTO;
 
public interface PerfilUsuarioDAO {
 
    public List<PerfilUsuarioTO> findAll();
     
    public PerfilUsuarioTO findByType(String type);
     
    public PerfilUsuarioTO findById(int id);
}
