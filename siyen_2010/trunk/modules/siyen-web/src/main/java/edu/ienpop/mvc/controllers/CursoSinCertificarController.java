package edu.ienpop.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cursoSinCertificar")
public class CursoSinCertificarController {
	
	@RequestMapping("/borrar/$id")
    public String borrarCursoSinCertificar() {
        
        return "borrado...";
    }

}
