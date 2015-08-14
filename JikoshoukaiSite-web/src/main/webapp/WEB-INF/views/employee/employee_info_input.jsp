<div id="wrapper">
	<h1>${headerTitle}</h1>

	<div id="todoForm">
		<h3>Input Employee Information</h3>

		<t:messagesPanel />
		<form:form action="${pageContext.request.contextPath}/docreate"
			method="post" modelAttribute="employeeInfoInputForm">

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
			<form:input path="birthYear" value="" />
			<form:errors path="birthYear" />
			<label>Year</label>
			<form:input path="birthMonth" value="" />
			<form:errors path="birthMonth" />
			<label>Month</label>
			<form:input path="birthDate" value="" />
			<form:errors path="birthDate" />
			<label>Day</label>
			<br>

			<label>Self-introduction</label>
			<form:textarea rows="4" cols="50" maxlength="50"
				path="selfIntroduction" value="" />
			<form:errors path="selfIntroduction" />
			<br>

			<input type="submit" value="Back" />
			<input type="submit" value="Update" />
		</form:form>
	</div>

</div>
