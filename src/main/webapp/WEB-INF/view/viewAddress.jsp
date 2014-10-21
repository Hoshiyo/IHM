<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
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
		<c:forEach var="listValue" items="${adresses}">
				<li>Address : ${listValue.nbr} ${listValue.street}
				City : ${listValue.city}
				Zip code : ${listValue.zipCode}
				Address type : ${listValue.type}</li>
		</c:forEach>
	</ul>
	
</c:if>
</body>
</html>