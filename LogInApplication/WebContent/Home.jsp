<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

 <link rel="stylesheet" type="text/css" href="Home.css">

</head>
<body><%
//allow access only if session exists

String userName = null;
if(session.getAttribute("user") == null) {
	response.sendRedirect("LogIn.jsp");
} else {
	userName = (String) session.getAttribute("user");
}

%>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
  <ul>
  <li><a href="#home"><h3>Home</h3></a></li>
  
  
  <li style="float:right">
    <form action="UserLogOut" method="post">
       <button type="submit"class="btn" ><h3>log out</h3></button>&nbsp
     </form>
  </li>
  <li style="float:right"> <h3>Hi,<%=userName %></h3></li>&nbsp
</ul>
 </div>
</nav>
<h1>home page </h1>
</body>
</html>