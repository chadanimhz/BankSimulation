<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bank Simulation</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

</head>

<body>
	<section class="container-fluid bg">
		<section class="row justify-content-center">

			<section class="col-12 col-sm-4 col-md-3">
				<form action="login" method="post" class="form-container ">
					<section align="center">
						<h3>Login</h3>
						<c:out value='${message}' />

						<!-- <img src="images/user.png" height="100px" width="100px" />-->

					</section>
					&nbsp;
					<div class="form-group">
						<label for="userEmail">Email address</label> <input type="email"
							name="email" class="form-control" id="userEmail"
							aria-describedby="emailHelp"> <small id="emailHelp"
							class="form-text text-muted">We'll never share your email
							with anyone else.</small>
					</div>
					<div class="form-group">
						<label for="userPassword">Password</label> <input type="password"
							name="password" class="form-control" id="userPassword">
					</div>
					
					<button type="submit" class="btn btn-primary btn-block">Submit</button>
				</form>
			</section>
		</section>

	</section>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous"></script>
</body>
</html>
