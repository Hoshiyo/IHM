<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="resources/themes/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link href="resources/themes/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
		<title>Edit Contact</title>
	</head>
	<body>
		<h1>IHM : ${message}</h1>
		
<!-- set up the modal to start hidden and fade in and out -->
<div id="contactModal" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
    <!-- dialog header -->
    <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal">&times;<span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Edit Contact</h4>
      </div>
      <!-- dialog body -->
      <a class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span></a>
      
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
		      <label for="birthday" class="col-sm-2 control-label">Birth Date</label>
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
		   <div class="form-group">
		      <div class="col-sm-offset-2 col-sm-10">
		         <button type="submit" class="btn btn-default">Save contact</button>
		      </div>
		   </div>
		</form>
      </div>
      <!-- dialog buttons -->
      <div class="modal-footer"><button type="button" class="btn btn-primary">OK</button></div>
    </div>
  </div>
</div>
 
 <!-- JavaScript Includes -->
		<script type="text/javascript" src="resources/themes/jquery/js/jquery.min.js"></script>
		<script type="text/javascript" src="resources/themes/bootstrap/js/bootstrap.min.js"></script>
	
	</body>
</html>