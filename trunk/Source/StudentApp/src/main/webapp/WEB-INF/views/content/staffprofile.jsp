  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="page-title">
	<div class="title_left">
		<h2>
			Setup Staff Details
		</h2>
	</div>
</div>

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
				
   <form action=".htm" modelAttribute="staff" method="post" >
    <h3 >Setup Staff Details</h3>
        <div style="float:center; width: 500px; height: 700px; margin-top: 20px">
        
        <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Staff ID</span>	         
	         <span>
	             <input class="form-control" maxlength="20" style="width:200px"  type="text" id="id" name="id" />
	         </span>
	     </div>
	     <p></p>      
	      <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Title</span>	         
	         <span>
	            <div class="dropdown">
			    <select class="btn btn-default dropdown-toggle" id="title" name="title" >Title
			    <option value="">Mr.</a></option>
			    <option value="">Miss.</option>	
			    <option value="">other</option>
			    </select>
			  </div>     
	         </span>
	     </div>
	     <p></p>	   
	     <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Name</span>
	         <span>
	             <input class="form-control" maxlength="250" width="300px" style="width:360px"  type="text" id="name" name="name" />
	         </span>
	     </div>
	     <p></p>   
	     <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Address</span>
	     	 <textarea class="form-control" rows="5" style="width:220px" id="address" name="address"></textarea>	         
	     </div>
	     <p></p>	 
	     <div align="left" class="Branch">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Branch</span>
	         <span>
	            <div class="dropdown">
			    <select class="btn btn-default dropdown-toggle" type="button" id="branch" name="Branch">
			     <option value="">B12</option>
			    </select>
			  </div>  
	         </span>
	     </div>
	     <p></p>
	    <!-- <div align="left" class="Division">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Division</span>
	         <span>
	           <div class="dropdown">
			    <select class="btn btn-default dropdown-toggle" type="button" id="branch" name="Branch">
			     <option value="">B12</option>
			    </select>
			  </div>  
	         </span>
	     </div>
	     <p></p>-->
	     <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Designation</span>
	         <span>
	            <div class="dropdown">
			    <select class="btn btn-default dropdown-toggle" id="designation" name="designation">
			     <option value="">D12</option>
			    </select>
			  </div>  
	         </span>
	     </div>	
	     <p></p>   
	     <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >NIC</span>
	         <span>
	             <input class="form-control" maxlength="12" width="100px" style="width:100px"  type="text" id="nic" name="nic" />
	         </span>
	     </div>
	     <p></p>
	     <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Home</span>
	         <span>
	             <input class="form-control" maxlength="10" width="100px" style="width:100px"  type="number" id="tel" name="tel" />
	         </span>
	     </div>
	     <p></p>   
	     <div align="left"">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Mobile Number</span>
	         <span>
	             <input class="form-control" maxlength="10" width="100px" style="width:100px"  type="number" id="mobile" name="mobile" />
	         </span>
	     </div>
	     <p></p>      
	     <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Email</span>
	         <span>
	             <input class="input_feild" maxlength="50" width="100px" style="width:360px"  type="email" id="email" name="email" />
	         </span>
	     </div>
	     <p></p>  
	     <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Joined Date</span>
	         <span>
	           <input class="form-control" maxlength="10" width="300px" style="width:100px"  type="date" id="jdate" name="jdate" />
	         </span>
	     </div>
	     <p></p>	     
	     <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Left Date</span>
	     	 <input class="form-control" maxlength="10" width="20px" style="width:100px"  type="date" id="ldate" name="ldate" />	         
	     </div>
	     <p></p>	     
	     <div align="left" class="StaffProfile">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Status</span>
	         <span>
	            <div class="left">
			    <select class="btn btn-default dropdown-toggle" id="status" name="status" >			 
			    <option value="">Active</option>
			    <option value="">Terminate</option>
			    </select>
			  </div>  
	         </span>
	     </div>
	     <p></p>     
	     <div align="left">
             <span style="float:left;width:100;" >&nbsp;</span>
             <span>
                 <button type="button" class="btn btn-default">Insert</button>
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