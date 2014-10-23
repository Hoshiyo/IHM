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
	}
	span.info {
		color: gray;
	}
	span.address {
		font-weight: bold;
	}
-->
</style>
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
			<li class="list-group-item" >
				<a class="deleteAddress" href="${address.id}">
					<button class="btn btn-default">
						<span class="glyphicon glyphicon-trash"></span>
					</button>
				</a>
				<a class="editAddress" href="${address.id}/edit" data-toggle="modal" data-target="#addressModal">
					<button class="btn btn-default">
						<span class="glyphicon glyphicon-home"></span>
					</button>
				</a><span class="address">${address.type} :</span>
				${address.nbr}${address.street} - ${address.city}, ${address.zipCode}</li>
		</c:forEach>
	</ul>
</c:if>

<a href="javascript:history.go(-1)"><button id="backHomePage" class="btn btn-default">Back To Home Page</button></a>
