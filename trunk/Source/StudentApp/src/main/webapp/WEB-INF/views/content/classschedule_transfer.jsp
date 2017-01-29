 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="page-title">
	<div class="title_left">
	
	</div>
</div>


<head>

   <script type="text/javascript">
            // When the document is ready
            $(document).ready(function () {
                
            //    $('#date').datepicker({
             //       format: "yy-mm-dd"
             //   });  

                $("#date").datepicker({ dateFormat: 'yy-mm-dd' });
            
            });
        </script>

<script>
	function getGradeList(v){
		window.location="classschedule_transfer.htm?branchId="+v+"";		
	}

	function getStudentList(v){
		var s=document.getElementById("branch").value;
		
		window.location="classschedule_transfer.htm?branchId="+s+"&gradeId="+v+"";		
	}

	function getStudentListUsingAcademicYear(v){
	//	alert(v);
		var ayear=v;
		var branch=document.getElementById("branch").value;
		var gradeId=document.getElementById("grade_id").value;
			
		window.location="classschedule_transfer.htm?branchId="+branch+"&gradeId="+gradeId+"&academic_year="+ayear+"";	
		 
		}
	

	function check_warning(v){
		var transfer_year=parseInt(v);
		var current_year=parseInt(document.getElementById("academic_year").value);

		if(transfer_year>current_year) {
				document.getElementById("btn_submit").disabled=false;
			}else{
				document.getElementById("btn_submit").disabled=true;
				toastr.warning(" Transfer Year Should Be Greater Than Current Year");		
				}



		}
	

</script>

</head>


