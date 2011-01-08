package edu.ienpop.model;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author neodevelop
 *
 */
@Entity
@Table(name="curso_sin_certificar")
@AttributeOverrides( {
		@AttributeOverride(name = "idCurso", column = @Column(name = "idCursoSinCertificar"))
})
public class CursoSinCertificar extends Curso {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column
	private boolean listoParaCertificar;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="cursoSinCertificar")
	private Set<AlumnoSinCertificar> alumnosSinCertificar;
	
	public Set<AlumnoSinCertificar> getAlumnosSinCertificar() {
		return alumnosSinCertificar;
	}
	public void setAlumnosSinCertificar(
			Set<AlumnoSinCertificar> alumnosSinCertificar) {
		this.alumnosSinCertificar = alumnosSinCertificar;
	}
	public boolean isListoParaCertificar() {
		return listoParaCertificar;
	}
	public void setListoParaCertificar(boolean listoParaCertificar) {
		this.listoParaCertificar = listoParaCertificar;
	}
	
}
