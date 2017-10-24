<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 <link rel="stylesheet" type="text/css" href="CSS/Registration.css">
<script type="text/javascript">

function validate(){
	console.log("inside")
	

	var email=document.getElementById("email").value;
	var mobileNumber=document.getElementById("mobile").value;
	var confirmPassword=document.getElementById("confirmpassword").value;
	var password=document.getElementById("password").value;
	var emailValidation=/^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
	var mobileValidation=/^((\+)?(\d{2}[-]))?(\d{10}){1}?$/;
	var isError=false;
	
	if(!emailValidation.test(email)) {
		$("#email").css("border-color", "red");
		$("#email").after( "<span id='errors'> <font color= 'red'> Not a valid email </font></span>")

		isError=true;
	} else {
		$("#email").css("border-color", "green");
		$("#errors").remove();

	}
	if(confirmPassword!=password) {
		$("#password").css("border-color", "red");
		$("#confirmpassword").css("border-color", "red");
		$("#confirmpassword").after( "<span id='errors'> <font color= 'red'> passwords are not matching </font></span>")

		isError=true;
	} else {
		$("#password").css("border-color", "green");
		$("#confirmpassword").css("border-color", "green");
		$("#errors").remove();

	}
	if(!mobileValidation.test(mobileNumber)) {
		$("#mobile").css("border-color", "red");
		$("#mobile").after( "<span id='errors'> <font color= 'red'> enter valid 10 digit number </font></span>")

		isError=true;
	} else {
		$("#mobile").css("border-color", "green");
		$("#errors").remove();

	}
	if(isError==true) {
		return false;
	
	}
}

</script>
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
					
					<form action="<%=response.encodeURL("UserRegistration") %>" method="post" onsubmit="return validate()" class="form-signup">
						
						<div class="row">
							
							<div class="col-xs-12 col-sm-12 col-md-12">
								    
								     <span id="reauth-email" class="reauth-email" class="col-xs-12 col-sm-12 col-md-12">
								    </span> 
									<label>User Name</label><br>
									<input type="text" name="User Name" placeholder="Enter your Name" required>
							</div>
						 </div>
									
						 <div class="row">
							
							<div class="col-xs-12 col-sm-12 col-md-12">
					
									<label>Email Id</label><br>
									<input type="email" id="email" name="Email Id" placeholder="Enter your Email" required >
							</div>
						 </div>
						 <div class="row">
							
							<div class="col-xs-12 col-sm-12 col-md-12">
								
								<label>Password</label><br>
								<input type="password" id ="password" name="Password" placeholder="Enter your password" required >
						</div>
						</div>
				
						<div class="row">
							
							<div class="col-xs-12 col-sm-12 col-md-12">
						
								<label>Confirm Password</label><br>
								<input type="password" id ="confirmpassword" name="confirmPassword" placeholder="Re-enter your password" required>
							</div>
						</div>
						<div class="row">
							
							<div class="col-xs-12 col-sm-12 col-md-12">
						
								<label>Mobile Number</label><br>
								<input type="number" id="mobile" name="Mobile Number" placeholder="Enter your  mobile number" required>
							</div>
						</div>
						
						<div class="row">
						
							<div class="col-xs-12 col-sm-12 col-md-12">
						
								<button type="submit" id="button" class="btn btn-lg btn-primary btn-block btn-signup">submit</button>
							
							</div>
						</div>
				
					</form>
			</div>
		</div>
	</div>
</div>
<!--  <script type="text/javascript" src="Registration.js"></script>
 -->
</body>
</html>