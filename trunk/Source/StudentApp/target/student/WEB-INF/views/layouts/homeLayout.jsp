<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html lang="en">
    <head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- Meta, title, CSS, favicons, etc. -->
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
        <title><tiles:insertAttribute name="title" ignore="true" /></title>
        
        <link rel='shortcut icon' type='image/x-icon' href='images/favicon.ico' />

		<!-- Bootstrap core CSS -->
		<link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet">
		
		<!-- Toaster CSS -->
		<link href="<c:url value="/css/toastr.css"/>" rel="stylesheet" type="text/css" />
		
		<link href="<c:url value="/fonts/css/font-awesome.min.css"/>" rel="stylesheet">
		<link href="<c:url value="/css/animate.min.css"/>" rel="stylesheet">
		
		<!-- Custom styling plus plugins -->
		<link href="<c:url value="/css/custom.css"/>" rel="stylesheet">
		<link href="<c:url value="/css/icheck/flat/green.css"/>" rel="stylesheet">
		
		<!-- select2 -->
		<link href="<c:url value="/css/select/select2.min.css"/>" rel="stylesheet">
		<!-- switchery -->
		<link rel="stylesheet" href="<c:url value="/css/switchery/switchery.min.css"/>" />
		
		<link rel="stylesheet" href="<c:url value="/css/jquery-ui.min.css"/>" />
		
			<link rel="stylesheet" href="<c:url value="/css/bootstrap-datetimepicker.min.css"/>" />
		
		<script src="<c:url value="/js/jquery.min.js"/>"></script>

    </head>

    <body class="nav-md">
    
    	<div class="container body">
    		<div class="main_container">
    			<tiles:insertAttribute name="header" />
    			
    			<div class="right_col" role="main">
    				<div class="">
		    			<tiles:insertAttribute name="body" />				
		       			<tiles:insertAttribute name="footer" />
	       			</div>
       			</div>
       			
       			<script src="<c:url value="/js/bootstrap.min.js"/>" type="text/javascript"></script>
				<!-- bootstrap progress js -->
				<script src="<c:url value="/js/progressbar/bootstrap-progressbar.min.js"/>" type="text/javascript"></script>
				<script src="<c:url value="/js/nicescroll/jquery.nicescroll.min.js"/>" type="text/javascript"></script>
				<script src="<c:url value="/js/bootstrap-datepicker.js"/>" type="text/javascript"></script>
				<!-- icheck -->
				<script src="<c:url value="/js/icheck/icheck.min.js"/>" type="text/javascript"></script>
				<!-- tags -->
				<script src="<c:url value="/js/tags/jquery.tagsinput.min.js"/>" type="text/javascript"></script>
				<!-- switchery -->
				<script src="<c:url value="/js/switchery/switchery.min.js"/>" type="text/javascript"></script>
				<!-- daterangepicker -->
				<script src="<c:url value="/js/moment.min2.js"/>" type="text/javascript"></script>
				<script src="<c:url value="/js/datepicker/daterangepicker.js"/>" type="text/javascript"></script>
				<!-- select2 -->
				<script src="<c:url value="/js/select/select2.full.js"/>" type="text/javascript"></script>
				<!-- form validation -->
				<script src="<c:url value="/js/parsley/parsley.min.js"/>" type="text/javascript"></script>
				<!-- textarea resize -->
				<script src="<c:url value="/js/textarea/autosize.min.js"/>" type="text/javascript"></script>
				
				<script src="<c:url value="/js/jquery-ui.min.js"/>" type="text/javascript"></script>
				
				<script src="<c:url value="/js/toastr.js"/>" type="text/javascript"></script>
				
				<script type="text/javascript">
					autosize($('.resizable_textarea'));
				</script>
				<!-- textarea resize -->
				<script src="js/custom.js" type="text/javascript"></script>
				
       			<script src="<c:url value="/js/jquery-ui-timepicker-addon.js"/>" type="text/javascript"></script>
    		</div>
    	</div>
    
    </body>
    
</html>
