<%@page import="java.io.Console"%>
<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="board.vo.boardList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="member.vo.Member, board.vo.Board, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- jsp에서는 나에게 할당된 session객체를 그냥 사용할 수 있어요. => jsp에서는 getSession()을 안써도 됨 그냥 사용이 가능
	어떤 이름을 사용해야 하나요 => "session"
	세션안에 이름이 있으므로 값을 가져오는데 object 형태를 형변환하여 수행.
 -->
	<h1><%=((Member) session.getAttribute("member")).getMemberName()%>님
		환영합니다.
	</h1>
	<h3 align="left"><a href="newPost.jsp" >새글쓰기</a></h3>
	<h3>게시글 목록</h3>
	<table border="2">
		<thead>
			<th>글번호</th>
			<th>글제목</th>
			<th>글내용</th>
			<th>글작성자</th>
			<th>게시일</th>
			<th>좋아요</th>
		</thead>
		<tbody>
		<% 
		// request에서 데이터를 붙여서 출력하는 것이 가장 주요.
		List<boardList> list = (List<boardList>)request.getAttribute("AllList");
		for(boardList board:list){
			
		%>
		<tr> <!-- 한 행  -->
			<td><%= board.getBoardNum() %></td>
			<td><% int index = board.getBoardNum();%>
			<a href="/board/current?page=<%=index %>"> <%= board.getBoardTitle() %></a></td>
			<td><%= board.getBoardContent() %></td>
			<td><%= board.getMemberName() %></td>
			<td><%= board.getBoardDate() %></td>
			<td><%= board.getBoardLike() %></td>
		</tr>
		<%
		
		}
		%>
		</tbody>
	</table>
</body>
</html>