<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- my common function jsp -->
<%@ include file="../commons/commonjs.jsp"%>

<div class="x_panel">
	<div class="x_title">
		<h2>
			<spring:message code='find.user' />
		</h2>
		<ul class="nav navbar-right panel_toolbox">
			<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
		</ul>
		<div class="clearfix"></div>
	</div>
	<div class="x_content">
		<form:form action="findUser.htm" method="post">

			<div class="form-group">
				<div class="col-md-6">
					<select class="form-control" id="forwardUser" name="forwardUser">
						<c:forEach var="user" items="${users}">
							<option value="${user.userId}">${user.userDisplayName}</option>
						</c:forEach>
					</select>
				</div>

				<button class="btn btn-primary" type="submit">
					<i class="fa fa-share"></i>
					<spring:message code='find.button.label' />
				</button>
				<button class="btn btn-primary" type="button"
					onclick="redirect('registerUser.htm');">
					<i class="fa fa-user"></i>
					<spring:message code='create.new.button.label' />
				</button>
			</div>

		</form:form>

	</div>
</div>

<div class="x_panel">
	<div class="x_title">
		<h2>
			<spring:message code='create.update.user.heading' />
		</h2>
		<ul class="nav navbar-right panel_toolbox">
			<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
		</ul>
		<div class="clearfix"></div>
	</div>
	<div class="x_content">

		<form:form action="registerUser.htm" modelAttribute="systemUser"
			method="post" onsubmit="return validateForm();">

			<input type="hidden" name="userId" value="${systemuser.userId}" />

			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"
					for="name-initials"><spring:message
						code='register.username' /><span class="required">*</span> </label>
				<div class="col-md-6 col-sm-6 col-xs-12">
					<input type="text" class="form-control" id="userName"
						name="userName" value="${systemuser.userName}"
						onblur="validateUser();" placeholder="">
				</div>
			</div>
			<div class="clearfix"></div>

			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"
					for="name-initials"><spring:message
						code='register.password' /><span class="required">*</span> </label>
				<div class="col-md-6 col-sm-6 col-xs-12">
					<input type="password" class="form-control" id="password"
						name="password" value="" placeholder="">
				</div>
			</div>
			<div class="clearfix"></div>

			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"
					for="name-initials"><spring:message
						code='register.confirm.password' /><span class="required">*</span>
				</label>
				<div class="col-md-6 col-sm-6 col-xs-12">
					<input type="password" class="form-control" id="passwordcon"
						name="passwordcon" value="" onblur="checkConfirmPassword();"
						placeholder="">
				</div>
			</div>
			<div class="clearfix"></div>

			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"
					for="name-initials"><spring:message
						code='register.display.name' /><span class="required">*</span> </label>
				<div class="col-md-6 col-sm-6 col-xs-12">
					<input type="text" class="form-control" id="userDisplayName"
						name="userDisplayName" value="${systemuser.userDisplayName}"
						placeholder="">
				</div>
			</div>
			<div class="clearfix"></div>

			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"
					for="name-initials"><spring:message
						code='register.user.roles' /><span class="required">*</span> </label>
				<div class="col-md-6 col-sm-6 col-xs-12">
					<select class="form-control" id="userrole" name="userrole">
						<c:choose>
							<c:when test="${systemuserrole == 'ROLE_ADMIN'}">
								<option value="ROLE_ADMIN" selected="selected">Admin</option>
								<option value="ROLE_DIVISION_HEAD">Division Head</option>
								<option value="ROLE_USER">User</option>
							</c:when>
							<c:when test="${systemuserrole == 'ROLE_DIVISION_HEAD'}">
								<option value="ROLE_ADMIN" selected="selected">Admin</option>
								<option value="ROLE_DIVISION_HEAD" selected="selected">Division
									Head</option>
								<option value="ROLE_USER">User</option>
							</c:when>
							<c:when test="${systemuserrole == 'ROLE_USER'}">
								<option value="ROLE_ADMIN">Admin</option>
								<option value="ROLE_DIVISION_HEAD">Division Head</option>
								<option value="ROLE_USER" selected="selected">User</option>
							</c:when>
							<c:otherwise>
								<option value="ROLE_USER">User</option>
								<option value="ROLE_ADMIN">Admin</option>
								<option value="ROLE_DIVISION_HEAD">Division Head</option>

							</c:otherwise>
						</c:choose>
					</select>
				</div>
			</div>
			<div class="clearfix"></div>

			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"
					for="name-initials"><spring:message
						code='register.active.status' /><span class="required">*</span> </label>
				<div class="col-md-6 col-sm-6 col-xs-12">
					<select class="form-control" id="activeStatus" name="activeStatus">
						<c:choose>
							<c:when test="${systemuser.activeStatus == 'YES'}">
								<option value="YES" selected="selected">Activated</option>
								<option value="NO">Deactivated</option>
							</c:when>
							<c:otherwise>
								<option value="YES">Activated</option>
								<option value="NO" selected="selected">Deactivated</option>
							</c:otherwise>
						</c:choose>
					</select>
				</div>
			</div>
 
			<div class="clearfix"></div>
 

			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"
					for="name-initials"><spring:message code='register.email' /></label>
				<div class="col-md-6 col-sm-6 col-xs-12">
					<input type="text" class="form-control" id="emailAddress"
						name="emailAddress" value="${systemuser.emailAddress}"
						placeholder="">
				</div>
			</div>
			<div class="clearfix"></div>

			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"
					for="name-initials"><spring:message
						code='register.staff.id' /><span class="required">*</span> </label>
				<div class="col-md-6 col-sm-6 col-xs-12">
					<input type="text" class="form-control" id="staffId" name="staffId"
						value="${systemuser.staffId}" placeholder="">
				</div>
			</div>
			<div class="clearfix"></div>

			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"
					for="name-initials"><spring:message
						code='register.staff.name' /><span class="required">*</span> </label>
				<div class="col-md-6 col-sm-6 col-xs-12">
					<input type="text" class="form-control" id="staffName"
						name="staffName" value="${systemuser.staffName}" placeholder="">
				</div>
			</div>
			<div class="clearfix"></div>

			<div class="form-group">
				<label class="control-label col-md-3 col-sm-3 col-xs-12"
					for="name-initials"><spring:message
						code='register.designation' /><span class="required">*</span> </label>
				<div class="col-md-6 col-sm-6 col-xs-12">
					<input type="text" class="form-control" id="designation"
						name="designation" value="${systemuser.designation}"
						placeholder="">
				</div>
			</div>
			<div class="clearfix"></div>

			<br />
			<br />

			<div class="col-md-12 col-sm-12 col-xs-12 col-md-offset-8">
				<button class="btn btn-primary col-md-2 col-sm-2" type="submit"
					id="submitButton">
					<i class="fa fa-share"></i>
					<spring:message code='create.udpate.button.label' />
				</button>
				<button class="btn btn-primary col-md-2 col-sm-2" type="button"
					onclick="redirect('registerUser.htm');">
					<i class="fa fa-times"></i>
					<spring:message code='reset.button.label' />
				</button>
			</div>

		</form:form>

	</div>
