package es.pablo.ritmic.TO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="tipofichero")
public class TipoFicheroTO implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTipoFichero;
	
	@NotNull
    @Column(name="tipoFichero", nullable=false)
    private String tipoFichero;
	
	//Metodos Getters
	public int getIdTipoFichero() {
		return this.idTipoFichero;
	}
	
	public String getTipoFichero() {
		return this.tipoFichero;
	}

	//Metodos Setters
	public void setIdTipoFichero(int id) {
		this.idTipoFichero = id;
	}
	
	public void setTipoFichero(String tipoFichero) {
		this.tipoFichero = tipoFichero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTipoFichero;
		result = prime * result + ((tipoFichero == null) ? 0 : tipoFichero.hashCode());
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
		TipoFicheroTO other = (TipoFicheroTO) obj;
		if (idTipoFichero != other.idTipoFichero)
			return false;
		if (tipoFichero == null) {
			if (other.tipoFichero != null)
				return false;
		} else if (!tipoFichero.equals(other.tipoFichero))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TipoFicheroTO [idTipoFichero=" + idTipoFichero + ", tipoFichero=" + tipoFichero + "]";
	}
}
