var alumnoCriteriaCache;

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
			
			var day=alumno.fechaHoraRegistro.getDay();
			var month=alumno.fechaHoraRegistro.getMonth();
			var daym=alumno.fechaHoraRegistro.getDate();
			var year=alumno.fechaHoraRegistro.getYear();
			year+=1900;
			month++;//daym++;
			var fechaAlumno = daym+"/"+month+"/"+year;
			dwr.util.setValue("fechaRegistro"+id,fechaAlumno);
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
			
			var day=alumno.fechaHoraRegistro.getDay();
			var month=alumno.fechaHoraRegistro.getMonth();
			var daym=alumno.fechaHoraRegistro.getDate();
			var year=alumno.fechaHoraRegistro.getYear();
			year+=1900;
			month++;//daym++;
			var fechaAlumno = daym+"/"+month+"/"+year;
			dwr.util.setValue("fechaRegistro"+id,fechaAlumno);
			if((i%2)==0)
				$("patternAlumnoBusqueda"+id).className = "rowNoFill";
			else
				$("patternAlumnoBusqueda"+id).className = "rowFill";
		}
	});
}

function buscarCursos(){
	var cursoCriteria = {id:null,fechaDesde:null,fechaHasta:null,idPuerto:null,idTipoCurso:null,idUsuario:null,idStatusCurso:4,idLlave:null,libretas:null};
	alert(cursoCriteria);
	//alert("hola cursos");
}