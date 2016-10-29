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
				
   <form action=".htm" modelAttribute="" method="post" >
    <h3 >Setup Staff Details</h3>
        <div style="float:center; width: 500px; height: 700px; margin-top: 20px">
        
        <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Staff ID</span>	         
	         <span>
	             <input class="form-control" maxlength="20" style="width:200px"  type="text" id="szStfID" name="szStfID" />
	         </span>
	     </div>
	     <p></p>      
	      <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Title</span>	         
	         <span>
	            <div class="dropdown">
			    <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown" style="width:100px">Title
			    <span class="caret"></span></button>
			    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">	
			    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Mr.</a></li>
			    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Miss.</a></li>	
			    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Mrs.</a></li>
			    </ul>
			  </div>     
	         </span>
	     </div>
	     <p></p>	   
	     <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Name</span>
	         <span>
	             <input class="form-control" maxlength="250" width="300px" style="width:360px"  type="text" id="szStfName" name="szStfName" />
	         </span>
	     </div>
	     <p></p>   
	     <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Address</span>
	     	 <textarea class="form-control" rows="5" style="width:220px" id="Address"></textarea>	         
	     </div>
	     <p></p>	 
	     <div align="left" class="Branch">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Branch</span>
	         <span>
	            <div class="dropdown">
			    <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown" style="width:100px">Branch
			    <span class="caret"></span></button>
			    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
			    </ul>
			  </div>  
	         </span>
	     </div>
	     <p></p>
	     <div align="left" class="Division">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Division</span>
	         <span>
	            <div class="dropdown">
			    <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown" style="width:100px">Division
			    <span class="caret"></span></button>
			    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
			    </ul>
			  </div>  
	         </span>
	     </div>
	     <p></p>
	     <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Designation</span>
	         <span>
	            <div class="dropdown">
			    <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown" style="width:100px">Designation
			    <span class="caret"></span></button>
			    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
			    </ul>
			  </div>  
	         </span>
	     </div>	
	     <p></p>   
	     <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >NIC</span>
	         <span>
	             <input class="form-control" maxlength="12" width="100px" style="width:100px"  type="text" id="szStfNIC" name="szStfNIC" />
	         </span>
	     </div>
	     <p></p>
	     <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Home</span>
	         <span>
	             <input class="form-control" maxlength="10" width="100px" style="width:100px"  type="number" id="szStfHoNo" name="szStfHoNo" />
	         </span>
	     </div>
	     <p></p>   
	     <div align="left"">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Mobile Number</span>
	         <span>
	             <input class="form-control" maxlength="10" width="100px" style="width:100px"  type="number" id="dStfMobNo" name="dStfMobNo" />
	         </span>
	     </div>
	     <p></p>      
	     <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Email</span>
	         <span>
	             <input class="input_feild" maxlength="50" width="100px" style="width:360px"  type="email" id="szEmail" name="szTelN0" />
	         </span>
	     </div>
	     <p></p>  
	     <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Joined Date</span>
	         <span>
	           <input class="form-control" maxlength="10" width="300px" style="width:100px"  type="date" id="dtStuJoin" name="dtStuJoin" />
	         </span>
	     </div>
	     <p></p>	     
	     <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Left Date</span>
	     	 <input class="form-control" maxlength="10" width="20px" style="width:100px"  type="date" id="dtStuLeft" name="dtStuLeft" />	         
	     </div>
	     <p></p>	     
	     <div align="left" class="StaffProfile">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Status</span>
	         <span>
	            <div class="Status">
			    <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown" style="width:100px">Status
			    <span class="caret"></span></button>
			    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
			    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Active</a></li>
			    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Terminate</a></li>
			    </ul>
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