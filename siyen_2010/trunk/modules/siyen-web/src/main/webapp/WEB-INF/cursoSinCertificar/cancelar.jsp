<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Mostrando datos</title>

</head>
<body>
	${cursoSinCertificar}
	<br/>${cursoSinCertificar.fechaInicio}
	<br/>${cursoSinCertificar.puerto.idPuerto}
	<br/>${cursoSinCertificar.instructor.idInstructor}
	<br/>${cursoSinCertificar.alumnosSinCertificar}
	<c:forEach items="${cursoSinCertificar.alumnosSinCertificar}" var="alumnoSinCertificar">
		<br/>${alumnoSinCertificar.nombreCompleto}
	</c:forEach>
</body>
</html>