<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Mostrando de un total de ${contadorCursosSinCertificar}</h3>
	<table>
		<thead>
			<th>Fecha de inicio</th>
			<th>Clave de puerto</th>
			<th>Tipo de curso</th>
			<th>Clave del instructor</th>
			<th>Listo para certificar</th>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</thead>
		<tbody>
			<c:forEach items="${cursosSinCertificar}" var="cursoSinCertificar">
			<tr>
				<td><fmt:formatDate value="${cursoSinCertificar.fechaInicio}" pattern="dd-MM-yyyy"/></td>
				<td>${cursoSinCertificar.puerto.idPuerto}</td>
				<td>${cursoSinCertificar.tipoCurso.idTipoCurso}</td>
				<td>${cursoSinCertificar.instructor.idInstructor}</td>
				<td>${cursoSinCertificar.listoParaCertificar}</td>
				<td>Borrar</td>
				<td>Modificar</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:set var="maxSize" value="10"/>
	<c:set var="paginas" value="${(contadorCursosSinCertificar)/10}"/>
	<c:if test="${(contadorCursosSinCertificar%10) != 0}">
		<c:set var="paginas" value="${paginas + 1}"/>
	</c:if>
	<c:if test="${paginas >= 1}">
		<c:forEach begin="0" end="${paginas - 1}" varStatus="i">
			<a href="${pageContext.request.contextPath}/siyen/cursoSinCertificar/ver?offset=${i.index * 10}&maxSize=10">
				${(i.index)+1}
			</a>&nbsp;&nbsp;
		</c:forEach>
	</c:if>
</body>
</html>