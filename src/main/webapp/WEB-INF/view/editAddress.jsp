<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="resources/themes/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link href="resources/themes/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
		<title>Edit address</title>
	</head>
	<body>
		<h1>IHM : ${message}</h1>
		
<!-- set up the modal to start hidden and fade in and out -->
<div id="addressModal" class="modal fade">
  <div class="modal-dialog">
    <div class="modal-content">
    <!-- dialog header -->
    <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal">&times;<span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Edit address</h4>
      </div>
      <!-- dialog body -->
      <a class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span></a>
      
      <div class="modal-body">
        <form class="form-horizontal" role="form">
		   <div class="form-group">
		      <label for="nbr" class="col-sm-2 control-label">Number</label>
		      <div class="col-sm-10">
		         <input type="text" class="form-control" id="nbr" 
		            placeholder="Enter The Address Number">
		      </div>
		   </div>
		   <div class="form-group">
		      <label for="street" class="col-sm-2 control-label">Street</label>
		      <div class="col-sm-10">
		         <input type="text" class="form-control" id="street" 
		            placeholder="Enter The Street">
		      </div>
		   </div>
		   <div class="form-group">
		      <label for="city" class="col-sm-2 control-label">City</label>
		      <div class="col-sm-10">
		         <input type="text" class="form-control" id="city" 
		            placeholder="Enter The City">
		      </div>
		   </div>
		   <div class="form-group">
		      <label for="zipCode" class="col-sm-2 control-label">Zip Code</label>
		      <div class="col-sm-10">
		         <input type="text" class="form-control" id="zipCode" 
		            placeholder="Enter The Zip Code">
		      </div>
		   </div>
		  <div class="form-group">
					<form:label path="type" class="col-sm-3 control-label">Address Type</form:label>
						<div class="col-sm-9">
						<select class="form-control">
							<option>----- Select an address type -----</option>
							<option>Payment address</option>
							<option>Delivery address</option>
						</select>
					</div>
				</div>
		   <div class="form-group">
		      <div class="col-sm-offset-2 col-sm-10">
		         <button type="submit" class="btn btn-default">Save address</button>
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