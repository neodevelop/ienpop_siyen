package edu.ienpop.mvc.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ienpop.model.CatalogoPuerto;
import edu.ienpop.model.Curso;
import edu.ienpop.model.CursoCriteria;
import edu.ienpop.services.BusinessException;
import edu.ienpop.services.CursoService;
import edu.ienpop.services.PersistenceService;

@Controller
public class InformePeriodicoController{

	Logger log = Logger.getLogger(this.getClass());
	@Autowired
	CursoService cursoService;
	@Autowired
	PersistenceService persistenceService;

	
	@SuppressWarnings("unchecked")
	@RequestMapping("/informePeriodico.ienpop")
	public String generaInformePeriodico(HttpServletRequest request, ModelMap model) throws BusinessException, ServletRequestBindingException{
		log.debug("En InformePeriodicoController...");
		CursoCriteria cursoCriteria = new CursoCriteria();
		//Todos estos cursos deben de estar concluidos
		cursoCriteria.setIdStatusCurso(CursoCriteria.CONCLUIDO);
		int tipo = ServletRequestUtils.getIntParameter(request, "tipo", 1);
		String view = "";
		String desde = ServletRequestUtils.getStringParameter(request, "desde", "none");
		String hasta = ServletRequestUtils.getStringParameter(request, "hasta", "none");
		cursoCriteria = setterFechas(desde, hasta, cursoCriteria);
		List<Curso> cursos = null;
		String idPuerto=null;
		String libreta=null;
		boolean verLibretas = false;
		CatalogoPuerto puerto = null;
		String[] libretas;
		switch(tipo){
		case 1:
			cursos = cursoService.getInformePeriodico(cursoCriteria.getFechaDesde(), cursoCriteria.getFechaHasta());
			view = "informePeriodicoCursos";
			break;
		case 2:
			cursos = cursoService.getInformePeriodico(cursoCriteria.getFechaDesde(), cursoCriteria.getFechaHasta());
			view = "informePeriodicoCursosAlumnos";
			break;
		case 3:
			idPuerto = ServletRequestUtils.getStringParameter(request, "idPuerto", "none");
			//Obtenemos las libretas del request
			libreta = ServletRequestUtils.getStringParameter(request, "libreta");
			//log.debug("El valor de 'libreta' es: "+libreta);
			//Separamos en un arreglo
			libretas = libreta.split(",");
			log.debug(ToStringBuilder.reflectionToString(libretas));
			cursoCriteria.setIdPuerto(new String[] {idPuerto});
			log.debug("Puerto: "+idPuerto);
			puerto = (CatalogoPuerto)persistenceService.findById(CatalogoPuerto.class, idPuerto);
			//Se lo ponemos a criteria
			cursoCriteria.setLibretas(libretas);
			//Lo mandamos al servicio
			cursos = cursoService.getCursosXStatus(cursoCriteria);
			view = "informePeriodicoCursos";
			verLibretas=true;
			break;
		case 4:
			idPuerto = ServletRequestUtils.getStringParameter(request, "idPuerto", "none");
			//Obtenemos las libretas del request
			libreta = ServletRequestUtils.getStringParameter(request, "libreta");
			//log.debug("El valor de 'libreta' es: "+libreta);
			//Separamos en un arreglo
			libretas = libreta.split(",");
			log.debug(ToStringBuilder.reflectionToString(libretas));
			cursoCriteria.setIdPuerto(new String[] {idPuerto});
			puerto = (CatalogoPuerto)persistenceService.findById(CatalogoPuerto.class, idPuerto);
			//Se lo ponemos a criteria
			cursoCriteria.setLibretas(libretas);
			//Lo mandamos al servicio
			cursos = cursoService.getCursosXStatus(cursoCriteria);
			view = "informePeriodicoCursosAlumnos";
			verLibretas=true;
			break;
		default:
			cursos = cursoService.getInformePeriodico(cursoCriteria.getFechaDesde(), cursoCriteria.getFechaHasta());
			view = "informePeriodicoCursos";
			break;
		}
		model.addAttribute("puerto", puerto);
		model.addAttribute("verLibretas",verLibretas);
		model.addAttribute("cursos", cursos);
		model.addAttribute("criteria",cursoCriteria);
		log.debug("Enviando el Model: "+ToStringBuilder.reflectionToString(model)+" And View: "+ view);
		return view;
	}
	
	private CursoCriteria setterFechas(String desde, String hasta, CursoCriteria cc){
		String[] desdeArray = desde.split("-");
		String[] hastaArray = hasta.split("-");
		Calendar calDesde = Calendar.getInstance();
		Calendar calHasta = Calendar.getInstance();
		calDesde.set(Integer.valueOf(desdeArray[2]), Integer.valueOf(desdeArray[1])-1, Integer.valueOf(desdeArray[0]));
		calHasta.set(Integer.valueOf(hastaArray[2]), Integer.valueOf(hastaArray[1])-1, Integer.valueOf(hastaArray[0]));
		cc.setFechaDesde(calDesde.getTime());
		cc.setFechaHasta(calHasta.getTime());
		return cc;
	}

}
