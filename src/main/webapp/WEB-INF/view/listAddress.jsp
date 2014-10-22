<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${not empty lists}">

	<ul>
		<c:forEach var="listValue" items="${lists}">
			<li>${listValue.contact.FName}${listValue.contact.LName}:
				${listValue.nbr} ${listValue.street} ${listValue.city}
				${listValue.zipCode} ${listValue.type} <a class="editAddress"
				href="/address/${listValue.id}/edit">edit</a> <a class="deleteAddress"
				href="/address/${listValue.id}">delete</a>
			</li>
		</c:forEach>
	</ul>
</c:if>

<button id="addAddress" class="btn btn-default navbar-btn"
	data-toggle="modal" data-target="#myModal">
	<span class="glyphicon glyphicon-plus"></span>
</button>

<div id="myModal"></div>

<!-- JavaScript Includes -->
<script type="text/javascript"
	src="../resources/themes/jquery/js/jquery.min.js"></script>
<script type="text/javascript"
	src="../resources/themes/bootstrap/js/bootstrap.min.js"></script>
<script src="<c:url value="/resources/themes/js/functions.js" />"></script>

<script>
	$(document).ready(function() {

		$("#addAddress").click(getContactForm);

		$(".editAddress").each(function(id, item) {

			$(item).click(function(e) {
				e.preventDefault();

				$.ajax({
					url : $(item).attr("href"),
					type : "GET"

				}).done(function(html) {
					$("#myModal").html(html);
					$("#addressForm").submit(editContact);
				})
			})
		});

		$(".deleteAddress").each(function(id, item) {

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