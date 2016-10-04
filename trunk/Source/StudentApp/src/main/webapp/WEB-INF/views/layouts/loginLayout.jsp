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

<link href="<c:url value="/fonts/css/font-awesome.min.css"/>" rel="stylesheet">
<link href="<c:url value="/css/animate.min.css"/>" rel="stylesheet">

<!-- Custom styling plus plugins -->
<link href="<c:url value="/css/custom.css"/>" rel="stylesheet">
<link href="<c:url value="/css/icheck/flat/green.css"/>" rel="stylesheet">
<script src="<c:url value="/js/jquery.min.js"/>"></script>


</head>

<body style="background: #F7F7F7;">
	<div>
	
		<a class="hiddenanchor" id="toregister"></a> <a class="hiddenanchor" id="tologin"></a>
		 
		<div id="wrapper">
			<tiles:insertAttribute name="body" />
		</div>
	</div>
</body>

</html>
