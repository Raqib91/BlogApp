<%@page import="com.raqib91.entity.Blogger"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Blog Creation</title>
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
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");

	if (session.getAttribute("bloggerUsername") == null)
		response.sendRedirect("Login");
	%>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
		<a class="navbar-brand" href="#">Hello <%=session.getAttribute("bloggerUsername")%>!
		</a>
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="#">Dashboard</a></li>
			<li><a href="Pending_Blogs" target="_blank"><button type="button"
						class="btn btn-warning">Pending Blogs</button>&nbsp;&nbsp;&nbsp;</a></li>
			<li><a href="Approved_Blogs" target="_blank"><button type="button"
						class="btn btn-success">Approved Blogs</button>&nbsp;&nbsp;&nbsp;</a></li>
			<li><form action="bloggerLogout" method="post">
					<button type="submit" class="btn btn-danger">Logout</button>
				</form></li>
		</ul>
	</nav>

	<div class="container">
		<br> <br> <br> <br>
		<center>
			<div class="card">
				<div class="card-body">
					<form action="createBlog" method="post">
						<div class="form-group">
							<label for="title">Title:</label> <input type="text"
								class="form-control" placeholder="Enter blog title here"
								name="blogTitle" required>
						</div>
						<div class="form-group">
							<label for="content">Content:</label>
							<textarea class="form-control" name="blogContent" rows="3"
								placeholder="Enter blog content here"></textarea>
						</div>
						<input type="hidden" name="blogStatus" value="Pending"> <input
							type="hidden" name="bloggerId"
							value="<%=session.getAttribute("bloggerId")%>">
						<button type="submit" class="btn btn-primary">Create</button>
					</form>
				</div>
			</div>
		</center>
	</div>

</body>
</html>