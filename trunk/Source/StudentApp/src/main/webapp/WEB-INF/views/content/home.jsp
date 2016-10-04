<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- my common function jsp -->
<%@ include file="../commons/commonjs.jsp"%>

<div class="row">
	<div class="x_panel">
		<div class="x_title">
			<h2>
				<spring:message code="my.home.heading.text" />
			</h2>
			<ul class="nav navbar-right panel_toolbox">
				<li><a class="collapse-link"><i	class="fa fa-chevron-up"></i></a></li>
			</ul>
			<div class="clearfix"></div>
		</div>
		<div class="x_content">
			
			<h2>
				<spring:message code="my.pending.count.text" /> : ${pendingCount}
			</h2>
			<br/><hr/>
			<div class="table-responsive">
			<table class="table table-striped table-bordered">
				<tr>
					<th><spring:message code="home.summay.table.No" /></th>
					<th><spring:message code="home.summay.table.sent.date" /></th>
					<th><spring:message code="home.summay.table.sent.by" /></th>
					<th><spring:message code="home.summay.table.current.status" /></th>
					<th><spring:message code="label.reveiwer.comment" /></th>
					<th></th>
					<th></th>
				</tr>
				<c:forEach var="pending" items="${pendingList}" varStatus="count">
					<tr>
						<td>${count.index+1}</td>
						<td><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value="${pending.completedDateTime}" /></td>
						<td>${pending.completedUser.userDisplayName}</td>
						<td><spring:message code="${pending.reviewStatus.displayName}"/></td>
						<td>${pending.reviewerComment}</td>
						<td>
							<c:set var="redirectUrl" value=""></c:set>
							<c:choose>
								<c:when test="${pending.baseApplication.applicationType == 'LAD'}">
									<c:set var="redirectUrl" value="applicationLAD.htm?id=${pending.baseApplication.id}"></c:set>
								</c:when>
								<c:when test="${pending.baseApplication.applicationType == 'LAP'}">
									<c:set var="redirectUrl" value="applicationLAP.htm?id=${pending.baseApplication.id}"></c:set>
								</c:when>
								<c:when test="${pending.baseApplication.applicationType == 'LI'}">
									<c:set var="redirectUrl" value="applicationLI.htm?id=${pending.baseApplication.id}"></c:set>
								</c:when>
								<c:when test="${pending.baseApplication.applicationType == 'LAB'}">
									<c:set var="redirectUrl" value="applicationLAB.htm?id=${pending.baseApplication.id}"></c:set>
								</c:when>
							</c:choose>
						<a class="badge bg-green" href="${redirectUrl}"><spring:message code="advance.search.application.lable.direct.to.application" /></a></td>
						<td><a class="badge bg-green" href="completeWorkFlow.htm?id=${pending.id}"><spring:message code="home.lable.complete.workflow" /></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		</div>
	</div>
</div>
