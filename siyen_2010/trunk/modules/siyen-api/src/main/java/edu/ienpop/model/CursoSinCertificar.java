package edu.ienpop.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	public boolean isListoParaCertificar() {
		return listoParaCertificar;
	}
	public void setListoParaCertificar(boolean listoParaCertificar) {
		this.listoParaCertificar = listoParaCertificar;
	}
	
}
