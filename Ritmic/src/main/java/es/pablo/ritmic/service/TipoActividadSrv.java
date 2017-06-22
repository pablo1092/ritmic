package es.pablo.ritmic.service;

import java.util.List;

import es.pablo.ritmic.TO.TipoActividadTO;
 
public interface TipoActividadSrv {
 
	public TipoActividadTO findById(int id);
 
	public TipoActividadTO findByTipo(String tipo);
     
    public List<TipoActividadTO> findAll();
}
