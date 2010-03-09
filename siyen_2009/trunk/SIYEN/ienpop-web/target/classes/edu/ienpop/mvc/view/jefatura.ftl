<html>
<head>
<title>.: IENPOP - SIYEN :.</title>
<link rel="stylesheet" type="text/css" href="css/siyen_blue.css">
<link rel="stylesheet" type="text/css" href="css/image_tabs.css">
<link rel="stylesheet" type="text/css" href="css/aqua/theme.css">
<script src="js/prototype.js"></script>
<script src="js/control.tabs.2.0.0.RC2.js"></script>
<script src="js/control.modal.2.2.2.js"></script>
<script src="js/date.js"></script>
<script src="js/formexp.js"></script>
<script src="js/nuevoCurso.js"></script>
<script src="js/obtenerLlave.js"></script>
<script src="js/imprimir.js"></script>
<script src="js/generarOficios.js"></script>
<script src="js/validarCertificado.js"></script>
<script src="js/informes.js"></script>
<script src="js/busquedas.js"></script>
<script src="js/cambiosRaros.js"></script>
<script type='text/javascript' src='/siyen/dwr/interface/CursoXCertificarService.js'></script>
<script type='text/javascript' src='/siyen/dwr/interface/IenpopProducer.js'></script>
<script type='text/javascript' src='/siyen/dwr/interface/CursoService.js'></script>
<script type='text/javascript' src='/siyen/dwr/interface/AlumnoService.js'></script>
<script type='text/javascript' src='/siyen/dwr/engine.js'></script>
<script type='text/javascript' src='/siyen/dwr/util.js'></script>
<script language="javascript" src="js/calendar.js"></script>
<script language="javascript" src="js/calendar-es.js"></script>
<script language="javascript" src="js/calendar-setup.js"></script>
</head>
<body onLoad="configIni()">
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
      <td>
      <center>
          <table width="750" border="1" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC" bgcolor="#FFFFFF" class="workarea">
            <tr>
              <td align="center">
              	<!-----------------------------------------------ZONA EDITABLE------------------------------------------------------->
              	<table width="100%" border="0" cellspacing="0" cellpadding="5">
                  <tr>
                    <td>

						<ul class="tabbed_images" id="tabs_example_3">
							<li><a href="#image_1"><img src="img/modificaciones.jpg" border="0"></a></li>
							<li><a href="#image_2"><img src="img/busquedas.jpg" border="0"></a></li>
							<li><a href="#image_3"><img src="img/informes.jpg" border="0"></a></li>
							<li><a href="#image_4"><img src="img/cambios_raros.jpg" border="0"></a></li>
						</ul>
	
                    </td>
            	</tr>
            	<tr>
            		<td>
            				<div id="image_1">
            					<!-------------------------CONTENIDO 1------------------------------>
            					<#include "modificarCurso.ftl">
            					<!-------------------------CONTENIDO 1------------------------------>
							</div>
							<div id="image_2">
								<!-------------------------CONTENIDO 2------------------------------>
            					<#include "busquedas.ftl">
            					<!-------------------------CONTENIDO 2------------------------------>
							</div>
							<div id="image_3">
								<!-------------------------CONTENIDO 3------------------------------>
            					<#include "informes.ftl">
            					<!-------------------------CONTENIDO 3------------------------------>
							</div>
							<div id="image_4">
								<!-------------------------CONTENIDO 4------------------------------>
            					<#include "cambios_raros.ftl">
            					<!-------------------------CONTENIDO 4------------------------------>
							</div>
							<script>
								new Control.Tabs('tabs_example_3')
							</script>
            		</td>
            	</tr>
          		</table>
          		<!-----------------------------------------------ZONA EDITABLE------------------------------------------------------->
          		</td>
          	</tr>
          	</table>
        </center>
      </td>
    </tr>
    <tr>
      <td><br><img src="img/footer.gif" width="780" height="47"></td>
    </tr>
  </table>
</center>
</body>
</html>
