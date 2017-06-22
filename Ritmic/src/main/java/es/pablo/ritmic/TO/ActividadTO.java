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
@Table(name="Actividad")
public class ActividadTO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idActividad;
	
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTipoActividad")
    private TipoActividadTO tipoActividad;
	
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCurso")
    private CursoTO curso;
	
	@NotNull
    @Column(name="descripActividad", nullable=false)
    private String descripActividad;
	
	@NotNull
	@Column(name="dificultadActividad", nullable = false)
	private int dificultadActividad;
	
	//Metodos Getters
	public int getIdActividad() {
		return this.idActividad;
	}
	
	public TipoActividadTO getIdTipoActividad() {
		return this.tipoActividad;
	}
	
	public CursoTO getIdCurso() {
		return this.curso;
	}
	
	public String getDescripActividad() {
		return this.descripActividad;
	}

	public int getDificultadActividad() {
		return this.dificultadActividad;
	}

	//Metodos Setters
	public void setIdActividad(int id) {
		this.idActividad = id;
	}
	
	public void setIdTipoActividad(TipoActividadTO tipoActividad) {
		this.tipoActividad = tipoActividad;
	}
	
	public void setIdCurso(CursoTO curso) {
		this.curso = curso;
	}
	
	public void setDescripActividad(String descripcion) {
		this.descripActividad = descripcion;
	}

	public void setDificultadActividad(int dif) {
		this.dificultadActividad = dif;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((descripActividad == null) ? 0 : descripActividad.hashCode());
		result = prime * result + dificultadActividad;
		result = prime * result + idActividad;
		result = prime * result + ((tipoActividad == null) ? 0 : tipoActividad.hashCode());
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
		ActividadTO other = (ActividadTO) obj;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (descripActividad == null) {
			if (other.descripActividad != null)
				return false;
		} else if (!descripActividad.equals(other.descripActividad))
			return false;
		if (dificultadActividad != other.dificultadActividad)
			return false;
		if (idActividad != other.idActividad)
			return false;
		if (tipoActividad == null) {
			if (other.tipoActividad != null)
				return false;
		} else if (!tipoActividad.equals(other.tipoActividad))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ActividadTO [idActividad=" + idActividad + ", tipoActividad=" + tipoActividad + ", curso=" + curso
				+ ", descripActividad=" + descripActividad + ", dificultadActividad=" + dificultadActividad + "]";
	}

}
