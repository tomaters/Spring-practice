<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete board</title>
<!-- Bootstrap: Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<!-- Bootstrap: Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">	
<script>
	function redirectToArticleList() {
		setTimeout(function(){
			window.location.href = "getBoardList.do";
		}, 2000);
	}
	window.onload = redirectToArticleList();
</script>
</head>
<body>
	<div class="container-sm bg-light mx-auto p-4 border-bottom">
			<h1 class="text-center text-success">Article successfully deleted</h1>
			<h4 class="text-center text-muted">Returning to article list...</h4>
	</div>
</body>
</html>