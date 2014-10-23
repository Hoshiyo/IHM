<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- TODO: Faire verif en JS ! -->
<div id="addressModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
	
			<!-- dialog header -->
			<div class="modal-header">
				<button id="closeModal" type="button" class="close" data-dismiss="modal">
					&times;<span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Edit Address</h4>
			</div>
	
			<!-- dialog body -->
			<div class="modal-body">
				<form:form id="addressForm" method="PUT" action="/address/"
					commandName="address" class="form-horizontal" role="form">
					
					<form:hidden path="id" />
					
					<div class="form-group">
						<form:label path="nbr" class="col-sm-2 control-label">Number</form:label>
						<div class="col-sm-10">
							<form:input class="form-control" path="nbr"
								placeholder="Enter Your Nbr Street"  />
						</div>
					</div>
					<div class="form-group">
						<form:label path="street" class="col-sm-2 control-label">Street</form:label>
						<div class="col-sm-10">
							<form:input class="form-control" path="street" 
								placeholder="Enter Your Nbr Street"  />
						</div>
					</div>
					<div class="form-group">
						<form:label path="city" class="col-sm-2 control-label">City</form:label>
						<div class="col-sm-10">
							<form:input class="form-control" path="city" />
						</div>
					</div>
					<div class="form-group">
						<form:label path="zipCode" class="col-sm-2 control-label">Zip code</form:label>
						<div class="col-sm-10">
							<form:input class="form-control" path="zipCode" />
						</div>
					</div>
					<div class="form-group">
						<form:label path="type" class="col-sm-2 control-label">Address type</form:label>
							<div class="col-sm-10">
							<select class="form-control">
								<option>----- Select an address type -----</option>
								<option>Payment address</option>
								<option>Delivery address</option>
							</select>
						</div>
					</div>
	
					<input type="submit" value="Submit" />
				</form:form>
			</div>
		</div>
	</div>
</div>