<#import "spring.ftl" as spring/>
<html>
<head>
</head>
<body>
	El curso para diplomas es: ${idCurso}
	<br>Curso: ${curso.id}
	<br>FechaInicio: ${curso.fechaInicio}
	<br>FechaFin: ${curso.fechaFin}
	<br>Puerto: ${curso.idPuerto}
	<br>TipoCurso: ${curso.idTipoCurso}
	<br>
	<#list curso.alumnos as alumno>
		<br>${alumno.numeroControl}
		<br>${alumno.nombreCompleto}
	</#list>
	<br>
	<br>${puerto.puerto},${puerto.estado}
	<br>Curso: ${tipoCurso.nombreCurso}
	<br>Duracion: ${tipoCurso.duracion}
</body>
</html>