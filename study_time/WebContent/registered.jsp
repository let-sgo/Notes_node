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
						<h4>Successfully Registered!</h4></br>
						<h4>Check your mail for login id and password</h4></br>
						<a href="index.jsp">Back to login</a>
							
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