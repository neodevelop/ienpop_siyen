package edu.ienpop.mvc.flows;

import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import edu.ienpop.model.AlumnoSinCertificar;
import edu.ienpop.model.CursoSinCertificar;
import edu.ienpop.model.Instructor;
import edu.ienpop.model.Puerto;
import edu.ienpop.model.TipoCurso;

@Component
public class CursoSinCertificarFlow {
	
	private static final Log logger = LogFactory.getLog(CursoSinCertificarFlow.class);

	public void procesaFlow(CursoSinCertificar cursoSinCertificar){
		logger.debug(ToStringBuilder.reflectionToString(cursoSinCertificar));
	}
	
	public void preparaCursoSinCertificar(CursoSinCertificar cursoSinCertificar){
		logger.debug("Preparando el CursoSinCertificar");
		cursoSinCertificar.setPuerto(new Puerto());
		cursoSinCertificar.setTipoCurso(new TipoCurso());
		cursoSinCertificar.setInstructor(new Instructor());
		cursoSinCertificar.setAlumnosSinCertificar(new ArrayList<AlumnoSinCertificar>());
	}
	
	public void showAlumnoSinCertificar(AlumnoSinCertificar alumnoSinCertificar){
		logger.debug(ToStringBuilder.reflectionToString(alumnoSinCertificar));
	}
}
