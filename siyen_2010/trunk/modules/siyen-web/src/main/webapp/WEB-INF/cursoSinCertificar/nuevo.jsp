<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Crear curso sin certificar</title>
</head>
<body>
	<form:form modelAttribute="cursoSinCertificar">
		Fecha de Inicio:<form:input path="fechaInicio"/>
		<br/>Instructor:
			<form:select path="instructor.idInstructor">
				<form:option value="-- Selecciona --"/>
				<form:options  items="${instructores}" itemLabel="nombre" itemValue="idInstructor"   />
			</form:select>
		<br/>Puerto:
			<form:select path="puerto.idPuerto">
				<form:option value="-- Selecciona --"/>
				<form:options  items="${puertos}" itemLabel="puerto" itemValue="idPuerto"   />
			</form:select>
		<br/>Curso:
			<form:select path="tipoCurso.idTipoCurso">
				<form:option value="-- Selecciona --"/>
				<form:options  items="${tiposCurso}" itemLabel="nombreCurso" itemValue="idTipoCurso"   />
			</form:select>
		<br/><input type="submit" name="guardar" value="Crear curso" />
	</form:form>
</body>
</html>