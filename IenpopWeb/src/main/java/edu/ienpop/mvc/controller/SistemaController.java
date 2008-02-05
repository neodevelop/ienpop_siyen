package edu.ienpop.mvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import edu.ienpop.integration.jms.IenpopProducer;
import edu.ienpop.model.Usuario;
import edu.ienpop.services.BusinessException;
import edu.ienpop.services.CatalogoService;
import edu.ienpop.services.PersistenceService;

public class SistemaController extends AbstractController {

	PersistenceService persistenceService;
	IenpopProducer ienpopProducer;
	CatalogoService catalogoService;
	Logger log = Logger.getLogger(this.getClass());

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
			try{
				ienpopProducer.notificarAcceso(usuario);
			}catch(BusinessException e){
				model.put("error", "Error de comunicaciones con el servidor...");
				log.debug("Error de comunicación:"+e.getMessage());
				return new ModelAndView("main",model);
			}
			return new ModelAndView("sistema", model);
		}
	}

	public IenpopProducer getIenpopProducer() {
		return ienpopProducer;
	}

	public void setIenpopProducer(IenpopProducer ienpopProducer) {
		this.ienpopProducer = ienpopProducer;
	}

}
