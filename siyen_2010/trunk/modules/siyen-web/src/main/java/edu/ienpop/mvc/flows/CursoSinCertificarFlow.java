package edu.ienpop.mvc.flows;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.RequestContext;

import edu.ienpop.model.CursoSinCertificar;
import edu.ienpop.model.Instructor;
import edu.ienpop.model.Puerto;
import edu.ienpop.model.TipoCurso;

@Component
public class CursoSinCertificarFlow {
	
	private static final Log logger = LogFactory.getLog(CursoSinCertificarFlow.class);
	
	public void preparaCursoSinCertificar(CursoSinCertificar cursoSinCertificar){
		logger.debug("Preparando el CursoSinCertificar");
		cursoSinCertificar.setPuerto(new Puerto());
		cursoSinCertificar.setTipoCurso(new TipoCurso());
		cursoSinCertificar.setInstructor(new Instructor());
	}
	
	@SuppressWarnings("unchecked")
	public void preparaRelaciones(CursoSinCertificar cursoSinCertificar,RequestContext context){
		//logger.debug(ToStringBuilder.reflectionToString(context));
		logger.debug("Asignando los puerto,curso e instructor para poder persistir...");
		List<TipoCurso> tiposCursos = (List)(context.getFlowScope().get("tiposCursos"));
		List<Instructor> instructores = (List)(context.getFlowScope().get("instructores"));
		List<Puerto> puertos = (List)(context.getFlowScope().get("puertos"));
		TipoCurso tipoCurso = tiposCursos.get(tiposCursos.indexOf(cursoSinCertificar.getTipoCurso()));
		Instructor instructor = instructores.get(instructores.indexOf(cursoSinCertificar.getInstructor()));
		Puerto puerto = puertos.get(puertos.indexOf(cursoSinCertificar.getPuerto()));
		cursoSinCertificar.setTipoCurso(tipoCurso);
		cursoSinCertificar.setInstructor(instructor);
		cursoSinCertificar.setPuerto(puerto);
	}
	
}
