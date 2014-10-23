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
			<h4 class="modal-title" id="myModalLabel">Edit Contact</h4>
		</div>

		<!-- dialog body -->
		<div class="modal-body">
			<form:form id="contactForm" method="PUT" action="contact"
				commandName="contact" class="form-horizontal" role="form">

				<form:hidden path="id" />

				<div class="form-group">
					<form:label path="fName" class="col-sm-2 control-label">First Name</form:label>
					<div class="col-sm-10">
						<form:input class="form-control" path="fName"
							placeholder="Enter Your First Name" />
					</div>
				</div>
				<div class="form-group">
					<form:label path="lName" class="col-sm-2 control-label">Last
								Name</form:label>
					<div class="col-sm-10">
						<form:input class="form-control" path="lName"
							placeholder="Enter Your Last Name" />
					</div>
				</div>
				<div class="form-group">
					<form:label path="dateOfBirth" class="col-sm-2 control-label">Anniversary
								Date</form:label>
					<div class="col-sm-10">
						<form:input class="form-control" path="dateOfBirth"
							placeholder="Enter Your Anniversary Date" />
					</div>
				</div>
				<div class="form-group">
					<form:label path="phoneNbr" class="col-sm-2 control-label">Phone</form:label>
					<div class="col-sm-10">
						<form:input class="form-control" path="phoneNbr"
							placeholder="Enter Your Phone" />
					</div>
				</div>
				<div class="form-group">
					<form:label path="email" class="col-sm-2 control-label">Email</form:label>
					<div class="col-sm-10">
						<form:input class="form-control" path="email"
							placeholder="Enter Your Email" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="checkbox">
							<label> <input type="checkbox"> Actif
							</label>
						</div>
					</div>
				</div>
				<input type="submit" class="btn btn-primary" value="Submit" />
			</form:form>
		</div>
	</div>
</div>

<script>
	$(document).ready(function() {
		$("#dateOfBirth").datepicker({
			dateFormat : "dd/mm/yy"
		});
	});
</script>