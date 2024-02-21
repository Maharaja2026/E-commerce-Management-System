<%@page import="java.util.Base64"%>
<%@ page import="Dto.ProductDto"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{
text-align: center;
background-color: #009E62;
}
#add{
height: 50px;
width: 400px;
line-height:50px;
margin-left: 100px;
margin-bottom: 2px;
}
#add>span{
font-size:x-large;
color: black;
font-family:monospace;
}
#add>a{
padding-top: 10px;
padding-bottom: 10px;
padding-left: 50px;
padding-right: 50px;
background-color: #7829E0;
text-decoration: none;
text-align: center;
color: white;
border-radius: 6px;
font-size: 20px;
}
table {
    background-color: white;
	border-collapse: collapse;
	width: 50%;
	margin-left: 170px;
	border-radius:15px;
    text-align: center;
    width: 1000px;
}

th, td {
	border: 2px solid black;
	text-align: center;
}
th{
height: 2 0px;
font-size: large; 
}
td>a{
text-decoration: none;
padding: 10px;
color: black;
font-weight: bold;
border-radius: 5px;
}
td>#edit{
background-color: green;
border: 1px solid green;	
}
td>#delete{
background-color: red;
border: 1px solid red;	
}
#logout{
margin-top:5px;
background-color: black;
text-align: center;
border-radius: 10px;
color:white;
height:35px;
width: 100px;
font-size: 15px;
}
#logout:hover{
font-size: 17px;
}
</style>
</head>
<body>
    <h1 id="head">PRODUCTS</h1>
    <div id="add">
	<span>Add Product:</span>
	<a href="addproduct.jsp">add</a>
	</div>
	
	<table>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Price</th>
				<th>Brand</th>
				<th>Discount</th>
				<th>Image</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			
           <% List<ProductDto> products = (List)request.getAttribute("products"); %>
           <%for(ProductDto p : products){ %>
                <tr>
                    <td><%= p.getId()%></td>
                    <td><%= p.getName() %></td>
                    <td><%= p.getPrice() %></td>
                    <td><%= p.getBrand() %></td>
                    <td><%= p.getDiscount() %></td>
                    <% String base64image = new String(Base64.getEncoder().encode(p.getImage())); %>
                    <td><img src="data:image/jpeg;base64, <%= base64image %>" height="100px" width="100px"> </td>      
                    <td><a href="edit?id=<%= p.getId() %>" id="edit">edit</a></td>
                    <td><a href="delete?id=<%= p.getId() %>" id="delete">delete</a></td>
                </tr>
           <%} %>
    </table>
    
    <a href="logout"><input type="submit" id="logout" value="Logout"></a>
     


</body>
</html>