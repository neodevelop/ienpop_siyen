package edu.ienpop.mvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import edu.ienpop.model.CatalogoCurso;
import edu.ienpop.model.CatalogoPuerto;
import edu.ienpop.model.Curso;
import edu.ienpop.model.Usuario;
import edu.ienpop.services.CursoService;
import edu.ienpop.services.PersistenceService;

public class CertificadosController extends AbstractController {

	CursoService cursoService;
	PersistenceService persistenceService;
	public PersistenceService getPersistenceService() {
		return persistenceService;
	}
	public void setPersistenceService(PersistenceService persistenceService) {
		this.persistenceService = persistenceService;
	}
	public CursoService getCursoService() {
		return cursoService;
	}
	public void setCursoService(CursoService cursoService) {
		this.cursoService = cursoService;
	}
	@SuppressWarnings("unchecked")
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		long idCurso = ServletRequestUtils.getLongParameter(request, "idCurso");
		Curso curso =  getCursoService().generateCertificadosXCurso(idCurso);
		System.out.println(ToStringBuilder.reflectionToString(curso));
		CatalogoPuerto puerto = (CatalogoPuerto)getPersistenceService().findById(CatalogoPuerto.class, curso.getIdPuerto());
		//CatalogoCurso tipoCurso = (CatalogoCurso)getPersistenceService().findById(CatalogoCurso.class, curso.getIdTipoCurso());
		CatalogoCurso tipoCurso = curso.getTipoCurso();
		Usuario usuario = (Usuario)getPersistenceService().findById(Usuario.class, curso.getIdUsuario());
		Map model = new HashMap();
		//model.put("idCurso", idCurso);
		model.put("curso",curso);
		model.put("puerto",puerto);
		model.put("tipoCurso",tipoCurso);
		model.put("usuario",usuario);
		model.put("alumnos", curso.getAlumnos());
		model.put("format", "pdf");
		return new ModelAndView("constancias",model);
	}

}
