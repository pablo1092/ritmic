package es.pablo.ritmic.TO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Intento")
public class IntentoTO implements java.io.Serializable  {
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idIntento;
	
	@NotNull
	@Column(name="puntuacion", nullable=false)
	float puntuacion;
	
	@NotNull
	@Column(name="ejecucionAlumno", nullable=false)
	String ejecucionAlumno;
	
	@NotNull
	@Column(name = "idUsuario",  nullable=false)
	private int idAlumno;
	
	@NotNull
	@Column(name = "idActividad", nullable=false)
	private int idActividad;
	
	@NotNull
	@Column(name="idCurso", nullable=false)
	private int idCurso;
	

	public int getIdIntento() {
		return idIntento;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public int getIdActividad() {
		return idActividad;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public float getPuntuacion() {
		return puntuacion;
	}

	public String getEjecucionAlumno() {
		return ejecucionAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public void setIdActividad(int idActividad) {
		this.idActividad = idActividad;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public void setPuntuacion(float puntuacion) {
		this.puntuacion = puntuacion;
	}

	public void setEjecucionAlumno(String ejecucionAlumno) {
		this.ejecucionAlumno = ejecucionAlumno;
	}
}
