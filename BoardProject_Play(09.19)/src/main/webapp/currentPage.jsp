<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="comment.vo.CommentList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="member.vo.Member, board.vo.Board,comment.vo.Comment, java.util.List, comment.vo.CommentList"%>

<%
//Comment comm = (Comment)request.getAttribute("comment");
Board board = (Board) request.getAttribute("board");
Member member = (Member) session.getAttribute("member");
List<CommentList> list = (List<CommentList>) session.getAttribute("CommentList");

String boardLike = board.getBoardLike();
String memberId = member.getMemberId();
int board_num = board.getBoardNum();
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
			<li>좋아요 :<%=boardLike%></li>
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
			
			
			<form id="likeform">	
			<input id="mId" type="hidden" name="memberId" value ="<%=memberId%>">
			<input id="bId" type="hidden" name="boardnum" value="<%=board_num%>"> <!-- 게시글 번호 전달 받음 -->
			<input id="btnLike" type="button" value="Good" onclick="return like()">
			<div id="like_result"></div>
			</form>
			<!-- <button type="submit" name="postBoard" value="PostLike">좋아요</button> -->
			<%
			}
			%>
		</ul>
	</form>
	<br>

	<table border="1">
		<thead>
			<tr>댓글</tr>
		</thead>
		<tbody>
			<tr>
				<td>작성자</td>
				<td>내용</td>
				<td>게시일</td>
			</tr>
			<%
			for (CommentList comm : list) {
			%>
			<form action="commentDelete" method="post">
			<tr>
				<td><%=comm.getMemberName()%></td>
				<td><%=comm.getCommentContent()%></td>
				<td><%=comm.getCommentDate()%></td>

				<%
				if (comm.getCommentId().equals(member.getMemberId())) {
					int commentindex = comm.getCommentNum();
				%>
				<td height="10">
					<button type="button" onclick="location.href='/board/commentModify?boardIndex=<%=board.getBoardNum()%>&Commentnum=<%=commentindex%>'">수정</button>
					<button type="submit" name="commentDelete" value=<%= commentindex %>>삭제</button>	
				</td>
			</tr>
			</form>
			<%
				}
			}
			%>
			<!-- 마지막 번호 및 , 현재 접속자 이름, 입력 값 작성  -->
			<tr>
				<form action="commentInput" method="post">
				<td height="50"><%=member.getMemberName()%></td>
				<td><textarea name="commentContent"cols="20" placeholder="댓글을 입력하세요."></textarea></td>
				<td></td>
				<td><button type="submit">입력</button></td>
				</form>
			</tr>

		</tbody>
	</table>
</body>
<script src="https://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>
<script>
function like(){

	  $.ajax({
		    url: "boardLikeServlet",
		    type: "POST",
		    cache: false,
		    dataType: "json",
		    data:{ mid: $("#mId").val(),
		    	   bid: $("#bId").val()
		    	},
 		      //아이디가 like_form인 곳의 모든 정보를 가져와  파라미터 전송 형태(표준 쿼리형태)로 만들어줌
		    success: 
		    	function(data){   
		    
		    	//console.log(data); // 콘솔창 확인
		    	var boardLike = '<%= boardLike %>'
		    	var values = Object.values(data); // 객체안의 data의 result : "" 값을 반환.
		    	if(values == 1){
		    		alert("좋아요 추가되었습니다.");
		    		$("#btnLike").prop('disabled', true);
		    	}else {
		    		alert("이미 반영되었습니다.");
		    		$("#btnLike").prop('disabled', true);
		    	}
                $("#like_result").html(data.like);  //id값이 like_result인 html을 찾아서 data.like값으로 바꿔준다.
		    },   
		    error: 
		    function (request, status, error){  
		      alert("ajax실패")                  
		    }
		  });
}
</script>
</html>