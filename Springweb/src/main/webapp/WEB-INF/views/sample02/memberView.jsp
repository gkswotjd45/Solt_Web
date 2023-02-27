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
	<h1>회원정보입니다.</h1>
	<!-- 3번째 form문 수행. -->
	<c:choose>
		<c:when test="${ !empty requestScope.mem}">
			<ul>
				<li>이름 : ${mem.name}</li>
				<li>전화 : ${mem.phone}</li>
				<li>전화 : ${mem.id}</li>
				<li>전화 : ${mem.password}</li>
			</ul>
		</c:when>
		<c:when test="${ !empty requestScope.memberVO }">
			<ul>
				<li>이름 : ${memberVO.name}</li>
				<li>전화 : ${memberVO.phone}</li>
				<li>전화 : ${memberVO.id}</li>
				<li>전화 : ${memberVO.password}</li>
			</ul>
		</c:when>
		<c:otherwise>
			<!-- 1번째 form문 수행. -->
			<ul>
				<li>이름 : ${name}</li>
				<li>전화 : ${phone}</li>
				<li>전화 : ${id}</li>
				<li>전화 : ${password}</li>
			</ul>
		</c:otherwise>
	</c:choose>

	<Br>
	<br>
	<a href="${header.referer}">뒤로가기!</a>

</body>
</html>