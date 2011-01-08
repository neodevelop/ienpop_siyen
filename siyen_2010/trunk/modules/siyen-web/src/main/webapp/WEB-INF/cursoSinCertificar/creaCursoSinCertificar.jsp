<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Crear un curso para certificar</title>
</head>
<body>

<form:form commandName="cursoSinCertificar">
	<label>Fecha de Inicio:</label>
	<form:input path="fechaInicio" />
	<label>Puerto:</label>
	<form:select path="puerto.idPuerto" items="${puertos}"
		itemLabel="puerto" itemValue="idPuerto" />
	<label>Instructor:</label>
	<form:select path="instructor.idInstructor" items="${instructores}"
		itemLabel="nombre" itemValue="idInstructor" />
	<input type="submit" name="_eventId_agregarAlumnos" value="Agregar alumnos..." />
	<input type="submit" name="_eventId_cancelar" value="Cancelar..." />
</form:form>

</body>
</html>