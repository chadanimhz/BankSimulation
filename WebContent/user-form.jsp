<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Bank Simulation</title>

</head>
<body>

	<header>
		
			<div>
				Bank Simulation
			</div>

	</header>
	<br>
	<div>
		<div>
			<div>
				<c:if test="${user != null}">
					<form action="updateUser" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insertUser" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit User
            		</c:if>
						<c:if test="${user == null}">
            			Add New User
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>User Name</label> <input type="text"
						value="<c:out value='${user.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>User Email</label> <input type="text"
						value="<c:out value='${user.email}' />" class="form-control"
						name="email">
				</fieldset>

				<fieldset class="form-group">
					<label>Type</label> <input type="text"
						value="<c:out value='${user.type}' />" class="form-control"
						name="type">
				</fieldset>
				<fieldset class="form-group">
					<label>Password</label> <input type="password"
						value="<c:out value='${user.password}' />" class="form-control"
						name="password">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>