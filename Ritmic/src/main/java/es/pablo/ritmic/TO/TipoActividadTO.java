package es.pablo.ritmic.TO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name="tipoActividad")
public class TipoActividadTO implements Serializable{
 
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idtipoActividad; 
 
    @Column(name="tipo", unique=true, nullable=false)
    private String tipo;
     
    public Integer getidtipoActividad() {
        return idtipoActividad;
    }
 
    public void setIdTipoActividad(Integer idtipoActividad) {
        this.idtipoActividad = idtipoActividad;
    }
 
    public String getTipo() {
        return tipo;
    }
 
    public void setType(String tipo) {
        this.tipo = tipo;
    }
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idtipoActividad == null) ? 0 : idtipoActividad.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoActividadTO other = (TipoActividadTO) obj;
		if (idtipoActividad == null) {
			if (other.idtipoActividad != null)
				return false;
		} else if (!idtipoActividad.equals(other.idtipoActividad))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	@Override
    public String toString() {
        return "TipoActividad [idtipoActividad=" + idtipoActividad + ", tipo=" + tipo + "]";
    }
}