<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Timeline</title>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<!-- Bootstrap: Latest compiled and minified CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<!-- CSS -->
<link rel="stylesheet" href="resources/css/styles.css">

<body>
	<!-- TOP LEFT MENU BAR -->
	<div class="container-lg bg-info mx-auto p-4 border-bottom d-flex justify-content-end">
		<table>
			<tr>
			<td><form action="logout.do">
				<button type="submit" class="btn btn-light m-2">Log Out</button>
			</form></td>
			<td><form action="myAccount.do">
				<button type="submit" class="btn btn-light m-2">My Account</button>
			</form></td>
		</table>
	</div>
	
	<!--  extra space -->
	<div class="m-5"></div>
	
	<!-- USER INFO -->
	<div class="container-lg mx-auto p-4 d-flex justify-content-end">
		<div id="welcome_profile">
				<div id="profile_greeting" class="text-center">Hello, ${user.name}</div>
				<div class=""><img src="images/${profpic_path}" alt="Profile picture" class="img-fluid"></div>
		</div>
	</div>
	
	<!-- TIMELINE -->
	<div class="container-fluid mx-auto bg-light p-4 d-flex justify-content-center">
	Timeline
	</div>
</body>
</html>