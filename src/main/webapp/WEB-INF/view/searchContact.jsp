<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<link href="<c:url value="/resources/themes/bootstrap/css/bootstrap.min.css" />"
			rel="stylesheet">
		<link href="<c:url value="/resources/themes/jqueryui/jquery-ui.min.css" />"
			rel="stylesheet">
		<link href="<c:url value="/resources/themes/bootstrap/css/bootstrap-theme.min.css" />"
			rel="stylesheet">
		<style type="text/css">
			body {
				margin: 20px;
			}
			h3 {
				border-bottom: 1px solid black;
			}
			ul li {
				list-style-type : none;
			}
			ul li.last {
				border-bottom: 1px solid gray;
				margin-bottom: 10px;
				padding-bottom: 10px;
			}
			div.back {
				text-align: center;
				margin-top: 50px;
			}
		</style>
		<title>Search Results Contact</title>
	</head>
	<body>
		<h1>Search Contact</h1>
		
		<c:choose>
			<c:when test="${not empty nameList}">
				<h3>By Name</h3>
				<ul>
					<c:forEach var="contact" items="${nameList}">
						<li>First name : ${contact.FName}</li>
						<li>Last name : ${contact.LName}</li>
						<li>Phone number : ${contact.phoneNbr}</li>
						<li>Date of birth : ${contact.dateOfBirth}</li>
						<li>Mail : ${contact.email}</li>
						<li class="last">Actif : ${contact.actif}</li>
					</c:forEach>
				</ul>
				
			</c:when>			
			
			<c:when test="${not empty emailList}">
				<h3>By Email</h3>
				<ul>
					<c:forEach var="contact" items="${emailList}">
						<li>First name : ${contact.FName}</li>
						<li>Last name : ${contact.LName}</li>
						<li>Phone number : ${contact.phoneNbr}</li>
						<li>Date of birth : ${contact.dateOfBirth}</li>
						<li>Mail : ${contact.email}</li>
						<li class="last">Actif : ${contact.actif}</li>
					</c:forEach>
				</ul>
				
			</c:when>
			
			<c:when test="${not empty phoneList}">
				<h3>By Phone Number</h3>
				<ul>
					<c:forEach var="contact" items="${phoneList}">
						<li>First name : ${contact.FName}</li>
						<li>Last name : ${contact.LName}</li>
						<li>Phone number : ${contact.phoneNbr}</li>
						<li>Date of birth : ${contact.dateOfBirth}</li>
						<li>Mail : ${contact.email}</li>
						<li class="last">Actif : ${contact.actif}</li>
					</c:forEach>
				</ul>
				
			</c:when>
			<c:otherwise>
				<p>Not Found Result</p>
			</c:otherwise>
		</c:choose>
		<div class="back">
			<a href="javascript:history.go(-1)"><button id="backHomePage" class="btn btn-default">Back To Home Page</button></a>
		</div>
	</body>
</html>