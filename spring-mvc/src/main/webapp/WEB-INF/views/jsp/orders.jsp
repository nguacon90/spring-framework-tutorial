<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<spring:url value="/resources/css/style.css" var="styleCss" />
<link href="${styleCss}" rel="stylesheet" />
<title>Home page</title>
</head>
<body>
	<div class="page">
		<div class="listOrders">
			<table class="order-table">
				<tr>
					<th>Order Id</th>
					<th>Placed Time</th>
					<th>Symbol</th>
					<th>Price</th>
					<th>Quantity</th>
				</tr>
				<c:forEach var="order" items="${orders}" varStatus="indexes">
					<tr class="${indexes.index %2 == 0 ? 'even' : 'odd'}">
						<td>${order.id}</td>
						<td><fmt:formatDate pattern="dd-MM-yyyy HH:mm:ss" value="${order.timePlaced}"/></td>
						<td><c:out value="${fn:toUpperCase(order.symbol)}" /></td>
						<td>${order.price}</td>
						<td>${order.quantity}</td>
					</tr>
				</c:forEach>
				<c:if test="${empty orders}">
					<tr>
						<td colspan="5" style="text-align: center;">Không có dữ liệu</td>
					</tr>
				</c:if>
			</table>
		</div>
		<hr />
		<div class="enterOrder">
			<h2>Enter Order</h2>
			<form:form action="placeOrder" commandName="order" method="POST">
				<div>
					<label>Symbol</label>
					<form:input type="text" path="symbol" />
					<form:errors path="symbol" cssClass="error"/>
				</div>
				<div>
					<label>Price</label>
					<form:input type="text" path="price" />
					<form:errors path="price" cssClass="error"/>
				</div>
				<div>
					<label>Quantity</label>
					<form:input type="text" path="quantity" />
					<form:errors path="quantity" cssClass="error"/>
				</div>
				<div>
					<input type="submit" value="Place Order" />
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>