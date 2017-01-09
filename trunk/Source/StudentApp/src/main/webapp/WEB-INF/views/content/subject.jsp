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
  
        <div style="float:center; width: 500px; height: 215px; margin-top: 30px">    
        
	      <input type="hidden" name="action" value="${action}" id="action">	      
	      <form:hidden path="id" name="id" id="id" />
	      <form:hidden path="versionId" name="versionId" id="versionId" />
	     
	     <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Subject Code</span>	         
	         <span>
	         	            
			<form:input path="code" class="form-control" id="subject_code" name="subject_code" />			     
	         </span>
	     </div>
	     
	      <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Subject Name</span>	         
	         <span>	            
			   <form:input path="subject" class="form-control" id="subject_subject" name="subject_subject" />
			     
	         </span>
	     </div>
	     
	      <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Branch</span>	         
	         <span>
	            
			   <form:select path="branch.id"  class="form-control" id="branch_id" name="branch_id">
						<c:forEach var="b" items="${brLi}">
							<option value="${b.id}">${b.address}</option>
						</c:forEach>
				</form:select>
			     
	         </span>
	     </div>
	    
	     
	     <p></p>     
	     <div align="left">
             <span style="float:left;width:100;" >&nbsp;</span>
             <span>
                 <button type="submit" class="btn btn-default">Insert / Update</button>
                </span>
             <span style="float:left;width:100px;" >&nbsp;</span>
             <span>
                 <button type="button" class="btn btn-default">Reset</button>
             </span>
         </div>
	   </div>   
      
</form:form>

  <div style="float:center; width: 500px; height: 215px; margin-top: 30px"> 
  
  
  <table class="table table">
  <tr>
  	<td>Subject Id<td>
  	<td>Subject code </td>
  	<td>Subject Name </td>
  	<td>Location Name </td>
  	<td>action </td>
  	
  	</tr>
  	
  	
  	<c:forEach items="${sLi}" var="s" >
  	  <tr>
  			
  			<td>  ${s.id} </td>
  			<td>  ${s.code} </td>
  			<td>  ${s.subject} </td> 
  			<td>  ${s.branch.code} </td>
  			<td>  <a href="update_subject_details_view.htm?id=${s.id}">update </a> </td>  		 			
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
