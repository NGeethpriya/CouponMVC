<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find Coupon</title>
<link rel="stylesheet" href="Template.css">
</head>
<body>
<form action = "ccoupon" method = "get">
<% String message = (String) request.getAttribute("message");
if (message != null){%>
<table><tr><td><%=message %></td></tr></table>
<%} %>
	<table>
		<tr>
			<th colspan="2">FIND COUPON</th>
		</tr>
		<tr>
			<td>Coupon Code</td>
			<td><input type="text" name="ccode" required/></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="FIND" /></td>
		</tr>
	</table>
	</form>
</body>
</html>