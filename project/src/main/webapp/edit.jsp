<%@page import="java.util.Base64"%>
<%@page import="Dto.ProductDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
background-color: #4070F4;
}
table{
height:350px;
width: 350px;
border-radius:15px;
text-align: center;
position: relative;
left:50px;
}
#edit_module{
border: 3px solid black;
background-color: white;
border-radius: 30px;
height: 510px;
width: 450px;
margin-left: 440px;
margin-top: 100px;
text-align: center;
font-weight: bold;
}
h1{
color: black;
font-weight: bold;
}
#btn{
background-color: green;
text-align: center;
border-radius: 10px;
color:white;
height:35px;
width: 100px;
position: relative;
top: 10px;
font-size: 15px;
}
#btn:hover{
font-size: 17px;
}
#image{
position: relative;
right: 39px;
}
#img{
position: relative;
bottom: 20px;
left: 35 px;
}
</style>
</head>
<body>
<div id="edit_module">
<% ProductDto p = (ProductDto)request.getAttribute("product"); %>
<h1>Edit Product</h1>
<form action="editproduct" method="post" enctype="multipart/form-data">
<table>
<tr>
<td>Product Id</td>
<td><input type="number" name="id" value="<%= p.getId() %>" readonly></td>
</tr>
<tr>
<td>Name</td>
<td><input type="text" name="name" value=" <%= p.getName() %>"></td>
</tr>
<tr>
<td>Price</td>
<td><input type="number" name="price" value="<%= p.getPrice() %>"></td>
</tr>
<tr>
<td>Brand</td>
<td><input type="text" name="brand" value="<%= p.getBrand() %>"></td>
</tr>
<tr>
<td>Discount</td>
<td><input type="number" name="discount" value="<%= p.getDiscount() %>"></td>
</tr>
<tr>  
 <% String base64image = new String(Base64.getEncoder().encode(p.getImage())); %>
<td>Image</td>
<td><img src="data:image/jpeg;base64, <%= base64image %>" id="image" height="100px" width="100px"></td>
</tr>
<tr>
<td></td>
<td><input type="file" name="image" id="img"></td>
</tr>
</table>
<input type="submit" id="btn">
</form>
</div>
</body>
</html>