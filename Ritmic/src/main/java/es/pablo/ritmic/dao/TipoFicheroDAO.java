package es.pablo.ritmic.dao;

import java.util.List;

import es.pablo.ritmic.TO.TipoFicheroTO;

public interface TipoFicheroDAO {
	
	public TipoFicheroTO findById(int id);
   
	public TipoFicheroTO findByTipo(String tipo);
     
	public List<TipoFicheroTO> findAll();
}
