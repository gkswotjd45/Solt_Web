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
	<H1>step2 - 사용자 세부정보를 입력하세요.</H1>
	<!-- 아이디 주소 이름을 여기서 입력 이 다음페이지 는 특기, 취미, 등등 => 페이지별로 나눠서 입력 하겠다는 의미. -->
	<form action="/springWeb/memberRegisterStep3" method="post">
	취미 : <input type="text" name="memberHobby"><br><br>
	자기소개 : <input type="text" name="memberContent"><br><br>
	<input type="submit" value="저장"/>
	</form>
	<form action="/springWeb/memberRegisterStep1" method="post">
	<input type="submit" value="첫번째 페이지로 이동"/>
	</form>
</body>
</html>