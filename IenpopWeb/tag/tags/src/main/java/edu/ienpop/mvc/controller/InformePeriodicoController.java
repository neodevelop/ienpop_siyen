package edu.ienpop.mvc.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.log4j.Logger;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import edu.ienpop.model.CursoCriteria;
import edu.ienpop.services.CursoService;

public class InformePeriodicoController extends AbstractController {

	Logger log = Logger.getLogger(this.getClass());
	private CursoService cursoService;
	
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
		CursoCriteria cursoCriteria = new CursoCriteria();
		int tipo = ServletRequestUtils.getIntParameter(request, "tipo", 1);
		String view = "";
		String desde = ServletRequestUtils.getStringParameter(request, "desde", "none");
		String hasta = ServletRequestUtils.getStringParameter(request, "hasta", "none");
		cursoCriteria = setterFechas(desde, hasta, cursoCriteria);
		List cursos = null;
		String idPuerto,libreta;
		switch(tipo){
		case 1:
			cursos = getCursoService().getInformePeriodico(cursoCriteria.getFechaDesde(), cursoCriteria.getFechaHasta());
			view = "informePeriodicoCursos";
			break;
		case 2:
			cursos = getCursoService().getInformePeriodico(cursoCriteria.getFechaDesde(), cursoCriteria.getFechaHasta());
			view = "informePeriodicoCursosAlumnos";
			break;
		case 3:
			idPuerto = ServletRequestUtils.getStringParameter(request, "idPuerto", "none");
			libreta = ServletRequestUtils.getStringParameter(request, "libreta");
			cursoCriteria.setIdPuerto(new String[] {idPuerto});
			cursoCriteria.setIdStatusCurso(CursoCriteria.CONCLUIDO);
			cursos = getCursoService().getCursosXStatus(cursoCriteria);
			view = "informePeriodicoCursos";
			break;
		case 4:
			idPuerto = ServletRequestUtils.getStringParameter(request, "idPuerto", "none");
			libreta = ServletRequestUtils.getStringParameter(request, "libreta");
			cursoCriteria.setIdPuerto(new String[] {idPuerto});
			cursoCriteria.setIdStatusCurso(CursoCriteria.CONCLUIDO);
			cursos = getCursoService().getCursosXStatus(cursoCriteria);
			view = "informePeriodicoCursosAlumnos";
			break;
		default:
			cursos = getCursoService().getInformePeriodico(cursoCriteria.getFechaDesde(), cursoCriteria.getFechaHasta());
			view = "informePeriodicoCursos";
			break;
		}
		
		Map model = new HashMap();
		model.put("cursos", cursos);
		model.put("criteria",cursoCriteria);
		return new ModelAndView(view,model);
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
