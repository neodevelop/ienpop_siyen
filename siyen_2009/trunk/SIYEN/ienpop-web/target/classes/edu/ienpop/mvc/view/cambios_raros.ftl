<div id="iniciaCambioRaro">
<form action="#" name="busquedaCurso">
	<table width="100%">
		<tr>
			<td class="myLabel">Numero de Curso:</td>
			<td><input type="text" name="numeroCursoRaro" id="numeroCursoRaro" size="10"/></td>
			<td><input type="button" name="buscarCursoRaro" class="inputButton" value="Buscar Curso" onclick="buscarCursoParaCambioRaro(numeroCursoRaro.value)"/></td>
			<td class="goodMessage" align="left">Si el curso no existe, hay que crear uno nuevo(<a href="javascript:crearCursoParaCambioRaro()">clic aqui</a>)</td>
		</tr>
	</table>
</form>
</div>

<div id="formaCambiosRaros" style="display:none;">
<form action="#" name="cambiosRaros">
	<center>
		<table width="675" border="0" cellspacing="0" cellpadding="0">
        <tr>	
          <td width="49" height="22"><img src="img/5px.jpg"><img src="img/formulario_r1_c1.jpg" width="49" height="20"></td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td background="img/formulario_r2_c1.jpg">&nbsp;</td>
          <td background="img/formulario_r2_c5.jpg" class="formTitles">. : Datos del curso a alterar : .</td>
          <td width="36" height="24"><img src="img/formulario_r2_c17.jpg" width="36" height="24"></td>
        </tr>
        <tr>
          <td background="img/formulario_r4_c1.jpg">&nbsp;</td>
          <td>
          	<table width="100%" border="0" cellspaciing="2">
          		<tr>
          			<td class="myLabel">Curso:</td>
          			<td class="goodMessage"><b><span id="idCursoRaro">idCurso</span></b></td>
          			<td class="myLabel">Instructor:</td>
          			<td class="goodMessage">
          				<span id="idUsuarioCursoRaro">idUsuarioCurso</span>
          			</td>
          			<td>&nbsp;</td>
          			<td>&nbsp;</td>
          		</tr>
          		<tr>
          			<td class="myLabel">Inicio:</td>
          			<td class="goodMessage">
          				<span id="fechaInicioModificarRaro">fechaInicioModificar</span>
          			</td>
          			<td class="myLabel">Puerto:</td>
          			<td class="goodMessage">
          				<span id="idPuertoRaro">idPuerto</span>
					</td>
          			<td class="myLabel">Curso:</td>
          			<td class="goodMessage">
          				<span id="idTipoCursoRaro">idTipoCurso</span>
					</td>
          		</tr>
          		<tr>
          			<td class="myLabel">Finaliza:</td>
          			<td class="goodMessage"><span id="fechaFinModificarRaro">fechaFinModificar</span></td>
          			<td>&nbsp;</td>
          			<td class="myLabel">&nbsp;</td>
          			<td>&nbsp;</td>
          			<td>&nbsp;</td>
          		</tr>
          		<tr>
          			<td class="myLabel">Registrado:</td>
          			<td class="goodMessage"><span id="fechaRegistroModificarRaro">fechaRegistroModificar</span></td>
          			<td>&nbsp;</td>
          			<td class="myLabel">Alumnos:</td>
          			<td class="goodMessage"><span id=""><span id="numeroAlumnosRaro">numeroAlumnos</span></span></td>
          			<td>&nbsp;</td>
          		</tr>
          	</table>
          	<!--input type="hidden" id="idUsuario" name="idUsuario" value="${usuario.idUsuario}"/-->
          </td>
          <td background="img/formulario_r4_c17.jpg">&nbsp;</td>	
		</tr>
		<tr>
          <td><img src="img/formulario_r6_c1.jpg" width="49" height="36"></td>
          <td background="img/formulario_r6_c5.jpg">&nbsp;</td>
          <td><img src="img/formulario_r6_c17.jpg" width="36" height="36"></td>
        </tr>
		</table>
	</center>
</form>
</div>

