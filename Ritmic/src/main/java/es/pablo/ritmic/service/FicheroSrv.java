package es.pablo.ritmic.service;

import java.util.List;

import es.pablo.ritmic.TO.FicheroTO;
import es.pablo.ritmic.TO.TipoFicheroTO;

public interface FicheroSrv {

	public FicheroTO findById(int id);
	
	public FicheroTO findByTipo(TipoFicheroTO tipo);
	
	public FicheroTO finByIdActividad(int id);
	
	public List<FicheroTO> findAllFicheros();
	
	public void saveFichero(FicheroTO fichero);
	
	public void deleteFicheroById(int id);
}
