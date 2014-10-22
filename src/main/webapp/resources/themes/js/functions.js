function getContactForm() {
	$.ajax({
		url : "/contact/new",

	}).done(function(html) {
		$("#myModal").html(html);
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
		url : $("#contactForm").attr("action"),
		type : "POST",
		data : data,

	}).done(function(contact) {
		$("#closeModal").click();
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
		url : $("#contactForm").attr("action") + $("#id").val(),
		type : "PUT",
		data : data

	}).done(function(contact) {
		$("#closeModal").click();
		updateContactLine(contact);
	});

	return false;
}

function addContactLine(contact) {
	$("#container").append("<li>" + contact.fname + "</li>");
}

function updateContactLine(contact) {
	var item = $("#contact-" + contact.id);
	var html = contact.fname + " <a class='editContact' href='/contact/"
			+ contact.id
			+ "/edit'>edit</a> <a class='deleteContact' href=/contact/"
			+ contact.id + "'>delete</a>";
	item.html(html);
}

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
			+ " <a class='editAddress' href='/address/" + address.contact.id + "/edit'>edit</a> <a class='deleteAddress' href=/address/" + address.contact.id + "'>delete</a>";
	item.html(html);
}