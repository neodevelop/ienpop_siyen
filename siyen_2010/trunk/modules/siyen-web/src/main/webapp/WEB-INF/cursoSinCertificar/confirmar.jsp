<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<title>Mostrando datos</title>

</head>
<body>
	
	<fieldset>
	<legend>Datos del curso a certificar</legend>
	<label>Fecha de inicio:</label> <b> <fmt:formatDate value="${cursoSinCertificar.fechaInicio}" pattern="dd 'de' MMMM 'del' yyyy"/> </b>
	<br/><label>Puerto:</label> <b>${cursoSinCertificar.puerto.puerto}, ${cursoSinCertificar.puerto.estado}</b>
	<br/><label>Instructor:</label> <b>${cursoSinCertificar.instructor.nombre} (${cursoSinCertificar.instructor.idInstructor})</b>
	<br/><label>Tipo de curso:</label> <b>${cursoSinCertificar.tipoCurso.nombreCurso}(${cursoSinCertificar.tipoCurso.idTipoCurso})</b>
	<br/><label>Participantes:</label>
	<table width="100%">
	<thead>
		<tr>
			<th>No.</th>
			<th>Nombre</th>
			<th>Observaciones</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${cursoSinCertificar.alumnosSinCertificar}" var="alumnoSinCertificar" varStatus="vs">
		<tr>
			<td>${vs.index + 1}</td>
			<td>${alumnoSinCertificar.nombreCompleto}</td>
			<td>${alumnoSinCertificar.observaciones}</td>
		</tr>  
		</c:forEach>
	</tbody>
	</table>
	
	</fieldset>
	<br/>
	<a href="${flowExecutionUrl}&_eventId=finalizar">Confirmar y terminar...</a>
	<br/><a href="${flowExecutionUrl}&_eventId=cancelar">Cancelar...</a>
</body>
</html>