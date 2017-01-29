  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="../commons/commonjs.jsp"%>

<head>
<script>

	function setGradeToText(vales){

	//alert(vales);
		document.getElementById("gradeId").value=vales;

	}

	

	

</script>
<script type="text/javascript">
            
            $(document).ready(function () {        

                $("#academic_year").datepicker({ dateFormat: 'yyyy' });
            
            });
        </script>
</head>



<div class="page-title">
	<div class="title_left">
		<h2>
			Add Student To Grade
		</h2>
	</div>
</div>

<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h3>  <label class="label label-success"> Grade Details </label></h3>
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<br />
				
   <form action="update_grade_to_student.htm" modelAttribute="student"  method="get" >

    <input class="form-control" type="hidden" id="id" name="id" value="${student.id}" hidden="true" />
        <div >
      
	     <div class="row">
	         <div class="col-xs-6 col-sm-2">
	         	<span >Branch</span>	  
	         </div>	         
	         
	           <div class="col-xs-6 col-sm-4">
			   		<label class="label label-default">	 ${student.branch.name}  </label>
			  </div>     
	         
	     </div>
	     
	     
	     <br>
	    <div class="row">
	    	<div class="col-10">
	    
		         <div class="col-xs-6 col-sm-2"> 	<span >Student ID</span>	 </div>	         
		          <div class="col-xs-6 col-sm-4">
		       	<label class="label label-default">	   ${student.id}</label>
		              <input maxlength="20"  type="hidden" id="versionId" name="versionId" value="${student.versionId}" />
		         </div>	         
	         </div>
	         
	         <div class="col-10">
	         	<div class="col-xs-6 col-sm-2"> 	<span >Student code</span>	 </div>	         
	         	 <div class="col-xs-6 col-sm-4">
	         		<label class="label label-default">		  ${student.code}</label>
	         	</div>
	         </div>
	     </div>
	     	     
	       <br>
	   
	    <div class="row">
	    
	    	 <div class="col-10">
	           <div class="col-xs-6 col-sm-2"> 	<span >Student Name</span> </div>	  
	         		<div class="col-xs-6 col-sm-4">
	         			<label class="label label-default">	    ${student.name}</label>
	         		 </div> 
	          
	          </div>  
	          
	           <div class="col-10">
	           		<div class="col-xs-6 col-sm-2"> 	<span >Gender</span> </div>	  
	    			    <div class="col-xs-6 col-sm-4">
	           
			 			<label class="label label-default">	  ${student.gender}</label>
			  
	         	 </div>   
	           </div>
	     </div>
	     
	     <br>
	    
	     
	    <div class="row"> 
	     <div class="col-10">
	          <div class="col-xs-6 col-sm-2"> 	<span >Joined Date</span> </div>	  
	         <div class="col-xs-6 col-sm-4">
	      	<label class="label label-default">	   ${student.joinDate}</label>
	         </div> 
	         
	         </div>
	         
	          <div class="col-10">
	           <div class="col-xs-6 col-sm-2"> 	<span >Left Date</span> </div>	 
	           <div class="col-xs-6 col-sm-4"> 
	    	<label class="label label-default">	 	${student.leftDate}</label>
	     	 </div>  
	          
	          </div>  
	     </div>
	     
	     <br>
	   
	    <div class="row">
	          <div class="col-xs-6 col-sm-2"> 	<span >Status</span> </div>	  
	         <div class="col-xs-6 col-sm-4">
	           
				<label class="label label-warning">	${student.status}  </label>
			  </div>  
	         
	     </div>
	    
	     <br> 
	      <div class="row">
	         <div class="col-10">	      
	           <div class="col-xs-6 col-sm-2"> 	<span >GRADE-</span> </div>
	         	  <div class="col-xs-6 col-sm-4">
			         <select class="form-control" required="true" id="grade_id" id="grade_id"  onclick="setGradeToText(this.value)"   >
			          	<option value="${grade.id}">${grade.grade}</option> 
			          	<option value="0">PLEASE SELECT</option> 			          
			               <c:forEach items="${gradeList}" var="g">			    	
					    		 <option value="${g.id}">${g.grade}</option> 
					   		</c:forEach>  
			         </select>	         
	       		  <input type="hidden" id="gradeId" name="gradeId">
	         
	         	</div>
	         </div>
	         	         	
	         <div class="col-10">
	         	 <div class="col-xs-6 col-sm-2"> 	<span >Academic Year</span> </div>	  
	       			  <div class="col-xs-6 col-sm-4">	           
	           			<input  class="form-control" type="number" required="true" id="academic_year" value="${current_academic_year}" name="academic_year"/>
					  </div>  
	    	 </div>	         	
	       </div>
	     </div>
	   
	     <br>
	     <c:if test="${exists_grade=='no'}">
		       
		    <div class="row">
	              <div class="col-xs-6 col-sm-2"> 	 </div>	  
	              <div class="col-xs-6 col-sm-4">   
	                 <button type="submit" class="btn btn-primary">Update</button>
	               
	                
	                
	           </div>	
	         </div>
         
           </c:if>
           
             <c:if test="${exists_grade=='yes'}">
              <div class="row">
	              <div class="col-xs-6 col-sm-2"> 	 </div>	  
	              <div class="col-xs-6 col-sm-4">   
	                 <label class="label label-warning"> Grade Is Aleardy Added ,Please Go To The Class Transfer Form </label>
	               
	                
	                
	           </div>	
	         </div>
                </c:if>
	 
	   </div>
   </form>
 

</div>
</div>
</div>
</div>
</body>
</html>