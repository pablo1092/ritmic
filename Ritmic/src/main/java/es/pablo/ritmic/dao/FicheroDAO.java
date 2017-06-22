package es.pablo.ritmic.dao;

import java.util.List;

import es.pablo.ritmic.TO.FicheroTO;
import es.pablo.ritmic.TO.TipoFicheroTO;

public interface FicheroDAO {
	
	public FicheroTO findById(int id);
	
	public FicheroTO findByTipo(TipoFicheroTO tipo);
	
	public FicheroTO findByIdActividad(int idActividad);
	
	public List<FicheroTO> findAllFicheros();
	
	public void saveFichero(FicheroTO fichero);
	
	public void deleteFicheroById(int id);
}
