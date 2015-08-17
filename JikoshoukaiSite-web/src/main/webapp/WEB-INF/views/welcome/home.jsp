<!-- Page Content -->
<div class="container">

	<h3>Search Employee</h3>

	<t:messagesPanel />
	<form:form action="${pageContext.request.contextPath}/search"
		method="post" modelAttribute="searchEmployeeForm" class="form-inline">
		<div class="form-group">
			<label>姓（全角）</label>
			<form:input path="employee.surName" class="form-control" />
			<form:errors path="employee.surName" />
		</div>

		<div class="form-group">
			<label>名（全角）</label>
			<form:input path="employee.name" class="form-control" />
			<form:errors path="employee.name" />
		</div>


		<input type="submit" value="検索" class="btn btn-default" />
	</form:form>

	<hr>

	<a href="${pageContext.request.contextPath}/create"
		class="btn btn-primary pull-right" role="button">Add employee</a>
	<h3>Employee List</h3>
	<c:choose>
		<c:when test="${page != null && page.totalPages != 0}">
			<h3>${f:h(searchResultMessage)}</h3>
			<table class="table table-striped">
				<thead>
					<tr>
						<!-- <th>No</th> -->
						<th>姓（全角）</th>
						<th>名（全角）</th>
						<th>姓（カナ）</th>
						<th>名（カナ）</th>
						<th>性別</th>
						<th>年齢</th>
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
						<td>
						<c:if test="${employee.gender == 'M'}">
						Male
						</c:if>
						<c:if test="${employee.gender == 'F'}">
						Female
						</c:if>
						</td>
						<td>${f:h(employee.getAge())}</td>
						<td>${f:h(employee.selfIntroduction)}</td>
						<style>
						.pull-left{
						margin-right: 5px;
						}
						</style>
						<td><form:form method="post"
								action="${pageContext.request.contextPath}/edit" class="pull-left">
								<input type="hidden" name="id"
									value="${f:h(employee.employeeId)}" />
								<input type="submit" value="編集"
									class="btn btn-primary pull-left" />
							</form:form> 
							<form:form method="post"
								action="${pageContext.request.contextPath}/delete"  class="pull-left">
								<input type="hidden" name="id"
									value="${f:h(employee.employeeId)}" />
								<input type="submit" value="削除"
									class="btn btn-primary pull-left"
									onclick="return confirmDelete();" />
							</form:form></td>
					</tr>
				</c:forEach>
			</table>

			<div>
				<t:pagination page="${page}" outerElementClass="pagination" />
			</div>
		</c:when>
	</c:choose>

</div>
<!-- /.container -->

<script type="text/javascript">
	function confirmDelete() {
		var agree = confirm("Are you sure you want to delete this Record? (このレコードをデリートしたいですか。)");
		if (agree)
			return true;
		else
			return false;
	}
</script>