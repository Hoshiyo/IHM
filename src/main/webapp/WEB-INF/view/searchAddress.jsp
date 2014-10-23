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

<h1>By Street</h1>
<c:if test="${not empty streetList}">

	<ul>
		<c:forEach var="address" items="${streetList}">
				<li>Address : ${address.nbr} ${address.street}</li>
				<li>City : ${address.city}</li>
				<li>Zip code : ${address.zipCode}</li>
				<li>Address type : ${address.type}</li>
		</c:forEach>
	</ul>
	
</c:if>
<h1>By City</h1>
<c:if test="${not empty cityList}">

	<ul>
		<c:forEach var="address" items="${cityList}">
			<li>Address : ${address.nbr} ${address.street}</li>
			<li>City : ${address.city}</li>
			<li>Zip code : ${address.zipCode}</li>
			<li>Address type : ${address.type}</li>
		</c:forEach>
	</ul>
	
</c:if>
<h1>By Phone Number</h1>
<c:if test="${not empty contactList}">

	<ul>
		<c:forEach var="address" items="${contactList}">
			<li>Address : ${address.nbr} ${address.street}</li>
			<li>City : ${address.city}</li>
			<li>Zip code : ${address.zipCode}</li>
			<li>Address type : ${address.type}</li>
		</c:forEach>
	</ul>
	
</c:if>

</body>
</html>