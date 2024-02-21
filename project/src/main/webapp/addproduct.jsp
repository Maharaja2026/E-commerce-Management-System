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
#add_module{
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
</style>
</head>
<body>
<div id="add_module">
<h1>Add Product</h1>   
<form action="addproduct" method="post" enctype="multipart/form-data">
<table>
<tr>
<td>Product id</td>
<td><input type="number" name="product_id"></td>
</tr>
<tr>
<td>Name</td>
<td><input type="text" name="product_name"></td>
</tr>
<tr>
<td>Price</td>
<td><input type="number" name="product_price"></td>
</tr>
<tr>
<td>Brand</td>
<td><input type="text" name="product_brand"></td>
</tr>
<tr>
<td>Discount</td>
<td><input type="number" name="product_discount"></td>
</tr>
<tr>
<td> Image</td>
<td><input type="file" name="product_image"></td>
</tr>
</table>
<input type="submit" id="btn">
</form>
</div>
</body>
</html>