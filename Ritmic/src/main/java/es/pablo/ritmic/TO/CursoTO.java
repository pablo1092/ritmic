package es.pablo.ritmic.TO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="Curso")
public class CursoTO {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCurso;
	
	@NotNull
    @Column(name="descripcion", nullable=false)
    private String descripcion;
	
	@NotNull
	@Column(name="idProfesor", nullable=false)
	private int idProfesor;
	
	//Metodos Getters
	public int getIdCurso() {
		return this.idCurso;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}
	
	public int getIdProfesor() {
		return this.idProfesor;
	}
	
	//Metodos Setters
	public void setIdCurso(int id){
		this.idCurso = id;
	}
	
	public void setDescripcion(String desc){
		this.descripcion = desc;
	}
	
	public void setIdProfesor(int id) {
		this.idProfesor = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + idCurso;
		result = prime * result + idProfesor;
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
		CursoTO other = (CursoTO) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (idCurso != other.idCurso)
			return false;
		if (idProfesor != other.idProfesor)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CursoTO [idCurso=" + idCurso + ", descripcion=" + descripcion + ", idProfesor=" + idProfesor + "]";
	}
	
   
}
