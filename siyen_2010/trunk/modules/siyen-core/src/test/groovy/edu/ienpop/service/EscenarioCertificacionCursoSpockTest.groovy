package edu.ienpop.service

import edu.ienpop.dao.InstructorDao 
import edu.ienpop.dao.PuertoDao 
import edu.ienpop.dao.TipoCursoDao 
import edu.ienpop.model.CursoSinCertificar 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import spock.lang.Specification;


/**
 * @author neodevelop
 * 
 */
@ContextConfiguration(locations = "classpath:/Annotated-AppCtx.xml")
class EscenarioCertificacionCursoSpockTest extends Specification {
	
	@Autowired
	CursoCertificadoService cursoCertificadoService
	@Autowired
	CursoSinCertificarService cursoSinCertificarService
	@Autowired
	InstructorDao instructorDao
	@Autowired
	PuertoDao puertoDao
	@Autowired
	TipoCursoDao tipoCursoDao
	
	def cursoSinCertificar = new CursoSinCertificar()
	
	def "Crear un curso para certificar y agregar participantes"(){
		setup:"Creamos un CursoSinCertificar"
			
		when:"Persistimos el CursoSinCertificar"
			
		then:"El curso debe tener un numero asignado y sus participantes tambien"
			
		expect:"un tama–o definido en la lista"
			
		where:"tenemos estos valores de offset y paginaci—n..."
			
	}
	
}
