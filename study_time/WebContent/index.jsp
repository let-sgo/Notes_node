<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="author" content="Kodinger">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title>My Login Page</title>
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<%
				Object obj2=session.getAttribute("username");
				Object obj3=session.getAttribute("sem");
				if(obj2!=null && obj3!=null){
					String sem = (String)obj3;%>
				<jsp:forward page="dashboard.jsp"></jsp:forward>
				<%}%>
				
			
<body class="my-login-page container" style= "background: url('images/background.png')">
	<section class="h-100">
		<div class="container h-100">

			<div class="row justify-content-md-center h-100">
				<div class="card-wrapper">
					<div class="brand">
						<img src="images/girl.jpg" alt="logo">
                    </div>
                    <center><h2 style="margin-top : 10px; margin-bottom:10px;"><b>StudyTime</b></h2></center>

					<div class="card fat">
						<div class="card-body">
						<%
				Object obj1=request.getAttribute("message");
				if(obj1!=null){
				String msg = (String)obj1;%>
				<h4 style="color:red;"><%=msg%></h4>
				<%}%>
							<h4 class="card-title">Login</h4>
							<form action="login" method="POST" class="my-login-validation" novalidate="">
								<div class="form-group">
									<label for="id">login id</label>
									<input id="id" type="id" class="form-control" name="id" value="" required autofocus>
									<div class="invalid-feedback">
										id is invalid
									</div>
								</div>
								<div class="form-group">
									<label for="sem">semester</label>
									<select name="semester" style="width:100%">
									<option selected disabled>select semester~~</option>
					     				<option  value="3">3</option>
										<option  value="4">4</option>
										<option  value="5">5</option>
										<option  value="6">6</option>
										<option  value="7">7</option>
										<option  value="8">8</option>
									</select>
									
								</div>

								<div class="form-group">
									<label for="password">Password
										<a href="forgot.html" class="float-right">
											Forgot Password?
										</a>
									</label>
									<input id="password" type="password" class="form-control" name="password" required data-eye>
								    <div class="invalid-feedback">
								    	Password is required
							    	</div>
								</div>

								<div class="form-group">
									<div class="custom-checkbox custom-control">
										<input type="checkbox" name="remember" id="remember" class="custom-control-input">
										<label for="remember" class="custom-control-label">Remeber Me</label>
									</div>
								</div>

								<div class="form-group m-0">
									<button type="submit" class="btn btn-primary btn-block">
										Login
									</button>
								</div>
								<div class="mt-4 text-center">
									Don't have an account? <a href="register.jsp">Create One</a>
								</div>
							</form>
						</div>
					</div>
					<div class="footer">
						Copyright &copy; 2019 &mdash; Study Time
					</div>
				</div>
			</div>
		</div>
	</section>

	<script src="js/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="js/my-login.js"></script>
</body>
</html>