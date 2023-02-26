<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<H1>연산성공</H1>
	<!-- EL 검색 순서가 pageScope > requestScope > ssessionScope > applicationScope 
		pageScopes는 jsp 한페이지를 지칭. (이 페이지에서 만들어서 이 페이지 안에서만 생종)
	 -->
	 <% pageContext.setAttribute("msg", "소리없는 아우성!"); %>
	 <br>
	 <h3> request.getAttribute("msg") - 결과는 : <%= request.getAttribute("msg") %></h3>
	 <h3>$ {msg} - 결과는 :${msg}</h3>
	 <h3>$ {param.msg} - 결과는 :${param.msg}</h3>
	 <h3>$ {param.firstNum} - 결과는 :${param.firstNum}</h3>
	 <h3>$ {param.msg} - 결과는 :${param.msg}</h3>
	 <h3>$ {pageScope.msg} - 결과는 :${pageScope.msg}</h3>
	 <h3>$ {pageScope.myData} - 결과는 :${pageScope.myData}</h3>
	 <h3>$ {requestScope.msg} - 결과는 :${requestScope.msg}</h3>
	 <br><br>
	 <a href= "${header.referer}">뒤로가기</a>
</body>
</html>