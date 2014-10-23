var emailRegex = '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,4}$';
var dateRegex = /((0|1)\d\/(0|1)\d\/\d{4})/;
var nameRegex = '[a-zA-Z]{3,}';
var phoneRegex = /(\+\d{3}|0\d)( |-|\.)?\d{2}( |-|\.)?\d{2}( |-|\.)?\d{2}( |-|\.)?\d{2}/;

function getContactForm() {
	$.ajax({
		url : "/contact/new",

	}).done(function(html) {
		$("#contactModal").html(html);
		$("#contactForm").submit(createContact);
	})
}

function getContactDetails() {
	//TODO 
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
	var contactLine = 
"<li id='contact-" + contact.id + "' class='list-group-item new-contact-line' > \
	<a class='deleteContact' href='/contact/" + contact.id + "'> \
		<button class='btn btn-default'> \
			<span class='glyphicon glyphicon-trash'></span> \
		</button> \
	</a> \
	<a class='editAddress' href='/contact/" + contact.id + "'> \
		<button class='btn btn-default'><span class='glyphicon glyphicon-home'> \
			</span> \
		</button> \
	</a> \
	<a class='editContact' href='/contact/" + contact.id + "/edit' data-toggle='modal' data-target='#contactModal'> \
		<button class='btn btn-default'> \
			<span class='glyphicon glyphicon-user'></span> \
		</button> \
	</a> \
	<h3 class='firstname'>" + contact.fname + "</h3> \
	<h3 class='lastname'>" + contact.lname + "</h3> \
	<p class='phone'>" + contact.phoneNbr + "</p> \
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
	
	$(".new-contact-line").removeClass("new-contact-line");
}

function updateContactLine(contact) {
	var id = "#contact-" + contact.id;
	$(id + " .firstname").html(contact.fname);
	$(id + " .lastname").html(contact.lname);
	$(id + " .email").html(contact.email);
	$(id + " .phone").html(contact.phoneNbr);
}

/*
 * TODO
 * 
 * A CORRIGER PAR RAPPORT AU DESSUS
 * 
 */

function getAddressFormData() {
	var id = $("#id").val();
	var nbr = $("#nbr").val();
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
		url : $("#addressForm").attr("action"),
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