<%@page import="board.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Board board = (Board)session.getAttribute("board"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>수정 페이지</h2>
<ul>
	<form action="postChange" method="post">
	<ul>
	<li>제목: <input type="text" name="postTitle" value = <%=board.getBoardTitle() %>> </li><br>
	<li>글 내용: </li><br>
	<textarea cols="50" rows="10" name="postContent"><%= board.getBoardContent()%> </textarea><br>
	<button type="submit">수정하기</button>
	</ul>
	</form>
</ul>
</body>
</html>