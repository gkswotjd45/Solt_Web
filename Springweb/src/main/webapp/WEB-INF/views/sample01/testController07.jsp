<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<H1>testController07.jsp 호출</H1>
	<h1>model 안에 저장되어있는 데이터를 들고와서 여기서 출력해야 함.</h1>
	<!-- html 주석 --> <%-- jsp 주석 --%>
	<h3>EL을 이용해서 데이터를 추출해야 함. => EL 특수한 표시법.</h3>
	<!--데이터를 추출할 명시 -->
	<ul>
		<!-- 모델 객체를 직접 뒤질수 있음 myName으로만 명시 -->
		
		<li>이름 :<%-- ${myName} _ jsp 주석 표현 방식--%> ${myName}</li>
		<li>나이 : ${myAge}</li>
	</ul>

</body>
</html>