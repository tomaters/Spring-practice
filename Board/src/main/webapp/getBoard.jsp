<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mirae.board.implement.BoardDAO" %>
<%@ page import="com.mirae.board.BoardVO" %>

<%
	BoardVO board = (BoardVO) session.getAttribute("board");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Articles</title>
</head>
<body>
<center>
<h1>Articles</h1>
<a href="logout.do">Log out</a>
<hr>
<form action="updateBoard.do" method="post">
	<input name="sequence" type="hidden" value="<%= board.getSequence() %>">
	<table border="1" cellpadding="0" cellspacing="0">
		<tr>
			<td width="70">Title</td>
			<td align="left"><input name="title" type="text" value="<%= board.getTitle()%>"></td>
		</tr>
		<tr>
			<td>Username</td>
			<td align="left"><%= board.getUsername() %></td>
		</tr>
		<tr>
			<td>Contents</td>
			<td align="left"><textarea name="content" cols="40" rows="10"><%= board.getContent() %></textarea></td>
		</tr>
		<tr>
			<td>Date</td>
			<td align="left"><%= board.getRegDate() %></td>
		</tr>
		<tr>
			<td>Views</td>
			<td align="left"><%= board.getCount() %></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="Edit board">
			</td>
		</tr>
	</table>
</form>
<hr>
<a href="insertBoard.jsp">Register article</a>&nbsp;&nbsp;&nbsp;
<a href="deleteBoard_proc.do?sequence=<%= board.getSequence()%>">Delete article</a>&nbsp;&nbsp;&nbsp;
<a href="getBoardList.do">Article list</a>
</center>
</body>
</html>