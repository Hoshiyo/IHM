<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${not empty lists}">

	<ul>
		<c:forEach var="listValue" items="${lists}">
			<li>${listValue.FName}<a href=""></a></li>
		</c:forEach>
	</ul>

	<script>
		function deleteContact(id) {
			$.ajax({
				url : "/" + id,
				type : "DELETE",

			}).done(function(data) {
				console.log("DELETE:" + this);
			});
		}
	</script>
</c:if>