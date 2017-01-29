  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<head>

<script type="text/javascript">
function getGradeList(v){
		window.location="subjectdetails.htm?branch="+v+"";		
	}


	function getSubjectList(v){
		var s=document.getElementById("branch").value;
		
		window.location="subjectdetails.htm?branch="+s+"&grade_id="+v+"";		
	}

	function getTeacherDetailsToSubject(v){

		var branch=document.getElementById("branch").value;
		var grade=document.getElementById("grade_id").value;
		var subject=v;

		window.location="subjectdetails.htm?branch="+branch+"&grade_id="+grade+"&subject_id="+subject+"";	

		}

	function getStudentListUsingAcademicYear(v){
	//	alert(v);
		var ayear=v;
		var branch=document.getElementById("branch").value;
		var gradeId=document.getElementById("grade_id").value;
			
		window.location="classschedule_transfer.htm?branchId="+branch+"&gradeId="+gradeId+"&academic_year="+ayear+"";	
		 
		}

	</script>

</head>

<div class="page-title">
	<div class="title_left">
		<h3>
			Setup Subject
		</h3>
	</div>
</div>

<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h3>Setup Subject - Staff Assign/h3>
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<br />
   <form action="add_staff_to_subject.htm" modelAttribute="" method="post" >
   
   					<c:if test="${result=='added'}">
						<div class="alert alert-success">
	  						<strong>Success!</strong> Added New Subjects
						</div>			
						
					</c:if>
					
					<c:if test="${result=='failed'}">
						<div class="alert alert-danger">
  							<strong>Not Added!</strong> Please Check The Details
						</div>			
					
					
					</c:if>
  
  
   			<div class="row">
							<div class="col-xs-6 col-sm-2"> 	<span >Branch</span>	 </div>	    
								  <div class="col-xs-6 col-sm-4">
								  <select class="form-control" id="branch" onchange="getGradeList(this.value)" name="branch" >
										<c:if test="${exists==1}">
										<option value="0">SELECT</option>	
										</c:if>	
													
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
								  <select class="form-control" id="grade_id" onchange="getSubjectList(this.value)" name="grade_id" >
										<c:if test="${exists==2}">
										<option value="${grade.id}">${grade.grade}</option>	
										</c:if>	
																
										<c:forEach items="${gradeList}" var="g">
											<option value="${g.id}">${g.grade}</option>										
										</c:forEach>										
									</select>
							</div>								  
					</div>
					
					<br>					
					 <div class="row">
							<div class="col-xs-6 col-sm-2"> 	<span >Subjects</span>	 </div>	    
								  <div class="col-xs-6 col-sm-4">
								  <select class="form-control" id="subject_id" onchange="getTeacherDetailsToSubject(this.value)"  name="subject_id" >
																	
										<c:forEach items="${subjectList}" var="s">
											<option value="${s.id}">${s.subject}</option>										
										</c:forEach>										
									</select>
							</div>								  
					</div>
					
						<br>					
					 <div class="row">
							<div class="col-xs-6 col-sm-2"> 	<span >Teacher</span>	 </div>	    
								  <div class="col-xs-6 col-sm-4">
								  <select class="form-control" id="staff_id" onchange="getTeacherDetails(this.value)" name="staff_id" >
																	
										<c:forEach items="${teacherList}" var="t">
											<option value="${t.id}">${t.name} -${t.designation.designation}</option>										
										</c:forEach>										
									</select>
							</div>								  
					</div>
           
	       <br>
	    <div class="row">
            	<div class="col-xs-6 col-sm-2"> 	<span ></span>	 </div>	   
            	  <div class="col-xs-6 col-sm-4"> 
                 <button type="submit"  class="btn btn-default">Insert</button>
                </div>
            
         </div>
         
         
         <br>
         
         <c:if test="${staff==1}">
         
        <table class="table table-hover">
  				<tr>
  					<th>Staff ID</th>  	
  					<th>Title</th>			
  					<th>Staff Name</th>
  					<th>Address</th>
  					<th>Nic</th>
  					<th>Home Number</th>
  					<th>Mobile Number</th>
  					<th>Designation</th>
  					<th>Email</th>
  					<th>Join Date</th>	
  				</tr>
  				
  				<c:forEach items="${staffList}" var="p">
  					
  					<tr>
  						<td>${p.id}</td>
  						<td>${p.title}</td>
  						<td>${p.name}</td>
  						<td>${p.address}	</td>
  						<td>${p.nic}</td>
  						<td>${p.tel}</td>
  						<td>${p.mobile}</td>
  						<td>${p.designation.designation}	</td>
  						<td>${p.email}	</td>
  						<td>${p.jdate}	</td>
  								
  						
  							
  			</tr> 					 				
  				
  				</c:forEach>	
			</table>
         
         
         
         </c:if>
         
         
         
	
      
</form>
</div>
</div>
</div>
</div>
</body>
</html>
