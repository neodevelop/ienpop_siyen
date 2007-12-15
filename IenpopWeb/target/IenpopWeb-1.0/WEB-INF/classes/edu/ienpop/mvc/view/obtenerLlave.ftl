<form action="#" name="obtenerCursos">
<center>
	<input type="hidden" id="idUsuario" name="idUsuario" value="${usuario.idUsuario}"/>
	<input type="hidden" id="idPuerto" name="idPuerto" value="<#list usuario.puertos as puerto>${puerto.idPuerto?default('')} </#list>"/>
	<input type="hidden" id="idCurso" name="idCurso" value="<#list catalogoCursos as curso>${curso.idTipoCurso?default('')} </#list>"/>
	<input type="hidden" id="nombreCurso" name="nombreCurso" value="<#list catalogoCursos as curso>${curso.nombreCurso?default('')}| </#list>"/>
	<input type="button" name="obtenerCursosXCertificar" class="inputButton" id="obtenerCursosXCertificar" value="Listar cursos" onClick="obtenerCursosSinLlave()"/>
</center>
</form>
<table width="100%">
	<tr>
		<td class="titleTables">Cursos Por Certificar Sin Autorización</td>
	</tr>
</table>
<table width="100%">
	<thead>
		<tr class="columnTables">
			<th>Curso</td>
			<th>Fecha de Inicio</td>
			<th>Participantes</th>
			<th>Generar llave</th>
		</tr>
	</thead>
	<tbody id="cursosXCertificarBody">
		<tr id="patternCursoXCertificar" style="display:none;" class="rowNoFill">
			<td><span id="tipoCursoXCertificar">idCursoXCertificar</span></td>
			<td><span id="fechaInicioCursoXCertificar">fechaInicioCursoXCertificar</span></td>
			<td><span id="noParticipantesCursoXCertificar">noParticipantesCursoXCertificar</span></td>
			<td><input id="llave" type="button" value="Generar Llave" onclick="generarLlave(this.id)"/></td>
		</tr>
	</tbody>
</table>