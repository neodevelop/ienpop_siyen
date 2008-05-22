package edu.ienpop.mvc.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import edu.ienpop.model.CatalogoPuerto;
import edu.ienpop.services.CursoService;
import edu.ienpop.services.PersistenceService;
import edu.ienpop.services.UsuarioService;

public class OficioController extends AbstractController {

	CursoService cursoService;
	PersistenceService persistenceService;
	UsuarioService usuarioService;
	Logger log = Logger.getLogger(this.getClass());
	@SuppressWarnings("unchecked")
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
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
		List cursos = getCursoService().getOficio(calDesde.getTime(), calHasta.getTime(), idPuerto);
		Map model = new HashMap();
		model.put("cursos", cursos);
		model.put("puerto",getPersistenceService().findById(CatalogoPuerto.class, idPuerto));
		model.put("dirigido",dirigido);
		model.put("no", no);
		model.put("desde",calDesde.getTime());
		model.put("hasta", calHasta.getTime());
		model.put("instructor", getUsuarioService().getNombreDelusuario(idUsuario));
		model.put("ahora",Calendar.getInstance().getTime());
		//log.debug("Dirigido: "+dirigido);
		//log.debug("Desde: "+calDesde.getTime().toString());
		//log.debug("Hasta: "+calHasta.getTime().toString());
		//log.debug("idPuerto: "+idPuerto);
		//log.debug("no: "+no);
		if(format.equals("pdf")){
			model.put("format","pdf");
			return new ModelAndView("oficioPdf",model);
		}else{
			return new ModelAndView("oficio",model);
		}
		
	}
	public CursoService getCursoService() {
		return cursoService;
	}
	public void setCursoService(CursoService cursoService) {
		this.cursoService = cursoService;
	}
	public PersistenceService getPersistenceService() {
		return persistenceService;
	}
	public void setPersistenceService(PersistenceService persistenceService) {
		this.persistenceService = persistenceService;
	}
	public UsuarioService getUsuarioService() {
		return usuarioService;
	}
	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

}
