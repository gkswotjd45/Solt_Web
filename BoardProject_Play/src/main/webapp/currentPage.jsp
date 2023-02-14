<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="member.vo.Member, board.vo.Board,comment.vo.Comment, java.util.List"%>

<%
//Comment comm = (Comment)request.getAttribute("comment");
Board board = (Board) request.getAttribute("board");
Member member = (Member) session.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="postDelete" method="post">
		<h3><%=board.getBoardNum()%>번 게시글 입니다.
		</h3>
		<ul>
			<li>작성자 ID: <%=board.getBoardAuthor()%>
			</li>
			<br>
			<li>제목: <%=board.getBoardTitle()%>
			</li>
			<br>
			<li>글 내용:<%=board.getBoardContent()%></li>
			<br>
			<li>게시일 :<%=board.getBoardDate()%></li>
			<br>
			<li>좋아요 :<%=board.getBoardLike()%></li>
			<br>
			<%
			if (member.getMemberId().equals(board.getBoardAuthor())) {
			%>
			<span><button type="button"
					onclick="location.href='modifyPage.jsp'">수정</button>
				<button type="submit" name="postBoard" value="postDelete">삭제</button></span>
			<%
			} else {
			%>
			<button type="submit" name="postBoard" value="PostLike">좋아요</button>
			<%
			}
			%>
		</ul>
	</form>
	<br>

	<table border="1">
		<thead>
			<tr>댓글
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>순번</td>
				<td>작성자</td>
				<td>내용</td>
				<td>게시일</td>
			</tr>
			<%
			List<Comment> list = (List<Comment>)session.getAttribute("Comment");
			for (Comment comm : list) {
			%>
			<tr>
				<td><%=comm.getCommentNum() %></td>
				<td><%=comm.getCommentId() %></td>
				<td><%= comm.getCommentContent() %></td>
				<td><%= comm.getCommentDate() %></td>

				<%
			if (comm.getCommentId().equals(member.getMemberId())) {
			%>
				<td>
					<button type="button" onclick="#">수정</button>
					<button type="button" onclick="#">삭제</button>
				</td>
				<%
			}
				%>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>