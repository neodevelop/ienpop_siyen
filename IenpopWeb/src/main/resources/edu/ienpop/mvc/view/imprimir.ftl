<form action="#" name="imprimirCursos">
<center>
	<input type="hidden" id="idUsuario" name="idUsuario" value="${usuario.idUsuario}"/>
	<input type="hidden" id="email" name="email" value="${usuario.email?default('')}"/>
	<input type="hidden" id="idPuerto" name="idPuerto" value="<#list usuario.puertos as puerto>${puerto.idPuerto?default('')} </#list>"/>
	<input type="hidden" id="idCurso" name="idCurso" value="<#list catalogoCursos as curso>${curso.idTipoCurso?default('')} </#list>"/>
	<input type="hidden" id="nombreCurso" name="nombreCurso" value="<#list catalogoCursos as curso>${curso.nombreCurso?default('')}| </#list>"/>
	<input type="button" name="obtenerCursosXCertificar" class="inputButton" id="obtenerCursosXCertificar" value="Listar cursos" onClick="obtenerCursosConLlave()"/>
</center>
</form>
<table width="100%">
	<tr>
		<td class="titleTables">Cursos Por Certificar Con Autorizaci√≥n</td>
	</tr>
</table>
<table width="100%">
	<thead height="20">
		<tr class="columnTables" height="20">
			<th height="20">Curso</td>
			<th>Inicio</td>
			<!--th>Participantes</th-->
			<th>Llave</th>
			<th>Comprobar</th>
		</tr>
	</thead>
	<tbody id="cursosAprobadosBody">
		<tr id="patternCursosAprobados" style="display:none;" class="rowNoFill">
			<td><span id="tipoCursoAprobado">idCursoAprobado</span></td>
			<td><span id="fechaCursoAprobado">fechaCursoAprobado</span></td>
			<!--td><span id="noParticipantesCursoAprobado">noParticipantesCursoAprobado</span></td-->
			<td><input id="llaveCertificada" type="text" /></td>
			<td><input id="comprobar" type="button" value="Comprobar" onclick="comprobarLlave(this.id)"/></td>
		</tr>
	</tbody>
</table>
<!-- Tabla para alumnos a recertificar -->
<div id="cursosRecertificados" style="display:none;">
<table width="100%">
	<tr>
		<td class="titleTables">Cursos Con Renovación</td>
	</tr>
</table>
<table width="100%">
	<thead height="20">
		<tr class="columnTables" height="20">
			<th height="20">Curso</td>
			<th>Inicio</td>
			<!--th>Participantes</th-->
			<th>Llave</th>
			<th>Comprobar</th>
		</tr>
	</thead>
	<tbody id="cursosRecertificadosBody">
		<tr id="patternCursosRecertificados" style="display:none;" class="rowNoFill">
			<td><span id="tipoCursoRecertificado">idCursoAprobado</span></td>
			<td><span id="fechaCursoRecertificado">fechaCursoAprobado</span></td>
			<!--td><span id="noParticipantesCursoAprobado">noParticipantesCursoAprobado</span></td-->
			<td><input id="llaveCertificada" type="text" /></td>
			<td><input id="comprobar" type="button" value="Comprobar" onclick="comprobarLlaveRenovada(this.id)"/></td>
		</tr>
	</tbody>
</table>
</div>