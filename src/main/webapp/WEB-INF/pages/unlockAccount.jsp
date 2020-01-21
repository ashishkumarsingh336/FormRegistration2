<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="black">

	<form:form action="validate" method="POST"
		modelAttribute="unlockAccount" onsubmit="return checkPassword()">

		<h1 style="color: white; text-align: center">Unlock Account Page</h1>

		<h1 style="color: green; text-align: center">${MSG}</h1>
		<br>
		<h1 style="color: red; text-align: center">${MSG1}</h1>

		<table align="center" bgColor="violet" border="12"
			style="border-bottom-color: blue">
			<tr>
				<td><b><font size="4">Email Id:</font></b></td>
				<td width="150"><form:input path="email" /></td>
				<!-- disabled="true" -->
			</tr>
			<tr>
				<td><b><font size="4">Temprory Password :</font></b></td>
				<td><form:input path="tempPwd" /></td>
			</tr>
			<tr>
				<td><b><font size="4">New Password :</font></b></td>
				<td width="150"><form:input path="newPwd" /></td>
			</tr>
			<tr>
				<td><b><font size="4">Confirm Password :</font></b></td>
				<td width="150"><form:input path="confirmPwd" /> <br> </td>
			</tr>
			<tr>
				<td colspan="2" align="center" bgcolor="lightgreen"><b><input
						type="submit" value="Submit" color="blue" /></b></td>
			</tr>
		</table>
		<a href="login"><font size="6">Login</font></a>

	</form:form>

	<script type="text/javascript">
		function checkPassword() {
			var npwd = newPwd.value;
			var cpwd = confirmPwd.value;
			
			if (npwd != cpwd) {
				alert("Password didnot matched");
				return false;
			}
		}
	</script>

</body>
</html>