<form action="#" name="informeMensual">
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
          <td background="img/formulario_r2_c5.jpg" class="formTitles">Informe periodico</td>
          <td width="36" height="24"><img src="img/formulario_r2_c17.jpg" width="36" height="24"></td>
        </tr>
        <tr>
          <td background="img/formulario_r4_c1.jpg">&nbsp;</td>
          <td>
          	<table width="100%" border="0" cellspacing="2">
          		<tr>
          			<td class="myLabel">Desde:</td>
          			<td><input type="text" readonly="true" id="fechaInicio" name="fechaInicio" onfocus="return showCalendar('fechaInicio', '%d-%m-%Y', '24', true);"><br></td>
          			<td class="myLabel">Hasta:</td>
          			<td><input type="text" readonly="true" id="fechaFin" name="fechaFin" onfocus="return showCalendar('fechaFin', '%d-%m-%Y', '24', true);"><br></td>
          		</tr>
          	</table>
		<center><input type="button" name="generar1" value="Solo Cursos" class="inputButton" onclick="showInformePeriodico(1)"/>
		<input type="button" name="generar2" value="Alumnos y Cursos" class="inputButton" onclick="showInformePeriodico(2)"/></center>
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
<!-- -*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*- -->
<form action="#" name="informeTipoLibreta">
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
          <td background="img/formulario_r2_c5.jpg" class="formTitles">Informe por tipo de libreta</td>
          <td width="36" height="24"><img src="img/formulario_r2_c17.jpg" width="36" height="24"></td>
        </tr>
        <tr>
          <td background="img/formulario_r4_c1.jpg">&nbsp;</td>
          <td>
          	<table width="100%" border="0" cellspacing="2">
          		<tr>
          			<td class="myLabel">Desde:</td>
          			<td><input type="text" readonly="true" id="fechaInicio2" name="fechaInicio2" onfocus="return showCalendar('fechaInicio2', '%d-%m-%Y', '24', true);"><br></td>
          			<td class="myLabel">Hasta:</td>
          			<td><input type="text" readonly="true" id="fechaFin2" name="fechaFin2" onfocus="return showCalendar('fechaFin2', '%d-%m-%Y', '24', true);"><br></td>
          			<td class="myLabel">Puerto:</td>
          			<td>
          				<select name="idPuerto" id="idPuerto">
          					<#list usuario.puertos as puerto>
								<option value="${puerto.idPuerto?default('')}">${puerto.puerto?default('')}, ${puerto.estado?default('')}</option>
							</#list>
          				</select>
          			</td>
          		</tr>
          	</table>
          	<table width="100%" border="0" cellspacing="2">
          		<tr>
          			<td align="center">Libreta</td>
          		</tr>
          		<tr align="center">
          			<td>
  						<input type="checkbox" name="libreta" id="libreta" value="A" />
    					A
    					
  						<input type="checkbox" name="libreta" id="libreta" value="B" />
    					B
    					
  						<input type="checkbox" name="libreta" id="libreta" value="C" />
    					C
    					
  						<input type="checkbox" name="libreta" id="libreta" value="D" />
    					D
          			</td>
          		</tr>
          	</table>
		<center><input type="button" name="generar1" value="Solo Cursos" class="inputButton" onclick="showInformeTipoLibreta(3)"/>
		<input type="button" name="generar2" value="Alumnos y Cursos" class="inputButton" onclick="showInformeTipoLibreta(4)"/></center>
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