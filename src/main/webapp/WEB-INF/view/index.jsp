<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="<c:url value="/resources/themes/bootstrap/css/bootstrap.min.css" />"
			rel="stylesheet">
		<link href="<c:url value="/resources/themes/bootstrap/css/bootstrap-theme.min.css" />"
			rel="stylesheet">
		<style type="text/css">
			body {
				margin: 20px;
			}
			.list-group .editContact,
			.list-group .editAddress,
			.list-group .deleteContact {
				float: right;
				padding: 3px;
			}
			p {
				line-height: 1em;
				margin: 10px 0 !important;
			}
			h3.firstname,
			h3.lastname {
				display: inline;
			}
			
		</style>
		<title>Home page</title>
	</head>
<body>
	<h2>Hello World!</h2>

	<div id="myModal" class="modal fade"></div>

	<nav class="navbar navbar-default" role="navigation">
		<button id="addContact" class="btn btn-default navbar-btn"
			data-toggle="modal" data-target="#myModal">
			<span class="glyphicon glyphicon-plus"></span>
		</button>

		<form class="navbar-form navbar-left" role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Search">
			</div>
			<button type="submit" class="btn btn-default">
				<span class="glyphicon glyphicon-search"></span>
			</button>
		</form>
	</nav>

	<div id="container">
		<c:if test="${not empty lists}">

			<ul class="list-group">
				<c:forEach var="listValue" items="${lists}">
					<li id="contact-${listValue.id}" class="list-group-item" >
						<a class="deleteContact" href="/contact/${listValue.id}"><button
						class="btn btn-default"><span class="glyphicon glyphicon-trash"></span></button></a>
						<a class="editAddress" href="/contact/${listValue.id}"><button
						class="btn btn-default"><span class="glyphicon glyphicon-home"></span></button></a><a class="editContact" href="/contact/${listValue.id}/edit"
						data-toggle="modal" data-target="#myModal"><button
						class="btn btn-default"><span class="glyphicon glyphicon-user"></span></button></a>
						<h3 class="firstname">${listValue.FName}</h3>
						<h3 class="lastname">${listValue.LName}</h3>
						<p class="address">Delivery address : </p>
						<p class="address">Home address : </p>
						<p class="phone">01 54 87 51 00</p>
						<p class="email">montpellier@yahoo.fr</p>
					</li>
				</c:forEach>
			</ul>			
		</c:if>
	</div>

	<!-- JavaScript Includes -->
		<script type="text/javascript"
			src="<c:url value="/resources/themes/jquery/js/jquery.min.js" />"></script>
		<script type="text/javascript"
			src="<c:url value="/resources/themes/bootstrap/js/bootstrap.min.js" />"></script>
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
						$("#myModal").html(html);
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
