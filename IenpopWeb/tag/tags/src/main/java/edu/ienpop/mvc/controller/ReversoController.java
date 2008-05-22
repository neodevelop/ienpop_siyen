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
import edu.ienpop.services.CursoService;
import edu.ienpop.services.LlaveService;

public class ReversoController extends AbstractController {

	LlaveService llaveService;
	CursoService cursoService;
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
		String llave = ServletRequestUtils.getStringParameter(request, "llave");
		String idCurso = ServletRequestUtils.getStringParameter(request, "idCurso");
		LlaveCertificacion llaveCertificacion = getLlaveService().getLlavebyToken(llave);
		String idTipoCurso = getCursoService().getIdTipoCursoById(idCurso);
		List list = new ArrayList();
		list.add(llaveCertificacion);
		log.debug("La llave es: "+llave);
		log.debug("El idCurso es: "+idCurso);
		log.debug("El idTipoCurso es: "+idTipoCurso);
		Map model = new HashMap();
		model.put("llaves", list);
		model.put("format", "pdf");
		return new ModelAndView(idTipoCurso,model);
	}

	public CursoService getCursoService() {
		return cursoService;
	}

	public void setCursoService(CursoService cursoService) {
		this.cursoService = cursoService;
	}

}
