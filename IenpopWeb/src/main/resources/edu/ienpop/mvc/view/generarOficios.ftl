<form action="#" name="generarOficio">
	<center>
      <table width="675" border="0" cellspacing="0" cellpadding="0">
        <tr>	
          <td width="49" height="22"><img src="img/5px.jpg"><img src="img/formulario_r1_c1.jpg" width="49" height="20"></td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td background="img/formulario_r2_c1.jpg">&nbsp;</td>
          <td background="img/formulario_r2_c5.jpg" class="formTitles">Generar oficios de cursos certificados</td>
          <td width="36" height="24"><img src="img/formulario_r2_c17.jpg" width="36" height="24"></td>
        </tr>
        <tr>
          <td background="img/formulario_r4_c1.jpg">&nbsp;</td>
          <td>
          	<table width="100%" border="0" cellspaciing="2">
          		<tr>
          			<td class="myLabel">Dirigido a:</td>
          			<td>
          				<input type="text" name="dirigido" id="dirigido" size="60"/>
          			</td>
          		</tr>
          	</table>
          	<table width="100%" border="0" cellspaciing="2">
          		<tr>
          			<td>Desde:</td>
          			<td>Desde:</td>
          			<td>Desde:</td>
          			<td>Desde:</td>
          		</tr>
          	</table>
	
	<br>
	<br>Hasta:<input type="text" readonly="true" id="hasta" name="hasta" onfocus="return showCalendar('hasta', '%d-%m-%Y', '24', true);"><br>
	<br>En:<select name="idPuerto" id="idPuerto">
          			<#list usuario.puertos as puerto>
						<option value="${puerto.idPuerto?default('')}">${puerto.puerto?default('')}, ${puerto.estado?default('')}</option>
					</#list>
          		</select>
	<br>No.Oficio: <input type="no" name="no" id="no"/>
	<br><input type="button" name="generar" value="Generar" />
	
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