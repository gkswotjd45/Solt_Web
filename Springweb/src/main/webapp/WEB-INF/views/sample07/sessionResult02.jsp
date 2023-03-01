<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>수행된 결과입니다.</h1>
<h2>RequestScope </h2>
<h3>requestScope.data1 : ${requestScope.data1} </h3> <!-- createString1 -->
<h3>requestScope.data2 : ${requestScope.data2} </h3> <!-- createString2 -->
<h3>requestScope.msg : ${param.msg }</h3> <!-- createString2 -->
<!-- 파라미터가 가지고 있는 메시지를 가져옴. msg -->
<h3>requestScope.studentVO : ${requestScope.studentVO} </h3>
<h3>requestScope.student: ${requestScope.student} </h3>
<h3>requestScope.newStudent: ${requestScope.newStudent} </h3>

<hr>

<h2>Session Scope </h2>
<h3>sessionScope.data1 : ${sessionScope.data1} </h3> <!-- createString1 -->
<h3>sessionScope.data2  : ${sessionScope.data2} </h3> <!-- createString2 -->
<h3>sessionScope.newStudent: ${sessionScope.newStudent} </h3>

<!-- data2에  직접 세션을 가지고 밀어넣은 형태 -->
<h3>sessionScope.shin.studentName: ${sessionScope.shin.studentName} </h3>
<h3>sessionScope.shin.studentDept: ${sessionScope.shin.studentDept} </h3>
</body>
</html>