package edu.ienpop.mvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import edu.ienpop.services.PersistenceService;

public class CertificadosController extends AbstractController {

	PersistenceService persistenceService;
	public PersistenceService getPersistenceService() {
		return persistenceService;
	}
	public void setPersistenceService(PersistenceService persistenceService) {
		this.persistenceService = persistenceService;
	}
	@SuppressWarnings("unchecked")
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String noCurso = ServletRequestUtils.getStringParameter(request, "noCurso");
		Map model = new HashMap();
		model.put("noCurso", noCurso);
		return new ModelAndView("certificados",model);
	}

}
