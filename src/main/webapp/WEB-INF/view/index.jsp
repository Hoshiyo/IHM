<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="<c:url value="/resources/themes/bootstrap/css/bootstrap.min.css" />"
			rel="stylesheet">
		<link href="<c:url value="/resources/themes/bootstrap/css/bootstrap-theme.min.css" />"
			rel="stylesheet">
		<style type="text/css">
			body {
				margin: 20px;
			}
		</style>
		<title>Home page</title>
	</head>
<body>
	<h2>Hello World!</h2>
	
	<!-- set up the modal to start hidden and fade in and out -->
		<div id="myModal" class="modal fade">
		  <div class="modal-dialog">
		    <div class="modal-content">
		    
		    <!-- dialog header -->
		    <div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal">&times;<span class="sr-only">Close</span></button>
		        <h4 class="modal-title" id="myModalLabel">Edit Contact</h4>
		      </div>
		      
		      <!-- dialog body -->
		      <div class="modal-body">
		        <form class="form-horizontal" role="form">
				   <div class="form-group">
				      <label for="firstname" class="col-sm-2 control-label">First Name</label>
				      <div class="col-sm-10">
				         <input type="text" class="form-control" id="firstname" 
				            placeholder="Enter Your First Name">
				      </div>
				   </div>
				   <div class="form-group">
				      <label for="lastname" class="col-sm-2 control-label">Last Name</label>
				      <div class="col-sm-10">
				         <input type="text" class="form-control" id="lastname" 
				            placeholder="Enter Your Last Name">
				      </div>
				   </div>
				   <div class="form-group">
				      <label for="birthday" class="col-sm-2 control-label">Anniversary Date</label>
				      <div class="col-sm-10">
				         <input type="text" class="form-control" id="birthday" 
				            placeholder="Enter Your Anniversary Date">
				      </div>
				   </div>
				   <div class="form-group">
				      <label for="phone" class="col-sm-2 control-label">Phone</label>
				      <div class="col-sm-10">
				         <input type="text" class="form-control" id="phone" 
				            placeholder="Enter Your Phone">
				      </div>
				   </div>
				   <div class="form-group">
				      <label for="email" class="col-sm-2 control-label">Email</label>
				      <div class="col-sm-10">
				         <input type="text" class="form-control" id="email" 
				            placeholder="Enter Your Email">
				      </div>
				   </div>
				   <div class="form-group">
				      <div class="col-sm-offset-2 col-sm-10">
				         <div class="checkbox">
				            <label>
				               <input type="checkbox"> Actif
				            </label>
				         </div>
				      </div>
				   </div>
				</form>
		      </div>
		      
		      <!-- dialog buttons -->
		      <div class="modal-footer"><button type="button" class="btn btn-primary">OK</button></div>
		    </div>
		  </div>
		</div>
		
		<nav class="navbar navbar-default" role="navigation">
		<button class="btn btn-default navbar-btn" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-plus"></span></button>
	
			<form class="navbar-form navbar-left" role="search">
		        <div class="form-group">
		          <input type="text" class="form-control" placeholder="Search">
		        </div>
		        <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
		      </form>
		      <button class="btn btn-default navbar-btn" type="button"><span class="glyphicon glyphicon-trash"></span></button>
		</nav>		

	<div id="container">
		<c:if test="${not empty lists}">

			<ul>
				<c:forEach var="listValue" items="${lists}">
					<li id="contact-${listValue.id}">${listValue.FName} <a
						class="editContact" href="/contact/${listValue.id}/edit">edit</a>
						<a class="deleteContact" href="/contact/${listValue.id}">delete</a>
					</li>
				</c:forEach>
			</ul>

		</c:if>
	</div>

	<button id="addContact">New contact</button>

	<!-- JavaScript Includes -->
		<script type="text/javascript"
			src="<c:url value="/resources/themes/jquery/js/jquery.min.js" />"></script>
		<script type="text/javascript"
			src="<c:url value="/resources/themes/bootstrap/js/bootstrap.min.js" />"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="<c:url value="/resources/themes/js/functions.js" />"></script>
	<script>
		$(document).ready(function() {

			$("#addContact").click(getContactForm);

			$(".editContact").each(function(id, item) {

				$(item).click(function(e) {
					e.preventDefault();

					$.ajax({
						url : $(item).attr("href"),
						type : "GET"

					}).done(function(html) {
						$("#contactForm").remove();
						$("#container").append(html);
						$("#contactForm").submit(editContact);
					})
				})
			});

			$(".deleteContact").each(function(id, item) {

				$(item).click(function(e) {
					e.preventDefault();

					$.ajax({
						url : $(item).attr("href"),
						type : "DELETE"

					}).done(function(html) {
						$(item).parent().remove();
					})
				})
			});
		});
	</script>

</body>
</html>
