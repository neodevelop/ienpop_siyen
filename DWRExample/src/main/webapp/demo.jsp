<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello DWR!!!</title>
<script type='text/javascript' src='/DWRExample/js/demo.js'></script>
<script type='text/javascript' src='/DWRExample/dwr/interface/Demo.js'></script>
<script type='text/javascript' src='/DWRExample/dwr/engine.js'></script>
<script type='text/javascript' src='/DWRExample/dwr/util.js'></script>
</head>
<body>
<p>Name: <input type="text" id="demoName" /> <input value="Send"
	type="button" onclick="update()" /> <br />
Reply: <span id="demoReply"></span></p>
<br>
<br>
<p>
  <input value="Include Page" type="button" onclick="forward()"/><br/>
  Included Page:
</p>
<div id="forward"></div>
</body>
</html>
