<%@page import="com.raqib91.entity.Blogger"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Blogger Login</title>
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

<style type="text/css">
.card {
	width: 50%;
	box-shadow: 2px 2px 10px black;
}

label {
	font-weight: bold;
}
</style>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
		<a class="navbar-brand" href="#">Welcome to Blog App!</a>
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="#">Blogger
					Login</a></li>
		</ul>
	</nav>

	<div class="container">
		<br> <br> <br> <br>
		<center>
			<div class="card">
				<div class="card-body">
					<form action="bloggerLogin" method="post">
						<div class="form-group">
							<label for="username">Username:</label> <input type="text"
								class="form-control" placeholder="Enter username here"
								name="username" required>
						</div>
						<div class="form-group">
							<label for="pwd">Password:</label> <input type="password"
								class="form-control" placeholder="Enter password here"
								name="password" required>
						</div>
						<button type="submit" class="btn btn-primary">Login</button>
					</form>
				</div>
			</div>
		</center>
	</div>

</body>
</html>