package edu.ienpop.mvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.ienpop.dao.CursoSinCertificarDao;
import edu.ienpop.dao.InstructorDao;
import edu.ienpop.dao.PuertoDao;
import edu.ienpop.dao.TipoCursoDao;
import edu.ienpop.model.CursoSinCertificar;
import edu.ienpop.model.Instructor;
import edu.ienpop.model.Puerto;
import edu.ienpop.model.TipoCurso;

@Controller
@RequestMapping("/cursoSinCertificar")
public class CursoSinCertificarController {

	@Autowired
	private CursoSinCertificarDao cursoSinCertificarDao;
	@Autowired
	private InstructorDao instructorDao;
	@Autowired
	private PuertoDao puertoDao;
	@Autowired
	private TipoCursoDao tipoCursoDao;

	@ModelAttribute
	public void cargarCatalogos(ModelMap model){
		model.addAttribute("instructores", instructorDao.findAll());
		model.addAttribute("puertos", puertoDao.findAll());
		model.addAttribute("tiposCurso", tipoCursoDao.findAll());
	}
	
	@RequestMapping(value="/listar.ienpop")
	public String listarCursosSinCertificar(ModelMap model) {
		System.out.println("Hola mundo!!!");
		model.addAttribute("cursosSinCertificar", cursoSinCertificarDao.findAll());
		return "cursoSinCertificar/listar";
	}
	
	@RequestMapping(value="/nuevo.ienpop",method=RequestMethod.GET)
	public String crearCursoSinCertificar(ModelMap model){
		model.addAttribute(buildCursoSinCertificar());
		return "cursoSinCertificar/nuevo";
	}
	
	@RequestMapping(value="/nuevo.ienpop",method=RequestMethod.POST)
	public void guardarCursoSinCertificar(@ModelAttribute("cursoSinCertificar") CursoSinCertificar cursoSinCertificar ){
		System.out.println(ToStringBuilder.reflectionToString(cursoSinCertificar));
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	private CursoSinCertificar buildCursoSinCertificar(){
		CursoSinCertificar cursoSinCertificar = new CursoSinCertificar();
		cursoSinCertificar.setInstructor(new Instructor());
		cursoSinCertificar.setPuerto(new Puerto());
		cursoSinCertificar.setTipoCurso(new TipoCurso());
		return cursoSinCertificar;
	}
}
