<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
<!--
	ul li {
		list-style-type: none;
	}
	h3.firstname,
	h3.lastname {
		display: inline;
	}
	li[value] {
		color: gray;
	}
-->
</style>
<h1>Display the contact with id : ${contact.id}</h1>
<ul>
	<li><h3 class="firstname">${contact.FName}</h3>
	<h3 class="lastname">${contact.LName}</h3></li>
	<li value="Phone number :"> ${contact.phoneNbr}</li>
	<li>Date of birth : ${contact.dateOfBirth}</li>
	<li>Mail : ${contact.email}</li>
	<li>Actif : ${contact.actif}</li>
</ul>

<c:if test="${not empty addresses}">

	<ul id="addressList" class="list-group">
		<c:forEach var="address" items="${addresses}">
			<li>${address.type}: ${address.nbr}${address.street} -
				${address.city}, ${address.zipCode}</li>
		</c:forEach>
	</ul>
</c:if>