</div>

<script type="text/javascript">
	function validateForm() {
		var username = $("#userName").val();
		var password = $("#password").val();
		var passwordCon = $("#passwordcon").val();
		var userDisplayName = $("#userDisplayName").val();
	 
		var staffId = $("#staffId").val();
		var staffName = $("#staffName").val();
		var designation = $("#designation").val();
		//var isAdmin = $("#isAdmin").val();

		if (username == "") {
			showError("#userName",
					"<spring:message code='register.error.empty.username' />");
			return false;
		} else if (password == "") {
			showError("#password",
					"<spring:message code='register.error.empty.password' />");
			return false;
		} else if (passwordCon == "") {
			showError("#passwordcon",
					"<spring:message code='register.error.empty.confirm.password' />");
			return false;
		} else if (password != passwordCon) {
			showError("#password",
					"<spring:message code='register.error.invalid.password' />");
			return false;
		} else if (userDisplayName == "") {
			showError("#userDisplayName",
					"<spring:message code='register.error.empty.display.name' />");
			return false;
			/* }else if(isAdmin == 'NO' && districtCount == 1){
			   $("span.parsley-error").hide();
			   showErrorBelow("#allowDistrictTable", "<spring:message code='register.error.empty.districts' />");
			   return false;*/
		} else if (staffId == "") {
			showError("#staffId",
					"<spring:message code='register.error.staff.id' />");
			return false;
		} else if (staffName == "") {
			showError("#staffName",
					"<spring:message code='register.error.staff.name' />");
			return false;
		} else if (designation == "") {
			showError("#designation",
					"<spring:message code='register.error.designation' />");
			return false;
		} else {
			return true;
		}
	}

 

	function validateUser() {
		var username = $("#userName").val();
		$
				.ajax({
					type : "GET",
					url : "validateUserName.do",
					data : {
						"username" : username
					},
					success : function(data) {
						if (data == 'err') {
							showErrorBelow("#userName",
									"<spring:message code='register.error.invalid.username' />");
							$("#submitButton").prop('disabled', true);
						} else {
							$("span.parsley-error").hide(300);
							$("#submitButton").prop('disabled', false);
						}
					},
					error : function(data) {
						alert("error");
					}
				});
	}

	function checkConfirmPassword() {
		var password = $("#password").val();
		var passwordCon = $("#passwordcon").val();
		if (password != passwordCon) {
			showErrorBelow("#passwordcon",
					"<spring:message code='register.error.invalid.password' />");
			$("#submitButton").prop('disabled', true);
		} else {
			$("span.parsley-error").hide(300);
			$("#submitButton").prop('disabled', false);
		}
	}
</script>
