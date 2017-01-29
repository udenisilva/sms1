  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ include file="../commons/commonjs.jsp"%>

<head>

<script>
	function checkAmount(amount){		
			if(!isNaN(parseFloat(amount))){
				document.getElementById("add_btn").disabled=false;
			}else{
				document.getElementById("add_btn").disabled=true;
				 toastr.warning("Please Enter Correct Amount");
				
			}
	}
</script>

</head>

<div class="page-title">
	<div class="title_left">
		<h2>
			Student Payments
		</h2>
	</div>
</div>

<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h3>Student Payments</h3>
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
			
			<div class="form-group">
				<c:if test="${result=='NOT_Exists'}">
					<label class="label label-warning"> Student Is Not Exists ,Please try Again </label>
				</c:if>
				
				<c:if test="${result=='Exists'}">
				<label class="label label-success">Student Is  Exists</label>
				</c:if>
			</div>
			
			<div class="form-group">
				<c:if test="${result=='added'}">
					<label class="label label-success"> Add New Student Payment Successfully </label>
				</c:if>
				
				<c:if test="${result=='failed'}">
				<label class="label label-failed"> Failed New Payment Details</label>
				</c:if>
			</div>
			
			<div class="form-group">
				<c:if test="${result=='removed'}">
					<label class="label label-success"> Student Payment Removed </label>
				</c:if>
								
				<c:if test="${result=='removed_failed'}">
				<label class="label label-failed"> Student Payment Removed Failed</label>
				</c:if>
			</div>
			
			<div class="form-group">
				<c:if test="${result=='check_field'}">
					<label class="label label-warning"> Please Check Fields Again</label>
				</c:if>
								
				
			</div>
			
				<br />
				
		<form action="payment_select_student_details.htm"  method="post" > 
        	
         		<div class="row">
         			<div class="col-xs-6 col-sm-4">
         				<span >Student ID</span>	   
         			</div>
	         		<div class="col-xs-6 col-sm-4">  
	         		    <input  class="form-control" required="true"  placeholder="student_id" type="text" id="student_id" name="student_id" />
	         		</div> 
	         			<div class="clearfix visible-xs-block"></div>
  					<div class="col-xs-6 col-sm-4"> 	
  						<input type="submit"  value="Find" class="btn btn-submit" />
  					</div>	         	
	     		</div>
	     	
	     </form>
				
		<br>
		<hr>
				
   <form:form action="student_payment_new.htm"  method="post" > 
       
       <div class="row">
	        	<div class="col-xs-6 col-sm-4">
         				<span >Student ID</span>	   
         			</div>	         
	        	<div class="col-xs-6 col-sm-4">
         					<label class="label label-default" > ${student.id} </label>	   
         			</div>	 	          
	             <input type="hidden" id="student_id" name="student_id"   value="${student.id}" />	        
	     </div>
	     
	    <div class="row">
	        	<div class="col-xs-6 col-sm-4">
         				<span >Student Code & Name</span>	   
         			</div>	         
	        	<div class="col-xs-6 col-sm-4">
         				<label class="label label-default" >   ${student.code} -   ${student.name} </label>	   
         			</div>	 	          
	                     
	     </div>
	 
		<br> 
		
		 <div class="row">
	        	<div class="col-xs-6 col-sm-4">
         				<span >Academic Year</span>	   
         			</div>	         
	        	<div class="col-xs-6 col-sm-4">
         			<select id="academicyear" name="academicyear" required="true"  class="form-control" aria-labelledby="menu1">
						 
						  <c:if test="${yearList!=0}" >  
						  <option value="${yearList}">${yearList}</option>
						  </c:if>						  
						    <option value="2010">2010</option>
						    <option value="2011">2011</option>
						    <option value="2012">2012</option>
						    <option value="2013">2013</option>
						    <option value="2014">2014</option>
						    <option value="2015">2015</option>
						    <option value="2016">2016</option>
						    <option value="2017">2017</option>
						    <option value="2018">2018</option>
						    <option value="2019">2019</option>
						    <option value="2020">2020</option>
						  
					</select>
         			</div>	 	          
	                    
	     </div>
	     <br>
	     
	     	 <div class="row">
	        	<div class="col-xs-6 col-sm-4">
         				<span >Payment Type</span>	   
         			</div>	         
	        	<div class="col-xs-6 col-sm-4">
         			<select id="paymentType" required="true" name="paymentType"  class="form-control" aria-labelledby="menu1">
						  <option value="Admission_Fee" >Admission_Fee</option>
						  <option value="Semester_Fee">Semester_Fee</option>
						  <option value="Repeat_Exam_Fee">Repeat_Exam_Fee</option>
						  <option value="Other_Payment">Other Payment</option>
						  
					</select>
         			</div>	 	          
	                    
	     </div>
	     
	     <br>
	     
	  <div class="row">
	        	<div class="col-xs-6 col-sm-4">
         				<span >Amount</span>	   
         			</div>	         
	        	<div class="col-xs-6 col-sm-4">
         		  <input type="text" id="amount" name="amount"  onkeypress="checkAmount(this.value);" required="true" class="form-control"  placeholder="Amount"  />
         			</div> 	          
	                    
	     </div>
	     
	     <br>
	     
	       <div class="row">
	        	<div class="col-xs-6 col-sm-4">
         				<span >Payment Date</span>	   
         			</div>	         
	        	<div class="col-xs-6 col-sm-4">
	        		<label class="label label-default">	${curDate}</label>
         		  <input type="hidden" id="paymentDate" name="paymentDate" value="${curDate}"  placeholder="paymentDate"  />
         			</div>	 
	     </div>
	     
	     <br>
	     
	    <div class="row">
	        	<div class="col-xs-6 col-sm-4">
         				<span > </span>	   
         			</div>	         
	        	<div class="col-xs-6 col-sm-4">
         		  <input  class="btn btn-warning"  disabled="true"   placeholder="Amount" id="add_btn" name="add_btn" type="submit" value="Add"/>
         		</div>  
	     </div>
	     
</form:form>

<hr>
	<label class="label label-warning"> STUDENT RELATED PAYMENT DETAILS</label>
 		<div class="row">
 			<table class="table table-hover">
  				<tr>
  					<th>Student ID</th>
  					<th>Student Name</th>
  					<th>Payment Year</th>
  					<th>Payment Type</th>
  					<th>Payment Date</th>
  					<th>Amount</th>
  					<th>Remove</th>
  				</tr>
  				
  				<c:forEach items="${pLi}" var="p">
  					
  					<tr>
  						<td>${p.student.id}</td>
  						<td>${p.student.name}</td>
  						<td>${p.academicyear}</td>
  						<td>${p.paymentType}</td>
  						<td>${p.paymentDate}</td>
  						<td>${p.amount}</td>
  						<td><a href="remove_student_payment_details.htm?paymentId=${p.id}&studentId=${p.student.id}"><label class="label label-warning">Remove </label></td>
  						
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
