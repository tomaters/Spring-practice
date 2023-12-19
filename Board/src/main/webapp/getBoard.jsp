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
		<h1 class="text-center text-muted">Article by <i>"${board.username}"</i></h1>
		<div style="text-align: right; font-style: italic;">
			<a href="logout.do" class="text-muted text-decoration-none"><p class="text-white">Log out</p></a>
		</div>
		<hr>
		<form action="updateBoard.do" method="post">
			<input name="sequence" type="hidden" value="${board.sequence}">
			<div class="m-3">
				<table class="table table-bordered table-dark container-sm text-center w-75 mx-auto shadow">
					<tr>
						<td>Title</td>
						<td align="left"><input class="w-75 rounded" name="title" type="text" value="${board.title}"></td>
					</tr>
					<tr>
						<td>Username</td>
						<td align="left">${board.username}</td>
					</tr>
					<tr>
						<td>Content</td>
						<td align="left"><textarea class="p-2 overflow-auto rounded"
								name="content" cols="80" rows="10">${board.content}</textarea></td>
					</tr>
					<tr>
						<td>Date</td>
						<td align="left">${board.regDate}</td>
					</tr>
					<tr>
						<td>Views</td>
						<td align="left">${board.count}</td>
					</tr>
					<tr>
						<td colspan="2" align="center"><button type="submit" class="btn btn-light w-25">Edit article</button></td>
					</tr>
				</table>
			</div>
		</form>
		<hr>
		<div style="text-align: right; font-style: italic;">
			<a href="insertBoard.jsp" class="text-muted text-decoration-none"><p class="text-white">Submit an article</p></a>
			<a href="deleteBoard.do?sequence=${board.sequence}" class="text-muted text-decoration-none"><p class="text-white">Delete article</p></a>
			<a href="getBoardList.do" class="text-muted text-decoration-none"><p class="text-white">Article list</p></a>
		</div>
	</div>
</body>
</html>