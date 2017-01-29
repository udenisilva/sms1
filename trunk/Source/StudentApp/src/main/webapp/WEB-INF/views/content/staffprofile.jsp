
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="page-title">
	<div class="title_left">
		
	</div>
</div>

<%@ include file="../commons/commonjs.jsp"%>
<head>

   <script type="text/javascript">
            // When the document is ready
            $(document).ready(function () {
                
            //    $('#date').datepicker({
             //       format: "yy-mm-dd"
             //   });  

                $("#jdate").datepicker({ dateFormat: 'yy-mm-dd' });
                $("#ldate").datepicker({ dateFormat: 'yy-mm-dd' });
                $("#bday").datepicker({ dateFormat: 'yy-mm-dd' });

                
            });
        </script>
        
        <script>
      	  
        	function checkAjac(){

        			
        
				var email=document.getElementById("email").value;
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


<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h3>Staff Details</h3>
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<br />



				<form action="createStaff.htm" modelAttribute="staff" method="get">
				
					<c:if test="${msg=='suc'}">
						<div class="alert alert-success">
	  						<strong>Success!</strong> Added New Staff
						</div>			
						
					</c:if>
					
					<c:if test="${msg=='err'}">
						<div class="alert alert-danger">
  							<strong>Not Added!</strong> Please Check The Details
						</div>			
					
					
					</c:if>
					
					<c:if test="${msg=='exists_user_name'}">
						<div class="alert alert-success">
  							<strong>Updated!</strong> Staff Details Updated Successfully
						</div>	
					
						<div class="alert alert-warning">
  							<strong>Exists</strong> USER NAME IS ALREADY EXISTS ,PLEASE UPDATE ANOTHER EMAIL ADDRESS
						</div>			
						
					</c:if>
				
					<div >
						<input class="form-control" maxlength="20" style="width: 200px"
							type="hidden" id="versionId" name="versionId"
							value="${staff.versionId}" />
							
							<div class="row">
							<div class="col-xs-6 col-sm-2"> 	<span >Branch </span>	 </div>	 
								  <div class="col-xs-6 col-sm-4">     
									<select class="form-control" id="branch"
										name="branch.id" >
										<c:forEach items="${branchs}" var="branch">
											<c:choose>
												<c:when test="${branch.id == staff.branch.id}">
													<option value="${branch.id}" selected="selected">${branch.code}</option>
												</c:when>
												<c:otherwise>
													<option value="${branch.id}">${branch.code}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
								</div>
							
						</div>
						
						<br>
							
					<div class="row">
				         <div class="col-xs-6 col-sm-2"> 	<span >Staff Id</span>	 </div>	         
					          <div class="col-xs-6 col-sm-4">
					          
					          <c:if test="${staff.id==0}">
					      
					          
						       <h4>  <label class="lable lable-info">   ${staff_id}</label></h4>
						        		
					          </c:if>
					          
					            <c:if test="${staff.id!=0}">
					     
					              <label class="lable lable-success">
					                  <input class="form-control"  type="hidden" id="id" name="id" value="${staff.id}" />
						     			   <label class="lable lable-info"> <h4>   ${staff.id} </h4> </label> 
						          </label>	
					          </c:if>					          
					          
						         		         
	        				</div>
	   			   </div>
							
							
					
						<p></p>
						
						<div class="row">
							 <div class="col-xs-6 col-sm-2"> 	<span >Title</span>	 </div>	      
								   <div class="col-xs-6 col-sm-4"> 
									<select  class="form-control" id="title" required="true"
										name="title">
										<c:forEach items="${titles}" var="title">
											<c:choose>
												<c:when test="${title == staff.title}">
													<option value="${title}" selected="selected">${title}</option>
												</c:when>
												<c:otherwise>
													<option value="${title}">${title}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
								</div>
							
						</div>
						
						<p></p>
						
						
					<div class="row">
						<div class="col-10">
								 <div class="col-xs-6 col-sm-2"> 	<span >Teacher Name</span>	 </div>	   
								  <div class="col-xs-6 col-sm-4">   
								 <input class="form-control" required="true" type="text" id="name"
									name="name" value="${staff.name}" />
								
							</div>
						</div>
						
						<div class="col-10">
									 <div class="col-xs-6 col-sm-2"> 	<span >Gender</span>	 </div>	   
								  <div class="col-xs-6 col-sm-4">   
								
										<select class="form-control"  required="true"  id="gender" name="gender"  >  
						    				 <option value="${student.gender}">  ${staff.gender}   </option> 
						   				 <c:forEach items="${category}" var="c">			    				
						   					  <option value="${c}">${c}</option> 
						   			 	</c:forEach>
						    		</select>
								
								
								
							</div>
						
						</div>
						</div>
						
						<p></p>
						<div class="row">
							<div class="col-10">
								<div class="col-xs-6 col-sm-2"> 	<span >Address </span>	 </div>	 
									  <div class="col-xs-6 col-sm-4">     
										<textarea class="form-control" rows="5"   required="true" style="width: 409px; height: 77px;"
									id="address" name="address">  ${staff.address} </textarea>
									</div>
								</div>							
							
							<div class="col-10">
								<div class="col-xs-6 col-sm-2"> 	<span >Date Of Birth </span>	 </div>
									 <div class="col-xs-6 col-sm-4">
									 	 <input class="form-control" required="true" type="date" id="bday"
											name="bday" value="${staff.bday}" />
							
									 </div>
							</div>
							</div>
						<p></p>
						
						
						
						<p></p>
					
						<div class="row">
						
							 <div class="col-10">
								<div class="col-xs-6 col-sm-2"> 	<span >Designation </span>	 </div>	 
									  <div class="col-xs-6 col-sm-4">     
										<select class="form-control"  required="true"
											id="designation" name="designation.id" >
											<c:forEach items="${designations}" var="designation">
												<c:choose>
													<c:when test="${designation.id == staff.designation.id}">
														<option value="${designation.id}" selected="selected">${designation.designation}</option>
													</c:when>
													<c:otherwise>
														<option value="${designation.id}">${designation.designation}</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</select>
									</div>
									
							</div>
							
							<div class="col-10">
									<div class="col-xs-6 col-sm-2"> 	<span >NIC </span>	 </div>	 
								  <div class="col-xs-6 col-sm-4">     
 									<input class="form-control" maxlength="12" placeholder="this is the password of the this staff user"  required="true"
								width="100px" type="text" id="nic"
								name="nic" value="${staff.nic}" />
							</div>
							
							</div>
							
						</div>
						<p></p>
						
					
						<div class="row">
							<div class="col-10">
								<div class="col-xs-6 col-sm-2"> 	<span >Home Number </span>	 </div>	 
								 <div class="col-xs-6 col-sm-4">   
	 								<input class="form-control" maxlength="10"  required="true"
									width="100px" type="number" id="tel"
									name="tel" value="${staff.tel}" />
								</div>
							</div>
							
							<div class="col-10">
							<div class="col-xs-6 col-sm-2"> 	<span >Mobile Number </span>	 </div>	 
							 <div class="col-xs-6 col-sm-4">   
								 
								 <input class="form-control" maxlength="10"  required="true"
								width="100px"  type="number" id="mobile"
								name="mobile" value="${staff.mobile}" />
							</div>
							
							</div>
						</div>
						<p></p>
						
						<div class="row">
						
						<div class="col-10">
						
							<div class="col-xs-6 col-sm-2"> 	<span >Email </span>	 </div>	 
							 <div class="col-xs-6 col-sm-4">  
							<input class="form-control" maxlength="50"  required="true"
								  type="email" id="email"
								name="email" onkeypress="checkAjac();" value="${staff.email}" placeholder="this is the user name of staff user " />
								
								</div> 
								
								</div> 	
								
								<div class="col-10">
								<div class="col-xs-6 col-sm-1"> 
									<div  class="label label-warning" id="error_msg"  >  </div >	
									<div  class="label label-success" id="success_msg"  >  </div >	
									 </div>	 
								</div>						
								
						</div>
						
						<p></p>
							<div class="row">
							
								<div class="col-10">
							<div class="col-xs-6 col-sm-2"> 	<span >Join date </span>	 </div>	 
							 <div class="col-xs-6 col-sm-4">  
								 <input class="form-control" maxlength="10"  required="true"
							 type="date" id="jdate"
								name="jdate" value="${staff.jdate}" />
							</div>
							
							</div>
							
								<div class="col-10">
									<div class="col-xs-6 col-sm-2"> 	<span >Left date </span>	 </div>	 
							 <div class="col-xs-6 col-sm-4">  
								<input class="form-control" maxlength="10"  type="date" id="ldate" name="ldate"
								value="${staff.ldate}" />
						</div>
								
								</div>
						</div>
						<p></p>
						
						
						<div class="row">
							<div class="col-xs-6 col-sm-2"> 	<span >Status </span>	 </div>	 
							 <div class="col-xs-6 col-sm-4">  
									<select class="btn btn-default dropdown-toggle" name="status"  required="true"
										id="status" >
										<c:forEach items="${status}" var="statu">
											<c:choose>
												<c:when test="${statu == staff.status}">
													<option value="${statu}" selected="selected">${statu}</option>
												</c:when>
												<c:otherwise>
													<option value="${statu}">${statu}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
							
							</div>
						</div>
						<br>
						
							<div class="row">
							<div class="col-xs-6 col-sm-2"> 	 </div>	 
							 <div class="col-xs-6 col-sm-4">  
								<button type="submit" id="btn_save"   name="btn_save" class="btn btn-success">Insert</button>
						
						</div>
						</div>
					</div>
					
					<br>
						<label class="label label-warning"> STAFF  DETAILS</label>
						<br>
			<div class="row">
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
  					<th>Left Date</th>
  					<th>select</th>
  			
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
  						<td>${p.ldate}	</td>  					
  						<td><span class="label label-success"> <a href="staffprofile.htm?staffId=${p.id}" style="color: white;"> Select </a> </span>	</td>
  							
  			</tr> 					 				
  				
  				</c:forEach>	
			</table>
 
 		</div>
					
				</form>
				
				
				<br>
				
			
			
				
			</div>
		</div>
	</div>
</div>
</body>
</html>