package edu.ienpop.mvc.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ienpop.model.CursoCriteria;
import edu.ienpop.model.CursoSinCertificar;
import edu.ienpop.service.CursoSinCertificarService;

@Controller
@RequestMapping("/cursoSinCertificar")
public class CursoSinCertificarController {

	@Autowired
	private CursoSinCertificarService cursoSinCertificarService;

	@RequestMapping("/borrar/$id")
	public String borrarCursoSinCertificar() {

		return "borrado...";
	}

	/**
	 * @param session
	 * @param offset
	 * @param maxSize
	 * @param model
	 * @return String con el nombre de la view
	 * 
	 * Este método se repite en LlaveController
	 */
	@RequestMapping("/ver")
	public String verCursosSinCertificar(
			HttpSession session,
			@RequestParam(defaultValue = "0", required = true, value = "offset") int offset,
			@RequestParam(defaultValue = "10", required = true, value = "maxSize") int maxSize,
			ModelMap model) {
		CursoCriteria cursoCriteria = new CursoCriteria();
		//Hay que cambiar la llamada al metodo que toma todos los cursos
		//y poner la que llama los cursos de cierto usuario
		List<CursoSinCertificar> cursos = cursoSinCertificarService
				.obtenerCursosConCriteria(cursoCriteria, offset, maxSize);
		model.addAttribute("cursosSinCertificar", cursos);
		model.addAttribute("contadorCursosSinCertificar",
				cursoSinCertificarService
						.obtenerContadorDeCursosSinCertificar(cursoCriteria));
		if (session.getAttribute("message") != null) {
			model.addAttribute("message", session.getAttribute("message"));
			session.removeAttribute("message");
		}
		return "cursoSinCertificar/lista";
	}

	@RequestMapping("/ver/{idCursoSinCertificar}")
	public String verCursoSinCertificar(
			@PathVariable("idCursoSinCertificar") long idCursoSinCertificar,
			ModelMap model) {
		CursoSinCertificar cursoSinCertificar = cursoSinCertificarService
				.obtenerCursoSinCertificarConAlumnos(idCursoSinCertificar);
		model.addAttribute("cursoSinCertificar", cursoSinCertificar);
		return "cursoSinCertificar/ver";
	}

	@RequestMapping(value = "/borrar", method = RequestMethod.POST)
	public String borrarCursoSinCertificar(HttpServletRequest request,
			HttpSession session,
			@RequestParam("idCursoSinCertificar") long idCursoSinCertificar) {
		cursoSinCertificarService.borraCursoSinCertificar(idCursoSinCertificar);
		session.setAttribute("message", "El curso se ha borrado");
		return "redirect:" + request.getServletPath()
				+ "/cursoSinCertificar/ver";
	}
}
