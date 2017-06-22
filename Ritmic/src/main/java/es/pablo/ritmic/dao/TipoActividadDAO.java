package es.pablo.ritmic.dao;

import java.util.List;

import es.pablo.ritmic.TO.TipoActividadTO;

public interface TipoActividadDAO {
	
    public List<TipoActividadTO> findAll();
   
    public TipoActividadTO findByTipo(String tipo);
     
    public TipoActividadTO findById(int id);
}
