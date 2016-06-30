<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>

<spring:url value="/" var="urlHome" />
<spring:url value="/register" var="urlAddUser" />
<spring:url value="/users" var="urlViewUsers" />

<link rel="stylesheet" href="${urlHome}resources/css/style.css" />
<link rel="stylesheet" href="${urlHome}resources/css/bootstrap.min.css" />
<script src="${urlHome}resources/js/libs/jquery-1.9.1.js" type="text/javascript"></script>
<script src="${urlHome}resources/js/libs/bootstrap.min.js" type="text/javascript"></script>
<script src="${urlHome}resources/js/app.js" type="text/javascript"></script>


<nav class="navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlHome}">Home</a>
		</div>
		<div id="navbar">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${urlViewUsers}">View Users</a></li>
				<li><a href="${urlAddUser}">Add User</a></li>
			</ul>
		</div>
	</div>
</nav>