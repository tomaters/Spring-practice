<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create account</title>
<!-- Bootstrap: Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<!-- Bootstrap: Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">	
</head>
<body>
	<div class="container-sm bg-secondary mx-auto p-4 border-bottom">
		<h1 class="text-center text-muted">Create an account</h1>
		<div style="text-align: right; font-style: italic;">
			<a class="text-decoration-none text-muted" href="login.do"><p class="text-white">Sign in</p></a>
		</div>
		<hr>
		<form action="createAccount.do" method="post" onsubmit="return creationSuccess()">
			<div class="message" align="center" style="color: white; font-weight: bold; margin-bottom: 10px;"> test </div>
			<table class="table text-center table-bordered table-dark w-25 mx-auto shadow" style="margin-bottom: 10px;">
				<tr>
					<td>Username</td>
					<td align="left"><input class="w-100 rounded" type="text" name="id" onblur="checkDuplicate()"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td align="left"><input class="w-100 rounded" type="password" name="password" size="10"></td>
				</tr>
				<tr>
					<td>Name</td>
					<td align="left"><input class="w-100 rounded" type="text" name="name" size="10"></td>
				</tr>
				<tr>
					<td>Role</td>
					<td align="left">
					<select class="w-100 rounded" name="role">
								<option value="User">User
								<option value="Admin">Admin
						</select> 
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><button type="submit" class="btn btn-light">Create account</button></td>
				</tr>
			</table>
		</form>
		<hr>
	</div>
</body>
<script>
	function creationSuccess(){
			alert("Account created successfully");
			return true;
	}
</script>
</html>