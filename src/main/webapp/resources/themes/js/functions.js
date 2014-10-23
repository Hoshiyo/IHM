var emailRegex = '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,4}$';
var dateRegex = /((0|1)\d\/(0|1)\d\/\d{4})/;
var nameRegex = '[a-zA-Z]{3,}';
var phoneRegex = /(\+\d{3}|0\d)( |-|\.)?\d{2}( |-|\.)?\d{2}( |-|\.)?\d{2}( |-|\.)?\d{2}/;
var nbrRegex = '^[0-9]+$';
var adrTypeRegex = '(0|1)'

function getContactForm() {
	$.ajax({
		url : "new",

	}).done(function(html) {
		$("#contactModal").html(html);
		$("#contactForm").submit(createContact);
	})
}

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

	return json;
}

function checkContactData(data) {

	if (!data.fname.match(nameRegex)) {
		alert("First name must contain at least 3 letters (A-Z)");
	} else if (!data.lname.match(nameRegex)) {
		alert("Last name must contain at least 3 letters (A-Z)");
	} else if (!data.dateOfBirth.match(dateRegex)) {
		console.log(data.dateOfBirth);
		alert("Date format incorrect (dd/mm/yy)");
	} else if (!data.phoneNbr.match(phoneRegex)) {
		alert("Invalid phone number");
	} else if (!data.email.match(emailRegex)) {
		alert("Enter a correct email (exemple@ihm.fr)");
	} else {
		return true;
	}

	return false;
}

function createContact(e) {

	e.preventDefault();

	var data = getContactFormData();
	console.log(data.fname);

	if (checkContactData(data) === false) {
		return;
	}

	$.ajax({
		headers : {
			'Accept' : 'application/json',
			'Content-Type' : 'application/json'
		},
		url : $("#contactForm").attr("action"),
		type : "POST",
		data : JSON.stringify(data)

	}).done(function(contact) {
		$("#closeModal").click();
		addContactLine(contact);
	});

	return false;
}

function editContact(e) {

	e.preventDefault();

	var data = getContactFormData();

	if (checkContactData(data) === false) {
		return;
	}

	$.ajax({
		headers : {
			'Accept' : 'application/json',
			'Content-Type' : 'application/json'
		},
		url : $("#contactForm").attr("action") + $("#id").val(),
		type : "PUT",
		data : JSON.stringify(data)

	}).done(function(contact) {
		$("#closeModal").click();
		updateContactLine(contact);
	});

	return false;
}

function createContactLine(contact) {
	var contactLine = "<li id='contact-"
			+ contact.id
			+ "' class='list-group-item new-contact-line' > \
	<a class='deleteContact' href='/contact/"
			+ contact.id
			+ "'> \
		<button class='btn btn-default'> \
			<span class='glyphicon glyphicon-trash'></span> \
		</button> \
	</a> \
	<a class='createAddress' href='/contact/"
			+ contact.id
			+ "/newAddress' data-toggle='modal' data-target='#addressModal'> \
		<button class='btn btn-default'><span class='glyphicon glyphicon-home'> \
			</span> \
		</button> \
	</a> \
	<a class='editContact' href='/contact/"
			+ contact.id
			+ "/edit' data-toggle='modal' data-target='#contactModal'> \
		<button class='btn btn-default'> \
			<span class='glyphicon glyphicon-user'></span> \
		</button> \
	</a> \
	<h3 class='firstname'>"
			+ contact.fname + "</h3> \
	<h3 class='lastname'>" + contact.lname
			+ "</h3> \
	<p class='phone'>" + contact.phoneNbr
			+ "</p> \
	<p class='email'>" + contact.email + "</p> \
</li>";

	return contactLine;
}

function addContactLine(contact) {
	$("#contactList").append(createContactLine(contact));

	$(".new-contact-line .deleteContact").click(function(e) {
		e.preventDefault();

		$.ajax({
			url : $(this).attr("href"),
			type : "DELETE"

		}).done(function(html) {
			$("#contact-" + contact.id).remove();
		})
	});

	$(".new-contact-line .editContact").click(function(e) {
		e.preventDefault();

		$.ajax({
			url : $(this).attr("href"),
			type : "GET"

		}).done(function(html) {
			$("#contactModal").html(html);
			$("#contactForm").submit(editContact);
		})
	});

	$(".new-contact-line .createAddress").click(function(e) {
		e.preventDefault();
		$.ajax({
			url : $(this).attr("href"),
			type : "GET"

		}).done(function(html) {
			$("#addressModal").html(html);
			$("#addressForm").submit(createAddress);
		})
	});

	$(".new-contact-line").removeClass("new-contact-line");
}

