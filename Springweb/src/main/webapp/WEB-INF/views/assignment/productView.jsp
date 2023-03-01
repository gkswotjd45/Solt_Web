<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<H1>장바구니</H1>
	<h2>선택된 정보 </h2>
	<h3>사과: ${sessionScope.Apple.productCount}</h3>
	<h3>바나나:${sessionScope.Banana.productCount } </h3>
	<h3>한라봉 : ${sessionScope.Halabong.productCount }  </h3>
	<a href="${header.referer}">뒤로가기</a>
</body>
</html>