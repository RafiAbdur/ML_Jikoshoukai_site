<div id="wrapper">
	<h1>${headerTitle}</h1>

	<div id="todoForm">
		<h3>Input Employee Information</h3>

		<t:messagesPanel />
		<form:form action="${pageContext.request.contextPath}/${action}"
			method="post" modelAttribute="employeeInfoInputForm">
			
			<form:hidden path="employee.employeeId"/>
			
			<label>Name</label>
			<form:input path="employee.name" />
			<form:errors path="employee.name" />
			<br>

			<label>Surname</label>
			<form:input path="employee.surName" />
			<form:errors path="employee.surName" />
			<br>

			<label>Name (Kana)</label>
			<form:input path="employee.nameKana" />
			<form:errors path="employee.nameKana" />
			<br>

			<label>Surname (Kana)</label>
			<form:input path="employee.surNameKana" />
			<form:errors path="employee.surNameKana" />
			<br>

			<label>Gender</label>
			<form:select path="employee.gender"
				items="${employeeInfoInputForm.getGenderList()}" />
			<br>


			<label>BirthDay </label>
			<form:input path="birthdate" id="birthdate" />
			<br>

			<label>Self-introduction</label>
			<form:textarea rows="4" cols="50" maxlength="50"
				path="employee.selfIntroduction" value="" />
			<form:errors path="employee.selfIntroduction" />
			<br>

			

			<script>
				$(document).ready(function() {
					$(function() {
						$("#birthdate").datepicker({
							dateFormat: "yy-mm-dd"
						});
						
					});
				});
			</script>

			<input type="submit" value="Back" />
			<input type="submit" value="Update" />
		</form:form>
	</div>

</div>
