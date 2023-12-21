<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${username}</title>
<!-- Bootstrap: Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap: Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<!-- TOP LEFT MENU BAR -->
	<div class="container-lg bg-info mx-auto p-4 border-bottom d-flex justify-content-end">
		<table>
			<tr>
			<td><form action="logout.do">
				<button type="submit" class="btn btn-light m-2">Log Out</button>
			</form></td>
			<td><form action="viewAccount.do">
				<button type="submit" class="btn btn-light m-2">My Account</button>
			</form></td>
		</table>
	</div>
	
	<!--  extra space -->
	<div class="m-5"></div>
	
	<!-- USER INFO -->
	<div class="container-lg mx-auto p-4 d-flex flex-row justify-content-around align-items-center">
		<div id="welcome_profile">
			<div style="border: 1px solid gray; border-radius: 10%; padding: 15px;"><img src="${profpic_path}" alt="Profile picture" class="img-fluid"></div>
			<div style="margin-top: 15px; font-weight: bold; text-align: center;">
				<p>Upload Profile Picture</p>
				<form action="submitProfpic.do">
					<div class="d-flex flex-row align-items-center justify-content-center">
						<div><input type="file" class="form-control" id="profpic"/></div>
						<div><button type="submit" class="btn btn-light ms-2">Submit</button></div>
					</div>
				</form>
			</div>
		</div>
		<div>
			<table class="table table-striped table-hover">
				<tr>
					<td>Username</td>
					<td>${username}</td>
				</tr>
				<tr>
					<td>Email</td>
					<td>${email}</td>
				</tr>
				<tr>
					<td>Account creation date</td>
					<td>${reg_date}</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>