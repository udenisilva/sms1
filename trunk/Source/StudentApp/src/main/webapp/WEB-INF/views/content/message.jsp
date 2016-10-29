 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="page-title">
	<div class="title_left">
		<h2>
			Send Messages
		</h2>
	</div>
</div>

<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12">
		<div class="x_panel">
			<div class="x_title">
				<h3>Send Messages</h3>
				<ul class="nav navbar-right panel_toolbox">
					<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="x_content">
				<br />
				
   <form action=".htm" modelAttribute="" method="post" > 
        <div >       
      		<div align="left" class="Branch">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Category</span>
	         <span>
	            <div class="dropdown">
			    <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown" style="width:100px">Category
			    <span class="caret"></span></button>
			    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
			    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Parent</a></li>
			    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Staff</a></li>	
			    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Teachers</a></li>
			    </ul>
			  </div>  
	         </span>
	     </div>
	     <p></p>
      		<div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Message</span>
	     	 <textarea class="form-control" rows="5" style="width:400px" id="Address"></textarea>	         
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
</body>
</html>