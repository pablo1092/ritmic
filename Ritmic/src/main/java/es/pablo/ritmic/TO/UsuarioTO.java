package es.pablo.ritmic.TO;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.persistence.JoinColumn;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Usuario")
public class UsuarioTO implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUsuario;
	
	@NotNull
    @Column(name="sso_id", unique=true, nullable=false)
    private String ssoId;
	
	@NotNull
	@Column(nullable = false, unique=true)
	private String email;

	@NotNull
	@Column(name="pass", nullable=false)
	private String pass;
	
	@NotNull
	@Column(nullable = false)
	private String nombre;
	
	@NotNull
	@Column(nullable = false)
	private String apellidos;
	
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy") 
	private Date fechaNacimiento;
	
	@NotNull
	@Column(name="direccion")
	private String direccion;
	
	@NotNull
	@Column(name="poblacion")
	private String poblacion;
	
	@NotNull
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "APP_USER_USER_PROFILE", 
	         joinColumns = { @JoinColumn(name = "user_id") }, 
	         inverseJoinColumns = { @JoinColumn(name = "User_Profile_id") })
	private Set<PerfilUsuarioTO> userProfiles = new HashSet<PerfilUsuarioTO>();
	
	@NotNull
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "ALUMNO_CURSO", 
	         joinColumns = { @JoinColumn(name = "idUsuario") }, 
	         inverseJoinColumns = { @JoinColumn(name = "idCurso") })
	private Set<CursoTO> cursos = new HashSet<CursoTO>();
	
	@Column(name="idCursoActual")
	private int idCursoActual;
	
	@Transient
	private float puntuacionMedia;
	
	//Metodos Getters
	public int getIdUsuario() {
		return this.idUsuario;
	}
	
	public String getssoId() {
		return this.ssoId;
	}

	public String getEmail() {
		return this.email;
	}
	
	public String getPass() {
		return this.pass;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getApellidos() {
		return this.apellidos;
	}
	
	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public String getDireccion() {
		return this.direccion;
	}
	
	public String getPoblacion() {
		return this.poblacion;
	}
	
	public Set<PerfilUsuarioTO> getUserProfiles() {
		return userProfiles;
	}
	
	public Set<CursoTO> getCursos() {
		return cursos;
	}
	
	public int getCursoActual() {
		return idCursoActual;
	}
	
	public float getPuntuacionMedia() {
		return puntuacionMedia;
	}

	//Metodos Setters
	public void setIdUsuario(int id){
		this.idUsuario = id;
	}
	
	public void setSsoId(String ssoId) {
	    this.ssoId = ssoId;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	
	}
	public void setUserProfiles(Set<PerfilUsuarioTO> userProfiles) {
		this.userProfiles = userProfiles;
	}
	
	public void setCursos(Set<CursoTO> curso) {
		this.cursos = curso;
	}
	
	public void setCursoActual(int idCursoActual) {
		this.idCursoActual = idCursoActual;
	}
	
	public void setPuntuacionMedia(float puntuacion) {
		this.puntuacionMedia = puntuacion;
	}
}
