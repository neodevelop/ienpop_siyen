function obtenerCursosConLlave(){
	var idPuerto = document.obtenerCursos.idPuerto.value;
	var puertos= idPuerto.split(" ");
	var idUsuario=document.obtenerCursos.idUsuario.value;
	var usuarios = idUsuario.split(" ");
	var idCurso = document.obtenerCursos.idCurso.value;
	var idCursos = idCurso.split(" ");
	var nombreCurso = document.obtenerCursos.nombreCurso.value;
	var nombreCursos = nombreCurso.split("|");
	CursoXCertificarService.getCursosXCertificarConLlave(usuarios,puertos,function(cursosAprobados){
		dwr.util.removeAllRows("cursosAprobadosBody", { filter:function(tr) {
      		return (tr.id != "patternCursosAprobados");
		}});
		var cursoAprobado,thisIdCursoAprobado,alumnosCursoAprobado;
		for(var i=0;i<cursosAprobados.length;i++){
			cursoAprobado=cursosAprobados[i];
			thisIdCursoAprobado = cursoAprobado.id;
			alumnosCursoAprobado = cursoAprobado.alumnos;
			dwr.util.cloneNode("patternCursosAprobados", { idSuffix:thisIdCursoAprobado });
			for(var j=0;j<idCursos.length;j++){
				if(cursoAprobado.idTipoCurso==idCursos[j]){
					dwr.util.setValue("tipoCursoAprobado"+thisIdCursoAprobado, nombreCursos[j]);
					break;
				}
			}
			//dwr.util.setValue("tipoCursoAprobado"+thisIdCursoAprobado, cursoAprobado.idTipoCurso);
			var day=cursoAprobado.fechaInicio.getDay();
			var month=cursoAprobado.fechaInicio.getMonth();
			var daym=cursoAprobado.fechaInicio.getDate();
			var year=cursoAprobado.fechaInicio.getYear();
			year+=1900;
			month++;//daym++;
			var fechaCursoAprobado = daym+"/"+month+"/"+year;
			dwr.util.setValue("fechaCursoAprobado"+thisIdCursoAprobado, fechaCursoAprobado);
			//alert(fechaCursoAprobado);
			//dwr.util.setValue("noParticipantesCursoAprobado"+thisIdCursoAprobado, alumnosCursoAprobado.length);
			$("patternCursosAprobados" + thisIdCursoAprobado).style.display = "table-row";
			if((i%2)==0){
				$("patternCursosAprobados" + thisIdCursoAprobado).style.backgroundColor = "rgb(255,255,255)";
			}else{
				$("patternCursosAprobados" + thisIdCursoAprobado).style.backgroundColor = "rgb(170,213,255)";
			}
		}
	});
	//alert("Si llega "+puertos);
}

function comprobarLlave(idCursoAprobado){
	idCursoCertificado=idCursoAprobado.substring(9);
	token=dwr.util.getValue("llaveCertificada"+idCursoCertificado);
	//alert("Curso: "+idCursoCertificado+" Llave: "+token);
	dwr.engine.beginBatch();
	CursoService.addCursoCertificado(idCursoCertificado,token,function(idCurso){
		//alert("El curso "+idCurso+" se ha certificado, imprimir los diplomas...");
		window.open("certificados.ienpop?idCurso="+idCurso, "_blank", "width=800,height=600");
		obtenerCursosConLlave();
	});
	dwr.engine.endBatch({
		errorHandler:function(errorString, exception) { alert(errorString+" - "+exception); }
	});
}