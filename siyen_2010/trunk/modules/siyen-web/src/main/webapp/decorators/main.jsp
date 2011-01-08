<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>.: IENPOP -- <decorator:title default="SIYEN" /> :.</title>
		<link type="text/css" href="${pageContext.request.contextPath}/css/redmond/jquery-ui-1.8.2.custom.css" rel="stylesheet" />
		<link rel="stylesheet" href="http://yui.yahooapis.com/2.7.0/build/reset-fonts-grids/reset-fonts-grids.css" type="text/css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ienpop.css" type="text/css" />	
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui-1.8.2.custom.min.js"></script>
		<decorator:head/>
	</head>
	<body>
		<div id="doc3" class="yui-t3">
			<div id="hd" role="banner">
				<h1>Header</h1>
				<img src="${pageContext.request.contextPath}/img/layout_r1_c1.jpg" class="logo">
			</div>
			<div id="bd" role="main">
				<div id="yui-main">
					<div class="yui-b">
						<div class="yui-g">
							<decorator:body/>
						</div>
					</div>
				</div>
				<div class="yui-b">
					<!-- ELEMENTOS DEL MENU -->
					<h1>Opciones para instructores</h1>
					<ul>
					<li>
						<a href="${pageContext.request.contextPath}/siyen/cursoSinCertificar">
							Crear un curso para certificar
						</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/siyen/cursoSinCertificar/ver">
							Ver cursos para certificar
						</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/siyen/obtenerLlave">
							Obtener una llave
						</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/siyen/llaves">
							Ver mis llaves de certificación
						</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/siyen/certificarCurso">
							Certificar un curso
						</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/siyen/certificarCurso">
							Modificar un curso certificado
						</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/siyen/recertificar">
							Certificar un curso modificado
						</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/siyen/generarOficios">
							Generar oficios
						</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/siyen/validarConstancia">
							Validar constancia
						</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/siyen/miPerfil">
							Mi perfil
						</a>
					</li>
					</ul>
					<br/>
					<h1>Opciones para oficina de titulacion</h1>
					<ul>
						<li>
							Buscar cursos
						</li>
						<li>
							Informes
						</li>
						<li>
							Usuarios
							<ul>
								<li>Crear</li>
								<li>Modificar</li>
							</ul>
						</li>
						<li>
							Puertos
							<ul>
								<li>Crear</li>
								<li>Modificar</li>
							</ul>
						</li>
						<li>
							Cursos
							<ul>
								<li>Crear</li>
								<li>Modificar</li>
							</ul>
						</li>
						<li>
							Asignar puertos a usuarios
						</li>
					</ul>
					<!-- ELEMENTOS DEL MENU -->
				</div>
			</div>
		<div id="ft" role="contentinfo">
			<p>Footer</p>
		</div>
	</div>
	</body>
</html>