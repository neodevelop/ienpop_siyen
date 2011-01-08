package edu.ienpop.dao;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import spock.lang.Specification;

import edu.ienpop.model.CursoCriteria;

/**
 * @author neodevelop
 * 
 */
@ContextConfiguration(locations = "classpath:/Annotated-AppCtx.xml")
class CursoSinCertificarDaoSpockTest extends Specification {
	
	@Autowired
	CursoSinCertificarDao cursoSinCertificarDao
	
	def "encontrar los registros indicados"(){
		setup:"creando un objeto criteria"
			def cursoCriteria = new CursoCriteria()
		when:"buscamos con criteria y paginaci—n"
			def cursos = cursoSinCertificarDao.obtenerCursosSinCertificarConRelaciones(cursoCriteria, a, b)
		then:"la lista del resultado no viene vac’a y sus objetos dependientes tampoco"
			cursos.size() >= 0
			cursos.each{ curso ->
				assert curso.instructor
				assert curso.instructor.nombre
				assert curso.tipoCurso
				assert curso.tipoCurso.nombreCurso
				assert curso.puerto
				assert curso.puerto.puerto
			}
		expect:"un tama–o definido en la lista"
			cursos.size() == c
		where:"tenemos estos valores de offset y paginaci—n..."
			a << [10,15,20]
			b << [5,10,15]
			c << [5,10,15]
	}
	
}
