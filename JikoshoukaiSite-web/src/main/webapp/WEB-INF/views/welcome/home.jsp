<div id="wrapper">
	<h1>Home Page</h1>

	<div>
		<h3>Search Employee</h3>

		<t:messagesPanel />
		<form:form action="${pageContext.request.contextPath}/search"
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
		<a href="${pageContext.request.contextPath}/create">Add new employee</a>

		<h3>Employee List</h3>
		<c:choose>
			<c:when test="${page != null && page.totalPages != 0}">
				<table>
					<thead>
						<tr>
							<th>No</th>
							<th>Surname</th>
							<th>Name</th>
							<th>Surname in kana</th>
							<th>Name in kana</th>
							<th>Birth Date</th>
							<th>Self Introduction</th>
							<th>Action</th>
						</tr>
					</thead>

					<c:forEach var="employee" items="${page.content}"
						varStatus="rowStatus">
						<tr>
							<td>${(page.number * page.size) + rowStatus.count}</td>
							<td>${f:h(employee.surName)}</td>
							<td>${f:h(employee.name)}</td>		
							<td>${f:h(employee.surNameKana)}</td>					
							<td>${f:h(employee.nameKana)}</td>
							<td>${f:h(employee.birthdate)}</td>
							<td>${f:h(employee.selfIntroduction)}</td>
							<td><a href="${pageContext.request.contextPath}/edit/?id=${f:h(employee.employeeId)}">Edit</a> | <a href="${pageContext.request.contextPath}/delete/?id=${f:h(employee.employeeId)}">Delete</a></td>
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
