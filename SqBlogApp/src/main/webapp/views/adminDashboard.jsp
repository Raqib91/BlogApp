<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<style type="text/css">
.card {
	box-shadow: 2px 2px 10px black;
}

.card-header {
	background-color: aquamarine;
	font-weight: bold;
	font-size: 20px;
}
</style>

</head>
<body>

	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
	
		if (session.getAttribute("adminUsername") == null)
			response.sendRedirect("Login");
	%>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
		<a class="navbar-brand" href="#">Hello Admin!</a>
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="#">Home</a></li>
			<li><form action="adminLogout" method="post">
					<button type="submit" class="btn btn-danger">Logout</button>
				</form></li>
		</ul>
	</nav>

	<div class="container">
		<br> <br> <br> <br>
		<div class="row">
			<div class="col-md-5">
				<div class="card">
					<div class="card-header">Create Admin</div>
					<div class="card-body">
						<a href="create" target="_blank">Click here to create new
							admin</a>
					</div>
				</div>
			</div>
			<div class="col-md-2"></div>
			<div class="col-md-5">
				<div class="card">
					<div class="card-header">Show Admin</div>
					<div class="card-body">
						<a href="all" target="_blank">Click here to see all admin</a>
					</div>
				</div>
			</div>
		</div>
		<br> <br>

		<div class="row">
			<div class="col-md-5">
				<div class="card">
					<div class="card-header">Pending Blogger</div>
					<div class="card-body">
						<a href="Pending_Bloggers" target="_blank">Click here to see
							pending bloggers</a>
					</div>
				</div>
			</div>
			<div class="col-md-2"></div>
			<div class="col-md-5">
				<div class="card">
					<div class="card-header">Approved Blogger</div>
					<div class="card-body">
						<a href="Approved_Bloggers" target="_blank">Click here to see
							approved bloggers</a>
					</div>
				</div>
			</div>
		</div>
		<br> <br>

		<div class="row">
			<div class="col-md-5">
				<div class="card">
					<div class="card-header">Pending Blog</div>
					<div class="card-body">
						<a href="Pending_Blogs" target="_blank">Click here to see pending blogs</a>
					</div>
				</div>
			</div>
			<div class="col-md-2"></div>
			<div class="col-md-5">
				<div class="card">
					<div class="card-header">Approved Blog</div>
					<div class="card-body">
						<a href="Approved_Blogs" target="_blank">Click here to see approved blogs</a>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>