<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<spring:url value="/resources/css/style.css" var="styleCss" />
<link href="${styleCss}" rel="stylesheet" />
<title>Home page</title>
</head>
<body>
	<h2>Hello World</h2>
	<div><a href="orders">Place Order</a></div>
	<sec:authorize access="hasRole('ROLE_USER')">
		<!-- For login user -->
		<c:url value="/j_spring_security_logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
		</form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			};
		</script>

		<h2>
			User :  <sec:authentication property="principal.username"/> | <a
				href="javascript:formSubmit()"> Logout</a>
		</h2>


	</sec:authorize>
</body>
</html>