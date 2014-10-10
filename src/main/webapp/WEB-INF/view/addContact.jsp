<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC Form Handling</title>
</head>
<body>

	<h2>Student Information</h2>
	<form:form method="POST" action="addContact">
		<table>
			<tr>
				<td><form:label path="lName">Last Name</form:label></td>
				<td><form:input path="lName" /></td>
			</tr>
			<tr>
				<td><form:label path="fName">First Name</form:label></td>
				<td><form:input path="fName" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="dateOfBirth">Date of birth</form:label></td>
				<td><form:input path="dateOfBirth" /></td>
			</tr>
			<tr>
				<td><form:label path="phoneNbr">Phone number</form:label></td>
				<td><form:input path="phoneNbr" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>