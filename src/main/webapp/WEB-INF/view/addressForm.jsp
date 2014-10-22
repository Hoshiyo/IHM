<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- TODO: Faire verif en JS ! -->

<div class="modal-dialog">
	<div class="modal-content">

		<!-- dialog header -->
		<div class="modal-header">
			<button id="closeModal" type="button" class="close"
				data-dismiss="modal">
				&times;<span class="sr-only">Close</span>
			</button>
			<h4 class="modal-title" id="myModalLabel">Edit Address</h4>
		</div>

		<!-- dialog body -->
		<div class="modal-body">
			<form:form id="addressForm" method="PUT" action="/address/"
				commandName="address">
				<form:hidden path="id"></form:hidden>

				<form:label path="nbr">Number</form:label>
				<form:input path="nbr" />

				<form:label path="street">Street</form:label>
				<form:input path="street" />

				<form:label path="city">City</form:label>
				<form:input path="city" />

				<form:label path="zipCode">Zip code</form:label>
				<form:input path="zipCode" />

				<form:label path="type">Address type</form:label>
				<form:input path="type" />

				<input type="submit" value="Submit" />
			</form:form>
		</div>
	</div>
</div>