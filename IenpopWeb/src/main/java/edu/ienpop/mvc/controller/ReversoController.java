package edu.ienpop.mvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ienpop.model.LlaveCertificacion;
import edu.ienpop.services.BusinessException;
import edu.ienpop.services.CursoService;
import edu.ienpop.services.LlaveService;

@Controller
public class ReversoController{

	@Autowired
	LlaveService llaveService;
	@Autowired
	CursoService cursoService;
	Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping("/reverso*.pdf")
	public String muestraReverso(@RequestParam(value="llave") String llave,@RequestParam(value="idCurso") String idCurso,ModelMap model) throws BusinessException {
		LlaveCertificacion llaveCertificacion = llaveService.getLlavebyToken(llave);
		String idTipoCurso = cursoService.getIdTipoCursoById(idCurso);
		List<LlaveCertificacion> list = new ArrayList<LlaveCertificacion>();
		list.add(llaveCertificacion);
		log.debug("La llave es: "+llave);
		log.debug("El idCurso es: "+idCurso);
		log.debug("El idTipoCurso es: "+idTipoCurso);
		model.addAttribute("llaves", list);
		model.addAttribute("format", "pdf");
		return idTipoCurso;
	}

}
