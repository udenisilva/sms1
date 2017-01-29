
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>

<script>
      	  
        	function checkAjac(){

        			
        
				var email=document.getElementById("memail").value;
        	  //  var json = { "email" : email, "name" : name, "desc": desc};
        	    var json = { "email" : email};
        	    
        	    $.ajax({
        	        url: 'check_ajax.htm',
        	        data: JSON.stringify(json),
        	        type: "POST",           
        	        beforeSend: function(xhr) {
        	            xhr.setRequestHeader("Accept", "application/json");
        	            xhr.setRequestHeader("Content-Type", "application/json");
        	        },
        	        success: function(data){ 
        	        //	 alert(data);
        	        	if(data=="exists"){
        	        		 document.getElementById("error_msg").innerHTML="This User Is Exists , please Try New Email";
								//document.getElementById("btn_save").disabled=true;
								 document.getElementById("success_msg").innerHTML="";
            	        	}else{
            	        		 document.getElementById("success_msg").innerHTML="Proceed Next Step ,User Is Not Exists";
            	        	//	 document.getElementById("btn_save").disabled=false;
            	        		 document.getElementById("error_msg").innerHTML="";
                	        	}
        	           	// alert(data);
        	           
        	        }
        	    });
        	}

        	  
</script>

</head>

<div class="page-title">
	<div class="title_left">
		<h3>Parent Details</h3>
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
						
				<label class="label label-warning"> STUDENT  DETAILS</label>
			<div class="row">
			
			<div style="width:100%;overflow:auto; max-height:300px;">
 			<table class="table table-hover"  >
  				<tr>
  					<th>Student ID</th>
  					<th>Student Code</th>
  					<th>Student Name</th>
  					<th>Gender</th>
  					<th>Join Date</th>
  					<th>Left Date</th>
  					<th>Status</th>
  					<th>GRADE</th>
  					<th>select</th>
  			
  				</tr>
  				
  				<c:forEach items="${studentList}" var="p">
  					
  					<tr >
  					 
  						<td>${p.id}</td>
  						<td>${p.code}</td>
  						<td>${p.name}</td>
  						<td>${p.gender}	</td>
  						<td>${p.joinDate}</td>
  						<td>${p.leftDate}</td>
  						<td>${p.status}	</td>
  						<td>${p.grade.grade}	</td>
  						<td><span class="label label-success"> <a href="select_student_to_add_parent.htm?id=${p.id}&code=${p.code}" style="color: white;"> Select </a> </span>	</td>
  								
  					</tr> 	
  					
  							 				
  				
  				</c:forEach>	
			</table>
			
			</div>
 
 		</div>
			
			
			
				<br />
				<form action="createParents.htm" modelAttribute="parents"	method="post">
				
 					<input class="form-control"  type="hidden" id="student_id" name="student_id" value="${student.id}" hidden=""/>
					<input class="form-control" maxlength="20"  type="hidden" id="versionId" name="versionId" value="${parent.versionId}"/>		
					
		<div class="row">
	         <div class="col-xs-6 col-sm-2"> 	<span ></span>	 </div>	         
	          <div class="col-xs-6 col-sm-4">
	          <label>
	        		Student ID -  ${student.id}  &    Code - ${student.code}
	          </label>
	         
	         </div>
	     </div>
				
				<h4> <label class="label label-warning"> MOTHER'S Details  </label> </h4>	
				
		<div class="row">
		
			<div class="col-10">
		         <div class="col-xs-6 col-sm-2"> 	<span >Mother Name</span>	 </div>	         
		          <div class="col-xs-6 col-sm-4">
		          <input class="form-control" maxlength="20" required="true" type="text" id="mname" name="mname" value="${parent.mname}"/>
		         </div>
	         
	         </div>
	         
	         <div class="col-10">
	         	 <div class="col-xs-6 col-sm-2"> 	<span >Mother NIC</span>	 </div>	         
			          <div class="col-xs-6 col-sm-4">
			          <input class="form-control" maxlength="20" required="true"  type="text" id="mnic" name="mnic" value="${parent.mnic}"/>
	         </div>
	         
	         </div>
	     </div>
	     
	     <br>
	     
	     <div class="row">
	     
	     <div class="col-10">
	     
	         <div class="col-xs-6 col-sm-2"> 	<span >Mother Address</span>	 </div>	         
	          <div class="col-xs-6 col-sm-4">
	          <input class="form-control" maxlength="20" required="true"  type="text" id="maddress" name="maddress" value="${parent.maddress}"/>
	         </div>
	         
	         </div>
	         
	         
	         <div class="col-10">
	         
	           <div class="col-xs-6 col-sm-2"> 	<span >Mother Nationality</span>	 </div>	         
	          <div class="col-xs-6 col-sm-4">
	          <input class="form-control" maxlength="20" required="true"  type="text" id="mnationaity" name="mnationaity" value="${parent.mnationaity}"/>
	         </div>
	         
	         </div>
	     </div>
	     
	     <br>
	     
	   
	     <div class="row">
	      <div class="col-10">
	         <div class="col-xs-6 col-sm-2"> 	<span >Mother Working Company</span>	 </div>	         
	          <div class="col-xs-6 col-sm-4">
	          <input class="form-control" maxlength="20" required="true"   type="text" id="mcompany" name="mcompany" value="${parent.mcompany}"/>
	         </div>
	         
	         </div>
	         
	          <div class="col-10">
	            <div class="col-xs-6 col-sm-2"> 	<span >Mother Occupation</span>	 </div>	         
	          <div class="col-xs-6 col-sm-4">
	          <input class="form-control" maxlength="20" required="true"  type="text" id="moccupation" name="moccupation" value="${parent.moccupation}"/>
	         </div>
	          
	          
	          </div>
	         
	     </div>
	     
	     <br>
	     
	    
	     
	       <div class="row">
	        <div class="col-10">
	         <div class="col-xs-6 col-sm-2"> 	<span >Mother Phone</span>	 </div>	         
	          <div class="col-xs-6 col-sm-4">
	          <input class="form-control" maxlength="10" required="true"  type="number" id="mphone" name="mphone" value="${parent.mphone}"/>
	         </div>
	         </div>
	         
	         
	          <div class="col-10">
	             <div class="col-xs-6 col-sm-2"> 	<span >Mother Mobile</span>	 </div>	         
	          <div class="col-xs-6 col-sm-4">
	          <input class="form-control" maxlength="10" required="true"  type="number" id="mmobile" name="mmobile" value="${parent.mmobile}"/>
	         </div>
	          
	          </div>
	     </div>
	     
	     <br>
	     
	        <div class="row">
	        <div class="col-10">
	         <div class="col-xs-6 col-sm-2"> 	<span >Mother Email</span>	 </div>	         
	          <div class="col-xs-6 col-sm-4">
	          <input class="form-control"  required="true" onkeypress="checkAjac();"  placeholder="this is the user name of parent "  type="email" id="memail" name="memail" value="${parent.memail}"/>
	         </div>
	         
	         </div>
	         
	         <div class="col-10">
								<div class="col-xs-6 col-sm-1"> 
									<div  class="label label-warning" id="error_msg"  >  </div >	
									<div  class="label label-success" id="success_msg"  >  </div >	
									 </div>	 
			</div>	
	         
	     </div>
	     
	  <hr>
	  
	  			
				<h4> <label class="label label-warning"> FATHER'S Details  </label> </h4>	
				
		<div class="row">
		
		<div class="col-10">
	         <div class="col-xs-6 col-sm-2"> 	<span >Father Name</span>	 </div>	         
	          <div class="col-xs-6 col-sm-4">
	          <input class="form-control" maxlength="20" required="true"  type="text" id="fname" name="fname" value="${parent.fname}"/>
	         </div>
	         
	         </div>
	         
	         
	         <div class="col-10">
	          <div class="col-xs-6 col-sm-2"> 	<span >Father NIC</span>	 </div>	         
	          <div class="col-xs-6 col-sm-4">
	          <input class="form-control" maxlength="20" required="true"  type="text" id="fnic" name="fnic" value="${parent.fnic}"/>
	         </div>
	         
	         </div>
	     </div>
	     
	     <br>
	     
	     
	     <div class="row">
	     <div class="col-10">
	         <div class="col-xs-6 col-sm-2"> 	<span >Father Address</span>	 </div>	         
	          <div class="col-xs-6 col-sm-4">
	          <input class="form-control" maxlength="20" required="true"   type="text" id="faddress" name="faddress" value="${parent.faddress}"/>
	         </div>
	         
	         </div>
	         
	         
	         <div class="col-10">
	          <div class="col-xs-6 col-sm-2"> 	<span >Father Nationality</span>	 </div>	         
	          <div class="col-xs-6 col-sm-4">
	          <input class="form-control" maxlength="20" required="true"  type="text" id="fnationaity" name="fnationaity" value="${parent.fnationaity}"/>
	         </div>
	         
	         </div>
	     </div>
	     
	     <br>
	     
	     
	     
	     <div class="row">
	     <div class="col-10">
	         <div class="col-xs-6 col-sm-2"> 	<span >Father Working Company</span>	 </div>	         
	          <div class="col-xs-6 col-sm-4">
	          <input class="form-control" maxlength="20" required="true"  type="text" id="fcompany" name="fcompany" value="${parent.fcompany}"/>
	         </div>
	         
	         </div>
	         
	         <div class="col-10">
	           <div class="col-xs-6 col-sm-2"> 	<span >Father Occupation</span>	 </div>	         
	          <div class="col-xs-6 col-sm-4">
	          <input class="form-control" maxlength="20" required="true"  type="text" id="foccupation" name="foccupation" value="${parent.foccupation}"/>
	         </div>
	         
	         </div>
	     </div>
	     
	     <br>
	     
	 
	     
	       <div class="row">
	       <div class="col-10">
	         <div class="col-xs-6 col-sm-2"> 	<span >Father Phone</span>	 </div>	         
	          <div class="col-xs-6 col-sm-4">
	          <input class="form-control" maxlength="20" required="true"  type="number" id="fphone" name="fphone" value="${parent.fphone}"/>
	         </div>
	         </div>
	         
	         <div class="col-10">
	           <div class="col-xs-6 col-sm-2"> 	<span >Father Mobile</span>	 </div>	         
	          <div class="col-xs-6 col-sm-4">
	          <input class="form-control" maxlength="20" required="true"  type="number" id="fmobile" name="fmobile" value="${parent.fmobile}"/>
	         </div>
	         </div>
	     </div>
	     
	     <br>
	     
	     
	     
	        <div class="row">
	         <div class="col-xs-6 col-sm-2"> 	<span >Father Email</span>	 </div>	         
	          <div class="col-xs-6 col-sm-4">
	          <input class="form-control"  required="true"  type="email" id="femail" name="femail" value="${parent.femail}"/>
	         </div>
	     </div>
	     
	     <br>
	     
	      <div class="row">
	         <div class="col-xs-6 col-sm-2"> 	 </div>	         
	          <div class="col-xs-6 col-sm-4">
	      
	          <c:if test="${student.id>0}">
	          
	        <button type="submit" class="btn btn-warning">Submit</button>
	        </c:if>
	         </div>
	     </div>
					

				</form>
			</div>
		</div>
	</div>
</div>

</body>
</html>