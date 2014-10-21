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
<script>
	var form = $("#contactForm");

	function getContactFormData() {
		var id = $("#id").val();
		var fName = $("#fName").val();
		var lName = $("#lName").val();
		var email = $("#email").val();
		var dateOfBirth = $("#dateOfBirth").val();
		var phoneNbr = $("#phoneNbr").val();
		var json = {
			"id" : id,
			"fname" : fName,
			"lname" : lName,
			"email" : email,
			"dateOfBirth" : dateOfBirth,
			"phoneNbr" : phoneNbr
		};

		return JSON.stringify(json);
	}

	function createContact(e) {

		e.preventDefault();

		var data = getContactFormData();

		$.ajax({
			headers : {
				'Accept' : 'application/json',
				'Content-Type' : 'application/json'
			},
			url : form.attr("action"),
			type : "POST",
			data : data,

		}).done(function(contact) {
			addContactLine(contact);
		});

		return false;
	}

	function editContact(e) {

		e.preventDefault();

		var data = getContactFormData();

		$.ajax({
			headers : {
				'Accept' : 'application/json',
				'Content-Type' : 'application/json'
			},
			url : form.attr("action") + '/' + $("#id").val(),
			type : "PUT",
			data : data

		}).done(function(contact) {
			updateContactLine(contact);
		});

		return false;
	}

	function addContactLine(contact) {
		$("#container").append("<li>" + contact.fname + "</li>");
	}

	function updateContactLine(contact) {
		var item = $("#contact-" + contact.id);
		var html = contact.fname
				+ " <a class='editContact' href='/contact/" + contact.id + "/edit'>edit</a> <a class='deleteContact' href=/contact/" + contact.id + "'>delete</a>";
		item.html(html);
	}
</script>