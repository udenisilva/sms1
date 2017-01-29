  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- my common function jsp -->
<%@ include file="../commons/commonjs.jsp"%>

<div class="page-title">
	<div class="title_left">
		<h3>
			New Subject
		</h3>
	</div>
</div>

<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h3>New Subject</h3>
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
     
     <form:form action="add_subject.htm" modelAttribute="subject" method="post" >
  
	        	<c:if test="${result=='success' }">
	        
	        		<div class="alert alert-success">
	  						<strong>Success!</strong> Added New Subject
					</div>			
						
	        	</c:if>
	        	
	        	<c:if test="${result=='failed' }">
	        		
	        		<div class="alert alert-danger">
	  						<strong>Failed!</strong>Add New Subject
					</div>	
	        	</c:if>
	
       
        
	      <input type="hidden" name="action" value="${action}" id="action">	      
	      <form:hidden path="id" name="id" id="id" />
	      <form:hidden path="versionId" name="versionId" id="versionId" />
	     <br>
	     <div class="row">
	          <div class="col-xs-6 col-sm-2"> 	<span >Subject Code</span>	 </div>	               
	          <div class="col-xs-6 col-sm-4">
	            	<label class="label label-default">	      ${subject.code} </label>
	          	<form:hidden path="code" class="form-control" id="subject_code" name="subject_code" />	
	          </div>    
	        
	     </div>
	     <br>
	       <div class="row">
	            <div class="col-xs-6 col-sm-2"> 	<span >Subject Name</span>	 </div>	   
	          <div class="col-xs-6 col-sm-4">           
			   <form:input path="subject" class="form-control"  required="true"   id="subject_subject" name="subject_subject" />
			     
	         </div>
	     </div>
	     
	     <br>
	       <div class="row">
	           <div class="col-xs-6 col-sm-2"> 	<span >Grade</span>	 </div>	   	         
	          <div class="col-xs-6 col-sm-4">      
	            
			   <form:select path="grade.id" required="true"   class="form-control" id="grade_id" name="grade_id">
			   			<option value="${grade.id}">${grade.grade}</option>
						<c:forEach var="b" items="${gradeList}">
							<option value="${b.id}">${b.grade}</option>
						</c:forEach>
				</form:select>
	         </div>
	     </div>
	     
	     <br>
	       <div class="row">
	           <div class="col-xs-6 col-sm-2"> 	<span >Branch</span>	 </div>	   	         
	          <div class="col-xs-6 col-sm-4">      
	            
			   <form:select path="branch.id" required="true"   class="form-control" id="branch_id" name="branch_id">
						<c:forEach var="b" items="${brLi}">
							<option value="${b.id}">${b.address}</option>
						</c:forEach>
				</form:select>
	         </div>
	     </div>
	    
	     
	  <br>
	    <div class="row">
             <div class="col-xs-6 col-sm-2"> 	 </div>	   	  
             <div class="col-xs-6 col-sm-4">      
                 <button type="submit" class="btn btn-success">Insert / Update</button>
              
         </div>
	   </div>   
      
</form:form>
<hr>

 <div class="row">
	           <div class="col-xs-6 col-sm-2"> 	<span ></span>	 </div>	   	         
	          <div class="col-xs-6 col-sm-4">  
	         <h3> <span class="label label-success">View All Subjects</span></h3>
	           </div>
	           
	            </div>    

  	<form action="select_branch_details.htm" method="get" >
      <div class="row">
	           <div class="col-xs-6 col-sm-2"> 	<span >Branch</span>	 </div>	   	         
	          <div class="col-xs-6 col-sm-4">      
	            
			   <select  class="form-control" id="branch_id" name="branch_id">
						<c:forEach var="b" items="${brLi2}">
							<option value="${b.id}">${b.address} - ${b.address}</option>
						</c:forEach>
				</select>
	         </div>
	         
	           <div class="col-xs-6 col-sm-4"> 
	             <button type="submit" class="btn btn-success">Find</button>
	              </div>
	     </div>
	</form>
  
  <table class="table table">
  	<tr>
	  	<td>Subject Id<td>
	  	<td>Subject code </td>
	  	<td>Subject Name </td>
	  	<td>Grade </td>
	  	<td>Location Name </td>
	  	<td>action </td>
  	
  	</tr>
  	
  	
  	<c:forEach items="${sLi}" var="s" >
  	  <tr>
  			
  			<td>  ${s.id} </td>
  			<td>  ${s.code} </td>
  			<td>  ${s.subject} </td> 
  			<td>  ${s.grade.grade} </td> 
  			<td>  ${s.branch.code} </td>
  			<td>  <a href="update_subject_details_view.htm?id=${s.id}">update </a> </td>  		 			
  		</tr>
  	
  	</c:forEach>
  	
  
  </table>

     
     
     
</div>
</div>
</div>

</body>
</html>
