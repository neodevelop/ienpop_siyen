var alumnoCriteriaCache;
var cursoCriteriaCache;
var cursoModificar;
//var cursosInCache = { };

function errHandler(errorString, exception) {
	dwr.util.setValue("mensajeExcepcion","Error: "+ dwr.util.toDescriptiveString(errorString, 2));
	xDisplay("mensajeExcepcion","block");
	xDisplay("mensajeInformacion","none");
}

function buscarAlumnos(){
	var numeroControl = document.busquedaAlumnos.numeroControl.value;
	var nombreCompleto = document.busquedaAlumnos.nombreCompleto.value;
	var idCurso = document.busquedaAlumnos.idCurso.value;
	var desdeAlumno = document.busquedaAlumnos.desdeAlumno.value;
	var hastaAlumno = document.busquedaAlumnos.hastaAlumno.value;
	alumnoCriteriaCache=null;
	var fechaDesde = null;
	var fechaHasta = null;
	if(desdeAlumno)
		fechaDesde = new Date(getDateFromFormat(desdeAlumno,"dd-MM-y"));
	if(hastaAlumno)
		fechaHasta = new Date(getDateFromFormat(hastaAlumno,"dd-MM-y"));
	var alumnoCriteria = {id:null,numeroControl:numeroControl,nombreCompleto:nombreCompleto,idCurso:idCurso,idStatusAlumno:3,fechaDesde:fechaDesde,fechaHasta:fechaHasta,firstResult:0};
	alumnoCriteriaCache = alumnoCriteria;
	AlumnoService.getAlumnosByCriteria(alumnoCriteria,function(alumnos){
		dwr.util.removeAllRows("resultadoAlumnosBody",{
			filter:function(tr){
				return (tr.id != "patternAlumnoBusqueda");
			}
		}
		);
		var alumno,id;
		
		for(var i=0;i<alumnos.length;i++){
			alumno = alumnos[i];
			id = alumno.id;
			//alert(id);
			dwr.util.cloneNode("patternAlumnoBusqueda",{idSuffix:id});
			dwr.util.setValue("numeroControl"+id,alumno.numeroControl);
			dwr.util.setValue("nombreCompleto"+id,alumno.nombreCompleto);
			dwr.util.setValue("numeroCurso"+id,alumno.curso.id);
			dwr.util.setValue("idPuerto"+id,alumno.curso.idPuerto);
			dwr.util.setValue("tipoCurso"+id,alumno.curso.tipoCurso.idTipoCurso);
			dwr.util.setValue("fechaRegistro"+id,formatoDeFecha(alumno.fechaHoraRegistro));
			if((i%2)==0)
				$("patternAlumnoBusqueda"+id).className = "rowNoFill";
			else
				$("patternAlumnoBusqueda"+id).className = "rowFill";
		}
	});
	AlumnoService.getCountAlumnosByCriteria(alumnoCriteria, function(count){
		var paginador = "<< < ";
		var paginas = 0;
		paginas+=(count/10);
		if((count%10)!=0){
			paginas++;
		}
		for(var i=1;i<=paginas;i++){
			paginador+="<a href='javascript:buscarAlumnosCache("+((i*1)-1)+")'>"+(i*1)+"</a>&nbsp;";
			if((i%25)==0){
				paginador+="<br>";
			}
		}
		paginador+=" > >>";
		var pag = document.getElementById("paginadorAlumnos");
		var mensaje = document.getElementById("mensajeResultadosAlumnos");
		pag.innerHTML = paginador;
		mensaje.innerHTML = ".: Se han encontrado "+count+" resultados :.";
	});
}

function buscarAlumnosCache(indice){
	alumnoCriteriaCache.firstResult = 10*indice;
	AlumnoService.getAlumnosByCriteria(alumnoCriteriaCache,function(alumnos){
		dwr.util.removeAllRows("resultadoAlumnosBody",{
			filter:function(tr){
				return (tr.id != "patternAlumnoBusqueda");
			}
		}
		);
		var alumno,id;
		
		for(var i=0;i<alumnos.length;i++){
			alumno = alumnos[i];
			id = alumno.id;
			//alert(id);
			dwr.util.cloneNode("patternAlumnoBusqueda",{idSuffix:id});
			dwr.util.setValue("numeroControl"+id,alumno.numeroControl);
			dwr.util.setValue("nombreCompleto"+id,alumno.nombreCompleto);
			dwr.util.setValue("numeroCurso"+id,alumno.curso.id);
			dwr.util.setValue("idPuerto"+id,alumno.curso.idPuerto);
			dwr.util.setValue("tipoCurso"+id,alumno.curso.tipoCurso.idTipoCurso);
			dwr.util.setValue("fechaRegistro"+id,formatoDeFecha(alumno.fechaHoraRegistro));
			if((i%2)==0)
				$("patternAlumnoBusqueda"+id).className = "rowNoFill";
			else
				$("patternAlumnoBusqueda"+id).className = "rowFill";
		}
	});
}

//Busqueda de cursos

