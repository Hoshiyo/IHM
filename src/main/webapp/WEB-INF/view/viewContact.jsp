<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>Display the contact with id : ${contact.id}</h1>
<ul>
	<li>First name : ${contact.FName}</li>
	<li>Last name : ${contact.LName}</li>
	<li>Phone number : ${contact.phoneNbr}</li>
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