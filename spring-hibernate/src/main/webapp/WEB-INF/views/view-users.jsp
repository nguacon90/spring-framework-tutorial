<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="en">

<jsp:include page="header.jsp" />
<body>
	<div class="container">

		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>

		<h1>User Detail</h1>
		<br />

		<div class="row">
			<label class="col-sm-2">ID</label>
			<div class="col-sm-10">
				<c:out value="${id}" /> 
			</div>
		</div>

		<div class="row">
			<label class="col-sm-2">Name</label>
			<div class="col-sm-10">${user.name}</div>
		</div>

		<div class="row">
			<label class="col-sm-2">Email</label>
			<div class="col-sm-10">${user.email}</div>
		</div>

		<div class="row">
			<label class="col-sm-2">Gender</label>
			<div class="col-sm-10"><c:if test="${user.gender == 'M'}">Male</c:if> <c:if test="${user.gender == 'F'}">Female</c:if></div>
		</div>

	</div>

</body>
</html>