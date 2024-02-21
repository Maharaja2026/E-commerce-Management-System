<html>
<head>
<title>index</title>
<style type="text/css">
body{
background-color: #7829E0;
}
#main{
border: 2px solid black;
border-radius: 30px;
height:300px;
width: 500px;
text-align: center;
margin-top: 150px;
margin-left: 420px;
background-color: white;
}
#head{
font-size:40px;
font-family: serif;
font-weight: bold;
}
.btn{
padding-top: 10px;
padding-bottom: 10px;
padding-left: 30px;
padding-right: 30px;
border: 3px solid black;
background-color: #7829E0;
text-decoration: none;
text-align: center;
color: white;
border-radius: 10px;
font-size: 20px;
}
.btn:hover{
font-size: 24px;
}
p {
	position:relative;
	left:570px;
	bottom:42px;
	font-weight: bolder;
}
</style>
</head>
<body>
<% String message = (String)request.getAttribute("message"); %>

<% if(message != null){ %>
<h3><%= message %> </h3>
<% } %>
<div id="main">
<h1 id="head">Welcome</h1> <br>
<a href="login.jsp" class="btn">Login</a>
<br><br><br><br>
<a href="signup.jsp" class="btn">Signup</a>
</div>
<p>Create Account?sign-up me!</p>

</body>
</html>
