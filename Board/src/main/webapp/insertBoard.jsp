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
		<form action="insertBoard.do" method="post" name="writeform" onsubmit="return creationSuccess()" enctype="multipart/form-data">
			<!-- hidden input field to hold id value -->
			<input type="hidden" name="username" value="${id}"> 
			<table class="table text-center table-bordered table-dark w-75 mx-auto shadow">
				<tr>
					<td>Title</td>
					<td align="left"><input class="w-75 rounded" type="text" name="title"></td>
				</tr>
				<tr>
					<td>Username</td>
					<td align="left">${id}</td>
				</tr>
				<tr>
					<td>Content</td>
					<td align="left"><textarea name="content" rows="10" cols="80" class="p-2 overflow-auto rounded"></textarea></td>
				</tr>
				<tr>
					<td>Upload File</td>
					<td align="left"><input type="file" name="uploadFile"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
					<input type="button" class="btn btn-light" onclick="checkNull()" value="Submit article"/></td>
				</tr>
			</table>
		</form>
		<hr>
		<div style="text-align: right; font-style: italic;">
		<a href="getBoardList.do" class="text-muted text-decoration-none"><p class="text-white">Article list</p></a>
		</div>
	</div>
</body>

<script>
	function checkNull() {
		if(document.writeform.title.value=="") {
			alert("Please enter a title");
			document.writeform.title.focus();
			return;
		}
		if(document.writeform.username.value==""){
			document.writeform.username.focus();
			alert("You are not logged in");
			return;
		}
		if(document.writeform.content.value==""){
			alert("Please enter the content");
			document.writeform.content.focus();
			return;
		}
		document.writeform.submit();
	}
	
	function creationSuccess() {
		alert("Article created successfully");
		return true;
	}
	</script>
</html>