package edu.ienpop.mvc.controllers;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ienpop.model.CursoCriteria;
import edu.ienpop.model.CursoSinCertificar;
import edu.ienpop.service.CursoSinCertificarService;

@Controller
@RequestMapping("/cursoSinCertificar")
public class CursoSinCertificarController {

	// private CursoSinCertificarService cursoSinCertificarService;
	@Autowired
	private CursoSinCertificarService cursoSinCertificarService;

	@RequestMapping("/borrar/$id")
	public String borrarCursoSinCertificar() {

		return "borrado...";
	}

	@RequestMapping("/ver")
	public String verCursosSinCertificar(
			@RequestParam(defaultValue = "0", required = true, value = "offset") int offset,
			@RequestParam(defaultValue = "10", required = true, value = "maxSize") int maxSize,
			ModelMap model) {
		CursoCriteria cursoCriteria = new CursoCriteria();
		List<CursoSinCertificar> cursos = cursoSinCertificarService
		.obtenerCursosConCriteria(cursoCriteria, offset, maxSize);
		System.out.println(ToStringBuilder.reflectionToString(cursos));
		model.addAttribute("cursosSinCertificar", cursos);
		model.addAttribute("contadorCursosSinCertificar", cursoSinCertificarService
				.obtenerContadorDeCursosSinCertificar(cursoCriteria));
		return "cursoSinCertificar/lista";
	}
}
