package edu.ienpop.mvc.controller;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ienpop.model.CatalogoCurso;
import edu.ienpop.model.CatalogoPuerto;
import edu.ienpop.model.Curso;
import edu.ienpop.model.Usuario;
import edu.ienpop.services.BusinessException;
import edu.ienpop.services.CursoService;
import edu.ienpop.services.PersistenceService;

@Controller
public class CertificadosController{

	@Autowired
	CursoService cursoService;
	@Autowired
	PersistenceService persistenceService;
	
	Logger log = Logger.getLogger(this.getClass());
	
	@RequestMapping("/certificados*.pdf")
	public String generaCertificados(@RequestParam(value="idCurso") long idCurso,ModelMap model) throws BusinessException {
		Curso curso =  cursoService.generateCertificadosXCurso(idCurso);
		log.debug(ToStringBuilder.reflectionToString(curso));
		CatalogoPuerto puerto = (CatalogoPuerto)persistenceService.findById(CatalogoPuerto.class, curso.getIdPuerto());
		//CatalogoCurso tipoCurso = (CatalogoCurso)persistenceService.findById(CatalogoCurso.class, curso.getIdTipoCurso());
		CatalogoCurso tipoCurso = curso.getTipoCurso();
		Usuario usuario = (Usuario)persistenceService.findById(Usuario.class, curso.getIdUsuario());
		//model.put("idCurso", idCurso);
		model.addAttribute("curso",curso);
		model.addAttribute("puerto",puerto);
		model.addAttribute("tipoCurso",tipoCurso);
		model.addAttribute("usuario",usuario);
		model.addAttribute("alumnos", curso.getAlumnos());
		model.addAttribute("format", "pdf");
		return "constancias";
	}

	@RequestMapping("/reimprimirCertificados*.pdf")
	public String generaReimpresionCertificados(@RequestParam(value="idCurso") long idCurso,ModelMap model) throws BusinessException {
		Curso curso =  cursoService.generateCertificadosXCursoRecuperado(idCurso);
		log.debug(ToStringBuilder.reflectionToString(curso));
		CatalogoPuerto puerto = (CatalogoPuerto)persistenceService.findById(CatalogoPuerto.class, curso.getIdPuerto());
		//CatalogoCurso tipoCurso = (CatalogoCurso)persistenceService.findById(CatalogoCurso.class, curso.getIdTipoCurso());
		CatalogoCurso tipoCurso = curso.getTipoCurso();
		Usuario usuario = (Usuario)persistenceService.findById(Usuario.class, curso.getIdUsuario());
		//model.put("idCurso", idCurso);
		model.addAttribute("curso",curso);
		model.addAttribute("puerto",puerto);
		model.addAttribute("tipoCurso",tipoCurso);
		model.addAttribute("usuario",usuario);
		model.addAttribute("alumnos", curso.getAlumnos());
		model.addAttribute("format", "pdf");
		return "constancias";
	}
}
