<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="member.vo.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp new Post</title>
</head>
<body>
	<h3>새글 작성</h3>
	<form action="firstpost" method="post">
	<ui>
	<li>제목: <input type="text" name="postTitle"></li>
	<br>
	<li>작성자: <%=((Member) session.getAttribute("member")).getMemberName()%></li>
	<br>
	<li><span>내용 </span></li>
	<textarea cols="50" rows="10" name="postContent"></textarea> </ui>
	<br>
	<button type="submit">작성하기</button>
	</form>
</body>
</html>