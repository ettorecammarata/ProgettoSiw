<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@page import="java.util.List"%>
<%@page import="persistance.DatabaseManager"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page session="true"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>

<script src="js/jquery-3.3.1.min.js"></script>

<link rel="stylesheet" href="bootstrap-4.1.3/css/bootstrap.min.css">
<script src="bootstrap-4.1.3/js/bootstrap.min.js"></script>

<!--Fontawesome CDN-->
<link rel="stylesheet"  href="fontawesome-free-5.3.1-web/css/all.css" >
<link rel="stylesheet" type="text/css" href="css/Style.css">
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-center h-100">
			<div class="card">
				<div class="card-header">
					<h3>Sign In</h3>

				</div>
				<div class="card-body">
					<form method="POST" class="form-horizontal" action="loginServlet">
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input  class="form-control" name="username" type="text" placeholder="username">

						</div>
						<div class="input-group form-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<input class="form-control" name="password" type="password"placeholder="password">
						</div>
						<div class="row align-items-center remember">
							<input type="checkbox">Remember Me
						</div>
						<div class="form-group">
							<input type="submit" value="Login"
								class="btn float-right login_btn">
						</div>
					</form>
				</div>
				<div class="card-footer">
					<div class="d-flex justify-content-center links">
						Don't have an account?<a href="SignUp.jsp">Sign Up</a>
					</div>
					<div class="d-flex justify-content-center">
						<a href="#">Forgot your password?</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>