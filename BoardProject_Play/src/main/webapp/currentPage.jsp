<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="member.vo.Member, board.vo.Board, java.util.List"%>
	<% Board board = (Board)request.getAttribute("board"); 
		session.setAttribute("post",board);
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="postDelete" method="post">
	
	<h3><%=board.getBoardNum() %>번 게시글 입니다.</h3>
	<ul>
	<li>작성자 ID: <%=board.getBoardAuthor() %> </li><br>
	<li>제목: <%=board.getBoardTitle() %> </li><br>
	<li>글 내용:<%=board.getBoardContent() %></li><br>
	<li>게시일 :<%=board.getBoardDate() %></li><br>
	<li>좋아요 :<%=board.getBoardLike() %></li><br>
	<span><button type="button" onclick="location.href='modifyPage.jsp'">수정</button>
	<button type="submit" name="postBoard" value="postDelete">삭제</button></span>
	</ul>
	</form>
	<br>
</body>
</html>