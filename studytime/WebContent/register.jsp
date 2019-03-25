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
				Object obj1=request.getAttribute("message1");
				Object obj2=request.getAttribute("message2");
				Object obj3=request.getAttribute("message3");
				if(obj1!=null){
				String msg1 = (String)obj1;%>
				<script>
				alert('<%=msg1%>');
				</script>
				<%}if(obj2!=null){
					String msg2 = (String)obj2;%>
					<script>
					alert('<%=msg2%>');
					</script>
				<%}if(obj3!=null){
					String msg3 = (String)obj3;%>
					<script>
					alert('<%=msg3%>');
					</script>
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
						
							<h4 class="card-title">Register</h4>
							<form action="register" method="POST" class="my-login-validation" novalidate="">
								<div class="form-group">
									<label for="id">Roll no</label>
									<input id="id" type="id" class="form-control" name="id" value="" required autofocus>
									<div class="invalid-feedback">
										id is invalid
									</div>
								</div>
								<div class="form-group">
									<label for="id">First Name</label>
									<input id="id" type="id" class="form-control" name="fname" value="" required autofocus>
									<div class="invalid-feedback">
										id is invalid
									</div>
								</div>
								<div class="form-group">
									<label for="id">Last name</label>
									<input id="id" type="id" class="form-control" name="lname" value="" required autofocus>
									<div class="invalid-feedback">
										id is invalid
									</div>
								</div>
								<div class="form-group">
									<label for="id">Email Address</label>
									<input id="id" type="id" class="form-control" name="email" value="" required autofocus>
									<div class="invalid-feedback">
										id is invalid
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
										Register
									</button>
								</div>
								<div class="mt-4 text-center">
									 <a href="index.jsp">back to login</a>
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