  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="page-title">
	<div class="title_left">
		<h3>
			Setup Subject
		</h3>
	</div>
</div>

<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h3>Setup Subject</h3>
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<br />
   <form action=".htm" modelAttribute="" method="post" >
  
        <div style="float:center; width: 500px; height: 215px; margin-top: 30px">      
	      <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Grade</span>	         
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
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Subject</span>
	         <span>
	            <div class="dropdown">
			    <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown" style="width:100px">Subject
			    <span class="caret"></span></button>
			    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
			    </ul>
			  </div>  
	         </span>
	     </div>
	     <p></p>	     
	     <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Code</span>
	     	 <input class="form-control" maxlength="3" width="20px" style="width:100px"  type="text" id="szSubCode" name="szSubCode" />	         
	     </div>
	     <p></p>	     
	     <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Name</span>
	     	 <input class="form-control" maxlength="200" width="20px" style="width:360px"  type="text" id="szSubName" name="szSubName" />	         
	     </div>

	     <p></p>	     
	     <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Teacher</span>
	         <span>
	            <div class="dropdown">
			    <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown" style="width:100px">Teacher
			    <span class="caret"></span></button>
			    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
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