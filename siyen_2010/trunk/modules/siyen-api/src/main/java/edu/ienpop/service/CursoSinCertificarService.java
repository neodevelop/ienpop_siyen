package edu.ienpop.service;

import java.util.Set;

import edu.ienpop.model.Alumno;
import edu.ienpop.model.CursoSinCertificar;

/**
 * @author neodevelop
 * 
 */
public interface CursoSinCertificarService {

	/**
	 * @param cursoSinCertificar
	 * @param alumnosSinCertificar
	 *            Este metodo permitir‡ crear un cursoSinCertificar enviandole
	 *            los objetos pertinentes: los datos del curso y la lista de
	 *            alumnos...
	 * 
	 */
	void crearCursoSinCertificar(CursoSinCertificar cursoSinCertificar,
			Set<Alumno> alumnosSinCertificar);

	/**
	 * @param idCurso
	 * @return CursoSinCertificar
	 * 
	 *         Basado en el idCurso podemos obtener un curso completo con sus
	 *         respectivos alumnos
	 */
	CursoSinCertificar obtenerCursoSinCertificarConAlumnos(Long idCurso);

	/**
	 * @param cursoSinCertificar
	 * @param alumnosSinCertificar
	 *            Con este metodo validamos que los cambios son correctos y que
	 *            se ejecutara la actualizacion de dicha lista antes de
	 *            validarse o generar una llave
	 */
	void actualizaCursoSinCertificar(CursoSinCertificar cursoSinCertificar,
			Set<Alumno> alumnosSinCertificar);

	/**
	 * @param idCurso
	 *            Corrobora el cursoSinCertificar a borrar y ejecuta el borrado
	 */
	void borraCursoSinCertificar(Long idCurso);
}
