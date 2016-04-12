<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/js/materialize.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulario</title>
</head>
<body>

	<div class="container">	
		<h2>Alta</h2>
		<s:form action="save">
			<s:textfield label="Nombre" name="name"></s:textfield>
			<s:textfield label="Edad" name="age"></s:textfield>
			<s:radio label="Genero" name="gender"
				list="#{'Femenino':'Femenino','Masculino':'Masculino'}" />
			<s:submit></s:submit>
			<s:actionerror />
		</s:form>



		<table>
			<tr>
				<th>ID</th>
				<th>NOMBRE</th>
				<th>EDAD</th>
				<th>GENERO</th>
			</tr>
			<s:iterator value="personas" var="p">
				<tr>
					<td><s:property value="#p.id" /></td>
					<td><s:property value="#p.name" /></td>
					<td><s:property value="#p.age" /></td>
					<td><s:property value="#p.gender" /></td>
				</tr>
			</s:iterator>
		</table>

		<h2>Baja</h2>
		<s:form action="delete">
			<s:textfield label="Id" name="id"></s:textfield>
			<s:actionerror />
			<s:submit></s:submit>
		</s:form>

		<h2>Modificacion</h2>
		<s:form action="edit">
			<s:textfield label="Id" name="id"></s:textfield>
			<s:textfield label="Nombre" name="name"></s:textfield>
			<s:textfield label="Edad" name="age"></s:textfield>
			<s:radio label="Genero" name="gender"
				list="#{'Femenino':'Femenino','Masculino':'Masculino'}" />
			<s:actionerror />
			<s:submit></s:submit>
		</s:form>

	</div>


</body>
</html>