<html>
<head>
<title>.: IENPOP - SIYEN :.</title>
<link rel="stylesheet" type="text/css" href="css/siyen_blue.css">
</head>
<body>
<center>
  <table width="780" border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td><img src="img/header.jpg" width="780" height="91"></td>
    </tr>
    <tr>
      <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr class="userInfo">
            <td width="33%" align="left">${usuario.nombre?default('')} </td>
            <td width="33%" align="center">
            	<#if usuario.tipoUsuario=1>
					<#list usuario.puertos as puerto>
						${puerto.puerto?default('')}, ${puerto.estado?default('')} - 
						<#break>
					</#list>
				</#if>
            	<#switch usuario.tipoUsuario>
            		<#case 1>
            			Instructor
            			<#break>
            		<#case 2>
            			Goku
            			<#break>
            		<#case 3>
            			Jefatura de Titulacion
            			<#break>	
            	</#switch>
            </td>
            <td width="33%" align="right">
            <script languaje="JavaScript">
				var mydate=new Date()
				var year=mydate.getYear()
				if (year < 1000)
					year+=1900
				var day=mydate.getDay()
				var month=mydate.getMonth()
				var daym=mydate.getDate()
				if (daym<10)
					daym="0"+daym
				var dayarray=new Array("Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado")
				var montharray=new Array("Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre")
				document.write(dayarray[day]+" "+daym+" de "+montharray[month]+" de "+year)
			</script>
            </td>
          </tr>
        </table></td>
    </tr>
    <tr>
      <td><center>
          <table width="750" border="1" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC" bgcolor="#FFFFFF" class="workarea">
            <tr>
              <td align="center"><table width="100%" border="0" cellspacing="0" cellpadding="5">
                  <tr>
                    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td width="12" height="33"><img src="img/inicio_menu.jpg" width="12" height="33"></td>
                          <div id="tabList">
                          <td background="img/menu_fill.jpg">
                          	<img src="img/nuevo_curso.jpg" width="114" height="33" border="0">
                          	<img src="img/modificar_curso.jpg" width="124" height="33" border="0">
                          	<img src="img/obtener_llave.jpg" width="125" height="33" border="0">
                          	<img src="img/busquedas.jpg" width="99" height="33">
                          	<img src="img/generar_oficios.jpg" width="134" height="33">
                          	<img src="img/imprimir.jpg" width="91" height="33">
                          </td>
                          </div>
                        </tr>
                      </table></td>
                  </tr>
                  <!------------------------------------ INICIA TAB CONTENTS ------------------------------------------->
                  <div id="tabContents">
                  
                  <!------------------------------------ INICIA CONTENT 1 ------------------------------------------->
                  <div id="nuevoCurso">
                  <tr>
                    <td align="center">
                    <form action="" name="nuevoCurso" method="post">
                      <table width="500" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                          <td width="49" height="22"><img src="img/5px.jpg"><img src="img/formulario_r1_c1.jpg" width="49" height="20"></td>
                          <td>&nbsp;</td>
                          <td>&nbsp;</td>
                        </tr>
                        <tr>
                          <td background="img/formulario_r2_c1.jpg">&nbsp;</td>
                          <td background="img/formulario_r2_c5.jpg" class="formTitles">Titulo del Formulario </td>
                          <td width="36" height="24"><img src="img/formulario_r2_c17.jpg" width="36" height="24"></td>
                        </tr>
                        <tr>
                          <td background="img/formulario_r4_c1.jpg">&nbsp;</td>
                          <td>&nbsp;</td>
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
                    </form></td>
                  </tr>
                  </div>
                  <!------------------------------------ TERMINA CONTENT 1 ------------------------------------------->
                  <tr>
                    <td>&nbsp;</td>
                  </tr>
                  <!------------------------------------ INICIA CONTENT 2 ------------------------------------------->
                  <div id="modificarCurso">
                  <tr>
                    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td width="50%" align="center"><table width="300" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="20" height="20"><img src="img/forma_azul_r1_c1.jpg" width="20" height="20"></td>
							<td background="img/forma_azul_r1_c2.jpg" class="headerBoxBlue">T&iacute;tulo del mensaje </td>
                            <td width="20" height="20"><img src="img/forma_azul_r1_c4.jpg" width="20" height="20"></td>
                          </tr>
                          <tr>
                            <td background="img/forma_azul_r2_c1.jpg">&nbsp;</td>
                            <td class="boxBlue">cuerpo del mensaje en bajo perfil...!!! </td>
                            <td background="img/forma_azul_r2_c4.jpg">&nbsp;</td>
                          </tr>
                          <tr>
                            <td width="20" height="22"><img src="img/forma_azul_r7_c1.jpg" width="20" height="22"></td>
                            <td background="img/forma_azul_r7_c2.jpg">&nbsp;</td>
                            <td><img src="img/forma_azul_r7_c4.jpg" width="20" height="22"></td>
                          </tr>
                        </table></td>
                        <td width="50%" align="center"><table width="250" border="0" cellspacing="0" cellpadding="0">
                          <tr>
                            <td width="20" height="20"><img src="img/forma_gris_r1_c1.jpg" width="20" height="20"></td>
                            <td background="img/forma_gris_r1_c2.jpg" class="headerBoxGrey">Titulo del Recuadro </td>
                            <td width="20" height="20"><img src="img/forma_gris_r1_c4.jpg" width="20" height="20"></td>
                          </tr>
                          <tr>
                            <td background="img/forma_gris_r5_c1.jpg">&nbsp;</td>
                            <td class="boxGrey">Lorem ipsum mortem </td>
                            <td background="img/forma_gris_r5_c4.jpg">&nbsp;</td>
                          </tr>
                          <tr>
                            <td width="20" height="20"><img src="img/forma_gris_r7_c1.jpg" width="20" height="22"></td>
                            <td background="img/forma_gris_r7_c2.jpg">&nbsp;</td>
                            <td><img src="img/forma_gris_r7_c4.jpg" width="20" height="22"></td>
                          </tr>
                        </table></td>
                      </tr>
                    </table></td>
                  </tr>
                  </div>
                  <!------------------------------------ TERMINA CONTENT 2 ------------------------------------------->
                  <tr>
                    <td>&nbsp;</td>
                  </tr>
                  <!------------------------------------ INICIA CONTENT 3 ------------------------------------------->
                  <div id="obtenerLlave">
                  <tr>
                    <td>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td class="titleTables">TITULO DE LA TABLA </td>
                      </tr>
                    </table>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr class="columnTables">
    <td>Columna 1</td>
    <td>Columna 2 </td>
    <td>Columna 3 </td>
    <td>Columna 4 </td>
    <td>Columna 5 </td>
  </tr>
  <tr class="rowNoFill">
    <td>Texto1.1</td>
    <td>Texto1.2</td>
    <td>Texto1.3</td>
    <td>Texto1.4</td>
    <td>Texto1.5</td>
  </tr>
  <tr class="rowFill">
    <td>Texto2.1</td>
    <td>Texto2.2</td>
    <td>Texto2.3</td>
    <td>Texto2.4</td>
    <td>Texto2.5</td>
  </tr>
  <tr class="rowNoFill">
    <td>Texto3.1</td>
    <td>Texto3.2</td>
    <td>Texto3.3</td>
    <td>Texto3.4</td>
    <td>Texto3.5</td>
  </tr>
  <tr class="rowFill">
    <td>Texto4.1</td>
    <td>Texto4.2</td>
    <td>Texto4.4</td>
    <td>Texto4.5</td>
    <td>Texto4.6</td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class="rowCentral">Contenido Central </td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr class="columnTables">
    <td>Columna 1</td>
    <td>Columna 2 </td>
    <td>Columna 3 </td>
    <td>Columna 4 </td>
    <td>Columna 5 </td>
  </tr>
  <tr class="rowNoFill">
    <td><a href="#">Texto1.1</a></td>
    <td>Texto1.2</td>
    <td>Texto1.3</td>
    <td>Texto1.4</td>
    <td>Texto1.5</td>
  </tr>
  <tr class="rowFill">
    <td>Texto2.1</td>
    <td>Texto2.2</td>
    <td>Texto2.3</td>
    <td>Texto2.4</td>
    <td>Texto2.5</td>
  </tr>
  <tr class="rowNoFill">
    <td>Texto3.1</td>
    <td>Texto3.2</td>
    <td>Texto3.3</td>
    <td>Texto3.4</td>
    <td>Texto3.5</td>
  </tr>
  <tr class="rowFill">
    <td>Texto4.1</td>
    <td>Texto4.2</td>
    <td>Texto4.4</td>
    <td>Texto4.5</td>
    <td>Texto4.6</td>
  </tr>
