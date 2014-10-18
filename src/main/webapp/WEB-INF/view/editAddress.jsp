<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="resources/themes/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link href="resources/themes/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
		<title>Edit Address</title>
	</head>
	<body>
		<!-- set up the modal to start hidden and fade in and out -->
		<div id="myModal" class="modal fade">
		  <div class="modal-dialog">
		    <div class="modal-content">
		    <!-- dialog header -->
		    <div class="modal-header">
		    <button type="button" class="close" data-dismiss="modal">&times;<span class="sr-only">Close</span></button>
		        <h4 class="modal-title" id="myModalLabel">Edit address</h4>
		      </div>
		      <!-- dialog body -->
		      <div class="modal-body">
		        <form class="form-horizontal" role="form">
				   <div class="form-group">
				      <label for="number" class="col-sm-2 control-label">Number</label>
				      <div class="col-sm-10">
				         <input type="text" class="form-control" id="number" 
				            placeholder="Enter Your Address's Number">
				      </div>
				   </div>
				   <div class="form-group">
				      <label for="street" class="col-sm-2 control-label">Street</label>
				      <div class="col-sm-10">
				         <input type="text" class="form-control" id="street" 
				            placeholder="Enter Your Street">
				      </div>
				   </div>
				   <div class="form-group">
				      <label for="city" class="col-sm-2 control-label">City</label>
				      <div class="col-sm-10">
				         <input type="text" class="form-control" id="city" 
				            placeholder="Enter Your City">
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
				      <label for="zipcode" class="col-sm-2 control-label">ZipCode</label>
				      <div class="col-sm-10">
				         <input type="text" class="form-control" id="zipcode" 
				            placeholder="Enter Your ZipCode">
				      </div>
				   </div>
				   <div class="form-group">
					<label for="addresstype" class="col-sm-2 control-label">Address Type</label>   
				   <div class="col-sm-10">
				      <a class="btn btn-primary dropdown-toggle" data-toggle="dropdown" href="#">Select Your Address Type<span class="caret"></span></a>
				    <ul class="dropdown-menu">
				      <li><a href="#">Delivery</a></li>
				      <li><a href="#">Payment</a></li>
				    </ul>
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