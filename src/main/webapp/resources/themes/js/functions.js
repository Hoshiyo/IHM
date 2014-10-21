function getContactForm() {
	$.ajax({
		url : "/contact/new",

	}).done(function(html) {
		$("#contactForm").remove();
		$("#container").append(html);
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