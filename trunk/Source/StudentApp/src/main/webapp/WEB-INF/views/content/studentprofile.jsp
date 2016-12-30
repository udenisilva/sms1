  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="page-title">
	<div class="title_left">
		<h2>
			Setup Student Details
		</h2>
	</div>
</div>

<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h3>Student Details</h3>
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<br />
				
   <form action="createStudent.htm" modelAttribute="student" method="post" >
    <h3>Setup Student Details</h3>
    <input class="form-control" type="hidden" id="id" name="id" value="${student.id}" hidden="true" />
        <div style="float:center; width: 500px; margin-top: 20px">
      
	      <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Branch</span>	         
	         <span>
	            <div class="dropdown">
			    <select class="btn btn-default dropdown-toggle" id="branch" name="branch.id" style="width: 100">
			    <c:forEach items="${branchs}" var="branch">
			    <option value="${branch.id}">${branch.code}</option> 
			    </c:forEach>
			    </select>
			  </div>     
	         </span>
	     </div>
	     <p></p>	   
	     <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Student ID</span>	         
	         <span>
	             <input class="form-control" maxlength="20" style="width:200px"  type="text" id="code" name="code" value="${student.code}" />
	         </span>
	     </div>
	     <p></p>	     
	     <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Student Name</span>
	         <span>
	             <input class="form-control" maxlength="250" style="width:360px"  type="text" id="name" name="name" value="${student.name}" />
	         </span>
	     </div>
	     <p></p>   
	     <div align="left" class="Gender">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Gender</span>
	         <span>
	            <div class="dropdown">
			    <select class="btn btn-default dropdown-toggle"   id="gender" name="gender"  style="width: 100">  
			    <c:forEach items="${genders}" var="gender">
			     <option value="${gender}">${gender}</option> 
			    </c:forEach>
			    </select>
			  </div>  
	         </span>
	     </div>
	     <p></p>  
	     <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Joined Date</span>
	         <span>
	           <input class="form-control"  type="text" id="joinDate" name="joinDate" value="${student.joinDate}" style="width:80%"/>
	         </span>
	     </div>
	     <p></p>	     
	     <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Left Date</span>
	     	 <input class="form-control"   type="text" id="leftDate" name="leftDate" value="${student.leftDate}" style="width:180%"/>	         
	     </div>
	     <p></p>	     
	     <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Status</span>
	         <span>
	            <div class="Status">
			    <select class="btn btn-default dropdown-toggle" name="status" id="status"  style="width:100">
			   <c:forEach items="${status}" var="statu">
			     <option value="${statu}">${statu}</option> 
			    </c:forEach>
			    </select>
			  </div>  
	         </span>
	     </div>
	     <p></p>     
	     <div align="left">
             <span style="float:left;width:100;" >&nbsp;</span>
             <span>
                 <button type="submit" class="btn btn-default">Insert</button>
                </span>
             <span style="float:left;width:100px;" >&nbsp;</span>
             <span>
                 <button type="button" class="btn btn-default">Reset</button>
             </span>
         </div>
	   </div>   
 </form>
</div>
</div>
</div>
</div>
</body>
</html>