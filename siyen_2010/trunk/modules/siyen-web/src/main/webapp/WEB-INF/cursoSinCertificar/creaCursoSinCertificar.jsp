<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Crear un curso para certificar</title>
<script type="text/javascript">
	$(function(){
		$('#fechaInicio').datepicker({
			inline: true
		});
	});
</script>
<style type="text/css">
	/*demo page css*/
	body{ font: 75.5% "Trebuchet MS", sans-serif; margin: 20px;}
	.demoHeaders { margin-top: 1em; }
	#dialog_link {padding: .4em 1em .4em 20px;text-decoration: none;position: relative;}
	#dialog_link span.ui-icon {margin: 0 5px 0 0;position: absolute;left: .2em;top: 50%;margin-top: -8px;}
	ul#icons {margin: 0; padding: 0;}
	ul#icons li {margin: 2px; position: relative; padding: 4px 0; cursor: pointer; float: left;  list-style: none;}
	ul#icons span.ui-icon {float: left; margin: 0 4px;}
</style>
</head>
<body>
<fieldset>
<legend>Datos del curso a certificar</legend>
<form:form commandName="cursoSinCertificar">
	<label>Fecha de Inicio:</label>
	<form:input path="fechaInicio" />
	<br/><label>Puerto:</label>
	<form:select path="puerto.idPuerto" items="${puertos}"
		itemLabel="puerto" itemValue="idPuerto" />
	<br/><label>Instructor:</label>
	<form:select path="instructor.idInstructor" items="${instructores}"
		itemLabel="nombre" itemValue="idInstructor" />
	<br/><input type="submit" name="_eventId_agregarAlumnos" value="Agregar alumnos..." />
	<input type="submit" name="_eventId_cancelar" value="Cancelar..." />
</form:form>
</fieldset>
</body>
</html>