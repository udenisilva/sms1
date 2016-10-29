<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="col-md-3 left_col">
	<div class="left_col scroll-view">
		<div class="navbar nav_title" style="border: 0;">
			<a href="/olsims/" class="site_title"><i class="fa fa-area-chart"></i> <span>NBRO</span></a>
		</div>
		<div class="clearfix"></div>

		<br />

		<!-- sidebar menu -->
		<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

			<div class="menu_section">
				<h3>National Building Research Organization (NBRO)</h3>
				<br> <br>

				<ul class="nav side-menu">
					<li><a href="/olsims/"><i class="fa fa-home"></i> Home</a></li>
					<li><a href="#"><i class="fa fa-edit"></i> Application Processing <span class="fa fa-chevron-down"></span></a>
						<ul class="nav child_menu" style="display: none">
							<li><a href="applicationLAB.htm">LAB Form</a></li>
							<li><a href="applicationLAP.htm">LAP Form</a></li>
							<li><a href="applicationLAD.htm">LAD Form</a></li>
							<li><a href="applicationLI.htm">LI Request</a></li>
						</ul></li>
					<li><a href="officeUseOnly.htm?id=${param['id']}"><i class="fa fa-linux"></i>Office Use</a></li>
					<li><a href="attachments.htm?id=${param['id']}"><i class="fa fa-paperclip"></i>Attachment</a></li>
					<li><a href="costEstimation.htm?id=${param['id']}"><i class="fa fa-usd"></i>Cost Estimation</a></li>
					<li><a href="paymentInformation.htm?id=${param['id']}"><i class="fa fa-list"></i>Payment</a></li>
					<li><a href="paymentAcknowledgment.htm?id=${param['id']}"><i class="fa fa-list"></i>Payment Acknowledgment</a></li>
					<li><a href="applicationReview.htm?id=${param['id']}"><i class="fa fa-certificate"></i>Application Review</a></li>
					<li><a href="investigation.htm?id=${param['id']}"><i class="fa fa-list"></i>Investigation</a></li>
					<li><a href="clearanceIssue.htm?id=${param['id']}"><i class="fa fa-check"></i>Clearance Issue</a></li>
					<li><a href="#"><i class="fa fa-refresh"></i>Renew/Modify<span class="fa fa-chevron-down"></span></a>
						<ul class="nav child_menu" style="display: none">
							<li><a href="renewal.htm?id=${param['id']}">Renewal</a></li>
							<li><a href="modification.htm?id=${param['id']}">Modification</a></li>
							<li><a href="appeal.htm?id=${param['id']}">Appeal</a></li>
							<li><a href="cofc.htm?id=${param['id']}">CofC</a></li>
						</ul></li>
					<li><a href="getMap.htm"><i class="fa fa-list"></i>Map</a></li>
				</ul>
			</div>
		</div>
		<!-- /sidebar menu -->
	</div>
</div>

<!-- top navigation -->
<div class="top_nav">

	<!-- <div class="nav_menu">
		<nav class="" role="navigation">
			<div class="nav toggle">
				<a id="menu_toggle"><i class="fa fa-bars"></i></a>
			</div>

			<ul class="nav navbar-nav navbar-right">
				<li class="pull-left">
					<form action="searchApplication.htm" method="get">
					<div class="form-group top_search ">
						<div class="input-group">
							<input type="text" class="form-control" name="refNo" placeholder="Search for..." value="${sessionScope.SESSION_REF_NO}"> 
							<span class="input-group-btn">
								<button class="btn btn-success" type="submit">Go!</button>
							</span>
						</div>
					</div>
					</form>
				</li>
				<li class="">
					<a href="javascript:;"
					class="user-profile dropdown-toggle" data-toggle="dropdown"
					aria-expanded="false"> <img src="images/img.jpg" alt="">${sessionScope.SESSION_USER_DISPLAY_NAME}
					<span class=" fa fa-angle-down"></span>
					</a>
					<ul
						class="dropdown-menu dropdown-usermenu animated fadeInDown pull-right">
						<li><a href="userProfile.htm"> Profile</a></li>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<li><a href="registerUser.htm"> Create User</a></li>
							<li><a href="addCustomReport.htm"> Add Custom Reports</a></li>
						</sec:authorize>
						<li><a href="logout.htm"><i	class="fa fa-sign-out pull-right"></i> Log Out</a></li>
					</ul>
				</li>
				<li class="">
                    <a href="advanceSearch.htm"><i class="fa fa-search"></i> <span class="badge bg-green"> advance Search</span></a>
                </li>
			</ul>
		</nav>
	</div>-->

	<nav class="navbar navbar-default" role="navigation">
		<div class="container">
			<div class="nav toggle">
				<a id="menu_toggle"><i class="fa fa-bars"></i></a>
			</div>
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapsible">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button> 
			</div>

			<div class="navbar-collapse collapse" id="navbar-collapsible">

		<ul class="nav navbar-nav navbar-right">
 
				<li class="">
					<a href="javascript:;"
					class="user-profile dropdown-toggle" data-toggle="dropdown"
					aria-expanded="false"> <img src="images/img.jpg" alt="">${sessionScope.SESSION_USER_DISPLAY_NAME}
					<span class=" fa fa-angle-down"></span>
					</a>
					<ul
						class="dropdown-menu dropdown-usermenu animated fadeInDown pull-right">
						<li><a href="userProfile.htm"> Profile</a></li>
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<li><a href="registerUser.htm"> Create User</a></li>
							<li><a href="addCustomReport.htm"> Add Custom Reports</a></li>
						</sec:authorize>
						<li><a href="logout.htm"><i	class="fa fa-sign-out pull-right"></i> Log Out</a></li>
					</ul>
				</li>
				<li class="">
                    <a href="advanceSearch.htm"><i class="fa fa-search"></i> <span class="badge bg-green"> advance Search</span></a>
                </li>
			</ul>
					<form action="searchApplication.htm" method="get">
					<div class="form-group top_search ">
						<div class="input-group">
							<input type="text" class="form-control" name="refNo" placeholder="Search for..." value="${sessionScope.SESSION_REF_NO}"> 
							<span class="input-group-btn">
								<button class="btn btn-success" type="submit">Go!</button>
							</span>
						</div>
					</div>
					</form>

			</div>

		</div>
	</nav>


</div>
<!-- /top navigation -->