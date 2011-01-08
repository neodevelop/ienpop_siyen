package edu.ienpop.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author neodevelop
 *
 */
@Entity
@Table(name="alumno_sin_certificar")
@AttributeOverrides( {
		@AttributeOverride(name = "idAlumno", column = @Column(name = "idAlumnoSinCertificar"))
})
public class AlumnoSinCertificar extends Alumno {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idCursoSinCertificar")
	private CursoSinCertificar cursoSinCertificar;
	
	public CursoSinCertificar getCursoSinCertificar() {
		return cursoSinCertificar;
	}
	public void setCursoSinCertificar(CursoSinCertificar cursoSinCertificar) {
		this.cursoSinCertificar = cursoSinCertificar;
	}
}
