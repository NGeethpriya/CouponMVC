<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Product</title>
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
	<form action="cproduct" method="post">
		<%
		String message = (String) request.getAttribute("mess");
		if (message != null) {
		%>
			<p><%=message%></p>
		<%
		}
		%>
		<table>
			<tr>
				<th colspan="2">CREATE PRODUCT</th>
			</tr>
			<tr>
				<td>Product Name</td>
				<td><input type="text" name="pname" required /></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><input type="text" name="describe" required /></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="text" name="price" required /></td>
			</tr>
			<tr>
				<td>Coupon Code</td>
				<td><input type="text" name="ccode" required /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="SAVE" /></td>
			</tr>
		</table>
	</form>
</body>
</html>