<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${not empty lists}">

	<ul>
		<c:forEach var="listValue" items="${lists}">
			<li>${listValue.contact.FName} ${listValue.contact.LName}: ${listValue.nbr} ${listValue.street} ${listValue.city} ${listValue.zipCode} ${listValue.type}<a href=""></a></li>
		</c:forEach>
	</ul>


</c:if>