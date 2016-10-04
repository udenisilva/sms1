<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h3><spring:message code="change.password.title" /></h3>

<form name="changePasswordForm" action="changePassword.htm" method="post">

<div class="col-lg-6">
	<div class="form-group">
		<div class="col-sm-4">
			<label for="oldPassword" class="control-label"><b><spring:message code="change.password.old" /></b></label>
		</div>
		<div class="col-sm-6">
			<input type="text" id="oldPassword" name="oldPassword"/>  						
		</div>
	</div>
</div>
<div style="clear:both;"></div>
<div class="col-lg-6">
	<div class="form-group">
		<div class="col-sm-4">
			<label for="newPasswordOne" class="control-label"><b><spring:message code="change.password.new" /></b></label>
		</div>
		<div class="col-sm-6">
			<input type="text" id="newPasswordOne" name="newPasswordOne"/> 					
		</div>
	</div>
</div>
<div style="clear:both;"></div>
<div class="col-lg-6">
	<div class="form-group">
		<div class="col-sm-4">
			<label for="newPasswordTwo" class="control-label"><b><spring:message code="change.password.confirm" /></b></label>
		</div>
		<div class="col-sm-6">
			<input type="text" id="newPasswordTwo" name="newPasswordTwo"/>   						
		</div>
	</div>
</div>
<div style="clear:both;"></div>

<input type="submit" value="<spring:message code="change.password.button.value" />"/>

</form>