function buscarCursos(){
	//var puertos = "[";
	var puertos = new Array();
	var contadorInterno=0;
	for(var i=0; i<document.busquedaCursos.idPuerto.length;i++){
		if(document.busquedaCursos.idPuerto[i].checked){
			//puertos += "'"+document.busquedaCursos.idPuerto[i].value + "',";
			puertos[contadorInterno] = document.busquedaCursos.idPuerto[i].value;
			contadorInterno++;
		}
	}
	//var cursos = "[";
	var cursos = new Array();
	contadorInterno = 0;
	for(var i=0; i<document.busquedaCursos.idTipoCurso.length;i++){
		if(document.busquedaCursos.idTipoCurso[i].checked){
			//cursos += "'"+document.busquedaCursos.idTipoCurso[i].value + "',";
			cursos[contadorInterno] = document.busquedaCursos.idTipoCurso[i].value;
			contadorInterno++;
		}
	}
	var desdeCursos = document.busquedaCursos.desdeCurso.value;
	var hastaCursos = document.busquedaCursos.hastaCurso.value;
	var fechaDesde = null;
	var fechaHasta = null;
	if(desdeCursos)
		fechaDesde = new Date(getDateFromFormat(desdeCursos,"dd-MM-y"));
	if(hastaCursos)
		fechaHasta = new Date(getDateFromFormat(hastaCursos,"dd-MM-y"));
	//puertos = puertos.substr(0,puertos.length-1);
	//puertos+="]";
	//cursos = cursos.substr(0,cursos.length-1);
	//cursos+="]";
	if(document.busquedaCursos.idTipoCurso.length==0)
		cursos = null; 
	var cursoCriteria = {id:null,fechaDesde:fechaDesde,fechaHasta:fechaHasta,idPuerto:puertos,idTipoCurso:cursos,idStatusCurso:4};
	cursoCriteria.paginado = true;
	cursoCriteriaCache = cursoCriteria;
	//alert(cursoCriteria);
	CursoService.getCursosXStatus(cursoCriteria,function(cursos){
		//alert(cursos.length);
		//cursosInCache = cursos;
		dwr.util.removeAllRows("resultadoCursosBody",{
			filter:function(tr){
				return (tr.id != "patternCursoBusqueda");
			}
		}
		);
		
		var curso, idCurso;
		
		for(var i=0;i<cursos.length;i++){
			curso = cursos[i];
			idCurso = curso.id;
			//alert(idCurso);
			if(idCurso!=0){
				//cursosInCache[idCurso] = cursos[i];
				dwr.util.cloneNode("patternCursoBusqueda",{idSuffix:idCurso});
				$("patternCursoBusqueda" + idCurso).style.display = "table-row";
				dwr.util.setValue("idCurso"+idCurso,curso.id);
				dwr.util.setValue("idPuertoCurso"+idCurso,curso.idPuerto);
				dwr.util.setValue("idCatalogoTipoCurso"+idCurso,curso.tipoCurso.idTipoCurso);
				dwr.util.setValue("idUsuarioCurso"+idCurso,curso.idUsuario);
				dwr.util.setValue("noAlumnos"+idCurso,curso.alumnos.length);
				
				dwr.util.setValue("fechaInicioCurso"+idCurso,formatoDeFecha(curso.fechaInicio));
				dwr.util.setValue("fechaFinCurso"+idCurso,formatoDeFecha(curso.fechaFin));
				
				if((i%2)==0)
					$("patternCursoBusqueda"+idCurso).className = "rowNoFill";
				else
					$("patternCursoBusqueda"+idCurso).className = "rowFill";
			}
		}
	});
	CursoService.getCountCursosByCriteria(cursoCriteria,function(count){
		var paginador = "<< < ";
		var paginas = 0;
		paginas+=(count/10);
		if((count%10)!=0){
			paginas++;
		}
		for(var i=1;i<=paginas;i++){
			paginador+="<a href='javascript:buscarCursosCache("+((i*1)-1)+")'>"+(i*1)+"</a>&nbsp;";
			if((i%25)==0){
				paginador+="<br>";
			}
		}
		paginador+=" > >>";
		var pag = document.getElementById("paginadorCursos");
		var mensaje = document.getElementById("mensajeResultadosCursos");
		pag.innerHTML = paginador;
		mensaje.innerHTML = ".: Se han encontrado "+count+" resultados :.";
	});
}

