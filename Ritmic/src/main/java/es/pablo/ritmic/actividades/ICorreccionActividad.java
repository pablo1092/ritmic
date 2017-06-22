package es.pablo.ritmic.actividades;

import es.ua.dlsi.im3.IM3Exception;

public interface ICorreccionActividad {
	/**
	 * 
	 * @return Valor entre 0 y 10. 0 es peor
	 * @throws IM2Exception 
	 */
	public double corrige() throws IM3Exception;
}
