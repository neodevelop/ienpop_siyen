<#import "spring.ftl" as spring/>
<#setting number_format="0"/>
<html>
<head>
<title>Informe Periodico - IENPOP by SIYEN :)</title>
<link rel="stylesheet" type="text/css" href="css/siyen_blue_oficio.css">
<script src="js/informes.js"></script>
</head>
<body>
	<center>
	<a href="javascript:printPage()"><img src="img/imprimir.jpg" border="0"></a>
	<br>
	<h1>Informe de alumnos certificados del ${criteria.fechaDesde?date} al ${criteria.fechaHasta?date}</h1>
	<#if verLibretas>
		<#if criteria.libretas?size <= 1>
			<h2>Correspondiente a la libreta ${criteria.libretas[0]}</h2>
		<#else>
			<h2>Correspondiente a las libretas
			<#list criteria.libretas as libreta>
				${libreta}
				<#if libreta_index != criteria.libretas?size - 1 >
					,
				</#if> 
			</#list>
			</h2>
			<h3>Del puerto ${puerto.puerto}, ${puerto.estado}</h3>
		</#if>
	</#if>
	<br>
	<table width="100%" border="0">
		<tr class="columnTables">
			<td>No.</td>
			<td>Curso</td>
			<td>Lugar</td>
			<td>Fecha Inicio</td>
			<td>Fecha Fin</td>
			<td>No. Control</td>
			<td>Nombre</td>
			<td>Instructor</td>
			<td>Elaboraci—n</td>
		</tr>
	<#assign countCursos=0/>
	<#assign countAlumnos=0/>
	<#assign counter=0/>
	<#list cursos as curso>
		<#list curso.alumnos as alumno>
		<tr class="<#if (counter%2)=0>rowNoFill<#else>rowFill</#if>">
			<td>${curso.id}</td>
			<td>${curso.tipoCurso.idTipoCurso}</td>
			<td>${curso.idPuerto}</td>
			<td>${curso.fechaInicio?date}</td>
			<td>${curso.fechaFin?date}</td>
			<td>${alumno.numeroControl}</td>
			<td>${alumno.nombreCompleto}</td>
			<td>${curso.idUsuario}</td>
			<td>${alumno.fechaHoraRegistro?date}</td>
		</tr>
		<#assign counter = counter + 1 />
		</#list>
	<#assign countCursos = countCursos + 1 />
	<#assign countAlumnos = countAlumnos + curso.alumnos?size />
	</#list>
	</table>
	<br>
	<h3>Total de Cursos: ${countCursos}</h3>
	<br>
	<h3>Total de Alumnos: ${countAlumnos}</h3>
	</center>
</body>
</html>