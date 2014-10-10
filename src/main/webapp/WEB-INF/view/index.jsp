<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h2>Hello World!</h2>
	<c:if test="${not empty lists}">
 
		<ul>
			<c:forEach var="listValue" items="${lists}">
				<li>${listValue.FName}</li>
			</c:forEach>
		</ul>
 
	</c:if>
</body>
</html>
