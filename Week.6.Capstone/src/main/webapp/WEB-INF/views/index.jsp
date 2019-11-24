<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/sketchy/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-N8DsABZCqc1XWbg/bAlIDk7AS/yNzT5fcKzg/TwfmTuUqZhGquVmpb5VvfmLcMzp"
	crossorigin="anonymous">

<link href="styles.css" rel="stylesheet">

</head>
<body>
	<div class="container">

		<h1>Welcome</h1>

		<button class="btn btn-primary"
			onclick="document.getElementById('id01').style.display='block'"
			style="width: auto;">Login</button>

		<div id="id01" class="modal">

			<form class="modal-content animate" action="/login-user"
				method="post">
				<div class="imgcontainer">
					<span
						onclick="document.getElementById('id01').style.display='none'"
						class="close" title="Close Modal">&times;</span>
				</div>

				<div class="container">
					<label for="email"><b>Email Address</b></label> 
					<input type="text" placeholder="Enter email address" name="email" required> 
					<label for="password"><b>Password</b></label> 
					<input type="password" placeholder="Enter Password" name="password" required>
					<button type="submit">Login</button>
				</div>

				<div class="container" style="background-color: #f1f1f1">
					<button type="button"
						onclick="document.getElementById('id01').style.display='none'"
						class="cancelbtn">Cancel</button>
				</div>
			</form>
		</div>

		<a class="btn btn-primary" href="/new-account">New Account</a>

	</div>
	<script>
		var modal = document.getElementById('id01');

		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	</script>
</body>
</html>