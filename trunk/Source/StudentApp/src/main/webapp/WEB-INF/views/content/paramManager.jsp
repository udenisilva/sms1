<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- my common function jsp -->
<%@ include file="../commons/commonjs.jsp"%>

<div class="row">
	<div class="x_panel">
		<div class="x_title">
			<h2>
				<spring:message code="add.custom.report.head" />
			</h2>
			<ul class="nav navbar-right panel_toolbox">
				<li><a class="collapse-link"><i	class="fa fa-chevron-up"></i></a></li>
			</ul>
			<div class="clearfix"></div>
		</div>
		<div class="x_content">
		
			<c:forEach var="paramlist" items="${paramList}">
				${paramlist} : <input type="text" class="param" name="${paramlist}" id="id_${paramlist}"/><br/><br/>
			</c:forEach>
			
			<form id="hiddenForm" action="getReportParam.htm" method="post">
				<input type="hidden" id="fileName" name="fileName" value="${fileName}" />
				<input type="hidden" id="hiddenFieldValue" name="finalString" value=""/>
			</form>
			
			<button onclick="processReport();">Process</button>
			
		</div>
	</div>
</div>

<script type="text/javascript">

function processReport(){

	var finalString = "";
	$(".param").each(
		function(){
			finalString = finalString + $(this).attr('name') + "_" + $(this).val() + "#";
		}		
	);
	
	//alert(finalString);
	$("#hiddenFieldValue").val(finalString);
	
	$("#hiddenForm").submit();
	
}

</script>


