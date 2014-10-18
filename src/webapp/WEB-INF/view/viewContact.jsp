<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<h1>Display the contact with id : ${contact.id}</h1>
<ul>
	<li>First name : ${contact.FName}</li>
	<li>Last name : ${contact.LName}</li>
	<li>Phone number : ${contact.phoneNbr}</li>
	<li>Date of birth : ${contact.dateOfBirth}</li>
	<li>Mail : ${contact.email}</li>
	<li>Actif : ${contact.actif}</li>
</ul>