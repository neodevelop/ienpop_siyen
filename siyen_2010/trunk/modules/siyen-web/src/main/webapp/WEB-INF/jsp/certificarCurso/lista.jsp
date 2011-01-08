<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de cursos sin certificar</title>
</head>
<body>
<h3>Mostrando de un total de ${contadorCursosSinCertificar}</h3>
<table border="1" width="100%">
	<thead>
		<th>Fecha de inicio</th>
		<th>Clave de puerto</th>
		<th>Tipo de curso</th>
		<th>Clave del instructor</th>
		<th>Listo para certificar</th>
		<td>Operaciones</td>
	</thead>
	<tbody>
		<c:forEach items="${cursosSinCertificar}" var="cursoSinCertificar">
			<tr>
				<td><fmt:formatDate value="${cursoSinCertificar.fechaInicio}"
					pattern="dd-MM-yyyy" /></td>
				<td>${cursoSinCertificar.puerto.idPuerto}</td>
				<td>${cursoSinCertificar.tipoCurso.idTipoCurso}</td>
				<td>${cursoSinCertificar.instructor.idInstructor}</td>
				<td>${cursoSinCertificar.listoParaCertificar}</td>
				<td>
					<c:if test="${cursoSinCertificar.listoParaCertificar}">
						<a href="${flowExecutionUrl}&_eventId=preparaCurso&idCursoSinCertificar=${cursoSinCertificar.idCurso}">
							Certificar
						</a>
					</c:if>
					<c:if test="${!cursoSinCertificar.listoParaCertificar}">
						No tiene llave asignada
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<c:set var="maxSize" value="${cursoCriteria.maxSize}" />
<c:set var="paginas" value="${(contadorCursosSinCertificar)/(cursoCriteria.maxSize)}" />
<c:if test="${(contadorCursosSinCertificar%cursoCriteria.maxSize) != 0}">
	<c:set var="paginas" value="${paginas + 1}" />
</c:if>
<c:if test="${paginas >= 1}">
	<c:forEach begin="0" end="${paginas - 1}" varStatus="i">
		<a href="${flowExecutionUrl}&_eventId=pagina&offset=${i.index * cursoCriteria.maxSize}&maxSize=${cursoCriteria.maxSize}">${(i.index)+1}</a>
		&nbsp;&nbsp;
		</c:forEach>
</c:if>
</body>
</html>