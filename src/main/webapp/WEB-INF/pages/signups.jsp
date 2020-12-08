<%@page import="java.util.ArrayList"%>
<%@page import="com.web.controller.vo.Signup"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<title>Auth User!</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
  <header style="height: 30px;background-color: #ff5722;">
 </header>
  <div class="container">
   
	  <a href="logout">!!!!Logout</a>
  	<img src="img/login.png" style="height: 164px">
  	 <img src="img/jcoker.png">
  	Current roles  : ${authorities}
  	 <hr/>
  	 <span style="color:red;font-weight: bold;">${message}${param.message}</span>
  	
  	
  <table class="table table-bordered" style="width: 90%;">
    <thead>
      <tr>
       <th>Sid</th>
        <th>Username</th>
        <th>Password</th>
        <th>Name</th>
        <th>Email</th>
        <th>Gender</th>
        <th>Role</th>
        <th>Photo</th>
      </tr>
    </thead>
    <tbody>

				<%
					List<Signup> signups = (List<Signup>) request.getAttribute("dsignups");
					if (signups == null) {
						signups = new ArrayList<>();
					}
					int count=1; 
					for (Signup signup : signups) {
				%>
				<tr>
					<td><%=count++ %>
					 <a href="deleteSignup?username=<%=signup.getUsername()%>">
					    <img src="img/delete.png" style="height: 40px;">
					 </a>
					 <a href="editSignup?username=<%=signup.getUsername()%>">
					    <img src="img/edit.png" style="height: 40px;">
					  </a>
					</td>
					<td>
					
					 <a href="changeRole?username=<%=signup.getUsername()%>">
					    	<img src="img/roles.jpg" style="height: 100px;">
					    </a>
					    <br/>
					<%=signup.getUsername()%></td>
					<td><%=signup.getPassword()%></td>
					<td><%=signup.getName()%></td>
					<td><%=signup.getEmail()%></td>
					<td><%=signup.getGender()%></td>
					<td><%=signup.getRole()%></td>
					<td><img src="<%=signup.getPhoto()%>" style="height: 120px;"></td>
				</tr>
				<%
					}
				%>

			</tbody>
  </table>
  
  </div>	
	<br/><br/><br/>
</body>
</html>