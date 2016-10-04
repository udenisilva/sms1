<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="page-title">
	<div class="title_left">
		<h3><spring:message code="user.profile.title" /></h3>
	</div>
</div>

<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h2>
					Particulars of applicant <small>different form	elements</small>
				</h2>
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i	class="fa fa-chevron-up"></i></a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<br/>
				
				<form:form action="registerUser.htm" class="form-horizontal form-label-left" modelAttribute="systemUser" method="post" >
				<form:input type="hidden" name="userId" path="userId"/>
				<form:input type="hidden" name="password" path="password"/>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name-initials"><spring:message code="user.profile.username" /><span class="required">*</span>
					</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<form:input class="form-control col-md-7 col-xs-12" path="userName" id="userName" name="userName" required="required"/>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name-initials"><spring:message code="user.profile.staff.name" /><span class="required">*</span>
					</label>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<form:input class="form-control col-md-7 col-xs-12" path="staffName" id="staffName" name="staffName" required="required"/>
					</div>
				</div>
				<div class="form-group">
					<label for="emailAddress" class="control-label col-md-3 col-sm-3 col-xs-12"><b><spring:message code="user.profile.email" /></b></label>
					<div class="col-sm-6">
						<form:input class="form-control col-md-7 col-xs-12" path="emailAddress" id="emailAddress" name="emailAddress"/>  						
					</div>
				</div>
				<div class="form-group">
					<label for="staffId" class="control-label col-md-3 col-sm-3 col-xs-12"><b><spring:message code="user.profile.staff.id" /></b></label>
					<div class="col-sm-6">
						<form:input class="form-control col-md-7 col-xs-12" path="staffId" id="staffId" name="staffId"/>  						
					</div>
				</div>
				<div class="form-group">
					<label for="designation" class="control-label col-md-3 col-sm-3 col-xs-12"><b><spring:message code="user.profile.designation" /></b></label>
					<div class="col-sm-6">
						<form:input class="form-control col-md-7 col-xs-12" path="designation" id="designation" name="designation"/>  						
					</div>
				</div>
				
				<div class="col-md-12 col-sm-12 col-xs-12 col-md-offset-8">
					<input class="btn btn-success col-md-2 col-sm-2" type="submit" value="<spring:message code="user.profile.button.value" />"/>
				</div>
				
				</form:form>
				<a class="btn btn-success col-md-2 col-sm-2" href="changePassword.htm">Change Password</a>
			</div>
		</div>
	</div>
</div>

