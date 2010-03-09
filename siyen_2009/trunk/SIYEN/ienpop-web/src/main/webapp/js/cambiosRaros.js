var cursoRaro;
var alumnosRaros = new Array();
var indiceRaro = 0;

function buscarCursoParaCambioRaro(cursoId){
	CursoService.getCursoById(cursoId,function(curso){
		dwr.util.setValue("idCursoRaro",curso.id);
		dwr.util.setValue("idUsuarioCursoRaro",curso.idUsuario);
		dwr.util.setValue("numeroAlumnosRaro",curso.alumnos.length);
		dwr.util.setValue("idPuertoRaro",curso.idPuerto);
		dwr.util.setValue("idTipoCursoRaro",curso.tipoCurso.idTipoCurso);
		dwr.util.setValue("fechaInicioModificarRaro",formatoDeFecha(curso.fechaInicio));
		dwr.util.setValue("fechaFinModificarRaro",formatoDeFecha(curso.fechaFin));
		dwr.util.setValue("fechaRegistroModificarRaro",formatoDeFecha(curso.fechaHoraRegistro));
		cursoRaro = curso;
	});

	xDisplay("mensajeExcepcion","none");
	xDisplay("mensajeInformacion","none");
	xDisplay("nuevoCursoRaro","none");
	xDisplay("formaCambiosRaros","block");
	xDisplay("alumnosRaros","block");
	xDisplay("iniciaCambioRaro","none");
	xDisplay("terminaCambioRaro","block");
}

function crearCursoParaCambioRaro(){
	xDisplay("nuevoCursoRaro","block");
	xDisplay("formaCambiosRaros","none");
	xDisplay("alumnosRaros","block");
	xDisplay("iniciaCambioRaro","none");
	xDisplay("terminaCambioRaro","block");
}

function buscarYAgregar(numeroControl){
	AlumnoService.getAlumnoPorNumeroControl(numeroControl,function(alumno){
		alumnosRaros[indiceRaro++] = alumno;
		llenarTablaAlumnosRaros();
	});
}

function agregarNuevoAlumno(nombre){
	var alumno = {
			id:0,
			numeroControl:'n/a',
			nombreCompleto:nombre,
			idCurso:0,
			idStatusAlumno:3,
			fechaHoraRegistro:new Date(),
			curso:null
	};
	alumnosRaros[indiceRaro++] = alumno;
	llenarTablaAlumnosRaros();
}

function llenarTablaAlumnosRaros(){
	dwr.util.removeAllRows("alumnosRarosBody",{
		filter:function(tr){
			return (tr.id != "patternRaro");
		}
	});
	for(var i=0;i<alumnosRaros.length;i++){
		alumno = alumnosRaros[i];
		//id = alumno.id;
		id = i+1;
		dwr.util.cloneNode("patternRaro",{idSuffix:id});
		dwr.util.setValue("numeroControlRaro"+id,alumno.numeroControl);
		dwr.util.setValue("nombreCompletoRaro"+id,alumno.nombreCompleto);
		if((i%2)==0)
			$("patternRaro"+id).className = "rowNoFill";
		else
			$("patternRaro"+id).className = "rowFill";
		$("patternRaro" + id).style.display = "table-row";
	}
}

function ejecutarCambioRaro(){
	CursoService.cambiarAgregarAlumnosACurso(alumnosRaros,cursoRaro,function(){
		cursoRaro = null;
		alumnosRaros.clear();
		llenarTablaAlumnosRaros();
		indiceRaro = 0;
	});
	xDisplay("nuevoCursoRaro","none");
	xDisplay("formaCambiosRaros","none");
	xDisplay("alumnosRaros","none");
	xDisplay("iniciaCambioRaro","block");
	xDisplay("terminaCambioRaro","none");
}

function cancelarCambioRaro(){
	cursoRaro = null;
	alumnosRaros.clear();
	llenarTablaAlumnosRaros();
	indiceRaro = 0;
	xDisplay("nuevoCursoRaro","none");
	xDisplay("formaCambiosRaros","none");
	xDisplay("alumnosRaros","none");
	xDisplay("iniciaCambioRaro","block");
	xDisplay("terminaCambioRaro","none");
}

/**
function quitarAlumnoRaro(borraRaroId){
	var id = borraRaroId.substring(10)*1;
	delete alumnosRaros[id-1];
	llenarTablaAlumnosRaros();
	var alumno = {
			id:idTemporal,
			numeroControl:'n/a',
			nombreCompleto:nombre,
			idCurso:0,
			idStatusAlumno:3,
			fechaHoraRegistro:new Date(),
			curso:null
	};
}
**/
