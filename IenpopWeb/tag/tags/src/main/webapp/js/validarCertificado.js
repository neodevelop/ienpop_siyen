function validarCertificado(){
	var code = document.validarCertificadoForma.barcode.value;
	//alert(code);
	CursoService.getCursoByTokenCertificado(code,function(curso){
	
		dwr.util.setValue("idCursoCertificadoTable", curso.id);
		dwr.util.setValue("fechaInicioCertificadoTable", fechaConFormato(curso.fechaInicio));
		dwr.util.setValue("fechaFinCertificadoTable", fechaConFormato(curso.fechaFin));
		dwr.util.setValue("puertoCertificadoTable", curso.idPuerto);
		dwr.util.setValue("nombreCursoCertificadoTable", curso.tipoCurso.nombreCurso);
		//alert(curso.id);
		
		var alumnos = curso.alumnos;
		dwr.util.removeAllRows("alumnosCertificadosBody", { filter:function(tr) {
      		return (tr.id != "patternCertificado");
		}});
		for(var i=0;i<alumnos.length;i++){
			alumno=alumnos[i];
			id = alumno.id;
			dwr.util.cloneNode("patternCertificado", { idSuffix:id });
			dwr.util.setValue("numeroControlCertificadoTable"+id, alumno.numeroControl);
			dwr.util.setValue("nombreCompletoCertificadoTable"+id, alumno.nombreCompleto);
			dwr.util.setValue("idCursoCertificadoTable"+id, alumno.idCurso);
			$("patternCertificado" + id).style.display = "table-row";
			if((i%2)==0){
				$("patternCertificado" + id).style.backgroundColor = "rgb(255,255,255)";
			}else{
				$("patternCertificado" + id).style.backgroundColor = "rgb(170,213,255)";
			}
		}
	});
	//alert("entro");
	return false;
}

function fechaConFormato(fecha){
	var day=fecha.getDay();
	var month=fecha.getMonth();
	var daym=fecha.getDate();
	var year=fecha.getYear();
	year+=1900;
	month++;//daym++;
	var fechaFormateada = daym+"/"+month+"/"+year;
	return fechaFormateada;
}