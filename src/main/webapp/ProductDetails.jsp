<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.coupon.models.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Details</title>
<link rel = "stylesheet" href = "Template.css">
<style>
th, td{
	margin : 10px;
	padding : 10px;
	border : 1px solid gray;
	}

</style>
</head>
<body>
	<table>
	<tr><th colspan = "5"><h3>PRODUCTS</h3></th></tr>
		<tr>
			<th>S.No</th>
			<th>Product Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>Coupon Code</th>
		</tr>
<% Object obj = (Object) request.getAttribute("plist");
if (obj instanceof List){
	List<Product> proList = (List<Product>)obj; 
	for(Product p : proList){%>
		<tr>
			<td><%=p.getPid() %></td>
			<td><%=p.getPname() %></td>
			<td><%=p.getDescription() %></td>
			<td><%=p.getPrice() %></td>
			<td><%=p.getCcode() %></td>
		</tr>
		<%}} %>
	</table>
	<center><a href = "Home.html">Home</a></center>
</body>
</html>