function updateContactLine(contact) {
	var id = "#contact-" + contact.id;
	$(id + " .firstname").html(contact.fname);
	$(id + " .lastname").html(contact.lname);
	$(id + " .email").html(contact.email);
	$(id + " .phone").html(contact.phoneNbr);
}

function initContactList() {
	$("#addContact").click(getContactForm);

	$(".viewContact").each(function(id, item) {

		$(item).click(function(e) {
			e.preventDefault();

			$.ajax({
				url : $(item).parent().attr("id").replace("contact-", ""),
				type : "GET"

			}).done(function(html) {
				$("body").html(html);
				$("#backHomePage").click(displayHomePage)
			})
		})
	});

	$(".editContact").each(function(id, item) {

		$(item).click(function(e) {
			e.preventDefault();

			$.ajax({
				url : $(item).attr("href"),
				type : "GET"

			}).done(function(html) {
				$("#contactModal").html(html);
				$("#contactForm").submit(editContact);
			})
		})
	});

	$(".deleteContact").each(function(id, item) {

		$(item).click(function(e) {
			e.preventDefault();

			$.ajax({
				url : $(item).attr("href"),
				type : "DELETE"

			}).done(function(html) {
				$(item).parent().remove();
			})
		})
	});

	$(".createAddress").each(function(id, item) {

		$(item).click(function(e) {
			e.preventDefault();
			$.ajax({
				url : $(item).attr("href"),

			}).done(function(html) {
				$("#addressModal").html(html);
				$("#addressForm").submit(createAddress);
			})
		})
	});
}

function displayHomePage(e) {
	e.preventDefault();

	$.ajax({
		url : "contact/",
		type : "GET"

	}).done(function(html) {
		$("body").html(html);
	})
}

/*
 * TODO
 * 
 * A CORRIGER PAR RAPPORT AU DESSUS
 * 
 */

function getAddressFormData() {
	var id = $("#id").val();
	var contactId = $("#contactId").val();
	var nbr = $("#nbr").val();
	var street = $("#street").val();
	var city = $("#city").val();
	var zipCode = $("#zipCode").val();
	var type = $("#type").val();
	var json = {
		"id" : id,
		"contactId" : contactId,
		"nbr" : nbr,
		"street" : street,
		"city" : city,
		"zipCode" : zipCode,
		"type" : type
	};

	return json;
}

function checkAddressData(data) {

	if (!data.nbr.match(nbrRegex)) {
		alert("Number must contain 1 number (0-9)");
	} else if (!data.street.match(nameRegex)) {
		alert("Street must contain at least 3 letters (A-Z)");
	} else if (!data.city.match(nameRegex)) {
		alert("City must contain at least 3 letters (A-Z)");
	} else if (!data.zipCode.match(nbrRegex)) {
		alert("ZipCode must contain at least 3 number (0-9)");
	} else if (!data.type.match(adrTypeRegex)) {
		alert("Select an address type");
	} else {
		return true;
	}

	return false;
}

function createAddress(e) {

	e.preventDefault();

	var data = getAddressFormData();
	if (checkAddressData(data) === false) {
		return;
	}

	$.ajax({
		headers : {
			'Accept' : 'application/json',
			'Content-Type' : 'application/json'
		},
		url : $("#addressForm").attr("action"),
		type : "POST",
		data : JSON.stringify(data)

	}).done(function(address) {
		$("#closeModal").click();
	});
}

function editAddress(e) {

	e.preventDefault();

	var data = getAddressFormData();

	$.ajax({
		headers : {
			'Accept' : 'application/json',
			'Content-Type' : 'application/json'
		},
		url : $("#addressForm").attr("action") + '/' + $("#nbr").val(),
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
			+ " <a class='editAddress' href='/address/" + address.contact.id
			+ "/edit'>edit</a> <a class='deleteAddress' href=/address/"
			+ address.contact.id + "'>delete</a>";
	item.html(html);
}
