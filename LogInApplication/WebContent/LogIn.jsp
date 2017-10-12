<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

  <link  rel="stylesheet" type="text/css" href="LogIn.css">
 <script type="text/javascript">
 function validate(){
		var email=document.getElementById("email").value;
	
		var emailValidation=/^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
		if(!emailValidation.test(email)) {
			$("#email").css("border-color", "red");
			$("#email").after( "<span id='errors'> <font color= 'red'> Not a valid email </font></span>")

			//alert("Enter valid email address");
			return false;
		} else {
			$("#email").css("border-color", "green");
			$("#email").removeClass("errors");
		}
 }
 
 </script>
<title>Log in</title>
</head>
<body>

<div class="container" >
       
        <div class="card card-container">
 <font color="red">      
 <%
	String message=(String)request.getAttribute("error");
	if(message!=null) {
		out.println(message);
		request.removeAttribute("error");
	}
%>
</font> 
			<div class="row">
					
			<div class="col-xs-12 col-sm-12 col-md-12">
			<form action="UserLogIn" method="get" class="form-signin" onsubmit="return validate()">
						
						<div class="row">
							
							<div class="col-xs-12 col-sm-12 col-md-12">
								    
								    <span id="reauth-email" class="reauth-email" class="col-xs-12 col-sm-12 col-md-12">
								    </span>
									
									<label> Email Id</label>
				               	    
				               	    <input type="email" id="email" name ="email id" placeholder="Enter your Email" required>
							 </div>
						</div>		 
					<div class="row">
							
							<div class="col-xs-12 col-sm-12 col-md-12">
									
									<label>Password </label>
				                   
				                    <input type="password" name= "password" placeholder="Enter your password" required>
							</div>
					</div>
					<div class="row">
						
						<div class="col-xs-12 col-sm-12 col-md-12">
						
							<button type="submit"  class="btn btn-lg btn-primary btn-block btn-signin">log in</button>	
						
						</div>
					</div>
					
							
								
			</form>
		</div>
	</div>
	<a href="UserRegistration.jsp"style="text-decoration: none;"><button type="submit" id="button"  class="btn btn-lg btn-primary btn-block btn-signin">Register</button></a> 
			
   </div><!-- /card-container -->
</div><!-- container -->
<!--  <script type="text/javascript" src="login.js"></script>
 -->
</body>
</html>