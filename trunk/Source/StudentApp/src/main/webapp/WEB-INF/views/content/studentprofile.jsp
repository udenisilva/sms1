  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="../commons/commonjs.jsp"%>

<head>
 <script type="text/javascript">
            // When the document is ready
            $(document).ready(function () {
                
            //    $('#date').datepicker({
             //       format: "yy-mm-dd"
             //   });  

                $("#joinDate").datepicker({ dateFormat: 'yy-mm-dd' });
                $("#leftDate").datepicker({ dateFormat: 'yy-mm-dd' });
            
            });
        </script>
	

</head>


<div class="page-title">
	<div class="title_left">
		
	</div>
</div>

<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h3>Student Profile</h3>
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<br />
				
   <form action="createStudent.htm" modelAttribute="student" method="post" >
    <h3>Setup Student Details - <label class="label label-success"> ${msg} </label></h3>
    <input class="form-control" type="hidden" id="id" name="id" value="${student.id}" hidden="true" />
        <div >
      
	     <div class="row">
	         <div class="col-xs-6 col-sm-2">
	         	<span >Branch</span>	  
	         </div>	         
	         
	           <div class="col-xs-6 col-sm-4">
			   		 <select class="form-control" required="true" id="branch" name="branch.id" style="width: 100">
			   			 <option value="${student.branch.id}">   ${student.branch.name}    </option> 
					    <c:forEach items="${branchs}" var="branch">
					    <option value="${branch.id}">${branch.code}</option> 
					    </c:forEach>
			   		 </select>
			  </div>     
	         
	     </div>
	       <input class="form-control" maxlength="20"  type="hidden" id="versionId" name="versionId" value="${student.versionId}" />
	       <input class="form-control" maxlength="20"  type="hidden" id="id" name="id" value="${student.id}" />
	     <br>
	     
	   
	       <br>
	    <div class="row">
	         <div class="col-xs-6 col-sm-2"> 	<span >Student code</span>	 </div>	         
	          <div class="col-xs-6 col-sm-4">
	           <label class="label label-info"> ${student.code} </label>
	             <input class="form-control" required="required" maxlength="20"  type="hidden" id="code" name="code" value="${student.code}" />
	         </div>
	     </div>
	     
	     <br>
	    <div class="row">
	    	<div class="col-10">
	    
		           <div class="col-xs-6 col-sm-2"> 	<span >Student Name</span> </div>	  
		         <div class="col-xs-6 col-sm-4">
		             <input class="form-control" maxlength="250" required="required"   type="text" id="name" name="name" value="${student.name}" />
		          </div>
	          
	          </div>  
	          
	          <div class="col-10">	          
	           <div class="col-xs-6 col-sm-2"> 	<span >Gender</span> </div>	  
	       		 <div class="col-xs-6 col-sm-4">	           
			    		<select class="form-control"  required="true"  id="gender" name="gender"  >  
			    				 <option value="${student.gender}">  ${student.gender}   </option> 
			   				 <c:forEach items="${genders}" var="gender">			    				
			   					  <option value="${gender}">${gender}</option> 
			   			 	</c:forEach>
			    		</select>
			  
	          		</div>  	          
	          </div> 
	     </div>
	     
	     <br>
	    
	    
	     <br>
	     
	    <div class="row"> 
	      <div class="col-10">	 
	          <div class="col-xs-6 col-sm-2"> 	<span >Joined Date</span> </div>	  
	        	 <div class="col-xs-6 col-sm-4">
	           		<input class="form-control" required="required"  type="text" id="joinDate" name="joinDate" value="${student.joinDate}"/>
	        	 </div>  
	         
	         </div> 
	         
	          <div class="col-10">	
		          <div class="col-xs-6 col-sm-2"> 	<span >Left Date</span> </div>	 
		         	  <div class="col-xs-6 col-sm-4"> 
		     			 <input class="form-control"   type="text" id="leftDate" name="leftDate" value="${student.leftDate}" />
		     	 </div>   
	          </div>
	     </div>
	     
	     
	     <br>
	    <div class="row">
	          <div class="col-xs-6 col-sm-2"> 	<span >Status</span> </div>	  
	         <div class="col-xs-6 col-sm-4">
	           
			    <select class="form-control" required="true" name="status" id="status"  >
			    	   <option value="${student.status}">  ${student.status}   </option> 
			   				<c:forEach items="${status}" var="statu">		
			   					  <option value="${statu}">${statu}</option> 
			  				  </c:forEach>
			  	</select>
			  </div>  
	         
	     </div>
	   
	     <br>
	    <div class="row">
              <div class="col-xs-6 col-sm-2"> 	 </div>	  
              <div class="col-xs-6 col-sm-4">   
                 <button type="submit" class="btn btn-primary">Insert</button>
                 
                 <form action="studentprofile.htm"  method="post" >
                 	<button type="button" class="btn btn-warning">New Student</button>
                 </form>
              
                
           </div>	
         </div>
	   </div>   
 </form>
 
 <hr>
	<label class="label label-warning"> STUDENT  DETAILS</label>
	
	
 		<div class="row">
 			<table class="table table-hover">
  				<tr>
  					<th>Student ID</th>
  					<th>Student Code</th>
  					<th>Student Name</th>
  					<th>Gender</th>
  					<th>Join Date</th>
  					<th>Left Date</th>
  					<th>Status</th>
  					<th>GRADE</th>
  					<th>Update</th>
  						<th>Add Grade</th>
  				</tr>
  				
  				<c:forEach items="${studentList}" var="p">
  					
  					<tr>
  						<td>${p.id}</td>
  						<td>${p.code}</td>
  						<td>${p.name}</td>
  						<td>${p.gender}	</td>
  						<td>${p.joinDate}</td>
  						<td>${p.leftDate}</td>
  						<td>${p.status}	</td>
  						<td>${p.grade.grade}	</td>
  						<td><span class="label label-success"> <a href="update_student_details.htm?id=${p.id}&code=${p.code}" style="color: white;"> update </a> </span>	</td>
  							<td><span class="label label-success"> <a href="view_grade_to_student.htm?id=${p.id}" style="color: white;"> update Grade </a> </span>	</td>
  						
  						
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