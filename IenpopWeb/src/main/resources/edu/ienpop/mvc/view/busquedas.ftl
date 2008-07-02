<form action="#" name="busquedaAlumnos">
	<input type="hidden" id="idUsuario" name="idUsuario" value="${usuario.idUsuario}"/>
	<center>
      <table width="675" border="0" cellspacing="0" cellpadding="0">
        <tr>	
          <td width="49" height="22"><img src="img/5px.jpg"><img src="img/formulario_r1_c1.jpg" width="49" height="20"></td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td background="img/formulario_r2_c1.jpg">&nbsp;</td>
          <td background="img/formulario_r2_c5.jpg" class="formTitles">Busqueda de alumnos</td>
          <td width="36" height="24"><img src="img/formulario_r2_c17.jpg" width="36" height="24"></td>
        </tr>
        <tr>
          <td background="img/formulario_r4_c1.jpg">&nbsp;</td>
          <td>
          	<table width="100%" border="0" cellspacing="2">
          		<tr>
          			<td class="myLabel">No.Control:</td>
          			<td><input type="text" id="numeroControl" name="numeroControl" size="10"/></td>
          			<td class="myLabel">Nombre:</td>
          			<td><input type="text" id="nombreCompleto" name="nombreCompleto" size="40" /></td>
          			<td class="myLabel">No.Curso:</td>
          			<td><input type="text" id="idCurso" name="idCurso" size="10" /></td>
          			<!-- Valor por defecto para alumnos certificados -->
					<input type="hidden" name="idStatusAlumno" value="3"/>
          		</tr>
          		<tr>
          			<td class="myLabel">Desde:</td>
          			<td><input type="text" readonly="true" id="desdeAlumno" name="desdeAlumno" onfocus="return showCalendar('desdeAlumno', '%d-%m-%Y', '24', true);"><br></td>
          			<td class="myLabel">Hasta:</td>
          			<td><input type="text" readonly="true" id="hastaAlumno" name="hastaAlumno" onfocus="return showCalendar('hastaAlumno', '%d-%m-%Y', '24', true);"><br></td>
          		</tr>
          	</table>
		<center>
			<input type="button" name="buscaAlumnos" value="Buscar" class="inputButton" onclick="buscarAlumnos()"/>
			<input type="button" name="limpiarBusquedaAlumnos" value="Limpiar" class="inputButton" onclick="busquedaAlumnos.reset()"/>
		</center>
	
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
<!-- Finaliza el primer formulario y voy a colocar la tabla de resultados aqui abajo -->
<table width="100%">
	<thead>
		<tr class="columnTables">
			<th>No. Control</th>
			<th>Nombre</th>
			<th>No. Curso</th>
			<th>Tipo Curso</th>
			<th>Puerto</th>
			<th>Fecha</th>
			<th>Modificar</th>
		</tr>
	</thead>
	<tbody id="resultadoAlumnosBody">
		<tr id="patternAlumnoBusqueda" class="rowNoFill">
			<td><div id="numeroControl">&nbsp;</div></td>
			<td><div id="nombreCompleto">&nbsp;</div></td>
			<td><div id="numeroCurso">&nbsp;</div></td>
			<td><div id="tipoCurso">&nbsp;</div></td>
			<td><div id="idPuerto">&nbsp;</div></td>
			<td><div id="fechaRegistro">&nbsp;</div></td>
			<td><div id="modificarAlumno">&nbsp;</div></td>
		</tr>
	</tbody>
</table>
<!--Paginador-->
<center>
<div id="mensajeResultadosAlumnos" class="goodMessage">
	.: Se han encontrado 0 resultados :.
</div>
<div id="paginadorAlumnos" class="userInfo">
	Paginador
</div>
</center>
<!--Paginador-->
<!-- Otro formulario de busqueda pero esta vez de cursos... -->
<form action="#" name="busquedaCursos">
	<input type="hidden" id="idUsuario" name="idUsuario" value="${usuario.idUsuario}"/>
	<center>
      <table width="675" border="0" cellspacing="0" cellpadding="0">
        <tr>	
          <td width="49" height="22"><img src="img/5px.jpg"><img src="img/formulario_r1_c1.jpg" width="49" height="20"></td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td background="img/formulario_r2_c1.jpg">&nbsp;</td>
          <td background="img/formulario_r2_c5.jpg" class="formTitles">Busqueda de Cursos</td>
          <td width="36" height="24"><img src="img/formulario_r2_c17.jpg" width="36" height="24"></td>
        </tr>
        <tr>
          <td background="img/formulario_r4_c1.jpg">&nbsp;</td>
          <td>
          
			<!--Contenido del formulario-->          
          	<table width="100%" border="0" cellspacing="2">
          		<tr>
          			<td class="myLabel2">Puertos:</td>
          		</tr>
          		<tr>
          			<td class="myCheckbox">
          				<table width="100%" cellpadding="0" cellspacing="0">
          				<tr>
          				<#list usuario.puertos as puerto>
          					<#if puerto_index%10 == 0 && (puerto_index>0) >
          						</tr><tr>
          					</#if>
          						<td class="myCheckbox"><input type="checkbox" name="idPuerto" value="${puerto.idPuerto}" />
          						${puerto.idPuerto}</td>
          				</#list>
          				</tr>
          				</table>
          			</td>
          		</tr>
          		<tr>
          			<td class="myLabel2">Tipos de curso</td>
          		</tr>
          		<tr>
          			<td class="myCheckbox">
          				<table width="100%" cellpadding="0" cellspacing="0">
          				<tr>
          				<#list catalogoCursos as tipoCurso>
          					<#if tipoCurso_index%5 == 0 && (tipoCurso_index>0) >
          						</tr><tr>
          					</#if>
          					<td class="myCheckbox"><input type="checkbox" name="idTipoCurso" value="${tipoCurso.idTipoCurso}" />
          					${tipoCurso.idTipoCurso}</td>
          					
          				</#list>
          				</tr>
          				</table>
          			</td>
          		</tr>
          		<tr>
          			<td>
          			<table width="100%" cellpadding="0" cellspacing="0">
          			<tr>
          			<td class="myLabel">Desde:</td>
          			<td><input type="text" readonly="true" id="desdeCurso" name="desdeCurso" onfocus="return showCalendar('desdeCurso', '%d-%m-%Y', '24', true);"><br></td>
          			<td class="myLabel">Hasta:</td>
          			<td><input type="text" readonly="true" id="hastaCurso" name="hastaCurso" onfocus="return showCalendar('hastaCurso', '%d-%m-%Y', '24', true);"><br></td>
          			</tr>
          			</table>
          			</td>
          		</tr>
          	</table>
        	<input type="hidden" name="idStatusCurso" value="4"/>
			<center><input type="button" name="buscaCursos" value="Buscar" class="inputButton" onclick="buscarCursos()"/></center>
	
	
			<!--Contenido del formulario-->
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