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
	<!-- 변수를 만들고 값을 할당할 수 있음. -->
	<%
		int k = 100;
	%>
	<!-- jstl을 이용해 변수 만듬 -->
	<c:set var="num1" value="100"></c:set>

	<!-- 제어문 중 대표적인 제어문.. if 
test 안에는 el값이 true or false 값을 확인해야 함.
test 뒤에는 논리값이 나와야 함.
// test 값이 true 이면 해당 태그나 나옴 false는 안나옴. => else 문이 없는 형태.
 -->
	<c:if test="${num1 + myNum > 100}">
입력된 100보다 큽니다.
</c:if>

	<!-- 일반적으로 조건이 여러개 인 경우 c:if 대신 다른걸 사용함 //조건에 맞는 거 선택   
:when 이 조건이 true일 때 출력 => 마치 else if 처럼 수행
c:when을  다 거쳤는데 otherwise에 걸림 (else)

만약 c:when 조건이 상위에서 만족한다면 나머지 c:when 및  otherwise는 수행하지 않음.
-->

	<c:choose>
		<c:when test="${num1 + myNum > 50}"> 50보다 커요</c:when>
		<c:when test="${num1 + myNum > 100}">100보다 커요</c:when>
		<c:when test="${num1 + myNum > 300}">300보다 커요</c:when>
		<c:otherwise>이도저도 아님.</c:otherwise>
	</c:choose>

	<br>
	<br>
	<!-- 반복문도 해봄 -->
	<!-- 기본적인 형태 반복횟수를 알려줘서 반복하는 경우 -->
	<ul>
		<c:forEach var="tmp" begin="1" end="5" step="1">
			<li>${tmp}</li>
		</c:forEach>
	</ul>

	<br>
	<br>
	<!-- 일반적으로 집합자료구조를 이용한 반복처리를 많이 함. 
	model.addAttribute("myList", list); // mylist로 모델안에 있는거 당겨서 사용
-->
	<ul>
		<c:forEach var="name" items="${myList}">
			<li>${name}</li>
		</c:forEach>
	</ul>


	<!-- fmt를 사용하기 위해서 변수를 하나 선언해봄. 내가 원하는 값을 원하는 형태로 표현하는 방식.-->
	<c:set var="number" value="123456789" />
	<br><br>
	<!-- 숫자표현할 때 3자리마다 콤마 표시하는 것. -->
	<fmt:formatNumber value="${number}">
	</fmt:formatNumber>
	<br><br>

	<!-- 화폐 단위 -->
	<fmt:formatNumber value="${number}" type="currency"></fmt:formatNumber>

	<!-- 백분율  -->
	<c:set var="number" value="0.783" />
	<br><br>
	<fmt:formatNumber value="${number}" type="percent">
	</fmt:formatNumber>
	<br><br>
</body>
</html>