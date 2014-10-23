<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search results</title>
</head>
<body>

<h1>By Name</h1>
<c:if test="${not empty nameList}">

	<ul>
		<c:forEach var="contact" items="${nameList}">
			<li>First name : ${contact.FName}</li>
			<li>Last name : ${contact.LName}</li>
			<li>Phone number : ${contact.phoneNbr}</li>
			<li>Date of birth : ${contact.dateOfBirth}</li>
			<li>Mail : ${contact.email}</li>
			<li>Actif : ${contact.actif}</li>
		</c:forEach>
	</ul>
	
</c:if>
<h1>By Email</h1>
<c:if test="${not empty emailList}">

	<ul>
		<c:forEach var="contact" items="${emailList}">
			<li>First name : ${contact.FName}</li>
			<li>Last name : ${contact.LName}</li>
			<li>Phone number : ${contact.phoneNbr}</li>
			<li>Date of birth : ${contact.dateOfBirth}</li>
			<li>Mail : ${contact.email}</li>
			<li>Actif : ${contact.actif}</li>
		</c:forEach>
	</ul>
	
</c:if>
<h1>By Phone Number</h1>
<c:if test="${not empty phoneList}">

	<ul>
		<c:forEach var="contact" items="${phoneList}">
			<li>First name : ${contact.FName}</li>
			<li>Last name : ${contact.LName}</li>
			<li>Phone number : ${contact.phoneNbr}</li>
			<li>Date of birth : ${contact.dateOfBirth}</li>
			<li>Mail : ${contact.email}</li>
			<li>Actif : ${contact.actif}</li>
		</c:forEach>
	</ul>
	
</c:if>

</body>
</html>