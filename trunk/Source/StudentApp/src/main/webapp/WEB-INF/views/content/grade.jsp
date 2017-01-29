  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<head>
<script>

	function getGradeNameValue(vales){

		var gname=vales;
		var gclass=document.getElementById("grade_class").value;
		document.getElementById("grade").value="GRADE "+gclass+"-"+gname
		document.getElementById("grade_label").value="GRADE "+gclass+"-"+gname

	}


</script>
</head>



<div class="page-title">
	<div class="title_left">
		<h3>
			New Grade
		</h3>
	</div>
</div>

<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h3>New Grade</h3>
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
			
			<form:form action="select_branch_to_grade.htm" method="post">

	
	
	        	<c:if test="${result=='add'}">
	        
	        		<div class="alert alert-success">
	  						<strong>Success!</strong> Added New Grade
					</div>			
						
	        	</c:if>
	        	
	        	<c:if test="${result=='failed'}">
	        		
	        		<div class="alert alert-danger">
	  						<strong>Failed!</strong>Add New Grade
					</div>	
	        	</c:if>
	        	<c:if test="${result=='exists'}">
	        		<div class="alert alert-warning">
	  						<strong>Exists!</strong> New Grade Is Exists ,Please Add New Grade
					</div>	
	        	</c:if>
	         </div>
	 
		
			
				 <div class="row">
				 	<div class="col-10">				 
					 	 <div class="col-xs-6 col-sm-2">
		         			<span >Branch</span>	  
		         		</div>      
	         
						 <div class="col-xs-6 col-sm-4">
							<select class="form-control" id="branchId" name="branchId">
								<c:forEach var="b" items="${branchList}">
									<option value="${b.id}">${b.name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					
					<div class="col-10">	
							 <div class="col-xs-6 col-sm-2">
		         		  			<button class="btn btn-success" type="submit">
									<i class="fa fa-share"></i>
									<spring:message code='find.button.label' />
								</button>
		         			</div>		         		
					</div>
					
					</div>						

		</form:form>
		<hr>
		
	
   <form action="add_grade.htm" modelAttribute="Grade" method="post" >
  
  	<h3><label class="label label-success"> ${msg} </label></h3>
  	
  	<div class="row">
	         <div class="col-xs-6 col-sm-2"> 	<span >Branch ID</span>	 </div>	         
	          <div class="col-xs-6 col-sm-4">
	             <input class="form-control" maxlength="20" required="true"  type="hidden" id="branch.id" name="branch.id" value="${Grade.branch.id}" />
	              <input class="form-control" maxlength="20"  type="hidden" id="versionId" name="versionId" value="${Grade.versionId}" />
	         	  	<label class="label label-default">	      ${Grade.branch.id} </label>
	         </div>
	  </div>
	     
	       <br>
	    <div class="row">
	         <div class="col-xs-6 col-sm-2"> 	<span >Branch Name</span>	 </div>	         
	          <div class="col-xs-6 col-sm-4">
	           	<label class="label label-default">	      ${Grade.branch.name} </label>
	         </div>
	     </div>
	     
	     <br>
	    <div class="row">
	           <div class="col-xs-6 col-sm-2"> 	<span >New Grade Code</span> </div>	  
	         <div class="col-xs-6 col-sm-1">
	         	<label class="label label-default">	    GRADE- </label>
	         </div>
	         
	           <div class="col-xs-6 col-sm-1">
	         <select class="form-control" id="grade_class" id="grade_class" required="true"    >
	         	<option value="1">1</option>
	         	<option value="2">2</option>
	         	<option value="3">3</option>
	         	<option value="4">4</option>
	         	<option value="5">5</option>
	         	<option value="6">6</option>
	         	<option value="7">7</option>
	         	<option value="8">8</option>
	         	<option value="9">9</option>
	         	<option value="10">10</option>
	         	<option value="11">11</option>
	         	<option value="12">12</option>
	         	<option value="13">13</option>	         
	         </select>
	         
	         </div>
	          <div class="col-xs-6 col-sm-1">
	          <select class="form-control" id="grade_name" id="grade_name" required="true" onclick="getGradeNameValue(this.value)">
	         	<option value="A">A</option>
	         	<option value="B">B</option>
	         	<option value="C">C</option>
	         	<option value="D">D</option>
	         	<option value="E">E</option>
	         	<option value="F">F</option>	         	
	         </select>
	          </div>
	           <div class="col-xs-6 col-sm-3">
	           
	           <input class="form-control" maxlength="250"  required="true"  enabled="false" readonly="true"  type="text" id="grade_label" name="grade_label" value="${Grade.grade}" />
	             <input class="form-control" maxlength="250"    type="hidden" id="grade" name="grade" value="${Grade.grade}" />
	          </div>  
	      
	     </div>
	     
	     <br>
	
	    <div class="row">
              <div class="col-xs-6 col-sm-2"> 	 </div>	  
              <div class="col-xs-6 col-sm-4">   
                 <button type="submit" class="btn btn-success">Insert</button>
                 
           </div>	
         </div>
	  
	</form>	
			
		<hr>
	<label class="label label-success"> Grade  DETAILS</label>
	<br>
	
	
 		<div class="row">
 			<table class="table table-hover">
  				<tr>
  					<th>Branch ID</th>
  					<th>Branch Name</th>
  					<th>Grade Id</th>
  					<th>Grade</th>
  					<th>Version ID</th>  				
  					<th>Update</th>
  					
  				</tr>
  				
  				<c:forEach items="${gradeList}" var="p">
  					
  					<tr>
  						<td>${p.branch.id}</td>
  						<td>${p.branch.name}</td>
  						<td>${p.id}</td>
  						<td>${p.grade}	</td>
  						<td>${p.versionId}</td>  					
  						<td><span class="label label-danger"> <a href="remove_grade_details.htm?branch_id=${p.branch.id}&grade_id=${p.id}" style="color: white;"> remove </a> </span>	</td>
  						
  						
  					</tr>
  					
  				
  				
  				</c:forEach>
  				
  				
  				
			</table>
 
 		</div>	
			
	
	
</div>
</div>
</div>
</div>
</body>
</html>
