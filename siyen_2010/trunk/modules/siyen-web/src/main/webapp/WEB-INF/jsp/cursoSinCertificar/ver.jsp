<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<title>Mostrando datos del curso</title>

</head>
<body>
	
	<fieldset>
	<legend>Datos del curso</legend>
	<label>Fecha de inicio:</label> <b> <fmt:formatDate value="${cursoSinCertificar.fechaInicio}" pattern="dd 'de' MMMM 'del' yyyy"/> </b>
	<br/><label>Puerto:</label> <b>${cursoSinCertificar.puerto.puerto}, ${cursoSinCertificar.puerto.estado}</b>
	<br/><label>Instructor:</label> <b>${cursoSinCertificar.instructor.nombre} (${cursoSinCertificar.instructor.idInstructor})</b>
	<br/><label>Tipo de curso:</label> <b>${cursoSinCertificar.tipoCurso.nombreCurso}(${cursoSinCertificar.tipoCurso.idTipoCurso})</b>
	<br/>
	<br/><center><label><b>. : Participantes : .</b></label></center>
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
	<c:if test="${!cursoSinCertificar.listoParaCertificar}">
		<form action="${pageContext.request.contextPath}/siyen/cursoSinCertificar/borrar" method="post">
			<input type="hidden" name="idCursoSinCertificar" id="idCursoSinCertificar" value="${cursoSinCertificar.idCurso}" />
			<input type="submit" name="delete" value="Borrar este curso"/>
		</form>
		<form action="${pageContext.request.contextPath}/siyen/llave/paraCurso" method="post">
			<input type="hidden" name="idCursoSinCertificar" id="idCursoSinCertificar" value="${cursoSinCertificar.idCurso}" />
			<input type="submit" name="generate" value="Generar llave de curso"/>
		</form>
		<a href="${pageContext.request.contextPath}">Editar</a>
	</c:if>
	<a href="${pageContext.request.contextPath}/siyen/cursoSinCertificar/ver">Regresar</a>
</body>
</html>