<form action="#" name="validarCertificadoForma" onSubmit="return validarCertificado();">
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
          <td background="img/formulario_r2_c5.jpg" class="formTitles">Validar el certificado</td>
          <td width="36" height="24"><img src="img/formulario_r2_c17.jpg" width="36" height="24"></td>
        </tr>
        <tr>
          <td background="img/formulario_r4_c1.jpg">&nbsp;</td>
          <td>
          	<table width="100%" border="0" cellspacing="2">
          		<tr align="center">
          			<td class="myLabel" align="right">C—digo de barras:</td>
          			<td>
          				<input type="password" name="barcode" align="left" id="barcode" size="50"/>
          			</td>
          			<td><input type="reset" name="reset" value="Limpiar" class="inputButton"/></td>
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
        <tr>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
 	 </table>
  	  </center>
</form>

<!-- Despliegue de lo que encuentre -->
<center>
<table width="70%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td class="titleTables">Datos del curso</td>
	</tr>
</table>
<table width="90%" border="0" cellspacing="0" cellpadding="0">
	<tr class="columnTables">
		<th>Numero de Curso</td>
		<th>Fecha Inicio</td>
		<th>Fecha Fin</td>
		<th>Puerto</td>
		<th>Curso</td>
	</tr>
	<tr class="rowNoFill">
		<td>
			<span id="idCursoCertificadoTable"></span>
		</td>
		<td>
			<span id="fechaInicioCertificadoTable"></span>
		</td>
		<td>
			<span id="fechaFinCertificadoTable"></span>
		</td>
		<td>
			<span id="puertoCertificadoTable"></span>
		</td>
		<td>
			<span id="nombreCursoCertificadoTable"></span>
		</td>
	</tr>
</table>
<br><br>
<!-- Detalle del curso -->
<table width="70%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td class="titleTables">Alumnos del curso</td>
	</tr>
</table>
<table width="60%" border="0" cellspacing="0" cellpadding="0">
	<thead>
	<tr class="columnTables">
		<th>Numero de Control</td>
		<th>Nombre Completo</td>
		<th>Nœmero de Curso</td>
	</tr>
	</thead>
	<tbody id="alumnosCertificadosBody">
		<tr id="patternCertificado" style="display:none;" class="rowNoFill">
			<td width="30%">
				<span id="numeroControlCertificadoTable">numeroControl</span>
			</td>
			<td width="30%">
				<span id="nombreCompletoCertificadoTable">nombreCompleto</span>
			</td>
			<td width="30%">
				<span id="idCursoCertificadoTable">idCurso</span>
			</td>
		</tr>
	</tbody>
</table>
</center>