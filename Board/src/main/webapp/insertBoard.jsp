<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write a new article</title>
</head>
<body>
<center>
<h1>Register article</h1>
<a href="logout.do">Log out</a>
<hr>
<form action="insertBoard.do" method="post">
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td width="70">Title</td>
			<td align="left"><input type="text" name="title"></td>
		</tr>
		<tr>
			<td>Username</td>
			<td align="left"><input type="text" name="username" size="10"></td>
		</tr>
		<tr>
			<td>Content</td>
			<td align="left"><textarea name="content" rows="10" cols="40"></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="Register article">
			</td>
		</tr>
	</table>
</form>
<hr>
<a href="getBoardList.jsp">View articles list</a>
</center>
</body>
</html>