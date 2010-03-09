<html>
	<head>
		<title>Envío de llave de certificación</title>
	</head>
	<body>
		<style type="text/css">
		<!--
		.Estilo1 {color: #FFFFFF; }
		.Estilo4 {color: #000000}
		.Estilo5 {color: #0099FF}
		-->
		</style>
		<h3>Sistema de generacion de llaves para certificacion.</h3>
		<br>Esta es un correo generado por el sistema con la informacion para poder certificar el curso.<br><br>
		<table width="100%" border="1" cellspacing="0" cellpadding="0">
			<tr>
				<td align="center"><strong>Datos del curso</strong></td>
			</tr>
		</table>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="center" bgcolor="#CCCCCC">Fecha de Inicio</td>
				<td align="center" bgcolor="#CCCCCC">Puerto</td>
				<td align="center" bgcolor="#CCCCCC">Tipo de Curso</td>
				<td align="center" bgcolor="#CCCCCC">Llave de Certificacion</td>
			</tr>
			<tr>
				<td align="center">${curso.fechaInicio?date}</td>
				<td align="center">${puerto.puerto?default('')}, ${puerto.estado?default('')}</td>
				<td align="center">${tipoCurso.nombreCurso?default('')}</td>
				<td align="center"><b> ${llaveCertificacion?default('')} </b></td>
			</tr>
		</table>
		<br>
		<table width="100%" border="1">
			<tr>
				<td align="center" border="1"><strong>Alumnos a certificar con esta llave<strong></td>
			</tr>
		</table>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td align="center" bgcolor="#CCCCCC"><span class="Estilo4">Nombre del alumno</span></td>
				<td align="center" bgcolor="#CCCCCC"><span class="Estilo4">Observaciones</span></td>
			</tr>
			<#list curso.alumnos as alumno>
				<tr>
					<#if (alumno_index%2)=0>
					<td>${alumno.nombreCompleto?default('')}</td>
					<td>${alumno.observaciones?default('')}</td>
					<#else>
					<td bgcolor="#6699FF"><span class="Estilo5">${alumno.nombreCompleto?default('')}</span></td>
					<td bgcolor="#6699FF"><span class="Estilo5">${alumno.observaciones?default('')}</span></td>
					</#if>
				</tr>
			</#list>
		</table>
	</body>
</html>