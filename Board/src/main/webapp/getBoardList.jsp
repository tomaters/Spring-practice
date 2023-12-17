<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.mirae.board.implement.BoardDAO" %>
<%@ page import="com.mirae.board.BoardVO" %>

<%
	// retrieve session articles list
	List<BoardVO> boardList = (List)session.getAttribute("boardList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Articles list</title>
</head>
<body>
<center>
<h1>Articles list</h1>
<h3>Welcome</h3>
<h3 align="right"><a href="logout.do">Log out</a></h3>

<!-- Search function -->
<form action="getBoardList.jsp" method="post">
<table border="1" cellpadding="0" cellspacing="0" width="700">
	<tr>
		<td align="right">
			<select name="searchCondition">
			<option value="TITLE">Title
			<option value="CONTENT">Content
			</select>
			<input name="searchKeyword" type="text">
			<input type="submit" value="Search">
		</td>
	</tr>
</table>
</form>

<table border="1" cellpadding="0" cellspacing="0" width="700">
<tr>
	<th width="100">Number</th>
	<th width="200">Title</th>
	<th width="150">Username</th>
	<th width="150">Date</th>
	<th width="100">Views</th>
</tr>

<% for(BoardVO board : boardList) { %>
<tr>
	<td><%= board.getSequence() %></td>
	<td align="left"><a href="getBoard.do?sequence=<%= board.getSequence() %>"><%= board.getTitle() %></a></td>
	<td><%= board.getUsername() %></td>
	<td><%= board.getRegDate() %></td>
	<td><%= board.getCount() %></td>
</tr>
<% } %>
</table>
<br>
<a href="insertBoard.jsp">Register article</a>
</center>
</body>
</html>