function buscarCursosCache(indice){
	cursoCriteriaCache.firstResult = indice*10;
	CursoService.getCursosXStatus(cursoCriteriaCache,function(cursos){
		//alert(cursos.length);
		dwr.util.removeAllRows("resultadoCursosBody",{
			filter:function(tr){
				return (tr.id != "patternCursoBusqueda");
			}
		}
		);
		
		var curso, idCurso;
		
		for(var i=0;i<cursos.length;i++){
			curso = cursos[i];
			idCurso = curso.id;
			//alert(idCurso);
			if(idCurso!=0){
				dwr.util.cloneNode("patternCursoBusqueda",{idSuffix:idCurso});
				$("patternCursoBusqueda" + idCurso).style.display = "table-row";
				dwr.util.setValue("idCurso"+idCurso,curso.id);
				dwr.util.setValue("idPuertoCurso"+idCurso,curso.idPuerto);
				dwr.util.setValue("idCatalogoTipoCurso"+idCurso,curso.tipoCurso.idTipoCurso);
				dwr.util.setValue("idUsuarioCurso"+idCurso,curso.idUsuario);
				dwr.util.setValue("noAlumnos"+idCurso,curso.alumnos.length);
				
				dwr.util.setValue("fechaInicioCurso"+idCurso,formatoDeFecha(curso.fechaInicio));
				dwr.util.setValue("fechaFinCurso"+idCurso,formatoDeFecha(curso.fechaFin));
				
				if((i%2)==0)
					$("patternCursoBusqueda"+idCurso).className = "rowNoFill";
				else
					$("patternCursoBusqueda"+idCurso).className = "rowFill";
			}
		}
	});
}

function editarCurso(indice){
	var cursoId = indice.substring(9);
	CursoService.getCursoById(cursoId,function(curso){
		dwr.util.setValue("idCurso",curso.id);
		dwr.util.setValue("idUsuarioCurso",curso.idUsuario);
		dwr.util.setValue("numeroAlumnos",curso.alumnos.length);
		dwr.util.setValue("idPuerto",curso.idPuerto);
		dwr.util.setValue("idTipoCurso",curso.tipoCurso.idTipoCurso);
		dwr.util.setValue("fechaInicioModificar",formatoDeFecha(curso.fechaInicio));
		dwr.util.setValue("fechaFinModificar",formatoDeFecha(curso.fechaFin));
		dwr.util.setValue("fechaRegistroModificar",formatoDeFecha(curso.fechaHoraRegistro));
		
		cursoModificar = curso;
		
		dwr.util.removeAllRows("alumnosCursoModificar",{
			filter:function(tr){
				return (tr.id != "patternAlumnoCursoModificar");
			}
		}
		);
		for(var i=0;i<curso.alumnos.length;i++){
			alumno = curso.alumnos[i];
			id = alumno.id;
			//alert(id);
			dwr.util.cloneNode("patternAlumnoCursoModificar",{idSuffix:id});
			dwr.util.setValue("numeroControlCursoModificar"+id,alumno.numeroControl);
			dwr.util.setValue("nombreCompletoCursoModificar"+id,alumno.nombreCompleto);
			dwr.util.setValue("reimprimir"+id,id);
			dwr.util.setValue("fechaRegistroCursoModificar"+id,formatoDeFecha(alumno.fechaHoraRegistro));
			if((i%2)==0)
				$("patternAlumnoCursoModificar"+id).className = "rowNoFill";
			else
				$("patternAlumnoCursoModificar"+id).className = "rowFill";
			$("patternAlumnoCursoModificar" + id).style.display = "table-row";
		}
	});

	dwr.util.setValue("mensajeInformacion","vamos a modificar...");
	xDisplay("mensajeExcepcion","none");
	xDisplay("mensajeInformacion","none");
	xDisplay("formaModificarCurso","block");
	//alert("Visualizando...");
}

function formatoDeFecha(objetoFecha){
	var day=objetoFecha.getDay();
	var month=objetoFecha.getMonth();
	var daym=objetoFecha.getDate();
	var year=objetoFecha.getYear();
	year+=1900;
	month++;
	var fechaFormateada = daym+"/"+month+"/"+year;
	return fechaFormateada;
}

function actualizaCurso(){
	dwr.engine.setErrorHandler(errHandler);
	var idUsuarioCurso = dwr.util.getValue("idUsuarioCurso");
	var fechaInicioModificar = new Date(getDateFromFormat(dwr.util.getValue("fechaInicioModificar"),"dd-MM-y"));
	var idPuerto = dwr.util.getValue("idPuerto");
	var idTipoCurso = dwr.util.getValue("idTipoCurso");
	
	if($("statusCurso").checked){
		cursoModificar.idStatusCurso = 2;
	}
	
	var idsAlumnos = new Array();
	var j=0;
	for(var i=0;i<cursoModificar.alumnos.length;i++){
		alumno = cursoModificar.alumnos[i];
		if($("reimprimir"+alumno.id).checked){
			idsAlumnos[j] =  alumno.id*1;
			j++;
		}
	}
	
	cursoModificar.idUsuario = idUsuarioCurso;
	cursoModificar.fechaInicio = fechaInicioModificar;
	cursoModificar.idPuerto = idPuerto;
	cursoModificar.tipoCurso.idTipoCurso = idTipoCurso;
	
	dwr.engine.beginBatch();
	CursoService.recoveryCursoCertificado(cursoModificar,idsAlumnos,function(){
		dwr.util.setValue("mensajeInformacion","El curso "+ cursoModificar.id +" ha sido modificado, puedes escoger otro curso para modificar...");
		xDisplay("mensajeExcepcion","none");
		xDisplay("mensajeInformacion","block");
		xDisplay("formaModificarCurso","none");
	});
	dwr.engine.endBatch();
}