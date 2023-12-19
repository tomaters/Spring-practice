<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View article</title>
<!-- Bootstrap: Latest compiled and minified CSS -->
<link	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap: Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container-sm bg-secondary mx-auto p-4 border-bottom">
		<h1 class="text-center text-muted"><i>"${user.id}"</i> account information</h1>
		<div style="text-align: right; font-style: italic;">
			<a href="logout.do" class="text-muted text-decoration-none"><p class="text-white">Log out</p></a>
		</div>
		<hr>
		<form action="updateAccount.do" method="post">
			<div class="m-3">
				<table class="table table-bordered table-dark container-sm text-center w-75 mx-auto shadow">
					<tr>
						<td>Username</td>
						<td align="left"><input class="w-75 rounded" name="id" type="text" value="${user.id}"></td>
					</tr>
					<tr>
						<td>Password</td>
						<td align="left"><input class="w-75 rounded" type="password" name="password" placeholder="Enter password to update account information"></td>
					</tr>
					<tr>
						<td>Name</td>
						<td align="left"><input class="w-75 rounded" name="name" type="text" value="${user.name}"></td>
					</tr>
					<tr>
						<td>Role</td>
						<td align="left">${user.role}</td>						
					</tr>
					<tr>
						<td colspan="2" align="center"><button type="submit" class="btn btn-light w-25">Edit account information</button></td>
					</tr>
				</table>
			</div>
		</form>
		<hr>
		<div style="text-align: right; font-style: italic;">
			<a href="deleteAccount.do?id=${user.id}" class="text-muted text-decoration-none"><p class="text-white">Delete account</p></a>
			<a href="getBoardList.do" class="text-muted text-decoration-none"><p class="text-white">Article list</p></a>
		</div>
	</div>
</body>
</html>