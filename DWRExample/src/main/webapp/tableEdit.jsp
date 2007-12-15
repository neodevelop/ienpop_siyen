<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Table Editing</title>
<script type='text/javascript' src='/DWRExample/dwr/interface/People.js'></script>
<script type='text/javascript' src='/DWRExample/dwr/engine.js'></script>
<script type='text/javascript' src='/DWRExample/dwr/util.js'></script>
<script type='text/javascript' src='/DWRExample/js/myDwr.js'></script>
</head>
<body onLoad="init()">
<h3>All People</h3>
<table border="1" class="rowed grey">
	<thead>
		<tr>
			<th>Person</th>
			<th>Salary</th>
			<th>Actions</th>
		</tr>
	</thead>
	<tbody id="peoplebody">
		<tr id="pattern" style="display:none;">
			<td><span id="tableName">Name</span><br />
			<small> <span id="tableAddress">Address</span></small></td>
			<td>$<span id="tableSalary">Salary</span></td>
			<td><input id="edit" type="button" value="Edit"
				onclick="editClicked(this.id)" /> <input id="delete" type="button"
				value="Delete" onclick="deleteClicked(this.id)" /></td>
		</tr>
	</tbody>
</table>

<h3>Edit Person</h3>
<table class="plain">
	<tr>
		<td>Name:</td>
		<td><input id="name" type="text" size="30" /></td>
	</tr>
	<tr>
		<td>Salary:</td>
		<td>$<input id="salary" type="text" size="20" /></td>
	</tr>
	<tr>
		<td>Address:</td>
		<td><input type="text" id="address" size="40" /></td>
	</tr>
	<tr>
		<td colspan="2" align="right"><small>(ID=<span id="id">-1</span>)</small>
		<input type="button" value="Save" onclick="writePerson()" /> <input
			type="button" value="Clear" onclick="clearPerson()" /></td>
	</tr>
</table>
</body>
</html>
