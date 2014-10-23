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
	span.info {
		color: gray;
	}
	span.address {
		font-weight: bold;
	}
-->
</style>
<h1>Display the contact with id : ${contact.id}</h1>
<ul>
	<li><h3 class="firstname">${contact.FName}</h3>
	<h3 class="lastname">${contact.LName}</h3></li>
	<li><span class="info">Phone number :</span> ${contact.phoneNbr}</li>
	<li><span class="info">Date of birth :</span> ${contact.dateOfBirth}</li>
	<li><span class="info">Mail :</span> ${contact.email}</li>
	<li><span class="info">Actif :</span> ${contact.actif}</li>
</ul>

<c:if test="${not empty addresses}">

	<ul id="addressList" class="list-group">
		<c:forEach var="address" items="${addresses}">
			<li><span class="address">${address.type} :</span>
				${address.nbr}${address.street} - ${address.city}, ${address.zipCode}</li>
		</c:forEach>
	</ul>
</c:if>

<a href="javascript:history.go(-1)"><button id="backHomePage" class="btn btn-default">Back To Home Page</button></a>
<script type="text/javascript">
<!--

//-->
</script>