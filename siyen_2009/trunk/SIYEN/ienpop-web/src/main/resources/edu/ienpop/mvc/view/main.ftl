<#import "spring.ftl" as spring/>
<html>
<head>
<title>.: IENPOP - SIYEN :.</title>
<script type='text/javascript' src='/siyen/dwr/interface/UsuarioService.js'></script>
<script type='text/javascript' src='/siyen/dwr/engine.js'></script>
<script type='text/javascript' src='/siyen/dwr/util.js'></script>
<script type='text/javascript'>
	function errHandler(msg) {
		dwr.util.setValue("myMessage",msg);
	}
	
	function validarUsuario(){
		dwr.engine.setErrorHandler(errHandler);
		var username = dwr.util.getValue("usuario");
		var password = dwr.util.getValue("password");
		UsuarioService.isValidUsuario(username,password,
		function(usuarioValido){
			//dwr.util.setValue("myMessage",usuarioValido);
			if(usuarioValido==true){
				login.action="sistema.ienpop";
				login.submit();
			}
		});
	}
</script>
<link rel="stylesheet" type="text/css" href="css/siyen_blue.css">
</head>
<body>
<center>
<table width="780" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><img src="img/header.jpg" width="780" height="91"></td>
  </tr>
  <tr>
    <td height="30">&nbsp;</td>
  </tr>
  <tr>
    <td>
	<br><br><br>
	<table width="100%" border="0">
      <tr>
        <td width="218">&nbsp;</td>
        <td width="337" height="169" background="img/login_blue.gif">
		<form name="login" method="post">
		<table width="100%" border="0">
          <tr>
            <td width="10%">&nbsp;</td>
            <td width="80%" align="center"><h3>.:Ingresar al sistema:.</h3></td>
            <td width="10%">&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td><table width="100%" border="0">
              <tr>
                <td class="myLabel">Usuario:</td>
                <td><label>
                  <input type="text" id="usuario" name="usuario" onkeydown="DWRUtil.onReturn(event, validarUsuario)">
                </label></td>
              </tr>
              <tr>
                <td class="myLabel">Contrase&ntilde;a:</td>
                <td><label>
                  <input type="password" id="password" onkeydown="DWRUtil.onReturn(event, validarUsuario)">
                </label></td>
              </tr>
            </table></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td align="center"><input type="button" class="inputButton" value="Enviar" onclick="validarUsuario()"></td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td class="errorMessage"><span id="myMessage">${error?default('')}</span></td>
            <td>&nbsp;</td>
          </tr>
        </table>
		</form>
		</td>
        <td width="218">&nbsp;</td>
      </tr>
    </table>
	<br><br><br><br>
	</td>
  </tr>
  <tr>
    <td><img src="img/footer.jpg" width="780" height="47"></td>
  </tr>
</table>
</center>
</body>
</html>
