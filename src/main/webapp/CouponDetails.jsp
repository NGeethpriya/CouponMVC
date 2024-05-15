<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.coupon.models.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Coupon Details</title>
<link rel="stylesheet" href="Template.css">
<style>
th, td {
	margin: 10px;
	padding: 10px;
	border: 1px solid gray;
}
</style>
</head>
<body>
	<table>
		<tr>
			<th colspan="5"><h3>COUPONS</h3></th>
		</tr>
		<tr>
			<th>S.No</th>
			<th>Coupon Code</th>
			<th>Discount</th>
			<th>Expiry Date</th>
		</tr>
		<%
		Object obj = (Object) request.getAttribute("clist");
		if (obj instanceof List) {
			List<Coupon> coupList = (List<Coupon>) obj;
			for (Coupon c : coupList) {
		%>
		<tr>
			<td><%=c.getCid()%></td>
			<td><%=c.getCcode()%></td>
			<td><%=c.getDiscount()%></td>
			<td><%=c.getEdate()%></td>
		</tr>
		<%
		}
		}
		%>
	</table>
	<center>
		<a href="Home.html">Home</a>
	</center>
</body>
</html>