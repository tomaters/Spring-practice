<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create account</title>
<!-- Bootstrap: Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<!-- Bootstrap: Latest compiled and minified CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<!-- MENU -->
	<div class="container-lg bg-info mx-auto p-4 border-bottom d-flex justify-content-end">
		<table>
			<tr>
				<td><form action="home.jsp">
						<button type="submit" class="btn btn-light m-2">Return to Home</button>
					</form></td>
				<td><form action="login.jsp">
						<button type="submit" class="btn btn-light m-2">Log In</button>
					</form></td>
		</table>
	</div>
	
	<!-- MAIN -->
	<div class="container-sm mx-auto p-4 border-bottom">
		<h1 class="text-center text-muted">Create an account</h1>
		<div style="text-align: right; font-style: italic;"></div>
		<hr>
		<form id="createAccountForm" action="createAccount.do" method="post"
			onsubmit="return creationSuccess()">
			<div class="message" align="center"
				style="font-weight: bold; margin-bottom: 10px;">
				test</div>
			<table
				class="table text-center table-bordered table-dark w-25 mx-auto shadow"
				style="margin-bottom: 10px;">
				<tr>
					<td>Username</td>
					<td align="left"><input class="w-100 rounded" type="text"
						name="username" onblur="checkUsername()"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td align="left"><input class="w-100 rounded" type="password"
						name="password" size="10"></td>
				</tr>
				<tr>
					<td>Name</td>
					<td align="left"><input class="w-100 rounded" type="text"
						name="name" size="10"></td>
				</tr>
				<tr>
					<td>Email</td>
					<td align="left"><input class="w-100 rounded" type="text"
						name="email" size="10"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><button type="submit"
							class="btn btn-light">Create account</button></td>
				</tr>
			</table>
		</form>
	</div>
</body>
<script>
	function checkUsername(){
		const username = document.getElementById('username').value;
		
		fetch('/api/users/checkUsername?username=${username}')
		.then(response => response.json())
		.then(data => {
			if(data.exists) {
				alert('That username already exists');
			}
		})
		.catch(error => {
			console.error('Error', error);
			alert('An error occurred. Try again');
		});
	}
	
	function creationSuccess(){
		alert("Account created successfully");
		return true;
	}
</script>
</html>