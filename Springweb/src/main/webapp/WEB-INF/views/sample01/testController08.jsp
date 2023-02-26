<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<H1>testController08.jsp 호출</H1>

	<!--데이터를 추출할 명시 -->
	<ul>
		<!-- 모델 객체를 직접 뒤질수 있음 myName으로만 명시 -->
		<!-- "test" 입력하면 해당 문자열이 찍힘 -->
		<li>문자열 출력 : ${"test"}</li>
		<li>문자열 출력 : ${'test'}</li>
		<li>숫자 출력 : ${3.1415}</li>
		<li>논리값 출력 : ${true}</li>
		<li>null 출력: ${null} </li> <!-- null은 출력이 안됨 -->
		<li>list출력 (myList[1]) : ${myList[1]}</li> <!-- 배열의 위치를 지정하여 사용. -->
		<li>javabean(VO): ${myUser.userName}</li> <!-- 래퍼런스 이름. 프러퍼티 이름 (모델에 접근할려고 할때) -->
		<li>Map: ${myName} </li> <!-- 홍길동 출력 -->
		
		<li> param객체를 써봄 (내장 객체): ${param.userName} </li> <!-- 사용자가 입력한 파라미터 값을 (reqest정보를 땡겨옴) 가져옴 -->
		<li> header객체를 써보아요 : ${header.referer}</li> <!-- 내 페이지의 이전 url의 값이 저장되어 있음 (뒤로가가ㅣ) -->
		
		<li>산술연산(+,-,*,/,%)할 수 있음. ${param.userAge + 20}</li>
		<li>논리연산 (&&,||,!)할 수 있음. ${!false}</li> 
		<li>비교연산 (==,!=, 비교연산자 사용가능) : ${param.userAge <20} </li> <!-- 사용자 입력값에 대한 true, false -->
		<li>삼항 연자 (논리 값 ? a : b) : ${param.userAge < 20 ? "미성년자" : "성인" } </li>
		<li>empty 연산 : ${empty ""}</li> <!-- 공백 문자인지? 맞으면 true 출력, -->
		<li>empty 연산 : ${empty "abd"}</li> 
		<li>empty 연산 : ${empty null}</li> <!-- null 값도 공백임 true  나중에 jstl 로직처리가 가능함. --> 
		<li>empty 연산 : ${empty myList} -(안에 2개 있음)</li> <!-- 이 자료구조 안의 요소가 0개 이상인지 물음 "요소 의 개수" -->
		
		
		<!--  -->
	</ul>
	<a href=" ${header.referer}">뒤로가기</a> <!-- 해당 페이지의 이전 페이지를 나타내게 함. -->

</body>
</html>