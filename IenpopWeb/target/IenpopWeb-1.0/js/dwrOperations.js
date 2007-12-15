	var alumnosXCertificarCache = { };
	
	function configIni(){
		xDisplay('agregarAlumnos','none');
	}
	
	function errHandler(msg) {
		alert(msg);
		//dwr.util.setValue("myMessage",msg);
	}
	
	function creaNuevoCurso(){
		dwr.engine.setErrorHandler(errHandler);
		if(dwr.util.getValue("fechaInicioCurso")==''){
			alert("Por favor escribe la fecha...");
		}else{
			var jsFechaInicio = new Date(getDateFromFormat(dwr.util.getValue("fechaInicioCurso"),"dd-MM-y"));
			//alert(jsFechaInicio);
			var cursoXCertificar = {idCursoXCertificar:null,fechaInicio:jsFechaInicio,fechaHoraRegistro:null,idPuerto:null,idTipoCurso:null,idUsuario:"${usuario.idUsuario}",idStatusCurso:1,alumnos:null};
			dwr.util.getValues(cursoXCertificar);
			//alert("Es fecha? "+cursoXCertificar.fechaInicio+" = "+isDate(cursoXCertificar.fechaInicio,"dd-MM-y"));
			//alert(cursoXCertificar.fechaInicio+" "+cursoXCertificar.idUsuario+" "+cursoXCertificar.idPuerto+" "+cursoXCertificar.idTipoCurso+" "+cursoXCertificar.idStatusCurso);
			dwr.engine.beginBatch();
			CursoXCertificarService.createNuevoCurso(cursoXCertificar,function(curso){ 
				xDisplay('agregarAlumnos','block');
				dwr.util.setValue("idCursoXCertificar",curso.id);
				document.nuevoCurso.fechaInicioCurso.disabled=true;
				document.nuevoCurso.idPuerto.disabled=true;
				document.nuevoCurso.idTipoCurso.disabled=true;
			});
			dwr.engine.endBatch({
				errorHandler:function(errorString, exception) { alert(errorString+" - "+exception); }
			});
		}
	}
	
	function agregaAlumnoXCertificar(){
		dwr.engine.setErrorHandler(errHandler);
		if(dwr.util.getValue("idAlumnoXCertificar")==-1){
			var alumnoXCertificar = {id:dwr.util.getValue("idAlumnoXCertificar"),nombreCompleto:dwr.util.getValue("nombreCompletoXCertificar"),idCursoXCertificar:dwr.util.getValue("idCursoXCertificar"),idStatusAlumno:1,fechaHoraRegistro:null,observaciones:dwr.util.getValue("observacionesXCertificar")};
			//alumnoXCertificar.idCursoXCertificar=dwr.util.getValue("idCursoXCertificar");
			//alumnoXCertificar.nombreCompletoXCertificar=dwr.util.getValue("nombreCompletoXCertificar");
			//alumnoXCertificar.observacionesXCertificar=dwr.util.getValue("observacionesXCertificar");
			dwr.engine.beginBatch();
				CursoXCertificarService.addAlumnoACursoXCertificar(dwr.util.getValue("idCursoXCertificar"),alumnoXCertificar,function(){ 
					llenarTablaAlumnosXCertificar();
					dwr.util.setValue(nombreCompletoXCertificar,null);
					dwr.util.setValue(observacionesXCertificar,"Ninguna");
				});
			dwr.engine.endBatch({
				errorHandler:function(errorString, exception) { alert(errorString+" - "+exception); }
			});
		}else{
			var alumnoXCertificar = alumnosXCertificarCache[dwr.util.getValue("idAlumnoXCertificar")];
			//alert(dwr.util.getValue("idAlumnoXCertificar"));
			alumnoXCertificar.nombreCompleto = dwr.util.getValue("nombreCompletoXCertificar");
			alumnoXCertificar.observaciones = dwr.util.getValue("observacionesXCertificar");
			dwr.engine.beginBatch();
				CursoXCertificarService.changeAlumnoACursoXCertificar(alumnoXCertificar,function(){});
				llenarTablaAlumnosXCertificar();
				dwr.util.setValue("idAlumnoXCertificar",-1);
				dwr.util.setValue("nombreCompletoXCertificar",null);
				dwr.util.setValue("observacionesXCertificar","Ninguna");
			dwr.engine.endBatch({
				errorHandler:function(errorString, exception) { alert(errorString+" - "+exception); }
			});
		}
	}
	
	function llenarTablaAlumnosXCertificar(){
		//alert(dwr.util.getValue("idCursoXCertificar"));
		//dwr.engine.beginBatch();
			CursoXCertificarService.getAlumnosDeCursoXCertificar(dwr.util.getValue("idCursoXCertificar"),function(alumnos){
				dwr.util.removeAllRows("alumnosBody", { filter:function(tr) {
      				return (tr.id != "pattern");
				}});
				var alumnoXCertificar,id;
				for(var i=0;i<alumnos.length;i++){
					alumnoXCertificar=alumnos[i];
					id=alumnoXCertificar.id;
					dwr.util.cloneNode("pattern", { idSuffix:id });
					dwr.util.setValue("nombreCompletoTable"+id, alumnoXCertificar.nombreCompleto);
					$("pattern" + id).style.display = "table-row";
					if((i%2)==0){
						$("pattern" + id).style.backgroundColor = "rgb(255,255,255)";
					}else{
						$("pattern" + id).style.backgroundColor = "rgb(170,213,255)";
					}
					alumnosXCertificarCache[id]=alumnoXCertificar;
				}
			});
		//dwr.engine.endBatch({
		//	errorHandler:function(errorString, exception) { alert(errorString+" - "+exception); }
		//});
	}
	
	function editarAlumnoXCertificar(idAlumnoXCertificar){
		//alert(idAlumnoXCertificar);
		var alumnoXCertificar = alumnosXCertificarCache[idAlumnoXCertificar.substring(4)];
		dwr.util.setValue("idAlumnoXCertificar",alumnoXCertificar.id);
		dwr.util.setValue("nombreCompletoXCertificar",alumnoXCertificar.nombreCompleto);
		dwr.util.setValue("observacionesXCertificar",alumnoXCertificar.observaciones);
	}
	function borrarAlumnoXCertificar(idAlumnoXCertificar){
		//alert(idAlumnoXCertificar);
		var alumnoXCertificar = alumnosXCertificarCache[idAlumnoXCertificar.substring(6)];
		dwr.engine.beginBatch();
		if (confirm("Estás seguro de borrar a " + alumnoXCertificar.nombreCompleto + "?")) {
			CursoXCertificarService.removeAlumnoACursoXCertifcar(dwr.util.getValue("idCursoXCertificar"),alumnoXCertificar,function(){ });
			llenarTablaAlumnosXCertificar();
		}
		dwr.engine.endBatch({
				errorHandler:function(errorString, exception) { alert(errorString+" - "+exception); }
		});
	}

	function cerrarCursoNuevo(){
		var alumnosXCertificarCache = { };
		document.nuevoCurso.fechaInicioCurso.disabled=false;
		document.nuevoCurso.idPuerto.disabled=false;
		document.nuevoCurso.idTipoCurso.disabled=false;
		document.nuevoCurso.reset();
		dwr.util.removeAllRows("alumnosBody", { filter:function(tr) {
      				return (tr.id != "pattern");
				}});
		xDisplay('agregarAlumnos','none');
		//alert("El curso se ha cerrado");
	}