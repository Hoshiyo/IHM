<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ESIEA IHM Project</title>
</head>
<body>
	<h1>Display the contact with id : ${contact.id}</h1>
	<ul>
		<li>First name : ${contact.FName}</li>
		<li>Last name : ${contact.LName}</li>
		<li>Phone number : ${contact.phoneNbr}</li>
		<li>Date of birth : ${contact.dateOfBirth}</li>
		<li>Mail : ${contact.email}</li>
		<li>Actif : ${contact.actif}</li>
	</ul>
</body>
</html>