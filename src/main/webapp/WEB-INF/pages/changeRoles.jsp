<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="com.web.controller.vo.RoleVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.web.controller.vo.Signup"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<title>Change Role!</title>
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
  	
  	 <span style="color:red;font-weight: bold;">${message}</span>
  	<img src="${signup.photo}"  style="height: 164px">
  	
  	Username : <b>${signup.username}</b>
  	<hr/>
  	<h2>Edit Role Page!!</h2>
  	
  <form action="changeRole" method="Post">	
  <input type="hidden" name="lid" value="${signup.lid}">
  <table class="table table-bordered" style="width: 90%;">
    <thead>
      <tr>
       <th>Rid</th>
        <th>Name</th>
        <th>Description</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
					<c:forEach items="${roleVOs}" var="item" varStatus="paa">
						<tr>
							<td><b>${paa.count}</b></td>
							<td>${item.name}</td>
							<td>${item.description}</td>
							<td><c:choose>
									<c:when test="${item.selected}">
										<input type="checkbox" class="form-control" name="srole"
											value="${item.rid}" checked="checked">
									</c:when>
									<c:otherwise>
										<input type="checkbox" class="form-control" name="srole"
											value="${item.rid}">
									</c:otherwise>
								</c:choose></td>
						</tr>
					</c:forEach>

				</tbody>
  </table>
  <button type="submit" class="btn btn-primary">Update Role</button>
  </form>
  </div>	
	<br/><br/><br/>
</body>
</html>