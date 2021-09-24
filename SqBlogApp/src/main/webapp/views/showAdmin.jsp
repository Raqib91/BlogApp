<%@page import="com.raqib91.entity.Admin"%>
<%@page import="com.raqib91.entity.Blogger"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Admin</title>
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
	font-weight: bold;
	font-size: 20px;
}

form
{
	display: inline;
}
</style>
<body>

	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
	
		if (session.getAttribute("adminUsername") == null)
			response.sendRedirect("Login");
		
		List<Admin> admins = (List<Admin>) request.getAttribute("a");
	%>

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
		<a class="navbar-brand" href="#">Hello Admin!</a>
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="">All Admin</a></li>
			<li><form action="adminLogout" method="post">
					<button type="submit" class="btn btn-danger">Logout</button>
				</form></li>
		</ul>
	</nav>
	
	<div class="container">
		<br>
		<br>
		<br>
		<br>
		<center>
		<ul class="allAdmins">

		</ul>
		</center>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
		crossorigin="anonymous"></script>

	<script type="text/javascript">	
		$(function() {
			<%for (Admin a : admins) {%>
			$('.allAdmins').append('<li><div class="card"><div class="card-body">Admin Id: '+"<%= a.getAdminID()%>"+'<br>Admin Username: ' + "<%= a.getAdminUsername()%>" + '</div></div></li><br><br>');
			<%}%>
		});
		
	</script>

</body>
</html>