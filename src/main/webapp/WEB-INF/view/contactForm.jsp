<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- TODO: Faire verif en JS ! -->
<h2>Student Information</h2>
<form:form id="contactForm" method="PUT" action="/contact/"
	commandName="contact">
	<table>
		<tr>
			<td><form:hidden id="id" path="id"></form:hidden></td>
		</tr>
		<tr>
			<td><form:label path="fName">First Name</form:label></td>
			<td><form:input id="fName" path="fName" /></td>
		</tr>
		<tr>
			<td><form:label path="lName">Last Name</form:label></td>
			<td><form:input id="lName" path="lName" /></td>
		</tr>
		<tr>
			<td><form:label path="email">Email</form:label></td>
			<td><form:input id="email" path="email" /></td>
		</tr>
		<tr>
			<td><form:label path="dateOfBirth">Date of birth</form:label></td>
			<td><form:input id="dateOfBirth" path="dateOfBirth" /></td>
		</tr>
		<tr>
			<td><form:label path="phoneNbr">Phone number</form:label></td>
			<td><form:input id="phoneNbr" path="phoneNbr" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Submit" /></td>
		</tr>
	</table>
</form:form>