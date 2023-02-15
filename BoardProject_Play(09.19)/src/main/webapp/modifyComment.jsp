<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="member.vo.Member, board.vo.Board,comment.vo.Comment, java.util.List, comment.vo.CommentList"%>
<%
Comment comment = (Comment)request.getAttribute("Comment");
Member member = (Member)session.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>댓글 수정</h2>
	<form action="commentModify" method="post">
		<table border="1">
			<thead>
				<tr>해당 댓글
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%=member.getMemberName()%></td>
					<td><textarea cols="50" rows="5" name="CommentContent"><%=comment.getCommentContent() %></textarea></td>
				</tr>
			</tbody>
		</table>
		<button type="submit">수정하기</button>
	</form>

</body>
</html>