package edu.ienpop.mvc.flows;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.RequestContext;

import edu.ienpop.model.AlumnoSinCertificar;

@Component
public class AlumnoSinCertificarFlow {

	private static final Log logger = LogFactory
			.getLog(AlumnoSinCertificarFlow.class);

	@SuppressWarnings("unchecked")
	public void quitaAlumnoSinCertificar(int index, RequestContext context) {
		logger.debug("Obteniendo la lista de alumnos sin certificar");
		List<AlumnoSinCertificar> alumnos = (List)(context.getFlowScope().get("listaAlumnosSinCertificar"));
		logger.debug("Borrando de la lista con el indice: "+ index);
		alumnos.remove(index);
	}
}
