package es.pablo.ritmic.service;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.pablo.ritmic.TO.FicheroTO;
import es.pablo.ritmic.TO.TipoFicheroTO;
import es.pablo.ritmic.dao.FicheroDAO;

@Service("FicheroService")
@Transactional
public class FicheroImplSrv implements FicheroSrv {
	
	    @Autowired
	    private FicheroDAO dao;

	    public FicheroTO findById(int id) {
	        return dao.findById(id);
	    }

	    public FicheroTO findByTipo(TipoFicheroTO tipo) {
	    	FicheroTO fichero = dao.findByTipo(tipo);
	        return fichero;
	    }
	    
	    public FicheroTO finByIdActividad(int id) {
	    	FicheroTO fichero = dao.findByIdActividad(id);
	    	return fichero;
	    }
	    
	    public List<FicheroTO> findAllFicheros() {
	        return dao.findAllFicheros();
	    }

	    public void saveFichero(FicheroTO fichero) {
	        dao.saveFichero(fichero);
	    }
	     
		public void deleteFicheroById(int id) {
			dao.deleteFicheroById(id);
		}
	}