<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h3>Class Schedule</h3>
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<br />

	<form action="add_class_schedule_transfer.htm" modelAttribute="classschedule" method="get" >
	
	 				 <div class="row">
							<div class="col-xs-6 col-sm-2"> 	<span >Branch</span>	 </div>	    
								  <div class="col-xs-6 col-sm-4">
								  <select class="form-control" id="branch" onchange="getGradeList(this.value)" name="branch.id" >
												<option value="${selectBranch.id}">${selectBranch.code}</option>						
										<c:forEach items="${branchList}" var="branch">
											<option value="${branch.id}">${branch.code}</option>										
										</c:forEach>										
									</select>
							</div>								  
					</div>
					
					<br>					
					 <div class="row">
							<div class="col-xs-6 col-sm-2"> 	<span >Grade</span>	 </div>	    
								  <div class="col-xs-6 col-sm-4">
								  <select class="form-control" id="grade_id" onchange="getStudentList(this.value)" name="grade.id" >
									<option value="${selectGrade.id}">${selectGrade.grade}</option>									
										<c:forEach items="${gradeList}" var="g">
											<option value="${g.id}">${g.grade}</option>										
										</c:forEach>										
									</select>
							</div>								  
					</div>
				
			
	     			<br>
	     
				   	 <div class="row">
				       <div class="col-xs-6 col-sm-2"> 	<span >Academic Year</span>	 </div>	   
				        <div class="col-xs-6 col-sm-4">
				          
						    <select id="academic_year" name="academic_year" onchange="getStudentListUsingAcademicYear(this.value)"  class="form-control">
						    	<option value="${selectYear}">${selectYear} </option>
						    	<option value="0">SELECT </option>
						    	<option value="2015">2015 </option>
						    	<option value="2016">2016 </option>
						    	<option value="2017">2017 </option>
						    	<option value="2018">2018 </option>
						    	<option value="2019">2019 </option>
						    	<option value="2020">2020 </option>
						    	<option value="2021">2021 </option>
						    	<option value="2022">2022 </option>
						    	<option value="2023">2023 </option>
						    	<option value="2024">2024 </option>
						    	<option value="2025">2025 </option>
						    	<option value="2026">2026 </option>			    
						    </select>
						   
				        </div>
				     </div>
	     
	  			   <br>
	  			   
	  			 
	  			   
	     
			      <div class="row">
			       <div class="col-xs-6 col-sm-2"> 	<span ></span>	 </div>	   
			        <div class="col-xs-6 col-sm-4">
			        	<input type="submit" class="btn btn-success" value="Find">
			        </div>
			        </div>
			        
			        <br>
			           <div class="row">
			       <div class="col-xs-6 col-sm-2"> 	<span ></span>	 </div>	   
			        <div class="col-xs-6 col-sm-4">
			       		 <c:if test="${result=='exists_same_year'} ">
			        		<h3> <label class="label label-warning"> Cannot Proceed ,Same Year Exists ,Please Try Again  </label> </h3>
			        	</c:if>
			        	 <c:if test="${result=='added'} ">
			        		<h3> <label class="label label-success"> Student Transfered Successfully  </label> </h3>
			        	</c:if>
			        	 <c:if test="${result=='select_grade'} ">
			        		<h3> <label class="label label-warning"> Please Select Next Grade  </label> </h3>
			        	</c:if>
			        	
			        		
			        		
			        </div>
			        </div>
	     
	   
		<br>

	     <table id="myTable1" class="table table-striped table-bordered" cellspacing="0" width="100%">
                    
                        <tr>
                            <th>Student ID</th>
                            <th>Student Code</th>   
                               <th>Student Name</th>
                               <th>Status</th>
                               <th>Remarks</th>                                
                        </tr>
                        
                        <tbody>
								<c:forEach items="${classSchedulesList}" var="classSchedulesList" varStatus="loop">
								 	<tr>
									 	 <th>${classSchedulesList.student.id}
									 		 <input type="hidden" id="academicYear"	name="classSchedulesList[${loop.index}].academicyear" value="${classSchedulesList.academicyear}" />
									 		  <input type="hidden" id="id"	name="classSchedulesList[${loop.index}].id" value="${classSchedulesList.id}" />
									 	 	<input type="hidden" id="gradeId"	name="classSchedulesList[${loop.index}].grade.id" value="${classSchedulesList.grade.id}" />
									 	 	<input type="hidden" id="studentId"	name="classSchedulesList[${loop.index}].student.id" value="${classSchedulesList.student.id}" />
									 	 	<input type="hidden" id="versionId"	name="classSchedulesList[${loop.index}].versionId" value="${classSchedulesList.versionId}" />
									 	 </th>
	                            		 <th>${classSchedulesList.student.code}</th>    
	                            		 <th>${classSchedulesList.student.name}</th>
	                            		 <th>
	                            		 
											<select class="form-control" name="classSchedulesList[${loop.index}].status" id="status" >
													<c:forEach items="${status}" var="statu">
														<c:choose>
															<c:when test="${statu == classSchedulesList.status}">
																<option value="${statu}" selected="selected">${statu}</option>
																111111111111
															</c:when>
															<c:otherwise>
																<option value="${statu}">${statu}</option>
																22222222222
															</c:otherwise>
														</c:choose>
													</c:forEach>
											</select>
											
											 <th> <input type="text" id="remarks" name="classSchedulesList[${loop.index}].remarks" value="${classSchedulesList.remarks}" class="form-control"> </th>
										         		
                            		</tr>   
								</c:forEach>
								
						</tbody>
                   
                </table>
                
                  	<br>
	     
				   	 <div class="row">
				       <div class="col-xs-6 col-sm-2"> 	<span >Next Academic Year</span>	 </div>	   
				        <div class="col-xs-6 col-sm-4">
				          
						    <select id="next_academic_year" name="next_academic_year"  onchange="check_warning(this.value)"  class="form-control">						    	
						    	<option value="2015">2015 </option>
						    	<option value="2016">2016 </option>
						    	<option value="2017">2017 </option>
						    	<option value="2018">2018 </option>
						    	<option value="2019">2019 </option>
						    	<option value="2020">2020 </option>
						    	<option value="2021">2021 </option>
						    	<option value="2022">2022 </option>
						    	<option value="2023">2023 </option>
						    	<option value="2024">2024 </option>
						    	<option value="2025">2025 </option>
						    	<option value="2026">2026 </option>			    
						    </select>
						   
				        </div>
				     </div>
	     
	  			   <br>
	  			   
	  			   	 <div class="row">
				       <div class="col-xs-6 col-sm-2"> 	<span >Transfer Grade</span>	 </div>	    
								  <div class="col-xs-6 col-sm-4">
								  <select class="form-control" id="transfer_grade_id"  name="transfer_grade_id" >
																		
										<c:forEach items="${gradeList_trans}" var="g">
											<option value="${g.id}">${g.grade}</option>										
										</c:forEach>										
									</select>
							</div>		
				     </div>
				     
				     <br>
                
      
	   	 <div class="row">
             <div class="col-xs-6 col-sm-2"> 	 </div>	
              <div class="col-xs-6 col-sm-4">   
                 <button type="submit" id="btn_submit" name="btn_submit" disabled="true" class="btn btn-success">Transfer Students</button>
              </div>
           
         </div> 
   
    
	</form>
</div>
  </div>
   </div>
</div>

 