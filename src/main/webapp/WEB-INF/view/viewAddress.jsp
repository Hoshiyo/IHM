<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact addresses</title>
</head>
<body>

<h1>HELLO</h1>
<c:if test="${not empty adresses}">

<h2>HI !</h2>
	<ul>
		<c:forEach var="address" items="${adresses}">
				<li>Address : ${address.nbr} ${address.street}</li>
				<li>City : ${address.city}</li>
				<li>Zip code : ${address.zipCode}</li>
				<li>Address type : ${address.type}</li>
		</c:forEach>
	</ul>
	
</c:if>
	<h1>HELLO</h1>
	Address : ${address.nbr} ${address.street} City : ${address.city} Zip
	code : ${address.zipCode} Address type : ${address.type}
</body>
</html>
