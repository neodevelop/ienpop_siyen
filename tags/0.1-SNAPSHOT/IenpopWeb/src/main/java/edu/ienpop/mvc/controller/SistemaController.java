package edu.ienpop.mvc.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.ienpop.integration.jms.impl.IenpopProducer;
import edu.ienpop.model.Usuario;
import edu.ienpop.services.BusinessException;
import edu.ienpop.services.CatalogoService;
import edu.ienpop.services.PersistenceService;

@Controller
public class SistemaController {

	@Autowired
	PersistenceService persistenceService;
	@Autowired
	IenpopProducer ienpopProducer;
	@Autowired
	CatalogoService catalogoService;
	Logger log = Logger.getLogger(this.getClass());

	@RequestMapping("/sistema.ienpop")
	public String sistema(@RequestParam(value="usuario",required=false) String idUsuario, ModelMap model) {
		String view = "sistema";
		if (idUsuario==null) {
			model.addAttribute("error",
					"La sesi—n ha expirado o el ingreso fue incorrecto...");
			return "main";
		} else {
			try {
				Usuario usuario = (Usuario) persistenceService.findById(Usuario.class, idUsuario);
				model.addAttribute("usuario", usuario);
				model.addAttribute("catalogoCursos", catalogoService
						.getCatalogoCurso());
				model.addAttribute("instructores",persistenceService.getAllEntities("Usuario"));
				ienpopProducer.notificarAcceso(usuario);
				if(usuario.getTipoUsuario()==3)
					view="jefatura";
			} catch (BusinessException e) {
				model.addAttribute("error", "Error de comunicaciones...");
				return "main";
			}
			return view;
		}
	}

}
