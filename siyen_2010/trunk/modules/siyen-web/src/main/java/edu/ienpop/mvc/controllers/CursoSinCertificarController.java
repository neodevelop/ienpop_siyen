package edu.ienpop.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.ienpop.dao.CursoSinCertificarDao;

@Controller
@RequestMapping("/cursoSinCertificar")
public class CursoSinCertificarController {
	
	//private CursoSinCertificarService cursoSinCertificarService;
	@Autowired
	private CursoSinCertificarDao cursoSinCertificarDao;
	
	@RequestMapping("/borrar/$id")
    public String borrarCursoSinCertificar() {
        
        return "borrado...";
    }
	
	@RequestMapping("/ver")
    public String verCursosSinCertificar(ModelMap model) {
        model.addAttribute("cursosSinCertificar", cursoSinCertificarDao.findAll());
        return "cursoSinCertificar/lista";
    }

}
