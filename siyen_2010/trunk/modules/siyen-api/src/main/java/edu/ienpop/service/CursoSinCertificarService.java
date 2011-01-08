package edu.ienpop.service;

import java.util.List;

import edu.ienpop.model.AlumnoSinCertificar;
import edu.ienpop.model.CursoCriteria;
import edu.ienpop.model.CursoSinCertificar;

/**
 * @author neodevelop
 * 
 */
public interface CursoSinCertificarService {

	/**
	 * @param cursoSinCertificar
	 * @param alumnosSinCertificar
	 *            Este metodo permitirá crear un cursoSinCertificar enviandole
	 *            los objetos pertinentes: los datos del curso y la lista de
	 *            alumnos...
	 * 
	 */
	void crearCursoSinCertificar(CursoSinCertificar cursoSinCertificar,
			List<AlumnoSinCertificar> alumnosSinCertificar);

	/**
	 * @param idCurso
	 * @return CursoSinCertificar
	 * 
	 *         Basado en el idCurso podemos obtener un curso completo con sus
	 *         respectivos alumnos
	 */
	CursoSinCertificar obtenerCursoSinCertificarConAlumnos(Long idCurso);

	/**
	 * @param idCurso
	 * @return CursoSinCertificar solamente por el Id
	 */
	CursoSinCertificar obtenerCursoSinCertificarPorId(Long idCurso);

	/**
	 * @param cursoSinCertificar
	 * @param alumnosSinCertificar
	 *            Con este metodo validamos que los cambios son correctos y que
	 *            se ejecutara la actualizacion de dicha lista antes de
	 *            validarse o generar una llave
	 */
	void actualizaCursoSinCertificar(CursoSinCertificar cursoSinCertificar);

	/**
	 * @param idCurso
	 *            Corrobora el cursoSinCertificar a borrar y ejecuta el borrado
	 */
	void borraCursoSinCertificar(Long idCurso);

	/**
	 * @param cursoCriteria
	 * @param offset
	 * @param maxSize
	 * @return Con este mñetodo obtenemos un conjunto de cursos paginados a
	 *         nuestro gusto
	 */
	List<CursoSinCertificar> obtenerCursosConCriteria(
			CursoCriteria cursoCriteria);

	/**
	 * @param cursoCriteria
	 * @return Este método complementa a obtenerCursosConCriteria(...) para
	 *         obtener el total de cursos con los mismo parametros
	 */
	int obtenerContadorDeCursosSinCertificar(CursoCriteria cursoCriteria);
}
