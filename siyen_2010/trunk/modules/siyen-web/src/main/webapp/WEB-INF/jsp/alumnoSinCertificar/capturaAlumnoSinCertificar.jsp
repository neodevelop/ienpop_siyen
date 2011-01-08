<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar alumnos</title>
<script type="text/javascript">
	$(function(){
		$('#nombreCompleto').focus();
	});
</script>
</head>
<body>
<fieldset>
<legend>Datos del alumno a certificar</legend>
<form:form commandName="alumnoSinCertificar" >
	<label>Nombre Completo:</label>
	<form:input path="nombreCompleto"/>
	<form:errors path="nombreCompleto"/>
	<br/><label>Observaciones:</label>
	<form:textarea path="observaciones"/>
	<br/>
	<input type="submit" name="_eventId_agregaAlumno" value="Agregar alumno..." />
	<input type="submit" name="_eventId_cancelar" value="Cancelar para ver..." />
	<input type="submit" name="_eventId_terminar" value="Terminar captura de personas" />
</form:form>
</fieldset>
<table width="100%">
	<thead>
		<tr>
			<th>No.</th>
			<th>Nombre</th>
			<th>Observaciones</th>
			<th>&nbsp;</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${listaAlumnosSinCertificar}" var="alumnoSinCertificar" varStatus="i">
		<c:choose>
			<c:when test="${(i.index%2) == 0}">
				<c:set var="fila" value="even"/>
			</c:when>
			<c:otherwise>
				<c:set var="fila" value="odd"/>
			</c:otherwise>
		</c:choose>
		<tr class="${fila}">
			<td>${i.index + 1}</td>
			<td>${alumnoSinCertificar.nombreCompleto}</td>
			<td>${alumnoSinCertificar.observaciones}</td>
			<td><a href="${flowExecutionUrl}&_eventId=borrar&participante=${i.index}">Borrar</a></td>
		</tr>  
		</c:forEach>
	</tbody>
</table>
</body>
</html>