<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write article</title>
<!-- Bootstrap: Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<!-- Bootstrap: Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">	
</head>
<body>
	<div class="container-sm bg-secondary mx-auto p-4 border-bottom">
		<h1 class="text-center text-muted">Write an article</h1>
		<div style="text-align: right; font-style: italic;">
			<a class="text-decoration-none text-muted" href="logout.do"><p class="text-white">Log out</p></a>
		</div>
		<hr>
		<form action="insertBoard.do" method="post">
			<table class="table text-center table-bordered table-dark w-75 mx-auto shadow">
				<tr>
					<td>Title</td>
					<td align="left"><input class="w-75 rounded" type="text" name="title"></td>
				</tr>
				<tr>
					<td>Username</td>
					<td align="left"><input class="w-75 rounded" type="text" name="username" size="10"></td>
				</tr>
				<tr>
					<td>Content</td>
					<td align="left"><textarea name="content" rows="10" cols="80" class="p-2 overflow-auto rounded"></textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><button type="submit" class="btn btn-light">Submit article</button></td>
				</tr>
			</table>
		</form>
		<hr>
		<div style="text-align: right; font-style: italic;">
		<a href="getBoardList.jsp" class="text-muted text-decoration-none"><p class="text-white">Article list</p></a>
		</div>
	</div>
</body>
</html>