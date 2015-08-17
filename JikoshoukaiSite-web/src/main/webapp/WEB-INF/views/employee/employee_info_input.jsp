<div id="container">
	<h1>${headerTitle}</h1>

	<div id="todoForm">

		<t:messagesPanel />

		<form:form action="${pageContext.request.contextPath}/${action}"
			method="post" commandName="employeeInfoInputForm"
			class="form-horizontal">

			<form:hidden path="employee.employeeId" />

			<div class="form-group">
				<label>姓（全角）</label>
				<form:input path="employee.surName" class="form-control" /><br>
				<form:errors path="employee.surName" class="alert alert-danger" />
			</div>

			<div class="form-group">
				<label>名（全角）</label>
				<form:input path="employee.name" class="form-control" /><br>
				<form:errors path="employee.name" class="alert alert-danger" />
			</div>

			<div class="form-group">
				<label>姓（カナ）</label>
				<form:input path="employee.surNameKana" class="form-control" /><br>
				<form:errors path="employee.surNameKana" class="alert alert-danger" />
			</div>

			<div class="form-group">
				<label>名（カナ）</label>
				<form:input path="employee.nameKana" class="form-control" /><br>
				<form:errors path="employee.nameKana" class="alert alert-danger" />
			</div>

			<div class="form-group">
				<label>性別</label>
				<form:select path="employee.gender"
					items="${employeeInfoInputForm.getGenderList()}" class="form-control" /><br>
			</div>

			<div class="form-group">
				<label>生年月日 </label>
				<form:input path="birthdate" id="birthdate" class="form-control" /><br>
				<c:if test="${not empty dateErrorMessage}">
					<span class="alert alert-danger">${dateErrorMessage}</span>
				</c:if>
			</div>

			<div class="form-group">
				<label>自己紹介</label> <br>
				<form:textarea rows="4" cols="50" maxlength="50"
					path="employee.selfIntroduction" value="" class="form-control" /><br>
				<form:errors path="employee.selfIntroduction" class="alert alert-danger" />
			</div>


			<script>
				$(document).ready(function() {
					$(function() {
						$("#birthdate").datepicker({
							dateFormat : "yy-mm-dd"
						});

					});
				});
			</script>
			
			<input type="button"
				onclick="location.href='${pageContext.request.contextPath}';"
				value="Back" class="btn btn-primary" />
				
			<input type="submit" value="Update" class="btn btn-primary" />
		</form:form>
	</div>

</div>
