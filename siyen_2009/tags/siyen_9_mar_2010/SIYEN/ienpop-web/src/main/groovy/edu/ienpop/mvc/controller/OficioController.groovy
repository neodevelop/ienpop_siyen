package edu.ienpop.mvc.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ienpop.model.CatalogoPuerto;
import edu.ienpop.model.Curso;
import edu.ienpop.services.BusinessException;
import edu.ienpop.services.CursoService;
import edu.ienpop.services.PersistenceService;
import edu.ienpop.services.UsuarioService;

@Controller
public class OficioController{

	@Autowired
	CursoService cursoService;
	@Autowired
	PersistenceService persistenceService;
	@Autowired
	UsuarioService usuarioService;
	Logger log = Logger.getLogger(this.getClass());

	@SuppressWarnings("unchecked")
	@RequestMapping("/oficio.ienpop")
	public String generaOficio(HttpServletRequest request,ModelMap model) throws BusinessException {
		//log.debug("EmpezanDo a recibir parametros...");
		String dirigido = ServletRequestUtils.getStringParameter(request, "dirigido", "none");
		String desde = ServletRequestUtils.getStringParameter(request, "desde", "none");
		String hasta = ServletRequestUtils.getStringParameter(request, "hasta", "none");
		String idPuerto = ServletRequestUtils.getStringParameter(request, "idPuerto", "");
		String no = ServletRequestUtils.getStringParameter(request, "no", "1");
		String format = ServletRequestUtils.getStringParameter(request, "format", "html");
		String idUsuario = ServletRequestUtils.getStringParameter(request, "idUsuario", "none");
		String[] desdeArray = desde.split("-");
		String[] hastaArray = hasta.split("-");
		Calendar calDesde = Calendar.getInstance();
		Calendar calHasta = Calendar.getInstance();
		calDesde.set(Integer.valueOf(desdeArray[2]), Integer.valueOf(desdeArray[1])-1, Integer.valueOf(desdeArray[0]));
		calHasta.set(Integer.valueOf(hastaArray[2]), Integer.valueOf(hastaArray[1])-1, Integer.valueOf(hastaArray[0]));
		List<Curso> cursos = cursoService.getOficio(calDesde.getTime(), calHasta.getTime(), idPuerto);
		model.addAttribute("cursos", cursos);
		model.addAttribute("puerto",persistenceService.findById(CatalogoPuerto.class, idPuerto));
		model.addAttribute("dirigido",dirigido);
		model.addAttribute("no", no);
		model.addAttribute("desde",calDesde.getTime());
		model.addAttribute("hasta", calHasta.getTime());
		model.addAttribute("instructor", usuarioService.getNombreDelusuario(idUsuario));
		model.addAttribute("ahora",Calendar.getInstance().getTime());
		//log.debug("Dirigido: "+dirigido);
		//log.debug("Desde: "+calDesde.getTime().toString());
		//log.debug("Hasta: "+calHasta.getTime().toString());
		//log.debug("idPuerto: "+idPuerto);
		//log.debug("no: "+no);
		if(format.equals("pdf")){
			model.put("format","pdf");
			return "oficioPdf";
		}else{
			return "oficio";
		}
		
	}

}