<div id="nuevoCursoRaro" style="display:none;">
<form action="#" name="modificarCurso">
	<center>
		<table width="675" border="0" cellspacing="0" cellpadding="0">
        <tr>	
          <td width="49" height="22"><img src="img/5px.jpg"><img src="img/formulario_r1_c1.jpg" width="49" height="20"></td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td background="img/formulario_r2_c1.jpg">&nbsp;</td>
          <td background="img/formulario_r2_c5.jpg" class="formTitles">. : Datos del curso a crear : .</td>
          <td width="36" height="24"><img src="img/formulario_r2_c17.jpg" width="36" height="24"></td>
        </tr>
        <tr>
          <td background="img/formulario_r4_c1.jpg">&nbsp;</td>
          <td>
          	<table width="100%" border="0" cellspaciing="2">
          		<tr>
          			<td class="myLabel">&nbsp;</td>
          			<td class="goodMessage">&nbsp;</td>
          			<td class="myLabel">Instructor:</td>
          			<td>
          				<select name="idUsuarioCursoNuevo" id="idUsuarioCursoNuevo">
          					<#list instructores as instructor>
								<option value="${instructor.idUsuario?default('')}">${instructor.nombre?default('')}</option>
							</#list>
          				</select>
          			</td>
          			<td>&nbsp;</td>
          			<td>&nbsp;</td>
          		</tr>
          		<tr>
          			<td class="myLabel">Inicio:</td>
          			<td>
          			<input type="text" readonly="true" id="fechaInicioNuevo" name="fechaInicioNuevo" onfocus="return showCalendar('fechaInicioNuevo', '%d-%m-%Y', '24', true);"><br>
          			</td>
          			<td class="myLabel">Puerto:</td>
          			<td>
          				<select name="idPuertoNuevo" id="idPuertoNuevo">
          					<#list usuario.puertos as puerto>
								<option value="${puerto.idPuerto?default('')}">${puerto.puerto?default('')}, ${puerto.estado?default('')}</option>
							</#list>
          				</select>
					</td>
          			<td class="myLabel">Curso:</td>
          			<td>
          				<select name="idTipoCursoNuevo" id="idTipoCursoNuevo">
          					<#list catalogoCursos as curso>
								<option value="${curso.idTipoCurso?default('')}">${curso.idTipoCurso?default('')}</option>
							</#list>
          				</select>
					</td>
          		</tr>
          	</table>
          </td>
          <td background="img/formulario_r4_c17.jpg">&nbsp;</td>	
		</tr>
		<tr>
          <td><img src="img/formulario_r6_c1.jpg" width="49" height="36"></td>
          <td background="img/formulario_r6_c5.jpg">&nbsp;</td>
          <td><img src="img/formulario_r6_c17.jpg" width="36" height="36"></td>
        </tr>
		</table>
	</center>
</form>
</div>

<div id="terminaCambioRaro" style="display:none;">
	<center>
	<input type="button" id="ejecutaCambioRaro" value="Ejecutar cambio raro" onClick="ejecutarCambioRaro()" class="inputButton" />
	<input type="button" id="cancelaCambioRaro" value="Cancelar cambio raro" onClick="cancelarCambioRaro()" class="inputButton" />
	</center>
</div>

<div id="alumnosRaros" style="display:none;">
<form action="#" name="formaAlumnosRaros">
	<center>
      <table width="675" border="0" cellspacing="0" cellpadding="0">
        <tr>	
          <td width="49" height="22"><img src="img/5px.jpg"><img src="img/formulario_r1_c1.jpg" width="49" height="20"></td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td background="img/formulario_r2_c1.jpg">&nbsp;</td>
          <td background="img/formulario_r2_c5.jpg" class="formTitles">Alumnos del curso raro</td>
          <td width="36" height="24"><img src="img/formulario_r2_c17.jpg" width="36" height="24"></td>
        </tr>
        <tr>
          <td background="img/formulario_r4_c1.jpg">&nbsp;</td>
          <td>
          	<table width="100%" border="0" cellspaciing="2">
          		<tr>
          			<td class="myLabel">No. Control:</td>
          			<td>
          				<input type="text" value="II0" id="numeroControlRaro" name="numeroControlRaro" />
          				<input type="button" value="Buscar y agregar" class="inputButton" onClick="buscarYAgregar(numeroControlRaro.value)" />
          			</td>
          			<td>&nbsp;</td>
          		</tr>
          	</table>

          	<center>
          		<div id="agregarAlumnosRaros">
          			<table border="0" width="100%">
          				<tr>
          					<td width="50%" valign="top">
          						<fieldset>
          							<legend>Agregar alumnos</legend>
          								<table width="100%" border="0">
          									<tr>
          										<td class="myLabel">Nombre:</td>
          										<td><input type="text" id="nombreCompletoRaro" name="nombreCompletoRaro" size="30"/></td>
          									<tr>
          									<tr>
          										<td class="myLabel"><!--Observaciones:--></td>
          										<td>
          											<!--textarea name="observacionesRaro" id="observacionesRaro" rows="3" cols="20">Ninguna</textarea-->
          										</td>
          									<tr>
          									<tr>
          										<td>&nbsp;</td>
          										<td><input name="agregar" type="button" class="inputButton" value="Agregar" onClick="agregarNuevoAlumno(nombreCompletoRaro.value)"/></td>
          									<tr>
          								</table>
          						</fieldset>
          					</td>
          					<td width="50%" valign="top">
          						<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td class="titleTables">Alumnos adicionales</td>
									</tr>
								</table>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<thead>
									<tr class="columnTables">
										<th>No.Control</th>
										<th width="60%">Nombre</td>
										<!--th>Acciones</td-->
									</tr>
									</thead>
									<tbody id="alumnosRarosBody">
										<tr id="patternRaro" style="display:none;" class="rowNoFill">
											<td>
												<span id="numeroControlRaro">numeroControl</span>
											</td>
											<td width="60%">
												<span id="nombreCompletoRaro">nombre</span>
											</td>
											<!--td>
												<input id="borrarRaro" type="button" value="Barrar" onclick="quitarAlumnoRaro(this.id)"/>
											</td-->
										</tr>
									</tbody>
								</table>
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
</div>


<center>
<div id="mensajeInformacion" style="display:block;" class="goodMessage">
	Puedes buscar un curso para agregarle alumnos existentes o nuevos...
	<br>O bien, puedes crear un curso nuevo donde agregaras alumnos existentes o nuevos...
</div>
<div id="mensajeExcepcion" style="display:none;" class="errorMessage">
	Mensaje de Error
</div>
</center>