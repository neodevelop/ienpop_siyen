<form action="#" name="nuevoCurso">
	<center>
      <table width="675" border="0" cellspacing="0" cellpadding="0">
        <tr>	
          <td width="49" height="22"><img src="img/5px.jpg"><img src="img/formulario_r1_c1.jpg" width="49" height="20"></td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td background="img/formulario_r2_c1.jpg">&nbsp;</td>
          <td background="img/formulario_r2_c5.jpg" class="formTitles">Datos del nuevo curso</td>
          <td width="36" height="24"><img src="img/formulario_r2_c17.jpg" width="36" height="24"></td>
        </tr>
        <tr>
          <td background="img/formulario_r4_c1.jpg">&nbsp;</td>
          <td>
          	<table width="100%" border="0" cellspaciing="2">
          		<tr>
          			<td class="myLabel">Fecha Inicio:</td>
          			<td>
          			<input type="text" readonly="true" id="fechaInicioCurso" name="fechaInicioCursoXCertificar" onfocus="return showCalendar('fechaInicioCurso', '%d-%m-%Y', '24', true);"><br>
          			</td>
          			<td class="myLabel">Puerto:</td>
          			<td>
          				<select name="idPuerto" id="idPuerto">
          					<#list usuario.puertos as puerto>
								<option value="${puerto.idPuerto?default('')}">${puerto.puerto?default('')}, ${puerto.estado?default('')}</option>
							</#list>
          				</select>
					</td>
          			<td class="myLabel">Curso:</td>
          			<td>
          				<select name="idTipoCurso" id="idTipoCurso">
          					<#list catalogoCursos as curso>
								<option value="${curso.idTipoCurso?default('')}">${curso.idTipoCurso?default('')}</option>
							</#list>
          				</select>
					</td>
          		</tr>
          	</table>
          	<input type="hidden" id="idUsuario" name="idUsuario" value="${usuario.idUsuario}"/>
          	<br>
          	<center>
          		<input name="crear" type="button" class="inputButton" value="Confirmar" onClick="creaNuevoCurso()"/>
          	</center>
          	<center>
          		<div id="agregarAlumnos">
          			<input type="hidden" id="idCursoXCertificar" name="idCursoXCertificar"/>
          			<table border="0" width="100%">
          				<tr>
          					<td width="50%" valign="top">
          						<fieldset>
          							<legend>Agregar alumnos</legend>
          								<table width="100%" border="0">
          									<tr>
          										<td class="myLabel">Nombre:</td>
          										<td><input type="text" id="nombreCompletoXCertificar" name="nombreCompletoXCertificar" size="30"/></td>
          									<tr>
          									<tr>
          										<td class="myLabel">Observaciones:</td>
          										<td>
          											<textarea name="observacionesXCertificar" id="observacionesXCertificar" rows="3" cols="20">Ninguna</textarea>
          										</td>
          									<tr>
          									<tr>
          										<td><input type="hidden" id="idAlumnoXCertificar" name="idAlumnoXCertificar" value="-1"/></td>
          										<td><input name="agregar" type="button" class="inputButton" value="Guardar" onClick="agregaAlumnoXCertificar()"/></td>
          									<tr>
          								</table>
          						</fieldset>
          					</td>
          					<td width="50%" valign="top">
          						<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td class="titleTables">Alumnos inscritos</td>
									</tr>
								</table>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<thead>
									<tr class="columnTables">
										<th width="60%">Nombre</td>
										<th>Acciones</td>
									</tr>
									</thead>
									<tbody id="alumnosBody">
										<tr id="pattern" style="display:none;" class="rowNoFill">
											<td width="60%">
												<span id="nombreCompletoTable">nombre</span>
											</td>
											<td>
												<input id="edit" type="button" value="Editar" onclick="editarAlumnoXCertificar(this.id)"/>|
												<input id="delete" type="button" value="Borrar" onclick="borrarAlumnoXCertificar(this.id)"/>
											</td>
										</tr>
									</tbody>
								</table>
          					</td>
          				</tr>
          				<tr>
          					<td align="center">
          						<input id="cerrarCurso" type="button" class="inputButton" value="Terminar captura..." onclick="cerrarCursoNuevo()"/>
          					</td>
          				</tr>
          			</table>
          		</div>
          	</center>
			</td>
          <td background="img/formulario_r4_c17.jpg">&nbsp;</td>
        </tr>
        <tr>
          <td><img src="img/formulario_r6_c1.jpg" width="49" height="36"></td>
          <td background="img/formulario_r6_c5.jpg">&nbsp;</td>
          <td><img src="img/formulario_r6_c17.jpg" width="36" height="36"></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
 	 </table>
  	  </center>
  	  </form>