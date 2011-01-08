<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Listar todos los cursos</title>
</head>
<body>
	<h1>Hola mundo!!!</h1>
	<c:forEach items="${cursosSinCertificar}" var="cursoSinCertificar">
		${cursoSinCertificar.idCurso}<br/>
	</c:forEach>
</body>
</html>