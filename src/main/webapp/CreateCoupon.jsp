<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Coupon</title>
<link rel="stylesheet" href="Template.css">
</head>
<style>
p{
	text-align : center;
	color : tomato;
	padding : 15px;
	margin-top : 20px;
	font-size : 20px;
	border : 2px solid tomato;
}
</style>
<body>
	<form action="ccoupon" method="post">

		<%
		String message = (String) request.getAttribute("message");
		if (message != null) {
		%>
		<p><%=message%></p>
		<%
		}
		%>
		<table>
			<tr>
				<th colspan="2">CREATE COUPON</th>
			</tr>
			<tr>
				<td>Coupon Code</td>
				<td><input type="text" name="ccode" required /></td>
			</tr>
			<tr>
				<td>Discount</td>
				<td><input type="text" name="discount" required /></td>
			</tr>
			<tr>
				<td>Expiry Date</td>
				<td><input type="text" name="edate" required /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="SAVE" /></td>
			</tr>
		</table>
	</form>
</body>
</html>