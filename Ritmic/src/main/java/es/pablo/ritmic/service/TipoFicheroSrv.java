package es.pablo.ritmic.service;

import java.util.List;

import es.pablo.ritmic.TO.TipoFicheroTO;
 
public interface TipoFicheroSrv {
 
	public TipoFicheroTO findById(int id);
	
	public TipoFicheroTO findByTipo(String tipo);
	
	public List<TipoFicheroTO> findAll();
}
