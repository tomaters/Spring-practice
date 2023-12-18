<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.mirae.board.implement.BoardDAO"%>
<%@ page import="com.mirae.board.BoardVO"%>

<%
// retrieve session articles list
List<BoardVO> boardList = (List) session.getAttribute("boardList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Articles list</title>
<!-- Bootstrap: Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap: Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container-sm bg-secondary mx-auto p-4 border-bottom">
		<h1 class="text-center text-muted">Articles list</h1>
		<h5 align="right">
			<div style="text-align: right; font-style: italic;">
			<a class="text-decoration-none text-muted" href="logout.do"><p class="text-white">Log out</p></a>
			</div>
		</h5>

		<!-- Search function -->
		<form action="getBoardList.jsp" method="post">
			<table class="table text-center table-bordered table-dark w-75 mx-auto shadow-lg">
				<tr>
					<td align="right">
						<select class="rounded" name="searchCondition">
								<option value="TITLE">Title
								<option value="CONTENT">Content
						</select> 
						<input class="rounded" name="searchKeyword" type="text"> 
						<input type="submit" value="Search">
						</td>
				</tr>
			</table>
		</form>

		<table class="table table-bordered table-hover text-center table-dark table-sm w-75 mx-auto shadow">
			<thead>
				<tr>
					<th width="50">Article</th>
					<th width="250">Title</th>
					<th width="150">Username</th>
					<th width="100">Date</th>
					<th width="50">Views</th>
				</tr>
			</thead>

			<%
			for (BoardVO board : boardList) {
			%>
			<tr>
				<td><%=board.getSequence()%></td>
				<td align="left"><a class="text-decoration-none "	href="getBoard.do?sequence=<%=board.getSequence()%>"><%=board.getTitle()%></a></td>
				<td><%=board.getUsername()%></td>
				<td><%=board.getRegDate()%></td>
				<td><%=board.getCount()%></td>
			</tr>
			<%
			}
			%>
		</table> 
			<div style="text-align: center; font-style: italic;">
				<a class="text-decoration-none text-muted" href="insertBoard.jsp"><p class="text-white">Submit an article<p></a>
			</div>
	</div>
</body>
</html>