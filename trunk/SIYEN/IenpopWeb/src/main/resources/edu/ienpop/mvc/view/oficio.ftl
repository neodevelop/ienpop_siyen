<#import "spring.ftl" as spring/>
<#setting number_format="0"/>
<html>
<head>
<title>Oficio - IENPOP by SIYEN :)</title>
<link rel="stylesheet" type="text/css" href="css/siyen_blue_oficio.css">
</head>
<body>
	<br><br><br>
	<p><b>${dirigido?default('')}</b>
	<br><b>CAPITAN DE PUERTO</b>
	<br><b>${puerto.direccion}</b>
	</p>
	<div align="right">
	${ahora?string("dd 'de' MMMM 'del' yyyy")}
	<br>${puerto.idPuerto}_${ahora?string("ddMMyy")}.${no?default('')}
	</div>
	<p>
	Distinguido Capit&aacute;n de Puerto
	<br>El <b>Instituto de Educación Náutica y Portuaria Océano Pacífico S.A. de C.V.</b>, 
	impartió en <strong>${puerto.puerto}, ${puerto.estado}</strong> del <strong>${desde?string("dd 'de' MMMM 'del' yyyy")} al ${hasta?string("dd 'de' MMMM 'del' yyyy")}</strong> los cursos de:
	</p>
	<table border="1" width="100%">
		<tr class="columnTables">
			<td width="10%"><b>Curso</b></td>
			<td width="13%"><b>Fecha Inicio</b></td>
			<td width="10%"><b>Fecha Fin</b></td>
			<td><b>Nombre de Curso</b></td>
			<td width="10%"><b>Clave</b></td>
			<td width="12%"><b>Participantes</b></td>
		</tr>
	<#list cursos as curso>
		<tr class="<#if (curso_index%2)=0>rowNoFill<#else>rowFill</#if>" bgcolor="<#if (curso_index%2)=0>#ffffff<#else>#CCCCCC</#if>">
			<td>${curso.id}</td>
			<td>${curso.fechaInicio?date}</td>
			<td>${curso.fechaFin?date}</td>
			<td>${curso.tipoCurso.nombreCurso}</td>
			<td>${curso.tipoCurso.idTipoCurso}</td>
			<td>${curso.alumnos?size}</td>
		</tr>
	</#list>
	</table>
	<p>
	De lo cuales adjuntamos las constancias que amparan la participación de los tripulantes para su entrega.
	</p>
	<center>
	<table border="1" width="55%">
	<tr class="columnTables">
		<td width="10%"><b>Curso</b></td>
		<td>Nombre</td>
		<td width="20%"><b>No. Control</b></td>
	</tr>
	<#assign x=0>
	<#list cursos as curso>
		<#list curso.alumnos as alumno>
		<tr class="<#if (x%2)=0>rowNoFill<#else>rowFill</#if>" bgcolor="<#if (x%2)=0>#ffffff<#else>#CCCCCC</#if>">
			<td>${alumno.idCurso}</td>
			<td>${alumno.nombreCompleto}</td>
			<td>${alumno.numeroControl}</td>
		</tr>
		<#assign x=x+1>
		</#list>
	</#list>
	</table>
	</center>
	<p>
	Agradeciendo de antemano sus atenciones me reitero con un atento saludo.
	</p>
	<p></p><br><br>
	<p>
	<center>
		${instructor}
		<br>INSTRUCTOR
	</center>
	</p>
	
	<p>
	c.c.p. Dirección General de Marina Mercante
	<br>c.c.p. Instructor
	<br>c.c.p. Expediente
	</p>
</body>
</html>