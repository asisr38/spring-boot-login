<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<title>Signup User!</title>
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

	<a href="logout">!!!!Logout</a>

	<div class="container">
		<h3>Signup Page</h3>
		<form action="signup" method="post">
			<div class="form-group">
				<label>Username</label> <input type="text" name="username"
					class="form-control" style="width: 60%;">
			</div>
			<div class="form-group">
				<label>Password</label> <input type="password" name="password"
					class="form-control" style="width: 60%;">
			</div>

			<div class="form-group">
				<label>Name</label> <input type="text" name="name"
					class="form-control" style="width: 60%;">
			</div>

			<div class="form-group">
				<label>Email</label> <input type="email" name="email"
					class="form-control" style="width: 80%;">
			</div>

			<div class="form-group">
				<label>Role</label> <select name="role" class="form-control"
					style="width: 40%;">
					<cp:forEach items="${roleVos}" var="item">
						<option>${item.name}</option>
					</cp:forEach>
					
				</select> <img src="img/jcoker.png" style="height: 40px; display: inline;">
			</div>


			<div class="form-group">
				<label>Gender</label> <select name="gender" class="form-control"
					style="width: 40%;">
					<option>Male</option>
					<option>Female</option>
					<option>Other</option>
				</select>
			</div>


			<div class="form-group">
				<label>Photo URL</label> <input type="text" name="photo"
					class="form-control" style="width: 80%;">
			</div>

			<div class="form-group">
				<button type="submit" class="btn btn-primary">Signup</button>
				<a href="login.jsp"><button type="button" class="btn btn-danger">Sign
						In</button></a>
			</div>
		</form>
		<hr />

	</div>
	<br />
	<br />
	<br />
</body>
</html>