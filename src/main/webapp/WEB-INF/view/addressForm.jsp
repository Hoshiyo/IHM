<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- set up the modal to start hidden and fade in and out -->
<div class="modal-dialog">
	<div class="modal-content">

		<!-- dialog header -->
		<div class="modal-header">
			<button id="closeModal" type="button" class="close"
				data-dismiss="modal">
				&times;<span class="sr-only">Close</span>
			</button>
			<h4 class="modal-title" id="myModalLabel">Create Address</h4>
		</div>

		<!-- dialog body -->
		<div class="modal-body">
			<form:form id="addressForm" method="POST" action="/address/"
				commandName="address" class="form-horizontal" role="form">

				<form:hidden path="id" />

				<form:hidden path="contactId" />

				<div class="form-group">
					<form:label path="nbr" class="col-sm-3 control-label">Number</form:label>
					<div class="col-sm-9">
						<form:input class="form-control" path="nbr"
							placeholder="Enter Your Nbr Street" />
					</div>
				</div>
				<div class="form-group">
					<form:label path="street" class="col-sm-3 control-label">Street</form:label>
					<div class="col-sm-9">
						<form:input class="form-control" path="street"
							placeholder="Enter Your Street" />
					</div>
				</div>
				<div class="form-group">
					<form:label path="city" class="col-sm-3 control-label">City</form:label>
					<div class="col-sm-9">
						<form:input class="form-control" path="city"
							placeholder="Enter Your City" />
					</div>
				</div>
				<div class="form-group">
					<form:label path="zipCode" class="col-sm-3 control-label">Zip Code</form:label>
					<div class="col-sm-9">
						<form:input class="form-control" path="zipCode"
							placeholder="Enter Your ZipCode" />
					</div>
				</div>
				<div class="form-group">
					<form:label path="type" class="col-sm-3 control-label">Address Type</form:label>
					<div class="col-sm-9">
						<form:select path="type" class="form-control">
							<form:options items="${type}" />
						</form:select>
					</div>
				</div>

				<input type="submit" class="btn btn-primary" value="Submit" />
			</form:form>
		</div>
	</div>
</div>