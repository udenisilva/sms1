  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="page-title">
	<div class="title_left">
		<h2>
			Examination Marks  
		</h2>
	</div>
</div>

<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h3> Marks Entry</h3>
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<br />
				
   <form action=".htm" modelAttribute="" method="post" > 
        <div>
             <div align="left">
	         <span style="float:left;width:150px; font:Arial, Helvetica, sans-serif; color:#039;" >Grade</span>	         
	         <span>
	            <div class="dropdown">
			    <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown"  style="width:100px">Grade
			    <span class="caret"></span></button>
			    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
			      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Grade 1</a></li>
			      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Grade 2</a></li>
			      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Grade 3</a></li>
			      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Grade 4</a></li>
			      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Grade 5</a></li>
			      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Grade 6</a></li>
			      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Grade 7</a></li>
			      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Grade 8</a></li>
			      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Grade 9</a></li>	
			      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Grade 10</a></li>
			      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Grade 11</a></li>
			      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Grade 12</a></li>								      
			    </ul>
			  </div>     
	         </span>
	     </div>
	     <p></p>	     
	     <div align="left">
	         <span style="float:left;width:150px; font:Arial, Helvetica, sans-serif; color:#039;" >Class</span>
	         <span>
	            <div class="dropdown">
			    <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown" style="width:100px">Class
			    <span class="caret"></span></button>
			    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
			    </ul>
			  </div>  
	         </span>
	     </div>
	     <p></p>
	     <div align="left">
	         <span style="float:left;width:150px; font:Arial, Helvetica, sans-serif; color:#039;" >Academic Year</span>
	         <span>
	            <div class="dropdown">
			    <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown" style="width:150px">Academic Year
			    <span class="caret"></span></button>
			    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
			    </ul>
			  </div>  
	         </span>
	     </div>
	     <p></p>
	     <div align="left">
	         <span style="float:left;width:150px; font:Arial, Helvetica, sans-serif; color:#039;" >Subject</span>
	         <span>
	            <div class="dropdown">
			    <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown" style="width:150px">Subject
			    <span class="caret"></span></button>
			    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
			    </ul>
			  </div>  
	         </span>
	     </div>
	     <p></p>
	     <div align="left">
	         <span style="float:left;width:150px; font:Arial, Helvetica, sans-serif; color:#039;" >Examination Type</span>
	         <span>
	            <div class="dropdown">
			    <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown" style="width:150px">Examination Type
			    <span class="caret"></span></button>
			    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
			    </ul>
			  </div>  
	         </span>
	     </div>
	     <p></p>
	     <table id="myTable1" class="table table-striped table-bordered" cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th style="color:#039;">Student ID</th>
                            <th style="color:#039;">Student Name</th>
                            <th style="color:#039;">Marks</th>
                            <th style="color:#039;">Grade</th>  
                            <th style="color:#039;">Remarks</th> 
                        </tr>
                    </thead>
                </table>
	     <P></P>
	     
	   </div>    
	   <P></P>  
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
</form>
</body>
</html>