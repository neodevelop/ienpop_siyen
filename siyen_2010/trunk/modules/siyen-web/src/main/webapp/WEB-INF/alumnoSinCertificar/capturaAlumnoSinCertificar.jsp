<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agregar alumnos</title>
</head>
<body>
<fieldset>
<legend>Datos del alumno a certificar</legend>
<form:form commandName="alumnoSinCertificar" >
	<label>Nombre Completo:</label>
	<form:input path="nombreCompleto"/>
	<label>Observaciones:</label>
	<form:textarea path="observaciones"/>
	<input type="submit" name="_eventId_alumnoCreado" value="Agregar alumno..." />
	<input type="submit" name="_eventId_cancelar" value="Cancelar para ver..." />
</form:form>
</fieldset>
<!-- a href="${flowExecutionUrl}&_eventId=checkCurso">Checar Curso</a-->
${cursoSinCertificar}
</body>
</html>