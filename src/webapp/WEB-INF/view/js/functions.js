$(document).ready(function() {
	$("#addContact").click(function() {
		$.ajax({
			url: "contact/addContactForm",
			
		})
		.done(function(html) {
			$("#container").append(html);
		})
	});
});