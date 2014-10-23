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
			span.search {
				font-weight: bold;
			}
			div.back {
				text-align: center;
				margin: 50px 0;
			}

		</style>
		<title>Search results</title>
		
	</head>
	<body>
		<h1 >Search Results Address</h1>
		
		<c:if test="${not empty nbrList}">
			<h3>By Number</h3>
			<ul>
				<c:forEach var="address" items="${nbrList}">
					<li>Address : ${address.nbr} ${address.street}</li>
					<li>City : ${address.city}</li>
					<li>Zip code : ${address.zipCode}</li>
					<li class="last">Address type : ${address.type}</li>
				</c:forEach>
			</ul>
			
		</c:if>
		
		<c:if test="${not empty streetList}">
			<h3>By Street</h3>
			<ul>
				<c:forEach var="address" items="${streetList}">
						<li>Address : ${address.nbr} ${address.street}</li>
						<li>City : ${address.city}</li>
						<li>Zip code : ${address.zipCode}</li>
						<li class="last">Address type : ${address.type}</li>
				</c:forEach>
			</ul>
			
		</c:if>

		<c:if test="${not empty cityList}">
			<h3>By City</h3>
			<ul>
				<c:forEach var="address" items="${cityList}">
					<li>Address : ${address.nbr} ${address.street}</li>
					<li>City : ${address.city}</li>
					<li>Zip code : ${address.zipCode}</li>
					<li>Address type : ${address.type}</li>
				</c:forEach>
			</ul>
			
		</c:if>
		
		<div class="back">
			<a href="javascript:history.go(-1)"><button id="backHomePage" class="btn btn-default">Back To Home Page</button></a>
		</div>
	
	</body>
</html>