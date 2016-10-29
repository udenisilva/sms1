<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> 
<%@taglib uri="http://www.springframework.org/tags" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>   
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!-- footer content -->
<footer>
<div class="row">
	<div class="x_panel">
		<div class="x_content">
		<div>
		<span style="float:inherit;">
			    <a onclick="changeSystemLanguage('en')">English</a> 
			    | 
			    <a onclick="changeSystemLanguage('si')"><spring:message code="site.lang.sinhala" /></a>
			</span>
		</div>
		<div>
			<p class="pull-right">
				 <spring:message code="site.copyright" />.</a>| <span class="lead"> <i
					class="fa fa-area-chart"></i> STUDENT
				</span>
			</p>
			</div>
		</div>
	</div>
	</div>
</footer>
<!-- /footer content -->