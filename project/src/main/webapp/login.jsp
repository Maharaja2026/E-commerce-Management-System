<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{
background-color: #E3AA7B;
}
#login_module{
height: 400px;
width: 550px;
margin-left: 390px;
margin-top: 150px;
text-align: center;
border: 2px solid black;
border-radius: 25px;
background-color: #F1FDCD;
}
table {
height:200px;
width: 300px;
border-radius:15px;
text-align: center;
position: relative;
left:120px;
}
td{
font-size: 20px;
}
h1{
color: black;
font-weight: bold;
}
input[type="submit"]{
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
input[type="submit"]:hover{
font-size: 17px;
}
#warning{
position: relative;
top:100px;
left: 10px;
}
#message{
position: relative;
top:200px;
left: 10px;
}
p {
	font-weight: lighter;
	position: relative;
	top: 35px;
}
p>a{
text-decoration: none;
}
</style>
</head>
<body>
<% String loginMsg = (String)request.getAttribute("login_msg"); %>
<% if(loginMsg != null){ %>
<%= loginMsg %>
<%} %>
<div id="login_module">
<h1>Login</h1>
<form action="login" method="post">
<table>
<tr>
<td>Email</td>
<td><input type="text" name="s_email"></td><% String warning = (String)request.getAttribute("warning"); %>
<% if(warning != null){ %>
<p id="warning"><%= warning %></p>
<%} %>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="s_password"></td><% String message = (String)request.getAttribute("message"); %>
<% if(message != null){ %>
<p id="message"><%= message %></p>
<%} %>
</tr>
</table>
<input type="submit">
<p>Don't have an account? <a href="signup.jsp">Signup</a></p>
</form>
</div>
</body>
</html>