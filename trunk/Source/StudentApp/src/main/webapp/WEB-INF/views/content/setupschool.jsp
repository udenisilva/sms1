  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!-- my common function jsp -->
<%@ include file="../commons/commonjs.jsp"%>

<div class="page-title">
	<div class="title_left">
		<h2>
			Setup School
		</h2>
	</div>
</div>

<div class="x_panel">
	<div class="x_title">
		<h2>
			<spring:message code='find.school' />
		</h2>
		<ul class="nav navbar-right panel_toolbox">
			<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
		</ul>
		<div class="clearfix"></div>
	</div>
	<div class="x_content">
		<form:form action="findBranch.htm" method="post">

			<div class="form-group">
				<div class="col-md-6">
					<select class="form-control" id="forwardId" name="forwardId">
						<c:forEach var="b" items="${brLi}">
							<option value="${b.id}">${b.name}</option>
						</c:forEach>
					</select>
				</div>

				<button class="btn btn-info" type="submit">
					<i class="fa fa-share"></i>
					<spring:message code='find.button.label' />
				</button>
				<button class="btn btn-info" type="button"
					onclick="redirect('setupschool.htm');">
					<i class="fa fa-user"></i>
					<spring:message code='create.new.button.label' />
				</button>
			</div>

		</form:form>

	</div>
</div>

<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h3>  Setup School - <label class="label label-info">  ${msg} </label></h3>
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<br />
				
   <form:form action="add_school_details.htm" modelAttribute="branch" method="get" onsubmit="return validateForm()"  > 
        <div >
      
      <input type="hidden" name="setupid" value="${branch.id}" />
      <input type="hidden" name="versionId" value="${branch.versionId}" />
      
    
      
	 <div class="row">
	         	<div class="col-xs-6 col-sm-2">
	        	 	<span >Code</span>	  
	         	</div>
	                 
	     		 <div class="col-xs-6 col-sm-4">
	     		 <label class="label label-info">${branch.code}</label>
	           		  <input type="hidden" class="form-control" maxlength="3" value="${branch.code}"  id="code" name="code" />
	     	  	</div>
	 </div>
	     
	     <br>
	     
	     <div class="row">
		     <div class="col-10">
		     	<div class="col-xs-6 col-sm-2">
		        	   <span class="required">Name</span>
		       	</div>
		        	        	 
		   		<div class="col-xs-6 col-sm-4">
		     	 	<input type="text" class="form-control col-sm-5"  required="required"   value="${branch.name}" id="name" name="name"/>
		        </div>         
	        </div>
	        
	      
	 </div>  
	 <br> 
	  	     
	 <div class="row">
	         <div class="col-10">
		       	<div class="col-xs-6 col-sm-2">
		        	   <span class="required">Address</span>
		       	</div>
		        	        	 
		   		<div class="col-xs-6 col-sm-4">
		     	 	<input type="text" class="form-control col-sm-5" rows="5" required="required"   value="${branch.address}" id="address" name="address"/>
		        </div>   
		        
	        </div>  
	        
	           
	 </div>
	 <br>
	<div class="row">
	         <div class="col-10">	        
		       	<div class="col-xs-6 col-sm-2">
		         	      <span class="required">Telephone No</span>	         	       
		         </div>	         	       	
		   		 <div class="col-xs-6 col-sm-4">	             
		             <input type="number" class="form-control" required="required" rows="5" value="${branch.tel}"  id="tel" name="tel"/>
		        </div>	        
	        </div>
	        
	         <div class="col-10">
	            
		       	<div class="col-xs-6 col-sm-2">
		        	     <span class="required">Fax No</span>
		        </div>
		  		<div class="col-xs-6 col-sm-4">
		             <input  type="number" class="form-control" required="required" maxlength="13" width="20px" value="${branch.fax}"   id="fax" name="fax" />
		         </div>   
	         </div>
	 </div>
	 
	 <br>
	
	     
	     <br>
<div class="row">
	         
	       	<div class="col-xs-6 col-sm-2">
	         	   <span class="required">Email</span>
	         </div>
	      	<div class="col-xs-6 col-sm-4">
	             <input type="email" class="form-control" required="required" maxlength="50"  value="${branch.email}"    id="email" name="email" />
	       </div>   
</div>

<br>
	<div class="row">
            
             	<div class="col-xs-6 col-sm-2">
                
               </div>
           <div class="col-xs-6 col-sm-4">
             <button type="submit" class="btn btn-info">Insert /Update</button>
                 <button type="button" class="btn btn-warning">Reset</button>
             </div>
         </div>
         
	   </div>   
</</form:form>
</div>
</div>
</div>
</div>
</body>

<script type="text/javascript">
	function validateForm() {
		var code = $("#code").val();
		var address = $("#address").val();
		var tel = $("#tel").val();
		var fax = $("#fax").val();
	 
		var email = $("#email").val();
	

		if (code == "") {
			showError("#code",
					"<spring:message code='setupschool.error.empty.code' />");
			return false;
		} else if (address == "") {
			showError("#address",
					"<spring:message code='setupschool.error.empty.invalid.address' />");
			return false;
		} else if (tel == "") {
			showError("#tel",
					"<spring:message code='setupschool.error.empty.tel' />");
			return false;
		} else if (fax == "") {
			showError("#fax",
					"<spring:message code='setupschool.error.empty.fax' />");
			return false;
		} else if (email == "") {
			showError("#email",
					"<spring:message code='setupschool.error.empty.email' />");
			return false;
			/* }else if(isAdmin == 'NO' && districtCount == 1){
			   $("span.parsley-error").hide();
			   showErrorBelow("#allowDistrictTable", "<spring:message code='register.error.empty.districts' />");
			   return false;*/	
		} else {
			return true;
		}
	}

	</script>



</html>
