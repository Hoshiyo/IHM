<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- TODO: Faire verif en JS ! -->
<h2>Address Information</h2>
<form:form id="addressForm" method="PUT" action="/address/"
	commandName="address">
	<table>
		<tr>
			<td><form:hidden id="contact" path="contact"></form:hidden></td>
		</tr>
		<tr>
			<td><form:label path="nbr">Number</form:label></td>
			<td><form:input id="nbr" path="nbr" /></td>
		</tr>
		<tr>
			<td><form:label path="street">Street</form:label></td>
			<td><form:input id="street" path="street" /></td>
		</tr>
		<tr>
			<td><form:label path="city">City</form:label></td>
			<td><form:input id="city" path="city" /></td>
		</tr>
		<tr>
			<td><form:label path="zipCode">Zip code</form:label></td>
			<td><form:input id="zipCode" path="zipCode" /></td>
		</tr>
		<tr>
			<td><form:label path="type">Address type</form:label></td>
			<td><form:input id="type" path="type" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Submit" /></td>
		</tr>
	</table>
</form:form>
<script>
	var form = $("#addressForm");

	function getContactFormData() {
		var id = $("#nbr").val();
		var street = $("#street").val();
		var city = $("#city").val();
		var zipCode = $("#zipCode").val();
		var type = $("#type").val();
		var json = {
			"nbr" : nbr,
			"street" : street,
			"city" : city,
			"zipCode" : zipCode,
			"type" : type
		};

		return JSON.stringify(json);
	}

	function createAddress(e) {

		e.preventDefault();

		var data = getAddressFormData();

		$.ajax({
			headers : {
				'Accept' : 'application/json',
				'Content-Type' : 'application/json'
			},
			url : form.attr("action"),
			type : "POST",
			data : data,

		}).done(function(address) {
			addAddressLine(address);
		});

		return false;
	}

	function editAddress(e) {

		e.preventDefault();

		var data = getAddressFormData();

		$.ajax({
			headers : {
				'Accept' : 'application/json',
				'Content-Type' : 'application/json'
			},
			url : form.attr("action") + '/' + $("#nbr").val(),
			type : "PUT",
			data : data

		}).done(function(address) {
			updateAddressLine(address);
		});

		return false;
	}

	function addAddressLine(address) {
		$("#container").append("<li>" + address.contact.FName + "</li>");
	}

	function updateAddressLine(address) {
		var item = $("#address-" + address.contact.FName);
		var html = address.contact.fname
				+ " <a class='editAddress' href='/address/" + address.contact.id + "/edit'>edit</a> <a class='deleteAddress' href=/address/" + address.contact.id + "'>delete</a>";
		item.html(html);
	}
</script>