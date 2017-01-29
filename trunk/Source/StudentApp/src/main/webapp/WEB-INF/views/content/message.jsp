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
				
				<c:if test="${result=='add_new'}">
				
				<label class="label label-success">
					New Message Added Successfully
				</label>
				
				</c:if>
				
				<c:if test="${result=='not_added'}">
				
				<label class="label label-danger">
					New Message Added Failed
				</label>
				
				</c:if>
					<c:if test="${result=='check_grade_added'}">
				
				<label class="label label-danger">
						Please Select The Grade
				</label>
				
				</c:if>
				
			</div>
			</div>	
			</div>
			</div>
			
				
				
				
	<form action="select_grade.htm"  method="get" > 
        <div >       
      		<div align="left" class="Branch">
      		
      		<select id="grade_id" name="grade_id" class="form-control" >
      			
			<c:forEach items="${grLi}" var="g">
				<option value="${g.id}">${g.grade} </option>
			</c:forEach>

      		</select>
      		
      		<input type="submit" class="form-group" value="Find">
      		</div>      		
      </div>
  </form>				
				
   <form action="add_or_update_grade.htm"  method="get" > 
        <div >  
        
        <div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Grade</span>
	     	 	 	   ${message.grade.id} - ${message.grade.grade}     
	    </div>
             
             	<input type="hidden" name="action" value="${action}" class="form-control" />  
               <input type="hidden" name="message_no" value="1" class="form-control" />  
               <input type="hidden" name="grade_id"  value="${message.grade.id}"  class="form-control" />  
             
      		<div align="left" class="Branch">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Message Title</span>
	          <input type="text" name="message_title" class="form-control" />  
	         <span>
	               
	         
	         </span>
	     </div>
	     <p></p>
      		<div align="left">
	         <span style="float:left;width:100px; font:Arial, Helvetica, sans-serif; color:#039;" >Message</span>
	     	 	     	 <input  type="message"  name="message" class="form-control" />        
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
 
 	<table class="table table">
 	
 	<tr>
 		<th>Grade Id</th>
 		<th>Grade Name</th>
 		<th>Id</th>
 		<th>Message Title</th>
 		<th>Message</th>
 		<th><u>Remove </u></th>
 	</tr>
 
 		<c:forEach items="${msLi}" var="m"> 				
	 		<tr>
	 			<td> ${m.grade.id} </td>
	 			<td> ${m.grade.grade} </td>
	 			<td> ${m.id}</td>
	 			<td> ${m.message_titles}</td>
	 			<td> ${m.message}</td>
	 			<td> <a href="remove_message.htm?grade_id=${m.grade.id}&msg_id=${m.id}"> remove </a></td>
	 		</tr>
 		</c:forEach>
 		
 	
 	
 	</table>
 
</body>
</html>