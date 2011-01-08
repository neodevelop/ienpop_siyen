<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de llaves para certificar</title>
</head>
<body>

<table border="1" width="100%">
	<thead>
		<th>Llave</th>
		<th>Usada</th>
		<th>Fecha de curso</th>
		<th>Clave de puerto</th>
		<th>Tipo de curso</th>
		<th>Clave del instructor</th>
	</thead>
	<tbody>
		<c:forEach items="${llaves}" var="llave">
			<tr>
				<td>${llave.llave}</td>
				<td>${llave.activo}</td>
				<td><fmt:formatDate value="${llave.cursoSinCertificar.fechaInicio}"
					pattern="dd-MM-yyyy" /></td>
				<td>${llave.cursoSinCertificar.puerto.idPuerto}</td>
				<td>${llave.cursoSinCertificar.tipoCurso.idTipoCurso}</td>
				<td>${llave.cursoSinCertificar.instructor.idInstructor}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>