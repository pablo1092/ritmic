package es.pablo.ritmic.TO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.JoinColumn;


@Entity
@Table(name="Fichero")
public class FicheroTO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFichero;
	
	@NotNull
    @Column(name="xpath", nullable=false)
    private String xpath;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTipoFichero")
    private TipoFicheroTO tipoFichero;
	
	@NotNull
	@Column(name="idActividad")
	private int idActividad;
	
	//Metodos Getters
	public int getIdFichero() {
		return this.idFichero;
	}
	
	public String getXpath() {
		return this.xpath;
	}

	public TipoFicheroTO getIdTipoFichero() {
		return this.tipoFichero;
	}
	
	public int getIdActividad() {
		return this.idActividad;
	}

	//Metodos Setters
	public void setIdFichero(int id) {
		this.idFichero = id;
	}
	
	public void setXpath(String xpath) {
		this.xpath = xpath;
	}
	
	public void setIdTipoFichero(TipoFicheroTO tipoFichero) {
		this.tipoFichero = tipoFichero;
	}
	
	public void setIdActividad(int id) {
		this.idActividad = id;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idFichero;
		result = prime * result + ((tipoFichero == null) ? 0 : tipoFichero.hashCode());
		result = prime * result + ((xpath == null) ? 0 : xpath.hashCode());
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
		FicheroTO other = (FicheroTO) obj;
		if (idFichero != other.idFichero)
			return false;
		if (tipoFichero == null) {
			if (other.tipoFichero != null)
				return false;
		} else if (!tipoFichero.equals(other.tipoFichero))
			return false;
		if (xpath == null) {
			if (other.xpath != null)
				return false;
		} else if (!xpath.equals(other.xpath))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FicheroTO [idFichero=" + idFichero + ", xpath=" + xpath + ", tipoFichero=" + tipoFichero + "]";
	}
	
	
}
