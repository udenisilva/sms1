
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<div class="page-title">
	<div class="title_left">
		<h3>
			Parent Details
		</h3>
	</div>
</div>

<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h3>Setup Parent Details</h3>
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<br />
				<form action=".htm" modelAttribute="" method="post">

					<div style="float: center; width: 500px; margin-top: 20px">
						<div align="left">
							<span
								style="float: left; width: 150px; font: Arial, Helvetica, sans-serif; color: #039;">Student
								ID</span> <span> <input class="form-control" maxlength="20"
								style="width: 200px" type="text" id="szStuID" name="szStuID" />
							</span>
						</div>
						<p></p>
						<div align="left">
							<span
								style="float: left; width: 150px; font: Arial, Helvetica, sans-serif; color: #039;">Address</span>
							<textarea class="form-control" rows="5" style="width: 220px"
								id="Address"></textarea>
						</div>
						<p></p>
						<h4 style="color: #039; background-color: rgba(0, 0, 255, 0.3);">Mother
							Details</h4>
						<div align="left">
							<span
								style="float: left; width: 150px; font: Arial, Helvetica, sans-serif; color: #039;">Mother
								Name</span> <span> <input class="form-control" maxlength="20"
								style="width: 300px" type="text" id="szMoID" name="szMoID" />
							</span>
						</div>
						<p></p>
						<div align="left">
							<span
								style="float: left; width: 150px; font: Arial, Helvetica, sans-serif; color: #039;">Mother
								NIC</span> <span> <input class="form-control" maxlength="20"
								style="width: 200px" type="text" id="szMoNic" name="szMoNic" />
							</span>
						</div>
						<p></p>
						<p></p>
						<div align="left">
							<span
								style="float: left; width: 150px; font: Arial, Helvetica, sans-serif; color: #039;">Emergency
								Number</span> <span> <input class="form-control" maxlength="10"
								width="100px" style="width: 100px" type="number" id="szMoHoNo"
								name="szMoHoNo" />
							</span>
						</div>
						<p></p>
						<div align="left">
							<span
								style="float: left; width: 150px; font: Arial, Helvetica, sans-serif; color: #039;">Mobile
								Number</span> <span> <input class="form-control" maxlength="10"
								width="100px" style="width: 100px" type="number" id="dSMobNo"
								name="dMobNo" />
							</span>
						</div>
						<p></p>
						<div align="left">
							<span
								style="float: left; width: 150px; font: Arial, Helvetica, sans-serif; color: #039;">Email</span>
							<span> <input class="form-control" maxlength="50"
								style="width: 200px" type="email" id="szMoEmail"
								name="szMoEmail" />
							</span>
						</div>
						<p></p>
						<h4 style="color: #039; background-color: rgba(0, 0, 255, 0.3);">Father
							Details</h4>
						<div align="left">
							<span
								style="float: left; width: 150px; font: Arial, Helvetica, sans-serif; color: #039;">Father
								Name</span> <span> <input class="form-control" maxlength="20"
								style="width: 300px" type="text" id="szFaID" name="szFaID" />
							</span>
						</div>
						<p></p>
						<div align="left">
							<span
								style="float: left; width: 150px; font: Arial, Helvetica, sans-serif; color: #039;">Father
								NIC</span> <span> <input class="form-control" maxlength="20"
								style="width: 200px" type="text" id="szFaNic" name="szFaNic" />
							</span>
						</div>
						<p></p>
						<p></p>
						<div align="left">
							<span
								style="float: left; width: 150px; font: Arial, Helvetica, sans-serif; color: #039;">Emergency
								Number</span> <span> <input class="form-control" maxlength="10"
								width="100px" style="width: 100px" type="number" id="szMoHoNo"
								name="szMoHoNo" />
							</span>
						</div>
						<p></p>
						<div align="left">
							<span
								style="float: left; width: 150px; font: Arial, Helvetica, sans-serif; color: #039;">Mobile
								Number</span> <span> <input class="form-control" maxlength="10"
								width="100px" style="width: 100px" type="number" id="dSMobNo"
								name="dMobNo" />
							</span>
						</div>
						<p></p>
						<div align="left">
							<span
								style="float: left; width: 150px; font: Arial, Helvetica, sans-serif; color: #039;">Email</span>
							<span> <input class="form-control" maxlength="50"
								style="width: 200px" type="email" id="szMoEmail"
								name="szMoEmail" />
							</span>
						</div>
						<p></p>
						<div align="left">
							<span style="float: left; width: 150;">&nbsp;</span> <span>
								<button type="button" class="btn btn-default">Insert</button>
							</span> <span style="float: left; width: 150px;">&nbsp;</span> <span>
								<button type="button" class="btn btn-default">Reset</button>
							</span>
						</div>
					</div>

				</form>
			</div>
		</div>
	</div>
</div>

</body>
</html>