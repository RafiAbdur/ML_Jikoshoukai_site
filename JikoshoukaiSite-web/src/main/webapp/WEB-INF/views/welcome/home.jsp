<div id="wrapper">
	<h1>Home Page</h1>

	<div>
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

		<hr>

		<h3>Employee List</h3>
		<c:choose>
			<c:when test="${page != null && page.totalPages != 0}">
				<table>
					<thead>
						<tr>
							<th>No</th>
							<th>Title</th>
						</tr>
					</thead>

					<c:forEach var="employee" items="${page.content}"
						varStatus="rowStatus">
						<tr>
							<td>${(page.number * page.size) + rowStatus.count}</td>
							<td>${f:h(employee.name)}</td>
						</tr>
					</c:forEach>
				</table>
				
				<div>
					<t:pagination page="${page}" outerElementClass="pagination" />
				</div>
			</c:when>
		</c:choose>

		<h2>${employees.size()}</h2>
	</div>

</div>
