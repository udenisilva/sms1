<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> 
<%@taglib uri="http://www.springframework.org/tags" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>   
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="col-md-3 left_col">
	<div class="left_col scroll-view">
		<div class="navbar nav_title" style="border: 0;">
			<a href="/olsims/" class="site_title"><i class="fa fa-area-chart"></i> <span>STUDENT</span></a>
		</div>
		<div class="clearfix"></div>

		<br />

		<!-- sidebar menu -->
		<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

			<div class="menu_section">
				<h3><spring:message code="site.logo" /></h3><br> <br>
				
				<ul class="nav side-menu">
					<li><a href="/olsims/"><i class="fa fa-home"></i> <spring:message code="lable.dashboard.home" /></a></li>
					<li><a href="#"><i class="fa fa-edit"></i><span class="fa fa-chevron-down"></span></a>
						<ul class="nav child_menu" style="display: none">
							<li><a href="#"><spring:message code="lable.dashboard.lab.form" /></a></li>						 
						</ul>
					</li>
					 
					<!--  <li><a href="#"><i class="fa fa-refresh"></i><span class="fa fa-chevron-down"></span></a>
						<ul class="nav child_menu" style="display: none">
							<li><a href="#?id=${param['id']}"> </a></li>
							 
						</ul>
					</li>-->
					  <li><a   href="SetupSchool.htm">Setup School</a></li>
				      <li><a   href="StudentProfile.htm">Student Profile</a></li>  
				      <li><a   href="ParentDetails.htm">Parent Details</a></li>    
				      <li><a  href="StudentPayment.htm">Student Payment</a></li>
				      <li><a   href="StudentAttendance.htm">Student Attendance</a></li>
				      <li><a   href="StaffProfile.htm">Staff Profile</a></li>
				      <li><a   href="classschedule.htm">Class Schedule</a></li>
				      <li><a  href="SubjectDetails.htm">Subject Details</a></li>
				      <li><a   href="Results.htm">Results</a></li>
				      <li><a   href="Message.htm">Message</a></li>    					
				<!--<li><a href="#"><i class="fa fa-list"></i><spring:message code="lable.dashboard.map" /></a></li> -->
				</ul>
			</div>
		</div>
		<!-- /sidebar menu -->
	</div>
</div>

<!-- top navigation -->
<div class="top_nav">

	<div class="nav_menu">
		<nav class="" role="navigation">
			<div class="nav toggle">
				<a id="menu_toggle"><i class="fa fa-bars"></i></a>
			</div>

			 <ul class="nav navbar-nav navbar-right">
				<!-- <li class="pull-left">
					<form class="navbar-form" action="searchApplication.htm" method="get">
					<div class="form-group top_search ">
						<div class="input-group">
							<input type="text" class="form-control" name="refNo" placeholder="Search for..." value="${sessionScope.SESSION_REF_NO}"> 
							<span class="input-group-btn">
								<button class="btn btn-success" type="submit">Go!</button>
							</span>
						</div>
					</div>
					</form>
				</li>-->
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
						</sec:authorize>
						<li><a href="logout.htm"><i	class="fa fa-sign-out pull-right"></i> Log Out</a></li>
					</ul>
				</li>
			<!--  	<li class="">
                    <a href="advanceSearch.htm"><i class="fa fa-search"></i> <span class="badge bg-green"> <spring:message code="site.advance.search" /></span></a>
                </li>-->
			</ul>
		</nav>
	</div>

</div>
<!-- /top navigation -->