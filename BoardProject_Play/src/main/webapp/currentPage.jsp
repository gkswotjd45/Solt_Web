<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="member.vo.Member, board.vo.Board, java.util.List"%>

<% Board board = (Board)request.getAttribute("board");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3><%=board.getBoardNum() %>번 게시글 입니다.</h3>
	<ul>
	
	<li>작성자 ID: <%=board.getBoardAuthor() %> </li><br>
	<li>제목: <%=board.getBoardTitle() %> </li><br>
	<li>글 내용:<%=board.getBoardContent() %></li><br>
	<li>게시일 :<%=board.getBoardDate() %></li><br>
	<li>좋아요 :<%=board.getBoardLike() %></li><br>
	<br>
	</ul>
	<br>
</body>
</html>