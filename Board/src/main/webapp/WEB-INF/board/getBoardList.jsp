<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!--  replaced with JSTL
page import="java.util.List"
page import="com.mirae.board.implement.BoardDAO"
page import="com.mirae.board.BoardVO"

List<BoardVO> boardList = (List) session.getAttribute("boardList");
 -->
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>
<!-- Bootstrap: Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap: Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container-lg bg-secondary mx-auto p-4 border-bottom">
		<!-- name set as session attribute upon login -->
		<h1 class="text-center text-muted">Hello, ${name}</h1>
		<h6 align="right">
			<div style="text-align: right; font-style: italic;">
				<a class="text-decoration-none text-muted" href="logout.do"><p class="text-white">Log out</p></a>
			</div>
			<div style="text-align: right; font-style: italic;">
				<a class="text-decoration-none text-muted" href="viewAccount.do?user=${user.id}"><p class="text-white">View account info</p></a>
			</div>
		</h6>

		<!-- Search function -->
		<form action="getBoardList.do" method="post">
			<table class="table text-center table-bordered table-dark w-75 mx-auto shadow-lg">
				<tr>
					<td align="right">
						
						<!-- <select class="rounded" name="searchCondition">
							<option value="title">Title
							<option value="username">Username
							<option value="content">Content
						</select> --> 

							<select name="searchCondition">
								<option value="">Select option</option>
								<c:forEach items="${conditionMap}" var="data">
									<option value="${data.value}">${data.key}</option>
								</c:forEach>
							</select>
							<input name="searchKeyword" type="text"/>
							<input type="submit" value="Search"/>
						
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

			<c:forEach items="${boardList}" var="board">
				<tr>
					<td>${board.sequence}</td>
					<td align="left"><a class="text-decoration-none"	href="getBoard.do?sequence=${board.sequence}">${board.title}</a></td>
					<td>${board.username}</td>
					<td>${board.regDate}</td>
					<td>${board.count}</td>
				</tr>
			</c:forEach>
			
			<!-- replaced with JSTL
			for (BoardVO board : boardList) {
			>
			<tr>
				<td><=board.getSequence()%></td>
				<td align="left"><a class="text-decoration-none "	href="getBoard.do?sequence=<=board.getSequence()%>"><=board.getTitle()%></a></td>
				<td><=board.getUsername()%></td>
				<td><=board.getRegDate()%></td>
				<td><=board.getCount()%></td>
			</tr>
			<}>  -->
		</table> 
			<div style="text-align: center; font-style: italic;">
				<a class="text-decoration-none text-muted" href="insertBoard.jsp"><p class="text-white">Submit an article<p></a>
			</div>
	</div>
	<a href="dataTransform.do">Data transform</a>
</body>
</html>