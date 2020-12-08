<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<title>Auth User!</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<header style="height: 30px; background-color: #ff5722;"> </header>

	<div class="container">
		<img src="${pageContext.request.contextPath}/img/login.png"
			style="height: 164px"> <span
			style="color: red; font-weight: bold;">${message}${param.message}</span>
		<img src="${pageContext.request.contextPath}/img/jcoker.png">

		<form action="${pageContext.request.contextPath}/forgetPswd" method="post">
			<div class="form-group">
				<label>Username </label> <input type="text" name="username"
					class="form-control" style="width: 60%;">
			</div>

			<div class="form-group">
				<span style="text-align: center; margin-bottom: 15px;"> A
					OneTimePswd will be sent to your email...</span><br />
				<button type="submit" class="btn btn-warning">Change Pswd</button>
			</div>
		</form>

		<div id="forgetPswd" class="modal fade" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h3 class="modal-title">Forgot Password</h3>
						<button type="button" class="close" data-dismiss="modal">&times;</button>

					</div>
					<div class="modal-body">
						<form action="changePswd" method="post">

							<div class="form-group">
								<input type="text" name="identity" id="identity"
									style="width: 150px;" placeHolder="Insert Username or Email">
							</div>

							<span style="text-align: center;"> A OPT is send to your
								email</span>

							<div class="form-group">
								<button type="submit" class="btn btn-warning">Change
									Pswd</button>
							</div>

						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
	<br />
	<br />
	<br />
</body>
</html>