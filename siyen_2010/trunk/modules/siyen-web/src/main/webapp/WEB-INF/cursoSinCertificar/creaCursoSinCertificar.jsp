<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Crear un curso para certificar</title>
<script type="text/javascript">
	$(function() {
		$('#fechaInicio').datepicker( {
			inline : true
		});
	});
</script>
</head>
<body>
<fieldset><legend>Datos del curso a certificar</legend> <form:form
	commandName="cursoSinCertificar">
	<label>Fecha de Inicio:</label>
	<input type="text" name="fechaInicio" id="fechaInicio"
		value="<fmt:formatDate value="${fechaInicio}" pattern="dd/MM/yyyy"/>" />
	<br />
	<label>Puerto:</label>
	<form:select path="puerto.idPuerto" items="${puertos}"
		itemLabel="puerto" itemValue="idPuerto" />
	<br />
	<label>Instructor:</label>
	<form:select path="instructor.idInstructor" items="${instructores}"
		itemLabel="nombre" itemValue="idInstructor" />
	<br />
	<label>Tipo de Curso:</label>
	<form:select path="tipoCurso.idTipoCurso" items="${tiposCursos}"
		itemLabel="idTipoCurso" itemValue="idTipoCurso" />
	<br />
	<input type="submit" name="_eventId_agregarAlumnos"
		value="Agregar alumnos..." />
</form:form></fieldset>
</body>
</html>