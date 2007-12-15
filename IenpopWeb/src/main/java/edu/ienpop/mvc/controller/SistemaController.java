package edu.ienpop.mvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import edu.ienpop.model.Usuario;
import edu.ienpop.services.CatalogoService;
import edu.ienpop.services.PersistenceService;

public class SistemaController extends AbstractController {

	PersistenceService persistenceService;

	CatalogoService catalogoService;

	public CatalogoService getCatalogoService() {
		return catalogoService;
	}

	public void setCatalogoService(CatalogoService catalogoService) {
		this.catalogoService = catalogoService;
	}

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
		Map model = new HashMap();
		String idUsuario = ServletRequestUtils.getStringParameter(request,
				"usuario", "none");
		if (idUsuario.equals("none")) {
			model.put("error", "La sesión ha expirado o el ingreso fue incorrecto...");
			return new ModelAndView("main",model);
		} else {
			Usuario usuario = (Usuario) getPersistenceService().findById(
					Usuario.class, idUsuario);
			model.put("usuario", usuario);
			model
					.put("catalogoCursos", getCatalogoService()
							.getCatalogoCurso());
			return new ModelAndView("sistema", model);
		}
	}

}
