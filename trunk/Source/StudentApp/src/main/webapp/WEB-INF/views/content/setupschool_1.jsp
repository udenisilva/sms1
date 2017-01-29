  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="page-title">
	<div class="title_left">
		<h2>
			Setup School
		</h2>
	</div>
</div>

<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h3>Setup School</h3>
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<br />
				
   <form action="createBranch.htm" modelAttribute="branch" method="post" > 
        <div style="float:center; width: 500px; margin-top: 20px">
       <input class="form-control" type="hidden" id="id" name="id" value="${branch.id}" hidden="true" />
	      <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Code</span>	         
	         <span>
	             <input class="form-control" maxlength="3" width="20px" style="width:50px"  type="text" id="code" name="code" value="${branch.code}" />
	         </span>
	     </div>
	     <p></p>	     
	     <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Name</span>
	         <span>
	             <input class="form-control" maxlength="250" width="300px" style="width:360px"  type="text" id="name" name="name" value="${branch.name}" />
	         </span>
	     </div>
	     <p></p>	     
	     <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Address</span>
	     	 <textarea class="form-control" rows="5" style="width:220px" id="address" name="address">${branch.address}</textarea>	         
	     </div>
	     <p></p>	     
	     <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Telephone No</span>
	         <span>
	             <input class="form-control" maxlength="13" width="20px" style="width:100px"  type="number" id="tel" name="tel" value="${branch.tel}" />
	         </span>
	     </div>
	     <p></p>	     
	     <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Fax No</span>
	         <span>
	             <input class="form-control" maxlength="13" width="20px" style="width:100px"  type="number" id="fax" name="fax" value="${branch.fax}" />
	         </span>
	     </div>
	     <p></p>	     
	     <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Email</span>
	         <span>
	             <input class="form-control" maxlength="50" width="100px" style="width:360px"  type="email" id="email" name="email" value="${branch.email}"/>
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
