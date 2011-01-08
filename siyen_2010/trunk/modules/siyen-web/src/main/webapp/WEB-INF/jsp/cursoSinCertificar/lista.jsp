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
	<h3>Lista de cursos por certificar...</h3>
	<table>
		<thead>
			<th>Fecha de inicio</th>
			<th>Clave de puerto</th>
			<th>Tipo de curso</th>
			<th>Clave del instructor</th>
			<th>Listo para certificar</th>
		</thead>
		<tbody>
			<c:forEach items="${cursosSinCertificar}" var="cursoSinCertificar">
			<tr>
				<td><fmt:formatDate value="${cursoSinCertificar.fechaInicio}" pattern="dd-MM-yyyy"/></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>