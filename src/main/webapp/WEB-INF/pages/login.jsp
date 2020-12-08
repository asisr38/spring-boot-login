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

		<form action="${pageContext.request.contextPath}/auth" method="post">
			<div class="form-group">
				<label>Username</label> <input type="text" name="username"
					class="form-control" style="width: 60%;">
			</div>
			<div class="form-group">
				<label>Password</label> <input type="password" name="password"
					class="form-control" style="width: 60%;">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Authenticate</button>
				<button type="reset" class="btn btn-warning">Reset</button>
				<a href="signup"><button type="button" class="btn btn-danger">Sigup</button></a>
				<a href="${pageContext.request.contextPath}/forgetPswd"><button type="button"
						class="btn btn-secondary">Forgot Password</button></a>
			</div>
		</form>
		<hr />
		Result is <span style="color: red; font-weight: bold;">${message}</span>
		<hr />
		<table class="table table-bordered" style="width: 90%;">
			<thead>
				<tr>
					<th>Username</th>
					<th>${data['username']}</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Name</td>
					<th>${data['name']}</th>
				</tr>
				<tr>
					<td>Email</td>
					<th>${data['email']}</th>
				</tr>
				<tr>
					<td>Role</td>
					<th>${data['role']}</th>
				</tr>

				<tr>
					<td>Gender</td>
					<th>${data['gender']}</th>
				</tr>

				<tr>
					<td>Photo</td>
					<td><img src="${data['photo']}" style="height: 150px;]" /></td>
				</tr>

			</tbody>
		</table>

		

	</div>
	<br />
	<br />
	<br />
</body>
</html>