package edu.ienpop.mvc.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ienpop.model.LlaveCertificacion;
import edu.ienpop.service.LlaveCertificacionService;

@Controller
@RequestMapping("/llave")
public class LlaveController {

	@Autowired
	private LlaveCertificacionService llaveCertificacionService;

	@RequestMapping(value = "/paraCurso", method = RequestMethod.POST)
	public String generarLlaveParaCursoSinCertificar(HttpSession session,
			HttpServletRequest request,
			@RequestParam("idCursoSinCertificar") long idCursoSinCertificar) {
		llaveCertificacionService
				.crearLlaveParaCertificacion(idCursoSinCertificar);
		session
				.setAttribute("message",
						"Se ha generado la llave para el curso");
		return "redirect:" + request.getServletPath()
				+ "/cursoSinCertificar/ver";
	}

	@RequestMapping("/enListaParaUsar")
	public String verLlavesCertificacion(ModelMap model) {
		List<LlaveCertificacion> llaves = llaveCertificacionService
				.obtenerLlavesConCursosSinCertificarAsociados();
		model.addAttribute("llaves",llaves);
		return "llave/lista";
	}
}
