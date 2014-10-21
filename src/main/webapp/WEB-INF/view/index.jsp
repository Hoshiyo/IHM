<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h2>Hello World!</h2>

	<div id="container">
		<c:if test="${not empty lists}">

			<ul>
				<c:forEach var="listValue" items="${lists}">
					<li id="contact-${listValue.id}">${listValue.FName} <a
						class="editContact" href="/contact/${listValue.id}/edit">edit</a>
						<a class="deleteContact" href="/contact/${listValue.id}">delete</a>
					</li>
				</c:forEach>
			</ul>

		</c:if>
	</div>

	<button id="addContact">New contact</button>

	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="<c:url value="/resources/themes/js/functions.js" />"></script>
	<script>
		$(document).ready(function() {

			$("#addContact").click(getContactForm);

			$(".editContact").each(function(id, item) {

				$(item).click(function(e) {
					e.preventDefault();

					$.ajax({
						url : $(item).attr("href"),
						type : "GET"

					}).done(function(html) {
						$("#contactForm").remove();
						$("#container").append(html);
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
		});
	</script>

</body>
</html>
