<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.vo.Member" %>
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
<h1><%= ((Member)session.getAttribute("member")).getMemberName() %>님 환영합니다.</h1>

</body>
</html>