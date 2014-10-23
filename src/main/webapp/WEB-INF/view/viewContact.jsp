<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
<!--
	ul li {
		list-style-type: none;
		margin: 10px 0;
	}
	h3.firstname,
	h3.lastname {
		display: inline;
	}
	#addressList .editAddress,
	#addressList .deleteAddress {
		float: right;
		padding: 3px;
		margin-top: -10px;
	}
	span.info {
		color: gray;
	}
	span.address {
		font-weight: bold;
	}
	div.back {
		text-align: center;
		margin-top: 50px;
	}
-->
</style>

<div id="addressModal" class="modal fade"></div>

<h1>Display the contact with id : ${contact.id}</h1>
<ul class="list-group">
	<li class="list-group-item" ><h3 class="firstname">${contact.FName}</h3>
	<h3 class="lastname">${contact.LName}</h3></li>
	<li class="list-group-item" ><span class="info">Phone number :</span> ${contact.phoneNbr}</li>
	<li class="list-group-item" ><span class="info">Date of birth :</span> ${contact.dateOfBirth}</li>
	<li class="list-group-item" ><span class="info">Mail :</span> ${contact.email}</li>
	<li class="list-group-item" ><span class="info">Actif :</span> ${contact.actif}</li>
</ul>

<c:if test="${not empty addresses}">

	<ul id="addressList" class="list-group">
		<c:forEach var="address" items="${addresses}">
			<li id="#address-${address.id}" class="list-group-item" >
				<a class="deleteAddress" href="../address/${address.id}">
					<button class="btn btn-default">
						<span class="glyphicon glyphicon-trash"></span>
					</button>
				</a>
				<a class="editAddress" href="../address/${address.id}/edit" data-toggle="modal" data-target="#addressModal">
					<button class="btn btn-default">
						<span class="glyphicon glyphicon-home"></span>
					</button>
				</a><span class="address">${address.type} :</span>
				<span class="addressInfo">${address.nbr}, ${address.street} - ${address.city}, ${address.zipCode}</span></li>
		</c:forEach>
	</ul>
</c:if>
<div class="back">
	<a href="javascript:history.go(-1)"><button id="backHomePage" class="btn btn-default">Back To Home Page</button></a>
</div>
<script>
	$(".editAddress").each(function(id, item) {
		$(item).click(function(e) {
			e.preventDefault();

			$.ajax({
				url : $(item).attr("href"),
				type : "GET"

			}).done(function(html) {
				$("#addressModal").html(html);
				$("#addressForm").submit(editAddress);
			})
		});
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
		});
	});
</script>