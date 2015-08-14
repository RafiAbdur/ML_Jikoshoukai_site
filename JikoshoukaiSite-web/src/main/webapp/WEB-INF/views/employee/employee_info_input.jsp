<div id="wrapper">
	<h1>${headerTitle}</h1>

	<div id="todoForm">
		<h3>Input Employee Information</h3>

		<t:messagesPanel />
		<form:form action="${pageContext.request.contextPath}/${action}"
			method="post" commandName="employeeInfoInputForm">
			
			<form:hidden path="employee.employeeId"/>
			
			<label>姓（全角）</label>
			<form:input path="employee.surName" />
			<form:errors path="employee.surName" />
			<br>
			<br>
			
			<label>名（全角）</label>
			<form:input path="employee.name" />
			<form:errors path="employee.name"></form:errors>
			<br>
			<br>
			
			<label>姓（カナ）</label>
			<form:input path="employee.surNameKana" />
			<form:errors path="employee.surNameKana" />
			<br>
			<br>

			<label>名（カナ）</label>
			<form:input path="employee.nameKana" />
			<form:errors path="employee.nameKana" />
			<br>
			<br>

			<label>性別</label>
			<form:select path="employee.gender"
				items="${employeeInfoInputForm.getGenderList()}" />
			<br>
			<br>


			<label>生年月日 </label>
			<form:input path="birthdate" id="birthdate" />
			<br>
			<br>

			<label>自己紹介</label>
			<br>
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
