<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- jsp 파일 내에서 html 파일을 내용은 싹 다 out.println("~~~~~~") ~안으로 다 들어감-->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 1. 입력 받고
		// 2. 로직처리하고
		// 여기에 mybatis 처리 코드가 여기에 나옴.
		// 3. 출력은 html에 "끼워 넣기"
		
		// db처리, 입력 처리. 여기안에서 다 해결하니 -> mvc 패턴이 등장하여 
		// 결국에는 jsp파일은 // 3. 출력은 html에 "끼워 넣기" 만 담당 => 결과 찍어주기.
		
	%>
	<% 
		String name = "홍길동"; //지역변수 = 메서드안의 변수를 선언했으므로.
	 for(int i =0; i<5 ; i++){
	%>	 
		<h1>반복되요.</h1>	 
	<%	 
	 }
	%> <!--  -->
	이것은 소리 없는 아우성!!
	사용자의 이름은 : <%= name %> 입니다. <!-- 자바 코드안의 변수를 안에 넣고 싶음. -->
	
	
	<!--	<!--%	 
	 }
	%>  -->
</body>
</html>