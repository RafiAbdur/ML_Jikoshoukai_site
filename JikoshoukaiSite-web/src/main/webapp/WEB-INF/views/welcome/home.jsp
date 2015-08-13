<div id="wrapper">
	<h1>Home Page</h1>

	<div id="todoForm">
		<h3>Search Employee</h3>

		<t:messagesPanel />
		<form:form action="${pageContext.request.contextPath}/docreate"
			method="post" modelAttribute="searchEmployeeForm">

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

			<label>Age</label>
			<form:input path="age" value="" />
			<form:errors path="age" />
			<br>

			<label>Gender</label>
			<form:select path="employee.gender"
				items="${searchEmployeeForm.getGenderList()}" />
			<br>

			<label>Keyword</label>
			<form:input path="keyword" />
			<form:errors path="keyword" />
			<br>


			<input type="submit" value="Search" />
		</form:form>
	</div>

</div>
