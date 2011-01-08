package edu.ienpop.model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

/**
 * @author neodevelop
 * 
 */
@Entity
@Table(name = "curso_sin_certificar")
@AttributeOverrides( { @AttributeOverride(name = "idCurso", column = @Column(name = "idCursoSinCertificar")) })
public class CursoSinCertificar extends Curso {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column
	private boolean listoParaCertificar;
	@OneToMany(cascade = { CascadeType.MERGE }, fetch = FetchType.LAZY, mappedBy = "cursoSinCertificar")
	@Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
          org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	private List<AlumnoSinCertificar> alumnosSinCertificar;

	public List<AlumnoSinCertificar> getAlumnosSinCertificar() {
		return alumnosSinCertificar;
	}

	public void setAlumnosSinCertificar(
			List<AlumnoSinCertificar> alumnosSinCertificar) {
		this.alumnosSinCertificar = alumnosSinCertificar;
	}

	public boolean isListoParaCertificar() {
		return listoParaCertificar;
	}

	public void setListoParaCertificar(boolean listoParaCertificar) {
		this.listoParaCertificar = listoParaCertificar;
	}

}
