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
          <td background="img/formulario_r2_c5.jpg" class="formTitles">. : Datos del curso a modificar : .</td>
          <td width="36" height="24"><img src="img/formulario_r2_c17.jpg" width="36" height="24"></td>
        </tr>
        <tr>
          <td background="img/formulario_r4_c1.jpg">&nbsp;</td>
          <td>
          	<table width="100%" border="0" cellspaciing="2">
          		<tr>
          			<td class="myLabel">Curso:</td>
          			<td class="goodMessage"><b><span id="idCurso">idCurso</span></b></td>
          			<td class="myLabel">Instructor:</td>
          			<td>
          				<select name="idUsuarioCurso" id="idUsuarioCurso">
          					<#list instructores as instructor>
								<option value="${instructor.idUsuario?default('')}">${instructor.nombre?default('')}</option>
							</#list>
          				</select>
          			</td>
          			<td>&nbsp;</td>
          			<td>&nbsp;</td>
          		</tr>
          		<tr>
          			<td class="myLabel">Fecha Inicio:</td>
          			<td>
          			<input type="text" readonly="true" id="fechaInicioModificar" name="fechaInicioModificar" onfocus="return showCalendar('fechaInicioModificar', '%d-%m-%Y', '24', true);"><br>
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
          		<tr>
          			<td class="myLabel">Fecha fin:</td>
          			<td class="goodMessage"><span id="fechaFinModificar">fechaFinModificar</span></td>
          			<td class="myLabel">Registrado:</td>
          			<td class="goodMessage"><span id="fechaRegistroModificar">fechaRegistroModificar</span></td>
          			<td class="myLabel">Alumnos:</td>
          			<td class="goodMessage"><span id=""><span id="numeroAlumnos">numeroAlumnos</span></span></td>
          		</tr>
          	</table>
          	<input type="hidden" id="idUsuario" name="idUsuario" value="${usuario.idUsuario}"/>
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