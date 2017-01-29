
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

   <script type="text/javascript">
            // When the document is ready
            $(document).ready(function () {
                
            //    $('#date').datepicker({
             //       format: "yy-mm-dd"
             //   });  

                $("#date").datepicker({ dateFormat: 'yy-mm-dd' });
            
            });
        </script>
	
<div class="page-title">
	<div class="title_left">
		<h2>Student Attendance</h2>
	</div>
</div>

<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<br />

				<form action="addattendance.htm" modelAttribute="attendancea"  method="post">
					
						 <div class="row">
						  <div class="col-10">
						 
							<div class="col-xs-6 col-sm-1"> 	<span >Branch</span>	 </div>	    
								  <div class="col-xs-6 col-sm-3">
									<select class="form-control" id="branch"
										onchange="this.options[this.selectedIndex].value && (window.location = this.options[this.selectedIndex].value);"
										name="branch.id" style="width: 100">
										<option value="">----Select----</option>
										
										<c:forEach items="${branchs}" var="branch">
											<c:choose>
												<c:when test="${branch.id == branchId}">
													<option value="studentattendance.htm?branchId=${branch.id}"
														selected="selected">${branch.code}</option>
												</c:when>
												<c:otherwise>
													<option value="studentattendance.htm?branchId=${branch.id}">${branch.code}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
										
									</select>
								</div>
							</div>
							
							<div class="col-10">
							
							
								<div class="col-xs-6 col-sm-1"> 	Grade	 </div>
								    
							 <input class="form-control" maxlength="10"
								width="300px" style="width: 100px" type="hidden" id="grade"
								name="grade.id" value="${gradeId}" />
								
							   <div class="col-xs-6 col-sm-3">
									<select class="form-control" id="gradec"
										name="gradec.id"
										onchange="this.options[this.selectedIndex].value && (window.location = this.options[this.selectedIndex].value);"
										style="width: 100">
										<option value="">----Select----</option>

										<c:forEach items="${grades}" var="grade">
											<c:choose>
												<c:when test="${grade.id == gradeId}">
													<option
														value="studentattendance.htm?branchId=${branchId}&gradeId=${grade.id}"
														selected="selected">${grade.grade}</option>
												</c:when>
												<c:otherwise>
													<option
														value="studentattendance.htm?branchId=${branchId}&gradeId=${grade.id}">${grade.grade}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
										
									</select>
								</div>
							
							
							</div>
							
						</div>
						
						<br>
						
										

						 <div class="row">
							 <div class="col-xs-6 col-sm-1"> 	<span >Date</span> </div>	
							  <div class="col-xs-6 col-sm-3">  	
								 <input type="date" class="form-control" required="true"  id="date"
									name="date" onchange="dateOnblur(this.value)" value="${datez}" />
							</div>
						</div>
						
						<br>
						
						 <div class="row">
							 <div class="col-xs-6 col-sm-1"> 	<span ></span> </div>	
							  <div class="col-xs-6 col-sm-3">  
								<input type="button"  class="btn btn-success" value="Find" onclick="getAllDetails()" >
							</div>
						</div>
						
			
				    
				             			
						<hr>
						
						 <div class="row">
							 <div class="col-xs-6 col-sm-2"> 	<span ></span> </div>	
							  <div class="col-xs-6 col-sm-4">  	
								 
								<label class="label label-success"> View Attendance  </label>							

							</div>
						</div>
						
						<br>
						
						<table id="myTable1" class="table table-striped" >
						
							
								<tr>
									<th>Student ID</th>
									<th>Student Code</th>
									<th>Student Name</th>
									<th>Present / Absent</th>
									
								</tr>
						
							
							
						
							
								<c:if test="${check==1}">
									<c:forEach items="${students}" var="student" varStatus="loop">													
										<tr>
												<td> ${student.id}  </td>
													<td>${student.code}<input class="form-control"
														type="hidden" id="studentId"
														name="attendance[${loop.index}].student.id"
														value="${student.id}" style="width: 180%" />
													</td>
													<td>${student.name}</td>
													<td>
														<div class="Status">
															<select class="btn btn-default dropdown-toggle"
																name="attendance[${loop.index}].status" id="status"
																style="width: 200">
																<c:forEach items="${status}" var="statu">
																	<option value="${statu}">${statu}</option>
																</c:forEach>
															</select>
														</div>
													</td>												
										</tr>									
									</c:forEach>
								</c:if>
								
								<c:if test="${check==2}">
								
								<c:forEach items="${attendances}" var="attendance" varStatus="loop">													
										<tr>
												<td> ${attendance.student.id}  </td>
													<td>${attendance.student.code}<input class="form-control"
														type="hidden" id="studentId"
														name="attendance[${loop.index}].student.id"
														value="${attendance.student.id}" style="width: 180%" />
													</td>
													<td>${attendance.student.name}</td>
													<td>
														<div class="Status">
																	<select class="btn btn-default dropdown-toggle"
																		name="attendance[${loop.index}].status" id="status"
																		style="width: 200">
																		<c:forEach items="${status}" var="statu">
																			<c:choose>
																				<c:when test="${statu == attendance.status}">
																					<option value="${statu}" selected="selected">${statu}</option>
																				</c:when>
																				<c:otherwise>
																					<option value="${statu}">${statu}</option>
																				</c:otherwise>
																			</c:choose>
																		</c:forEach>
																	</select>
																</div>
													</td>												
										</tr>									
									</c:forEach>
								
								
								</c:if>
							
						</table>
						<P></P>

					
					<br>

					<div class="row"> 
						  <div class="col-xs-6 col-sm-2"> </div>	
						    <div class="col-xs-6 col-sm-4">
								<button type="submit" class="btn btn-success">Insert / Update</button>
						 </div>
					</div>
					
				</form>
			</div>
		</div>
	</div>
</div>

</body>
	<script type="text/javascript">
					function dateOnblur(date) {
						window.location="studentattendance.htm?branchId="+${branchId}+"&gradeId="+${gradeId}+"&date="+date;
					}

					function getAllDetails(){
						var d=document.getElementById("date").value;
						window.location="studentattendance.htm?branchId="+${branchId}+"&gradeId="+${gradeId}+"&date="+d;
									     
						}
	</script>
</html>