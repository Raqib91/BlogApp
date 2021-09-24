<%@page import="com.raqib91.entity.Blog"%>
<%@page import="com.raqib91.entity.Blogger"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
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
ul
{
	list-style: none;
}

.card {
	width: 50%;
	box-shadow: 2px 2px 10px black;
}

.card-body {
	font-size: 20px;
	text-align: left;
}
</style>
<body>
	
	<%
		List<Blog> approvedBlogs = (List<Blog>) request.getAttribute("b");
	%>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
		<a class="navbar-brand" href="#">Welcome to Blog App!</a>
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="#">Home</a></li>
			<li><a href="blogger/Signup" target="_blank"><button
						type="button" class="btn btn-warning">Blogger Signup</button>&nbsp;&nbsp;&nbsp;</a></li>
			<li><a href="blogger/Login" target="_blank"><button
						type="button" class="btn btn-success">Blogger Login</button>&nbsp;&nbsp;&nbsp;</a></li>
			<li><a href="admin/Login" target="_blank"><button
						type="button" class="btn btn-info">Admin Login</button></a></li>
		</ul>
	</nav>

	<div class="container">
		<br> <br> <br> <br>
		<center>
			<ul class="approvedBlogs">

			</ul>
		</center>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
		crossorigin="anonymous"></script>

	<script type="text/javascript">	
		$(function() {
			<%for (Blog b : approvedBlogs) {%>
			$('.approvedBlogs').append('<li><div class="card"><div class="card-body"><h4>@' + "<%= b.getBlogger().getBloggerUsername()%>" + '</h4><br><h5>Blog Title: ' + "<%= b.getBlogTitle()%>" + '</h5><br>Blog Content: ' + "<%= b.getBlogContent()%>" + '<br>Blog Status: ' + "<%= b.getBlogStatus()%>" + '</div></div></li><br><br>');
			<%}%>
		});
		
	</script>

</body>
</html>