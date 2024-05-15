<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.coupon.models.Coupon"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Template.css">
<title>Success</title>
<style>
td {
	margin: 10px;
	padding: 10px;
	border: 1px solid gray;
	border-radius: 5px;
}
</style>
</head>
<body>

		<%
		String message = (String) request.getAttribute("mess");
		if (message != null) {
		%><table><tr><td><%=message%></td></tr></table>
		<%
		} else {
		Coupon coup = (Coupon) request.getAttribute("coup");
		%>
		<table>
		<tr>
			<th colspan="2">COUPON DETAILS</th>
		</tr>
		<tr></tr>
		<tr>
			<td>Coupon Code</td>
			<td><%=coup.getCcode()%></td>
		</tr>
		<tr>
			<td>Discount</td>
			<td><%=coup.getDiscount()%></td>
		</tr>
		<tr>
			<td>Expiry Date</td>
			<td><%=coup.getEdate()%></td>
		</tr>
		</table>
		<%
		}
		%>
			<center><a href="Home.html">BACK</a></center>


</body>
</html>