</table>					</td>
                  </tr>
                  </div>
                  <!------------------------------------ TERMINA CONTENT 3 ------------------------------------------->
				  <tr>
                    <td>&nbsp;</td>
                  </tr>
				  <tr>
				    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td><h1>Encabezado1</h1></td>
                        <td><a href="#">V&iacute;nculo</a></td>
                      </tr>
                      <tr>
                        <td><h2>Encabezado2</h2></td>
                        <td>&nbsp;</td>
                      </tr>
                      <tr>
                        <td><h3>Encabezado3</h3></td>
                        <td>&nbsp;</td>
                      </tr>
                      <tr>
                        <td><div id="sectionLinks"><ul>
                          <li><a href="#">Elemento1</a></li>
                          <li><a href="#">Elemento2</a></li>
                          <li><a href="#">Elemento3</a></li>
                          <li><a href="#">Elemento4</a></li>
                        </ul></div></td>
                        <td>&nbsp;</td>
                      </tr>
                    </table></td>
			      </tr>
              </table></td>
            </tr>
          </table>
          <!------------------------------------ TERMINA TAB CONTENTS ------------------------------------------->
          </div>
          <!------------------------------------ TERMINA TAB CONTENTS ------------------------------------------->
        </center>
      </td>
    </tr>
    <tr>
      <td><br><img src="img/footer.jpg" width="780" height="47"></td>
    </tr>
  </table>
</center>
</body>
</html>
