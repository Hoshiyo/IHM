<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

	<link href="<c:url value="/resources/themes/bootstrap/css/bootstrap.min.css" />"
		rel="stylesheet">
	<link href="<c:url value="/resources/themes/jqueryui/jquery-ui.min.css" />"
		rel="stylesheet">
	<link href="<c:url value="/resources/themes/bootstrap/css/bootstrap-theme.min.css" />"
		rel="stylesheet">
	<style type="text/css">
		body {
			margin: 20px;
		}
		.list-group .editContact,
		.list-group .createAddress,
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
		div.viewContact {
			cursor: pointer;
		}
	</style>
		
	<!-- JavaScript Includes -->
	<script type="text/javascript"
		src="<c:url value="../resources/themes/jquery/jquery.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="../resources/themes/jqueryui/jquery-ui.min.js" />"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/themes/bootstrap/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/resources/themes/js/functions.js" />"></script>
		
	<title>Home page</title>
</head>

<body>
	<h2>iWho's Who</h2>

	<div id="contactModal" class="modal fade"></div>
	<div id="addressModal" class="modal fade"></div>

	<nav class="navbar navbar-default" role="navigation">
		<button id="addContact" class="btn btn-default navbar-btn"
			data-toggle="modal" data-target="#contactModal">
			<span class="glyphicon glyphicon-plus"></span>
		</button>

		<form class="navbar-form navbar-left" role="search" action="search" method="GET">
			<div class="form-group">
				<input id="searchField" type="text" name="search" class="form-control-search" placeholder="Search"/>
			</div>
			<button id="searchContact" class="btn btn-default">
				<img src="<c:url value="/searchByContact.png" />" alt="search contact" height="18" width="18">
			</button>
			<button id="searchAddress" type="submit" class="btn btn-default">
				<img src="<c:url value="/searchByAddress.png" />" alt="search address" height="18" width="18">
			</button>
		</form>
	</nav>

	<div id="container">
		<c:if test="${not empty lists}">

			<ul id="contactList" class="list-group">
				<c:forEach var="listValue" items="${lists}">
					<li id="contact-${listValue.id}" class="list-group-item" >
						<a class="deleteContact" href="${listValue.id}">
							<button class="btn btn-default">
								<span class="glyphicon glyphicon-trash"></span>
							</button>
						</a>
						<a class="createAddress" href="${listValue.id}/newAddress" data-toggle="modal" data-target="#addressModal">
							<button class="btn btn-default">
								<span class="glyphicon glyphicon-home"></span>
							</button>
						</a>
						<a class="editContact" href="${listValue.id}/edit" data-toggle="modal" data-target="#contactModal">
							<button class="btn btn-default">
								<span class="glyphicon glyphicon-user"></span>
							</button>
						</a>
						<div class="viewContact">
							<h3 class="firstname">${listValue.FName}</h3>
							<h3 class="lastname">${listValue.LName}</h3>
							<p class="phone">${listValue.phoneNbr}</p>
							<p class="email">${listValue.email}</p>
						</div>
					</li>
				</c:forEach>
			</ul>
		</c:if>
	</div>

	<script>
		$(document).ready(function() {
			initContactList();
			$("#searchContact").click(function(e) {
				
				e.preventDefault();
				
				$.ajax({
					url : "search?search=" + $("#searchField").val(),
					type : "GET"

				}).done(function(html) {
					$("body").html(html);
					$("#backHomePage").click(displayHomePage);
				})
			});
			$("#searchAddress").click(function(e) {
				
				e.preventDefault();
				
				$.ajax({
					url : "../address/search?search=" + $("#searchField").val(),
					type : "GET"

				}).done(function(html) {
					$("body").html(html);
					$("#backHomePage").click(displayHomePage);
				})
			});
		});
	</script>

</body>
</html>
