<style>
.pagination li {
    display: inline;
}

.pagination li>a {
    margin-left: 10px;
}
</style>
<div id="wrapper">
	<h1>Home Page</h1>

	<div>
		<h3>Search Employee</h3>

		<t:messagesPanel />
		<form:form action="${pageContext.request.contextPath}/search"
			method="post" modelAttribute="searchEmployeeForm">

			<label>姓（全角）</label>
			<form:input path="employee.surName" maxlength="5"/>
			<form:errors path="employee.surName" />
			<br>
			<br>
			
			<label>名（全角）</label>
			<form:input path="employee.name" maxlength="5"/>
			<form:errors path="employee.name" />
			<br>
			<br>

			<label>姓（カナ）</label>
			<form:input path="employee.surNameKana" maxlength="10" />
			<form:errors path="employee.surNameKana" />
			<br>
			<br>
			
			<label>名（カナ）</label>
			<form:input path="employee.nameKana" maxlength="10"/>
			<form:errors path="employee.nameKana" />
			<br>
			<br>
			
			<label>性別　　　</label>
			<form:select path="employee.gender"
				items="${searchEmployeeForm.getGenderList()}" />
			<br>
			<br>

			<label>年齢　　　</label>
			<form:input path="age" maxlength="3" />
			<form:errors path="age" />
			<br>
			<br>

			<label>キーワード</label>
			<form:input path="keyword" maxlength="50"/>
			<form:errors path="keyword" />
			<br>
			<br>


			<input type="submit" value="検索" />
		</form:form>

		<hr>
		
		<a href="${pageContext.request.contextPath}/create">Add new
			employee</a>
			
			<h3>${f:h(searchResultMessage)}</h3>

		<h3>Employee List</h3>
		<c:choose>
			<c:when test="${page != null && page.totalPages != 0}">
				<table>
					<thead>
						<tr>
							<!-- <th>No</th> -->
							<th>姓（全角）</th>
							<th>名（全角）</th>
							<th>姓（カナ）</th>
							<th>名（カナ）</th>
							<th>性別</th>
							<th>Birth Date</th>
							<th>自己紹介</th>
							<th>操作</th>
						</tr>
					</thead>

					<c:forEach var="employee" items="${page.content}"
						varStatus="rowStatus">
						<tr>
							<!-- <td>${(page.number * page.size) + rowStatus.count}</td>-->
							<td>${f:h(employee.surName)}</td>
							<td>${f:h(employee.name)}</td>
							<td>${f:h(employee.surNameKana)}</td>
							<td>${f:h(employee.nameKana)}</td>
							<td>${f:h(employee.gender)}</td>
							<td>${f:h(employee.birthdate)}</td>
							<td>${f:h(employee.selfIntroduction)}</td>
							<td><form:form method="post"
									action="${pageContext.request.contextPath}/edit">
									<input type="hidden" name="id"
										value="${f:h(employee.employeeId)}" />
									<input type="submit" value="編集" />
								</form:form> <form:form method="post"
									action="${pageContext.request.contextPath}/delete">
									<input type="hidden" name="id"
										value="${f:h(employee.employeeId)}" />
									<input type="submit" value="削除" onclick="return confirmDelete();" />
								</form:form></td>
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

<script type="text/javascript">
	function confirmDelete() {
		var agree = confirm("Are you sure you want to delete this Record? (このレコードをデリートしたいですか。)");
		if (agree)
			return true;
		else
			return false;
	}
</script>