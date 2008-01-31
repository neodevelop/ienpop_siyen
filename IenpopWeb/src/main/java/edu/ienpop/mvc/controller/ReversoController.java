package edu.ienpop.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import edu.ienpop.model.LlaveCertificacion;
import edu.ienpop.services.LlaveService;

public class ReversoController extends AbstractController {

	LlaveService llaveService;
	Logger log = Logger.getLogger(this.getClass());
	
	public LlaveService getLlaveService() {
		return llaveService;
	}

	public void setLlaveService(LlaveService llaveService) {
		this.llaveService = llaveService;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//long idCurso = ServletRequestUtils.getLongParameter(request, "idCurso");
		String llave = ServletRequestUtils.getStringParameter(request, "llave");
		//log.debug("IdCurso: "+idCurso);
		//LlaveCertificacion llave = getLlaveService().getLlavebyIdCurso(idCurso);
		LlaveCertificacion llaveCertificacion = getLlaveService().getLlavebyToken(llave);
		List list = new ArrayList();
		list.add(llaveCertificacion);
		//log.debug(ToStringBuilder.reflectionToString(llave));
		log.debug("La llave es: "+llave);
		Map model = new HashMap();
		model.put("llaves", list);
		model.put("format", "pdf");
		return new ModelAndView("reverso",model);
	}

}
