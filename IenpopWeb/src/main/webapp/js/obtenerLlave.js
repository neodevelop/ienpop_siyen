function obtenerCursosSinLlave(){
	var idPuerto = document.obtenerCursos.idPuerto.value;
	var puertos= idPuerto.split(" ");
	var idUsuario=document.obtenerCursos.idUsuario.value;
	var usuarios = idUsuario.split(" ");
	var idCurso = document.obtenerCursos.idCurso.value;
	var idCursos = idCurso.split(" ");
	var nombreCurso = document.obtenerCursos.nombreCurso.value;
	var nombreCursos = nombreCurso.split("|");
	CursoXCertificarService.getCursosXCertificarSinLlave(usuarios,puertos,function(cursosXCertificar){
		dwr.util.removeAllRows("cursosXCertificarBody", { filter:function(tr) {
      		return (tr.id != "patternCursoXCertificar");
		}});
		var cursoXCertificar,thisIdCursoXCertificar,alumnosCursoXCertificar;
		for(var i=0;i<cursosXCertificar.length;i++){
			cursoXCertificar=cursosXCertificar[i];
			thisIdCursoXCertificar = cursoXCertificar.id;
			alumnosCursoXCertificar = cursoXCertificar.alumnos;
			dwr.util.cloneNode("patternCursoXCertificar", { idSuffix:thisIdCursoXCertificar });
			for(var j=0;j<idCursos.length;j++){
				if(cursoXCertificar.idTipoCurso==idCursos[j]){
					dwr.util.setValue("tipoCursoXCertificar"+thisIdCursoXCertificar, nombreCursos[j]);
					break;
				}
			}
			//dwr.util.setValue("tipoCursoXCertificar"+thisIdCursoXCertificar, cursoXCertificar.idTipoCurso);
			var day=cursoXCertificar.fechaInicio.getDay();
			var month=cursoXCertificar.fechaInicio.getMonth();
			var daym=cursoXCertificar.fechaInicio.getDate();
			var year=cursoXCertificar.fechaInicio.getYear();
			year+=1900;
			month++;//daym++;
			var fechaCursoXCertificar = daym+"/"+month+"/"+year;
			dwr.util.setValue("fechaInicioCursoXCertificar"+thisIdCursoXCertificar, fechaCursoXCertificar);
			dwr.util.setValue("noParticipantesCursoXCertificar"+thisIdCursoXCertificar, alumnosCursoXCertificar.length);
			$("patternCursoXCertificar" + thisIdCursoXCertificar).style.display = "table-row";
			if((i%2)==0){
				$("patternCursoXCertificar" + thisIdCursoXCertificar).style.backgroundColor = "rgb(255,255,255)";
			}else{
				$("patternCursoXCertificar" + thisIdCursoXCertificar).style.backgroundColor = "rgb(170,213,255)";
			}
		}
	});
	//alert("Si llega "+puertos);
}

function generarLlave(idCursoXCertificar){
	//alert(idCursoXCertificar.substring(5));
	var email = document.obtenerCursos.email.value;
	dwr.engine.beginBatch();
	IenpopProducer.generarLLaveQueue(idCursoXCertificar.substring(5),email,function(llave){
		alert("La información para certificar el curso ha sido enviada por correo...");
	});
	obtenerCursosSinLlave();
	dwr.engine.endBatch({
		errorHandler:function(errorString, exception) { alert(errorString+" - "+exception); }
	});
}